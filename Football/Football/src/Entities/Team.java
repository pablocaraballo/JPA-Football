package Entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Team implements Serializable {
	private int code;
	private String name;
	private String stadium;
	private String city;
	private Set<Player> players= new HashSet<Player>();
	  
	public Team(int code, String name, String stadium,
			String city) {
		super();
		this.code = code;
		this.name = name;
		this.stadium = stadium;
		this.city = city;
		
	}
	public Team() {
		super();
		
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	
	public void addJugador(Player p){
		players.add(p);
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	
	@Override
	public String toString() {
		return "Team [code=" + code + ", name=" + name + ", stadium=" + stadium
				+ ", city=" + city + "]";
	}
	

}



















