package br.com.dio.app.repositories.data.model

import com.google.gson.annotations.SerializedName

data class Repository (
    val id: Long,
    val name: String,
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stargazersCount: Long,
    val language: String,
    val forksCount: Long,
    val description: String
)

data class Owner (
    val login: String,
    @SerializedName("avatar_url")
    val avatarURL: String
)
