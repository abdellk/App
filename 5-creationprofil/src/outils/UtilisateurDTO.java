package outils;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
// @ManagedBean(name="utilisateur")
// @RequestScoped
public class UtilisateurDTO {

	private String nom;
	private String prenom;
	private String pseudo;
	private String email;
	private String password;

	/*
	 * private EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("peuplement"); private
	 * EntityManager em = emf.createEntityManager();
	 * 
	 * public UtilisateurDTO ajoutUtilisateur (UtilisateurDTO utilisateur){
	 * 
	 * em.getTransaction().begin(); em.persist(utilisateur);
	 * 
	 * return utilisateur; }
	 */

	public UtilisateurDTO() {
		super();
	}

	public UtilisateurDTO(String nom, String prenom, String pseudo, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
