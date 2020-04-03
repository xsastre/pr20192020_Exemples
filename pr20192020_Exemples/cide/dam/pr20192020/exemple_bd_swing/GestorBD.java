package cide.dam.pr20192020.exemple_bd_swing;

import java.util.*;

import java.sql.*;
import java.sql.Date;

//Aquesta classe fa el mecanisme de persistència independent de la GUI.
public class GestorBD {
	Connection conn;

	public GestorBD() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false","xavier","carnambsalsa");
	}

	public void tancar() throws Exception {
		conn.close();
	}
	
	public Enquesta obtenirEnquesta(String codi) throws SQLException {
		Enquesta novaEnquesta=new Enquesta();
		Statement consulta = conn.createStatement();
		ResultSet r = consulta.executeQuery("select id, nom_descriptiu, data_inici, data_fi, tipus, numero_preguntes,alias from enquestes where alias="+codi);
		if (r.next()) {
			novaEnquesta=new Enquesta(r.getInt("id"),r.getString("nom_descriptiu"),r.getDate("data_inici"),r.getDate("data_inici"),r.getInt("tipus"),r.getInt("numero_preguntes"),r.getString("token"),r.getString("alias"));
		}
		return novaEnquesta;
	}
	
	public List<Enquesta> obtenirEnquestes() throws SQLException {
		Statement cerca = conn.createStatement();
		ResultSet r = cerca.executeQuery("SELECT * FROM enquestes");

		LinkedList<Enquesta> llista = new LinkedList<Enquesta>();
		while (r.next()) {
			llista.add(new Enquesta(r.getInt("id"),r.getString("nom_descriptiu"),r.getDate("data_inici"),r.getDate("data_inici"),r.getInt("tipus"),r.getInt("numero_preguntes"),r.getString("token"),r.getString("alias")));

		}
		return llista;
		
	}
	public String[] ObtenirAliesEnquestes (List<Enquesta> llistaenquestes) {
		int numeroEnquestes=llistaenquestes.size();
		String[] matriuAlies=new String[numeroEnquestes];
		int comptador=0;
		for(Enquesta enquesta : llistaenquestes){
			matriuAlies[comptador]=enquesta.alias;
			comptador++;
		}
		return matriuAlies;
	}

}