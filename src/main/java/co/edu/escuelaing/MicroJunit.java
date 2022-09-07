package co.edu.escuelaing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MicroJunit {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        HashMap<String,Method>memory = new HashMap<>();
        //la clase que se quiere probar
        System.out.println("ARGS 0 " + args[0]);
       String className = args[0];
       Class c = Class.forName(className);
       Method[] declareMethods = c.getDeclaredMethods();
       int passed = 0;
       int failed = 0;
       Lectura lectura;
       for(Method m : declareMethods){

           /**
           if(m.isAnnotationPresent(Test.class)){
               try {
                   m.invoke(null);
                   System.out.printf("invoking " + m.getName() + " in class " + c.getName());
                   passed++;
               } catch (Exception e) {
                   failed++;
               }
           }**/
           if(m.isAnnotationPresent(RequestMapping.class)){
               try {
                   m.invoke(null);
                  // System.out.printf("invoking " + m.getName() + " in class " + c.getName() +"\n");
                   passed++;
                   memory.put(m.getAnnotation(RequestMapping.class).value(),m);
                   lectura = new Lectura(m.getAnnotation(RequestMapping.class).value(),m);
                   System.out.println("Metodo con /hello " + lectura.getMethods().get("/hello").invoke(null));
               } catch (Exception e) {
                   failed++;
               }
           }
       }
        System.out.printf("Passed " + passed + " failed " + failed);
        System.out.println("Metodo con /hello " + memory.get("/hello").invoke(null));
    }
}
