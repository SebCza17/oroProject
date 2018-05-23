package application.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityCore {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EntityCore() {
        try {
            this.entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            this.entityManager = entityManagerFactory.createEntityManager();
        }catch (Exception e){
            System.out.println("Nie udało się połączyć" + e);
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
