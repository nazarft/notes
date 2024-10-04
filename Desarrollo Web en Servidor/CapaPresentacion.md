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

### Records

En nuestro caso, dividiremos los modelos en dos tipos: *Collection* y *Detail*, cada uno destinado a un propósito específico. 
Los modelos **Collection** se utilizarán para representar listados de recursos, mientras que los modelos **Detail** ofrecerán información detallada sobre un recurso individual.

🔴 Los records son una clase inmutable que se utiliza para almacenar datos.

🔴 Crea un constructor, getters y métodos equals, hashCode y toString (con todos los campos).

🔴 No tiene setters.

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

En el ejemplo de BookDetail, utilizamos **@JsonProperty** para definir el nombre que los campos publisherCollection y authorsCollection tendrán en el JSON que se envía en la respuesta.
Aunque los atributos en el modelo son publisherCollection y authorsCollection, en la respuesta JSON aparecerán como publisher y authors, respectivamente.

## JSONProperty

**@JsonProperty** en Java se usa para indicar cómo se debe mapear una propiedad de un objeto durante la serialización y deserialización con bibliotecas como Jackson. Específicamente:

 * Serialización: Cuando conviertes un objeto Java a JSON, @JsonProperty permite definir el nombre que tendrá esa propiedad en el JSON.
 * Deserialización: Al convertir un JSON a un objeto Java, @JsonProperty indica qué campo del JSON debe mapearse a qué propiedad del objeto Java.
```java
public class Persona {
    @JsonProperty("nombre_completo")
    private String nombre;
}
```
En este caso, la propiedad nombre de la clase Persona se serializará y deserializará usando el nombre "nombre_completo" en el JSON que es lo que finalmente se mostrará en el JSON.

## Mapeadores

Podemos usar *MapStruct* para mapear las capas de dominio a las capas de controlador.
En resumen, es un framework de mapeo que genera el código necesario para la conversión
Para usarlo, añadimos estas dos dependencias:
```java
<dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct</artifactId>
			<version>${org.mapstruct.version}</version>
		</dependency>
```
🔴 **IMPORTANTE** -> Añadir la siguiente dependencia si usas Lombok y evitar conflictos:
```java
<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok-mapstruct-binding</artifactId>
			<version>0.2.0</version>
			<scope>provided</scope>
		</dependency>
```
## Usos de MapStruct

MapStruct es una herramienta de mapeo que genera el código de mapeo entre objetos en tiempo de compilación.
Funciona definiendo interfaces que describen los métodos de mapeo, y genera las implementaciones basadas en esas definiciones.

Por ejemplo vamos a crear AuthorMapper, que será una interfaz que MapStruct utilizará para generar el código que convierte un objeto Author del dominio en un objeto AuthorCollection de la capa de presentación:

```java
@Mapper
public interface AuthorMapper {
 
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
 
    AuthorCollection toAuthorCollection(Author author);
}
```
🔴 **@Mapper**: Indica que esta interfaz es un mapeador.

🔴 INSTANCE: Es una instancia Singleton que MapStruct crea automáticamente

🔴 toAuthorCollection(Author author): Declara un método que convierte un objeto de tipo Author a un objeto de tipo AuthorCollection y MapStruct generará el código necesario para implementar este método, realizando la conversión automáticamente.

Un detalle IMPORTANTE es que si no usamos Lombok será importante que los objetos que participan
en el mapeo tengan:

1. Constructor vacío:

Debes proporcionar un constructor sin parámetros en las clases. Esto permite que MapStruct cree nuevas instancias de las clases durante el proceso de mapeo.

2. Métodos getters y setters:

Necesitas tener métodos get y set para cada atributo. Esto permite a MapStruct acceder a los campos de los objetos y modificarlos según sea necesario durante la conversión.

🔴 Ejemplo

Supongamos que tienes dos clases: Author (capa de dominio) y AuthorCollection (capa de presentación):
```java
public class Author {
    private String name;
    private String email;

    // Constructor vacío
    public Author() {
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```
```java
public class AuthorCollection {
    private String fullName;
    private String emailAddress;

    // Constructor vacío
    public AuthorCollection() {
    }

    // Getters y Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
```
Con las clases definidas de esta manera, MapStruct puede convertir un objeto Author en un objeto AuthorCollection:
### Proceso de Mapeo
1. Creación de Objetos:

Cuando llamas a toAuthorCollection y pasas un objeto Author, MapStruct crea una nueva instancia de AuthorCollection usando el constructor vacío.

2. Acceso a Atributos:

MapStruct utiliza los métodos getters de Author para obtener los valores de name y email.

3. Asignación de Valores:

Luego, usa los métodos setters de AuthorCollection para asignar esos valores a fullName y emailAddress en el nuevo objeto.

```java Author author = new Author();
author.setName("Juan Pérez");
author.setEmail("juan.perez@example.com");

AuthorCollection authorCollection = AuthorMapper.INSTANCE.toAuthorCollection(author);

// Ahora authorCollection tendrá:
// fullName = "Juan Pérez"
// emailAddress = "juan.perez@example.com"
```
⚠️ Los atributos en las clases que se están mapeando deben ser idénticos para que MapStruct funcione correctamente
Si no son idénticos, debemos usar la notación **@Mapping** para especificar como debe ser el mapeo.

Por ejemplo, si el atributo en la clase Author se llamara fullName y en AuthorCollection se llamara name, podemos definir el mapeo así:

```java
@Mapping(source = "fullName", target = "name")
AuthorCollection toAuthorCollection(Author author);
```
👉 source: Propiedad de la clase de origen de la que se obtendrá el valor.

👉 target: Propiedad de la clase de destino donde se establecerá el valor.

### Métodos de conversión personalizados

Hay un caso especial con la base de datos **bookstore**.
En el caso del GenreMapper, el objetivo es convertir una lista de objetos Genre en una lista de cadenas (List<String>), donde cada cadena representa el nombre del género. Para lograr esto, podemos utilizar tanto métodos de mapeo directos como un método de conversión personalizado:

```java
@Mapper
public interface GenreMapper {
 
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);
 
    List<String> toGenreNameList(List<Genre> genres);
 
    default String toGenreName(Genre genre) {
        return genre.getName();
    }
}
```
👉 toGenreNameList(List<Genre> genres): Este método se encarga de mapear una lista de objetos Genre a una lista de String ya que como únicamente necesita el nombre del género, hace un *genre.getName()*. 

👉 default String toGenreName(Genre genre): Este es un método de conversión personalizado que permite extraer el nombre del género de un objeto Genre. Al ser un método default, se puede implementar directamente en la interfaz, y MapStruct lo utilizará automáticamente cuando realice la conversión de la lista.

👀 Cómo Funciona el Mapeo
1. Llamada al Método: Si llamas al método toGenreNameList y le pasas una lista de objetos Genre, MapStruct comenzará el proceso de conversión.

2. Iteración sobre la Lista: MapStruct recorrerá cada elemento de la lista de Genre.

3. Uso del Método toGenreName: Para cada objeto Genre, MapStruct invocará el método toGenreName, que extraerá el nombre utilizando genre.getName().

4. Construcción de la Lista de Nombres: Todos los nombres extraídos se recogerán en una nueva lista de String, que será el resultado del método toGenreNameList.

### Usar varios mapeadores a la vez y notación @Mapping 

Para el caso de BookMapper:
```java
@Mapper(uses = {PublisherMapper.class, AuthorMapper.class, GenreMapper.class})
public interface BookMapper {
 
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
 
    BookCollection toBookCollection(Book book);
 
    @Mapping(target ="publisherCollection", source = "publisher")
    @Mapping(target="authorsCollection", source = "authors")
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "genres", source = "genres")
    BookDetail toBookDetail(Book book);
 
}
```
👉  @Mapper(uses = {PublisherMapper.class, AuthorMapper.class, GenreMapper.class}): Esta anotación indica que BookMapper utiliza otros mapeadores, lo que permite a MapStruct integrar sus funciones en las conversiones que realiza.

👉 BookCollection toBookCollection(Book book): Este método convierte un objeto Book en un BookCollection, que contiene solo la información necesaria para el listado de libros.

👉 @Mapping(target =“publisherCollection”, source = “publisher”): Este mapeo especifica que el atributo publisher en el objeto Book se debe mapear al atributo publisherCollection en BookDetail. Aquí se utiliza el PublisherMapper para llevar a cabo la conversión.

👉 @Mapping(target=“authorsCollection”, source = “authors”): Similar al anterior, este mapeo se encarga de convertir la lista de authors del objeto Book en authorsCollection en BookDetail, utilizando el AuthorMapper.

👉 @Mapping(target = “category”, source = “category.name”): Este mapeo extrage el nombre de category para asignarlo a category en BookDetail.

👉 @Mapping(target = “genres”, source = “genres”): Aquí se realiza un mapeo directo de genres a genres, donde se espera que se utilice el GenreMapper para convertir cada Genre en su representación correspondiente, en este caso, un listado de Strings de genre.

## Respuesta

Vamos a cambiar el tipo de retorno del getAll() y el findByIsbn().
