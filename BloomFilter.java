package MPEI;

import java.util.*;
import java.io.*;

public class BloomFilter {
	
	private boolean[] bloomf;
	private int nHash; // number of hash functions
	private int nElem = 0;
	private int m; // number of bits in the bloom filter
	private int n;
	
	
	
	public BloomFilter(int n) {
		this.n = n;
		m = (int)Math.round(((-n*Math.log(0.01))/Math.pow((Math.log(2)),2)));
		nHash = (int)((m/n)*Math.log(2));
		
		bloomf = new boolean[m];
	}
	
	
	
	public void insert(String elem) {
		
		for(int i=1; i <= nHash; i++) {
			elem += i;
			int hash = Math.abs(elem.hashCode());
			hash = Math.abs(hash % bloomf.length);
			bloomf[hash] = true;
		}
		
		nElem++;
	}
	
	public boolean isMember(String elem) {
		
		for(int i = 1; i <= nHash; i++) {
			elem += i;
			int hash = Math.abs(elem.hashCode());
			hash = Math.abs(hash % bloomf.length);
			if(!bloomf[hash]) {
				return false;
			}
		}
		return true;
	}
	
	
	public void getBF() {
		for(int i = 0; i < m; i++) {
			System.out.print(" " + bloomf[i]);
		}
	}
	
}
