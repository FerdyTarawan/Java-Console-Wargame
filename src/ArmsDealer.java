import java.util.Vector;

public class ArmsDealer implements DealerActions{

	private Vector<GroundTroop> groundTroops;
	private Vector<Vehicle> vehicles;
	private UnitFactory factory;
	private Vector<DefenseUnit> du;
	
	public ArmsDealer() {
		// TODO Auto-generated constructor stub
		groundTroops = new Vector<>();
		vehicles = new Vector<>();
		du = new Vector<>();
		factory = UnitFactory.getInstance();
		stock();
	}
	
	public void initGT(){
		groundTroops.add(factory.makeGroundTroop("infantry", "ShockTrooper", 100));
		groundTroops.add(factory.makeGroundTroop("infantry", "Commando", 100));
		groundTroops.add(factory.makeGroundTroop("mechs", "Grenadier", 100));
		groundTroops.add(factory.makeGroundTroop("mechs", "MechSoldier", 100));
	}
	
	public void initV(){
		vehicles.add(factory.makeVehicle("tank", "Panzer 68", 100));
		vehicles.add(factory.makeVehicle("tank", "Centurion", 100));
		vehicles.add(factory.makeVehicle("submarine", "Vanguard", 100));
		vehicles.add(factory.makeVehicle("bomber", "B70-Bomber", 100));
		vehicles.add(factory.makeVehicle("bomber", "Ventura", 100));
	}
	
	public void initDU(){
		du.add(factory.makeDefenseUnit("artillery", "Artillery Missile", 100));
		du.add(factory.makeDefenseUnit("antiair", "Anti-Aircraft Guns", 100));
	}
	
	public void stock(){
		initGT();
		initV();
		initDU();
	}
	
	
	public Vector<GroundTroop> getGroundTroops() {
		return groundTroops;
	}


	public Vector<Vehicle> getVehicles() {
		return vehicles;
	}

	
	public Vector<DefenseUnit> getDu() {
		return du;
	}


	public void displayUnit(String type){
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.printf("| %-10s| %-20s| %-20s| %-20s| %-20s|\n","Number","Unit Name","Type","Price","Available Unit");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		if(type.equals("ground"))
		{
			for(int i =0; i<groundTroops.size();i++)
			{
				System.out.printf("| %-10d| %-20s| %-20s| %-20d| %-20d|\n",i+1,groundTroops.get(i).getUnitName(),
				groundTroops.get(i).getType(),groundTroops.get(i).getPrice(),groundTroops.get(i).getQuantity());	
			}
			
		}else if(type.equals("vehicle"))
		{
			for(int i =0; i<vehicles.size();i++)
			{
				System.out.printf("| %-10d| %-20s| %-20s| %-20d| %-20d|\n",i+1,vehicles.get(i).getUnitName(),
				vehicles.get(i).getType(),vehicles.get(i).getPrice(),vehicles.get(i).getQuantity());	
			}
		}else if(type.equals("defense"))
		{
			for(int i =0; i<du.size();i++)
			{
				System.out.printf("| %-10d| %-20s| %-20s| %-20d| %-20d|\n",i+1,du.get(i).getUnitName(),
						du.get(i).getType(),du.get(i).getPrice(),du.get(i).getQuantity());	
			}
		}
		System.out.println("-----------------------------------------------------------------------------------------------------");
	}
	
	public Unit buyUnit(int type, int idx, int qty, int gold)
	{
		idx -= 1;
		
		if(type == 1){
			
			if(groundTroops.get(idx).getQuantity() >= qty){
				Main.type("\nTotal Payment : ");
				Main.type(Integer.toString(groundTroops.get(idx).getPrice()*qty)+" gold\n");
				if(gold>=groundTroops.get(idx).getPrice()*qty){
					groundTroops.get(idx).setQuantity(groundTroops.get(idx).getQuantity() - qty);
					Main.type("Order Success!");
					return groundTroops.get(idx);
				}else{
					Main.type("Not Enough gold!");
					return null;
				}
			}else{
				Main.type("Not Enough unit in stock!");
				return null;
			}
			
		}else if(type == 2){
			if(vehicles.get(idx).getQuantity() >= qty){
				Main.type("\nTotal Payment : ");
				Main.type(Integer.toString(vehicles.get(idx).getPrice()*qty)+" gold\n");
				if(gold>=vehicles.get(idx).getPrice()*qty){
					vehicles.get(idx).setQuantity(vehicles.get(idx).getQuantity() - qty);
					Main.type("Order Success!");
					return vehicles.get(idx);
				}else{
					Main.type("Not Enough gold!");
					return null;
				}
			}else{
				Main.type("Not Enough unit in stock!");
				return null;
			}
			
		}else if(type == 3){
			if(du.get(idx).getQuantity() >= qty){
				Main.type("\nTotal Payment : ");
				Main.type(Integer.toString(du.get(idx).getPrice()*qty)+" gold\n");
				if(gold>=du.get(idx).getPrice() * qty){
					du.get(idx).setQuantity(du.get(idx).getQuantity() - qty);
					Main.type("Order Success!");
					return du.get(idx);
				}else{
					Main.type("Not Enough gold!");
					return null;
				}
			}else{
				Main.type("Not Enough unit in stock!");
				return null;
			}
		}
		
		return null;
	}

}
