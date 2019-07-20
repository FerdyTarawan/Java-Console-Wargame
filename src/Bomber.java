
public class Bomber extends Vehicle {

	public Bomber(String unitName, int quantity) {
		super(unitName, quantity);
		setPrice(15);
		setCombatAbility(15);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Bomber";
	}

}
