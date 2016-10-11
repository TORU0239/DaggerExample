package io.toru.daggerexample.app;

import android.app.Application;

import io.toru.daggerexample.di.component.DaggerMainComponent;
import io.toru.daggerexample.di.component.MainComponent;
import io.toru.daggerexample.di.module.MainModule;
import io.toru.daggerexample.di.module.SecondMainModule;


/**
 * Created by toru on 2016. 9. 15..
 */
public class MyApplication extends Application {
    private static MyApplication application;

    public static final String API_KEY = "4d31be9c8349b2240703d3c35504aa39";
    public static String BASE_URL = "https://api.flickr.com/services/rest/";

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mainComponent = DaggerMainComponent.builder()
                                            .mainModule(new MainModule(this))
                                            .secondMainModule(new SecondMainModule(this))
                                            .build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }

    public static MyApplication getApplication(){
        return application;
    }
}