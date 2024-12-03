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
    ),
    (
        'Martin Scorsese',
        'American',
        'Known for his works on crime and drama...',
        'Conocido por sus trabajos en crimen y drama...',
        1942,
        NULL
    ),
    (
        'Alejandro González Iñárritu',
        'Mexican',
        'Award-winning director from Mexico...',
        'Director galardonado de México...',
        1963,
        NULL
    ),
    (
        'James Cameron',
        'Canadian',
        'A renowned director of epic films...',
        'Un renombrado director de películas épicas...',
        1954,
        NULL
    ),
    (
        'Greta Gerwig',
        'American',
        'Recognized for her contemporary style...',
        'Reconocida por su estilo contemporáneo...',
        1983,
        NULL
    ),
    (
        'Denis Villeneuve',
        'Canadian',
        'Known for his distinct visual style...',
        'Conocido por su estilo visual distinto...',
        1967,
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
    ),
    (
        'Ryan Gosling',
        'Canadian',
        'Known for his roles in independent films...',
        'Conocido por sus papeles en películas independientes...'
    ),
    (
        'Emma Stone',
        'American',
        'Academy Award-winning actress...',
        'Actriz ganadora del premio de la Academia...'
    ),
    (
        'Brad Pitt',
        'American',
        'Leading actor in Hollywood...',
        'Actor líder en Hollywood...'
    ),
    (
        'Anne Hathaway',
        'American',
        'Known for her versatility...',
        'Conocida por su versatilidad...'
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
        'Película sin clasificación.',
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
    ('Thriller', 'Thriller'),
    ('Comedia', 'Comedy'),
    ('Romance', 'Romance'),
    ('Acción', 'Action'),
    ('Documental', 'Documentary'),
    ('Fantasía', 'Fantasy');

-- Inserciones para la tabla de Películas
-- Inserciones para la tabla de Películas (20 películas en total)
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
        'Parque Jurásico',
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
        'El origen',
        'Inception',
        'A thief who enters the dreams of others...',
        'Un ladrón que entra en los sueños de otros...',
        'inception.jpg',
        3,
        4
    ),
    (
        'MV004',
        'Tiempos violentos',
        'Pulp Fiction',
        'The lives of two hitmen...',
        'Las vidas de dos asesinos...',
        'pulp_fiction.jpg',
        4,
        3
    ),
    (
        'MV005',
        'Perdidos en Tokio',
        'Lost in Translation',
        'Two strangers form a bond...',
        'Dos desconocidos forman un vínculo...',
        'lost_in_translation.jpg',
        5,
        2
    ),
    (
        'MV006',
        'El lobo de Wall Street',
        'The Wolf of Wall Street',
        'The rise and fall of a stockbroker...',
        'El ascenso y caída de un corredor de bolsa...',
        'wolf_wall_street.jpg',
        6,
        4
    ),
    (
        'MV007',
        'Avatar',
        'Avatar',
        'A marine on an alien planet...',
        'Un marine en un planeta alienígena...',
        'avatar.jpg',
        8,
        5
    ),
    (
        'MV008',
        'Duna',
        'Dune',
        'A noble family becomes embroiled in...',
        'Una familia noble se ve envuelta en...',
        'dune.jpg',
        10,
        4
    ),
    (
        'MV009',
        'Birdman',
        'Birdman',
        'A washed-up actor tries to revive his career...',
        'Un actor venido a menos intenta revivir su carrera...',
        'birdman.jpg',
        7,
        3
    ),
    (
        'MV010',
        'La La Land: Una historia de amor',
        'La La Land',
        'A love story between a jazz musician and an aspiring actress...',
        'Una historia de amor entre un músico de jazz y una actriz en ascenso...',
        'la_la_land.jpg',
        9,
        2
    ),
    (
        'MV011',
        'Matrix',
        'The Matrix',
        'A hacker discovers a shocking truth about his reality...',
        'Un hacker descubre una verdad impactante sobre su realidad...',
        'matrix.jpg',
        3,
        4
    ),
    (
        'MV012',
        'Parásitos',
        'Parasite',
        'A poor family schemes to infiltrate a wealthy household...',
        'Una familia pobre trama infiltrarse en una familia rica...',
        'parasite.jpg',
        10,
        4
    ),
    (
        'MV013',
        'Titanic',
        'Titanic',
        'A romance set against the ill-fated voyage of the Titanic...',
        'Un romance ambientado en el fatídico viaje del Titanic...',
        'titanic.jpg',
        8,
        3
    ),
    (
        'MV014',
        'Forrest Gump',
        'Forrest Gump',
        'The story of a man with a kind heart...',
        'La historia de un hombre con un corazón amable...',
        'forrest_gump.jpg',
        1,
        2
    ),
    (
        'MV015',
        'El padrino',
        'The Godfather',
        'The rise of a mafia family in America...',
        'El ascenso de una familia mafiosa en América...',
        'godfather.jpg',
        6,
        5
    ),
    (
        'MV016',
        'Interestelar',
        'Interstellar',
        'A group of astronauts search for a new home for humanity...',
        'Un grupo de astronautas busca un nuevo hogar para la humanidad...',
        'interstellar.jpg',
        3,
        4
    ),
    (
        'MV017',
        'El caballero de la noche',
        'The Dark Knight',
        'Batman faces the Joker in Gotham City...',
        'Batman enfrenta al Joker en Ciudad Gótica...',
        'dark_knight.jpg',
        3,
        4
    ),
    (
        'MV018',
        'Amélie',
        'Amélie',
        'A whimsical French woman sets out to make others happy...',
        'Una mujer francesa extravagante se propone hacer felices a los demás...',
        'amelie.jpg',
        5,
        2
    ),
    (
        'MV019',
        'La lista de Schindler',
        'Schindler\'s List',
        'The story of a man who saved Jews during the Holocaust...',
        'La historia de un hombre que salvó a judíos durante el Holocausto...',
        'schindlers_list.jpg',
        1,
        5
    ),
    (
        'MV020',
        'El viaje de Chihiro',
        'Spirited Away',
        'A young girl enters a magical world ruled by spirits...',
        'Una joven entra en un mundo mágico gobernado por espíritus...',
        'spirited_away.jpg',
        10,
        3
    );

-- Inserciones para la tabla de Relación Películas-Actores
INSERT INTO
    movies_actors (movie_id, actor_id)
VALUES (1, 1),
    (1, 3),
    (2, 2),
    (2, 5),
    (3, 3),
    (3, 4),
    (4, 6),
    (5, 4),
    (6, 9),
    (6, 3),
    (7, 7),
    (8, 10),
    (9, 5),
    (10, 7),
    (10, 8);

-- Inserciones para la tabla de Relación Películas-Géneros
INSERT INTO
    movies_genres (movie_id, genre_id)
VALUES (1, 1),
    (1, 3),
    (2, 2),
    (3, 3),
    (3, 5),
    (4, 5),
    (5, 2),
    (6, 2),
    (6, 8),
    (7, 1),
    (7, 3),
    (8, 3),
    (8, 10),
    (9, 2),
    (9, 5),
    (10, 6),
    (10, 7);