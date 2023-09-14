package com.intercambiophoto.aplicacionandroi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class inicioactivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    private static ArrayList<Integer> removedItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();
        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter); // Debes establecer el adaptador en el RecyclerView
    }

    private void removeItem(View v) {
        int selectedItemPosition = recyclerView.getChildPosition(v);
        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForPosition(selectedItemPosition);
        TextView textViewName = viewHolder.itemView.findViewById(R.id.txtPhotocards);
        String selectedName = (String) textViewName.getText();
        int selectedItemId = -1;
        for (int i = 0; i < MyData.nameArray.length; i++) {
            if (selectedName.equals(MyData.nameArray[i])) {
                selectedItemId = MyData.id_[i];
            }
        }
        removedItems.add(selectedItemId);
        data.remove(selectedItemPosition);
        adapter.notifyItemRemoved(selectedItemPosition);
    }

    private void addRemovedItemToList() {
        if (!removedItems.isEmpty()) {
            int addItemAtListPosition = 3;
            data.add(addItemAtListPosition, new DataModel(
                    MyData.nameArray[removedItems.get(0)],
                    MyData.versionArray[removedItems.get(0)],
                    MyData.id_[removedItems.get(0)],
                    MyData.drawableArray[removedItems.get(0)]
            ));
            adapter.notifyItemInserted(addItemAtListPosition);
            removedItems.remove(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}

