import com.sun.java.accessibility.util.GUIInitializedListener;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

// public static void createDoctorObj () {

//     String line = "";
//     BufferedReader CSVcontent = null;

//     String csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\doctors.csv";

//                 try {
//                     CSVcontent = new BufferedReader(new FileReader(csvFile));
//                     while ((line = CSVcontent.readLine()) != null) {
//                         String[] info = line.split(";");
//                         String name = info[0];
//                         String SSN = info[1];
//                         String cell_phone = info[2];
//                         String age = info[3];
//                         String sex = info[4];
//                         float weight = Float.parseFloat(info[5]);
//                         float height = Float.parseFloat(info[6]);
//                         float hourlyPrice = Float.parseFloat(info[7]);
//                         String medicalID = info[8];
//                         int averageHourlyAppointments = Integer.parseInt(info[9]);

//                         Doctor newDoc = new Doctor(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, averageHourlyAppointments);
//                         doc.add(newDoc);

//                         }

//                         String info1 = "";
                        
//                         for (Doctor objeto : doc) {
//                         info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
//                                 "IDADE: " +objeto.getAge()+ "\n" +
//                                 "GENERO: " + objeto.getSex()+ "\n" +
//                                 "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
//                                 "SSN: " + objeto.getSSN() + "\n" +
//                                 "PESO: " + objeto.getWeight() + "\n" +
//                                 "ALTURA: " + objeto.getHeight() + "\n" +
//                                 "FUNÇÃO: Clínico Geral" + "\n" +
//                                 "========================================";
//                         campo_info.setText(info1);
//                     }

//                     }
// }

public class GUI implements ActionListener {
    private static JLabel cel;
    private static JLabel info;
    private static JLabel descricao;
    private static JTextArea campo_descricao;
    private static JTextArea campo_info;
    private static JLabel peso;
    private static JLabel altura;
    private static JTextField campo_altura;
    private static JTextField campo_peso;
    private static JTextField campo_cel;
    private static JLabel genero;
    private static JLabel cpf;
    private static JTextField campo_cpf;
    private static JLabel nome_paciente;
    private static JTextField campo_nome_usuario;
    private static JLabel idade_paciente;
    private static JTextField campo_idade_paciente;
    private static JButton botao_salvar;
    private static JButton mostrar_funcionarios;
    private static JButton mostrar_pac;
    private static JRadioButton radio_genero1;
    private static JRadioButton radio_genero2;
    private static JRadioButton radio_genero3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Paciente");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\breno\\Desktop\\Medical Records\\icon.png");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        frame.add(painel);
        inserir_componentes(painel);
        frame.setVisible(true);
        frame.setIconImage(icon);
    }

    public static void inserir_componentes(JPanel painel) {

        ArrayList<Doctor> allDocs = new ArrayList<>();
        ArrayList<Doctor> docGeral = new ArrayList<>();
        ArrayList<Cardiologist> docC = new ArrayList<>();
        ArrayList<Orthopedist> docOrto = new ArrayList<>();
        ArrayList<Obstetrician> docObst = new ArrayList<>();
        ArrayList<Nurse> allnurs = new ArrayList<>();
        ArrayList<Nurse> nurs = new ArrayList<>();
        ArrayList<PediatricNurse> nursP = new ArrayList<>();
        ArrayList<EmergencyNurse> nursE = new ArrayList<>();
        ArrayList<Manager> manag = new ArrayList<>();
        ArrayList<Hospital> hosp = new ArrayList<>();
        
        ArrayList<Patient> patients = new ArrayList<>();
        painel.setLayout(null);

        ArrayList<Patient> lista_paciente = new ArrayList<>();
        
        //rotulos e campos nome do paciente
        nome_paciente = new JLabel("Nome Paciente");
        nome_paciente.setBounds(10, 10, 100, 25);
        campo_nome_usuario = new JTextField(25);
        campo_nome_usuario.setBounds(150, 10, 200, 25);
        painel.add(campo_nome_usuario);
        painel.add(nome_paciente);

        //rotulos e campos idade do paciente
        idade_paciente = new JLabel("Idade do Paciente");
        idade_paciente.setBounds(10, 50, 150, 25);
        campo_idade_paciente = new JTextField(25);
        campo_idade_paciente.setBounds(150, 50, 200, 25);
        painel.add(campo_idade_paciente);
        painel.add(idade_paciente);
        ((AbstractDocument) campo_idade_paciente.getDocument()).setDocumentFilter(new MyDocumentFilter());

        //3 botoes para genero e rotulo
        genero = new JLabel("Gênero");
        genero.setBounds(10, 90, 150, 25);
        radio_genero1 = new JRadioButton("Masculino");
        radio_genero1.setBounds(145, 90, 100, 30);
        radio_genero2 = new JRadioButton("Feminino");
        radio_genero2.setBounds(245, 90, 100, 30);
        radio_genero3 = new JRadioButton("Outro");
        radio_genero3.setBounds(345, 90, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radio_genero1);
        bg.add(radio_genero2);
        bg.add(radio_genero3);
        painel.add(radio_genero1);
        painel.add(radio_genero2);
        painel.add(radio_genero3);
        painel.add(genero);

        //CPF
        cpf = new JLabel("CPF");
        cpf.setBounds(10, 130, 150, 25);
        campo_cpf = new JTextField(25);
        campo_cpf.setBounds(150, 130, 150, 25);
        painel.add(cpf);
        painel.add(campo_cpf);
        ((AbstractDocument) campo_cpf.getDocument()).setDocumentFilter(new MyDocumentFilter());

        //celular
        cel = new JLabel("Celular");
        cel.setBounds(10, 170, 150, 25);
        campo_cel = new JTextField(25);
        campo_cel.setBounds(150, 170, 150, 25);
        painel.add(cel);
        painel.add(campo_cel);
        ((AbstractDocument) campo_cel.getDocument()).setDocumentFilter(new MyDocumentFilter());

        //altura
        altura = new JLabel("Altura");
        altura.setBounds(10, 210, 150, 25);
        campo_altura = new JTextField(25);
        campo_altura.setBounds(150, 210, 150, 25);
        painel.add(altura);
        painel.add(campo_altura);
        ((AbstractDocument) campo_altura.getDocument()).setDocumentFilter(new MyDocumentFilter());

        //peso
        peso = new JLabel("Peso");
        peso.setBounds(10, 250, 150, 25);
        campo_peso = new JTextField(25);
        campo_peso.setBounds(150, 250, 150, 25);
        painel.add(peso);
        painel.add(campo_peso);
        ((AbstractDocument) campo_peso.getDocument()).setDocumentFilter(new MyDocumentFilter());

        //Descriçao
        descricao = new JLabel("Descrição");
        descricao.setBounds(10, 290, 150, 25);
        campo_descricao = new JTextArea(10,5);
        campo_descricao.setBounds(150, 290, 270, 200);
        painel.add(descricao);
        painel.add(campo_descricao);

        //MOSTRAR DADOS PACIENTES|MEDICOS
        info = new JLabel("INFORMAÇÔES");
        info.setBounds(440, 10, 150, 25);

        campo_info = new JTextArea(100, 25);
        campo_info.setBounds(530, 10, 300, 500);
        painel.add(info);
        // Remova a linha campo_info.add(campo_info); 
        painel.add(campo_info);
        campo_info.setEditable(false);

        // Adiciona a JTextArea a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(campo_info);
        scrollPane.setBounds(530, 10, 300, 500);
        painel.add(scrollPane);

        //Botao para salvar dados no objeto
        botao_salvar = new JButton(new AbstractAction("Salvar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String altura = campo_altura.getText();
                String peso = campo_peso.getText();
                String Genero = " ";
                float pesofloat = 0;
                float alturafloat = 0;

                try {
                    pesofloat = Float.parseFloat(peso);
                    alturafloat = Float.parseFloat(altura);
                    JOptionPane.showMessageDialog(null, "PESO: " + pesofloat + " ALTURA:" + alturafloat);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número para Peso/Altura válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                if (radio_genero1.isSelected()) {
                    Genero = "Masculino";
                } else if (radio_genero2.isSelected()) {
                    Genero = "Feminino";
                } else {
                    Genero = "Outro";
                }

                Patient Paciente =new Patient(campo_nome_usuario.getText(),campo_cpf.getText(),campo_cel.getText(),campo_idade_paciente.getText(),Genero,pesofloat,alturafloat,campo_descricao.getText());
                lista_paciente.add(Paciente);
                System.out.println("============Botao APERTADO============");

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lista_paciente.ob"))) {
                    oos.writeObject(lista_paciente);
                    JOptionPane.showMessageDialog(null,"Obejtos Salvo com sucesso!");
                } catch (Exception A) {
                    A.printStackTrace();
                }

            }
        });
        botao_salvar.setBounds(10, 500, 80, 25);
        botao_salvar.addActionListener(new GUI());
        painel.add(botao_salvar);
        
        //Botao para mostrar pacientes salvos
        mostrar_pac= new JButton( new AbstractAction("Paciente") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                String info ="";

                ArrayList<Patient> listaDeObjetos = new ArrayList<>();

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lista_paciente.ob"))) {
                    listaDeObjetos = (ArrayList<Patient>) ois.readObject();
                    for (Patient objeto : listaDeObjetos) {
                        info += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                "IDADE: " +objeto.getAge()+ "\n" +
                                "GENERO: " + objeto.getSex()+ "\n" +
                                "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                "SSN: " + objeto.getSSN() + "\n" +
                                "PESO: " + objeto.getWeight() + "\n" +
                                "ALTURA: " + objeto.getHeight() + "\n" +
                                "DESCRIÇÂO: " + objeto.getDesc() + "\n" +
                                "========================================";
                        campo_info.setText(info);
                    }
                    patients.addAll(listaDeObjetos);
            
                } catch (Exception E) {
                    E.printStackTrace();
                } finally {
                    System.out.println("Ação Executada com Sucesso :)");
                }


            }
        });
        mostrar_pac.setBounds(150, 500, 100, 25);
        mostrar_pac.addActionListener(new GUI());
        painel.add(mostrar_pac);

        //Botao para carregar de csv dos medicos
        mostrar_funcionarios = new JButton( new AbstractAction("Auxiliares") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                String line = "";
                BufferedReader CSVcontent = null;
            
                String csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\doctors.csv";

                String info1 = "";


                
                try {

                     CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {
                        String[] info = line.split(";");
                        String name = info[0];
                        String SSN = info[1];
                        String cell_phone = info[2];
                        String age = info[3];
                        String sex = info[4];
                        float weight = Float.parseFloat(info[5]);
                        float height = Float.parseFloat(info[6]);
                        float hourlyPrice = Float.parseFloat(info[7]);
                        String medicalID = info[8];
                        int averageHourlyAppointments = Integer.parseInt(info[9]);

                        Doctor newDoc = new Doctor(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, averageHourlyAppointments);
                        docGeral.add(newDoc);

                        allDocs.add(newDoc);
                        }

                        
                        for (Doctor objeto : docGeral) {
                        info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                "IDADE: " +objeto.getAge()+ "\n" +
                                "GENERO: " + objeto.getSex()+ "\n" +
                                "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                "SSN: " + objeto.getSSN() + "\n" +
                                "PESO: " + objeto.getWeight() + "\n" +
                                "ALTURA: " + objeto.getHeight() + "\n" +
                                "FUNÇÃO: Clínico Geral" + "\n" +
                                "========================================";
                        campo_info.setText(info1);
                        }

                    csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\cardiologists.csv";
                    CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {
                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String SSN = info[1];
                            String cell_phone = info[2];
                            String age = info[3];
                            String sex = info[4];
                            float weight = Float.parseFloat(info[5]);
                            float height = Float.parseFloat(info[6]);
                            float hourlyPrice = Float.parseFloat(info[7]);
                            String medicalID = info[8];
                            int averageHourlyAppointments = Integer.parseInt(info[9]);
                            int numberOfHeartTransplant = Integer.parseInt(info[10]);

                            Cardiologist newDocCardio = new Cardiologist(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, averageHourlyAppointments, numberOfHeartTransplant);
                            docC.add(newDocCardio);

                            allDocs.add(newDocCardio);
                            }
                    }
                            
                            for (Cardiologist objeto : docC) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "IDADE: " +objeto.getAge()+ "\n" +
                                    "GENERO: " + objeto.getSex()+ "\n" +
                                    "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                    "SSN: " + objeto.getSSN() + "\n" +
                                    "PESO: " + objeto.getWeight() + "\n" +
                                    "ALTURA: " + objeto.getHeight() + "\n" +
                                    "FUNÇÃO: Cardiologista" + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }

                        csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\obstetricians.csv";
                        CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {
                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String SSN = info[1];
                            String cell_phone = info[2];
                            String age = info[3];
                            String sex = info[4];
                            float weight = Float.parseFloat(info[5]);
                            float height = Float.parseFloat(info[6]);
                            float hourlyPrice = Float.parseFloat(info[7]);
                            String medicalID = info[8];
                            int averageHourlyAppointments = Integer.parseInt(info[9]);
                            int numberOfBirths = Integer.parseInt(info[10]);

                            Obstetrician newDocObst = new Obstetrician(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, averageHourlyAppointments, numberOfBirths);
                            docObst.add(newDocObst);
                            
                            allDocs.add(newDocObst);
                            }
                    }
                            
                            for (Obstetrician objeto : docObst) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "IDADE: " +objeto.getAge()+ "\n" +
                                    "GENERO: " + objeto.getSex()+ "\n" +
                                    "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                    "SSN: " + objeto.getSSN() + "\n" +
                                    "PESO: " + objeto.getWeight() + "\n" +
                                    "ALTURA: " + objeto.getHeight() + "\n" +
                                    "FUNÇÃO: Obstetra" + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }

                        csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\orthopedists.csv";
                        CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {

                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String SSN = info[1];
                            String cell_phone = info[2];
                            String age = info[3];
                            String sex = info[4];
                            float weight = Float.parseFloat(info[5]);
                            float height = Float.parseFloat(info[6]);
                            float hourlyPrice = Float.parseFloat(info[7]);
                            String medicalID = info[8];
                            int averageHourlyAppointments = Integer.parseInt(info[9]);
                            int numberOfMeniscectomies = Integer.parseInt(info[10]);

                            Orthopedist newDocOrto = new Orthopedist(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, medicalID, averageHourlyAppointments, numberOfMeniscectomies);
                            docOrto.add(newDocOrto);

                            allDocs.add(newDocOrto);
                            }
                    }
                            
                            for ( Orthopedist objeto : docOrto) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "IDADE: " +objeto.getAge()+ "\n" +
                                    "GENERO: " + objeto.getSex()+ "\n" +
                                    "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                    "SSN: " + objeto.getSSN() + "\n" +
                                    "PESO: " + objeto.getWeight() + "\n" +
                                    "ALTURA: " + objeto.getHeight() + "\n" +
                                    "FUNÇÃO: Ortopedista" + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }


                        csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\nurses.csv";
                        CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {

                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String SSN = info[1];
                            String cell_phone = info[2];
                            String age = info[3];
                            String sex = info[4];
                            float weight = Float.parseFloat(info[5]);
                            float height = Float.parseFloat(info[6]);
                            float hourlyPrice = Float.parseFloat(info[7]);
                            String nurseID = info[8];
                            int assists = Integer.parseInt(info[9]);

                            Nurse newNurse = new Nurse(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, nurseID, assists);
                            nurs.add(newNurse);

                            allnurs.add(newNurse);

                            }
                    }
                            
                            for (Nurse objeto : nurs) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "IDADE: " +objeto.getAge()+ "\n" +
                                    "GENERO: " + objeto.getSex()+ "\n" +
                                    "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                    "SSN: " + objeto.getSSN() + "\n" +
                                    "PESO: " + objeto.getWeight() + "\n" +
                                    "ALTURA: " + objeto.getHeight() + "\n" +
                                    "FUNÇÃO: Enfermeira Geral" + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }

                        csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\EmergencyNurse.csv";
                        CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {

                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String SSN = info[1];
                            String cell_phone = info[2];
                            String age = info[3];
                            String sex = info[4];
                            float weight = Float.parseFloat(info[5]);
                            float height = Float.parseFloat(info[6]);
                            float hourlyPrice = Float.parseFloat(info[7]);
                            String nurseID = info[8];
                            int assists = Integer.parseInt(info[9]);

                            EmergencyNurse newNurseE = new EmergencyNurse(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, nurseID, assists);
                            nursE.add(newNurseE);

                            allnurs.add(newNurseE);

                            }
                    }
                            
                            for (EmergencyNurse objeto : nursE) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "IDADE: " +objeto.getAge()+ "\n" +
                                    "GENERO: " + objeto.getSex()+ "\n" +
                                    "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                    "SSN: " + objeto.getSSN() + "\n" +
                                    "PESO: " + objeto.getWeight() + "\n" +
                                    "ALTURA: " + objeto.getHeight() + "\n" +
                                    "FUNÇÃO: Enfermeira de Emergência" + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }

                        csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\PediatricNurse.csv";
                        CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {

                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String SSN = info[1];
                            String cell_phone = info[2];
                            String age = info[3];
                            String sex = info[4];
                            float weight = Float.parseFloat(info[5]);
                            float height = Float.parseFloat(info[6]);
                            float hourlyPrice = Float.parseFloat(info[7]);
                            String nurseID = info[8];
                            int assists = Integer.parseInt(info[9]);

                            PediatricNurse newNurseP = new PediatricNurse(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, nurseID, assists);
                            nursP.add(newNurseP);

                            allnurs.add(newNurseP);

                            }
                    }
                            
                            for (PediatricNurse objeto : nursP) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "IDADE: " +objeto.getAge()+ "\n" +
                                    "GENERO: " + objeto.getSex()+ "\n" +
                                    "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                    "SSN: " + objeto.getSSN() + "\n" +
                                    "PESO: " + objeto.getWeight() + "\n" +
                                    "ALTURA: " + objeto.getHeight() + "\n" +
                                    "FUNÇÃO: Enfermeira Pediátrica" + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }

                        csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\managers.csv";
                        CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {

                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String SSN = info[1];
                            String cell_phone = info[2];
                            String age = info[3];
                            String sex = info[4];
                            float weight = Float.parseFloat(info[5]);
                            float height = Float.parseFloat(info[6]);
                            float hourlyPrice = Float.parseFloat(info[7]);
                            String managerID = info[8];
                            int yearsAsaManager = Integer.parseInt(info[9]);

                            Manager newM = new Manager(name, SSN, cell_phone, age, sex, weight, height, hourlyPrice, managerID, yearsAsaManager);
                            manag.add(newM);

                            }
                    }
                            
                            for (Manager objeto : manag) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "IDADE: " +objeto.getAge()+ "\n" +
                                    "GENERO: " + objeto.getSex()+ "\n" +
                                    "TELEFONE:" + objeto.getCell_PhoneNumber()+ "\n" +
                                    "SSN: " + objeto.getSSN() + "\n" +
                                    "PESO: " + objeto.getWeight() + "\n" +
                                    "ALTURA: " + objeto.getHeight() + "\n" +
                                    "FUNÇÃO: Administrador" + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }
                    
                        csvFile = "C:\\Users\\Francisco\\Desktop\\Medical Records\\Medical Records\\hospitals.csv";
                        CSVcontent = new BufferedReader(new FileReader(csvFile));

                    while ((line = CSVcontent.readLine()) != null) {

                        while ((line = CSVcontent.readLine()) != null) {
                            String[] info = line.split(";");
                            String name = info[0];
                            String EIN = info[1];
                            String address = info[2];
                            int availableRooms = Integer.parseInt(info[3]);
                            String phoneNumber = info[4];
                            String specialty = info[5];
                            Doctor ChiefPhysician = null;
                            Manager manager = null;

                            for(Doctor d: allDocs) {
                                if (d.getName().equals(info[6])) {
                                    ChiefPhysician = d;
                                }
                            }

                            for(Manager m: manag) {
                                if (m.getName().equals(info[7])) {
                                    manager = m;
                                }
                            }

                            Hospital newHosp = new Hospital(name, EIN, address, availableRooms, phoneNumber, specialty, ChiefPhysician, manager);
                            hosp.add(newHosp);

                            }
                    }
                            
                            for (Hospital objeto : hosp) {
                            info1 += "\n" +"NOME: " +objeto.getName()+ "\n" +
                                    "EIN: " + objeto.getEIN()+ "\n" +
                                    "QUARTOS DISPONÍVEIS: " + objeto.getAvailableRooms()+ "\n" +
                                    "TELEFONE:" + objeto.getPhoneNumber()+ "\n" +
                                    "ESPECIALIDADE: " + objeto.getSpecialty() + "\n" +
                                    "CIRURGIÃO CHEFE: " + objeto.getChiefPhysician().getName() + "\n" +
                                    "ADMINISTRADOR: " + objeto.getmanager().getName() + "\n" +
                                    "========================================";
                            campo_info.setText(info1);
                        }

                } catch (FileNotFoundException e1) {
                    System.out.println("File not found: \n" + e1.getMessage());
                } catch (ArrayIndexOutOfBoundsException e1) {
                    System.out.println("Index out of bound: \n" + e1.getMessage());
                } catch (IOException e1) {
                    System.out.println("IO Error: \n" + e1.getMessage());
                } finally { 
                    if (CSVcontent != null) {
                        try {
                            CSVcontent.close();
                        } catch (IOException e1) {
                            System.out.println("IO Error: \n" + e1.getMessage());
                        }

                    }
                }

                for(Hospital h: hosp) {
                    if (h.getSpecialty().equals("General Medicine")) {
                        h.setDoctors(docGeral);
                        h.setNurses(nurs);
                    } else {
                        if (h.getSpecialty().equals("Cardiology")) {
                            h.setDoctors(docC);
                            h.setNurses(nursE);
                        } else {
                            if (h.getSpecialty().equals("Orthopedics")) {
                                h.setDoctors(docOrto);
                                h.setNurses(nurs);
                            } else {
                                if (h.getSpecialty().equals("Pediatrics")) {
                                    h.setDoctors(docObst);
                                    h.setNurses(nursP);
                                }
                            }
                        }      
                    }  
                }   

                System.out.println(docC.get(0).complain());

                System.out.println("");
                
                System.out.println(docC.get(1).payment(24));

                System.out.println("");

                System.out.println(docObst.get(0).complain());

                System.out.println("");

                System.out.println(docObst.get(1).payment(12));

                System.out.println("");

                System.out.println(docOrto.get(0).complain());

                System.out.println("");

                System.out.println(docOrto.get(1).payment(36));

                System.out.println("");

                System.out.println(nurs.get(1).requestExam(docC.get(1),  patients.get(0)));

                System.out.println("");

                System.out.println(manag.get(0).paySalaryMeeting(docOrto.get(2), 5));

                System.out.println("");
                
                System.out.println(hosp.get(0).employeeDescription(docC.get(1)));

                System.out.println("");

                System.out.println(hosp.get(0).employeeDescription(nursE.get(1)));

                System.out.println("");

                System.out.println(hosp.get(1).surgeryRecord(docObst.get(4), docGeral.get(0), docC.get(1), nursE.get(1), nursE.get(2), patients.get(0)));

                System.out.println("");

                System.out.println(nursP.get(2).callForManager(manag.get(3)));
        }
            
        });
        
        mostrar_funcionarios.setBounds(290, 500, 110, 25);
        mostrar_funcionarios.addActionListener(new GUI());
        painel.add(mostrar_funcionarios);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}




