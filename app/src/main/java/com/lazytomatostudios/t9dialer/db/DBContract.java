package com.lazytomatostudios.t9dialer.db;

import android.provider.BaseColumns;

/**
 * Created by drpayyne on 20/1/18.
 */

public class DBContract {

    private DBContract() {

    }

    public static class Contact implements BaseColumns {

        public static final String TABLE_NAME = "contact";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_UID = "uid";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PHONE + " INTEGER, " +
                COLUMN_UID + " INTEGER" + ")";
    }
}
