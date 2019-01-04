package krystian.tutorial.hibernate.encje;

import java.util.Date;
import java.util.Set;

public class KlientPrywatny extends Klient {
private Date dataUrodzenia;
public KlientPrywatny(String imie,String nazwisko,Set<Zamowienie> zamowienia,Date dataUrodzenia) {
	super(imie, nazwisko, zamowienia);
	this.dataUrodzenia=dataUrodzenia;
	
}
public KlientPrywatny(){}
public Date getDataUrodzenia() {
	return dataUrodzenia;
}
public void setDataUrodzenia(Date dataUrodzenia) {
	this.dataUrodzenia = dataUrodzenia;
};

}
