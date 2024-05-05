public class JavaMethods2 {
    //Add a fname parameter of type String to myMethod, and output "John Doe".
    public static void main(String[] args) {
        myMethod("John");
    }
    static void myMethod(String fname) {
        System.out.println(fname + " Doe");
    }
}
