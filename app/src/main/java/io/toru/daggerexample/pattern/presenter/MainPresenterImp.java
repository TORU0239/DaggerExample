package io.toru.daggerexample.pattern.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.toru.daggerexample.app.MyApplication;
import io.toru.daggerexample.network.FlickrFetchApi;
import io.toru.daggerexample.pattern.model.PhotoJsonItem;
import io.toru.daggerexample.pattern.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by toru on 2016. 9. 19..
 */
public class MainPresenterImp implements MainPresenter {
    private static final String TAG = MainPresenterImp.class.getSimpleName();
    private MainView mainView;

    @Inject
    FlickrFetchApi api;

    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
        MyApplication.getApplication().getMainComponent().inject(this);
    }

    @Override
    public void onInitAction() {
        Log.w(TAG, "onInitAction: ");
        Call<PhotoJsonItem> call = api.loadRecentImage();
        Log.w(TAG, "onInitAction: url : " + call.request().url().toString());

        call.enqueue(new Callback<PhotoJsonItem>() {
            @Override
            public void onResponse(Call<PhotoJsonItem> call, retrofit2.Response<PhotoJsonItem> response) {
                Log.w(TAG, "onResponse: code :: " + response.code());
                if(response.code() == 200){
                    PhotoJsonItem list = response.body();
                    Log.w(TAG, "onResponse: list size :: " + list.photos.photo.size());
                }
                else{
                    // handling exception
                }
            }

            @Override
            public void onFailure(Call<PhotoJsonItem> call, Throwable t) {
                t.printStackTrace();
            }
        });

        mainView.onInitView();
    }
}