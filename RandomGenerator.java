package MPEI;

public class RandomGenerator {
	
	static String[] nameM = {"Adriano", "Afonso", "Alexandre", "André", "António", "Bernardo", "Bruno", "Caetano", "Carlos", "Cláudio", 
								"Daniel", "David", "Dinis", "Duarte", "Eduardo", "Fábio", "Fernando", "Filipe", "Gabriel", "Gonçalo", "Igor", "João", 
								"Joel", "José", "Júlio", "Leandro", "Leonardo", "Luís", "Marcelo", "Mariano", "Mateus", "Nelson", 
								"Nuno", "Óscar", "Pedro", "Paulo", "Rafael", "Renato", "Ricardo", "Rodrigo", "Rui", "Salvador", "Samuel", 
								"Sebastião", "Telmo", "Tiago", "Tomás", "Vasco", "Vicente", "Xavier"};
	
	
	static String[] nameF = {"Adriana", "Alexandra", "Alice", "Amélia", "Ana", "Anabela", "Bárbara", "Beatriz", "Bruna", 
								"Camila", "Carolina", "Catarina", "Cláudia", "Cristina", "Daniela", "Débora", "Diana", 
								"Eduarda", "Elisabete", "Elsa", "Fabiana", "Fátima", "Gabriela", "Gisela", "Helena",
								"Iara", "Inês", "Jéssica", "Joana", "Juliana", "Laura", "Letícia", "Lúcia", "Luísa",
								"Madalena", "Margarida", "Maria", "Mariana", "Marta", "Melissa", "Natália", "Olívia",
								"Patrícia", "Paula", "Raquel", "Rita", "Rosa", "Sandra", "Sara", "Sofia", "Soraia", 
								"Tatiana", "Teresa", "Vanessa", "Vera"};
	
	static String[] surname = {"Silva", "Santos", "Ferreira", "Pereira", "Oliveira", "Rodrigues", "Martins", "Jesus", "Sousa", "Fernandes", 
									"Gonçalves", "Gomes", "Lopes", "Marques", "Alves", "Almeida", "Ribeiro", "Pinto", "Carvalho", "Teixeira",
									"Moreira", "Correia", "Mendes", "Nunes", "Soares", "Vieira", "Monteiro", "Cardoso", "Rocha", "Raposo", 
									"Neves", "Coelho", "Cruz", "Cunha", "Pires", "Ramos", "Reis", "Simões", "Antunes", "Matos", "Fonseca", 
									"Machado", "Araújo", "Barbosa", "Tavares", "Lourenço", "Castro", "Figueiredo", "Azevedo"};
	
	
	static String[] location = {"Aveiro", "Beja", "Braga", "Bragança", "Castelo Branco", "Coimbra", "Évora", "Faro", "Guarda", "Leiria",
									"Lisboa", "Portalegre", "Porto", "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu"};
	
	
	
	static String[] symptoms = {"febre", "náseas", "dor de cabeça", "calafrios", "tosse", "dor de garganta", "dores musculares", "dor a urinar",
			"perda de apetite", "suores noturnos", "manchas vermelhas na pele", "perda de peso", "problemas de memória",
			"dificuldade em respirar", "dor abdominal", "alterações na cor da urina", "diarreia", "tonturas", "mal estar",
			"cansaço", "variações de humor"};

	static String[] SIDA  = {"SIDA", "febre", "suores noturnos", "manchas vermelhas na pele", "tosse", "dificuldade em respirar"};
	static String[] Infecao_Urinaria = {"Infeçãoo Urinária" ,"dor abdominal", "alterações na cor da urina", "febre", "mal estar", "dor a urinar"};
	static String[] Apendicite = {"Apendicite", "dor abdominal", "náuseas", "febre", "mal estar", "diarreia"};
	static String[] gripe = {"gripe", "febre", "calafrios", "dor de cabeça", "tosse", "dor de garganta"};
	static String[] Gravidez = {"Gravidez", "dor de cabeça", "náuseas", "tonturas", "cansaço", "variações de humor"};
	static String[] Gastroenterite = {"Gastroenterite", "náuseas", "febre", "diarreia", "perda de apetite", "perda de peso"};
	static String[][] doencas = {SIDA , Infecao_Urinaria , Apendicite , gripe, Gravidez , Gastroenterite };

	
	
	public static User GeneratePerson() {
		
		User user = new User();
		
		user.setGender(Math.random()>0.5); // atribui um género ao utente criado
		
		if(user.isGender()) {
			user.setName(nameM[(int) randRange(0, nameM.length-1)]);
		}
		
		else {
			user.setName(nameF[(int) randRange(0, nameF.length-1)]);
		
		}
		
		user.setName(user.getName()+" "+surname[(int) randRange(0, surname.length-1)]); 
		
		user.setAge((int)randRange(1,80)); 
		
		user.setLocal(location[(int) randRange(0, location.length-1)]);
		
		user.setnTimes((int) randRange(1,20));

		user.setDisease(doencas);

		return user;
		
		
	}
	
	public static String[][] getDoencas(){
		return doencas;
	}
	
	
	private static double randRange(double min, double max) {
		return min + (int)(Math.random() * (max - min) + 1);
	}

	
}