package storeHouse.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import storeHouse.Hibernate.utils.HibernateUtil;
import storeHouse.Objects.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        List<Product> ret = null;
        String hql = "FROM Products"; 
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query<Product> query = session.createQuery(hql, Product.class);
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
