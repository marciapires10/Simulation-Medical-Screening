package MPEI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class minHashing<T> {
	
	private static int nHashF; // número de hash functions
	private final int lenShingle = 3; // tamanho da partição (shingles)
	
	private static int[] seed;
	
	public minHashing(int nHashF) {
		this.nHashF = nHashF;
		
		seed = generateSeed();
	}
	
	public static double similarity(Set<String> j1, Set<String> j2) {
		
		Set<Integer> set1 = new HashSet<Integer>(toArrayList(getHash(j1)));
		Set<Integer> set2 = new HashSet<Integer>(toArrayList(getHash(j2)));
		
		Set<Integer> intersect = new HashSet<Integer>(set1);
		intersect.retainAll(set2);
		
		Set<Integer> union = new HashSet<Integer>(set1);
		union.addAll(set2);
		
		if(union.isEmpty()) {
			return 0;
		}
		
		return (double) intersect.size() / union.size();
	}
	
	private static ArrayList<Integer> toArrayList(int[] array){
		ArrayList<Integer> newList = new ArrayList<>();
		
		for(int i : array) {
			newList.add(new Integer(i));
		}
		
		return newList;
	}
	
	
	// função que recebe a string e a divide em shingles
	public static Set<String> getShingle(String str, int lenShingle) {
		
		Set<String> set = new TreeSet<>();
		for(int i = 0; i + lenShingle <= str.length(); i++) {
			set.add(str.substring(i, i+lenShingle));
		}
		return set;
		
	} 
	
	
	private int[] generateSeed() {
		
		seed = new int [nHashF];
		
		for(int i = 0; i < nHashF; i++) {
			seed[i] = Math.abs((int)(Math.random()*Integer.MAX_VALUE));
		}
		
		return seed;
	}
	
	
	private static int getMinHash (String shingle) {
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < nHashF; i++) {
			int hashCode = shingle.hashCode() ^ seed[i];
			min = Math.min(min, hashCode);
		}
		
		return min;
	}
	
	//percorrer a shingle e retornar o seu hashValue
	private static int[] getHash (Set<String> shingle) {
		
		int [] hashValues = new int [shingle.size()];
		
		Iterator<String> setIterator = shingle.iterator();
		
		for(int i = 0; i < hashValues.length; i++) {
			hashValues[i] = getMinHash(setIterator.next());
		}
		
		return hashValues;
	}
	
}
