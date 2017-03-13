package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_utilisateur;
	@Column(nullable = false)
	private String nom_utilisateur;
	@Column(nullable = false)
	private String prenom_utilisateur;
	@Column(nullable = false, unique = true)
	private String pseudo_utilisateur;
	@Column(nullable = false, unique = true)
	private String email_utilisateur;
	@Column(nullable = false)
	private String password_utilisateur;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation_date_utilisateur;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Annonce> annonces = new ArrayList<>();
	
	public void ajoutAnnonce(Annonce annonce) {
		annonces.add(annonce);
		annonce.setUtilisateur(this);
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom_utilisateur, String prenom_utilisateur, String pseudo_utilisateur,
			String email_utilisateur, String password_utilisateur, Date creation_date_utilisateur) {
		super();
		this.nom_utilisateur = nom_utilisateur;
		this.prenom_utilisateur = prenom_utilisateur;
		this.pseudo_utilisateur = pseudo_utilisateur;
		this.email_utilisateur = email_utilisateur;
		this.password_utilisateur = password_utilisateur;
		this.creation_date_utilisateur = creation_date_utilisateur;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getNom_utilisateur() {
		return nom_utilisateur;
	}

	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}

	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}

	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}

	public String getPseudo_utilisateur() {
		return pseudo_utilisateur;
	}

	public void setPseudo_utilisateur(String pseudo_utilisateur) {
		this.pseudo_utilisateur = pseudo_utilisateur;
	}

	public String getEmail_utilisateur() {
		return email_utilisateur;
	}

	public void setEmail_utilisateur(String email_utilisateur) {
		this.email_utilisateur = email_utilisateur;
	}

	public String getPassword_utilisateur() {
		return password_utilisateur;
	}

	public void setPassword_utilisateur(String password_utilisateur) {
		this.password_utilisateur = password_utilisateur;
	}

	public Date getCreation_date_utilisateur() {
		return creation_date_utilisateur;
	}

	public void setCreation_date_utilisateur(Date creation_date_utilisateur) {
		this.creation_date_utilisateur = creation_date_utilisateur;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}


}
