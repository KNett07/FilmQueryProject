package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws SQLException;
  public Actor findActorById(int actorId) throws SQLException;
//List<Actor> findActorsByFilmId(Actor filmActor);
List<Film> findFilmByKeyword(String keyword);
String findLanguageById(int langId) throws SQLException;
List<Actor> findCastById(int castId) throws SQLException;
}
