package com.digis.quwi.test.domain.auth;

import com.digis.quwi.test.data.auth.AuthRepository;
import com.digis.quwi.test.domain.UseCase;
import com.digis.quwi.test.domain.states.State;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LoginUseCase extends UseCase<LoginParams> {

    private final AuthRepository authRepository;

    @Inject
    public LoginUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    protected Observable<State> createObservable(LoginParams params) {
        return authRepository.login(params);
    }
}
