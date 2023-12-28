package com.example.apidatabase.Repository

import com.example.apidatabase.model.Kontak
import com.example.apidatabase.service_api.KontakService

interface KontakRepository {

    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}