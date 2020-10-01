package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullname : String?) : Pair<String?,String?> {
        val parts : List<String>? = fullname?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        if (firstName.isNullOrBlank()) {
            firstName = null
            lastName = null
        }
        return firstName to lastName
    }

    fun toInitials(firstName : String?, lastName: String?) :  String?{
            var firstName = firstName
            var lastName = lastName
        if (firstName.isNullOrBlank())
                firstName = null
        if (lastName.isNullOrBlank())
            lastName = null
        firstName = firstName?.dropWhile{
            it == ' '
        }
        lastName = lastName?.dropWhile{
            it == ' '
        }
         firstName  = firstName?.first()?.toUpperCase()?.toString()?:""
         lastName  = lastName?.first()?.toUpperCase()?.toString() ?:""

        var initials : String? = firstName+lastName
        if (initials.isNullOrBlank())
        initials=null
        return initials
    }

    fun translitiration (divider  : String = "") : String =
        divider.replace(Regex("[йцукенгшщзхъфывапролджэячсмитьбюЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ]")) {
            when (it.value) {
                "a" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                "А" -> "A"
                "Б" -> "B"
                "В" -> "V"
                "Г" -> "G"
                "Д" -> "D"
                "Е" -> "E"
                "Ё" -> "E"
                "Ж" -> "Zh"
                "З" -> "Z"
                "И" -> "I"
                "Й" -> "I"
                "К" -> "K"
                "Л" -> "L"
                "М" -> "M"
                "Н" -> "N"
                "О" -> "O"
                "П" -> "P"
                "Р" -> "R"
                "С" -> "S"
                "Т" -> "T"
                "У" -> "U"
                "Ф" -> "F"
                "Х" -> "H"
                "Ц" -> "C"
                "Ч" -> "Ch"
                "Ш" -> "Sh"
                "Щ" -> "Sh"
                "Ъ" -> ""
                "Ы" -> "I"
                "Ь" -> ""
                "Э" -> "E"
                "Ю" -> "Yu"
                "Я" -> "Ya"

                else -> it.value
            }
        }

}