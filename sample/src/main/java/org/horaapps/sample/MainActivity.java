package org.horaapps.sample;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.horaapps.liz.ThemedActivity;

public class MainActivity extends ThemedActivity {

    private RecyclerView recyclerViewSample;
    private SampleAdapter sampleAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setupView();
    }

    private void init() {
        recyclerViewSample = findViewById(R.id.recyclerView_sample);
        sampleAdapter = new SampleAdapter(this);
    }

    private void setupView() {
        recyclerViewSample.setAdapter(sampleAdapter);
    }

}
