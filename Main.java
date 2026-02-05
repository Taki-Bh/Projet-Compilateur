package compilateurnewversion;

import java.util.ArrayList;

import compilateurnewversion.parsernew;

public class Main {
	public static void main(String[] args) {

		compilateurnewversion.Scanner anaLex = new compilateurnewversion.Scanner("fichier_test.txt");
		ArrayList<String> tabLex= new ArrayList<String>();
		/*
		 * System.out.println("remplissage du tableaullll");
		 * System.out.println(anaLex.fluxCaracteres.size());
		 * for( int i=0; i<anaLex.fluxCaracteres.size();i++)
		 * 
		 * System.out.println(" " + anaLex.fluxCaracteres.get(i));
		 */
		System.out.println("***********************Analyse lexical*************************");
		int taille = anaLex.fluxCaracteres.size();
		String tab[] = new String[taille];
		for (int i = 0; i < anaLex.fluxCaracteres.size(); i++)
			// if (!tab[i].equals(ss))
			tab[i] = anaLex.fluxCaracteres.get(i).toString();

		UniteLexicale ul = null;
		do {
			ul = anaLex.lexemeSuivant();
			tabLex.add(ul.getCategorie().toString());
			System.out.println(ul);

		} while (ul.getCategorie() != Categorie.EOF);
		tab = new String[tabLex.size()];
		for( int i=0; i<tabLex.size();i++)	       	
		       	tab[i]=tabLex.get(i);

		System.out.println("***********************Analyse Syntaxique*************************");

		parsernew test22 = new parsernew();
		test22.analyzeSLRnew(tab);

	}
}