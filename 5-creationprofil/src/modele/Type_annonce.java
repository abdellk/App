package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_ANNONCE")
public class Type_annonce {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id_type;
		@Column(nullable = false)
		private String libelle_type;
		
		@OneToMany(mappedBy = "type_annonce", cascade = CascadeType.ALL)
		private List<Annonce> annonces = new ArrayList<>();
		
		public void ajoutAnnonce(Annonce annonce){
			annonces.add(annonce);
			annonce.setType_annonce(this);;
		}

		public Type_annonce() {
			super();
		}

		public Type_annonce(String libelle_type) {
			super();
			this.libelle_type = libelle_type;
		}

		public int getId_type() {
			return id_type;
		}

		public void setId_type(int id_type) {
			this.id_type = id_type;
		}

		public String getLibelle_type() {
			return libelle_type;
		}

		public void setLibelle_type(String libelle_type) {
			this.libelle_type = libelle_type;
		}

		public List<Annonce> getAnnonces() {
			return annonces;
		}

		public void setAnnonces(List<Annonce> annonces) {
			this.annonces = annonces;
		}

}
