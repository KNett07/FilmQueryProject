package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Film film = null;
		String sql = "SELECT id, rating, title, description, language_id FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film(filmResult.getInt("id"), filmResult.getInt("rating"), filmResult.getString("title"),
					filmResult.getString("description"), filmResult.getString("language id"));
		}
		return film;

	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Actor actor = null;
		// ...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(actorResult.getInt("id"), actorResult.getString("first_name"), actorResult.getString("last_name"));
		}
		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
//	String user = "student";
//	String pass = "student";
//	Connection conn = DriverManager.getConnection(URL, user, pass);
//	 Film film = null;
//	  String sql = "SELECT id FROM film WHERE id = ?";
//	  PreparedStatement stmt = conn.prepareStatement(sql);
//	  stmt.setInt(1,id);
//	  ResultSet filmResult = stmt.executeQuery();
//	  if (filmResult.next()) {
//	    film = new Film(); // Create the object
//	    // Here is our mapping of query columns to our object fields:
//	    film.setId(filmResult.getInt("id"));
//	    film.setRating(filmResult.getInt("rating"));
//	    film.setTitle(filmResult.getString("title"));
//	    film.setLanguage(filmResult.getString("language"));
//	  }
//	  return film;
		return null;
	}

}
