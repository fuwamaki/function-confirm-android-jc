package com.example.jcsample.network

import com.example.jcsample.model.GithubResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPIClient {

    @GET("/search/repositories")
    suspend fun getRepositories(@Query("q") query: String): Response<GithubResponse>
}