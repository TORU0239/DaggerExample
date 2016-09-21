package io.toru.daggerexample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import io.toru.daggerexample.di.module.MainModule;
import io.toru.daggerexample.di.module.SecondMainModule;
import io.toru.daggerexample.pattern.presenter.MainPresenterImp;

/**
 * Created by toru on 2016. 9. 19..
 */
@Singleton
@Component(modules = {MainModule.class, SecondMainModule.class})
public interface MainComponent {
    void inject(MainPresenterImp imp);
}