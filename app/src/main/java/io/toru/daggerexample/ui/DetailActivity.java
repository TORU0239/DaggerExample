package io.toru.daggerexample.ui;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import io.toru.daggerexample.R;
import io.toru.daggerexample.base.activity.BaseActivity;
import io.toru.daggerexample.pattern.presenter.DetailPresenter;
import io.toru.daggerexample.pattern.presenter.DetailPresenterImp;
import io.toru.daggerexample.pattern.view.DetailView;

public class DetailActivity extends BaseActivity{
    private static final String TAG = DetailActivity.class.getSimpleName();

    @BindView(R.id.detail_image)
    ImageView detailImage;

    @Override
    public int getLayoutID() {
        return R.layout.activity_detail;
    }

    @Override
    public void initModel() {
        initToolbar();
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        url = url.substring(0, url.length()-6).concat(".jpg");
        Log.w(TAG, "initModel: " + url);
        Picasso.with(this).load(url)
                .fit()
                .into(detailImage);
    }

    private void initToolbar(){
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
