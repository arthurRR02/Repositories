package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val service: GitHubService) : Repositories {

    override suspend fun listRepositories(user: String) = flow {
        val repositoryList = service.listRepositories(user)
        emit(repositoryList)
    }
}