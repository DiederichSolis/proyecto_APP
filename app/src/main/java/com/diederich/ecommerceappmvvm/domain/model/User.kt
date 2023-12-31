package com.diederich.ecommerceappmvvm.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("id") val id:String? = null,
    @SerializedName("name") val name:String,
    @SerializedName("lastname") val lastname:String,
    @SerializedName("email") val email:String,
    @SerializedName("phone") val phone:String,
    @SerializedName("password") val password:String,
    @SerializedName("imagen") val image:String? = null,
    @SerializedName("notification_token") val notificationToken:String? = null,
    @SerializedName("roles") val roles: ArrayList<Rol>? = null,
): Serializable {

    fun toJson(): String = Gson().toJson(this)

    companion object{
        fun fromJson(data: String):User = Gson().fromJson(data, User::class.java) //data se pasa a un objetod de tipo user
    }

}
