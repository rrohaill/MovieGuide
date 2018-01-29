package com.movies.movieguide;

import com.movies.movieguide.details.DetailsComponent;
import com.movies.movieguide.details.DetailsModule;
import com.movies.movieguide.favorites.FavoritesModule;
import com.movies.movieguide.listing.ListingComponent;
import com.movies.movieguide.listing.ListingModule;
import com.movies.movieguide.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
