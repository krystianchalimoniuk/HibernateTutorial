package krystian.tutorial.hibernate.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import krystian.tutorial.hibernate.dbconfig.Dbconfig;
import krystian.tutorial.hibernate.encje.Klient;
import krystian.tutorial.hibernate.encje.KlientFirmowy;
import krystian.tutorial.hibernate.encje.KlientPrywatny;
import krystian.tutorial.hibernate.encje.Zamowienie;

public class KlientDAO {
private Session s;
private List <Klient> listaKlientow;
private Query<Klient> query;
private Query q;
private Transaction t;
	public KlientDAO(){
	s=Dbconfig.getInstance();
}
	public boolean dodajKlientaFirmowego(KlientFirmowy k) {
		try {
			t=s.beginTransaction();
			s.persist(k);
			t.commit();
			return true;	
		} catch (Exception e) {
		    e.printStackTrace();
		    t.rollback();
		    return false;
		}
	}
	public boolean dodajKlientaPrywatnego(KlientPrywatny k) {
		try {
			t=s.beginTransaction();
			s.persist(k);
			t.commit();
			return true;	
		} catch (Exception e) {
		    e.printStackTrace();
		    t.rollback();
		    return false;
		}
	}
	public List<Klient> pobierzKlientaPoImieniu(String imie){
		query=s.createQuery("FROM Klient k WHERE imie=:imie",Klient.class)
				.setParameter("imie", imie);
		listaKlientow=query.list();
		return listaKlientow;
	}
	public void wydrukujIloscKlientowoNazwiskuNaC() {
		q=s.createQuery("SELECT k.nazwisko, count(*) as liczba FROM Klient k group by k.nazwisko having k.nazwisko like 'C%'");
		listaKlientow=q.list();
		for(Object rekord : listaKlientow) {
			Object[] tablice=(Object[])rekord;
			String nazwisko=(String)tablice[0];
			Long liczba=(Long)tablice[1];
			System.out.println(nazwisko+" "+liczba);
		}
	}
	public void wydrukujOgraniczonaIloscRekordow(int offset,int limit) {
		query=s.createQuery("FROM Klient k", Klient.class)
		.setFirstResult(offset)
		.setMaxResults(limit);
		listaKlientow=query.list();
		for(Klient klient: listaKlientow)
			System.out.println(klient.getImie()+" "+klient.getNazwisko());
	}
	public boolean updateKlient(String oldName,String newName) {
		try {
			Transaction t=s.beginTransaction();
			s.createQuery("update Klient k set k.imie=:stare WHERE k.imie=:nowe")
			.setParameter(":stare", oldName)
			.setParameter(":nowe", newName)
			.executeUpdate();
			t.commit();
			return true;	
		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
	}
	public boolean usunKlienta(int id) {
		try {
			Transaction t=s.beginTransaction();
			s.createQuery("DELETE Klient k WHERE k.id=:id")
			.setParameter(":id", id)
			.executeUpdate();
			t.commit();
			return true;	
		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
	}
	public void kryteria(){
		CriteriaBuilder builder=s.getCriteriaBuilder();
		CriteriaQuery<Klient> criteria = builder.createQuery(Klient.class);
	    Root<Klient> myObjectRoot = criteria.from(Klient.class);
	    Join<Klient, Zamowienie> joinObject = myObjectRoot.join("zamowienia");

	    Predicate likeRestriction = builder.and(
	            builder.equal( myObjectRoot.get("imie"), "Krystian"),
	            builder.equal(myObjectRoot.get("nazwisko"), "Chalimoniuk"),
	            builder.equal(joinObject.get("adres"),"Grabanów" )
	    );
	    criteria.select(myObjectRoot).where(likeRestriction);
		TypedQuery<Klient> query = s.createQuery(criteria);
		listaKlientow=(List<Klient>)query.getResultList();
		for (Klient k:listaKlientow)
			System.out.println(k.getImie());
	}
}
