package com.movies.movieguide.listing;

import com.movies.movieguide.Movie;
import com.movies.movieguide.RxSchedulerRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author arunsasidharan
 */
@RunWith(MockitoJUnitRunner.class)
public class MoviesListingPresenterImplTest {
    @Rule
    public RxSchedulerRule rule = new RxSchedulerRule();
    @Mock
    private MoviesListingInteractor interactor;
    @Mock
    private MoviesListingView view;
    @Mock
    private List<Movie> movies;

    private MoviesListingPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MoviesListingPresenterImpl(interactor);
    }

    @After
    public void teardown() {
        presenter.destroy();
    }

    @Test
    public void shouldBeAbleToDisplayMovies() {
        // given:
        Observable<List<Movie>> responseObservable = Observable.just(movies);
        when(interactor.fetchMovies()).thenReturn(responseObservable);

        // when:
        presenter.setView(view);

        // then:
        verify(view).showMovies(movies);
    }
}