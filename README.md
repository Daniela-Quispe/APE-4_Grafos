# APE 4 - GRAFOS

Implementación de Grafos mediante Listas de Adyacencia y Comparación de los Algoritmos BFS y Dijkstra

---

# 2.1 Objetivos

## Objetivo General

Implementar un grafo utilizando lista de adyacencia para representar dentro del Campus Huachi de la Universidad Técnica de Ambato y comparar los algoritmos BFS y Dijkstra.

## Objetivos Específicos

* Diseñar e implementar un grafo mediante listas de adyacencia en Java para representar las diferentes ubicaciones y rutas existentes dentro del Campus Huachi de la Universidad Técnica de Ambato.
* Aplicar el algoritmo Breadth First Search (BFS) para determinar rutas con el menor número de paradas o nodos intermedios entre dos ubicaciones del campus.
* Implementar y analizar el algoritmo de Dijkstra para calcular la ruta de menor distancia considerando los pesos asociados a las conexiones del grafo y comparar sus resultados con los obtenidos mediante BFS.
* Comprender el funcionamiento de los grafos y las listas de adyacencia como estructuras de datos para representar conexiones.
* Comparar la eficiencia y los resultados obtenidos por BFS y Dijkstra, analizando sus ventajas según el criterio de búsqueda utilizado.

---

# 2.2 Modalidad

Presencial.

---

# 2.3 Tiempo de Duración

**Presenciales:** 8 horas

**No presenciales:** 0 horas

---

# 2.4 Instrucciones

* Analizar el problema planteado e identificar las ubicaciones que serán representadas como nodos dentro del grafo del Campus Huachi de la Universidad Técnica de Ambato.
* Implementar la estructura del grafo utilizando listas de adyacencia para almacenar las conexiones entre los diferentes nodos.
* Completar los métodos marcados con TODO en el archivo `APE4_Grafos.java`: `agregarNodo()`, `agregarArista()`, `bfs()` y `dijkstra()`.
* Crear los nodos correspondientes a las ubicaciones definidas en el programa y registrar sus conexiones mediante aristas con pesos asociados.
* Implementar el algoritmo Breadth First Search (BFS) para encontrar la ruta con el menor número de paradas entre un nodo de origen y un nodo de destino.
* Implementar el algoritmo de Dijkstra para determinar la ruta de menor distancia considerando los pesos asignados a las aristas.
* Ejecutar el programa y verificar el correcto funcionamiento de ambos algoritmos.
* Analizar y comparar los resultados obtenidos por BFS y Dijkstra, identificando las diferencias entre la ruta con menos paradas y la ruta con menor distancia.

---

# 2.5 Listado de Equipos, Materiales y Recursos

## Equipos y materiales utilizados

* Inteligencia Artificial.
* Java.
* Visual Studio Code.
* GitHub.
* Internet.
* Computador de escritorio o portátil con JDK instalado.

## TAC Utilizadas

* Plataformas educativas.
* Aplicaciones educativas.
* Inteligencia Artificial.

---

# 2.6 Actividades por Desarrollar

* Analizar la estructura y funcionamiento de los grafos como herramienta para representar rutas y conexiones.
* Diseñar la representación del Campus Huachi mediante nodos y aristas.
* Implementar la estructura de datos utilizando listas de adyacencia.
* Desarrollar el método `agregarNodo()`.
* Implementar el método `agregarArista()`.
* Programar el algoritmo BFS.
* Implementar el algoritmo de Dijkstra.
* Ejecutar pruebas de funcionamiento.
* Comparar los resultados obtenidos.
* Documentar el código mediante comentarios.
* Generar evidencias de ejecución.
* Elaborar el informe técnico de la práctica.

---

# 2.7 Resultados Obtenidos

## Repositorio GitHub

https://github.com/Daniela-Quispe/APE-4_Grafos

## Tema

**Grafos: Mapa del Campus UTA**

---

# 1. INTRODUCCIÓN

Las estructuras de datos constituyen uno de los pilares fundamentales dentro del desarrollo de software, ya que permiten organizar, almacenar y procesar información de manera eficiente. Entre las estructuras más importantes se encuentran los grafos, los cuales son ampliamente utilizados para representar relaciones, conexiones y recorridos entre distintos elementos.

Un grafo está compuesto por un conjunto de nodos o vértices y un conjunto de aristas que representan las conexiones existentes entre ellos. Gracias a esta estructura es posible modelar problemas reales relacionados con redes de transporte, sistemas GPS, telecomunicaciones, redes sociales, inteligencia artificial y optimización de rutas.

En la presente práctica se desarrolló una representación de rutas mediante grafos utilizando listas de adyacencia en Java. Esta implementación permite almacenar de forma eficiente las conexiones existentes entre diferentes ubicaciones y aplicar algoritmos de búsqueda para determinar rutas óptimas.

Para el análisis se implementaron dos algoritmos fundamentales:

* Breadth First Search (BFS).
* Algoritmo de Dijkstra.

Cada algoritmo resuelve un problema diferente:

* BFS encuentra la ruta con menor cantidad de paradas.
* Dijkstra encuentra la ruta con menor distancia acumulada.

La práctica permite fortalecer conocimientos relacionados con estructuras de datos no lineales, algoritmos de búsqueda, optimización de rutas y aplicación de grafos en problemas reales.

---

# 2. MARCO TEÓRICO

## Grafos

Los grafos son estructuras de datos no lineales utilizadas para representar relaciones entre diferentes elementos.

Matemáticamente se representan como:

**G = (V, E)**

Donde:

* V representa el conjunto de vértices o nodos.
* E representa el conjunto de aristas o conexiones.

En esta práctica los nodos representan ubicaciones del campus y las aristas representan las rutas entre dichas ubicaciones.

---

## Tipos de Grafos

### Grafo Dirigido

Las conexiones poseen una dirección específica.

Ejemplo:

A → B

---

### Grafo No Dirigido

Las conexiones pueden recorrerse en ambos sentidos.

Ejemplo:

A ↔ B

La práctica utiliza un grafo no dirigido.

---

### Grafo Ponderado

Cada conexión posee un peso asociado.

Ejemplo:

A ----50---- B

Los pesos representan distancias entre ubicaciones.

---

## Lista de Adyacencia

La lista de adyacencia permite representar un grafo almacenando para cada nodo una lista de sus vecinos.

Ejemplo:

```text
Universidad:
   FISEI (50)
   Comedor (20)

FISEI:
   Universidad (50)
   Idiomas (40)
```

### Ventajas

* Menor consumo de memoria.
* Mayor eficiencia en grafos dispersos.
* Facilidad para recorrer vecinos.

---

## Algoritmo Breadth First Search (BFS)

BFS es un algoritmo de búsqueda en anchura que explora los nodos por niveles utilizando una cola FIFO.

### Funcionamiento

1. Insertar el nodo inicial en una cola.
2. Marcarlo como visitado.
3. Explorar sus vecinos.
4. Insertar vecinos no visitados.
5. Repetir hasta encontrar el destino.

### Complejidad

O(V + E)

### Característica principal

Encuentra la ruta con menor cantidad de paradas.

---

## Algoritmo de Dijkstra

El algoritmo de Dijkstra permite encontrar la ruta de menor costo o distancia en un grafo ponderado.

### Funcionamiento

1. Inicializar todas las distancias en infinito.
2. Asignar distancia cero al origen.
3. Seleccionar el nodo con menor distancia.
4. Actualizar las distancias de los vecinos.
5. Repetir el proceso.

### Complejidad

O((V + E) log V)

### Característica principal

Encuentra la ruta con menor distancia acumulada.

---

## Cola (Queue)

Estructura FIFO (First In First Out).

Operaciones:

* Encolar.
* Desencolar.
* Consultar el primer elemento.

BFS utiliza una cola para gestionar el recorrido.

---

## Cola de Prioridad (Priority Queue)

Permite extraer siempre el elemento con mayor prioridad.

En Dijkstra la prioridad corresponde a la menor distancia acumulada.

---

## Aplicaciones de los Grafos

* Sistemas GPS.
* Redes de transporte.
* Redes sociales.
* Telecomunicaciones.
* Inteligencia artificial.
* Sistemas de recomendación.
* Optimización de rutas.

---

# 3. DESARROLLO DEL EJERCICIO

## 3.1 Análisis del Problema

Se requiere implementar un grafo utilizando listas de adyacencia para representar rutas entre ubicaciones.

Para ello se identificaron:

* Nodos.
* Aristas.
* Distancias.
* Algoritmos de búsqueda.

---

## 3.2 Creación de la Clase Nodo

```java
static class Nodo {
    String id;
    String nombre;

    public Nodo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
```

Función:

Representar cada ubicación dentro del grafo.

---

## 3.3 Creación de la Clase Arista

```java
static class Arista {
    String destino;
    int peso;

    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}
```

Función:

Representar una conexión entre nodos.

---

## 3.4 Creación de la Estructura Grafo

```java
Map<String, Nodo> nodos = new HashMap<>();
Map<String, List<Arista>> adyacencia = new HashMap<>();
```

Función:

* Almacenar nodos.
* Almacenar conexiones.

---

## 3.5 Implementación de agregarNodo()

```java
public void agregarNodo(String id, String nombre) {
    nodos.put(id, new Nodo(id, nombre));
    adyacencia.put(id, new ArrayList<>());
}
```

Permite registrar nuevos nodos dentro del grafo.

---

## 3.6 Implementación de agregarArista()

```java
public void agregarArista(String origen, String destino, int peso) {

    adyacencia.get(origen)
              .add(new Arista(destino, peso));

    adyacencia.get(destino)
              .add(new Arista(origen, peso));
}
```

Permite conectar dos nodos del grafo.

---

## 3.7 Registro de Nodos

```java
grafo.agregarNodo("uta", "Universidad");
grafo.agregarNodo("fisei", "FISEI");
grafo.agregarNodo("idiomas", "Idiomas");
grafo.agregarNodo("biblioteca", "Biblioteca");
grafo.agregarNodo("estadio", "Estadio");
grafo.agregarNodo("comedor", "Comedor");
```

Total: 6 nodos.

---

## 3.8 Registro de Conexiones

```java
grafo.agregarArista("uta", "fisei", 50);
grafo.agregarArista("fisei", "idiomas", 40);
grafo.agregarArista("idiomas", "biblioteca", 30);
grafo.agregarArista("biblioteca", "estadio", 70);

grafo.agregarArista("uta", "comedor", 20);
grafo.agregarArista("comedor", "estadio", 200);
```

---

## 3.9 Implementación de BFS

El algoritmo BFS utiliza una cola para recorrer el grafo por niveles.

Objetivo:

Encontrar la ruta con menor cantidad de paradas.

Resultado:

```text
Universidad -> Comedor -> Estadio
```

---

## 3.10 Implementación de Dijkstra

El algoritmo utiliza:

```java
Map<String, Integer> distancias;
Map<String, String> anteriores;
PriorityQueue<String> cola;
```

Objetivo:

Encontrar la ruta con menor distancia.

Resultado:

```text
Universidad -> FISEI -> Idiomas -> Biblioteca -> Estadio
```

---

## 3.11 Ejecución del Programa

Salida obtenida:

```text
===== BFS =====
Universidad (uta) -> Comedor (comedor) -> Estadio (estadio)

===== DIJKSTRA =====
Universidad (uta) -> FISEI (fisei) -> Idiomas (idiomas) -> Biblioteca (biblioteca) -> Estadio (estadio)
```

---

## 3.12 Análisis de Resultados

### BFS

Ruta encontrada:

```text
Universidad -> Comedor -> Estadio
```

Distancia:

20 + 200 = 220

Busca minimizar el número de conexiones.

---

### Dijkstra

Ruta encontrada:

```text
Universidad -> FISEI -> Idiomas -> Biblioteca -> Estadio
```

Distancia:

50 + 40 + 30 + 70 = 190

Busca minimizar la distancia total.

---

# 4. COMPARACIÓN DE RESULTADOS

| Criterio                         | BFS                             | Dijkstra                                             |
| -------------------------------- | ------------------------------- | ---------------------------------------------------- |
| Objetivo                         | Menor número de paradas         | Menor distancia total                                |
| Considera pesos                  | No                              | Sí                                                   |
| Ruta encontrada                  | Universidad → Comedor → Estadio | Universidad → FISEI → Idiomas → Biblioteca → Estadio |
| Número de conexiones             | 2                               | 4                                                    |
| Distancia total                  | 220                             | 190                                                  |
| Resultado óptimo según distancia | No                              | Sí                                                   |
| Estructura utilizada             | Cola                            | Cola de prioridad                                    |
| Complejidad                      | O(V+E)                          | O((V+E) log V)                                       |

Los resultados demuestran que una ruta con menos paradas no necesariamente corresponde a la ruta más corta.

BFS minimiza el número de conexiones mientras que Dijkstra minimiza la distancia total recorrida.

---

# 5. CONCLUSIONES

* Se implementó correctamente un grafo mediante listas de adyacencia utilizando Java.
* Se logró representar las conexiones entre diferentes ubicaciones mediante nodos y aristas ponderadas.
* El algoritmo BFS permitió encontrar la ruta con menor cantidad de paradas entre el origen y el destino.
* El algoritmo de Dijkstra permitió determinar la ruta con menor distancia acumulada considerando los pesos asociados a cada conexión.
* Se comprobó que BFS y Dijkstra producen resultados diferentes debido a que optimizan criterios distintos.
* La práctica fortaleció conocimientos relacionados con grafos, recorridos, estructuras dinámicas y optimización de rutas.

---

# 6. RECOMENDACIONES

* Utilizar pesos reales para representar distancias exactas entre ubicaciones.
* Incorporar más nodos para representar de forma más completa el Campus Huachi.
* Implementar interfaces gráficas para visualizar las rutas encontradas.
* Realizar pruebas con grafos de mayor tamaño para analizar el comportamiento de los algoritmos.
* Complementar la implementación con otros algoritmos de búsqueda de caminos mínimos.

---

[8] Codecademy, “Dijkstra's Shortest Path Algorithm,” [En línea]. Disponible en: https://www.codecademy.com/article/dijkstras-shortest-path-algorithm [Accedido: 30-may-2026].
