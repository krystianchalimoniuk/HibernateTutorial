package krystian.tutorial.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import krystian.tutorial.hibernate.encje.Klient;

public class KlientsDAO implements KlientDAOImpl<Klient, String> {

	private Session currentSession;

	private Transaction currentTransaction;

	public KlientsDAO() {

	}

	public Session openCurrentSession() {

		currentSession = getSessionFactory().openSession();

		return currentSession;

	}

	public Session openCurrentSessionwithTransaction() {

		currentSession = getSessionFactory().openSession();

		currentTransaction = currentSession.beginTransaction();

		return currentSession;

	}

	public void closeCurrentSession() {

		currentSession.close();

	}

	public void closeCurrentSessionwithTransaction() {

		currentTransaction.commit();

		currentSession.close();

	}

	private static SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()

				.applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		return sessionFactory;

	}

	public Session getCurrentSession() {

		return currentSession;

	}

	public void setCurrentSession(Session currentSession) {

		this.currentSession = currentSession;

	}

	public Transaction getCurrentTransaction() {

		return currentTransaction;

	}

	public void setCurrentTransaction(Transaction currentTransaction) {

		this.currentTransaction = currentTransaction;

	}

	@Override
	public void persist(Klient entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Klient entity) {
		getCurrentSession().update(entity);

	}

	@Override
	public Klient findById(String id) {
		Klient klient = (Klient) getCurrentSession().get(Klient.class, id);
		return klient;

	}

	@Override
	public void delete(Klient entity) {
		getCurrentSession().delete(entity);

	}

	@Override
	public List<Klient> findAll() {
		List<Klient> klient = (List<Klient>) getCurrentSession().createQuery("from Klient", Klient.class).list();

		return klient;

	}

	@Override
	public void deleteAll() {
		List<Klient> entityList = findAll();
		for (Klient entity : entityList) {
			delete(entity);
		}

	}

}
