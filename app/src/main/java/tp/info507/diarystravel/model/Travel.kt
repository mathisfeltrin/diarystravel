package tp.info507.diarystravel.model

class Travel (
    val id: Int,
    val name: String,
    val date: String,
    val localisation: String,
    val description: String,
) {
    companion object{
        const val ID = "id"
        const val NAME = "name"
        const val DATE = "date"
        const val LOCALISATION = "localisation"
        const val DESCRIPTION = "description"
    }
}