/*
Simulación de API con Promesas
Objetivo: Crear una función que simule una llamada a una API que tarde en resolver.
Descripción: Crea una función fakeApiCall que devuelva una promesa que se resuelva después de 2 segundos con un objeto de usuario { nombre: 'Juan', edad: 30 }.
Desafío: Usa tanto promesas como async/await para manejar esta función en diferentes escenarios.
*/
function fakeApiCall() {
    return new Promise((resolve) =>{
        setTimeout(()=>{
            resolve({nombre : 'Juan',edad : 30});
        }, 2000);
    });
}
// Usando promesas
fakeApiCall().then((data)=>{
    console.log('Usuario: ', data);
}).catch((error)=>{
    console.log('Error: ',error);
});

// Usando asyncAwait
async function getUserData() {
    try {
        const usuario = await fakeApiCall();
        console.log('Usuario: ', usuario);
    } catch (error) {
        console.log('Error: ', error);
    }
}
getUserData();