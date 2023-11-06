package tp.info507.diarystravel.storage

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import tp.info507.diarystravel.helper.DataBaseHelper
import tp.info507.diarystravel.model.Travel
import tp.info507.diarystravel.storage.utility.DataBaseStorage

class TravelDataBaseStorage(context: Context) : DataBaseStorage<Travel>(DataBaseHelper(context), "travel") {

    companion object {
        const val ID = 0
        const val NAME = 1
        const val DATE = 2
        const val LOCALISATION = 3
        const val DESCRIPTION = 4
    }

    override fun objectToValues(obj: Travel): ContentValues {
        val values = ContentValues()
        values.put(Travel.NAME, obj.name)
        values.put(Travel.DATE, obj.date)
        values.put(Travel.LOCALISATION, obj.localisation)
        values.put(Travel.DESCRIPTION, obj.description)

        return values
    }

    override fun cursorToObject(cursor: Cursor): Travel {
        return Travel(
            cursor.getInt(ID),
            cursor.getString(NAME),
            cursor.getString(DATE),
            cursor.getString(LOCALISATION),
            cursor.getString(DESCRIPTION)
        )
    }



}