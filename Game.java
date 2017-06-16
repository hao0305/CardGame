package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static List<Card> allCards;
	static Player p1 = null;
	static Player p2 = null;
	
	public Game(){
		allCards = new ArrayList<Card>();
	}
	
	private static void addCard(){
		String[] id= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] type = {"Spades","Hearts", "Diamonds", "Clubs"};
		
		for (int i = 0; i<4; i++){
			for (int j = 0; j<13; j++){
				Card temp = new Card((j+13*i), id[j], type[i]);
				allCards.add(temp);
				
			}
		}
	}
	public static void initialCard(){
		for (Card c: allCards){
			System.out.print(c.getType() + c.getId() + " ");
		}
	}
	
	
	public static void shuffle(){
		for (Card c: allCards){
			for (int i = 0; i<52; i++){
				int random = new Random().nextInt(52);
				Collections.swap(allCards, i, random);
			}
		}
	}
	
	public static void addPlayer(){
		int id_temp;
		String name_temp;
		Scanner console = new Scanner(System.in);
		for (int i = 0; i<2; i++){
			System.out.println("Player" + i + ": Please enter your id");
			id_temp = console.nextInt();
			System.out.println("Please enter your name: ");
		    name_temp = console.next();
		    
		    if (i == 0)
		    	p1 = new Player(id_temp, name_temp );
		    else
		    	p2 = new Player(id_temp, name_temp );
		}
		System.out.println("Player 1:" + p1.getName() + "  Player 2:"+p2.getName());
	}
	
	public static void displayCard(){
		p1.cardInHand.add(allCards.get(0));
		p2.cardInHand.add(allCards.get(1));
		p1.cardInHand.add(allCards.get(2));
		p2.cardInHand.add(allCards.get(3));
		System.out.println("Player 1: " + p1.cardInHand.get(0).getType() + p1.cardInHand.get(0).getNumber() + " "+ p1.cardInHand.get(1).getType() + p1.cardInHand.get(1).getNumber());
		System.out.println("Player 2: " + p2.cardInHand.get(0).getType() + p2.cardInHand.get(0).getNumber() + " " + p2.cardInHand.get(1).getType() + p2.cardInHand.get(1).getNumber());
	}
	

	public static int largerCard (Card c1, Card c2){
		if (c1.getNumber() > c2.getNumber()){
			return 1;
		}
		else if (c1.getNumber() < c2.getNumber()){
			return 2;
		}
		else if ( c1.getType() == c2.getType() ){
			return 0;
		}
		else if ((c1.getType() == "Spades") && (c2.getType() != "Spades")){
			return 1;
		}
		else if ((c1.getType() != "Spades") && (c2.getType() == "Spades")){
			return 2;
		}
		else if ((c1.getType() == "Hearts") && (c1.getType() != "Hearts")){
			return 1;
		}
		else if ((c1.getType() != "Hearts") && (c1.getType() == "Hearts")){
			return 2;
		}
		else if ((c1.getType() == "Hearts") && (c1.getType() != "Hearts")){
			return 1;
		}
		else if ((c1.getType() != "Hearts") && (c1.getType() == "Hearts")){
			return 2;
		}
		else if ((c1.getType() == "Clubs") && (c1.getType() != "Clubs")){
			return 1;
		}
		else if ((c1.getType() != "Clubs") && (c1.getType() == "Clubs")){
			return 2;
		}
		else if ((c1.getType() == "Diamonds") && (c1.getType() != "Diamonds")){
			return 1;
		}
		else if ((c1.getType() != "Diamonds") && (c1.getType() == "Diamonds")){
			return 2;
		}
		else
			return 3;
	}
	
	
	
	public static void compare(Player p1, Player p2){
		Card tempC1;
		Card tempC2;
		int temp1 = largerCard(p1.cardInHand.get(0), p1.cardInHand.get(1));
		int temp2 = largerCard(p2.cardInHand.get(0), p2.cardInHand.get(1));
		
		if (temp1 == 1 || temp1 == 0){
			tempC1 = p1.cardInHand.get(0);
		} else{
			tempC1 = p1.cardInHand.get(1);
		}
		if (temp2 == 1 || temp2 == 0){
			tempC2 = p2.cardInHand.get(0);
		} else{
			tempC2 = p2.cardInHand.get(1);
		}
		
		int temp_result = largerCard(tempC1, tempC2);
		if (temp_result == 1){
			System.out.println("Player 1 Win");
		}else if (temp_result == 0){
			System.out.println("WOW! Its a TIE");
		} else
			System.out.println("Player 2 Win");
	}
	
	
	public static void main(String[] args){
		Game game = new Game();
		System.out.println("-----NEW CARD INITIALIZING-----");
        game.addCard();
        game.initialCard();
        System.out.println("-----SHUFFLING-----");
        game.shuffle();
        game.initialCard();
        System.out.println("-----WELCOME NEW PLAYERS-----");
        game.addPlayer();
        System.out.println("-----CARD DISPLAYED-----");
        game.displayCard();
        System.out.println("-----RESULT-----");
        game.compare(p1, p2);
	}
}
