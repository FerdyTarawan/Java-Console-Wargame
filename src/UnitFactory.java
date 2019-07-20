
public class UnitFactory {

	private static UnitFactory instance = null;
	
	private UnitFactory() {
		// TODO Auto-generated constructor stub
	}

	public static UnitFactory getInstance() 
    { 
        if (instance == null){
        	instance = new UnitFactory();
        }
        return instance; 
    }
	
	public GroundTroop makeGroundTroop(String type,String name,int qty)
	{
		GroundTroop unit = null;
		if(type.equals("infantry"))
		{
			unit = new Infantry(name, qty);
		}else if(type.equals("mechs"))
		{
			unit = new Mechs(name, qty);
		}
		
		return unit;
	}
	
	public Vehicle makeVehicle(String type,String name,int qty)
	{
		Vehicle unit = null;
		if(type.equals("tank"))
		{
			unit = new Tank(name, qty);
		}else if(type.equals("submarine"))
		{
			unit = new Submarine(name, qty);
		}else if(type.equals("bomber"))
		{
			unit = new Bomber(name, qty);
		}
		
		return unit;
	}
	
	public DefenseUnit makeDefenseUnit(String type,String name,int qty)
	{
		DefenseUnit unit = null;
		if(type.equals("artillery"))
		{
			unit = new Artillery(name, qty);
		}else if(type.equals("antiair"))
		{
			unit = new AntiAircraft(name, qty);
		}
		return unit;
	}
}
