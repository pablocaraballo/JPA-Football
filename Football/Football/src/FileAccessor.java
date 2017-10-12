
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

import Entities.*;

/**
 * @author Pablo Caraballo & Antonio Rodriguez
 * @version FileAccessorv01
 * @since 15/02/2017
 */

public class FileAccessor {

	ArrayList<Team> listaEquipos = new ArrayList();
	//ArrayList<Player> listaJugadores = new ArrayList();
	ArrayList<Match> listaPartidos = new ArrayList();
	//ArrayList<Plays> listaJuegos = new ArrayList();
	

	public FileAccessor() {
	}

	//####################### EQUIPOS #############################

	public void readEquipos(String filename) throws IOException {
		int code;
		String name,stadium,city;
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			code = Integer.parseInt(str.nextToken());
			name = str.nextToken();
			stadium = str.nextToken();
			city = str.nextToken();
			listaEquipos.add(new Team(code, name, stadium, city));

		}
		br.close();
	}

	public void printEquipos() {
		
		System.out.println("####################### EQUIPOS #############################");
		for (int i = 0; i < listaEquipos.size(); i++) {
			System.out.println(listaEquipos.get(i).toString());
		}
	}
	
	//####################### PARTIDOS #############################
	
	public void readPartidos(String filename) throws IOException, ParseException {
		int code, count=0;
		Date date;
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Team home=new Team();
		Team away=new Team();
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");
			code = Integer.parseInt(str.nextToken());
			date = dateformat.parse(str.nextToken());
			//COMPARAR ID DE HOME CON LA LISTA DE EQUIPOS Y SELECCIONAR EQUIPO LOCAL
				
				home=listaEquipos.get(count);
				
			//COMPARAR ID DE AWAY CON LA LISTA DE EQUIPOS Y SELECCIONAR EQUIPO VISITANTE
		
				away=listaEquipos.get(count+1);
			
			listaPartidos.add(new Match(code, date,home,away));
			count+=2;
			if(count>=4)
				count=0;
		}
		br.close();
	}

	public void printPartidos() {
		System.out.println("####################### PARTIDOS #############################");
		for (int i = 0; i < listaPartidos.size(); i++) {
			System.out.println(listaPartidos.get(i).toString());
		}
		System.out.println("##############################################################");
	}
	
	//################################# PLAYERS ##################################
	
		public void readPlayersFile(String filename) throws IOException {
			int id_player,cont=0;
			String surname, forename;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(linea, ",");
				id_player = Integer.parseInt(str.nextToken());
				forename = str.nextToken();
				surname = str.nextToken();
				listaEquipos.get(cont).addJugador(new Player(id_player, forename, surname));
				cont++;
			}
			br.close();
		}
		
		public void printJugadores() {
			
			System.out.println("####################### JUGADORES #############################");
			for (int i = 0; i < listaEquipos.size(); i++) {
				
				System.out.println("######### "+listaEquipos.get(i).getName()+" #########");
				
				for(Player p : listaEquipos.get(i).getPlayers()){
					System.out.println(p);
				}
			}
		}
		
	//################################# JUEGOS ##################################

	public void readJuegos(String filename)
			throws IOException {
		int starts, substituted, goals,yellow, id,cont=0;
		boolean red;
		Player jugador=null;
		
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String linea=br.readLine();
		
		while(linea!=null){
			StringTokenizer token=new StringTokenizer(linea, ",");
			id=Integer.parseInt(token.nextToken());
			starts=Integer.parseInt(token.nextToken());
			substituted=Integer.parseInt(token.nextToken());
			goals=Integer.parseInt(token.nextToken());
			yellow=Integer.parseInt(token.nextToken());
			red=Boolean.parseBoolean(token.nextToken());
			
			for(int i=0; i<listaEquipos.size(); i++){
				
				for(Player p : listaEquipos.get(i).getPlayers()){
					
					if(id==p.getId()){
						jugador=p;
					}
				}
			}
			listaPartidos.get(cont).addPlays(new Plays(starts,substituted,goals,yellow,red,jugador));
			linea=br.readLine();
			cont++;
		}
	}
	
	public void printJuegos() {
		
		for (int i = 0; i < listaPartidos.size(); i++) {
			
			for(Plays p: listaPartidos.get(i).getPlays()){
				
				System.out.println(p);
			}
		}
	}
}
