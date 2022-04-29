package model;

public class RechargeableBattery extends Battery implements Rechargeable{
	
	private int chargerNumber;
	
	private char type;
	
	public final static char BATTERY_LITIO='l';
	
	public final static char BATTERY_NIQUEL_CADIO='n';
	
	public final static double FACTOR_LITIO=0.92;
	
	public final static double FACTOR_NIQUEL_CADIO=0.8;
	
	public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type){
		
		super(name, voltage, cost, capacity);
		
		this.chargerNumber = chargerNumber;
		
		this.type=type;
		
	}
	
	@Override
	
	public double calculateUsefulPromLifeCost(){
		
		double promLife=0;
		
		if(type=='l'){
			
			promLife=(cost*voltage*capacity)/(1000*chargerNumber*FACTOR_LITIO);
			
		}else{
			
			promLife=(cost*voltage*capacity)/(1000*chargerNumber*FACTOR_NIQUEL_CADIO);
			
		}
		
		return promLife;
		
	}
	
	@Override
	
	public String toString(){
		
		return"\nBateria recargable\nNombre:" + name + "\nCosto de vida util:"+calculateUsefulPromLifeCost()+"\n-----------------------";
		
	}
	
	
}