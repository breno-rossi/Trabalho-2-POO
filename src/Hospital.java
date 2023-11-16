import java.util.ArrayList;

public class Hospital {

    private String name;
    private String EIN; // CNPJ
    private String address;
    private ArrayList<Doctor> doctors;
    private ArrayList<Nurse> nurses;
    private int availableRooms;
    private String phoneNumber;

    private String specialty;
    private Doctor ChiefPhysician;
    private Manager manager; // 1X1 (1 doctor for 1 hospital)


    public Hospital(String name, String EIN, String address, int availableRooms, String phoneNumber, String specialty, Doctor ChiefPhysician, Manager manager) {
        this.name = name;
        this.EIN = EIN;
        this.address = address;
        this.availableRooms = availableRooms;
        this.phoneNumber = phoneNumber;
        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
        this.specialty = specialty;
        this.ChiefPhysician = ChiefPhysician;
        this.manager = manager;
    }


    public String surgeryRecord (Doctor d1, Doctor d2, Doctor d3, Nurse n1, Nurse n2, Patient p) {
        String record = "Surgery record\n\nDoctors: " + d1.getName() + ", " + d2.getName() + " and " + d3.getName()
        + ";\nNurses: " + n1.getName() + " and " + n2.getName() + ";\n" + "Patient: " + p.getName() + ";\nPatient SSN: " + p.getSSN() + ".";
        return record;
    }

    public String employeeDescription(Professional prof) {
        String r = prof.history();
        return r;
    }

    // Métodos Getter e Setter para 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos Getter e Setter para 'EIN'
    public String getEIN() {
        return EIN;
    }

    public void setEIN(String EIN) {
        this.EIN = EIN;
    }

    // Métodos Getter e Setter para 'address'
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // Métodos Getter e Setter para 'doctors'
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<? extends Doctor> doctors) {
        this.doctors = new ArrayList<>(doctors);
    }

    // Métodos Getter e Setter para 'nurses'
    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(ArrayList<? extends Nurse> nurses) {
        this.nurses = new ArrayList<>(nurses);
    }

    // Métodos Getter e Setter para 'availableRooms'
    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    // Métodos Getter e Setter para 'phoneNumber'
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Método Getter para 'specialty'
    public String getSpecialty() {
        return specialty;
    }

    // Método Setter para 'specialty'
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    // Método Getter para 'ChiefPhysician'
    public Doctor getChiefPhysician() {
        return ChiefPhysician;
    }

    // Método Setter para 'ChiefPhysician'
    public void setChiefPhysician(Doctor ChiefPhysician) {
        this.ChiefPhysician = ChiefPhysician;
    }

    // Método Getter para 'ChiefPhysician'
    public Person getmanager() {
        return manager;
    }

    // Método Setter para 'ChiefPhysician'
    public void setmanager(Manager manager) {
        this.manager = manager;
    }
    
}
