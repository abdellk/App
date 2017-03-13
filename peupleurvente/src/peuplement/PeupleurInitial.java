package peuplement;


import java.util.Date;

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
		Utilisateur defaultadmin = new Utilisateur("Admin", "Defaut", "AD", "default-admin@test.fr", "mdp", new Date());
													
		Utilisateur vidal = new  Utilisateur("Vidal", "Fabrice", "Doppio", "fabricevidal@test.fr", "mdp", new Date());
		Utilisateur bucce = new  Utilisateur("Buc", "Bruno", "Trou", "passion@test.fr", "mdp", new Date());
		
		//Utilisateur pirlo = new  Utilisateur("Pirlo", "Damien", "Double", "default-admin@test.fr", "mdp");
		//nom      prenom    pseudo          email            password
		
		Type_annonce type1 = new Type_annonce("Telephonie");
		Type_annonce type2 = new Type_annonce("Television");
		Annonce telephone = new Annonce ("Vente de mon HTC One", "Tout neuf", new Date(), "Courbevoie", "92400", "200");
		Annonce television = new Annonce ("Vente d'une télé", "Pas neuf", new Date(), "Suresnes", "92", "400");
		
		vidal.ajoutAnnonce(telephone);
		bucce.ajoutAnnonce(television);
		
		type1.ajoutAnnonce(telephone);
		type2.ajoutAnnonce(television);
		
		/*
		 *  FAIRE LES AJOUTS AUX LISTES OOH	
		 */
		em.persist(defaultadmin);
		em.persist(vidal);
		em.persist(bucce);
	//	em.persist(pirlo);
		em.persist(type1);
		em.persist(type2);
		em.persist(telephone);
		em.persist(television);	
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
