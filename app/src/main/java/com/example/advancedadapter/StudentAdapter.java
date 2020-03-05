package com.example.advancedadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Student> mDataSource;

    public StudentAdapter(Context context,ArrayList<Student> student) {
        mContext = context;
        mDataSource = student;
        mInflator = (LayoutInflater) mContext.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View rowView = mInflator.inflate(R.layout.list_view_row, parent, false);
       TextView firstName= rowView.findViewById(R.id.first_name);
       TextView lastName= rowView.findViewById(R.id.last_name);
        TextView major= rowView.findViewById(R.id.major);

        Student student= (Student) getItem(i);
        firstName.setText(student.getFirstName());
        lastName.setText(student.getLastName());
        major.setText(student.getMajor());
        return rowView;
    }
}
