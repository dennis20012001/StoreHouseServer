package storeHouse.base.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import storeHouse.base.entities.DetailsSale;
import storeHouse.base.entities.Invoice;
import storeHouse.base.entities.Product;
import storeHouse.base.entities.ProductInvoice;
import storeHouse.base.entities.Sale;
import storeHouse.base.entities.User;

public class HibernateUtil {

	private static SessionFactory factory;

	static {
		// Configurar la SessionFactory - Hay que agregar todas las entidades para que hibernate funcione
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Invoice.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Sale.class)
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(DetailsSale.class)
				.addAnnotatedClass(ProductInvoice.class)
				.buildSessionFactory();
	}

	public static Session getSession() {
		return factory.getCurrentSession();
	}

	public static void close() {
		factory.close();
	}
}