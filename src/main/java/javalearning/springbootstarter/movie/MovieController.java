package javalearning.springbootstarter.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javalearning.springbootstarter.genre.Genre;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/genres/{id}/movies")
	public List<Movie> getAllMovies(@PathVariable String id){
		return movieService.getAllMovies(id);
	}
	
	@RequestMapping("/genres/{genreId}/movies/{id}")
	public Optional<Movie> getMovie(@PathVariable String id){
		return movieService.getMovie(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/genres/{genreId}/movies")
	public void addMovie(@RequestBody Movie movie, @PathVariable String genreId) {
		movie.setGenre(new Genre(genreId, "", ""));
		movieService.addMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/genres/{genreId}/movies/{id}")
	public void updateMovie(@RequestBody Movie movie, @PathVariable String genreId, @PathVariable String id) {
		movie.setGenre(new Genre(genreId, "", ""));
		movieService.updateMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/genres/{genreId}/movies/{id}")
	public void deleteMovie(@PathVariable String id) {
		movieService.deleteMovie(id);
	}
}
