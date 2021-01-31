package javalearning.springbootstarter.movie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javalearning.springbootstarter.genre.Genre;

@Entity
public class Movie {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	@ManyToOne
	private Genre genre;
	
	public Movie() {
		
	}
	public Movie(String id, String name, String description, String genreId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.genre = new Genre(genreId, "", "");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
}
