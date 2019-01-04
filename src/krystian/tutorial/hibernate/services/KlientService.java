package krystian.tutorial.hibernate.services;

import java.util.List;

import krystian.tutorial.hibernate.dao.KlientsDAO;
import krystian.tutorial.hibernate.encje.Klient;

public class KlientService {


		private static KlientsDAO klientDao;

		public KlientService() {

			klientDao = new KlientsDAO();

		}

		public void persist(Klient entity) {

			klientDao.openCurrentSessionwithTransaction();

			klientDao.persist(entity);

			klientDao.closeCurrentSessionwithTransaction();

		}

		public void update(Klient entity) {

			klientDao.openCurrentSessionwithTransaction();

			klientDao.update(entity);

			klientDao.closeCurrentSessionwithTransaction();

		}

		public Klient findById(String id) {

			klientDao.openCurrentSession();

			Klient klient = klientDao.findById(id);

			klientDao.closeCurrentSession();

			return klient;

		}

		public void delete(String id) {

			klientDao.openCurrentSessionwithTransaction();

			Klient book = klientDao.findById(id);

			klientDao.delete(book);

			klientDao.closeCurrentSessionwithTransaction();

		}

		public List<Klient> findAll() {

			klientDao.openCurrentSession();

			List<Klient> listaKlientow = klientDao.findAll();

			klientDao.closeCurrentSession();

			return listaKlientow;

		}

		public void deleteAll() {

			klientDao.openCurrentSessionwithTransaction();
			klientDao.deleteAll();
			klientDao.closeCurrentSessionwithTransaction();

		}

		public KlientsDAO klientDao() {

			return klientDao;

		}

	}


