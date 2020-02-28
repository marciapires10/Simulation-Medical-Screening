package MPEI;

import java.util.Random;
import java.util.Scanner;

public class TestBloomFilter {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int op = -1;
		int opp;
		
		int k = 6;
		
		System.out.println("Testing --> BloomFilter");
		System.out.println("");
		
		BloomFilter bloomfilter = new BloomFilter(100);
		
		do {
			System.out.println("-------- MENU --------");
			System.out.println("1. Test with fixed strings");
			System.out.println("2. Test with random strings");
			System.out.println("3. Test with random generated people");
			System.out.println("Press 0 to exit");
			opp = sc.nextInt();
			
			switch(opp) {
			case 1:
	
				String[] str = {"Estou com dores de garganta", "Tenho febre", "Tenho náuseas", "Estou com febre", "Estou com dificuldade a respirar", "Tenho dor a urinar"};
				String[] str1 = {"Tenho febre", "Estou com febre", "Tenho dores abdominais", "Estou com variações de humor", "Estou com dificuldade a respirar", "Tenho manchas vermelhas na pele"};
		
		
				System.out.println("Inserting strings...");
				System.out.println("");
				for (String strings : str) {
					System.out.println(strings);
					bloomfilter.insert(strings);
					System.out.println("Inserted on Bloom Filter");
					System.out.println("");
				}
				
				System.out.println("Checking...");
				System.out.println("");
				for (String strings : str1) {
					System.out.println("String: " + strings + (bloomfilter.isMember(strings)?" is on the BF ":" is not on the BF"));
					System.out.println("");
				}
				
			break;
			
			case 2:
				String[] str2 = {randString(), randString(), randString(), randString(), randString(), randString()};
				String[] str3 = {randString(), randString(), randString(), randString(), randString(), randString()};
				
				System.out.println("Inserting strings...");
				System.out.println("");
				for (String strings : str2) {
					System.out.println(strings);
					bloomfilter.insert(strings);
					System.out.println("Inserted on Bloom Filter");
					System.out.println("");
				}
				
				System.out.println("Checking...");
				System.out.println("");
				
				for (String strings : str3) {
					System.out.println("String: " + strings + (bloomfilter.isMember(strings)?" is on the BF ":" is not on the BF"));
					System.out.println("");
				}
					
			break;
			
			case 3:
				String[] str4 = {RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName()};
				String[] str5 = {RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName(), RandomGenerator.GeneratePerson().getName()};
				
				System.out.println("Inserting strings...");
				System.out.println("");
				for (String strings : str4) {
					System.out.println(strings);
					bloomfilter.insert(strings);
					System.out.println("Inserted on Bloom Filter");
					System.out.println("");
				}
				
				System.out.println("Checking...");
				System.out.println("");
				
				for (String strings : str5) {
					System.out.println("String: " + strings + (bloomfilter.isMember(strings)?" is on the BF ":" is not on the BF"));
					System.out.println("");
				}
				
			
			case 0:
				System.exit(0);
			break;
			
			}
		} while (op == -1);
	
	}
	
		public static String randString() {
		
		String alpha = new String("abcdefghijklmnopqrstuvwxyz");
		int len = alpha.length();
		
		String str = new String();
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++) {
			str = str + alpha.charAt(rand.nextInt(len));
		}
		
		return str;
	}
}
