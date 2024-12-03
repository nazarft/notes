package com.fpmislata.MoviesStore.persistence.dao.jdbc;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.domain.model.Genre;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.persistence.dao.ActorDao;
import com.fpmislata.MoviesStore.persistence.dao.GenreDao;
import com.fpmislata.MoviesStore.persistence.dao.MovieDao;
import com.fpmislata.MoviesStore.persistence.impl.mapper.MovieRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovieDaoImpl implements MovieDao {
    private final JdbcTemplate jdbcTemplate;
    private final ActorDao actorDao;
    private final GenreDao genreDao;
    @Override
    public List<Movie> getAll(int page, int size) {
        String sql = "SELECT * FROM movies LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new MovieRowMapper(),size, page * size);
    }

    @Override
    public Optional<Movie> findByCode(String code) {
        String sql = """
                SELECT * FROM movies 
                INNER JOIN director ON movies.director_id = director.id
                INNER JOIN ContentRatings ON movies.contentRating_id = ContentRatings.id
                WHERE code = ?
                """;
        try{
            Movie movie = jdbcTemplate.queryForObject(sql, new MovieRowMapper(), code);
            movie.setActors(actorDao.getByMovieId(movie.getId()));
            movie.setGenres(genreDao.getByMovieId(movie.getId()));
            return Optional.ofNullable(movie);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Movie> findById(Long id) {
        String sql = """
                SELECT * FROM movies 
                INNER JOIN director ON movies.director_id = director.id
                INNER JOIN ContentRatings ON movies.contentRating_id = ContentRatings.id
                WHERE code = ?
                """;
        try{
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new MovieRowMapper(), id));
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public int count() {
        String sql = "SELECT COUNT(*) FROM movies";
        return jdbcTemplate.queryForObject(sql, Integer.class);

    }

    @Override
    public void save(Movie movie) {
        if(movie.getId() != null){
            this.update(movie);
        } else {
            long id = this.insert(movie);
            movie.setId(id);
        }
        this.deleteActors(movie.getId());
        this.insertActors(movie.getId(), movie.getActors());
        this.deleteGenres(movie.getId());
        this.insertGenres(movie.getId(), movie.getGenres());
    }

    @Override
    public void update(Movie movie) {
        String sql = """
                    UPDATE movies
                    SET code = ?,
                        title_es = ?,
                        title_en = ?,
                        synopsis_es = ?,
                        synopsis_en = ?,
                        image = ?,
                        contentRating_id = ?,
                        director_id = ?
                    WHERE id = ?
                """;
        jdbcTemplate.update(
                sql,
                movie.getCode(),
                movie.getTitle_es(),
                movie.getTitle_en(),
                movie.getSynopsis_es(),
                movie.getSynopsis_en(),
                movie.getImage(),
                movie.getContentRating().getId(),
                movie.getDirector().getId(),
                movie.getId()
        );

    }

    @Override
    public void delete(Long id) {
        this.deleteActors(id);
        this.deleteGenres(id);
        String sql = "DELETE FROM movies WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public long insert(Movie movie) {
        String sql = """
                INSERT INTO movies (code, 
                title_es, 
                title_en, 
                synopsis_es, 
                synopsis_en,
                image,
                contentRating_id,
                director_id)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
                    preparedStatement.setString(1, movie.getCode());
                    preparedStatement.setString(2, movie.getTitle_es());
                    preparedStatement.setString(3, movie.getTitle_en());
                    preparedStatement.setString(4, movie.getSynopsis_es());
                    preparedStatement.setString(5, movie.getSynopsis_en());
                    preparedStatement.setString(6, movie.getImage());
                    preparedStatement.setLong(7, movie.getContentRating().getId());
                    preparedStatement.setLong(8, movie.getDirector().getId());
                    return preparedStatement;
                }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void insertActors(Long idMovie, List<Actor> actors) {
        String sql = """
                INSERT INTO movies_actors (movie_id, actor_id)
                VALUES (?, ?)
                """;
        actors.forEach(actor -> {
            jdbcTemplate.update(sql, idMovie, actor.getId());
        });

    }

    @Override
    public void deleteActors(Long idMovie) {
        String sql = "DELETE FROM movies_actors WHERE movie_id = ?";
        jdbcTemplate.update(sql, idMovie);

    }

    @Override
    public void insertGenres(Long idMovie, List<Genre> genres) {
        String sql = """
                INSERT INTO movies_genres (movie_id, genre_id)
                VALUES (?, ?)
                """;
        genres.forEach(genre -> {
            jdbcTemplate.update(sql, idMovie, genre.getId());
        });

    }

    @Override
    public void deleteGenres(Long idMovie) {
        String sql = "DELETE FROM movies_genres WHERE movie_id = ?";
        jdbcTemplate.update(sql, idMovie);
    }
}
