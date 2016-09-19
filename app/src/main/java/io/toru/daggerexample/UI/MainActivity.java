package io.toru.daggerexample.ui;

import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.toru.daggerexample.R;
import io.toru.daggerexample.base.activity.BaseActivity;
import io.toru.daggerexample.pattern.presenter.MainPresenter;
import io.toru.daggerexample.pattern.presenter.MainPresenterImp;
import io.toru.daggerexample.pattern.view.MainView;


public class MainActivity extends BaseActivity implements MainView{
    private static final String TAG = MainActivity.class.getSimpleName();

    private MainPresenter mainPresenter;

    @BindView(R.id.main_text)
    TextView mainText;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initModel() {
        mainPresenter = new MainPresenterImp(this);
    }

    @Override
    public void onInitView() {
        Log.w(TAG, "onInitView: ");
        mainText.setText("18");
    }

    @OnClick(R.id.main_button)
    public void onMainButtonClick(){
        mainPresenter.onInitAction();
    }
}