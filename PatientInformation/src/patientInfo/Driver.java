package patientInfo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List ; 
class patient{
	static int id ; 
	private int patientid; 
	private String patientFirstname ; 
	private String patientLastname  ; 
	private int age ; 
	private String gender ;
	public  int getpatientid() {
		return patientid; 
	}
	List<Appointment> listOfAppointment = new ArrayList<Appointment>() ;
	{
		patientid = (++id + 1000) ; 
	}
	patient(String PatientFirstname , String PatientLastname , int age , String gender){
		this.patientFirstname = PatientFirstname ; 
		this.patientLastname = PatientLastname ; 
		this.age = age ; 
		this.gender = gender ; 
	}
	
	public String toString(){
		return patientid + " " +patientFirstname + " " + patientLastname + " " + age + " " +gender ; 
	}
}
class Appointment {
	String appointmentDate ; 
	String appointmentTime ; 
	String doctorname ; 
	Appointment(String appointmentDate  , String appointmentTime , String doctorname ){
		this.appointmentDate = appointmentDate ;
		this.appointmentTime = appointmentTime ; 
		this.doctorname = doctorname ; 
	}
	public String toString() {
		return appointmentDate + " " + appointmentTime + " " + doctorname ; 
	}
}
public class Driver {
	List<patient> listOfPatient = new ArrayList<patient>() ;
	
	public void addpatient() {
		Scanner sc = new Scanner(System.in) ; 
		System.out.println("Enter the First Name:-");
		String firstName = sc.nextLine() ; 
		System.out.println("Enter the Last Name:-");
		String lastName = sc.nextLine() ; 
		System.out.println("Enter ur age :-");
		int age = sc.nextInt() ; 
		sc.nextLine();
		System.out.println("Enter your gender :-");
		String gender = sc.nextLine() ; 
		listOfPatient.add(new patient(firstName , lastName , age , gender ));
		System.out.println("patient added succesfully");
	}
	public void bookAppointment() {
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Enter your id:-");
		int id = sc.nextInt() ; 
		sc.nextLine() ; 
		System.out.println("Enter your date of appointment:-");
		String appointmentDate = sc.nextLine() ; 
		System.out.println("Enter your time of appointment:-");
		String appointmentTime = sc.nextLine() ; 
		System.out.println("Enter Doctors Name:-");
		String docName = sc.nextLine() ; 
		
	}
	public void retrivePatientInformation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id :-");
		int id = sc.nextInt() ;
		boolean flag = false ; 
		for(int i = 0 ; i < listOfPatient.size() ; i++) {
			if(listOfPatient.get(i).getpatientid() == id) {
				System.out.println(listOfPatient.get(i));
				flag = true ; 
			}
		}
		if(flag == false) {
			System.out.println("Patient does not exits");
		}
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		Driver d = new Driver() ; 
		while(true) {
			System.out.println("press 1 to add patient");
			System.out.println("press 2 to retrive patient");
			System.out.println("press 3 to book appointment");
			System.out.println("press 4 to exit");
			int choice = sc.nextInt() ; 
			switch(choice) {
			case 1 : d.addpatient();
			break ; 
			case 2 : d.retrivePatientInformation();
			break ;
			case 3 : d.bookAppointment();
			break ; 
			case 4 : System.exit(0);
			break ; 
			default : System.out.println("Enter a valid choice.");
			}
		}
	}

}
