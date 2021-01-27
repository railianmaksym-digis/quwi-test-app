package com.digis.quwi.test.app.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.digis.quwi.test.BuildConfig;
import com.digis.quwi.test.app.di.providers.AuthApiProvider;
import com.digis.quwi.test.app.di.providers.GsonProvider;
import com.digis.quwi.test.app.di.providers.OkHttpProvider;
import com.digis.quwi.test.app.di.providers.ProjectsApiProvider;
import com.digis.quwi.test.app.di.providers.RetrofitProvider;
import com.digis.quwi.test.data.auth.AuthApi;
import com.digis.quwi.test.data.auth.AuthCache;
import com.digis.quwi.test.data.auth.AuthRepository;
import com.digis.quwi.test.data.projects.ProjectsApi;
import com.digis.quwi.test.data.projects.ProjectsRepository;
import com.digis.quwi.test.domain.auth.LoginUseCase;
import com.digis.quwi.test.domain.projects.GetProjectsUseCase;
import com.digis.quwi.test.domain.projects.UpdateProjectParams;
import com.digis.quwi.test.domain.projects.UpdateProjectUseCase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import toothpick.config.Module;

public class AppModule extends Module {

    public AppModule(Application application) {
        bind(Application.class).toInstance(application);
        bind(Context.class).toInstance(application);

        String sharedPrefsKey = BuildConfig.APPLICATION_ID + ".sharedpreferences";
        bind(SharedPreferences.class).toInstance(application.getSharedPreferences(sharedPrefsKey, Context.MODE_PRIVATE));
        bind(Gson.class).toProvider(GsonProvider.class);

        bind(AuthCache.class).to(AuthCache.class);

        bind(OkHttpClient.class).toProvider(OkHttpProvider.class);
        bind(Retrofit.class).toProvider(RetrofitProvider.class);
        bind(AuthApi.class).toProvider(AuthApiProvider.class);
        bind(ProjectsApi.class).toProvider(ProjectsApiProvider.class);

        bind(AuthRepository.class).to(AuthRepository.class).singleton();
        bind(LoginUseCase.class).to(LoginUseCase.class);

        bind(ProjectsRepository.class).to(ProjectsRepository.class).singleton();
        bind(GetProjectsUseCase.class).to(GetProjectsUseCase.class);
        bind(UpdateProjectUseCase.class).to(UpdateProjectUseCase.class);
    }
}
