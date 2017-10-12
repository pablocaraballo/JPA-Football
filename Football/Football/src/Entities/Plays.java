package Entities;


import java.io.Serializable;
import java.util.Date;

public class Plays implements Serializable {
	private int starts;
	private int substituted;
	private int goals;
	private int yellow;
	private boolean red;
	private Player player;
	  
	public Plays(int starts,int substituted, int goals, int yellow, boolean red, Player player) {
		super();
		this.starts = starts;
		this.substituted = substituted;
		this.goals = goals;
		this.yellow = yellow;
		this.red = red;
		this.player = player;
		
	}
	public Plays() {
		super();
		
	}
	public int getStarts() {
		return starts;
	}
	public void setStarts(int starts) {
		this.starts = starts;
	}
	public int getSubstituted() {
		return substituted;
	}
	public void setSubstituted(int substituted) {
		this.substituted = substituted;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public int getYellow() {
		return yellow;
	}
	public void setYellow(int yellow) {
		this.yellow = yellow;
	}
	public boolean isRed() {
		return red;
	}
	public void setRed(boolean red) {
		this.red = red;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	@Override
	public String toString() {
		return "Plays [starts=" + starts + ", substituted =" + substituted + ", goals =" + goals+ ", "
				+ "yellow =" + yellow + ", red =" + red  + "]";
	}
	

}
