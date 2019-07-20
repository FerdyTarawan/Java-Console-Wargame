
public class Infantry extends GroundTroop {

	public Infantry(String unitName, int quantity) {
		super(unitName, quantity);
		setPrice(2);
		setCombatAbility(1);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Infantry";
	}
}
