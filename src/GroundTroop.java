
public abstract class GroundTroop extends Unit{
	
	public GroundTroop(String unitName, int quantity) {
		super(unitName, quantity);
		super.setPrice(1000);
		super.setCombatAbility(50);
	}
	
	public void setPrice(int multiplier) {
		super.setPrice(this.getPrice() * multiplier);
	}

	public void setCombatAbility(int multiplier) {
		super.setCombatAbility(getCombatAbility() * multiplier);
	}
	
	public abstract String getType();

}
