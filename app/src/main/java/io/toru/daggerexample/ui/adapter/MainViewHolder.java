package io.toru.daggerexample.ui.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.toru.daggerexample.R;
import io.toru.daggerexample.pattern.model.PhotoThumbnailItem;
import io.toru.daggerexample.ui.DetailActivity;

/**
 * Created by toru on 2016. 10. 3..
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = MainViewHolder.class.getSimpleName();

    @BindView(R.id.main_cardview)
    CardView cardView;

    @BindView(R.id.thumbnail_image)
    ImageView thumbnailImage;

    @BindView(R.id.thumbnail_text)
    TextView thumbnailTitleText;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateView(Object model) {
        final PhotoThumbnailItem item = (PhotoThumbnailItem)model;
        thumbnailTitleText.setText(item.title);
        Picasso.with(thumbnailImage.getContext())
                .load(item.url_t)
                .fit()
                .into(thumbnailImage);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), DetailActivity.class).putExtra("url", item.url_t));
            }
        });
    }
}