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

import com.lazytomatostudios.t9dialer.db.DBContract;
import com.lazytomatostudios.t9dialer.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class DialerActivity extends AppCompatActivity {

    SQLiteDatabase database;

    private RecyclerView recyclerView;
    private ContactAdapter cAdapter;

    Cursor cursor;

    String[] projection = {
            DBContract.Contact.COLUMN_NAME,
            DBContract.Contact.COLUMN_PHONE,
            DBContract.Contact.COLUMN_UID
    };

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

        prepareContactData();
    }

    public void prepareContactData() {

        List<Contact> contactList = new ArrayList<>();

        cAdapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(cAdapter);

        cursor = database.query(DBContract.Contact.TABLE_NAME, projection, null, null, null, null, null, null);

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
            prepareContactData();
        }

        return super.onOptionsItemSelected(item);
    }
}
