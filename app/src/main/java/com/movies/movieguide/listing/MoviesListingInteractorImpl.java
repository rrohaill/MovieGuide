package com.movies.movieguide.listing;

import com.movies.movieguide.Movie;
import com.movies.movieguide.MoviesWraper;
import com.movies.movieguide.favorites.FavoritesInteractor;
import com.movies.movieguide.listing.sorting.SortType;
import com.movies.movieguide.listing.sorting.SortingOptionStore;
import com.movies.movieguide.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author arun
 */
class MoviesListingInteractorImpl implements MoviesListingInteractor {
    private FavoritesInteractor favoritesInteractor;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;

    MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                TmdbWebService tmdbWebService, SortingOptionStore store) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
    }

    @Override
    public Observable<List<Movie>> fetchMovies() {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            return tmdbWebService.popularMovies().map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies().map(MoviesWraper::getMovieList);
        } else {
            return Observable.just(favoritesInteractor.getFavorites());
        }
    }

}
