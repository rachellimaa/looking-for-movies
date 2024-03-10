package com.rachellima.movies

import com.rachellima.models.Search
import com.rachellima.movies.repository.remote.OmdbRepositoryImpl
import com.rachellima.network.api.OmdbApi
import com.rachellima.network.model.OmdbResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Response

class OmdbRepositoryImplTest {

    @Test
    fun `getAllOmdbResponse returns correct OmdbResponse`() = runBlocking {
        val omdbApi: OmdbApi = mockk()

        val omdbResponse = OmdbResponse("teste", mutableListOf(Search("Movie saved", "test1", "", "", "")), "")
        val response = Response.success(omdbResponse)

        coEvery { omdbApi.getOmdbResponse(any()) } returns response

        val omdbRepository = OmdbRepositoryImpl(omdbApi)

        val result = omdbRepository.getAllOmdbResponse("movie_title")

        coVerify { omdbApi.getOmdbResponse("movie_title") }

        assertEquals(omdbResponse, result)
    }
}