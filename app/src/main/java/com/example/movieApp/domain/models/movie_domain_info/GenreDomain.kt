package com.example.movieApp.domain.models.movie_domain_info

import java.io.Serializable

data class GenreDomain(
    val id: Int,
    val name: String
) : Serializable {
    companion object {
        val unknown = GenreDomain(
            id = 0,
            name = ""
        )
    }
}