package com.digis.quwi.test.app.utils;

import com.digis.quwi.test.data.auth.AuthCache;
import com.digis.quwi.test.data.auth.AuthData;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    private final AuthCache authCache;

    @Inject
    public AuthInterceptor(AuthCache authCache) {
        this.authCache = authCache;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        AuthData cachedAuthData = authCache.getEntity();
        if (cachedAuthData == null) {
            return chain.proceed(chain.request());
        }

        return chain.proceed(
                chain.request().newBuilder()
                .addHeader(AUTHORIZATION_HEADER, TOKEN_PREFIX + cachedAuthData.getToken())
                .build()
        );
    }
}
