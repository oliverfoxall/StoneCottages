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
    private static final String DATABASE_NAME = "http://jamesdowen.com/cli/stonecottages/";
     // Login table name
    private static final String TABLE_CLIENT = "clienttable";

    // Login Table Columns names
    private static final String KEY_ID = "ClientID";
    private static final String KEY_FIRST_NAME = "firstName";
    private static final String KEY_SECOND_NAME = "secondName";
    private static final String KEY_CITY_TOWN = "cityTown";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ADDRESS_1 = "address1";
    private static final String KEY_ADDRESS_2 = "address2";
    private static final String KEY_POST_CODE = "postCode";
    private static final String KEY_PHONE = "phoneNumber";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_FIRST_NAME + " TEXT,"
                + KEY_SECOND_NAME + "TEXT,"
                + KEY_EMAIL + " TEXT UNIQUE,"
                + KEY_ADDRESS_1 + " TEXT,"
                + KEY_PHONE + "TEXT UNIQUE,"
                + KEY_CITY_TOWN + "TEXT,"
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
    public void addUser(String fName, String sName, String email, String phone, String address1, String address2, String postCode, String cityTown) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, fName); // First Name
        values.put(KEY_SECOND_NAME, sName); // Second Name
        values.put(KEY_CITY_TOWN, cityTown); ///city/town
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
            user.put("fName", cursor.getString(1));
            user.put("sName", cursor.getString(2));
            user.put("cityTown", cursor.getString(3));
            user.put("email", cursor.getString(4));
            user.put("phone", cursor.getString(5));
            user.put("address1", cursor.getString(6));
            user.put("address2", cursor.getString(7));
            user.put("postCode", cursor.getString(8));

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
