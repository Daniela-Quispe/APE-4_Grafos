import java.util.*;

public class APE4_Grafos {

    // ═══════════════════════════════════════
    // Nodo
    // ═══════════════════════════════════════
    static class Nodo {
        String id;
        String nombre;

        public Nodo(String id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
    }

    // ═══════════════════════════════════════
    // Arista
    // ═══════════════════════════════════════
    static class Arista {
        String destino;
        int peso;

        public Arista(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // ═══════════════════════════════════════
    // Grafo
    // ═══════════════════════════════════════
    static class Grafo {

        Map<String, Nodo> nodos = new HashMap<>();
        Map<String, List<Arista>> adyacencia = new HashMap<>();

        // ═══════════════════════════════════
        // TODO 1
        // Agregar nodo al grafo
        // ═══════════════════════════════════
        public void agregarNodo(String id, String nombre) {

            // Crear nodo y guardarlo
            nodos.put(id, new Nodo(id, nombre));

            // Crear lista de adyacencia vacía
            adyacencia.put(id, new ArrayList<>());
        }

        // ═══════════════════════════════════
        // TODO 2
        // Agregar arista no dirigida
        // ═══════════════════════════════════
        public void agregarArista(String origen, String destino, int peso) {

            // Conexión origen → destino
            adyacencia.get(origen)
                    .add(new Arista(destino, peso));

            // Conexión destino → origen
            adyacencia.get(destino)
                    .add(new Arista(origen, peso));
        }

        // ═══════════════════════════════════
        // TODO 3 — BFS
        // Ruta con menos paradas
        // ═══════════════════════════════════
        public List<String> bfs(String inicio, String fin) {

            // Cola para recorrer niveles
            Queue<List<String>> cola = new LinkedList<>();

            // Nodos visitados
            Set<String> visitados = new HashSet<>();

            // Camino inicial
            List<String> caminoInicial = new ArrayList<>();

            // Agregar inicio al camino
            caminoInicial.add(inicio);

            // Agregar camino a la cola
            cola.add(caminoInicial);

            // Marcar inicio como visitado
            visitados.add(inicio);

            while (!cola.isEmpty()) {

                // Obtener primer camino
                List<String> camino = cola.poll();

                // Obtener último nodo del camino
                String actual =
                        camino.get(camino.size() - 1);

                // Si llegamos al destino
                if (actual.equals(fin)) {
                    return camino;
                }

                // Recorrer vecinos
                for (Arista arista : adyacencia.get(actual)) {

                    // Si el vecino no fue visitado
                    if (!visitados.contains(arista.destino)) {

                        // Marcar vecino
                        visitados.add(arista.destino);

                        // Crear nuevo camino
                        List<String> nuevoCamino =
                                new ArrayList<>(camino);

                        // Agregar vecino
                        nuevoCamino.add(arista.destino);

                        // Agregar nuevo camino a la cola
                        cola.add(nuevoCamino);
                    }
                }
            }

            return null;
        }

        // ═══════════════════════════════════
        // TODO 4 — Dijkstra
        // Ruta con menor distancia
        // ═══════════════════════════════════
        public List<String> dijkstra(String inicio, String fin) {

            Map<String, Integer> distancias =
                    new HashMap<>();

            Map<String, String> anteriores =
                    new HashMap<>();

            PriorityQueue<String> cola =
                    new PriorityQueue<>(
                            Comparator.comparingInt(
                                    distancias::get
                            )
                    );

            // Inicializar distancias
            for (String nodo : nodos.keySet()) {

                // Distancia infinita
                distancias.put(nodo, Integer.MAX_VALUE);
            }

            // Distancia inicial
            distancias.put(inicio, 0);

            // Agregar inicio a la cola
            cola.add(inicio);

            while (!cola.isEmpty()) {

                // Nodo con menor distancia
                String actual = cola.poll();

                // Recorrer vecinos
                for (Arista arista : adyacencia.get(actual)) {

                    // Nueva distancia
                    int nuevaDistancia =
                            distancias.get(actual)
                            + arista.peso;

                    // Si es menor, actualizar
                    if (nuevaDistancia <
                            distancias.get(arista.destino)) {

                        // Actualizar distancia
                        distancias.put(
                                arista.destino,
                                nuevaDistancia
                        );

                        // Guardar anterior
                        anteriores.put(
                                arista.destino,
                                actual
                        );

                        // Agregar vecino
                        cola.add(arista.destino);
                    }
                }
            }

            // Reconstruir camino
            List<String> camino = new ArrayList<>();

            String actual = fin;

            while (actual != null) {

                camino.add(0, actual);

                actual = anteriores.get(actual);
            }

            return camino;
        }

        // ═══════════════════════════════════
        // Mostrar ruta
        // ═══════════════════════════════════
        public void mostrarRuta(List<String> ruta) {

            if (ruta == null) {
                System.out.println("No existe ruta");
                return;
            }

            for (int i = 0; i < ruta.size(); i++) {

                String idNodo = ruta.get(i);

                Nodo nodo = nodos.get(idNodo);

                System.out.print(
                        nodo.nombre + " (" + nodo.id + ")"
                );

                if (i < ruta.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }
    }

    // ═══════════════════════════════════════
    // MAIN
    // ═══════════════════════════════════════
    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        // ═══════════════════════════════════
        // NODOS DEL CAMPUS HUACHI
        // ═══════════════════════════════════

        grafo.agregarNodo("rectorado", "Rectorado");
        grafo.agregarNodo("fisei", "FISEI");
        grafo.agregarNodo("ficm", "FICM");
        grafo.agregarNodo("fcadm", "FCADM");
        grafo.agregarNodo("fca", "Contabilidad y Auditoria");
        grafo.agregarNodo("juris", "Jurisprudencia");
        grafo.agregarNodo("humanas", "Ciencias Humanas");
        grafo.agregarNodo("diseno", "Diseño y Arquitectura");
        grafo.agregarNodo("alimentos", "Alimentos y Biotecnologia");
        grafo.agregarNodo("biblioteca", "Biblioteca");
        grafo.agregarNodo("coliseo", "Coliseo");
        grafo.agregarNodo("estadio", "Estadio");
        grafo.agregarNodo("comedor", "Comedor");

        // ═══════════════════════════════════
        // ARISTAS
        // ═══════════════════════════════════

        grafo.agregarArista("rectorado", "fisei", 30);
        grafo.agregarArista("fisei", "ficm", 25);
        grafo.agregarArista("ficm", "fcadm", 20);
        grafo.agregarArista("fcadm", "fca", 15);
        grafo.agregarArista("fca", "juris", 20);
        grafo.agregarArista("juris", "humanas", 25);
        grafo.agregarArista("humanas", "diseno", 20);
        grafo.agregarArista("diseno", "alimentos", 35);
        grafo.agregarArista("alimentos", "biblioteca", 30);
        grafo.agregarArista("biblioteca", "coliseo", 20);
        grafo.agregarArista("coliseo", "estadio", 15);

        // Ruta corta pero con mayor distancia
        grafo.agregarArista("rectorado", "comedor", 10);
        grafo.agregarArista("comedor", "estadio", 200);

        // ═══════════════════════════════════
        // PRUEBAS
        // ═══════════════════════════════════

        System.out.println("===== BFS =====");

        List<String> rutaBFS =
                grafo.bfs("rectorado", "estadio");

        grafo.mostrarRuta(rutaBFS);

        System.out.println("\n===== DIJKSTRA =====");

        List<String> rutaDijkstra =
                grafo.dijkstra("rectorado", "estadio");

        grafo.mostrarRuta(rutaDijkstra);
    }
}