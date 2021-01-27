package com.digis.quwi.test.app.main;

import android.app.Application;

import androidx.annotation.NonNull;

import com.digis.quwi.test.app.base.BaseViewModel;
import com.digis.quwi.test.app.utils.SingleLiveEvent;
import com.digis.quwi.test.data.auth.AuthRepository;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(@NonNull Application application, AuthRepository authRepo) {
        super(application);
        if (!authRepo.isAuthorized()) {
            openAuthScreenAction.call();
        } else {
            openProjectsListScreenAction.call();
        }
    }

    public SingleLiveEvent<Void> openAuthScreenAction = new SingleLiveEvent<>();
    public SingleLiveEvent<Void> openProjectsListScreenAction = new SingleLiveEvent<>();
}
