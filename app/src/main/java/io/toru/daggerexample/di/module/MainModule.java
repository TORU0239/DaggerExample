package io.toru.daggerexample.di.module;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerexample.app.MyApplication;
import io.toru.daggerexample.network.FlickrFetchApi;
import io.toru.daggerexample.network.NetworkApi;
import io.toru.daggerexample.pattern.model.PhotoList;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by toru on 2016. 9. 19..
 */

@Module
public class MainModule {
    private static final String TAG = MainModule.class.getSimpleName();
    private Context ctx;

    public MainModule(Context ctx) {
        this.ctx = ctx;
    }

    @Provides
    @Singleton
    public FlickrFetchApi getFlickFetchApi(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                        .addInterceptor(new Interceptor() {
                                            @Override
                                            public Response intercept(Chain chain) throws IOException {
                                                return chain.proceed(chain.request());
                                            }
                                        })
                                        .build();

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(MyApplication.baseUrl)
                                .client(okHttpClient)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        return retrofit.create(FlickrFetchApi.class);
    }
}