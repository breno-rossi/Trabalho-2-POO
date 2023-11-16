public class PediatricNurse extends Nurse{
    


    public PediatricNurse (String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice, String nurseID, int assists) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, nurseID, assists);
    }
    
    public String complain() {
        return "'The babies are crying very loud!'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 1.75);
    }

    public String history() {
        String desc = this.getName() + "is a pediatric nurse and he/she have already made " + this.getAssists() + " assists."; 
        return desc;
    }

}
