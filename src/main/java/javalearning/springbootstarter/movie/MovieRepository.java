package javalearning.springbootstarter.movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface MovieRepository extends CrudRepository<Movie, String> {

	public List<Movie> findByGenreId(String genreId);

}
