package com.chyngyzturapov.testapp.data.repo


import com.chyngyzturapov.testapp.data.model.JsonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
class FirstRepository @Inject constructor(
) {
    suspend fun getUser(): Flow<JsonModel.User> {
        return flow {
            val result = JsonModel.User(
                company = listOf(
                    JsonModel.User.Company("SmartPost", "Android Developer"),
                    JsonModel.User.Company("SmartLogic", "Intern mobile Developer"),
                ),
                education = 1,
                first_name = "Chyngyz",
                photo =
                "https://sun9-31.userapi.com/impg/Zg9KNHNuZq4EZFpO0qikPu1SwlI3JY1_4jTrEw/8NG2Tq3n-y0.jpg?size=2560x1707&quality=96&sign=9a6f4eca06f39aa970757a812c9a5b14&type=album",
                second_name = "Turapov"
            )
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}