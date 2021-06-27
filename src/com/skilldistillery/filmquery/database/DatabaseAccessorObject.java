package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String sql = "SELECT id, release_year, rating, title, description, language_id FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film(filmResult.getInt("id"), filmResult.getInt("release_year"), filmResult.getString("rating"),
					filmResult.getString("title"), filmResult.getString("description"),
					findLanguageById(filmResult.getInt("language_id")), filmResult.getInt("language_id"),
					findCastById(filmResult.getInt("id")));
		}
		return film;

	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Actor actor = null;
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(actorResult.getInt("id"), actorResult.getString("first_name"),
					actorResult.getString("last_name"));
		}
		return actor;
	}

	@Override
	public List<Actor> findCastById(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		Actor castR = null;
		List<Actor> cast = new ArrayList<>();
		String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ON film.id = film_actor.film_id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet castResult = stmt.executeQuery();
		while (castResult.next()) {
			castR = new Actor(castResult.getInt("id"), castResult.getString("first_name"),
					castResult.getString("last_name"));
			cast.add(castR);

		}
		return cast;
	}

	@Override
	public String findLanguageById(int langId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String lang = null;
		String sql = "SELECT language.name FROM language WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, langId);
		ResultSet langResult = stmt.executeQuery();
		if (langResult.next()) {
			lang = langResult.getString("name");
		}
		return lang;
	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {

		Film film = null;
		List<Film> films = new ArrayList<Film>();
		String sql = "SELECT film.id, release_year, rating, title, description, language_id"
				+ " FROM film JOIN language ON film.language_id = language.id "
				+ " WHERE film.title LIKE ? OR film.description LIKE ?";
		try (Connection conn = DriverManager.getConnection(URL, "student", "student");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet keyResult = stmt.executeQuery();
			while (keyResult.next()) {
				film = new Film(keyResult.getInt("film.id"), keyResult.getInt("release_year"),
						(keyResult.getString("rating")), (keyResult.getString("title")),
						(keyResult.getString("description")), findLanguageById(keyResult.getInt("language_id")),
						keyResult.getInt("language_id"), findCastById(keyResult.getInt("id")));
				films.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

}
