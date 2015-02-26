package com.clockworkant.movies.providers.mock

import com.clockworkant.movies.lib.*

class KTMockMovieProvider : MoviesProvider {
    override fun getMovies(moviesCallback: MoviesProvider.MoviesCallback?) {
        moviesCallback?.onMoviesRecieved(
                listOf(
                        KTMovie("Spamtastic"),
                        KTMovie("First Element"),
                        KTMovie("REddit, the movie"),
                        KTMovie("The interview (with a vampire"),
                        KTMovie("A time to kill, everyone")
                )
        )
    }

}

data class KTMovie (val movieName: String) : Movie {
    override fun getName(): String? {
        return movieName
    }
}


