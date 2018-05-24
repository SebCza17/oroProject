package application;



import application.model.EntityCore;
import application.model.FillDishDatabase;
import application.model.FillDrinkDatabase;
import application.model.FillOrderDatabase;
import entities.DescriptionEntity;
import entities.OrderEntity;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Scanner odczyt = new Scanner(System.in);

    public static void main(String[] args)  {

        int which = 0;

        while(which != 9){
            switch (which){
                case 0:
                    showMenu();
                    break;
                case 1:
                    FillDishDatabase fillDishDatabase = new FillDishDatabase();
                    fillDishDatabase.randDish();
                    break;
                case 2:
                    FillDrinkDatabase fillDrinkDatabase = new FillDrinkDatabase();
                    fillDrinkDatabase.randDrink();
                    showMenu();
                    break;
                case 3:
                    FillOrderDatabase fillOrderDatabase = new FillOrderDatabase();
                    System.out.println("\nPodaj ile chcesz wprowadzic zamowien");
                    int n = odczyt.nextInt();
                    fillOrderDatabase.makeOrder(n);
                    showMenu();
                    break;
                case 4:
                    selectOrder();
                    showMenu();
                    break;
                case 5:
                    selectOrderWhere();
                    showMenu();
                    break;
                case 6:
                    EntityCore entityCore = new EntityCore();
                    entityCore.start();
                    entityCore.end();
                    break;
                default:
                    break;
            }
            which = odczyt.nextInt();
        }

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

//        FillDishDatabase fillDishDatabase = new FillDishDatabase();
//        fillDishDatabase.randDish();

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

//        for(int i = 0; i < 20; i ++) {
//
//            System.out.println(randDouble(16,35));
//        }
//        FillDrinkDatabase fillDrinkDatabase = new FillDrinkDatabase();
//        fillDrinkDatabase.randDrink();


//        EntityCore entityCore = new EntityCore();
//        Query query =  entityCore.getEntityManager().createQuery("from DishEntity");
//        List<DishEntity> dishEntities = query.getResultList();
//
//        for(int i = 0; i < dishEntities.size() - 1; i++)
//            System.out.println(dishEntities.get(i).getId());

//
//        OrderEntity orderEntity = new OrderEntity();
//        EntityCore entityCore = new EntityCore();
//        orderEntity.setStartDatetime(new Date());
//        entityCore.start();
//       // entityCore.getEntityManager().persist(orderEntity);
//        entityCore.end();
    }

    private static void showMenu(){
        System.out.println("Menu: ");
        System.out.println("0 - Menu: ");
        System.out.println("1 - Wypełnij baze daniami");
        System.out.println("2 - Wypełnij baze napojami");
        System.out.println("3 - Wypełnij baze zamówieniami");
        System.out.println("4 - Select All from Order");
        System.out.println("5 - Select WHERE from Order");
        System.out.println("9 - Zakończ Program");
        System.out.print("\n\nPodaj Cyfre: ");
    }

    private static void selectOrder(){
        EntityCore entityCore = new EntityCore();
        Query query = entityCore.getEntityManager().createQuery("from OrderEntity ");
        List<OrderEntity> orderEntities = query.getResultList();

        entityCore.start();
        int i = 0;
        while(i < orderEntities.size() - 1) {
        int j = i + 10;
            for (; i < j && i < orderEntities.size() - 1; i++) {
                System.out.println(orderEntities.get(i).toString());
            }
            System.out.println("1 - dalej");
            if (odczyt.nextInt() != 1) i = orderEntities.size();



        }
        entityCore.end();
    }

    private static void selectOrderWhere(){
        EntityCore entityCore = new EntityCore();
        entityCore.start();

        System.out.println("Podaj id referencji do pobrania");
        int idx = odczyt.nextInt();
        OrderEntity orderEntity = entityCore.getEntityManager().getReference(OrderEntity.class,idx);
        System.out.println(orderEntity.toString());
        System.out.println(orderEntity.getDescriptionEntity().getDescription());
        for(int i = 0; i < orderEntity.getDishEntities().size() - 1; i++)
            System.out.print(", "+ orderEntity.getDishEntities().get(i).getName());

        System.out.println("\n\n");
        for(int i = 0; i < orderEntity.getDrinkEntities().size() - 1; i++)
            System.out.print(", "+ orderEntity.getDrinkEntities().get(i).getName());

        entityCore.end();
    }

//
//    private static Double randDouble(int min, int max){
//        Random random = new Random();
//        double roundOff = Math.round(min + (max - min) * random.nextDouble() * 100.0) / 100.0;
//        return roundOff;
//    }

}
