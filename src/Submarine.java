
public class Submarine extends Vehicle {

	public Submarine(String unitName, int quantity) {
		super(unitName, quantity);
		setPrice(10);
		setCombatAbility(12);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Submarine";
	}

	
}
