public class Main3 {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol2 = new ArbolRojoNegro<>();

        for (int i = 20; i >= 1; i--) {
            arbol2.insertar(i);
        }

        for (int i = 1; i <= 9; i++) {
            arbol2.eliminarNodo(i);
        }

        System.out.println("Árbol Rojo-Negro después de eliminar 1 a 9:");
        arbol2.imprimirArbol();

        System.out.println("\nPreorden:");
        arbol2.preOrden();

        System.out.println("Inorden:");
        arbol2.inOrden();

        System.out.println("Postorden:");
        arbol2.postOrden();
    }
}