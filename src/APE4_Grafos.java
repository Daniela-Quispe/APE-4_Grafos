import java.util.*; // Importar todas las clases de la libreria

public class APE4_Grafos {

    // ═══════════════════════════════════════
    // Nodo
    // ═══════════════════════════════════════
    static class Nodo { // Clase que representa un nodo del grafo
        String id; // Identificador unico del nodo
        String nombre; // Nombre del nodo

        public Nodo(String id, String nombre) { // Constructor de la clase nodo
            this.id = id; // Asignar el identificador recibido
            this.nombre = nombre; // Asignar el nombre recibido
        }
    }

    // ═══════════════════════════════════════
    // Arista
    // ═══════════════════════════════════════
    static class Arista { // Clase que representa una conexion entre nodos
        String destino; // Nodo destino de la conexion
        int peso; // Distancia o peso de la conexion

        public Arista(String destino, int peso) { // Constructor de la clase arista
            this.destino = destino; // Guardar el nodo destino
            this.peso = peso; // Guardar el peso de la conexion
        }
    }

    // ═══════════════════════════════════════
    // Grafo
    // ═══════════════════════════════════════
    static class Grafo { // Clase que contiene toda la logica del grafo

        Map<String, Nodo> nodos = new HashMap<>(); // Mapa para almacenar los nodos del grafo
        Map<String, List<Arista>> adyacencia = new HashMap<>(); // Lista de adyacencia para almacenar conexiones

        // ═══════════════════════════════════
        // TODO 1
        // Agregar nodo al grafo
        // ═══════════════════════════════════
        public void agregarNodo(String id, String nombre) { // Metodo para agregar un nodo al grafo

            // Crear un nuevo nodo y guardarlo en el mapa
            nodos.put(id, new Nodo(id, nombre)); 
            
            // Crear lista de adyacencia vacia para sus conexiones
            adyacencia.put(id, new ArrayList<>());
        }

        // ═══════════════════════════════════
        // TODO 2
        // Agregar arista no dirigida
        // ═══════════════════════════════════
        public void agregarArista(String origen, String destino, int peso) { // Metodo para agregar una arista no dirigida

            // Conexion desde origen → destino
            adyacencia.get(origen)
                    .add(new Arista(destino, peso));

            // Conexion desde destino → origen
            adyacencia.get(destino)
                    .add(new Arista(origen, peso));
        }

        // ═══════════════════════════════════
        // TODO 3 — BFS
        // Ruta con menos paradas
        // ═══════════════════════════════════
        public List<String> bfs(String inicio, String fin) { // Metodo BFS para encontrar la ruta con menos paradas

            // Crear cola para recorrer el grafo por niveles
            Queue<List<String>> cola = new LinkedList<>();

            // Crear conjunto para almacenar nodos visitados
            Set<String> visitados = new HashSet<>();

            // Crear camino inicial vacio
            List<String> caminoInicial = new ArrayList<>();

            // Agregar el nodo de inicio al camino
            caminoInicial.add(inicio);

            // Insertar el camino inicial en la cola
            cola.add(caminoInicial);

            // Marcar el nodo inicial como visitado
            visitados.add(inicio);

            while (!cola.isEmpty()) { // Continuar mientras existan elementos en la cola

                // Obtener el primer camino de la cola
                List<String> camino = cola.poll();

                // Obtener el ultimo nodo del camino actual
                String actual =
                        camino.get(camino.size() - 1);

                // Verificar si llegamos al destino
                if (actual.equals(fin)) {
                    return camino; // Retornar la ruta encontrada
                }

                // Recorrer todos los vecinos del nodo actual
                for (Arista arista : adyacencia.get(actual)) {

                    // Verificar si el vecino no fue visitado
                    if (!visitados.contains(arista.destino)) {

                        // Marcar el vecino como visitado
                        visitados.add(arista.destino);

                        // Crear nuevo camino
                        List<String> nuevoCamino =
                                new ArrayList<>(camino);

                        // Agregar el vecino al nuevo camino
                        nuevoCamino.add(arista.destino);

                        // Agregar el nuevo camino a la cola
                        cola.add(nuevoCamino);
                    }
                }
            }

            return null; // Retornar null si no existe ruta
        }

        // ═══════════════════════════════════
        // TODO 4 — Dijkstra
        // Ruta con menor distancia
        // ═══════════════════════════════════
        public List<String> dijkstra(String inicio, String fin) { // Metodo Dijkstra para encontrar la ruta con menor distancia

            Map<String, Integer> distancias =
                    new HashMap<>(); // Crear mapa para almacenar las distancias minimas

            Map<String, String> anteriores =
                    new HashMap<>(); // Crear mapa para almacenar el nodo anterior

            PriorityQueue<String> cola =
                    new PriorityQueue<>(
                            Comparator.comparingInt(
                                    distancias::get // Crear cola de prioridad ordenada por distancia
                            )
                    );

            // Recorrer todos los nodos del grafo
            for (String nodo : nodos.keySet()) {

                // Inicializar cada distancia como infinita
                distancias.put(nodo, Integer.MAX_VALUE);
            }

            // Asignar distancia cero al nodo inicial
            distancias.put(inicio, 0);

            // Agregar el nodo inicial en la cola
            cola.add(inicio);

            while (!cola.isEmpty()) { // Continuar mientras existan nodos por analizar

                // Obtener el nodo con menor distancia acumulada
                String actual = cola.poll();

                // Recorrer todos los vecinos del nodo actual
                for (Arista arista : adyacencia.get(actual)) {

                    // Calcular la nueva distancia posible
                    int nuevaDistancia =
                            distancias.get(actual)
                            + arista.peso;

                    // Verificar si la nueva distancia es menor
                    if (nuevaDistancia <
                            distancias.get(arista.destino)) {

                        // Actualizar la distancia minima encontrada
                        distancias.put(
                                arista.destino,
                                nuevaDistancia
                        );

                        // Guardar el nodo anterior para reconstruir la ruta
                        anteriores.put(
                                arista.destino,
                                actual
                        );

                        // Insertar el vecino actualizado en la cola de prioridad
                        cola.add(arista.destino);
                    }
                }
            }

            // Crear lista para almacenar la ruta final
            List<String> camino = new ArrayList<>();

            String actual = fin; // Comenzar desde el nodo destino

            while (actual != null) { // Reconstruir la ruta desde el final hacia el inicio

                camino.add(0, actual); // Insertar cada nodo al inicio de la lista

                actual = anteriores.get(actual); // Retroceder al nodo anterior
            }

            return camino; // Retornar la ruta encontrada
        }

        // ═══════════════════════════════════
        // Mostrar ruta
        // ═══════════════════════════════════
        public void mostrarRuta(List<String> ruta) { // Metodo para mostrar una ruta en pantalla

            if (ruta == null) { // Verificar si la ruta existe
                System.out.println("No existe ruta"); // Mostrar mensaje de error
                return; // Salir del metodo
            }

            for (int i = 0; i < ruta.size(); i++) { // Recorrer todos los nodos de la ruta

                String idNodo = ruta.get(i); // Obtener el identificador del nodo actual

                Nodo nodo = nodos.get(idNodo); // Buscar el nodo dentro del mapa

                System.out.print(
                        nodo.nombre + " (" + nodo.id + ")"
                ); // Mostrar nombre e identificador del nodo

                if (i < ruta.size() - 1) { // Verificar si no es el ultimo nodo
                    System.out.print(" -> "); // Mostrar flecha de conexion
                }
            }

            System.out.println(); // Realizar salto de linea al finalizar
        }
    }

// ═══════════════════════════════════════
// MAIN
// ═══════════════════════════════════════
public static void main(String[] args) { // Metodo principal del programa

    Grafo grafo = new Grafo(); // Crear una instancia del grafo

    // NODOS
    grafo.agregarNodo("uta", "Universidad"); // Agregar nodo Universidad
    grafo.agregarNodo("fisei", "FISEI"); // Agregar nodo FISEI
    grafo.agregarNodo("idiomas", "Idiomas"); // Agregar nodo Idiomas
    grafo.agregarNodo("biblioteca", "Biblioteca"); // Agregar nodo Biblioteca
    grafo.agregarNodo("estadio", "Estadio"); // Agregar nodo Estadio
    grafo.agregarNodo("comedor", "Comedor"); // Agregar nodo Comedor

    // ARISTAS
    grafo.agregarArista("uta", "fisei", 50); // Conectar Universidad con FISEI
    grafo.agregarArista("fisei", "idiomas", 40); // Conectar FISEI con Idiomas
    grafo.agregarArista("idiomas", "biblioteca", 30); // Conectar Idiomas con Biblioteca
    grafo.agregarArista("biblioteca", "estadio", 70); // Conectar Biblioteca con Estadio

    // Ruta con menos paradas
    // pero mas distancia
    grafo.agregarArista("uta", "comedor", 20); // Conectar Universidad con Comedor
    grafo.agregarArista("comedor", "estadio", 200); // Conectar Comedor con Estadio

    // ═══════════════════════════════════
    // PRUEBAS
    // ═══════════════════════════════════

    System.out.println("===== BFS ====="); // Mostrar titulo para BFS

    List<String> rutaBFS =
            grafo.bfs("uta", "estadio"); // Ejecutar algoritmo BFS

    grafo.mostrarRuta(rutaBFS); // Mostrar la ruta encontrada por BFS

    System.out.println("\n===== DIJKSTRA ====="); // Mostrar titulo para Dijkstra

    List<String> rutaDijkstra =
            grafo.dijkstra("uta", "estadio"); // Ejecutar el algoritmo Dijkstra

    grafo.mostrarRuta(rutaDijkstra); // Mostrar la ruta encontrada por Dijkstra
  }
}
