# LAB 3 AREP
## Author
**Juan Andrés Pico**
## Fecha
**07/09/2022**
## Introducción
En ente laboratorio se busca hacer un código que nos ayuda a entender hilos y la concurrencia en el codigo que teniamos anteriormente y para finalizar hacer el despliegue en heroku
## Despliegue
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://mighty-atoll-21580.herokuapp.com/)
Al entrar directamente al enlace se ve la pagina principal para entrar al index, se le agregara /index.html
![](/img/Leyendo-HTML.png)
### Pagina html 
![](/img/index.png)
### Imagen 
Para leer la imagen /public/img/img.png
![](/img/imagen.png)
### Error
Error
![](/img/error.png)
### Java Script
![](/img/javascript.png)
### Spring boot
En este laboratorio se crearon anotaciones RequestMapping "/hello" y "status"
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {
    String value();
}
```
Se leyo de manera que la clase EndPoints en java pudiera lanzar los siguientes Strings 
```java
    public class EndPoints {

    @RequestMapping("/hello")
    public static String helloWorld(){
        return "Hello world!!!!";
    }

    @RequestMapping("/status")
    public static String helloStatus(){
        return "Estado x";
    }
}
```

De manera que se pudieran ver desde un html como el siguiente y que se puedan leer las anotaciones como lo hace Spring boot

![](/img/endpoint%20hello.png)
Y tambien con /status
![](/img/status%20endpoint.png)