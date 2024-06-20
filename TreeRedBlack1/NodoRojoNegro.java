public class NodoRojoNegro<T extends Comparable<T>> {
    T dato;
    NodoRojoNegro<T> izquierdo, derecho, padre;
    boolean color; // true para rojo, false para negro

    public NodoRojoNegro(T dato) {
        this.dato = dato;
        this.izquierdo = this.derecho = this.padre = null;
        this.color = true; // los nuevos nodos son inicialmente rojos
    }
  
}