package io.toru.daggerexample.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.toru.daggerexample.R;
import io.toru.daggerexample.pattern.model.PhotoThumbnailItem;

/**
 * Created by toru on 2016. 10. 3..
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private static final String TAG = MainRecyclerAdapter.class.getSimpleName();

    private List<PhotoThumbnailItem> listModel;

    public MainRecyclerAdapter(List<PhotoThumbnailItem> listModel) {
        this.listModel = listModel;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.updateView(listModel.get(position));
    }

    @Override
    public int getItemCount() {
        if (listModel == null) {
            return 0;
        } else {
            return listModel.size();
        }
    }
}
