package org.app.siekraf.feature_login.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.app.siekraf.core.data.ApiConfig
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class ApiService {

    private val conn: HttpURLConnection = URL("${ApiConfig.BASE_URL}/login").openConnection() as HttpURLConnection

    init {
        conn.requestMethod = "POST"
        conn.doOutput = true
        conn.doInput = true
        conn.setRequestProperty("Content-Type", "application/json")
        conn.setRequestProperty("Accept", "application/json")
    }

    fun getToken(email: String, password: String): Flow<String> {
        return flow {

            val requestBody = JSONObject()
            requestBody.put("email", email)
            requestBody.put("password", password)

            conn.outputStream.use {
                it.write(requestBody.toString().toByteArray())
            }
            val responseCode = conn.responseCode

            val response = if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = conn.inputStream
                val responseBody = inputStream.bufferedReader().use {
                    it.readText()
                }
                inputStream.close()

                val jsonObject = JSONObject(responseBody)
                val token = jsonObject.getString("token")
                token
            } else {
                val errorStream = conn.errorStream
                val responseBody = errorStream.bufferedReader().use {
                    it.readText()
                }
                errorStream.close()
                throw Exception(responseBody)
            }
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

}