MainXML:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/dataEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter text to share"
        android:inputType="text" />

    <Button
        android:id="@+id/shareButton"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Share Data" />

    <TextView
        android:id="@+id/statusTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="No data shared yet"
        android:paddingTop="16dp" />
</LinearLayout>
Second XML:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/receivedTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Received data will appear here"
        android:textSize="18sp" />

</LinearLayout>
Main JAVA:
package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private EditText dataEditText;
    private Button shareButton;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        dataEditText = findViewById(R.id.dataEditText);
        shareButton = findViewById(R.id.shareButton);
        statusTextView = findViewById(R.id.statusTextView);

        // Set up the share button click listener
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataToShare = dataEditText.getText().toString();

                // Check if the user entered any data
                if (!dataToShare.isEmpty()) {
                    // Create an intent to start the SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("sharedData", dataToShare); // Pass the data

                    // Start the SecondActivity
                    startActivity(intent);
                } else {
                    statusTextView.setText("Please enter some text to share.");
                }
            }
        });
    }
}
Second JAVA:
package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView receivedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize the TextView
        receivedTextView = findViewById(R.id.receivedTextView);

        // Get the intent that started this activity
        Intent intent = getIntent();

        // Retrieve the shared data
        String sharedData = intent.getStringExtra("sharedData");

        // Display the received data in the TextView
        if (sharedData != null) {
            receivedTextView.setText(sharedData);
        } else {
            receivedTextView.setText("No data received");
        }
    }
}
Manifest.XML:
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.MyApplication"
        tools:targetApi="31">
        <activity android:name=".MainActivity"
            tools:ignore="IntentFilterExportedReceiver"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <activity android:name=".SecondActivity" />

    </application>

</manifest>
