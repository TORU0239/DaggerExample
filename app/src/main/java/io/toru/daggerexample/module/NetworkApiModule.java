package io.toru.daggerexample.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.toru.daggerexample.network.NetworkApi;

/**
 * Created by toru on 2016. 9. 15..
 */

@Module
public class NetworkApiModule {
    @Provides
    @Singleton
    public NetworkApi getNetwork(){
        return new NetworkApi();
    }
}
