package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void displayMenu() {
		System.out.println("**********************************");
		System.out.println("*** Welcome to Quirky Queries! ***");
		System.out.println("**********************************");
		System.out.println("********* Do you want to: ********");
		System.out.println("**********************************");
		System.out.println("****** 1.Search Film by Id *******");
		System.out.println("**********************************");
		System.out.println("***** 2. Search Actor by Id ******");
		System.out.println("**********************************");
		System.out.println("** 3.Search for Film by Keyword **");
		System.out.println("**********************************");
		System.out.println("************ 4.Exit **************");
		System.out.println("**********************************");
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		boolean notExit = true;
		while (notExit) {
			displayMenu();
			int choice = input.nextInt();
			if (choice == 1) {
				startFilmIdInterface1(input);
			} else if (choice == 2) {
				startActorIdInterface2(input);
			} else if (choice == 3) {
				startKeywordInterface3(input);
			} else if (choice == 4) {
				System.out.println("Okay then BuhBye!");
				System.exit(0);
			} else {
				System.out.println("Not a valid selection, try again.");
			}
		}

		input.close();
	}

	private void startFilmIdInterface1(Scanner input) throws SQLException {
		System.out.println("****************************");
		System.out.println("*** Search Films by Id  ****");
		System.out.println("****************************");
		System.out.println("**** Start by entering *****");
		System.out.println("********** Film Id *********");
		System.out.println("****************************");

		int searchId = input.nextInt();
		input.nextLine();
		Film film = db.findFilmById(searchId);

		if (film != null) {
			System.out.println(film);
		} else {
			System.out.println("Not a valid Film Id. Try again.");
		}

	}

	private void startActorIdInterface2(Scanner input) throws SQLException {
		System.out.println("******************************");
		System.out.println("** Search Films by Actor Id **");
		System.out.println("*****************************");
		System.out.println("**** Start by entering ******");
		System.out.println("********** Actor Id **********");
		System.out.println("******************************");

		int actorFilmId = input.nextInt();
		input.nextLine();

		Actor actor = db.findActorById(actorFilmId);
		if (actor != null) {
			System.out.println(actor);
		} else {
			System.out.println("Not a valid Actor Id. Try again.");
		}

	}

	private void startKeywordInterface3(Scanner input) throws SQLException {

		System.out.println("********************************");
		System.out.println("*** Search film by Keyword  ****");
		System.out.println("********************************");
		System.out.println("****** Start by entering: *******");
		System.out.println("********************************");
		System.out.println("*********** Keyword *************");
		System.out.println("********************************");

		input.nextLine();
		String keyword = input.nextLine();
		boolean validSearch = true;
		List<Film> film = db.findFilmByKeyword(keyword);
		if (film.size() != 0) {
			System.out.println(film);
		} else {
			System.out.println("No films match that keyword. Try again.");
		}

	}

}
