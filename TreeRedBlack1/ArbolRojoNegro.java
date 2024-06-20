public class ArbolRojoNegro<T extends Comparable<T>> {
    private NodoRojoNegro<T> raiz;
    private NodoRojoNegro<T> TNULL;

    public ArbolRojoNegro() {
        TNULL = new NodoRojoNegro<>(null);
        TNULL.color = false;
        TNULL.izquierdo = null;
        TNULL.derecho = null;
        raiz = TNULL;
    }

    public NodoRojoNegro<T> getTNULL() {
        return TNULL;
    }
    
    private void preOrdenAyudante(NodoRojoNegro<T> nodo) {
        if (nodo != TNULL) {
            System.out.print(nodo.dato + " ");
            preOrdenAyudante(nodo.izquierdo);
            preOrdenAyudante(nodo.derecho);
        }
    }

    private void inOrdenAyudante(NodoRojoNegro<T> nodo) {
        if (nodo != TNULL) {
            inOrdenAyudante(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrdenAyudante(nodo.derecho);
        }
    }

    private void postOrdenAyudante(NodoRojoNegro<T> nodo) {
        if (nodo != TNULL) {
            postOrdenAyudante(nodo.izquierdo);
            postOrdenAyudante(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }
    public void preOrden() {
        preOrdenAyudante(this.raiz);
        System.out.println();
    }

    public void inOrden() {
        inOrdenAyudante(this.raiz);
        System.out.println();
    }

    public void postOrden() {
        postOrdenAyudante(this.raiz);
        System.out.println();
    }
    private NodoRojoNegro<T> minimo(NodoRojoNegro<T> nodo) {
        while (nodo.izquierdo != TNULL) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }
    
    // Balancear el árbol después de la eliminación de un nodo
    private void arreglarEliminar(NodoRojoNegro<T> x) {
        NodoRojoNegro<T> s;
        while (x != raiz && x.color == false) {
            if (x == x.padre.izquierdo) {
                s = x.padre.derecho;
                if (s.color == true) {
                    s.color = false;
                    x.padre.color = true;
                    rotarIzquierda(x.padre);
                    s = x.padre.derecho;
                }

                if (s.izquierdo.color == false && s.derecho.color == false) {
                    s.color = true;
                    x = x.padre;
                } else {
                    if (s.derecho.color == false) {
                        s.izquierdo.color = false;
                        s.color = true;
                        rotarDerecha(s);
                        s = x.padre.derecho;
                    }

                    s.color = x.padre.color;
                    x.padre.color = false;
                    s.derecho.color = false;
                    rotarIzquierda(x.padre);
                    x = raiz;
                }
            } else {
                s = x.padre.izquierdo;
                if (s.color == true) {
                    s.color = false;
                    x.padre.color = true;
                    rotarDerecha(x.padre);
                    s = x.padre.izquierdo;
                }

                if (s.derecho.color == false && s.derecho.color == false) {
                    s.color = true;
                    x = x.padre;
                } else {
                    if (s.izquierdo.color == false) {
                        s.derecho.color = false;
                        s.color = true;
                        rotarIzquierda(s);
                        s = x.padre.izquierdo;
                    }

                    s.color = x.padre.color;
                    x.padre.color = false;
                    s.izquierdo.color = false;
                    rotarDerecha(x.padre);
                    x = raiz;
                }
            }
        }
        x.color = false;
    }

    private void rbTransplantar(NodoRojoNegro<T> u, NodoRojoNegro<T> v) {
        if (u.padre == null) {
            raiz = v;
        } else if (u == u.padre.izquierdo) {
            u.padre.izquierdo = v;
        } else {
            u.padre.derecho = v;
        }
        v.padre = u.padre;
    }

    private void eliminarNodoAyudante(NodoRojoNegro<T> nodo, T clave) {
        NodoRojoNegro<T> z = TNULL;
        NodoRojoNegro<T> x, y;
        while (nodo != TNULL) {
            if (nodo.dato == clave) {
                z = nodo;
            }

            if (nodo.dato.compareTo(clave) <= 0) {
                nodo = nodo.derecho;
            } else {
                nodo = nodo.izquierdo;
            }
        }

        if (z == TNULL) {
            System.out.println("No se pudo encontrar la clave en el árbol");
            return;
        }

        y = z;
        boolean colorOriginalY = y.color;
        if (z.izquierdo == TNULL) {
            x = z.derecho;
            rbTransplantar(z, z.derecho);
        } else if (z.derecho == TNULL) {
            x = z.izquierdo;
            rbTransplantar(z, z.izquierdo);
        } else {
            y = minimo(z.derecho);
            colorOriginalY = y.color;
            x = y.derecho;
            if (y.padre == z) {
                x.padre = y;
            } else {
                rbTransplantar(y, y.derecho);
                y.derecho = z.derecho;
                y.derecho.padre = y;
            }

            rbTransplantar(z, y);
            y.izquierdo = z.izquierdo;
            y.izquierdo.padre = y;
            y.color = z.color;
        }
        if (colorOriginalY == false) {
            arreglarEliminar(x);
        }
    }

    // Balancear el nodo después de la inserción
    private void arreglarInsertar(NodoRojoNegro<T> k) {
        NodoRojoNegro<T> u;
        while (k.padre.color == true) {
            if (k.padre == k.padre.padre.derecho) {
                u = k.padre.padre.izquierdo;
                if (u.color == true) {
                    u.color = false;
                    k.padre.color = false;
                    k.padre.padre.color = true;
                    k = k.padre.padre;
                } else {
                    if (k == k.padre.izquierdo) {
                        k = k.padre;
                        rotarDerecha(k);
                    }
                    k.padre.color = false;
                    k.padre.padre.color = true;
                    rotarIzquierda(k.padre.padre);
                }
            } else {
                u = k.padre.padre.derecho;

                if (u.color == true) {
                    u.color = false;
                    k.padre.color = false;
                    k.padre.padre.color = true;
                    k = k.padre.padre;
                } else {
                    if (k == k.padre.derecho) {
                        k = k.padre;
                        rotarIzquierda(k);
                    }
                    k.padre.color = false;
                    k.padre.padre.color = true;
                    rotarDerecha(k.padre.padre);
                }
            }
            if (k == raiz) {
                break;
            }
        }
        raiz.color = false;
    }

    private void imprimirAyudante(NodoRojoNegro<T> raiz, String indent, boolean ultimo) {
        if (raiz != TNULL) {
            System.out.print(indent);
            if (ultimo) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = raiz.color ? "ROJO" : "NEGRO";
            System.out.println(raiz.dato + "(" + sColor + ")");
            imprimirAyudante(raiz.izquierdo, indent, false);
            imprimirAyudante(raiz.derecho, indent, true);
        }
    }

    public NodoRojoNegro<T> buscarEnArbol(T k) {
        return buscarEnArbolAyudante(this.raiz, k);
    }

    private NodoRojoNegro<T> buscarEnArbolAyudante(NodoRojoNegro<T> nodo, T clave) {
        if (nodo == TNULL || clave.compareTo(nodo.dato) == 0) {
            return nodo;
        }

        if (clave.compareTo(nodo.dato) < 0) {
            return buscarEnArbolAyudante(nodo.izquierdo, clave);
        }
        return buscarEnArbolAyudante(nodo.derecho, clave);
    }

    // Rotar a la izquierda en el nodo x
    private void rotarIzquierda(NodoRojoNegro<T> x) {
        NodoRojoNegro<T> y = x.derecho;
        x.derecho = y.izquierdo;
        if (y.izquierdo != TNULL) {
            y.izquierdo.padre = x;
        }
        y.padre = x.padre;
        if (x.padre == null) {
            this.raiz = y;
        } else if (x == x.padre.izquierdo) {
            x.padre.izquierdo = y;
        } else {
            x.padre.derecho = y;
        }
        y.izquierdo = x;
        x.padre = y;
    }

    // Rotar a la derecha en el nodo x
    private void rotarDerecha(NodoRojoNegro<T> x) {
        NodoRojoNegro<T> y = x.izquierdo;
        x.izquierdo = y.derecho;
        if (y.derecho != TNULL) {
            y.derecho.padre = x;
        }
        y.padre = x.padre;
        if (x.padre == null) {
            this.raiz = y;
        } else if (x == x.padre.derecho) {
            x.padre.derecho = y;
        } else {
            x.padre.izquierdo = y;
        }
        y.derecho = x;
        x.padre = y;
    }

    public void insertar(T clave) {
        NodoRojoNegro<T> nodo = new NodoRojoNegro<>(clave);
        nodo.padre = null;
        nodo.dato = clave;
        nodo.izquierdo = TNULL;
        nodo.derecho = TNULL;
        nodo.color = true;

        NodoRojoNegro<T> y = null;
        NodoRojoNegro<T> x = this.raiz;

        while (x != TNULL) {
            y = x;
            if (nodo.dato.compareTo(x.dato) < 0) {
                x = x.izquierdo;
            } else {
                x = x.derecho;
            }
        }

        nodo.padre = y;
        if (y == null) {
            raiz = nodo;
        } else if (nodo.dato.compareTo(y.dato) < 0) {
            y.izquierdo = nodo;
        } else {
            y.derecho = nodo;
        }

        if (nodo.padre == null) {
            nodo.color = false;
            return;
        }

        if (nodo.padre.padre == null) {
            return;
        }

        arreglarInsertar(nodo);
    }

    public void eliminarNodo(T dato) {
        eliminarNodoAyudante(this.raiz, dato);
    }

    public void imprimirArbol() {
        imprimirAyudante(this.raiz, "", true);
    }

    public int obtenerNivel(NodoRojoNegro<T> nodo) {
        return obtenerNivelAyudante(raiz, nodo.dato, 1);
    }

    private int obtenerNivelAyudante(NodoRojoNegro<T> nodo, T dato, int nivel) {
        if (nodo == null || nodo == TNULL)
            return 0;

        if (nodo.dato.compareTo(dato) == 0)
            return nivel;

        int nivelInferior = obtenerNivelAyudante(nodo.izquierdo, dato, nivel + 1);
        if (nivelInferior != 0)
            return nivelInferior;

        nivelInferior = obtenerNivelAyudante(nodo.derecho, dato, nivel + 1);
        return nivelInferior;
    }

    public String obtenerColor(NodoRojoNegro<T> nodo) {
        return nodo.color ? "ROJO" : "NEGRO";
    }
}