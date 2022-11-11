package CRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static CRUD.CentroSalud.*;

public class Main {
    public static void main(String[] args) {
        Connection con = conectar();
        try {
            Statement st = con.createStatement();
            opcionesMenu(st);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void opcionesMenu(Statement st) {
        Scanner s = new Scanner(System.in);
        int opc;
        do {
            mostrarMenu();
            opc = s.nextInt();
            switch (opc) {
                case 1 -> crearTablas(st);
                case 2 -> {
                    System.out.println("Introduzca la tabla en la que desea insertar datos");
                    insertar(st, pedirTablaConVerificacion());
                }
                case 3 -> LeerInsertarMockaroo.leerInsertarMockaroo(st);
                case 4 -> {
                    System.out.println("Introduzca la tabla que desea listar");
                    listar(st, pedirTablaConVerificacion());
                }
                case 5 -> {
                    System.out.println("Introduzca la tabla que desea modificar");
                    modificar(st, pedirTablaConVerificacion());
                }
                case 6 -> {
                    System.out.println("Introduzca la tabla en la que desea borrar un registro");
                    borrarRegistro(st, pedirTablaConVerificacion());
                }
                case 7 -> {
                    System.out.println("Introduzca la tabla en la que desea borrar todos los registros");
                    borrarTodosRegistros(st, pedirTablaConVerificacion());
                }
                case 8 -> {
                    System.out.println("Introduzca la tabla que desea eliminar");
                    eliminarTabla(st, pedirTablaConVerificacion());
                }
                default -> System.out.println("Gracias! :)");
            }
        } while (opc >= 1 && opc <= 8);
    }

    public static void mostrarMenu() {
        System.out.println("Elija el número correspondiente a la opción deseada\n" +
                "---------------------------------------------------\n" +
                "   1.-Crear tablas\n" +
                "   2.-Insertar registros\n" +
                "   3.-Insertar fichero Mockaroo\n" +
                "   4.-Listar registros\n" +
                "   5.-Modificar registro\n" +
                "   6.-Borrar un registro por id\n" +
                "   7.-Borrar todos los registros\n" +
                "   8.-Eliminar tabla\n" +
                "Pulse cualquier otro número para salir");
    }
}
