import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu {
	
	private int op;
	
	public int muestraMenu() throws NumberFormatException, IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("=====================================================");
		System.out.println("##################### FOOTBALL ######################");
		System.out.println("=====================================================");
		System.out.println("1. Cargar datos en BD");
		System.out.println("2. Añadir jugador");
		System.out.println("3. Actualizar estadio de equipo");
		System.out.println("4. Modificar jugada");
		System.out.println("5. Modificar fecha de partido");
		System.out.println("6. Dar de baja a jugador");
		System.out.println("7. Salir");
		System.out.print("Elige una opción: ");
		op=Integer.parseInt(br.readLine());
		return op;
	}

}
