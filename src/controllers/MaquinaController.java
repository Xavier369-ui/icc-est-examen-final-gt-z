package controllers;

import java.util.ArrayList;
import java.util.Collections;
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
    
    // Método A: Filtrar máquinas con subred < umbral (manteniendo orden original)
    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> resultado = new Stack<>();
        // Recorremos en orden inverso para mantener el orden al sacar de la pila
        for (int i = maquinas.size()-1; i >= 0; i--) {
            Maquina m = maquinas.get(i);
            if (m.getSubred() < umbral) {
                resultado.push(m);
            }
        }
        return resultado;
    }

    // Método B: Ordenar por subred ASC y nombre ASC (eliminando duplicados)
    public TreeSet<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        TreeSet<Maquina> resultado = new TreeSet<>(
            Comparator.comparingInt(Maquina::getSubred)
                      .thenComparing(Maquina::getNombre)
        );
        
        // Copiamos la pila para no modificar la original
        Stack<Maquina> copiaPila = new Stack<>();
        copiaPila.addAll(pila);
        
        while (!copiaPila.isEmpty()) {
            resultado.add(copiaPila.pop());
        }
        
        return resultado;
    }

    // Método C: Agrupar por riesgo (orden ASC)
    public TreeMap<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        TreeMap<Integer, Queue<Maquina>> mapa = new TreeMap<>();
        
        for (Maquina m : maquinas) {
            int riesgo = m.getRiesgo();
            mapa.putIfAbsent(riesgo, new LinkedList<>());
            mapa.get(riesgo).add(m);
        }
        
        return mapa;
    }

    // Método D: Explotar grupo más grande (mayor riesgo en empate)
    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {
        Map.Entry<Integer, Queue<Maquina>> mayorGrupo = null;
        
        for (Map.Entry<Integer, Queue<Maquina>> entry : mapa.entrySet()) {
            if (mayorGrupo == null || 
                entry.getValue().size() > mayorGrupo.getValue().size() ||
                (entry.getValue().size() == mayorGrupo.getValue().size() && 
                 entry.getKey() > mayorGrupo.getKey())) {
                mayorGrupo = entry;
            }
        }
        
        Stack<Maquina> resultado = new Stack<>();
        if (mayorGrupo != null) {
            // Convertir la cola a pila (orden LIFO)
            Queue<Maquina> cola = mayorGrupo.getValue();
            List<Maquina> temp = new ArrayList<>(cola);
            Collections.reverse(temp);
            resultado.addAll(temp);
        }
        
        return resultado;
    }
}
