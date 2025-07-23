package models;

import java.util.HashSet;
import java.util.List;

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
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public List<Integer> getCodigos() {
        return codigos;
    }
    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }
    public int getSubred() {
        return subred;
    }
    public void setSubred(int subred) {
        this.subred = subred;
    }
    public int getRiesgo() {
        return riesgo;
    }
    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }
    @Override
    public String toString() {
        return "Maquina [nombre=" + nombre + ", ip=" + ip + ", codigos=" + codigos + ", subred=" + subred + ", riesgo="
                + riesgo + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((codigos == null) ? 0 : codigos.hashCode());
        result = prime * result + subred;
        result = prime * result + riesgo;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Maquina other = (Maquina) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (codigos == null) {
            if (other.codigos != null)
                return false;
        } else if (!codigos.equals(other.codigos))
            return false;
        if (subred != other.subred)
            return false;
        if (riesgo != other.riesgo)
            return false;
        return true;
    }
    public int calcularSubred(){
        String[] partes = ip.split("\\.");
        return Integer.parseInt(partes[3]);
    }
    public int calcularRiesgo() {
        int suma = 0;
        for (int c : codigos) {
            if(c % 3 == 0) suma += c;
        } 
        HashSet<Character> caracteres = new HashSet<>();
        for (char ch : nombre.replaceAll(" ", "").toCharArray()) {
            caracteres.add(ch);
        }
        return suma * caracteres.size();
       
    }
    
}
