
public abstract class DefenseUnit extends Unit {

	public DefenseUnit(String unitName, int quantity) {
		super(unitName, quantity);
		// TODO Auto-generated constructor stub
		super.setPrice(3000);
		super.setCombatAbility(200);
	}
	
	public void setPrice(int multiplier) {
		super.setPrice(this.getPrice() * multiplier);
	}

	public void setCombatAbility(int multiplier) {
		super.setCombatAbility(getCombatAbility() * multiplier);
	}
	public abstract String getType();
}
