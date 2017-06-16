package game;
import java.util.ArrayList;
import java.util.List;

public class Player {
	private Integer id;
	private String name;
	public List<Card> cardInHand;
	
	public Player(Integer id, String name){
		this.id = id;
		this.name = name;
		this.cardInHand = new ArrayList<Card>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCardInHand() {
		return cardInHand;
	}

	public void setCardInHand(List<Card> cardInHand) {
		this.cardInHand = cardInHand;
	}
	
	
}
