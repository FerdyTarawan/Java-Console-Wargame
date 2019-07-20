import java.util.*;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);

	public static void type(String text){
		int i;
		if(text.equals("loop")){
			for(i = 0; i < 50; i++){
			    System.out.printf("\n");
			    try{
			        Thread.sleep(25);
			    }catch(InterruptedException ex){
			        Thread.currentThread().interrupt();
			    }
			}
			return;
		}
		for(i = 0; i < text.length(); i++){
		    System.out.printf("%c", text.charAt(i));
		    try{
		        Thread.sleep(25);
		    }catch(InterruptedException ex){
		        Thread.currentThread().interrupt();
		    }
		}
	}
	
	public static void clr()
	{
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}
	
	public void play()
	{
		int input=0;
		int menu2,menu22,tempQty;
		String tempname,temparmy;
		Simulator simulator;
		
		clr();

		do{
			type("Enter your name [consists of two word | minimum 5 characters] : ");
			tempname = scan.nextLine();
		}while(tempname.length() < 5 || !tempname.contains(" "));
		
		do{
			type("\nName your army [consists of two word| minimum 8 characters | Ends with 'army'] : ");
			temparmy = scan.nextLine();
		}while(temparmy.length() < 8 || !temparmy.endsWith("army") || !tempname.contains(" "));
		
		simulator = new Simulator(tempname, 1000000,temparmy);
		
		do{
			type("loop");
			type("Advance Warfare Simulator\n");
			type("-------------------------\n\n");
			type("Welcome ");
			type(simulator.getName()+"\n\n");
			type("1. Go To War\n");
			type("2. Order Unit\n");
			type("3. Show Army Status\n");
			type("4. Quit\n");
			do{
				try
				{
					type(">> ");
					input=scan.nextInt();
				}
				catch(Exception e)
				{
					input = 0;
				}
				scan.nextLine();
			}while(input < 1 || input > 4);
			
			switch (input) {
				case 1:
					clr();
					if(simulator.getHeroArmy().getArmyUnit().size() == 0)
					{
						type("You army has no unit!");
						scan.nextLine();
					}else{
						simulator.war(0);	
					}
					break;
				case 2:
					clr();
					type("What unit do you want to order?\n\n");
					type("1. Ground Troops\n");
					type("2. Vehicles\n");
					type("3. Defense Unit\n");
					do{
						try
						{
							type(">> ");
							menu2=scan.nextInt();
						}
						catch(Exception e)
						{
							menu2 = 0;
						}
						scan.nextLine();
					}while(menu2 < 1 || menu2 > 3);
					clr();
					if(menu2 == 1){
						simulator.displayUnit("ground");
						do{
							try
							{
								type("Enter unit number [1-");
								type(Integer.toString(simulator.getGroundTroops().size())+"] : ");
								menu22=scan.nextInt();
							}
							catch(Exception e)
							{
								menu22 = 0;
							}
							scan.nextLine();
						}while(menu22 < 1 || menu22 > simulator.getGroundTroops().size());
						do{
							try
							{
								type("Enter order quantity number [minimum 1 order] : ");
								tempQty=scan.nextInt();
							}
							catch(Exception e)
							{
								tempQty = 0;
							}
							scan.nextLine();
						}while(tempQty < 1);
						simulator.buyUnit(1, menu22, tempQty,simulator.getGold());
					}
					else if(menu2 == 2){
						simulator.displayUnit("vehicle");
						do{
							try
							{
								type("Enter unit number [1-");
								type(Integer.toString(simulator.getVehicles().size())+"] : ");
								menu22=scan.nextInt();
							}
							catch(Exception e)
							{
								menu22 = 0;
							}
							scan.nextLine();
						}while(menu22 < 1 || menu22 > simulator.getVehicles().size());
						do{
							try
							{
								type("Enter order quantity number [minimum 1 order] : ");
								tempQty=scan.nextInt();
							}
							catch(Exception e)
							{
								tempQty = 0;
							}
							scan.nextLine();
						}while(tempQty < 1);
						simulator.buyUnit(2, menu22, tempQty,simulator.getGold());
					}
					else if(menu2 ==3){
						simulator.displayUnit("defense");
						do{
							try
							{
								type("Enter unit number [1-");
								type(Integer.toString(simulator.getDu().size())+"] : ");
								menu22=scan.nextInt();
							}
							catch(Exception e)
							{
								menu22 = 0;
							}
							scan.nextLine();
						}while(menu22 < 1 || menu22 > simulator.getDu().size());
						do{
							try
							{
								type("Enter order quantity number [minimum 1 order] : ");
								tempQty=scan.nextInt();
							}
							catch(Exception e)
							{
								tempQty = 0;
							}
							scan.nextLine();
						}while(tempQty < 1);
						simulator.buyUnit(3, menu22, tempQty,simulator.getGold());
					}
					scan.nextLine();
				
					break;
				case 3:
					clr();
					type(simulator.getHeroArmy().getArmyName()+" status : \n\n");
					simulator.displayArmy("hero");
					type("\nRemaining Gold : ");
					type(Integer.toString(simulator.getGold()));
					type("\nCombat rank : ");
					type(Integer.toString(simulator.getHeroArmy().getTotalPower()));
					scan.nextLine();
					break;
			}
		
		}while(input != 4);
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		int input;
		do{
			clr();
			type("Advance Warfare Simulator\n");
			type("-------------------------\n");
			type("1. Play\n");
			type("2. Exit\n");
			do{
				try
				{
					type(">> ");
					input=scan.nextInt();
				}
				catch(Exception e)
				{
					input = 0;
				}
				scan.nextLine();
			}while(input < 1 || input > 3);
			
			switch (input) {
				case 1:
					play();
					break;
				case 2:
					type("loop");
					type("Thank you for playing!");
					scan.nextLine();
			}
			
		}while(input != 2);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
