package guessMaster;

import java.util.*;


public class GuessMaster{
	private int numberOfCandidatesEntities;
	private Entity[] entities;
	private int i;
	Random rand;
	//constructor for GM
	public GuessMaster() {
		
		rand=new Random();
		numberOfCandidatesEntities=3;
		entities=new Entity[numberOfCandidatesEntities];
		i=0;
		// TODO Auto-generated constructor stub
	}

	//adding an entity to the entity array
	public void addEntity(Entity entity) {
		entities[i]=entity;
		i++;
	}
	public void playGame(int index) {
		//setting the correct name and date based on the randomly selected one
		String corName=entities[index].getName();
		Date corDate=entities[index].getBorn();
		//declaring scanner
		Scanner scan= new Scanner(System.in);
		System.out.println("You are trying to guess "+corName+"'s birthday");
		String userInput=null;
		//while loop that runs until "quit" is inputed
		while(true) {
			//opening scanner
			userInput=scan.nextLine();
			//quit statement
			if(userInput.equalsIgnoreCase("quit")) {
				break;
			}
			//reads user input, checks against the correct date then  output the hint/congratulations
			Date UI=new Date(userInput);
			if(UI.equals(corDate)) {
				System.out.println("BINGO. You got it!!");
				playGame();
			}else if(UI.precedes(corDate)) {
				System.out.println("Incorrect. Try an later date.");
			}else if(UI.follows(corDate)){
				System.out.println("Incorrect. Try an earlier date.");
			}else {
				System.out.println("ERROR");

			}
			
		}
		//closing scanner to avoid resource leak
		scan.close();
	}
	//randomly generates index for candidate array then sends it to playGame
	public  void playGame() {
		int randNum=rand.nextInt(numberOfCandidatesEntities);
		playGame(randNum);
	}
	
	public static void main(String arg[]) {
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25,1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 4, 1776));
		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(usa);
		gm.playGame();
		
		
	}
	
	
}
