# Capa de presentación 

La capa de presentación en una arquitectura por capas se encarga de gestionar la interacción del usuario con la aplicación.
Aquí se implementan los controladores que definen los endpoints de la API y, opcionalmente, la lógica de validación básica de las solicitudes.
Esta capa debe ser lo más independiente posible de la lógica de negocio y la persistencia. Se comunica con la capa de dominio o de aplicación para ejecutar los casos de uso requeridos, devolviendo al usuario las respuestas en el formato adecuado (como JSON o HTML). 
También puede encargarse del manejo de excepciones y la validación básica de los datos de entrada.

## Endpoints 

En el desarrollo de APIs, es una buena práctica organizar y estructurar los endpoints para que sean intuitivos y fáciles de mantener. 
Un cambio común es añadir un prefijo como /api a las rutas, lo que ayuda a distinguir los recursos de la API del resto de las rutas que puede tener la aplicación. 
En nuestro caso, pasaremos de localhost:8080/books a localhost:8080/api/books, lo que mejora la claridad al indicar que estas rutas pertenecen a la API de la aplicación.
Este enfoque es útil para proyectos que combinan API y otros tipos de recursos, como páginas web o servicios estáticos, ya que permite tener una estructura más limpia y comprensible.
```java
@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {
 
    public static final String URL = "/api/books";
```

## Modelos de la capa de presentación

En la capa de presentación a veces es mas conveniente crear varios modelos diferentes de la capa de dominio para adaptarse a distintas necesidades por parte del usuario.
Por ejemplo:

* Para el findAll: podemos devolver un listado de libros con únicamente isbn, title, price, discount y cover.
Aquí podríamos crear un modelo de presentación simplificado que contenga solo estos campos.
* Para el findByIsbn: al tratarse de los detalles del libro podemos usar un modelo completo
que incluya toda la información relevante que contenga todos los atributos del libro, incluyendo sinopsis, editoriales, categorías, autores y géneros.
Además, en el mismo listado, puede que sólo necesitemos el atributo nombre de un modelo asociado (como categoria), sin necesidad de devolver más datos adicionales.

El resultado que buscamos es el siguiente:

```java
[
  {
    "isbn": "9780142424179",
    "title": "El principito",
    "price": 15.99,
    "discount": 0,
    "cover": "9780142424179.jpg"
  },
  {
    "isbn": "9780142410363",
    "title": "Matilda",
    "price": 14.99,
    "discount": 0,
    "cover": "9780142410363.jpg"
  },
  {
    "isbn": "9780142418222",
    "title": "Charlie y la fábrica de chocolate",
    "price": 13.99,
    "discount": 0,
    "cover": "9780142418222.jpg"
  },
  ...
```
Y para los detalles: 
```java
{
  "isbn": "9780060557912",
  "title": "Buenos presagios",
  "price": 16.99,
  "discount": 0,
  "synopsis": "Buenos presagios cuenta la historia de un ángel y un demonio ...",
  "cover": "9780060557912.jpg",
  "genres": [
    "Fantasía"
  ],
  "category": "recomendados",
  "publisher": {
    "id": 5,
    "name": "Alfaguara"
  },
  "authors": [
    {
      "id": 3,
      "name": "Maurice Sendak"
    },
    {
      "id": 4,
      "name": "C.S. Lewis"
    }
  ]
}
```

Si te fijas en la respuesta anterior, la categoría es una cadena de texto, mientras que la editorial (publisher) contiene el id y el nombre. 
Además, mientras que el array authors está compuesto por el id y nombre de los autores, los géneros son un array de nombres.

En nuestro caso, dividiremos los modelos en dos tipos: *Collection* y *Detail*, cada uno destinado a un propósito específico. 
Los modelos **Collection** se utilizarán para representar listados de recursos, mientras que los modelos **Detail** ofrecerán información detallada sobre un recurso individual.

Para lograr esto de una manera eficiente, haremos uso de los **Records** en Java que nos permite nos permiten crear clases inmutables de manera concisa, 
ideales para representar estos modelos sin la sobrecarga de escribir código repetitivo como getters, setters o constructores.

Los crearemos en la carpeta **controller/webModel**.

Así, los modelos de la capa controlador serían:

```java
public record AuthorCollection(
        long id,
        String name
) {
}
```
```java
public record PublisherCollection(
        long id,
        String name
) {
}
```
```java
public record BookCollection (
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String cover
) { }
```
```java
public record BookDetail(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String synopsis,
        String cover,
        List<String> genres,
        String category,
        @JsonProperty("publisher") PublisherCollection publisherCollection,
        @JsonProperty("authors") List<AuthorCollection> authorsCollection
) {
}
```
Para las categorías y géneros no necesitamos crear modelos.
La anotación @JsonProperty se utiliza para personalizar el nombre de los campos cuando no coinciden
lo que puede ser útil en la capa de presentación para ajustar el formato de los datos enviados al cliente.

En el ejemplo de BookDetail, utilizamos **@JsonProperty** para definir el nombre que los campos publisherCollection y authorsCollection tendrán en el JSON que se envía en la respuesta.
Aunque los atributos en el modelo son publisherCollection y authorsCollection, en la respuesta JSON aparecerán como publisher y authors, respectivamente.


