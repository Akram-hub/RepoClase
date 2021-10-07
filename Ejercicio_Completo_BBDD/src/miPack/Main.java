package miPack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Metodos m1 = new Metodos();
		Persona d1 = new Persona();

//		m1.SelectBBDD();
//		m1.InsertBBDD();
		
		Scanner sc = new Scanner(System.in);
//		Scanner rs = new Scanner(System.in);
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false;
		int opcion;
		
		String nombre;
		int id;
		String fecha_nac;
//		Date fecha;
		int id_mod;
	    
			while(!exit) {
				System.out.println("-------------------");
				System.out.println("|MENU BASE DE DATOS|");
				System.out.println("-------------------");
				System.out.println("1. Select BBDD .java");
				System.out.println("2. Insert BBDD .java");
				System.out.println("3. Update");
				System.out.println("4. Delete");
				System.out.println("5. Salir");
				
				try {
					
					opcion = sc.nextInt();

					switch(opcion) {
						
						case 1:
							System.out.println("-------------------");
							System.out.println("|Seleccionar Datos|");
							System.out.println("-------------------");
							
							System.out.println("Datos seleccionados: ");
							System.out.println("NOMBRE  ID  FECHANAC");
							m1.SelectBBDD();
					
						break;
						case 2:
							System.out.println("---------------");
							System.out.println("|Inserte Datos|");
							System.out.println("---------------");
							
							System.out.println("Inserte NOMBRE");
							nombre = rd.readLine();
							d1.setNombre(nombre);

							System.out.println("Inserte ID");
							id = sc.nextInt();
							d1.setId(id);
							
							System.out.println("Inserte FECHANAC");
							fecha_nac = rd.readLine();
							d1.setFecha_nac(fecha_nac);
							
							m1.InsertBBDD(nombre, id, fecha_nac);
							System.out.println("Datos insertados correctamente");
							
						break;
						case 3:
							System.out.println("---------------");
							System.out.println("|Update Datos|");
							System.out.println("---------------");
							
							System.out.println("Inserte ID a modificar");
							id_mod = sc.nextInt();
							d1.setId(id_mod);
							
							System.out.println("Inserte NOMBRE (nuevo)");
							nombre = rd.readLine();
							d1.setNombre(nombre);

							System.out.println("Inserte ID (nuevo)");
							id = sc.nextInt();
							d1.setId(id);
							
							System.out.println("Inserte FECHANAC (nuevo)");
							fecha_nac = rd.readLine();
							d1.setFecha_nac(fecha_nac);
							
							
							m1.UpdateBBDD(nombre, id, fecha_nac, id_mod);
							System.out.println("Datos modificados correctamente");
							
						break;
						case 4:
							System.out.println("---------------");
							System.out.println("|Delete Datos|");
							System.out.println("---------------");
							
							System.out.println("Inserte ID de la fila que quiere eliminar");
							id = sc.nextInt();
							d1.setId(id);
							
							m1.Delete(id);
							System.out.println("Datos eliminados correctamente");
						break;
						case 5:
							exit = true;
						break;
						default:
							System.out.println("Seleccione una opcion (digite numeros del 1 al 4)");
					}
					//sc.close();
				} catch(Exception e) {
					System.out.println("Debes insertar un n�mero");
					sc.next();
					e.printStackTrace();
				}
			}
			sc.close();
	}

}

