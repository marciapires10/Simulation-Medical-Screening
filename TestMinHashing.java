package MPEI;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TestMinHashing {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int op = -1;
		int opp;
		minHashing minHash = new minHashing(100);
		
		System.out.println("Testing --> minHashing");
		System.out.println("");
		
		do {
			System.out.println("-------- MENU --------");
			System.out.println("1. Test with fixed strings");
			System.out.println("2. Test with your own strings");
			System.out.println("3. Test with random strings");
			System.out.println("Press 0 to exit");
			opp = sc.nextInt();
			
			switch(opp) {
			case 1:
				String str1 = "Estou com febre";
				String str2 = "Tenho dor de garganta";
				String str3 = "Estou com dor de cabeça";
				
				System.out.println(str1);
				System.out.println(str2);
				System.out.println(str3);
				
				Set<String> set1 = minHashing.getShingle(str1, 3);
				Set<String> set2 = minHashing.getShingle(str2, 3);
				Set<String> set3 = minHashing.getShingle(str3, 3);
				
				System.out.println("1) Similarity: " + minHashing.similarity(set1, set2));
				System.out.println("2) Similarity: " + minHashing.similarity(set2, set3));
				System.out.println("3) Similarity: " + minHashing.similarity(set1, set3));
			
			break;
			
			case 2:

				sc.nextLine();
				System.out.println("Insert first string");
				String str4 = sc.nextLine();
				System.out.println("Insert second string");
				String str5 = sc.nextLine();
				System.out.println("Insert third string");
				String str6 = sc.nextLine();
				
				Set<String> set4 = minHashing.getShingle(str4, 3);
				Set<String> set5 = minHashing.getShingle(str5, 3);
				Set<String> set6 = minHashing.getShingle(str6, 3);
				
				System.out.println("1) Similarity: " + minHashing.similarity(set4, set5));
				System.out.println("2) Similarity: " + minHashing.similarity(set5, set6));
				System.out.println("3) Similarity: " + minHashing.similarity(set4, set6));
			
			break;
			
			case 3:
				String str7 = randString();
				String str8 = randString();
				String str9 = randString();
				
				Set<String> set7 = minHashing.getShingle(str7, 2);
				Set<String> set8 = minHashing.getShingle(str8, 2);
				Set<String> set9 = minHashing.getShingle(str9, 2);
				
				System.out.println("1) Similarity: " + minHashing.similarity(set7, set8));
				System.out.println("2) Similarity: " + minHashing.similarity(set8, set9));
				System.out.println("3) Similarity: " + minHashing.similarity(set7, set9));
			break;
			
			case 0:
				System.exit(0);
			break;
			
			}
			
		} while (op == -1);
		
	}
	
	public static String randString() {
		
		String alpha = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		int len = alpha.length();
		
		String str = new String();
		Random rand = new Random();
		
		for(int i = 0; i < 100; i++) {
			str = str + alpha.charAt(rand.nextInt(len));
		}
		
		return str;
	}
}
