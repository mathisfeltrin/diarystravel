package tp.info507.diarystravel.storage.utility

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import tp.info507.diarystravel.helper.DataBaseHelper

abstract class DataBaseStorage<T>(private val helper: SQLiteOpenHelper,private val table : String) : Storage<T> {

    protected abstract fun objectToValues(obj:T): ContentValues
    protected abstract fun cursorToObject(cursor: Cursor) : T

    override fun insert(obj: T): Int {
        return helper.writableDatabase.insert(table, null, objectToValues(obj)).toInt()
    }

    override fun size(): Int {
        return helper.readableDatabase.query(table, null, null, null, null, null,null,null).count
    }

    override fun find(id: Int): T? {
        var obj: T? = null
        val cursor = helper.readableDatabase.query(table,
            null, "${BaseColumns._ID} = ?", arrayOf("$id"),
            null, null, null, null)

        if (cursor.moveToNext()){
            obj = cursorToObject(cursor)
        }
        cursor.close()
        return obj
    }

    override fun findAll(): List<T> {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, obj: T) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}