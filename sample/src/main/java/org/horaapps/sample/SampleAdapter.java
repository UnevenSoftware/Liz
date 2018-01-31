package org.horaapps.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.horaapps.liz.ThemedAdapter;

import java.util.ArrayList;

public class SampleAdapter extends ThemedAdapter {
    private ArrayList<Integer> numOfCardViews = new ArrayList<>();

    public SampleAdapter(Context context) {
        super(context);

        /* creating only one CardView currently */
        this.numOfCardViews.add(1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.themed_layout_1, parent, false);
        return new ThemedHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numOfCardViews.size();
    }

    public static class ThemedHolder extends RecyclerView.ViewHolder {

        public ThemedHolder(View view) {
            super(view);
        }
    }
}
