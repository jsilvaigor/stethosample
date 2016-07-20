package us.antenado.sthetosample.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by isilva on 19/07/16.
 */
public class CreateDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "stetho_sample.db";
    public static final String TABLE = "users";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final int VERSION = 1;


    public CreateDB(Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE + "("
                + ID + " integer primary key autoincrement, "
                + NAME + " text, "
                + AGE + " text"
                + ")";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}
