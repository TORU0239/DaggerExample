package io.toru.daggerexample.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.daggerexample.R;

/**
 * Created by toru on 2016. 10. 3..
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.adapter_text)
    TextView mainTextView;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateView(Object model) {
//        QuestionModel eachModel = (QuestionModel)model;
//        mainTextView.setText(eachModel.question);
    }
}