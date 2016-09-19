package io.toru.daggerexample.di.module;

import android.util.Log;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerexample.network.NetworkApi;

/**
 * Created by toru on 2016. 9. 19..
 */

@Module
public class MainModule {
    private static final String TAG = MainModule.class.getSimpleName();

    @Provides
    public NetworkApi getNetworkApi(){
        Log.w(TAG, "test mainModule");
        return new NetworkApi();
    }
}