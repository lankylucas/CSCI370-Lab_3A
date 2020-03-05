package com.example.advancedadapter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView listView;
Student studentOne= new Student("Lucas", "Romanova","StudioArt");
    Student studentTwo= new Student("Lank", "hmmm","CSCI");
    Student studentThree= new Student("look", "GaymcDee","Women and Gender Studies");
    Student studentFour= new Student("Igor", "Coke","Bio");
    Student studentFive= new Student("kat", "Molli","Chem");
    ArrayList<Student> students= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        students.add(studentOne);
        students.add(studentTwo);
        students.add(studentThree);


        StudentAdapter adapter = new StudentAdapter(getApplicationContext(), students);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);


    }
}
