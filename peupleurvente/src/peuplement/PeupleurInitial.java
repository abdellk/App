package peuplement;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Annonce;
import modele.Type_annonce;
import modele.Utilisateur;

public class PeupleurInitial {

	public PeupleurInitial() {
		super();
	}

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("peuplement");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Utilisateur defaultadmin = new Utilisateur("Admin", "Defaut", "AD", "default-admin@test.fr", "mdp");
													
		Utilisateur vidal = new  Utilisateur("Vidal", "Fabrice", "Doppio", "fabricevidal@test.fr", "mdp");
		Utilisateur bucce = new  Utilisateur("Buc", "Bruno", "Trou", "passion@test.fr", "mdp");
		

		//Utilisateur pirlo = new  Utilisateur("Pirlo", "Damien", "Double", "default-admin@test.fr", "mdp");
											//nom      prenom    pseudo          email            password
		Type_annonce offre = new Type_annonce("Offre");
		Type_annonce demande = new Type_annonce("Demande");
		Annonce newannonce = new Annonce ();
		
		em.persist(defaultadmin);
		em.persist(vidal);
		em.persist(bucce);
	//	em.persist(pirlo);
		em.persist(offre);
		em.persist(demande);
		em.persist(newannonce);	
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
