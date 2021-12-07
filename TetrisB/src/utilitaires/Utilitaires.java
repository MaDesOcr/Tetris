package utilitaires;

import java.util.Iterator;
import java.util.Scanner;

public class Utilitaires {

	public static void fillEcran(char[][] ecran) {
		for(int i = 0; i<ecran.length; i++) {
			for(int j = 0; j<ecran[i].length; j++) {
				ecran[i][0] = '0';
				ecran[i][ecran.length-1] = '0';
				ecran[0][j] = '0';
				ecran[ecran.length-1][j] = '0';
			}
		}
		for(int i = 0; i<ecran.length; i++) {
			for(int j = 0; j<ecran[i].length; j++) {
				if(ecran[i][j] != '0') {
					ecran[i][j] = ' ';	
				}
			}
		}
	}

	public static void printEcran(char[][] ecran) {
		/*for (char[] cs : ecran) {
			//for (char cs2 : cs) {
				System.out.print(cs);
			//}
			System.out.println("");
		}*/
		
		for(int i = 0; i < ecran.length; i++) {
			for(int j = 0; j < ecran[i].length; j++) {
				System.out.print(ecran[j][i]);
			}
			System.out.println("");
		}
	}
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
}
