import java.util.Vector;

public class Army implements WarActions{

	private String armyName;
	
	private Vector<Unit> armyUnit;
	
	private int totalPower;
	
	public Army(String armyName) {
		// TODO Auto-generated constructor stub
		this.armyName = armyName;
		this.armyUnit = new Vector<>();
		this.totalPower = 0;
	}
	
	public int war(int enemyTotalPower)
	{
		return this.totalPower - enemyTotalPower;
	}
	
	public void addUnit(Unit newUnit){
		int flag = 0;
		for(int i =0; i<armyUnit.size();i++)
		{
			if(armyUnit.get(i).getUnitName().equals(newUnit.getUnitName())){
				flag = 1;
				armyUnit.get(i).setQuantity(armyUnit.get(i).getQuantity()+newUnit.getQuantity());
				break;
			}
		}
		
		if(flag==0)
		{
			armyUnit.add(newUnit);	
		}
	}

	public String getArmyName() {
		return armyName;
	}

	public Vector<Unit> getArmyUnit() {
		return armyUnit;
	}

	public int getTotalPower() {
		return totalPower;
	}

	public void setTotalPower(int power) {
		this.totalPower += power;
	}

	@Override
	public void displayArmy() {
		// TODO Auto-generated method stub
		
		if(armyUnit.size() == 0)
		{
			System.out.println("Army has no unit!");
			return;
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.printf("| %-10s| %-20s| %-20s| %-20s|\n","Number","Unit Name","Type","Unit Quantity");
		System.out.println("-------------------------------------------------------------------------------");
		for(int i =0; i<armyUnit.size();i++)
		{
			if(armyUnit.get(i) instanceof GroundTroop)
			{
				System.out.printf("| %-10d| %-20s| %-20s| %-20d|\n",i+1,armyUnit.get(i).getUnitName(),
						((GroundTroop) armyUnit.get(i)).getType(),armyUnit.get(i).getQuantity());	
			}else if(armyUnit.get(i) instanceof Vehicle)
			{
				System.out.printf("| %-10d| %-20s| %-20s| %-20d|\n",i+1,armyUnit.get(i).getUnitName(),
						((Vehicle) armyUnit.get(i)).getType(),armyUnit.get(i).getQuantity());	
			}else if(armyUnit.get(i) instanceof DefenseUnit)
			{
				System.out.printf("| %-10d| %-20s| %-20s| %-20d|\n",i+1,armyUnit.get(i).getUnitName(),
						((DefenseUnit) armyUnit.get(i)).getType(),armyUnit.get(i).getQuantity());	
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	

}
