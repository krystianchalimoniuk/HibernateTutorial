package krystian.tutorial.hibernate.encje;

public class KlientFirmowy extends Klient {
private String nazwaFirmy;
private String NIP;
public String getNazwaFirmy() {
	return nazwaFirmy;
}
public void setNazwaFirmy(String nazwaFirmy) {
	this.nazwaFirmy = nazwaFirmy;
}
public String getNIP() {
	return NIP;
}
public void setNIP(String NIP) {
	this.NIP = NIP;
}
}
