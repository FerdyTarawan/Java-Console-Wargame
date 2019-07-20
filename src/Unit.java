
public abstract class Unit implements Cloneable{

	private String unitName;
	private int price;
	private int combatAbility;
	private int quantity;
	
	public Unit(String unitName,int quantity) {
		// TODO Auto-generated constructor stub
		this.unitName = unitName;
		this.quantity = quantity;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCombatAbility() {
		return combatAbility;
	}

	public void setCombatAbility(int combatAbility) {
		this.combatAbility = combatAbility;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
