package io.toru.daggerexample.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.toru.daggerexample.R;
import io.toru.daggerexample.base.activity.BaseActivity;
import io.toru.daggerexample.pattern.model.PhotoThumbnailItem;
import io.toru.daggerexample.pattern.model.PhotoThumbnailList;
import io.toru.daggerexample.pattern.presenter.MainPresenter;
import io.toru.daggerexample.pattern.presenter.MainPresenterImp;
import io.toru.daggerexample.pattern.view.MainView;
import io.toru.daggerexample.ui.adapter.MainRecyclerAdapter;


public class MainActivity extends BaseActivity implements MainView{
    private static final String TAG = MainActivity.class.getSimpleName();

    private MainPresenter mainPresenter;

    @BindView(R.id.main_text)
    TextView mainText;

    @BindView(R.id.main_recyclerView)
    RecyclerView mainRecyclerView;

    private MainRecyclerAdapter adapter;

    private List<PhotoThumbnailItem> itemList;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initModel() {
        mainPresenter = new MainPresenterImp(this);
        itemList = new ArrayList<>();
        adapter = new MainRecyclerAdapter(itemList);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.main_button)
    public void onMainButtonClick(){
        mainPresenter.onInitAction();
    }

    @Override
    public void onInitView(PhotoThumbnailList list) {
        mainText.setText("18");
        itemList.addAll(list.photo);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onInitView() {

    }
}