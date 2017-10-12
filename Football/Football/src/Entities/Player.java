package Entities;


import java.io.Serializable;
import java.util.Date;

public class Player implements Serializable {
	private int id;
	private String surname;
	private String forename;
	
	
	  
	public Player(int id, String forename, String surname) {
		super();
		this.id=id;
		this.surname = surname;
		this.forename = forename;
		
	}
	public Player() {
		super();
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", surname=" + surname + ", forename=" + forename + "]";
	}
	

}
