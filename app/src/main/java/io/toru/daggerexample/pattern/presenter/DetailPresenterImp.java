package io.toru.daggerexample.pattern.presenter;

import io.toru.daggerexample.pattern.view.DetailView;

/**
 * Created by toru on 2016. 10. 12..
 */

public class DetailPresenterImp implements DetailPresenter {
    private static final String TAG = DetailPresenterImp.class.getSimpleName();

    private DetailView detailView;

    public DetailPresenterImp(DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void onDisplayImage() {
        detailView.displayDetailImage("");
    }
}
