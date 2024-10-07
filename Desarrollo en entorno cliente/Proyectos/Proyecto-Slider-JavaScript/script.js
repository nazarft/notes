let myImages = ["image1.jpg", "image2.jpg", "image3.jpg"];
// Al hacer el slider indico que la imagen actual es la primera, asi que el valor de currentImage es 0
let currentImage = 0;
let container = document.querySelector('.content');
let nextBtn = document.getElementById('next');
let prevBtn = document.getElementById('previous');

nextBtn.addEventListener('click', () => {
    currentImage++;
    if (currentImage > myImages.length - 1) { currentImage = 0; }

    // Creo un nuevo elemento imagen
    let newSlide = document.createElement('img');
    // Añado la imagen correspondiente al elemento imagen
    newSlide.src = `slides/${myImages[currentImage]}`;
    // Añado la clase fadeinimg al elemento imagen
    newSlide.className = 'fadeinimg';
    // Añade la nueva imagen al contenedor
    container.appendChild(newSlide);

    if (container.children.length > 2) {
        // Elimino la primera imagen
        container.removeChild(container.children[0]);
        // Asi no se acumulan las imagenes en el contenedor
    }
});
prevBtn.addEventListener('click', () => {
    currentImage--;
    if (currentImage < 0) { currentImage = myImages.length - 1; }

    let newSlide = document.createElement('img');
    newSlide.src = `slides/${myImages[currentImage]}`;
    newSlide.className = 'fadeinimg';
    container.appendChild(newSlide);

    if (container.children.length > 2) {
        container.removeChild(container.children[0]);
    }
});
