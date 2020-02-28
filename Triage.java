package MPEI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Triage {

	private static ArrayList<User> ListUsers = new ArrayList<User>();
    private static BloomFilter bf = new BloomFilter(100);
    
    	
    public static void main(String[] args) {
   
    	
    	Scanner sc = new Scanner(System.in);
    	
        int choice = 1;
        String name;
        int age;
        boolean gender;
        String local;
        int nTimes;
        String[] symptoms = new String[5];
        
        
        do {
        	System.out.println("........................................");
        	System.out.println("");
        	System.out.println("WELCOME TO OUR NATIONAL HOSPITAL SERVICE");
        	System.out.println("........................................");
        	System.out.println("");
            System.out.println("---------MENU----------");
            System.out.println("1) Input your data");
            System.out.println("2) Generate random users");
            
            choice = sc.nextInt();
            
            switch (choice) {
            
            case 1:
                System.out.print("Name: ");
                name = sc.next();
                System.out.print("Age: ");
                age = sc.nextInt();
                System.out.print("Gender (male = 1 / female = 0): ");
                
                if(sc.nextInt()==1){
                    gender = true;
                }
                else {
                	gender = false;
                }
                
                System.out.print("Local of: ");
                local = sc.next();
                System.out.print("Number of times went to the hospital: ");
                nTimes = sc.nextInt();
                StochasticCounter.event(nTimes);
                
                System.out.print("Symptoms: (write 5) \n");
                Scanner lerSintomas = new Scanner(System.in);
                for (int i = 0; i < 5; i++) {
                    symptoms[i] = lerSintomas.nextLine();
                }
                
                User pacient = new User(name, age, gender, local, nTimes, symptoms);
                
                System.out.println("");
                System.out.println("Your data were introduced!");
                System.out.println("");
                
                addUser(pacient);
                
                System.out.println("Confirm your data");
                System.out.println("-----------------");
                System.out.print(pacient.toString());
                System.out.println("");
                System.out.println("");
                System.out.println("-----------------");
                System.out.println("");
                System.out.println("Do you want to know your diagnose? Press 1 if yes; Press 2 if no");
                
                
                if(sc.nextInt() == 1) {
                	
                	Set<String> set1 = new HashSet<String>();
                	for(int i = 0; i < 5; i++) {
                		set1.add(symptoms[i]);
                		set1 = minHashing.getShingle(symptoms[i], 3);
                	}
                	
                	String[][] diagnostico = RandomGenerator.getDoencas();
                	
                	Set<String> set2 = new HashSet<String>();
                	for(int i = 0; i < 6; i++) {
                		for(int j = 1; j < 6; j++) {
                			set2.add(diagnostico[i][j]);
                			set2 = minHashing.getShingle(diagnostico[0][2], 3);
              
                		}
                		
                		
                		String oi = "hello ola adeus";
                		Set<String> set3 = minHashing.getShingle(oi, 3);
                		
                		String adeus = "adeus oi ahah";
                		Set<String> set4 = minHashing.getShingle(adeus, 3);
                		System.out.println(minHashing.similarity(set3, set4));
                		
                		//if (minHashing.similarity(set1, set2) > 0.8) {
                          //  System.out.println("Um possível diagnóstico é: " + diagnostico[i][0]);
                        //}
                		//set2.clear();
                	}
                }
                 break;
            case 2:
            	for(int i = 1; i < 20; i++) {
	            	addUser(RandomGenerator.GeneratePerson());
	            	System.out.println(RandomGenerator.GeneratePerson().toString());
            	}
            	break;
            case 0:
                System.exit(0);
                break;

            }
        } while (choice != 0);
    }
    

	public static boolean addUser(User u) {
    	
    	if(ListUsers.contains(u)) {
    		return false;
    	}
    	
    	ListUsers.add(u);
    	bf.insert(u.getName());
    	
    	return true;
    }
    
  
}