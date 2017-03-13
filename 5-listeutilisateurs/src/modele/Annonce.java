package modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ANNONCE")
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_annonce;
	@Column(nullable = false)
	private String titre_annonce;
	@Column(nullable = false)
	private String description_annonce;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date creation_date_annonce;
	@Column(nullable = false)
	private String ville_annonce;
	@Column(nullable = false)
	private String code_postal_annonce;
	@Column(nullable = false)
	private String prix_annonce;
	@ManyToOne
	@JoinColumn(name = "id_utilisateur_annonce")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "id_type_annonce")
	private Type_annonce type_annonce;
	
	public Annonce() {
		super();
	}

	/*
	 * Constructeur sans Utilisateur et type;
	 */
	
	public Annonce(String titre_annonce, String description_annonce, Date creation_date_annonce, String ville_annonce,
			String code_postal_annonce, String prix_annonce) {
		super();
		this.titre_annonce = titre_annonce;
		this.description_annonce = description_annonce;
		this.creation_date_annonce = creation_date_annonce;
		this.ville_annonce = ville_annonce;
		this.code_postal_annonce = code_postal_annonce;
		this.prix_annonce = prix_annonce;
	}

	public int getId_annonce() {
		return id_annonce;
	}

	public void setId_annonce(int id_annonce) {
		this.id_annonce = id_annonce;
	}

	public String getTitre_annonce() {
		return titre_annonce;
	}

	public void setTitre_annonce(String titre_annonce) {
		this.titre_annonce = titre_annonce;
	}

	public String getDescription_annonce() {
		return description_annonce;
	}

	public void setDescription_annonce(String description_annonce) {
		this.description_annonce = description_annonce;
	}

	public Date getCreation_date_annonce() {
		return creation_date_annonce;
	}

	public void setCreation_date_annonce(Date creation_date_annonce) {
		this.creation_date_annonce = creation_date_annonce;
	}

	public String getVille_annonce() {
		return ville_annonce;
	}

	public void setVille_annonce(String ville_annonce) {
		this.ville_annonce = ville_annonce;
	}

	public String getCode_postal_annonce() {
		return code_postal_annonce;
	}

	public void setCode_postal_annonce(String code_postal_annonce) {
		this.code_postal_annonce = code_postal_annonce;
	}

	public String getPrix_annonce() {
		return prix_annonce;
	}

	public void setPrix_annonce(String prix_annonce) {
		this.prix_annonce = prix_annonce;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Type_annonce getType_annonce() {
		return type_annonce;
	}

	public void setType_annonce(Type_annonce type_annonce) {
		this.type_annonce = type_annonce;
	}

	
	
}
