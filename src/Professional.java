public abstract class Professional extends Person {
    
    protected float hourlyPrice;
    private int hoursWorked;

    abstract public double payment(int hoursWorked);

    public Professional(String name, String SSN, String cell_phone, String age, String sex, float weight, float height, float hourlyPrice) {
        super(name, SSN, cell_phone, age, sex, weight, height);
        this.hourlyPrice = hourlyPrice;
    }

    public String complain() {
        return "'I don't have a job.'";
    }

    public String history() {
        return "'I don't have much experience.";
    }

    public String callForManager(Manager m){
        String ret = "Calling " + m.getCell_PhoneNumber() + "..." + "\n" + "*" + m.complain() + "*";
        return ret;
    }

    // Método getter para hourlyPrice
    public float getHourlyPrice() {
        return hourlyPrice;
    }

    // Método setter para hourlyPrice
    public void setHourlyPrice(float hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

    // Método getter para hoursWorked
    public int getHoursWorked() {
        return hoursWorked;
    }

    // Método setter para hoursWorked
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

}
