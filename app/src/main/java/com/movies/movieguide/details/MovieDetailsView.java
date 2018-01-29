package com.movies.movieguide.details;

import com.movies.movieguide.Movie;
import com.movies.movieguide.Review;
import com.movies.movieguide.Video;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
