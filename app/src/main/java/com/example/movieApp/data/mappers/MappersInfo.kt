package com.example.movieApp.data.mappers

import com.example.movieApp.data.models.movie_info.BelongsToCollection
import com.example.movieApp.data.models.movie_info.Genre
import com.example.movieApp.data.models.movie_info.MovieInfoResponse
import com.example.movieApp.data.models.movie_info.ProductionCompany
import com.example.movieApp.data.models.movie_info.ProductionCountry
import com.example.movieApp.data.models.movie_info.SpokenLanguage
import com.example.movieApp.domain.models.movie_domain_info.BelongsToCollectionDomain
import com.example.movieApp.domain.models.movie_domain_info.GenreDomain
import com.example.movieApp.domain.models.movie_domain_info.MovieInfoResponseDomain
import com.example.movieApp.domain.models.movie_domain_info.ProductionCompanyDomain
import com.example.movieApp.domain.models.movie_domain_info.ProductionCountryDomain
import com.example.movieApp.domain.models.movie_domain_info.SpokenLanguageDomain

fun MovieInfoResponse.toDomain() = MovieInfoResponseDomain(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection.toDomain(),
    budget = budget,
    genres = genres.map { it.toDomain() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toDomain() },
    productionCountries = productionCountries.map { it.toDomain() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toDomain() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun BelongsToCollection.toDomain() = BelongsToCollectionDomain(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath
)

fun Genre.toDomain() = GenreDomain(
    id = id,
    name = name
)

fun ProductionCompany.toDomain() = ProductionCompanyDomain(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry
)

fun ProductionCountry.toDomain() = ProductionCountryDomain(
    iso31661 = iso31661,
    name = name
)

fun SpokenLanguage.toDomain() = SpokenLanguageDomain(
    englishName = englishName,
    iso6391 = iso6391,
    name = name
)