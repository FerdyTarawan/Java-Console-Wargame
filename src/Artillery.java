
public class Artillery extends DefenseUnit {

	public Artillery(String unitName, int quantity) {
		super(unitName, quantity);
		setPrice(7);
		setCombatAbility(6);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Artillery";
	}

}
