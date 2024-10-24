# Idioma

Vamos a crear una configuración que permita cambiar el idioma utilizando las cabeceras "Accept-Language" de las solicitudes HTTP.

Empezaremos creando el package en /common/locale donde colocaremos nuestros archivos.

## LanguageUtils

```java
public class LanguageUtils {
    private static final ThreadLocal<Locale> currentLocale = new ThreadLocal<>();

    public static void setCurrentLocale(Locale locale){
        currentLocale.set(locale);
    }
    public static String getCurrentLanguage(){
        Locale locale = currentLocale.get();
        return locale != null ? locale.getLanguage(): Locale.getDefault().getLanguage();
    }
}
```
* ThreadLocal<Locale>: ThreadLocal es una clase de Java que permite almacenar datos que son específicos de un hilo.
Cada hilo tiene su propia copia de la variable. En este caso, currentLocale almacenará un objeto de tipo Locale,
que representa información de localización (como el idioma y la región) para un hilo específico.
* currentLocale.set(locale): Este método establece el idioma proporcionado en el ThreadLocal actual.
Esto significa que el locale estará disponible solo para el hilo que lo estableció, y no afectará a otros hilos.
* Locale locale = currentLocale.get();: Este código obtiene el Locale actual del ThreadLocal.
Si el hilo no ha establecido un Locale, este valor será null.

* return locale != null ? locale.getLanguage() : Locale.getDefault().getLanguage();:
Aquí se utiliza un operador ternario para determinar qué idioma devolver.
Si locale no es null, se llama al método getLanguage() en el objeto locale, lo que devuelve un código de idioma de dos letras (como "en" para inglés o "es" para español).
Si locale es null, se llama a Locale.getDefault().getLanguage(),
que devuelve el código de idioma de la configuración regional predeterminada de la JVM.
Esto garantiza que siempre se devuelva un código de idioma,
ya sea el que se estableció específicamente para el hilo o el predeterminado de la aplicación.

### Resumen
La clase LanguageUtils es una herramienta útil para manejar la configuración regional (idioma) en aplicaciones multihilo. Proporciona dos métodos:

setCurrentLocale(Locale locale): Para establecer el idioma y la configuración regional del hilo actual.
getCurrentLanguage(): Para obtener el código del idioma actual del hilo, o el idioma predeterminado si no se ha establecido uno.

## Interceptores en Java
Los interceptores en Java permiten modificar el comportamiento de las solicitudes y respuestas en una aplicación web.

Para nuestra aplicación, extenderemos de **LocaleChangeInterceptor** que se encargará de leer la cabecera Accept-Language y establecer
el idioma utilizando la clase **LanguageUtils**.
```java
public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        String lang = request.getHeader("Accept-Language"); // Obtiene el valor de la cabecera
        Locale locale = lang != null ? Locale.forLanguageTag(lang) : Locale.getDefault();
 
        LanguageUtils.setCurrentLocale(locale); // Establece el idioma actual
 
        return super.preHandle(request, response, handler); // Llama al método preHandle de la clase padre
    }
}
```
* HttpServletRequest request: Representa la solicitud HTTP que un cliente envía a un servidor.
Lo usaremos para obtener la cabecera Accept-Language que especificia el idioma elegido por el cliente.

* HttpServletRespone respone: permite establecer códigos de estado, agregar encabezados y enviar datos al cliente.
En este caso, no lo usaremos.

* Object handler: puede ser un controlador (un método en un controlador anotado con @RequestMapping) u otros componentes que manejan la lógica de la aplicación.
Este parámetro se utiliza para determinar qué acción tomar después de que se complete el procesamiento del interceptor.

### Proceso por orden:
1- Se obtiene el valor del header 'Accept-Language'.

2- Si se consigue el valor, se convierte en un objeto Locale usando forLanguageTag (utilizando una representación estándar de idioma, 
como “es-ES” para español de España o “en-US” para inglés de Estados Unidos), si no, devuelve el valor por defecto.

3- Se establece el idioma mediante LanguageUtils y se llama a prehandle del padre ( usamos .super para así asegurar que el prehandle del padre
se ejecute para que funcione nuestro interceptor correctamente.

## LocaleConfig

```java
@Configuration
public class LocaleConfig implements WebMvcConfigurer {
 
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("es"));
        return localeResolver;
    }
 
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("Accept-Language");
        return localeInterceptor;
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomLocaleChangeInterceptor());
    }
}
```
* AcceptHeaderLocaleResolver localeResolver: permite resolver el idioma de la aplicación a partir de la cabecera Accept-Language
de las solicitudes HTTP. Si no se puede resolver se proporciona "es" como idioma predeterminado.

* LocaleChangeInterceptor localeChangeInterceptor: permite cambiar de manera dinámica el idioma de la aplicación.
se configura para que lea el parametro desde la cabecera "Accept-Language".

* addInterceptors(InterceptorRegistry registry): viene implementa de la interfaz (WebMvcConfigurer) y lo usamos para
registrar interceptores. En este caso, se añade nuestro interceptor personalizado (CustomLocaleChangeInterceptor).

Podemos configurar el idioma del usuario en nuestros mapeadores:

```java
@RequiredArgsConstructor
public class CategoryRowMapper implements CustomRowMapper<Category> {
 
    @Override
    public Category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Category category = new Category();
        category.setName(resultSet.getString("categories.name_" + language));
        category.setSlug(resultSet.getString("categories.slug"));
        return category;
    }
}
```
🔴 Sería mejor hacerlo en la consulta de la base de datos.

# Paginación 
Creamos en la ruta controller/common donde guardaremos la nueva clase **PaginatedResponse**.

```java
@Data
@AllArgsConstructor
public class PaginatedResponse<T> {
    private List<T> data;
    private int total;
    private int currentPage;
    private int pageSize;
    private String next;
    private String previous;
 
    public PaginatedResponse(List<T> data, int total, int currentPage, int pageSize, String baseUrl) {
        this.data = data;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.next = createNextLink(baseUrl);
        this.previous = createPreviousLink(baseUrl);
    }
 
    private String createNextLink(String baseUrl) {
        if(currentPage * pageSize < total) {
            return baseUrl + "?page=" + (currentPage + 1) + "&size=" + pageSize;
        }
        return null;
    }
 
    private String createPreviousLink(String baseUrl) {
        if(currentPage > 1) {
            return baseUrl + "?page=" + (currentPage - 1) + "&size=" + pageSize;
        }
        return null;
    }
}
```
De esta manera, PaginatedReponse <T> recibirá un genérico, es decir, acepta cualquier tipo de dato.

Crearemos dos métodos privados que crearan un link previo y siguiente.

### Application properties
```java
app.base.url=http://localhost:8080
app.pageSize.default=10
```
Modificamos así nuestro controller con los métodos:
```java

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.URL)
public class BookController {
 
    public static final String URL = "/api/books";
    @Value("${app.base.url}")
    private String baseUrl;
 
    @Value("${app.pageSize.default}")
    private String defaultPageSize;
 
    private final BookService bookService;
 
    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<BookCollection> books = bookService
                .getAll(page - 1, pageSize)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
 
        int total = bookService.count();
 
        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
```
En BookService:
```java
@Override
public List<Book> getAll(int page, int size) {
    return bookRepository.getAll(page, size);
}
 
@Override
public int count() {
    return bookRepository.count();
```
En BookRepository:
```java
@Override
public List<Book> getAll(int page, int size) {
    String sql = """
                    SELECT * FROM books
                    LIMIT ? OFFSET ?
                 """;
    return jdbcTemplate.query(sql, new BookRowMapper(), size, page * size);
}
 
@Override
public int count() {
    String sql = """
                    SELECT COUNT(*) FROM books
                 """;
    return jdbcTemplate.queryForObject(sql, Integer.class);
}
```
  
