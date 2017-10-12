import java.util.List;

import javax.persistence.EntityManager;

import Entities.Player;

public class PlayerManager {
	
	public void addPlayer(Player player){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(player);
		em.getTransaction().commit();
		em.close();
	}
	
	public void listPlayers(){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		List<Player> result=em.createQuery("from Player", Player.class)
				.getResultList();
		for(Player player: result){
			System.out.println(player.toString());
		}
	}
	
	public void updatePlayer(Integer id, String nombre){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Player player=(Player) em.find(Player.class, id);
		player.setForename(nombre);
		em.merge(player);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deletePlayer(Integer id){
		
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Player player=(Player) em.find(Player.class, id);
		em.remove(player);
		em.getTransaction().commit();
		em.close();
	}
}
