package io.toru.daggerexample.component;

import javax.inject.Singleton;
import dagger.Component;
import io.toru.daggerexample.UI.MainActivity;
import io.toru.daggerexample.module.NetworkApiModule;

/**
 * Created by toru on 2016. 9. 15..
 */

@Singleton
@Component(modules = {NetworkApiModule.class})
public interface DiComponent {
    void inject(MainActivity activity);
}
