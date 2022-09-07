package co.edu.escuelaing;

public class WebServices {

    @RequestMapping("/hello")
    public static String helloWorld(){
        return "Hello world!!!!";
    }

    @RequestMapping("/status")
    public static String helloStatus(){
        return "Estado x";
    }
}
