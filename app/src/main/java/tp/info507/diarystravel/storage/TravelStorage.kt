package tp.info507.diarystravel.storage

import android.content.Context
import tp.info507.diarystravel.model.Travel
import tp.info507.diarystravel.storage.utility.Storage

object TravelStorage {
    fun get(context: Context): Storage<Travel> {
        lateinit var storage: Storage<Travel>
        storage = TravelDataBaseStorage(context)
        return storage
    }
}