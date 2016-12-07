package moe.xing.rv_utils_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import moe.xing.rvutils.StatusRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StatusRecyclerViewAdapter<String> adapter
                = new StatusRecyclerViewAdapter<>(new StringAdapter(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.view_empty_in_app, recyclerView, false));
        recyclerView.setAdapter(adapter);
        List<String> list = new ArrayList<>();
        adapter.setList(list);
    }
}
