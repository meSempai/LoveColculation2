package com.example.lovecolculation.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("love_table")
data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
) {
    override fun toString(): String {
        return "${firstName}\n ${secondName}\n ${percentage}\n ${result}\n"
    }
}




