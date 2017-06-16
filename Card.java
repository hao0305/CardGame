package game;

public class Card {
	private Integer number;
	private String id;
	private String type;
	
	public Card(Integer number, String id, String type){
		this.number=number;
		this.id = id;
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
