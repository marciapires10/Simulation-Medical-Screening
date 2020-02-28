package MPEI;

public class User {

	
	private String name;
	private int age;
	private boolean gender; // se for igual a 1 = homem, se for igual a 0 = mulher
	private String local;
	private int nTimes; // número de entradas no hospital no último ano (através do contador estocástico)
	private String[] symptoms = new String[5];
	private String[] disease;
	
	
	// constructor
	
	public User(String name, int age, boolean gender, String local, int nTimes, String[] symptoms) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.local = local;
		this.nTimes = nTimes;
		this.symptoms = symptoms;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	public User(User generatePerson) {
		// TODO Auto-generated constructor stub
	}

	// getters 
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isGender() {
		return gender;
	}

	public String getLocal() {
		return local;
	}

	public int getnTimes() {
		return nTimes;
	}

	public String[] getSymptoms() {
		return symptoms;
	}
	
	public String[] getDisease() {
		return disease;
	}
	
	
	// setters
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setnTimes(int d) {
		this.nTimes = d;
	}

	public void setDisease(String[][] diseases) {
		int i = randRange(0, 5);
		this.disease = diseases[i];
	}
	
	
	@Override
	
	public String toString() {
		String str = "";
		
		if(name != null) {
			str += name;
		}
		
		if(age != 0) {
			if(str != "") {
				str += ", ";
			}
			str += this.age + " years";
		}
		
		if(gender != true) {
			if(gender) {
				if(str != "") {
					str += ", ";
				}
				str += "Male";
			}
			else {
				if(str != "") {
					str += ", ";
				}
				str += "Female";
			}
		}
		
		if(local != null) {
			if(str != "") {
				str += ", ";
			}
			str += local;
		}
		
		if(nTimes != 0) {
			if(str != "") {
				str += ", ";
			}
			str += this.nTimes + " times here in the last year";
		}
		
		
		return str;
	}
	
	private static int randRange(int min, int max) {
		return min + (int)(Math.random() * (max - min) + 1);
	}
}
