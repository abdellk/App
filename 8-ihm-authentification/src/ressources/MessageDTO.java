package ressources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageDTO {

	private String bienvenue;
	private String email;
	private long idutil;
	private boolean verif;

	public MessageDTO() {
		super();
	}

	public MessageDTO(String bienvenue, String email, long idutil,boolean verif) {
		super();
		this.bienvenue = bienvenue;
		this.email = email;
		this.idutil = idutil;
		this.verif = verif;
	}

	public String getBienvenue() {
		return bienvenue;
	}

	public void setBienvenue(String bienvenue) {
		this.bienvenue = bienvenue;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdutil() {
		return idutil;
	}

	public void setIdutil(long idutil) {
		this.idutil = idutil;
	}

	public boolean isVerif() {
		return verif;
	}

	public void setVerif(boolean verif) {
		this.verif = verif;
	}	
	
}
