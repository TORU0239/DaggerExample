package io.toru.daggerexample.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.daggerexample.R;
import io.toru.daggerexample.pattern.model.PhotoItem;

/**
 * Created by toru on 2016. 10. 3..
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.thumbnail_image)
    ImageView thumbnailImage;


    @BindView(R.id.thumbnail_text)
    TextView thumbnailTitleText;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateView(Object model) {
        PhotoItem item = (PhotoItem)model;
        thumbnailTitleText.setText(item.title);

        StringBuilder urlBuilder = new StringBuilder("https://farm");
        urlBuilder.append(item.farm)
                .append(".staticflickr.com/")
                .append(item.server)
                .append("/")
                .append(item.id)
                .append("_")
                .append(item.secret)
                .append("_t.jpg");

        Picasso.with(thumbnailImage.getContext())
                .load(urlBuilder.toString())
                .fit()
                .into(thumbnailImage);
    }
}