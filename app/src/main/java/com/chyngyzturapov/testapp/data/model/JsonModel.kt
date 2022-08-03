package com.chyngyzturapov.testapp.data.model

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