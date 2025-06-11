package Empresa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean repetir;

        do {
            try {
                System.out.print("Ingrese la cédula del empleado: ");
                String cedula = reader.readLine();
                if (cedula.isEmpty()) throw new IllegalArgumentException("La cédula no puede estar vacía.");

                System.out.print("Ingrese el nombre del empleado: ");
                String nombre = reader.readLine();
                if (nombre.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío.");

                System.out.print("Ingrese el departamento del empleado: ");
                String departamento = reader.readLine();
                if (departamento.isEmpty()) throw new IllegalArgumentException("El departamento no puede estar vacío.");

                System.out.print("Ingrese el salario bruto del empleado: ");
                double salarioBruto = Double.parseDouble(reader.readLine());
                if (salarioBruto < 0) throw new IllegalArgumentException("El salario no puede ser negativo.");

                System.out.print("¿Desea hacer descuentos adicionales? (si/no): ");
                String respuesta = reader.readLine();
                double descuentoAdicional = 0;
                if (respuesta.equalsIgnoreCase("si")) {
                    System.out.print("Ingrese el monto total de los descuentos adicionales: ");
                    descuentoAdicional = Double.parseDouble(reader.readLine());
                    if (descuentoAdicional < 0) throw new IllegalArgumentException("El descuento adicional no puede ser negativo.");
                }

                Empleado empleado = new Empleado(cedula, nombre, departamento, salarioBruto, descuentoAdicional);
                empleado.imprimirEncabezado();
                empleado.imprimirInformacion();

            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Formato numérico incorrecto.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

            System.out.print("¿Desea ingresar otro empleado? (si/no): ");
            try {
                String continuar = reader.readLine();
                repetir = continuar.equalsIgnoreCase("si");
            } catch (IOException e) {
                System.out.println("Error al leer la respuesta. Terminando el programa.");
                repetir = false;
            }

        } while (repetir);

        System.out.println("Programa terminado");
    }
}

