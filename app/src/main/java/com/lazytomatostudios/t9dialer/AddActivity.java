package com.lazytomatostudios.t9dialer;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lazytomatostudios.t9dialer.db.DBContract;
import com.lazytomatostudios.t9dialer.db.DBHelper;

public class AddActivity extends AppCompatActivity {

    Button saveButton;
    EditText nameText, phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameText = findViewById(R.id.name_edittext);
        phoneText = findViewById(R.id.phone_edittext);
        saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                saveToDB();
            }
        });
    }

    //ADD CONTACT TO DATABASE
    public void saveToDB() {
        SQLiteDatabase database = new DBHelper(this).getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        long id = getCustomID(nameText.getText().toString());

        contentValues.put(DBContract.Contact.COLUMN_NAME, nameText.getText().toString());
        contentValues.put(DBContract.Contact.COLUMN_PHONE, Long.valueOf(phoneText.getText().toString()));
        contentValues.put(DBContract.Contact.COLUMN_UID, id);

        long newRowId = database.insert(DBContract.Contact.TABLE_NAME, null, contentValues);

        Log.d("TAG", "Row inserted at : " + newRowId);
    }

    //GENERATES CUSTOM ID DEPENDING ON CONTACT NAME
    public long getCustomID(String name){

        long id = 0;

        String [] t9Ref = new String [] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Log.d("GAT", String.valueOf(name.length()));
        Log.d("GAT", String.valueOf(t9Ref.length));

        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < t9Ref.length; j++) {
                if(t9Ref[j].contains(String.valueOf(name.toLowerCase().charAt(i)))) {
                    Log.d("FOUND", "Index : " + j + " with " + name.charAt(i) + " at " + t9Ref[j]);
                    id = (id * 10) + j;
                    break;
                }
            }
        }
        Log.d("TAG", "Generated ID : " + id);

        return id;
    }
}
