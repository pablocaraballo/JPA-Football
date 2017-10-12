import java.util.List;

import javax.persistence.EntityManager;

import Entities.Team;

public class TeamManager {
	
	public void addTeam(Team team){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(team);
		em.getTransaction().commit();
		em.close();
	}
	
	public void listTeams(){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		List<Team> result=em.createQuery("from Team", Team.class)
				.getResultList();
		for(Team Team: result){
			System.out.println(Team.toString());
		}
	}
	
	public void updateTeam(Integer id, String nombre){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Team Team=(Team) em.find(Team.class, id);
		Team.setStadium(nombre);
		em.merge(Team);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteTeam(Integer id){
		
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Team Team=(Team) em.find(Team.class, id);
		em.remove(Team);
		em.getTransaction().commit();
		em.close();
	}

}
