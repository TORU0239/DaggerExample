package io.toru.daggerexample.di.component;

import dagger.Component;
import io.toru.daggerexample.di.module.MainModule;
import io.toru.daggerexample.pattern.presenter.MainPresenterImp;
import io.toru.daggerexample.ui.MainActivity;

/**
 * Created by toru on 2016. 9. 19..
 */
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
    void inject(MainPresenterImp imp);
}
