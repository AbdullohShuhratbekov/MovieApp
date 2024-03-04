package com.example.movieApp.domain.models.movie_domain_model

import com.example.movieApp.data.models.movie_model.MovieModel
import java.io.Serializable

data class MovieDomainModelResullts(
    val movieResults: List<MovieModel>,
) : Serializable {
    companion object {
        val unknown = MovieDomainModelResullts(
            movieResults = listOf()
        )
    }
}
