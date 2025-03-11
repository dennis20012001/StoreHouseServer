package storeHouse.Controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.Hibernate.utils.HibernateUtil;
import storeHouse.Objects.Users;

@RestController
@RequestMapping("/api")
public class UsersController {

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        List<Users> usersList = null;
        String hql = "from users";
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query<Users> query = session.createQuery(hql, Users.class);
            usersList = query.list();
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

        return usersList;
    }
}
