package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.model.Repository
import kotlinx.coroutines.flow.Flow

interface Repositories {

  suspend fun listRepositories(user: String) : Flow<List<Repository>>

}