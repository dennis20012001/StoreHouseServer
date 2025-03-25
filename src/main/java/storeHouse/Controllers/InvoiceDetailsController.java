package storeHouse.Controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.Hibernate.utils.HibernateUtil;
import storeHouse.Objects.ProductInvoice;

	@RestController
	public class InvoiceDetailsController {
		@SuppressWarnings("deprecation")
		public List<ProductInvoice> getAllInvoicesDetails() {
			List<ProductInvoice> ret = null;
			String hql = "from InvoiceDetails";
			Session session = null;
			Transaction transaction = null;

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				Query query = session.createQuery(hql);
				ret = query.list();

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				System.out.println("Error: " + e.getMessage());
			} finally {
				if (session != null) {
					session.close();
				}
			}

			return ret;
		}
}
