package tp.info507.diarystravel.model

class Travel (
    var id: Int,
    var name: String,
    var date: String,
    var localisation: String,
    var description: String,
) {
    companion object{
        const val ID = "id"
        const val NAME = "name"
        const val DATE = "date"
        const val LOCALISATION = "localisation"
        const val DESCRIPTION = "description"
    }

    override fun toString(): String{
        return "id = ${id},name = ${name}, date = ${date}, localisation = ${localisation}, description = ${description}"
    }
}