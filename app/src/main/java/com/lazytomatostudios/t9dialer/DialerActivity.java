package com.lazytomatostudios.t9dialer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DialerActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Contact> contactList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);

        cAdapter = new ContactAdapter(contactList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);

        prepareContactData();

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
    }

    public void prepareContactData() {
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
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:

                // do something when the corky is clicked

                break;
            case R.id.btn_2:

                // do something when the corky2 is clicked

                break;
            case R.id.btn_3:

                // do something when the corky3 is clicked

                break;
            case R.id.btn_4:

                // do something when the corky is clicked

                break;
            case R.id.btn_5:

                // do something when the corky2 is clicked

                break;
            case R.id.btn_6:

                // do something when the corky3 is clicked

                break;
            case R.id.btn_7:

                // do something when the corky3 is clicked

                break;
            case R.id.btn_8:

                // do something when the corky2 is clicked

                break;
            case R.id.btn_9:

                // do something when the corky3 is clicked

                break;
            case R.id.btn_0:

                // do something when the corky3 is clicked

                break;
            default:
                break;
        }
    }
}
