window.onload = function () {
  fetch('http://localhost:8080/movies')
    .then(response => response.json())
    .then(movies => {
      renderMovies(movies);
    })
    .catch(error => console.error('Error al obtener las películas:', error));
};

function renderMovies(movies) {
  const movieList = document.getElementById('movie-list');
  movieList.innerHTML = '';
  movies.forEach(movie => {
    const movieItem = document.createElement('div');
    movieItem.classList.add('movie-item');
    movieItem.innerHTML = `
      <h3>${movie.title_es}</h3>
      <button onclick="findMovieByCode('${movie.code}')">Ver detalles</button>
    `;
    movieList.appendChild(movieItem);
  });
}

function findMovieByCode(code) {
  // Redirigir a la página de detalles de la película - Preguntar a Salva si es así
  window.location.href = `movie-details.html?code=${code}`;
}

