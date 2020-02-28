package MPEI;

import java.util.Scanner;

public class StochasticCounterTest {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	StochasticCounter CounterTester = new StochasticCounter(0.25);
    	
    	System.out.println("Testing --> Stochastic Counter");
		System.out.println("");
        System.out.println("Counter for 1 million entries with a probability of being sick of 25%");
        
        int n_tester = 1000000;
        
        for (int i = 0; i < n_tester; i++) {
            CounterTester.event();
        }
        
        System.out.print("Number of times being sick: " + (double) CounterTester.value() + "\n");
        System.out.print("Aproximate number of entries: " + (double) CounterTester.value() / 0.25 + "\n");

        System.out.println("-------------------------------------------------------");

        System.out.println("Testing with entries from the user");
        
        System.out.print("First and Last Name: \n");
        String NameTest = sc.nextLine();
        
        System.out.print("Number of your entries in the hospital: \n");
        int n = sc.nextInt();
        
        System.out.print("Probability of being sick  \n");
        double prob = sc.nextDouble() / 100.0;
        
        StochasticCounter User_Test = new StochasticCounter(prob, NameTest);
        for (int i = 0; i < n; i++) {
            User_Test.event();
        }
        System.out.println("For the user: " + User_Test.name());
        System.out.println("Number of times being sick: " + (double) User_Test.value());
        System.out.println("Aproximate number of entries: " + (int) ((double)User_Test.value() / prob));
    }
}