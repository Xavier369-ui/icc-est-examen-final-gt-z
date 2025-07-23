import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import controllers.MaquinaController;
import models.Maquina;

public class App {
    public static void main(String[] args) throws Exception {
        List<Maquina> maquinas = crearMaquinas();

    }

    static List<Maquina> crearMaquinas() {

        List<Maquina> maquinas = Arrays.asList(
                new Maquina("Controlador20", "155.25.220.238", Arrays.asList(21, 30, 29, 16)),
                new Maquina("DB3", "172.144.210.32", Arrays.asList(4, 29, 16, 6, 2)),
                new Maquina("Nodo20", "107.227.99.52", Arrays.asList(13, 29, 16, 19, 21)),
                new Maquina("Web9", "152.151.220.228", Arrays.asList(6, 14, 20, 28)),
                new Maquina("Nodo1", "79.81.250.200", Arrays.asList(3, 21, 29, 2, 10)),
                new Maquina("Proxy9", "118.100.50.194", Arrays.asList(10, 21, 9)),
                new Maquina("Servidor19", "156.194.75.201", Arrays.asList(2, 12, 6, 21)),
                new Maquina("Cache13", "63.124.90.218", Arrays.asList(2, 7, 18)),
                new Maquina("Nodo18", "45.75.99.209", Arrays.asList(24, 25, 3, 19, 9)),
                new Maquina("Cache19", "170.18.150.40", Arrays.asList(10, 23, 3, 17)),
                new Maquina("Servidor5", "179.88.180.199", Arrays.asList(26, 1, 18, 10, 24)),
                new Maquina("Nodo1", "46.127.150.235", Arrays.asList(9, 8, 27, 30)),
                new Maquina("Cliente16", "61.181.150.223", Arrays.asList(23, 14, 30)),
                new Maquina("Cache5", "55.157.250.217", Arrays.asList(3, 10, 18)),
                new Maquina("Servidor6", "90.81.220.74", Arrays.asList(29, 5, 2)),
                new Maquina("Backup4", "109.136.180.44", Arrays.asList(21, 17, 7, 12, 14)),
                new Maquina("Cache11", "10.57.220.239", Arrays.asList(3, 6, 23)),
                new Maquina("Nodo7", "39.239.100.167", Arrays.asList(21, 16, 4, 15)),
                new Maquina("Controlador15", "189.71.210.192", Arrays.asList(13, 25, 6, 3)),
                new Maquina("Nodo1", "144.171.100.184", Arrays.asList(15, 20, 4, 18)),
                new Maquina("Servidor14", "157.163.120.234", Arrays.asList(20, 16, 17, 5)),
                new Maquina("Backup2", "32.60.200.93", Arrays.asList(5, 8, 26, 4, 13)),
                new Maquina("Web1", "109.145.50.136", Arrays.asList(9, 17, 1, 11, 4)),
                new Maquina("Gateway2", "162.106.99.202", Arrays.asList(3, 13, 19, 8, 14)),
                new Maquina("Controlador13", "107.96.75.65", Arrays.asList(19, 9, 16, 18, 17)),
                new Maquina("DB6", "60.161.240.214", Arrays.asList(14, 6, 26, 13, 10)),
                new Maquina("Cliente1", "125.206.50.228", Arrays.asList(18, 15, 3, 17)),
                new Maquina("Cliente20", "107.1.150.55", Arrays.asList(6, 18, 4)),
                new Maquina("Cache14", "116.240.150.64", Arrays.asList(22, 26, 4, 13)),
                new Maquina("DB20", "98.241.90.82", Arrays.asList(9, 26, 15, 25, 16)),
                new Maquina("Gateway9", "139.10.250.20", Arrays.asList(21, 30, 18)),
                new Maquina("Backup7", "131.161.150.103", Arrays.asList(29, 12, 5)),
                new Maquina("Proxy1", "146.34.200.73", Arrays.asList(10, 8, 20)),
                new Maquina("Servidor14", "16.124.50.184", Arrays.asList(6, 4, 15, 25)),
                new Maquina("Nodo19", "174.178.180.27", Arrays.asList(10, 14, 25, 30, 18)),
                new Maquina("Web17", "22.193.180.36", Arrays.asList(24, 12, 21, 6)),
                new Maquina("Web10", "93.39.210.164", Arrays.asList(15, 23, 27, 26)),
                new Maquina("Cache11", "131.127.250.68", Arrays.asList(24, 11, 1, 26, 28)),
                new Maquina("Cliente2", "138.96.75.97", Arrays.asList(15, 23, 4, 7)),
                new Maquina("Gateway13", "50.88.75.47", Arrays.asList(5, 27, 30, 2)),
                new Maquina("Proxy14", "110.209.90.236", Arrays.asList(30, 18, 7)),
                new Maquina("Servidor18", "11.15.120.159", Arrays.asList(28, 26, 4, 29, 23)),
                new Maquina("Controlador9", "175.187.220.68", Arrays.asList(13, 14, 16, 9)),
                new Maquina("Web12", "166.129.75.84", Arrays.asList(6, 10, 7)),
                new Maquina("Cache15", "133.207.50.55", Arrays.asList(2, 6, 10, 25)),
                new Maquina("Cliente3", "168.227.50.20", Arrays.asList(13, 26, 5, 14, 30)),
                new Maquina("DB4", "87.64.240.164", Arrays.asList(17, 14, 5, 23)),
                new Maquina("Nodo7", "23.248.75.5", Arrays.asList(18, 28, 10, 27, 29)),
                new Maquina("Nodo6", "169.238.150.174", Arrays.asList(6, 14, 3)),
                new Maquina("DB13", "71.248.50.86", Arrays.asList(17, 11, 12))
                );
                MaquinaController controller = new MaquinaController();
                System.out.println("Metodo A - filtrarPorSubred > 100:");
                Stack<Maquina> pila = controller.filtrarPorSubred(maquinas, 100);
                pila.forEach(System.out::println);
                System.out.println("Metodo B - ordenarPorSubred:");
                Set<Maquina> ordenado = controller.ordenarPorSubred(pila);
                ordenado.forEach(System.out::println);
                System.out.println("Metodod C - agruparPorRiesgo:");
                Map<Integer,Queue<Maquina>> mapa = controller.agruparPorRiesgo(maquinas);
                mapa.forEach((riesgo,cola) -> {
                    System.out.println("Riesgo"+ riesgo + "→" + cola);
                });
                System.out.println("Metodo D - explotarGrupo:");
                Stack<Maquina> grupoMayor = controller.explotarGrupo(mapa);
                grupoMayor.forEach(System.out::println);
        return maquinas;

    }
}
