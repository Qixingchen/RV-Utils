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
        addList.add("20");
        addList.add("21");
        addList.add("22");
        addList.add("23");
        addList.add("24");
        addList.add("25");
        addList.add("26");
        addList.add("27");
        adapter.addData(addList);
    }
}
