package com.example.mwyouthfootballportal.Data.Models

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

data class FootballMatchResponse(
    val response: List<MatchResult>
)

data class MatchResult(
    val fixture: Fixture,
    val league: League,
    val teams: Teams,
    val score: Score
)

data class Fixture(
    val id: Int,
    val referee: String?
)

data class League(
    val id: Int,
    val name: String,
    val country: String,
    val logo: String?,
    val flag: String?
)

data class Teams(
    val home: HomeAwayTeam,
    val away: HomeAwayTeam
)

data class HomeAwayTeam(
    val id: Int,
    val name: String,
    val logo: String?
)

data class Score(
    val halftime: String,
    val fulltime: String,
    val extratime: String?,
    val penalty: String?
)

