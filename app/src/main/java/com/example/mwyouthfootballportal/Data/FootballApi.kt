package com.example.mwyouthfootballportal.Data

import com.example.mwyouthfootballportal.Data.Models.FootballMatchResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootballApiService {

    @Headers(
        "X-RapidAPI-Key: ac000882f7mshce54c31cfefffeep1bfe45jsne2c0dc5d4bde",
        "X-RapidAPI-Host: api-football-v1.p.rapidapi.com"
    )
    @GET("v3/fixtures")
    suspend fun getFootballResults(
        @Query("date") date: String,
        @Query("league") leagueId: Int
    ): FootballMatchResponse
}