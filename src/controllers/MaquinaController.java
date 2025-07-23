package controllers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import models.Maquina;

public class MaquinaController {
    // Método A
    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> stack = new Stack<>();
        for (Maquina m : maquinas) {
            if (m.getSubred() < umbral) {
                stack.push(m);
            }
        }
        return stack;
    }

    // Método B
    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        TreeSet<Maquina> ordenadas = new TreeSet<>(new Comparator<Maquina>() {
            @Override
            public int compare(Maquina m1, Maquina m2) {
                int comp = Integer.compare(m1.getSubred(), m2.getSubred());
                if (comp != 0) return comp;
                return m1.getNombre().compareTo(m2.getNombre());
            }
        });

        for (Maquina m : pila) {
            ordenadas.add(m);
        }
        return ordenadas;
    }

    // Método C
    public Map<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        TreeMap<Integer, Queue<Maquina>> mapa = new TreeMap<>();
        for (Maquina m : maquinas) {
            int riesgo = m.getRiesgo();
            mapa.putIfAbsent(riesgo, new LinkedList<>());
            mapa.get(riesgo).add(m);
        }
        return mapa;
    }

    // Método D
    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {
        int maxCantidad = -1;
        int riesgoMax = -1;
        Queue<Maquina> grupoSeleccionado = null;

        for (Map.Entry<Integer, Queue<Maquina>> entry : mapa.entrySet()) {
            int cantidad = entry.getValue().size();
            int riesgo = entry.getKey();

            if (cantidad > maxCantidad || (cantidad == maxCantidad && riesgo > riesgoMax)) {
                maxCantidad = cantidad;
                riesgoMax = riesgo;
                grupoSeleccionado = entry.getValue();
            }
        }

        Stack<Maquina> resultado = new Stack<>();
        if (grupoSeleccionado != null) {
            for (Maquina m : grupoSeleccionado) {
                resultado.push(m);
            }
        }

        return resultado;
    }

    
}
