package com.diederich.ecommerceappmvvm.data.repository

import com.diederich.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.diederich.ecommerceappmvvm.domain.model.AuthResponse
import com.diederich.ecommerceappmvvm.domain.model.ErrorResponse
import com.diederich.ecommerceappmvvm.domain.repository.AuthRepository
import com.diederich.ecommerceappmvvm.domain.util.ConvertErrorBody
import com.diederich.ecommerceappmvvm.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl (private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return  try {
            val result = authRemoteDataSource.login(email,password)
          if(result.isSuccessful) {
              Resource.Success(result.body()!!)
          }
            else{
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
              Resource.Failure(errorResponse?.message?: "Error desconocido")
          }
        }
        catch (e: HttpException){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la peticion Http")
        }
        catch (e: IOException){
            e.printStackTrace()
            Resource.Failure("Verifica tu Conexion a internet")
        }

        catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }


}