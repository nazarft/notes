let elegirPokemon = prompt('Di el nombre de un pokemón o un número');
const pokeApi = `https://pokeapi.co/api/v2/pokemon/${elegirPokemon}`;
const div = document.querySelector('.pokemon');
fetch(pokeApi)
    .then(json => json.json())
    .then(data => {
        div.innerHTML = `
        <p> Hola soy ${data.name} </p>
        <img src = ${data.sprites.front_default}>
        `
    })