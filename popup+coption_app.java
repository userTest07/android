XML File:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- Button to Show Popup Dialog -->
    <Button
        android:id="@+id/showPopupButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show Popup Dialog" />

    <!-- Button to Show Options Menu (you click the overflow menu for this) -->
    <Button
        android:id="@+id/showOptionsMenuButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show Options Menu"
        android:layout_marginTop="20dp" />

    <!-- TextView for Context Menu -->
    <TextView
        android:id="@+id/contextMenuText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Long press me for context menu"
        android:layout_marginTop="20dp"
        android:padding="10dp"
        android:background="#e0e0e0" />
</LinearLayout>
Java File:
package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to show Popup Dialog
        Button showPopupButton = findViewById(R.id.showPopupButton);
        showPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Popup Dialog
                showPopupDialog();
            }
        });

        // Button to show Options Menu (display overflow)
        Button showOptionsMenuButton = findViewById(R.id.showOptionsMenuButton);
        showOptionsMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Options Menu
                showOptionsMenu(v);
            }
        });

        // TextView for Context Menu
        TextView contextMenuText = findViewById(R.id.contextMenuText);
        contextMenuText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Show Context Menu
                registerForContextMenu(v);
                openContextMenu(v);
                return true;
            }
        });
    }

    // Popup Dialog Method
    private void showPopupDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Popup Dialog")
                .setMessage("This is a simple popup dialog.")
                .setPositiveButton("OK", null)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    // Options Menu (Overflow Menu)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main.xml
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_help:
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Method to show the options menu when the button is clicked
    private void showOptionsMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
        popupMenu.show();
    }

    // Context Menu for long click on TextView
    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "Option 1");
        menu.add(0, v.getId(), 0, "Option 2");
        menu.add(0, v.getId(), 0, "Option 3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if ("Option 1".equals(item.getTitle())) {
            Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();
        } else if ("Option 2".equals(item.getTitle())) {
            Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show();
        } else if ("Option 3".equals(item.getTitle())) {
            Toast.makeText(this, "Option 3 selected", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
Menu.XML File:
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/action_settings"
        android:title="Settings"
        android:icon="@android:drawable/ic_menu_preferences"
        app:showAsAction="ifRoom" />

    <!-- Help Menu Item -->
    <item
        android:id="@+id/action_help"
        android:title="Help"
        android:icon="@android:drawable/ic_menu_help"
        app:showAsAction="ifRoom" />
</menu>
