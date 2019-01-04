package krystian.tutorial.hibernate.encje;

import java.util.Set;

public class Klient {
private int id;
private String imie;
private String nazwisko;
private Set<Zamowienie> zamowienia;
public Klient() {}
public Klient(String imie,String nazwisko,Set<Zamowienie> zamowienia) {
	this.imie=imie;
	this.nazwisko=nazwisko;
	this.zamowienia=zamowienia;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getImie() {
	return imie;
}
public void setImie(String imie) {
	this.imie = imie;
}
public String getNazwisko() {
	return nazwisko;
}
public void setNazwisko(String nazwisko) {
	this.nazwisko = nazwisko;
}
public Set<Zamowienie> getZamowienia() {
	return zamowienia;
}
public void setZamowienia(Set<Zamowienie> zamowienia) {
	this.zamowienia = zamowienia;
}
@Override
	public int hashCode() {
	
		return this.id;
	}
@Override
	public boolean equals(Object obj) {
	if(obj instanceof Klient) {
		Klient inny=(Klient)obj;
		return this.id==inny.id;
		}
	return false;
	}
}
