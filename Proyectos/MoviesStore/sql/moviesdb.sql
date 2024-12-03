DROP DATABASE IF EXISTS peliculas_db;

CREATE DATABASE peliculas_db;

USE peliculas_db;

-- Tabla de Directores
CREATE TABLE director (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(100),
    biography_en TEXT,
    biography_es TEXT,
    birth_year INT,
    death_year INT
);

-- Tabla de Actores
CREATE TABLE actors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(100),
    biography_en TEXT,
    biography_es TEXT
);

-- Tabla de Ratings
CREATE TABLE ContentRatings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rating VARCHAR(10) NOT NULL,
    description TEXT NOT NULL,
    isViolent BOOLEAN NOT NULL DEFAULT false,
    isAdult BOOLEAN NOT NULL DEFAULT false
);

-- Tabla de Géneros
CREATE TABLE genres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name_es VARCHAR(100) NOT NULL,
    name_en VARCHAR(100) NOT NULL
);

-- Tabla de Películas
CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(100) NOT NULL,
    title_es VARCHAR(255) NOT NULL,
    title_en VARCHAR(255) NOT NULL,
    synopsis_en TEXT,
    synopsis_es TEXT,
    image VARCHAR(255),
    contentRating_id INT,
    director_id INT,
    FOREIGN KEY (contentRating_id) REFERENCES ContentRatings (id),
    FOREIGN KEY (director_id) REFERENCES director (id)
);

-- Tabla de Relación entre Películas y Actores
CREATE TABLE movies_actors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    actor_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (actor_id) REFERENCES actors (id)
);

-- Tabla de Relación entre Películas y Géneros
CREATE TABLE movies_genres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
    genre_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);