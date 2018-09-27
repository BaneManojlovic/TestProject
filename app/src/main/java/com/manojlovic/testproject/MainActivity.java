package com.manojlovic.testproject;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.manojlovic.testproject.R.layout.popup_window;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private final ArrayList<Item> arrayList = new ArrayList<>();
    private Dialog myDialog;
    private TextView textClose;
    public int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList.add(new Item(R.drawable.picture01, "Petar Petrovic", "Golman"));
        arrayList.add(new Item(R.drawable.picture01, "Marko Markovic", "Odbrana"));
        arrayList.add(new Item(R.drawable.picture01, "Ivan Ivanovic", "Odbrana"));
        arrayList.add(new Item(R.drawable.picture01, "Marko Petrovic", "Odbrana"));
        arrayList.add(new Item(R.drawable.picture01, "Petar Ivanovic", "Vezni"));
        arrayList.add(new Item(R.drawable.picture01, "Ivan Petrovic", "Vezni"));
        arrayList.add(new Item(R.drawable.picture01, "Petar Markovic", "Vezni"));
        arrayList.add(new Item(R.drawable.picture01, "Stefan Stefanovic", "Vezni"));
        arrayList.add(new Item(R.drawable.picture01, "Toma Tomic", "Napad"));
        arrayList.add(new Item(R.drawable.picture01, "Petar Tomic", "Napad"));

        mRecycleView = findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Adapter(arrayList);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);

        //openst toast msg, later pop up window
        mAdapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String a = arrayList.get(position).getmText1();
                Toast.makeText(MainActivity.this, a, Toast.LENGTH_LONG).show();

            }
        });
    }

    //method for opening of popup window
    public void showPopUp(View view) {
        TextView textClose;
        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.popup_window);
        textClose = (TextView) myDialog.findViewById(R.id.btn_close);
        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
}
