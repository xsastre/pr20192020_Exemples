package pr20192020_exemples.streams_i_fitxers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Streams1_escriu_fitxer {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("fruita.txt"));
			bw.write("taronja\n");
			bw.write("mango\n");
			bw.write("xirimoia\n");
			bw.close();
		} catch (IOException ioe) {
			System.out.println("No s'ha pogut escriure el fitxer");
		}
	}
}

