package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	
	private int id;
	private int rating;
	private String title;
	private String description;
	private String languageId;
	private List<Actor> films;

	
	public Film(int id, int rating, String title, String description, String languageId) {
		super();
		this.id = id;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
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

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", rating=" + rating + ", title=" + title + ", description=" + description
				+ ", languageId=" + languageId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((languageId == null) ? 0 : languageId.hashCode());
		result = prime * result + rating;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		if (rating != other.rating)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public List<Actor> getFilms() {
		return films;
	}

	public void setFilms(List<Actor> films) {
		this.films = films;
	}
	

	
}
