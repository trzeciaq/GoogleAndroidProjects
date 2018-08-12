package com.example.android.books.data;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.books.R;
import com.example.android.books.data.BookContract.BookEntry;

public class BookCursorAdapter extends CursorAdapter {

    public BookCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.textview_book_title);
        TextView bookThemaTextView = (TextView) view.findViewById(R.id.textview_book_thema);
        TextView priceTextView = (TextView) view.findViewById(R.id.textview_book_price);
        TextView quantityTextView = (TextView) view.findViewById(R.id.textview_book_quantity);
        Button buttonSale = (Button) view.findViewById(R.id.button_sale_book);

        // Find the columns of book attributes that we're interested in
        final int columnIndex = cursor.getInt(cursor.getColumnIndex(BookEntry._ID));
        int titleColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_TITLE);
        int themaColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_THEMA);
        int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY);

        // Read the book attributes from the Cursor for the current book


            String bookTitle = cursor.getString(titleColumnIndex);
            String themaBook = cursor.getString(themaColumnIndex);
            String priceBook = cursor.getString(priceColumnIndex);
            String quantityBook = cursor.getString(quantityColumnIndex);

            final int quantityOnStock = Integer.valueOf(quantityBook);

            nameTextView.setText(bookTitle);
            bookThemaTextView.setText(themaBook);
            priceTextView.setText(priceBook + "€");
            quantityTextView.setText(quantityBook);


        buttonSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = ContentUris.withAppendedId(BookEntry.CONTENT_URI, columnIndex);

                if (quantityOnStock == 0) {
                    Toast.makeText(context, R.string.out_of_stock, Toast.LENGTH_SHORT).show();
                } else {
                    int newQuantity = quantityOnStock - 1;

                    if (newQuantity == 0) {
                        Toast.makeText(context, R.string.out_of_stock, Toast.LENGTH_SHORT).show();
                    }

                    ContentValues contentValues = new ContentValues();
                    contentValues.put(BookEntry.COLUMN_BOOK_QUANTITY, newQuantity);
                    int numRowsUpdated = context.getContentResolver().update(uri, contentValues, null, null);

                    if (numRowsUpdated > 0) {
                        Toast.makeText(context.getApplicationContext(), R.string.take_out_of_stock, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context.getApplicationContext(), R.string.out_of_stock, Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
