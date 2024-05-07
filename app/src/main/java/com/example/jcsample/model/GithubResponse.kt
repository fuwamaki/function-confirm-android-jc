package com.example.jcsample.model

import com.google.gson.annotations.SerializedName

data class GithubResponse(
    val items: List<GitRepo>
)

data class GitRepo(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("html_url") val htmlUrl: String,
    val owner: GitRepoOwner,
)

data class GitRepoOwner(
    @SerializedName("avatar_url") val avatarUrl: String,
)
