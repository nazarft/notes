-- Inserciones para la tabla de Directores
INSERT INTO
    director (
        name,
        nationality,
        biography_en,
        biography_es,
        birth_year,
        death_year
    )
VALUES (
        'Steven Spielberg',
        'American',
        'A famous American filmmaker...',
        'Un famoso cineasta estadounidense...',
        1946,
        NULL
    ),
    (
        'Pedro Almodóvar',
        'Spanish',
        'A renowned Spanish director...',
        'Un renombrado director español...',
        1949,
        NULL
    ),
    (
        'Christopher Nolan',
        'British',
        'An influential British director...',
        'Un influyente director británico...',
        1970,
        NULL
    ),
    (
        'Quentin Tarantino',
        'American',
        'A director known for his unconventional storytelling...',
        'Un director conocido por sus narrativas poco convencionales...',
        1963,
        NULL
    ),
    (
        'Sofia Coppola',
        'American',
        'A filmmaker recognized for her unique style...',
        'Una cineasta reconocida por su estilo único...',
        1971,
        NULL
    );

-- Inserciones para la tabla de Actores
INSERT INTO
    actors (
        name,
        nationality,
        biography_en,
        biography_es
    )
VALUES (
        'Tom Hanks',
        'American',
        'An award-winning American actor...',
        'Un galardonado actor estadounidense...'
    ),
    (
        'Penélope Cruz',
        'Spanish',
        'A popular Spanish actress...',
        'Una popular actriz española...'
    ),
    (
        'Leonardo DiCaprio',
        'American',
        'A leading actor of his generation...',
        'Un actor destacado de su generación...'
    ),
    (
        'Scarlett Johansson',
        'American',
        'A versatile actress known for her roles in...',
        'Una actriz versátil conocida por sus roles en...'
    ),
    (
        'Javier Bardem',
        'Spanish',
        'A Spanish actor known for his intense performances...',
        'Un actor español conocido por sus interpretaciones intensas...'
    ),
    (
        'Natalie Portman',
        'American-Israeli',
        'An actress recognized for her diverse roles...',
        'Una actriz reconocida por sus roles diversos...'
    );

-- Inserciones para la tabla de Categorías
INSERT INTO
    ContentRatings (
        rating,
        description,
        isViolent,
        isAdult
    )
VALUES (
        'G',
        'Apropiado para todas las edades, sin contenido inapropiado.',
        false,
        false
    ),
    (
        'PG',
        'Puede contener algunas situaciones que podrían no ser adecuadas para niños.',
        false,
        false
    ),
    (
        'PG-13',
        'Contenido que puede no ser adecuado para niños menores de 13 años.',
        false,
        false
    ),
    (
        'R',
        'Contenido para adultos: incluye violencia, lenguaje fuerte y/o situaciones sexuales.',
        true,
        true
    ),
    (
        'NC-17',
        'Contenido explícito para adultos, incluyendo violencia extrema y/o sexo.',
        true,
        true
    ),
    (
        'Unrated',
        'Película sin clasificación, a menudo por estar en proceso de revisión.',
        false,
        false
    );

-- Inserciones para la tabla de Géneros
INSERT INTO
    genres (name_es, name_en)
VALUES ('Aventura', 'Adventure'),
    ('Drama', 'Drama'),
    (
        'Ciencia Ficción',
        'Science Fiction'
    ),
    ('Terror', 'Horror'),
    ('Thriller', 'Thriller');

-- Inserciones para la tabla de Películas
INSERT INTO
    movies (
        code,
        title_es,
        title_en,
        synopsis_en,
        synopsis_es,
        image,
        director_id,
        contentRating_id
    )
VALUES (
        'MV001',
        'Jurassic Park',
        'Jurassic Park',
        'A theme park suffers...',
        'Un parque temático sufre...',
        'jurassic_park.jpg',
        1,
        5
    ),
    (
        'MV002',
        'Todo sobre mi madre',
        'All About My Mother',
        'A nurse gets involved...',
        'Una enfermera se involucra...',
        'todo_sobre_mi_madre.jpg',
        2,
        3
    ),
    (
        'MV003',
        'Inception',
        'Inception',
        'A thief who enters the dreams of others...',
        'Un ladrón que entra en los sueños de otros...',
        'inception.jpg',
        3,
        4
    ),
    (
        'MV004',
        'Pulp Fiction',
        'Pulp Fiction',
        'The lives of two hitmen...',
        'Las vidas de dos asesinos...',
        'pulp_fiction.jpg',
        4,
        3
    ),
    (
        'MV005',
        'Lost in Translation',
        'Lost in Translation',
        'Two strangers form a bond...',
        'Dos desconocidos forman un vínculo...',
        'lost_in_translation.jpg',
        5,
        2
    );

-- Inserciones para la tabla de Relación Películas-Actores
INSERT INTO
    movies_actors (movie_id, actor_id)
VALUES (1, 1), -- Tom Hanks en Jurassic Park (ficticio)
    (1, 3), -- Leonardo DiCaprio en Jurassic Park (ficticio)
    (2, 2), -- Penélope Cruz en Todo sobre mi madre
    (2, 5), -- Javier Bardem en Todo sobre mi madre (ficticio)
    (3, 3), -- Leonardo DiCaprio en Inception
    (3, 4), -- Scarlett Johansson en Inception (ficticio)
    (4, 6), -- Natalie Portman en Pulp Fiction (ficticio)
    (5, 4);
-- Scarlett Johansson en Lost in Translation
-- Inserciones para la tabla de Relación Películas-Géneros
INSERT INTO
    movies_genres (movie_id, genre_id)
VALUES (1, 1), -- Jurassic Park es Aventura
    (1, 3), -- Jurassic Park es Ciencia Ficción
    (2, 2), -- Todo sobre mi madre es Drama
    (3, 3), -- Inception es Ciencia Ficción
    (3, 5), -- Inception es Thriller
    (4, 5), -- Pulp Fiction es Thriller
    (5, 2);
-- Lost in Translation es Drama