import java.util.Random;
import java.util.Vector;

public class Simulator implements WarActions,DealerActions{

	private String name;
	private int gold;
	
	private Army heroArmy;
	private Army enemyArmy;
	private ArmsDealer armsDealer;
	
	public Simulator(String name, int gold,String armyname) {
		super();
		this.name = name;
		this.gold = gold;
		initHero(armyname);
		initDealer();
	}

	public void initDealer()
	{
		if(armsDealer == null){
			armsDealer = new ArmsDealer();
		}
	}
	
	public void initHero(String armyName)
	{
		if(heroArmy == null){
			heroArmy = new Army(armyName);
	    }
	}
	
	public void initEnemy(String armyName)
	{

		if(enemyArmy == null){
			enemyArmy = new Army(armyName);
			
			int enemyGold = 10000000;
			int type,idx;
			Random rand = new Random();
			Unit newUnit = null;
			int qty = 1;
			int i=0;
			while(i<20)
			{
				type = rand.nextInt(3)+1;
				
				if(type == 1)
				{
					idx = rand.nextInt(armsDealer.getGroundTroops().size());
	
//					if(enemyGold >= armsDealer.getGroundTroops().get(idx).getPrice() * qty){
						try {
							newUnit = (Unit)armsDealer.getGroundTroops().get(idx).clone();
							newUnit.setQuantity(qty);
							
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						enemyGold -= armsDealer.getGroundTroops().get(idx).getPrice() * qty;
						addUnit(newUnit,"enemy");i++;
						enemyArmy.setTotalPower(getGroundTroops().get(idx).getCombatAbility() * qty);
					//}
				}else if(type == 2)
				{
					idx = rand.nextInt(armsDealer.getVehicles().size());
	
					//if(enemyGold >= armsDealer.getVehicles().get(idx).getPrice() * qty){
						try {
							newUnit = (Unit)armsDealer.getVehicles().get(idx).clone();
							newUnit.setQuantity(qty);
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						enemyGold -= armsDealer.getVehicles().get(idx).getPrice() * qty;
						addUnit(newUnit,"enemy");i++;
						enemyArmy.setTotalPower(getVehicles().get(idx).getCombatAbility() * qty);
					//}
				}else if(type == 3){
					idx = rand.nextInt(armsDealer.getDu().size());
	
					//if(enemyGold >= armsDealer.getDu().get(idx).getPrice() * qty){
						try {
							newUnit = (Unit)armsDealer.getDu().get(idx).clone();
							newUnit.setQuantity(qty);
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						enemyGold -= armsDealer.getDu().get(idx).getPrice() * qty;
						addUnit(newUnit,"enemy");i++;
						enemyArmy.setTotalPower(getDu().get(idx).getCombatAbility() * qty);
					//}
				}	
			}
		}
	}
	
	public Army getHeroArmy() {
		return heroArmy;
	}


	public Army getEnemyArmy() {
		return enemyArmy;
	}


	public Vector<GroundTroop> getGroundTroops() {
		return armsDealer.getGroundTroops();
	}


	public Vector<Vehicle> getVehicles() {
		return armsDealer.getVehicles();
	}

	
	public Vector<DefenseUnit> getDu() {
		return armsDealer.getDu();
	}
	
	public Unit buyUnit(int type, int idx,int qty, int gold){
		Unit temp = armsDealer.buyUnit(type, idx, qty,gold);
		if(temp == null){
			return null;
		}
		//buy success
		Unit buy = null;
		try {
			buy = (Unit) temp.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buy.setQuantity(qty);
		addUnit(buy,"hero");
		
		setGold(getGold()-(buy.getPrice()*buy.getQuantity()));
		
		heroArmy.setTotalPower(buy.getCombatAbility()*buy.getQuantity());
		
		
		return null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	@Override
	public void addUnit(Unit newUnit) {
		// TODO Auto-generated method stub
		
	}
	
	public void addUnit(Unit newUnit, String type)
	{
		if(type.equals("hero"))
		{
			heroArmy.addUnit(newUnit);
		}
		else{
			enemyArmy.addUnit(newUnit);
		}
	}

	@Override
	public void displayArmy() {
		// TODO Auto-generated method stub
		heroArmy.displayArmy();
	}

	public void displayArmy(String whichArmy){
		if(whichArmy.equals("hero"))
		{
			heroArmy.displayArmy();
			
		}
		else{
			enemyArmy.displayArmy();
		}
	}
	
	@Override
	public int war(int enemyTotalPower) {
		// TODO Auto-generated method stub
		initEnemy("Enemy army");
		
		Main.type("Vs "+getEnemyArmy().getArmyName()+" : \n\n");
		displayArmy("enemy");
		Main.type("\n Combat points : ");
		Main.type(Integer.toString(getEnemyArmy().getTotalPower())+"\n\n");
		Main.type("Proceed ? [y/n] : ");
		String confirm = Main.scan.nextLine();
		
		if(confirm.equals("y"))
		{
			int reward = heroArmy.war(enemyArmy.getTotalPower());
			if(reward < 0){
				reward = Math.abs(reward);
				Main.type("You Lost!\n");
				Main.type("Your Gold will be reduced by ");
				String r = Integer.toString(reward);
				Main.type(r+"\n");
				setGold(getGold()-reward);
				if(getGold() < 0)
				{
					setGold(0);
				}
				Main.type("Press Enter To Continue..");
				Main.scan.nextLine();
			}else if(reward > 0){
					Main.type("You Won!");
					Main.type("Your will be rewarded with ");
					String r = Integer.toString(reward);
					Main.type(r + " gold\n");
					setGold(getGold()+reward);
					Main.type("Press Enter To Continue..");
					Main.scan.nextLine();
			}else{
				Main.type("Draw!\n");
				Main.type("No reward will be given..\n");
				Main.type("Press Enter To Continue..\n");
				Main.scan.nextLine();
			}
		}
		enemyArmy = null;
		return 0;
	}

	@Override
	public void displayUnit(String type) {
		// TODO Auto-generated method stub
		Main.type("Your Gold : ");
		Main.type(Integer.toString(getGold())+"\n\n");
		armsDealer.displayUnit(type);
	}

}
