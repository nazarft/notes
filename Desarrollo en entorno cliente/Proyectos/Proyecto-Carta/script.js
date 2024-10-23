let imgContainer = document.querySelector('.imagen-comida');
let entrantesLabels = document.querySelectorAll('.entrante-label');
let bebidasLabels = document.querySelectorAll('.bebidas-label');
let bocadillosLabels = document.querySelectorAll('.bocadillo-label');
let totalDiv = document.querySelector('.total-span');

function sumCheckedValues() {
    const radios = Array.from(document.querySelectorAll('input[type = "radio"]:checked'));
    return radios.reduce((total, radio) => {
        return total + Number(radio.value);
    }, 0);
}
function actualizarTotal() {
    let total = sumCheckedValues();
    totalDiv.textContent = `Total: ${total} euros`;
}
function asignarEventos(labels, categoria) {

    labels.forEach(label => {
        let input = label.querySelector('input[type="radio"]');
        label.addEventListener('mouseover', () => {
            imgContainer.src = `img/${categoria}/${label.dataset.precio}.png`;
        });
        input.addEventListener('change', () => {
            actualizarTotal();
        });
    });
}

asignarEventos(entrantesLabels, 'entrantes');
asignarEventos(bocadillosLabels, 'bocadillos');
asignarEventos(bebidasLabels, 'bebidas');

