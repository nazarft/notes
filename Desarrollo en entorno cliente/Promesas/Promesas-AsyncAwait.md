Las promesas y async/await son dos enfoques en JavaScript para manejar operaciones asíncronas. Aunque ambos se utilizan para trabajar con tareas que no se completan de inmediato (como llamadas a APIs, temporizadores, etc.), hay diferencias en cómo se usan y se leen.

# Promesas
Las promesas representan un valor que puede estar disponible ahora, en el futuro o nunca. Se utilizan con los métodos .then() y .catch() para manejar el éxito o el error de una operación asíncrona.
```javascript
function obtenerDatos() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const exito = true; // Simula una respuesta exitosa o fallida
            if (exito) {
                resolve("Datos obtenidos con éxito");
            } else {
                reject("Error al obtener los datos");
            }
        }, 2000);
    });
}

// Uso de la promesa
obtenerDatos()
    .then((resultado) => {
        console.log(resultado); // "Datos obtenidos con éxito"
    })
    .catch((error) => {
        console.log(error); // Si falla: "Error al obtener los datos"
    });
```
En este ejemplo, la función obtenerDatos() retorna una promesa que después de 2 segundos se resuelve con éxito o falla. Usamos .then() para manejar el resultado exitoso y .catch() para manejar cualquier error.

# Async/Await
async/await es una sintaxis que hace que el código asíncrono sea más fácil de leer y parezca más secuencial. En lugar de usar .then() y .catch(), usamos las palabras clave await y try/catch para manejar las promesas.

```javascript
async function obtenerDatosAsync() {
    try {
        const resultado = await obtenerDatos();  // Pausa hasta que la promesa se resuelva
        console.log(resultado);  // "Datos obtenidos con éxito"
    } catch (error) {
        console.log(error);  // Si falla: "Error al obtener los datos"
    }
}

obtenerDatosAsync();
```
Aquí, obtenerDatosAsync() es una función asíncrona. Cuando llamamos a await obtenerDatos(), JavaScript espera (pausa) hasta que la promesa de obtenerDatos() se resuelva o rechace, y el flujo de código parece secuencial. Los errores se manejan con un bloque try/catch.

<img width="756" alt="image" src="https://github.com/user-attachments/assets/6085fe4f-9824-4ddf-8f0d-5175650b9176">
# Conclusión

* Promesas son más útiles cuando manejas operaciones que pueden suceder en paralelo o cuando necesitas más control sobre el flujo asíncrono.
* Async/Await ofrece una forma más simple y legible de trabajar con código asíncrono, especialmente cuando el flujo de operaciones es secuencial.
