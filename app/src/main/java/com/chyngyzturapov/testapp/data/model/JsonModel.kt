package com.chyngyzturapov.testapp.data.model

import android.net.Uri
import java.net.URI
import java.net.URL

//data class JsonModel(
//    val user: User
//) {
//    data class User(
//        val company: List<Company> = listOf(
//            Company("SmartPost", "Android Developer"),
//            Company("SmartLogic", "Intern mobile Developer"),
//        ),
//        val education: Int = 1,
//        val first_name: String = "Chyngyz",
//        val photo: String =
//            "https://sun9-31.userapi.com/impg/Zg9KNHNuZq4EZFpO0qikPu1SwlI3JY1_4jTrEw/8NG2Tq3n-y0.jpg?size=2560x1707&quality=96&sign=9a6f4eca06f39aa970757a812c9a5b14&type=album",
//        val second_name: String = "Turapov"
//    ) {
//        data class Company(
//            val name: String,
//            val position: String
//        )
//    }
//}
data class JsonModel(
    val user: User
) {
    data class User(
        val company: List<Company>,
        val education: Int,
        val first_name: String,
        val photo: String,
        val second_name: String
    ) {
        data class Company(
            val name: String,
            val position: String
        )
    }
}