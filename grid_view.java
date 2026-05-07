XML File:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <GridView
        android:id="@+id/gridView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:numColumns="3"
        android:horizontalSpacing="10dp"
        android:verticalSpacing="10dp"
        android:padding="10dp"
        android:columnWidth="80dp"
        android:stretchMode="columnWidth"
        android:gravity="center" />
</LinearLayout>
JAVA FILE:
package com.example.myapplication4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find GridView by ID
        GridView gridView = findViewById(R.id.gridView);

        // Sample data for the grid
        String[] gridItems = {
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6",
                "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12"
        };

        // Create an adapter and set it to the GridView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gridItems);
        gridView.setAdapter(adapter);
    }
}
