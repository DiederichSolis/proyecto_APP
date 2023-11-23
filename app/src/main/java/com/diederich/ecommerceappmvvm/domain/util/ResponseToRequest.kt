package com.diederich.ecommerceappmvvm.domain.util

import com.diederich.ecommerceappmvvm.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result: Response<T>): Resource<T> {
        return try {
            if (result.isSuccessful) {
                Resource.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la peticion Http")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verifica tu Conexion a internet")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }
}
