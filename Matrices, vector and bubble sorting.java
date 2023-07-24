import java.util.Random;
import java.util.Scanner;

public class MD2_4_Pauls_Brikmanis {

	public static void fillSpecialMatrice(char[][] matrice) {
		Random random = new Random();
		String burti = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for(int i = 0; i < matrice.length; i++) {
					for(int j = 0; j <= i; j++) {   
							matrice[i][j] = burti.charAt(random.nextInt(52));
					}
			}
	}
	
	public static char[] matriceToVector(char[][] matrice) {
		int elSkaits=((matrice.length*matrice.length)-matrice.length)/2+matrice.length;
		char[] vector = new char[elSkaits];
		int k = 0;
		
		for(int i = 0; i < matrice.length; i++) {
			for(int j = 0; j < matrice.length; j++) {
				if (matrice[i][j] != 0)
					vector[k++] = matrice[i][j];
			}
		}
		return vector;
	}
	
	
	public static void displayMatrice(char[][] matrice)	{
		System.out.println("***********************************");
		System.out.println("Matrica:");
		for (int i=0; i<matrice.length; i++) {
			for (int j=0; j<matrice.length; j++) {
				System.out.print(matrice[i][j] + "  "); 
			}
			System.out.println();
		}
		System.out.println("**********************************");
		return;
	}
	
	public static void displayVector(char[] vector) {
	System.out.println("Vektors:");
	for (int k=0; k<vector.length; k++) {
		System.out.print(vector[k] + "  ");
		}
	System.out.println();
	System.out.println("*********************************");
	}
	
	public static void sentinelSearch(char[] vector, char x) {
		int indeks = 0;
		int elSkaits=vector.length; 
		char last = vector[elSkaits-1]; 
		vector[elSkaits-1] = x; 
		int i = 0;
		while (vector[i] !=x) i++;
		vector[elSkaits-1] = last; 
		if (vector[i] == x)  indeks = i;  
		else indeks = -1;  
		if (indeks ==-1) 
			System.out.println("Burts " + x + " neatrodas dotajā vektorā!");
		else
			System.out.println("Burts " + x + " atrodas vektorā, un tā indekss ir:" + indeks);
	}

	public static char[] bubbleSort(char[] vector_k) {
		int n = vector_k.length; 
		char temp;
		int i,j;
        for (i = 0; i < n-1; i++) 
            for (j = 0; j < n-i-1; j++) 
                if (vector_k[j] < vector_k[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    temp = vector_k[j]; 
                    vector_k[j] = vector_k[j+1]; 
                    vector_k[j+1] = temp; 
                } 
		return vector_k;
	}
		
		
	public static void main(String[] args) {
		System.out.println("Pauls Brikmanis 201RDB002 5.grupa");
		char[][] c;
		c = new char[7][7];
		fillSpecialMatrice(c);
		char[] cv;
		cv = matriceToVector(c);
			

		displayMatrice(c);
		displayVector(cv);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Kādu burtu sameklēt:");
		
		char burts=sc.next().charAt(0);
		
		while ((burts < 97 || burts > 123) && (burts < 65 || burts > 91)) {
			System.out.println("Nekorekta ievade!");
			System.out.println("Ievadiet burtu:");
			char burts1=sc.next().charAt(0);
			burts = burts1;
		}
		sc.close();
		
		sentinelSearch(cv,burts);
		
		char[] cv_kartots;
		cv_kartots = bubbleSort(cv);
		
		System.out.println("Kārtots vektors:");
		for (int k=0; k<cv_kartots.length; k++) {
			System.out.print(cv_kartots [k]+" ");
			}
		System.out.println();
		System.out.println("*********************************");
		}
		
	}