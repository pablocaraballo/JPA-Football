package Entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Match implements Serializable {
	int code;
	Date played;
	Team home;
	Team away;
	Set<Plays> plays=new HashSet<Plays>();
	
	
	  
	public Match(int code, Date played, Team home, Team away) {
		super();
		this.code = code;
		this.played= played;
		this.home = home;
		this.away = away;		
	}
	public Match() {
		super();
		
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getPlayed() {
		return played;
	}
	public void setPlayed(Date played) {
		this.played = played;
	}
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	
	public void addPlays(Plays p){
		
		plays.add(p);
		
	}
	public Team getAway() {
		return away;
	}
	public void setAway(Team away) {
		this.away = away;
	}
	public Set<Plays> getPlays() {
		return plays;
	}
	public void setPlays(Set<Plays> plays) {
		this.plays = plays;
	}
	@Override
	public String toString() {
		return "Match [code=" + code + ", played=" + played + ", home=" + home.getCode() + ", Away=" + away.getCode() + "]";
	}
	

}
