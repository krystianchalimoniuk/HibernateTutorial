package krystian.tutorial.hibernate.encje;

import java.util.Date;

public class Zamowienie {
private int id;
private Date data;
private String adres;
private Klient klient;
public Klient getKlient() {
	return klient;
}
public void setKlient(Klient klient) {
	this.klient = klient;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public String getAdres() {
	return adres;
}
public void setAdres(String adres) {
	this.adres = adres;
}

}
