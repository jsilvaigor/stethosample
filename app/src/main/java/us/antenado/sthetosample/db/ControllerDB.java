package us.antenado.sthetosample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by isilva on 19/07/16.
 */
public class ControllerDB {

    private SQLiteDatabase db;
    private CreateDB mDb;

    public ControllerDB(Context context) {
        this.mDb = new CreateDB(context);
    }

    public String insertData(String name, String age){

        ContentValues values;
        long result;

        db = mDb.getWritableDatabase();
        values = new ContentValues();
        values.put(CreateDB.NAME, name);
        values.put(CreateDB.AGE, age);

        result = db.insert(CreateDB.TABLE, null, values);

        if(result == -1){
            return "Error while saving!";
        }else{
            return "Success!";
        }

    }

    public String getAllData(){

        Cursor cursor;
        String result = "";
        String[] fields = {CreateDB.ID, CreateDB.NAME, CreateDB.AGE};

        db = mDb.getReadableDatabase();
        cursor = db.query(CreateDB.TABLE, fields, null, null, null, null, null, null);

        if(cursor==null){
            db.close();
            return result;
        }else{
            try {
                while (cursor.moveToNext()) {
                    result += "ID: " + cursor.getInt(cursor.getColumnIndex(CreateDB.ID))
                            + "/ NAME: " + cursor.getString(cursor.getColumnIndex(CreateDB.NAME))
                            + "/ AGE: " + cursor.getString(cursor.getColumnIndex(CreateDB.AGE))
                            + "\n\n";
                 }
            } finally {
                cursor.close();
                return result;
            }
        }


    }
}
