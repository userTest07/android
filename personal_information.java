XML File 
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:padding="10dp"
    android:gravity="center">

    <TextView
        android:id="@+id/tvInfo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Personal Information"
        android:textSize="20sp"
        android:gravity="center_horizontal"
        android:textStyle="bold"
        android:layout_marginTop="20dp"
        android:textColor="@android:color/holo_red_light"/>

    <EditText
        android:id="@+id/subject"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Subject Name"
        android:ems="10"
        android:inputType="text"
        android:textSize="18sp"
        android:layout_marginTop="50dp"
        android:layout_below="@+id/tvInfo"/>

    <RadioGroup
        android:id="@+id/genderGroup"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/subject"
        android:layout_marginTop="25dp">

        <RadioButton
            android:id="@+id/radioMale"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Male"
            android:textSize="25sp"/>

        <RadioButton
            android:id="@+id/radioFemale"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Female"
            android:textSize="25sp"/>
    </RadioGroup>

    <Spinner
        android:id="@+id/spinnerQualification"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/genderGroup"
        android:layout_marginTop="50dp"
        android:entries="@array/qualification_array"/>

    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/spinnerQualification"
        android:layout_marginTop="50dp"
        android:text="Submit"
        android:textSize="18sp"
        android:onClick="displayData"/>
</RelativeLayout>
JAVA FILE
package com.example.myapplication8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to display data entered by the user when the button is clicked
    public void displayData(View view) {
        // Getting references to the EditText fields
        EditText subjectField = findViewById(R.id.subject);

        // Getting the text from the subject field
        String subject = subjectField.getText().toString();

        // Getting gender from RadioGroup
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        RadioButton genderButton = findViewById(selectedGenderId);
        String gender = genderButton != null ? genderButton.getText().toString() : "Not selected";

        // Getting qualification from Spinner
        Spinner qualificationSpinner = findViewById(R.id.spinnerQualification);
        String qualification = qualificationSpinner.getSelectedItem().toString();

        // Displaying the entered data (or you could save or process it here)
        String message = "Subject: " + subject + "\nGender: " + gender + "\nQualification: " + qualification;

        // Show data in a Toast message for now
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
In your res/values/strings.xml, define an array for the qualification options.

<resources>
<string name="app_name">Student Personal Info</string>

<string-array name="qualification_array">
    <item>High School</item>
    <item>Undergraduate</item>
    <item>Postgraduate</item>
    <item>PhD</item>
</string-array>
</resources>
