package io.toru.daggerexample.di.module;

import android.content.Context;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerexample.network.NetworkApi;
import io.toru.daggerexample.network.TestApi;

/**
 * Created by toru on 2016. 9. 19..
 */

@Module
public class SecondMainModule {
    private static final String TAG = SecondMainModule.class.getSimpleName();
    private Context ctx;

    public SecondMainModule(Context ctx) {
        this.ctx = ctx;
    }

    @Provides
    @Singleton
    public TestApi getTestApi(){
        return new TestApi();
    }
}