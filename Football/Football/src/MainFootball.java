import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.*;

public class MainFootball {

	public static EntityManagerFactory emf;
	
	public static void main(String[] args) throws IOException, ParseException {
		
		try {
			emf = Persistence.createEntityManagerFactory("Football");
		} catch (Throwable ex) {
			System.err.println("Failed to create EntityManagerFactory object."
					+ ex);
			throw new ExceptionInInitializerError(ex);
		}
		//Instanciacion de Managers
		PlayerManager PM=new PlayerManager();
		TeamManager TM=new TeamManager();
		MatchManager MM=new MatchManager();
		PlaysManager PSM=new PlaysManager();
		
		//Instanciacion de FileAccessor
		FileAccessor fa=new FileAccessor();
		Menu menu=new Menu();
		
		//CARGA DE DATOS EN MEMORIA
		fa.readEquipos("equipos.csv");
		fa.readPartidos("partidos.csv");
		fa.readPlayersFile("jugadores.csv");
		fa.readJuegos("juegos.csv");
		
		int op = 0;
		do{
			op=menu.muestraMenu();
			switch(op){
			case 1: for(Match m : fa.listaPartidos){
						MM.addMatch(m);
					}
					TM.listTeams();
					fa.printJuegos();
					PM.listPlayers();
					MM.listMatchs();
					System.out.println("Carga de datos realiazada con éxito!");
			break;
			case 2: Player p=new Player(5,"Joan","Anton");
					PM.addPlayer(p);	
					System.out.println("El jugador "+ p.getForename()+" "+p.getSurname()+" ha sido añadido a la base de datos");
			break;
			case 3: TM.updateTeam(4, "Wanda Metropolitano"); 
					System.out.println("El Estadio del Atletico de Madrid ha pasado de llamarse Vicente Calderon a Wanda Metropolitano");
			break;
			case 4: System.out.println("Implementacion erronea || Mirar código comentado!!");
					/*PSM.updatePlays(1, 2, 0);
					System.out.println("En el partido 1 el jugador 2 ha metido 0 goles");
					System.out.println("Cambiado con éxito!");*/
			break;
			case 5: DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
					Date fecha=dateformat.parse("19/02/2017"); 
					MM.updateMatch(2, fecha);
					System.out.println("Fecha Modificada");
			break;
			case 6: PM.deletePlayer(5);
					System.out.println("Jugador con id 5 ha sido borrado con éxito");
			break;
			case 7: System.out.println("Hasta pronto!");
					System.exit(0);
			break;
			default: System.out.println("Opción incorrecta, prueba de nuevo!"); break;
			}
		}while(op!=7);
	}
}
