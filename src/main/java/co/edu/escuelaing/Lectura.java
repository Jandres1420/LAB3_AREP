package co.edu.escuelaing;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Lectura {
    private HashMap<String, Method> methods;
    private String name;
    private Method method;

    public Lectura(String name, Method method){
        this.name = name;
        this.method =method;
        methods = new HashMap<>();

    }

    public HashMap<String, Method> getMethods() {
        return methods;
    }

    public void setMethods(HashMap<String, Method> methods) {
        this.methods = methods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
