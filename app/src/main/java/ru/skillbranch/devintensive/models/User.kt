package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false
){
    constructor(id:String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar=null
    )

   private constructor(builder: Builder) : this(
        builder.id,
        builder.firstName,
        builder.lastName,
        builder.avatar,
        builder.rating,
        builder.respect,
        builder.lastVisit,
        builder.isOnline
        )

    companion object Factory{
        private var lastId : Int = -1
        fun makeUser(fullName:String?) : User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return  User(lastId.toString(), firstName = firstName,lastName = lastName)
        }
    }



    class Builder{
        var id: String = "${lastId++}"
            private set

        var firstName: String? = null
            private set

        var lastName: String? = null
            private set

        var avatar: String? = null
            private set

        var rating : Int = 0
            private set

        var respect : Int = 0
            private set

        var lastVisit : Date? = Date()
            private set

        var isOnline : Boolean = false
            private set

        fun id(id: String) = apply { this.id = id; return this }
        fun firstName(firstName: String?) = apply { this.firstName = firstName; return this }
        fun lastName(lastName: String?) = apply { this.lastName = lastName; return this }
        fun avatar(avatar: String?) = apply { this.avatar = avatar; return this }
        fun rating(rating: Int) = apply { this.rating = rating; return this }
        fun respect(respect: Int) = apply { this.respect = respect; return this }
        fun lastVisit(lastVisit: Date?) = apply { this.lastVisit = lastVisit; return this }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline; return this }
        fun build() = User(this)
    }
}