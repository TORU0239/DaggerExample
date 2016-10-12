package io.toru.daggerexample.pattern.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.toru.daggerexample.app.MyApplication;
import io.toru.daggerexample.network.FlickrFetchApi;
import io.toru.daggerexample.pattern.model.PhotoThumbnailJsonItem;
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
        Call<PhotoThumbnailJsonItem> call = api.loadRecentImage();
        call.enqueue(new Callback<PhotoThumbnailJsonItem>() {
            @Override
            public void onResponse(Call<PhotoThumbnailJsonItem> call, retrofit2.Response<PhotoThumbnailJsonItem> response) {
                Log.w(TAG, "onResponse: code :: " + response.code());
                if(response.code() == 200){
                    PhotoThumbnailJsonItem list = response.body();
                    Log.w(TAG, "onResponse: list size :: " + list.photos.photo.size());
                    mainView.onInitView(list.photos);
                }
                else{
                    // handling exception
                    mainView.onInitView();
                }
            }

            @Override
            public void onFailure(Call<PhotoThumbnailJsonItem> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}