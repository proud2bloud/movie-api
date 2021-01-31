package javalearning.springbootstarter.genre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@RequestMapping("/genres")
	public List<Genre> getAllGenres(){
		return genreService.getAllGenres();
	}
	
	@RequestMapping("/genres/{id}")
	public Optional<Genre> getGenre(@PathVariable String id){
		return genreService.getGenre(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/genres")
	public void addGenre(@RequestBody Genre genre) {
		genreService.addGenre(genre);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/genres/{id}")
	public void updateGenre(@RequestBody Genre genre, @PathVariable String id) {
		genreService.updateGenre(id, genre);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/genres/{id}")
	public void deleteGenre(@PathVariable String id) {
		genreService.deleteGenre(id);
	}
}
