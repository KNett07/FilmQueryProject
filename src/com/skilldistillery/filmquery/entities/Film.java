package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	
	private int id;
	private int releaseYear;
	private String rating;
	private String title;
	private String description;
	private String language;
	private int languageId;
	private List<Actor> actors;
	
	
	
	
	public Film(int id, int releaseYear, String rating, String title, String description, String language,
			int languageId, List<Actor> actors) {
		super();
		this.id = id;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.title = title;
		this.description = description;
		this.language = language;
		this.languageId = languageId;
		this.actors = actors;
	}
	
	
	
	public Film(int id, int releaseYear, String rating, String title, String description, int languageId) {
		super();
		this.id = id;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.title = title;
		this.description = description;
		this.languageId = languageId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + languageId;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageId != other.languageId)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return ("\t **Film Id=" + id) + "\n" + ("Release Year=" + releaseYear) + "\n" + ("Rating=" + rating) + "\n" + ("Title=" + title)
				+ "\n" + ("Description=" + description) + "\n" +("Language=" + language) + "\n" + ("Actors="
				+ actors) + "\n **************** \n";
	}
	
	

	
	

	

	
}
