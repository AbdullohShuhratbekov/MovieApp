package com.example.movieApp.domain.models.movie_domain_info

import java.io.Serializable

data class MovieInfoResponseDomain(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: BelongsToCollectionDomain,
    val budget: Int,
    val genres: List<GenreDomain>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyDomain>,
    val productionCountries: List<ProductionCountryDomain>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDomain>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int

):Serializable{
    companion object{
        val unknown = MovieInfoResponseDomain(
            adult = true,
            backdropPath = "",
            belongsToCollection = BelongsToCollectionDomain.unknown,
            budget = 0,
            genres = listOf(GenreDomain.unknown),
            homepage = "",
            id = 0,
            imdbId = "",
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            productionCompanies = listOf(ProductionCompanyDomain.unknown),
            productionCountries = listOf(ProductionCountryDomain.unknown),
            releaseDate = "",
            revenue = 0,
            runtime = 0,
            spokenLanguages = listOf(SpokenLanguageDomain.unknown),
            status = "",
            tagline = "",
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0

        )
    }
}