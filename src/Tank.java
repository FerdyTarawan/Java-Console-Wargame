
public class Tank extends Vehicle {

	public Tank(String unitName, int quantity) {
		super(unitName, quantity);
		setPrice(8);
		setCombatAbility(10);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Tank";
	}
	
	
}
