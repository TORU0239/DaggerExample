package io.toru.daggerexample.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.toru.daggerexample.R;
import io.toru.daggerexample.base.activity.BaseActivity;
import io.toru.daggerexample.model.QuestionModel;
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
    private List<QuestionModel> questionModelList;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initModel() {
        mainPresenter = new MainPresenterImp(this);
        questionModelList = new ArrayList<>();
        adapter = new MainRecyclerAdapter(questionModelList);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onInitView() {
        Log.w(TAG, "onInitView: ");
        mainText.setText("18");

        QuestionModel model = new QuestionModel();
        model.question = "Test";
        questionModelList.add(model);

        model = new QuestionModel();
        model.question = "Test2";
        questionModelList.add(model);

        model = new QuestionModel();
        model.question = "Test3";
        questionModelList.add(model);

        model = new QuestionModel();
        model.question = "Test4";
        questionModelList.add(model);

        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.main_button)
    public void onMainButtonClick(){
        mainPresenter.onInitAction();
    }
}