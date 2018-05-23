package application;

import application.model.EntityCore;
import application.model.FillDatabase;
import entities.DescriptionEntity;
import entities.DishDetailsEntity;
import entities.DishEntity;
import entities.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {



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

//
//        DishEntity dishEntity = new DishEntity();
//        dishEntity.setName("test");
//        dishEntity.setKind(1);
//        entityManager.persist(dishEntity);
//
//
////        OrderEntity orderEntity = new OrderEntity();
////        orderEntity.setStatus(1);
////        orderEntity.setKind(2);
//
//        OrderEntity orderEntity = entityManager.getReference(OrderEntity.class, 7);
//        List<DishEntity> dishEntities = new ArrayList<>();
//
//        dishEntities.add(dishEntity);
//
//        orderEntity.setDishEntities(dishEntities);
//        entityManager.persist(orderEntity);
//
//
//
////        OrderEntity orderEntity = entityManager.getReference(OrderEntity.class, 2);
////        for(int i = 0; i < orderEntity.getIdDish().size(); i++)
////            System.out.println(orderEntity.getIdDish().get(i).getId());
//
//
//
//
//        entityManager.getTransaction().commit();
//
        FillDatabase fillDatabase = new FillDatabase();
        fillDatabase.randDish();

//
//
//        EntityCore entityCore = new EntityCore();
//
//        DishEntity dishEntity = new DishEntity();
//        dishEntity.setName("Margarita");
//
//        DishDetailsEntity dishDetailsEntity = new DishDetailsEntity();
//        dishDetailsEntity.setAvailability(true);
//        dishDetailsEntity.setSizes(30.0);
//        dishDetailsEntity.setPrice(15.5);
//        dishDetailsEntity.setTax(8.0);
//        dishDetailsEntity.setDishEntity(dishEntity);
//        entityCore.start();
//        entityCore.getEntityManager().persist(dishDetailsEntity);
//        entityCore.getEntityManager().persist(dishEntity);
//        entityCore.commit();
//        entityCore.end();
//
//        EntityCore entityCore = new EntityCore();
//        entityCore.start();
//        entityCore.end();
//
//        for(int i = 0; i < 20; i ++) {
//
//            System.out.println(randDouble(16,35));
//        }



    }
//
//    private static Double randDouble(int min, int max){
//        Random random = new Random();
//        double roundOff = Math.round(min + (max - min) * random.nextDouble() * 100.0) / 100.0;
//        return roundOff;
//    }

}
