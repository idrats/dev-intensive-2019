package ru.skillbranch.devintensive.unils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return Pair(firstName?.trim()?.ifEmpty { null }, lastName?.trim()?.ifEmpty { null })
    }

    fun transliteration(payload: String, divider:String = " ") :String{
        return payload + divider
    }

    fun toInitials(firstName: String?, lastName: String?) : String {
        return "${(firstName?.first()?.toUpperCase() ?: "")} ${lastName?.first()?.toUpperCase()}}"
    }
}