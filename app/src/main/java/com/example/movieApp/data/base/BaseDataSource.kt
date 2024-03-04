package com.example.movieApp.data.base

import com.example.movieApp.data.base.model.AnotherError
import com.example.movieApp.data.base.model.ResultStatus
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseDataSource {

    suspend fun <T> invokeResponseRequest(request: suspend () -> Response<T>): ResultStatus<T> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                ResultStatus.succes(
                    data = response.body()!!,
                )
            } else {
                ResultStatus.error(
                    errorThrowable = AnotherError(
                        errorMessage = response.message(),
                        code = response.code()
                    ),
                    data = null
                )
            }
        } catch (httpException: HttpException) {
            ResultStatus.error(errorThrowable = httpException, data = null)
        } catch (e: Exception) {
            ResultStatus.error(errorThrowable = e, data = null)
        }
    }
}