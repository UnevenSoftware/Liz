package org.horaapps.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.horaapps.liz.ThemedAdapter;
import org.horaapps.liz.ThemedViewHolder;

import java.util.ArrayList;

public class SampleAdapter extends ThemedAdapter<SampleAdapter.ViewHolder> {
    private ArrayList<Integer> numOfCardViews = new ArrayList<>();

    public SampleAdapter(Context context) {
        super(context);

        /* creating only one CardView currently */
        this.numOfCardViews.add(0);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.themed_layout_1, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return numOfCardViews.size();
    }

    static class ViewHolder extends ThemedViewHolder {

        ViewHolder(View view) {
            super(view);
        }
    }
}
