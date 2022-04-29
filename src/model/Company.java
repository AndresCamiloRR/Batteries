package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
		
		int normal =0;
		
		int rechargable =0;
		
		for (int i=0; i<MAX_BATTERIES; i++){
			
			if (batteries[i]!=null){
				
				if(batteries[i] instanceof RechargeableBattery){
					
					rechargable++;
					
				}else if(batteries[i] instanceof Battery){
					
					normal++;
					
				}
				
			}
			
		}
		
    	return "En total hay " + normal + " baterias comunes y " + rechargable + " baterias recargables";
    }
    
    public String showBatteriesInfo() {
    	String str = "";
		
		for (int i=0; i<MAX_BATTERIES; i++){
			
			if (batteries[i]!=null){
				
				str+=batteries[i].toString();
				
			}
			
		}
		
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
		
		double promLife=0;
		
		int rechargableBatteries=0;
		
		for (int i=0; i<MAX_BATTERIES; i++){
			
			if (batteries[i]!=null&&batteries[i] instanceof RechargeableBattery){
				
				promLife+=((RechargeableBattery)batteries[i]).calculateUsefulPromLifeCost();
				
				rechargableBatteries++;
				
			}
			
		}
		
		if(rechargableBatteries!=0){
			
			promLife=promLife/rechargableBatteries;
			
		}else{}
		
		return promLife;
		
	}

}
