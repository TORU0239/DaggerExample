package io.toru.daggerexample.pattern.view;

import io.toru.daggerexample.pattern.model.PhotoList;

/**
 * Created by toru on 2016. 9. 19..
 */
public interface MainView {
    void onInitView(PhotoList list);
    void onInitView();
}