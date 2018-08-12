
package com.example.android.books.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class BookContract {

    private BookContract() {}

    public static final String CONTENT_AUTHORITY = "com.example.android.books";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_BOOKS = "books";

    public static final class BookEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /** Name of database table for books */
        public final static String TABLE_NAME = "books";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_BOOK_TITLE ="title";
        public final static String COLUMN_BOOK_SUPPLIER_NAME = "supplier_name";
        public final static String COLUMN_BOOK_SUPPLIER_PHONE_NUMBER = "supplier_phone_number";
        public final static String COLUMN_BOOK_THEMA = "thema";
        public final static String COLUMN_BOOK_PRICE = "price";
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        public static final String THEMA_UNKNOWN = "Unknown";
        public static final String THEMA_FANTASY = "Fantasy";
        public static final String THEMA_SCIENCE_FICTION = "Science-fiction";

    }

}

