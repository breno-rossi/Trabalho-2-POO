public class Obstetrician extends Doctor{
    
    private int numberOfBirths;


    public Obstetrician (String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice, String medicalID, int avarageHourlyAppointments, int numberOfBirths) {
        super(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, avarageHourlyAppointments);
        this.numberOfBirths = numberOfBirths;
    } 

    public String complain() {
        return "'Too many births to do!'";
    }

    public double payment(int hoursWorked) {
        return (hourlyPrice * hoursWorked * 2.50);
    }

    public String history() {
        String desc = this.getName() + "is an obstrician and he/she have already made " + numberOfBirths + " births."; 
        return desc;
    }

    public String procedure() {
        return "*Using the ultrasound machine*";
    }

    public String examine(Patient p){
        String ret;
        if (p.getSex() == "Feminino") {
            ret = "'Your BMI is "+ p.calculateBMI() + ". " + p.getName() + ", let me check if you are pregnant...";
        } else {
            ret = "Sorry, sir " + p.getName() + ". You are not able to become pregnant." + "\n" + this.procedure();
        }
        return ret;
    }
}

