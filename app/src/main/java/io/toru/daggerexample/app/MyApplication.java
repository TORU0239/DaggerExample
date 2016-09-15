package io.toru.daggerexample.app;

import android.app.Application;

import io.toru.daggerexample.component.DaggerDiComponent;
import io.toru.daggerexample.component.DiComponent;

/**
 * Created by toru on 2016. 9. 15..
 */
public class MyApplication extends Application {
    private DiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDiComponent.builder().build();
    }

    public DiComponent getComponent() {
        return component;
    }
}