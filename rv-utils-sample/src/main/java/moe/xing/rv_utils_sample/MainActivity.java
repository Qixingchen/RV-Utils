package moe.xing.rv_utils_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import moe.xing.rvutils.StatusRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        StatusRecyclerViewAdapter<String> adapter
                = new StatusRecyclerViewAdapter<>(new StringAdapter(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.view_empty_in_app, recyclerView, false));
        recyclerView.setAdapter(adapter);
        List<String> list = new ArrayList<>();
        adapter.setList(list);
        adapter.addData("1");
        adapter.addData("2");
        adapter.addData("3");
        adapter.addData("4");
        adapter.addData("5");
        adapter.addData("6");
        adapter.addData("7");
        List<String> addList = new ArrayList<>();
        addList.add("10");
        addList.add("11");
        addList.add("12");
        addList.add("13");
        addList.add("14");
        addList.add("15");
        addList.add("16");
        addList.add("17");
        adapter.addData(addList);

        List<String> addList2 = new ArrayList<>();
        addList2.add("10");
        addList2.add("11");
        addList2.add("12");
        addList2.add("13");
        addList2.add("14");
        addList2.add("15");
        addList2.add("16");
        addList2.add("17");
        addList2.add("20");
        addList2.add("21");
        addList2.add("22");
        addList2.add("23");
        addList2.add("24");
        addList2.add("25");
        addList2.add("26");
        addList2.add("27");
        addList2.add("28");
        addList2.add("29");
        addList2.add("30");

        Button reset = findViewById(R.id.reset2_btn);
        reset.setOnClickListener(view -> {
            adapter.setList(addList2);
        });

        findViewById(R.id.reset1_btn).setOnClickListener(view -> adapter.setList(addList));
    }
}
