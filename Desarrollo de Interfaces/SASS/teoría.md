# SASS

SASS es un preprocesador de CSS que permite utilizar características adicionales en el desarrollo de estilos para sitios web, 
como variables, anidación, mixins, y funciones. Estas características facilitan la escritura y mantenimiento de código CSS,
haciéndolo más eficiente y legible. Una vez que escribes el código en Sass, 
se compila en CSS estándar para ser interpretado por los navegadores.

## 1- Instalación

    npm install -g sass
  
## 2- Compilar

    sass input.scss output.css
    sass --watch input.scss output.css
    
**sass --watch input.scss output.css**
Este comando compila el archivo input.scss en un archivo output.css. Lo que hace es transformar el código Sass
(que incluye variables, mixins, anidación, etc.) en código CSS estándar que los navegadores pueden entender. 
El archivo resultante output.css contendrá el CSS equivalente.

  * input.scss: es el archivo fuente en el que escribes tu código Sass.
  * output.css: es el archivo de salida que será el CSS resultante.

**sass --watch input.scss output.css**
    
Este comando activa el modo de "observación" o "vigilancia" (watch mode).
En este modo, Sass observa continuamente el archivo input.scss en busca de cambios, y automáticamente recompila el archivo en
output.css cada vez que detecta una modificación.

El comando estará corriendo en segundo plano mientras editas el archivo Sass.
Si haces algún cambio en input.scss, automáticamente verás esos cambios reflejados en output.css sin necesidad de ejecutar 
el comando de compilación manualmente cada vez.

## 3- Archivos de barril

```css
    @import 'file1';
    @import 'file2';
    @import 'file3';
```

Cuando compiles main.scss, Sass incluirá automáticamente el contenido de todos los archivos importados 
(_variables.scss, _mixins.scss, _layout.scss) en el archivo CSS resultante.
Solo necesitarás incluir y compilar main.scss, y todos los estilos estarán presentes en el archivo CSS generado.

## 4- Variables

```css
          // Declaración
    $font-family: Arial, sans-serif;
    $primary-color: #666;
    $name: 'secondary';
    
    // Uso
    body {
      font-family: $font-family;
      color: $primary-color;
      #{$name}-color: red;
    }
```

## 5- Bucles

```css
 $colors: (
       "rojo": #FF0000, 
       "verde": #00FF00, 
       "azul": #0000FF
    );
    
    // For
    @for $i from 1 through 3 {
      .item-#{$i} {
        width: 2em * $i;
      }
    }
    
    // Each
    @each $name, $color in $colors {
      .background-#{$name} {
        background-color: $color;
      }
    }
    
    // While
    $i: 1;
    @while $i <= 3 {
      .item-#{$i} {
        width: 2em * $i;
      }
      $i: $i + 1;
    }
```
## 6- Selector padre

 ```css
   AAA {
      color: red;
      &__BBB {
        color: blue;
      }
    }
```
Esto se compilará a:

 ```css
   .AAA {
      color: red;
    }
    .AAA__BBB {
      color: blue;
    }
```
Aquí tienes algunos ejemplos con diferentes clases utilizando anidación en Sass y la convención BEM (Block, Element, Modifier):

Código Sass:

```css
    .card {
  border: 1px solid #ccc;
  padding: 20px;
  background-color: white;

  &__title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
  }

  &__content {
    font-size: 16px;
    color: #555;
  }

  &--highlighted {
    border-color: #f39c12;
    background-color: #fffbea;
  }
}
```

CSS resultante:

```css
.card {
  border: 1px solid #ccc;
  padding: 20px;
  background-color: white;
}

.card__title {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
}

.card__content {
  font-size: 16px;
  color: #555;
}

.card--highlighted {
  border-color: #f39c12;
  background-color: #fffbea;
}
```
