package com.lazytomatostudios.t9dialer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lazytomatostudios.t9dialer.db.DBContract;
import com.lazytomatostudios.t9dialer.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class DialerActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase database;

    private RecyclerView recyclerView;
    private ContactAdapter cAdapter;

    Cursor cursor;

    long num = 0;

    String[] projection = {
            DBContract.Contact.COLUMN_NAME,
            DBContract.Contact.COLUMN_PHONE,
            DBContract.Contact.COLUMN_UID
    };

    String selection = DBContract.Contact.COLUMN_UID + " like ?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database = new DBHelper(this).getReadableDatabase();

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Button button1 = (Button)findViewById(R.id.btn_1);
        Button button2 = (Button)findViewById(R.id.btn_2);
        Button button3 = (Button)findViewById(R.id.btn_3);
        Button button4 = (Button)findViewById(R.id.btn_4);
        Button button5 = (Button)findViewById(R.id.btn_5);
        Button button6 = (Button)findViewById(R.id.btn_6);
        Button button7 = (Button)findViewById(R.id.btn_7);
        Button button8 = (Button)findViewById(R.id.btn_8);
        Button button9 = (Button)findViewById(R.id.btn_9);
        Button button0 = (Button)findViewById(R.id.btn_0);
        Button buttonClear = (Button)findViewById(R.id.btn_clr);
        Button buttonBack = (Button)findViewById(R.id.btn_bck);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
    }

    public void prepareContactData(long num) {

        String[] selectionArgs = {String.valueOf(num) + "%"};

        List<Contact> contactList = new ArrayList<>();

        cAdapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(cAdapter);

        cursor = database.query(DBContract.Contact.TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);

        String name, phone, id;

        while(cursor.moveToNext()) {
            int index;

            index = cursor.getColumnIndexOrThrow("name");
            name = cursor.getString(index);

            index = cursor.getColumnIndexOrThrow("phone");
            phone = cursor.getString(index);

            index = cursor.getColumnIndexOrThrow("uid");
            id = cursor.getString(index);

            contactList.add(new Contact(name, Long.valueOf(phone)));

            Log.d("TAG", "Name : " + name);
            Log.d("TAG", "Phone : " + phone);
            Log.d("TAG", "ID : " + id);
        }

        cAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_contact) {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        } else if (id == R.id.refresh_contact) {
            Log.d("TAG", "Refresing list...");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                num = (num*10) + 1;
                prepareContactData(num);
                break;
            case R.id.btn_2:
                num = (num*10) + 2;
                prepareContactData(num);
                break;
            case R.id.btn_3:
                num = (num*10) + 3;
                prepareContactData(num);
                break;
            case R.id.btn_4:
                num = (num*10) + 4;
                prepareContactData(num);
                break;
            case R.id.btn_5:
                num = (num*10) + 5;
                prepareContactData(num);
                break;
            case R.id.btn_6:
                num = (num*10) + 6;
                prepareContactData(num);
                break;
            case R.id.btn_7:
                num = (num*10) + 7;
                prepareContactData(num);
                break;
            case R.id.btn_8:
                num = (num*10) + 8;
                prepareContactData(num);
                break;
            case R.id.btn_9:
                num = (num*10) + 9;
                prepareContactData(num);
                break;
            case R.id.btn_0:
                num = (num*10);
                prepareContactData(num);
                break;
            default:
                break;
        }
    }
}
