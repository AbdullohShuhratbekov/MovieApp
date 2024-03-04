package com.example.movieApp.domain.models.movie_domain_info

import java.io.Serializable

data class ProductionCompanyDomain(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
) : Serializable {
    companion object {
        val unknown = ProductionCompanyDomain(
            id = 0,
            logoPath = null,
            name = "",
            originCountry = ""
        )
    }
}