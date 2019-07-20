
public class AntiAircraft extends DefenseUnit {

	public AntiAircraft(String unitName, int quantity) {
		super(unitName, quantity);
		setPrice(7);
		setCombatAbility(5);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Anti-Aircraft";
	}

}
