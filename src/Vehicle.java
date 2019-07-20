
public abstract class Vehicle extends Unit{

	public Vehicle(String unitName, int quantity) {
		super(unitName, quantity);
		// TODO Auto-generated constructor stub
		super.setPrice(5000);
		super.setCombatAbility(250);
	}
	
	public void setPrice(int multiplier) {
		super.setPrice(this.getPrice() * multiplier);
	}

	public void setCombatAbility(int multiplier) {
		super.setCombatAbility(getCombatAbility() * multiplier);
	}
	
	public abstract String getType();
	
}
