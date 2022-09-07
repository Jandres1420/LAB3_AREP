package co.edu.escuelaing;

public class JunitTest {

    @Test
    public static void m1(){}
    public static void m2(){}
    @Test
    public static void m3(){}
    @Test
    public static void m4() throws Exception{
        throw(new Exception(("error 4")));
    }
    @Test
    public static void m5(){}
    @Test
    public static void m6s(){}
}
