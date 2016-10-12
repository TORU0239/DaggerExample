package io.toru.daggerexample.pattern.view;

import io.toru.daggerexample.pattern.model.PhotoThumbnailList;

/**
 * Created by toru on 2016. 9. 19..
 */
public interface MainView {
    void onInitView(PhotoThumbnailList list);
    void onInitView();
}