let detailsForm = document.getElementById('destination-details-form');

function handleFormSubmit(event) {
    // Evitamos que se ejecute el formulario
    event.preventDefault();

    // Desestrucuración
    let [name, location, photo, description, ...rest] = event.target.elements;
    let destinationName = name.value;
    let destinationLocation = location.value;
    let destinationPhoto = photo.value;
    let destinationDescription = description.value;

    for (let i = 0; i < detailsForm.length; i++) {
        detailsForm.elements[i].value = "";
    }

    // detailsForm.reset();

    //Crear la tarjeta
    let destCard = createDestinationCard(destinationName, destinationLocation, destinationPhoto, destinationDescription);
    //Obtener el contenedor
    let wishListContainer = document.querySelector('.destination-container');
    //Si no hay hijos, cambiamos el título
    if (wishListContainer.children.length === 0) {
        document.querySelector('.title').innerHTML = "Mi lista de deseos";
    }
    //añadir la tarjeta al contenedor
    wishListContainer.appendChild(destCard);


}
function createDestinationCard(name, location, photoUrl, description) {

    let card = document.createElement('div');
    card.className = 'card';

    let img = document.createElement('img');
    let constantPhotoUrl = 'images/inicio.jpg';
    if (photoUrl.length === 0) {
        img.setAttribute('src', constantPhotoUrl);
    } else {
        img.setAttribute('src', photoUrl);
        img.classList.add('img-pretty');
    }
    card.appendChild(img);

    let cardBody = document.createElement('div');
    cardBody.className = 'card-body';

    let cardTitle = document.createElement('h3');
    cardTitle.innerText = name;
    // Como es un div dentro de otro div, agregamos los hijos
    cardBody.appendChild(cardTitle);

    let cardSubtitle = document.createElement('h4');
    cardSubtitle.innerText = location;
    cardBody.appendChild(cardSubtitle);

    let cardDescription = document.createElement('p');
    cardDescription.innerText = description;
    cardBody.appendChild(cardDescription);

    let deleteBtn = document.createElement('button');
    deleteBtn.innerText = 'Eliminar';
    cardBody.appendChild(deleteBtn);
    deleteBtn.addEventListener('click', function () {
        card.remove();
    });
    card.appendChild(cardBody);

    return card;
}

detailsForm.addEventListener('submit', handleFormSubmit);
