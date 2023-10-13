package tp.info507.diarystravel.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import tp.info507.diarystravel.model.Travel

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, "diarystravel.db", null,1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE Travel (" +
                    "${BaseColumns._ID} INTEGER," +
                    "${Travel.NAME} TEXT," +
                    "${Travel.DATE} DATE," +
                    "${Travel.LOCALISATION} TEXT," +
                    "${Travel.DESCRIPTION} TEXT," +
                    "PRIMARY KEY(${BaseColumns._ID})" +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}