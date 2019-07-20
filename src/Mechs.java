
public class Mechs extends GroundTroop {

	public Mechs(String unitName, int quantity) {
		super(unitName, quantity);
		setPrice(3);
		setCombatAbility(3);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Mechs";
	}

}
