
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Plays;

public class PlaysManager {
	
	public void addPlays(Plays plays){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(plays);
		em.getTransaction().commit();
		em.close();
	}
	
	public void listPlayss(){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		List<Plays> result=em.createQuery("from Plays", Plays.class)
				.getResultList();
		for(Plays plays: result){
			System.out.println(plays.toString());
		}
	}
	
	public void updatePlays(Integer partido, Integer jugador , int goals){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Plays plays=(Plays) em.createQuery("from Plays Where Plays.id_partido="+partido+" AND Plays.id_jugador="+jugador, Plays.class);
		plays.setGoals(goals);
		em.merge(plays);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deletePlays(Integer id){
		
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Plays plays=(Plays) em.find(Plays.class, id);
		em.remove(plays);
		em.getTransaction().commit();
		em.close();
	}

}
