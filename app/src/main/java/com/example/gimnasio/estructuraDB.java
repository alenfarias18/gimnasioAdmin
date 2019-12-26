package com.example.gimnasio;

import android.provider.BaseColumns;

public class estructuraDB implements BaseColumns {

        public static final String TABLE_NAME = "tbl_registro";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

         private static final String SQL_CREATE_ENTRIES =  "CREATE TABLE " + TABLE_NAME + " (" +_ID + " INTEGER PRIMARY KEY," +COLUMN_NAME_TITLE + " TEXT," + COLUMN_NAME_SUBTITLE + " TEXT)";

         private static final String SQL_DELETE_ENTRIES ="DROP TABLE IF EXISTS " + TABLE_NAME;

}
