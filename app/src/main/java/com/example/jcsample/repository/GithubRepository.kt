package com.example.jcsample.repository

import com.example.jcsample.model.ErrorResponse
import com.example.jcsample.model.GithubResponse
import com.example.jcsample.network.GithubAPIClient
import retrofit2.Response
import java.lang.IllegalStateException
import javax.inject.Inject
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result

class GithubRepository @Inject constructor(
    private val githubApiClient: GithubAPIClient,
) {
    suspend fun getRepositories(query: String): Result<GithubResponse, ErrorResponse> {
        return githubApiClient.getRepositories(query).result()
    }

    private fun <T> Response<T>.result(): Result<T, ErrorResponse> {
        return if (isSuccessful) {
            Ok(body() ?: throw IllegalStateException("response body is null"))
        } else {
            Err(
                ErrorResponse(
                    code = code(),
                    message = message()
                )
            )
        }
    }
}