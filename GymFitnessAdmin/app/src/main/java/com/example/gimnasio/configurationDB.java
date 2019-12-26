package com.example.gimnasio;

import android.provider.BaseColumns;

public class configurationDB {
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
