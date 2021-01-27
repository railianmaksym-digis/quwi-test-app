package com.digis.quwi.test.app.main;

import android.content.Intent;
import android.os.Bundle;

import com.digis.quwi.test.R;
import com.digis.quwi.test.app.auth.AuthActivity;
import com.digis.quwi.test.app.base.BaseActivity;
import com.digis.quwi.test.app.di.ToothpickUtils;
import com.digis.quwi.test.app.projects.ProjectListActivity;
import com.digis.quwi.test.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainViewModel getViewModel() {
        return ToothpickUtils.provideViewModel(this, MainViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.openAuthScreenAction.observe(this, aVoid -> {
            startActivity(new Intent(MainActivity.this, AuthActivity.class));
            finish();
        });
        viewModel.openProjectsListScreenAction.observe(this, aVoid -> {
            startActivity(new Intent(MainActivity.this, ProjectListActivity.class));
            finish();
        });
    }
}