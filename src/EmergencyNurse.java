public class EmergencyNurse extends Nurse{
    
    public EmergencyNurse (String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice, String nurseID, int assists) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, nurseID, assists);
    }
    
    public String complain() {
        return "'There's an emergency here!'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 1.80);
    }

    public String history() {
        String desc = this.getName() + "is an emergency nurse and he/she have already made " + this.getAssists() + " assists."; 
        return desc;
    }
}
