package krystian.tutorial.hibernate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import krystian.tutorial.hibernate.dao.KlientDAO;
import krystian.tutorial.hibernate.encje.Klient;
import krystian.tutorial.hibernate.encje.KlientFirmowy;
import krystian.tutorial.hibernate.encje.KlientPrywatny;
import krystian.tutorial.hibernate.encje.Zamowienie;

public class MainActivity {
	public static void main(String args[]) {
    
	List<Klient> listaKlientow;
	String imie="Ola";
	KlientDAO klientDAO=new KlientDAO();
	klientDAO.wydrukujOgraniczonaIloscRekordow(1, 1);
	listaKlientow=klientDAO.pobierzKlientaPoImieniu(imie);
	for(Klient k: listaKlientow) {
		System.out.println(k.getImie()+" "+k.getNazwisko());
	} 
	klientDAO.kryteria();
	KlientFirmowy kf=new KlientFirmowy();
	kf.setImie("Sebastian");
	kf.setNazwisko("Mitura");
	kf.setNazwaFirmy("U Bastiana");
	kf.setNIP("132-132-54-31");
	boolean udaloSie =klientDAO.dodajKlientaFirmowego(kf);
	if(udaloSie)
		System.out.println("Udalo sie dodać!");
//	KlientPrywatny kp;
//	Zamowienie z=new Zamowienie();
//	z.setKlient(kp);
//	z.setAdres("Grabanów Kolonia 36a");
//	z.setData(new Date());
//	Set<Zamowienie> zbior=new HashSet<Zamowienie>();
//	zbior.add(z);
//	kp=new KlientPrywatny("Sebastian","Mitura",zbior,new Date());
//    klientDAO.dodajKlientaPrywatnego(kp);
//	Query<Zamowienie> q=s.createQuery("FROM Zamowienie z WHERE z.klient.imie=:imie",Zamowienie.class)
//	.setParameter("imie",imie);
//	Query q=s.createQuery("FROM Klient k join k.zamowienia as z with z.data > '2018-12-15'");
//	Query q=s.createQuery("SELECT k.nazwisko, count(*) as liczba FROM Klient k group by k.nazwisko having k.nazwisko like 'C%'");
//	
//	List<Klient> wyniki=q.list();
//	for(Object rekord : wyniki) {
//	Object[] tablice=(Object[])rekord;
//	String nazwisko=(String)tablice[0];
//	Long liczba=(Long)tablice[1];
//	System.out.println(nazwisko+" "+liczba);
//}
//	for(Klient k :wyniki)
//	System.out.println(k.getImie()+" "+k.getNazwisko());
//	for(Object rekord : wyniki) {
//	Object[] tablice=(Object[])rekord;
//	Klient k=(Klient)tablice[0];
//	Zamowienie z=(Zamowienie)tablice[1];
//	System.out.println(k.getImie()+" "+k.getNazwisko());
//}
//.setParameter("nazwisko", nazwiskoWejscie);
//			.setFirstResult(1)
//			.setMaxResults(1);
	
//	for(Zamowienie z:wyniki)
//		System.out.println(z.getId()+" "+z.getAdres());
//	for(Object rekord : wyniki) {
//		Object[] tablice=(Object[])rekord;
//		String imie=(String)tablice[0];
//		String nazwisko=(String)tablice[1];
//		System.out.println(imie+" "+nazwisko);
//	}
//	KlientFirmowy klient=(KlientFirmowy)s.get(KlientFirmowy.class, 1);
//	System.out.println(klient.getNazwaFirmy());
//	Transaction t=s.beginTransaction();
//	Klient klient=new Klient();
//	klient.setImie("Krystian");
//	klient.setNazwisko("Chalimoniuk");
//	Set<Zamowienie> zbior=new HashSet<Zamowienie>();
//	Zamowienie zamowienie=new Zamowienie();
//	zamowienie.setAdres("Grabanów");
//	zamowienie.setData(new Date());
//	zamowienie.setKlient(klient);
//	zbior.add(zamowienie);
//	klient.setZamowienia(zbior);
//	s.persist(klient);
//	t.commit();
//	List l=s.createQuery("SELECT k.imie from Klient k").list();
//	System.out.println(l.size());
	}
}
