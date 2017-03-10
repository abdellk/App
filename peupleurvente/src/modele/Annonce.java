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
	private int idannonce;
	@Column
	private String titre;
	@Column
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date derniere_mise_a_jour;
	@Column
	private String ville;
	@Column
	private String code_postal;
	@Column
	private String prix;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Utilisateur user;
	@ManyToOne
	@JoinColumn(name = "id_type")
	private Type_annonce type;
	
	public Annonce() {
		super();
	}

	public Annonce(int idannonce, String titre, String description, Date derniere_mise_a_jour, String ville,
			String code_postal, String prix) {
		super();
		this.titre = titre;
		this.description = description;
		this.derniere_mise_a_jour = derniere_mise_a_jour;
		this.ville = ville;
		this.code_postal = code_postal;
		this.prix = prix;
	}

	public int getIdannonce() {
		return idannonce;
	}

	public void setIdannonce(int idannonce) {
		this.idannonce = idannonce;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDerniere_mise_a_jour() {
		return derniere_mise_a_jour;
	}

	public void setDerniere_mise_a_jour(Date derniere_mise_a_jour) {
		this.derniere_mise_a_jour = derniere_mise_a_jour;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Type_annonce getType() {
		return type;
	}

	public void setType(Type_annonce type) {
		this.type = type;
	}
	
	
}
