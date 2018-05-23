package application;

import entities.DescriptionEntity;
import entities.DishDetailsEntity;
import entities.DishEntity;
import entities.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
//
//        DishDetailsEntity dishDetailsEntity = new DishDetailsEntity();
//        dishDetailsEntity.setAvailability(false);
//        dishDetailsEntity.setTax(8.0);
//
//
//        DishEntity dishEntity1 = entityManager.getReference(DishEntity.class, 1);
//
//        dishDetailsEntity.setIdDish(dishEntity1);
//        entityManager.persist(dishDetailsEntity);
//
//        entityManager.getTransaction().commit();
//
//        System.out.println(dishEntity1.getName());
//
//        for(int i = 0 ; i<dishEntity1.getDishDetailsEntity().size(); i++)
//        System.out.println(dishEntity1.getDishDetailsEntity().get(i).getAvailability());


//        DishEntity dishEntity = new DishEntity();
//        dishEntity.setName("Neapoli");
//        dishEntity.setKind(1);
//        entityManager.persist(dishEntity);
//
//
//
//        OrderEntity orderEntity = entityManager.getReference(OrderEntity.class, 2);
//        List<DishEntity> dishEntities = orderEntity.getIdDish();
//
//        dishEntities.add(dishEntity);
//
//        orderEntity.setIdDish(dishEntities);
//        entityManager.persist(orderEntity);
//


//        OrderEntity orderEntity = entityManager.getReference(OrderEntity.class, 2);
//        for(int i = 0; i < orderEntity.getIdDish().size(); i++)
//            System.out.println(orderEntity.getIdDish().get(i).getId());




      //  entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


    }
}
