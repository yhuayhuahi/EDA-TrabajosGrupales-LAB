public class Main2 {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol2 = new ArbolRojoNegro<>();

        for (int i = 20; i >= 1; i--) {
            arbol2.insertar(i);
        }

        System.out.println("Árbol Rojo-Negro después de insertar 20 a 1:");
        arbol2.imprimirArbol();

        System.out.println("\nPreorden:");
        arbol2.preOrden();

        System.out.println("Inorden:");
        arbol2.inOrden();

        System.out.println("Postorden:");
        arbol2.postOrden();
    }
}
