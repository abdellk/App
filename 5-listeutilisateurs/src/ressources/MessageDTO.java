package ressources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageDTO {

	private String message;
	private String nomU;

	public MessageDTO() {
		super();
	}

	public MessageDTO(String message, String nomU) {
		super();
		this.message = message;
		this.nomU = nomU;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNomU() {
		return nomU;
	}

	public void setNomU(String nomU) {
		this.nomU = nomU;
	}



}