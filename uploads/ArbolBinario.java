//BRASHICH, Federico - VINF09098 - 27/10/2025

/** Clase que implementa las operaciones del Tipo Abstracto de Datos Árbol **/
public class ArbolBinario {
    NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(String dato) {
        this.raiz = insertarRec(this.raiz, dato);			// Llama al método recursivo para insertar
    }

    private NodoArbol insertarRec(NodoArbol actual, String dato) {
    	if (actual == null) {			// Si el nodo actual es nulo, se ha encontrado la posición y se inserta el nuevo nodo
            return new NodoArbol(dato);
        }

        // Compara el nuevo dato con el dato del nodo actual para mantener la propiedad BST
        if (dato.compareTo(actual.dato) < 0) {							// Si el nuevo dato es menor
            actual.izquierdo = insertarRec(actual.izquierdo, dato);		// Recorro el subárbol izquierdo
        } else if (dato.compareTo(actual.dato) > 0) {					// Si el nuevo dato es mayor
            actual.derecho = insertarRec(actual.derecho, dato);			// Recorro el subárbol derecho
        }
        // Si son iguales, no se inserta (se ignora el duplicado)
        

        return actual;
    }

    // --- Recorridos Recursivos ---

    // Recorrido Inorden (Izquierda -> Raíz -> Derecha)
    public void recorridoInorden() {
        System.out.println("\n---< Recorrido del Árbol (Inorden Recursivo) >---");
        System.out.print("Inorden: ");
        recorridoInordenRec(this.raiz);
        System.out.println();
    }

    private void recorridoInordenRec(NodoArbol nodo) {
        if (nodo != null) {
            recorridoInordenRec(nodo.izquierdo);	// 1. Recorro el subárbol izquierdo
            System.out.print(nodo.dato + " ");		// 2. Proceso la Raíz (el dato)
            recorridoInordenRec(nodo.derecho);		// 3. Recorro el subárbol derecho
        }
    }
    
    // Nuevo: Recorrido Preorden (Raíz -> Izquierda -> Derecha)
    public void recorridoPreorden() {
        System.out.println("\n---< Recorrido del Árbol (Preorden Recursivo) >---");
        System.out.print("Preorden: ");
        recorridoPreordenRec(this.raiz);			// Comienzo el recorrido desde la raíz
        System.out.println();
    }

    private void recorridoPreordenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " "); 		// 1. Proceso la Raíz
            recorridoPreordenRec(nodo.izquierdo); 	// 2. Voy a la Izquierda
            recorridoPreordenRec(nodo.derecho); 	// 3. Voy a la Derecha
        }
    }

    // Nuevo: Recorrido Postorden (Izquierda -> Derecha -> Raíz)
    public void recorridoPostorden() {
        System.out.println("\n---< Recorrido del Árbol (Postorden Recursivo) >---");
        System.out.print("Postorden: ");
        recorridoPostordenRec(this.raiz);			// Comienzo el recorrido desde la raíz
        System.out.println();
    }

    private void recorridoPostordenRec(NodoArbol nodo) {
        if (nodo != null) {
            recorridoPostordenRec(nodo.izquierdo); 	// 1. Voy a la Izquierda
            recorridoPostordenRec(nodo.derecho); 	// 2. Voy a la Derecha
            System.out.print(nodo.dato + " "); 		// 3. Proceso la Raíz
        }
    }
}