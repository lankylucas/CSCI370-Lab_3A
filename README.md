# CSCI370-Lab_3A
Advanced Adapter Lab

This Lab builds upon the simple ListView and Adapter topics we have been discussing in class.

## Problem
This lab will have you creating a listview that will contain Students along with majors and an AVI. The listview will use a custom layout file that you will create.

## Purpose
This lab will build upon your basic Adapter knowledge. You will create a custom Adapter and custom layout for the the data.

## Steps
### Create Views:
* Open Android Studio and create a basic project. Name the project whatever you like, **AdvancedAdapter** is a good candidate. Choose **API 23: Android 6.0 (Marshmallow)**. Next choose just an **Empty Activity**.
* In the **activity_main.xml**, replace the default TextView with
```xml
    <ListView
        android:id="@+id/student"
        android:layout_height="match_parent"
        android:layout_width="match_parent">
    </ListView>
 ```
* Create a layout file name **list_view_row.xml**.
* Add an ImageView and three TextView elements. HINT: Use the following as a starting point and modify once you have that working:
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    >


    <RelativeLayout xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/thumbnail"
            android:layout_width="90dp"
            android:layout_height="90dp"
            android:layout_alignParentStart="true"
            android:layout_centerVertical="true"
            android:layout_marginBottom="6dp"
            android:layout_marginStart="4dp"
            android:layout_marginTop="6dp"
            android:contentDescription="Desc"
            android:scaleType="centerInside"
            android:text="CS"
            android:textAlignment="center"
            android:textSize="22dp"
            tools:src="@mipmap/ic_launcher"

            />

        <TextView
            android:id="@+id/last_name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_centerVertical="true"
            android:layout_marginEnd="2dp"
            android:layout_marginStart="4dp"
            android:maxLines="1"
            android:textColor="#000000"
            android:textSize="20dp"
            tools:text="Detail" />

        <RelativeLayout
            android:id="@+id/list_text_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_toEndOf="@id/category_thumbnail"
            android:layout_toStartOf="@id/last_name">

            <TextView
                android:id="@+id/first_name"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="8dp"
                android:layout_marginRight="8dp"
                android:textSize="18sp"
                tools:text="Title" />

            <TextView
                android:id="@+id/major"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@+id/first_name"
                android:layout_marginLeft="8dp"
                android:layout_marginRight="8dp"
                android:layout_marginTop="2dp"
                android:ellipsize="end"
                android:maxLines="3"
                android:textSize="16sp"
                tools:text="Subtitle" />
        </RelativeLayout>
    </RelativeLayout>
</android.support.constraint.ConstraintLayout>
```
* Modifying the thumbnail to be an ImageView will be the **Challenge**. Get the version with TextView workking first. You can use [icons8.com](https://icons8.com/) for icons. I think 96 by 96 is a good size to get.
* Create a Java reference to the ListView in **MainActivity.java**.
* Create a **com.example.advancedadapter.Student** class in Java (a POJO- Plain Ole Java Object) with three Strings as private member variables (firstName, lastName, and major). Remember, POJO are only constructors, getters, and setters.
* In MainActivity.java, create 5 Students and put them into an ArrayList. Make sure to give the Students a firstName, lastName, and major.
* Create a StudentAdapter class that extends BaseAdapter and takes in a Context Object and an ArrayList in the constructor.
* In StudentAdapter.java, create the following private member variables:
```
    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<com.example.advancedadapter.Student> mDataSource;
```
* In the constructor, set mContext and mDataSource to the arguments that are passed in.
* In the constructor, set mInflator as follows:
```
mInflator = (LayoutInflater) mContext.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
```
* Override the required methods that enforced by BaseAdapter.
* return the proper values as discussed in class for **getCount(), getItem(), and getItemId()**.
* The first line in **getView()** should be:
```
 View rowView = mInflator.inflate(R.layout.list_view_row, parent, false);
```
* Under that line, code the mapping, the basic steps are create a reference to the View items in layout file, create a com.example.advancedadapter.Student reference by calling getItem(), set necessary fields in View items with data from com.example.advancedadapter.Student.
* In MainActivity.java, have your ListView object set an adapter with the StudentAdapter you created in the last step.
* Run your application and test.

### Add Click Listeners:
* **ListView** affords you the option to apply listeners to each item in the list.
* On your ListView object, set a **OnItemClickListener** and a **OnItemLongClickListener**. Create a different Toast message for each. **NOTE: If you return false on the LongClickListener, it will all for other Listeners**. Test your Click Listeners and observe how the regular click is automatically called after the long click.
* Change the LongClickListener to return true and test again. Observe how the regular click no longer is called.

### Style the ListView
* Add the following lines to the ListView in **activity_main.xml**:
```xml
<ListView
    ...
    android:dividerHeight="5.0sp"
    android:divider="@android:color/black"
    android:padding="45sp">
</ListView>
```
* Test your code one final time.
* Share, commit, and push lab to your GitHub account
