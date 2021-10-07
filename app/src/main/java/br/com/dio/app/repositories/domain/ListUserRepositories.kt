package br.com.dio.app.repositories.domain

import br.com.dio.app.repositories.core.UseCase
import br.com.dio.app.repositories.data.model.Repository
import br.com.dio.app.repositories.data.repositories.Repositories
import kotlinx.coroutines.flow.Flow

class ListUserRepositories(private val repository: Repositories) : UseCase<String, List<Repository>>() {

    override suspend fun execute(param: String): Flow<List<Repository>> {
        return repository.listRepositories(param)
    }
}