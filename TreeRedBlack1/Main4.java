public class Main4 {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol2 = new ArbolRojoNegro<>();

        for (int i = 20; i >= 1; i--) {
            arbol2.insertar(i);
        }

        int[] valoresABuscar = {10, 15, 20};
        for (int valor : valoresABuscar) {
            NodoRojoNegro<Integer> nodo = arbol2.buscarEnArbol(valor);
            if (nodo != arbol2.getTNULL()) {
                int nivel = arbol2.obtenerNivel(nodo);
                String color = arbol2.obtenerColor(nodo);
                System.out.println("Valor: " + valor + ", Nivel: " + nivel + ", Color: " + color);
            } else {
                System.out.println("Valor: " + valor + " no encontrado en el árbol.");
            }
        }
    }
}
