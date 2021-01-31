
package javalearning.springbootstarter.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovies(String genreId){
		List<Movie> movies = new ArrayList<>();
		movieRepository.findByGenreId(genreId)
		.forEach(movies::add);
		return movies;
	}
	
	public Optional<Movie> getMovie(String id) {
		return movieRepository.findById(id);
	}
	
	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void deleteMovie(String id) {
		movieRepository.deleteById(id);
	}

}
