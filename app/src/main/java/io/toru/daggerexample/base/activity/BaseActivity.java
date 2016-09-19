package io.toru.daggerexample.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by toru on 2016. 9. 19..
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    public abstract int getLayoutID();
    public abstract void initModel();

    protected void initialize(){
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        initModel();
    }
}