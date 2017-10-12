import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Match;

public class MatchManager {
	
	public void addMatch(Match match){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(match);
		em.getTransaction().commit();
		em.close();
	}
	
	public void listMatchs(){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		List<Match> result=em.createQuery("from Match", Match.class)
				.getResultList();
		for(Match match: result){
			System.out.println(match.toString());
		}
	}
	
	public void updateMatch(Integer id, Date fecha){
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Match match=(Match) em.find(Match.class, id);
		match.setPlayed(fecha);
		em.merge(match);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteMatch(Integer id){
		
		EntityManager em=MainFootball.emf.createEntityManager();
		em.getTransaction().begin();
		Match match=(Match) em.find(Match.class, id);
		em.remove(match);
		em.getTransaction().commit();
		em.close();
	}

}
