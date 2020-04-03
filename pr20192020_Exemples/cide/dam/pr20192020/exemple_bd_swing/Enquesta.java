package cide.dam.pr20192020.exemple_bd_swing;

import java.sql.Date;

public class Enquesta {
	public int id ;
	public String nom_descriptiu;
	public Date data_inici;
	public Date data_fi;
	public int tipus;
	public int numero_preguntes;
	public String token;
	public String alias;	
	
	public Enquesta() {

	}
	
	public Enquesta(int id, String nom_descriptiu, Date data_inici, Date data_fi, int tipus, int numero_preguntes,
			String token, String alias) {
		super();
		this.id = id;
		this.nom_descriptiu = nom_descriptiu;
		this.data_inici = data_inici;
		this.data_fi = data_fi;
		this.tipus = tipus;
		this.numero_preguntes = numero_preguntes;
		this.token = token;
		this.alias = alias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_descriptiu() {
		return nom_descriptiu;
	}

	public void setNom_descriptiu(String nom_descriptiu) {
		this.nom_descriptiu = nom_descriptiu;
	}

	public Date getData_inici() {
		return data_inici;
	}

	public void setData_inici(Date data_inici) {
		this.data_inici = data_inici;
	}

	public Date getData_fi() {
		return data_fi;
	}

	public void setData_fi(Date data_fi) {
		this.data_fi = data_fi;
	}

	public int getTipus() {
		return tipus;
	}

	public void setTipus(int tipus) {
		this.tipus = tipus;
	}

	public int getNumero_preguntes() {
		return numero_preguntes;
	}

	public void setNumero_preguntes(int numero_preguntes) {
		this.numero_preguntes = numero_preguntes;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}}
