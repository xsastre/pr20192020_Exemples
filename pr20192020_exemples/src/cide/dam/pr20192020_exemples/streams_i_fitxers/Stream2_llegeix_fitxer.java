package cide.dam.pr20192020_exemples.streams_i_fitxers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stream2_llegeix_fitxer {



	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("fruita.txt"));
			String linia = "";
			while (linia != null) {
				System.out.println(linia);
				linia = bf.readLine();
			}
			bf.close();
		} catch (FileNotFoundException e) { // que fer si no troba el fitxer
			System.out.println("No es troba el fitxer fruita.txt");
		} catch (IOException e) { // que fer si hi ha un error en la lectura del fitxer
			System.out.println("No es pot llegir fruita.txt");
		}
	}
}
