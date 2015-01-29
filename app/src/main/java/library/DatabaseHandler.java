package library;

/**
 * Created by Oliver on 27/01/2015.
 */
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "android_api";

    // Login table name
    private static final String TABLE_CLIENT = "clienttable";

    // Login Table Columns names
    private static final String KEY_ID = "ClientID";
    private static final String KEY_NAME = "SecondName";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_ADDRESS_1 = "Adress1";
    private static final String KEY_ADDRESS_2 = "Adress2";
    private static final String KEY_POST_CODE = "PostCode";
    private static final String KEY_PHONE = "PhoneNumber";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT UNIQUE,"
                + KEY_ADDRESS_1 + " TEXT,"
                + KEY_PHONE + "TEXT,"
                + KEY_POST_CODE + "TEXT,"
                + KEY_ADDRESS_2 + " TEXT" + ")";
        db.execSQL(CREATE_CLIENT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);

        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String name, String email, String phone, String address1, String address2, String postCode) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Name
        values.put(KEY_EMAIL, email); // Email
        values.put(KEY_PHONE, phone); // phone number
        values.put(KEY_ADDRESS_1, address1); // address 1
        values.put(KEY_ADDRESS_2, address2); // address 2
        values.put(KEY_POST_CODE, postCode); // post code

        // Inserting Row
        db.insert(TABLE_CLIENT, null, values);
        db.close(); // Closing database connection
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String,String> user = new HashMap<String,String>();
        String selectQuery = "SELECT  * FROM " + TABLE_CLIENT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            user.put("name", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("phone", cursor.getString(3));
            user.put("address1", cursor.getString(4));
            user.put("address2", cursor.getString(5));
            user.put("postCode", cursor.getString(6));

        }
        cursor.close();
        db.close();
        // return user
        return user;
    }

    /**
     * Getting user login status
     * return true if rows are there in table
     * */
    public int getRowCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CLIENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();

        // return row count
        return rowCount;
    }

    /**
     * Re crate database
     * Delete all tables and create them again
     * */
    public void resetTables(){
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_CLIENT, null, null);
        db.close();
    }

}
