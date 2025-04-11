package storeHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerMain {

	public static void main(String[] args) {
		SpringApplication.run(ServerMain.class, args);
		
		/*
		// Crear una nueva instancia de Invoice
        User user = new User();
        user.setUserId(1L);

        Invoice invoice = new Invoice();
        invoice.setUserId(user);
        invoice.setCIF("A11122233");
        invoice.setDate(new Date());
        invoice.setTotal(new BigDecimal("101.50"));
        invoice.setPaid(true);

        // Obtener la sesión de Hibernate y empezar la transacción
        Session session = HibernateUtil.getSession();
        try {
            // Comenzar la transacción para todo el bloque de operaciones
            session.beginTransaction();

            // Guardar la factura
            session.persist(invoice);
            System.out.println("Factura guardada correctamente.");

            // Eliminar la factura
            session.remove(invoice);
            System.out.println("Factura eliminada correctamente.");

            // Guardar de nuevo la factura
            session.persist(invoice);

            // Editar la factura
            invoice.setTotal(new BigDecimal("131.00"));
            session.merge(invoice);
            System.out.println("Factura editada correctamente.");

            // Recuperar todas las facturas y mostrarlas
            Query<Invoice> query = session.createQuery("FROM Invoice", Invoice.class);
            List<Invoice> invoices = query.getResultList();
            for (Invoice inv : invoices) {
                System.out.println("Factura: " + inv);
            }
            

            // Confirmar la transacción después de todas las operaciones
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback(); // Si ocurre un error, revertir
            }
            e.printStackTrace();
        } finally {
            // Cerrar la sesión después de todo el proceso
            session.close();
            HibernateUtil.close();
        }
        */
    }
}

