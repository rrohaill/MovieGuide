package com.movies.movieguide.listing;

import com.movies.movieguide.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
public interface MoviesListingInteractor
{
    Observable<List<Movie>> fetchMovies();
}
