package com.movies.movieguide.favorites;

import com.movies.movieguide.Movie;

import java.util.List;

/**
 * @author arun
 */
public interface FavoritesInteractor
{
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
