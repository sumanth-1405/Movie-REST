package com.stackroute.keepmovie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.keepmovie.model.Movie;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 */

@Repository
@Transactional
public class MovieDAOImpl implements MovieDAO {

	private SessionFactory sessionFactory;

	public MovieDAOImpl() {

	}

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	public MovieDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveMovie(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.save(movie);
		session.flush();
		return true;

	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteMovie(int movieId) {
		boolean bool = false;
		Session session = sessionFactory.getCurrentSession();
		if (getMovieById(movieId) != null) {
			session.clear();
			session.delete(getMovieById(movieId));
			session.flush();
			bool = true;
		}
		return bool;

	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Movie> getAllMovies() {
		String hql = "FROM Movie movie";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Movie getMovieById(int movieId) {
		Session session = sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		session.flush();
		return movie;

	}

	/* Update existing note */

	public boolean updateMovie(Movie movie) {

		Session session = sessionFactory.getCurrentSession();
			session.clear();
			session.update(movie);
			session.flush();
			return true;
		}

}
