public class Doctor extends Professional{
    
    private String medicalID; // CRM
    private int avarageHourlyAppointments;

    public Doctor (String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice, String medicalID, int avarageHourlyAppointments) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice);
        this.medicalID = medicalID;
        this.avarageHourlyAppointments = avarageHourlyAppointments;
    } 

    public String complain() {
        return "'I need to apply for a medical residency.'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 2.00);
    }

    public String history() {
        String desc = this.getName() + "is a doctor and he/she have an avarage hourly appointments of " + avarageHourlyAppointments + "."; 
        return desc;
    }

    public String procedure() {
        return "*Using the thermometer*";
    }
    
    public String examine(Patient p){
        return "'Your BMI is "+ p.calculateBMI() + ". " + p.getName() +", let me check your temperature...'" + "\n" + this.procedure();
    }
}
