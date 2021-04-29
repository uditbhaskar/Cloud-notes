package com.example.cloudnotes.data.repository

import com.example.cloudnotes.data.local.DatabaseService
import com.example.cloudnotes.data.model.Dummy
import com.example.cloudnotes.data.remote.request.DummyRequest
import com.example.cloudnotes.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchDummy(id: String): Single<List<Dummy>> =
        networkService.doDummyCall(DummyRequest(id)).map { it.data }

}