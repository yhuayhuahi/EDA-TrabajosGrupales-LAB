public class Main1 {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol1 = new ArbolRojoNegro<>();

        for (int i = 1; i <= 20; i++) {
            arbol1.insertar(i);
        }

        System.out.println("Árbol Rojo-Negro después de insertar 1 a 20:");
        arbol1.imprimirArbol();

        System.out.println("\nPreorden:");
        arbol1.preOrden();

        System.out.println("Inorden:");
        arbol1.inOrden();

        System.out.println("Postorden:");
        arbol1.postOrden();
    }
}
