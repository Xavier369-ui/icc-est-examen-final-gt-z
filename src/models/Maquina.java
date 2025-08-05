package models;

import java.util.List;
import java.util.Objects;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        this.subred = calcularSubred();
        this.riesgo = calcularRiesgo();
    }

    public int calcularSubred() {
        String[] octetos = ip.split("\\.");
        return Integer.parseInt(octetos[3]);
    }

    public int calcularRiesgo() {
        // Suma de códigos divisibles por 3 (según requisito original)
        int suma = codigos.stream()
                         .filter(c -> c % 3 == 0)
                         .mapToInt(Integer::intValue)
                         .sum();
        
        // Caracteres únicos sin espacios
        long charsUnicos = nombre.replace(" ", "").chars().distinct().count();
        
        return suma * (int)charsUnicos;
    }

    // Getters requeridos
    public String getNombre() { return nombre; }
    public String getIp() { return ip; }
    public List<Integer> getCodigos() { return codigos; }
    public int getSubred() { return subred; }
    public int getRiesgo() { return riesgo; }
    
    @Override
    public String toString() {
        return nombre + " - " + ip + " (Subred: " + subred + ", Riesgo: " + riesgo + ")";
    }

    // equals y hashCode para manejar duplicados en TreeSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maquina maquina = (Maquina) o;
        return subred == maquina.subred && nombre.equals(maquina.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, subred);
    }
    
}
