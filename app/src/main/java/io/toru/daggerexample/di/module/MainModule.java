package io.toru.daggerexample.di.module;

import android.content.Context;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerexample.network.NetworkApi;

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
    public NetworkApi getNetworkApi(){
        Log.w(TAG, "test mainModule");
        return new NetworkApi();
    }
}