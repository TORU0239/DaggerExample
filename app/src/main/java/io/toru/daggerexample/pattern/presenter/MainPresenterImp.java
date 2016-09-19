package io.toru.daggerexample.pattern.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.toru.daggerexample.di.component.DaggerMainComponent;
import io.toru.daggerexample.network.NetworkApi;
import io.toru.daggerexample.pattern.view.MainView;

/**
 * Created by toru on 2016. 9. 19..
 */
public class MainPresenterImp implements MainPresenter {
    private static final String TAG = MainPresenterImp.class.getSimpleName();
    private MainView mainView;

    @Inject
    NetworkApi api;

    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
        DaggerMainComponent.builder().build().inject(this);
    }

    @Override
    public void onInitAction() {
        Log.w(TAG, "onInitAction: ");
        api.networkTest();
        mainView.onInitView();
    }
}
