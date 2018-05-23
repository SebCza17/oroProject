package application.model;

import entities.DescriptionEntity;
import entities.DishEntity;
import entities.DrinkEntity;
import entities.OrderEntity;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FillOrderDatabase extends RandValue{

    private String[] orderDescription = {"Margarita bez sera", "Bez Oliwek", "Bez Cebuli", "Napój Na Gorąco", "Pilne", "Co Zostanie", "Struga 58",
    "Kopernika wejscie od Pogonowskiego", "4 pietro mieszkania 22", "Karolweska 12", "Sala konferencyjna E8 WEEIA"};


    private DescriptionEntity randOrderDescription(){
        StringBuilder desc = new StringBuilder();
        desc.append("Uwagi: ");

        DescriptionEntity descriptionEntity = new DescriptionEntity();

        int hMuch = randInt(1, 3);
        for (int i = 0; i < hMuch; i++) {
            int idx = randInt(0 ,orderDescription.length - 1);
            desc.append(", ").append(orderDescription[idx]);
        }

        descriptionEntity.setDescription(desc.toString());


        EntityCore entityCore = new EntityCore();
        entityCore.start();

        entityCore.getEntityManager().persist(descriptionEntity);

        entityCore.end();


        return descriptionEntity;
    }

    private List<DishEntity> chosenDish(EntityCore entityCore){
        List<DishEntity> dishEntities;
        List<DishEntity> dishEntities1 = new ArrayList<>();

        Query query = entityCore.getEntityManager().createQuery("from DishEntity ");
        dishEntities = query.getResultList();

        int idx = randInt(1, 6);
        for(int i = 0; i < idx; i++) {
            dishEntities1.add(dishEntities.get(randInt(0, dishEntities.size() - 1)));
        }

        return dishEntities1;
    }

    private List<DrinkEntity> chosenDrink(EntityCore entityCore){
        List<DrinkEntity> drinkEntities;
        List<DrinkEntity> drinkEntities1 = new ArrayList<>();


        Query query = entityCore.getEntityManager().createQuery("from DrinkEntity ");
        drinkEntities = query.getResultList();

        int idx = randInt(1, 6);
        for(int i = 0; i < idx; i++) {
            drinkEntities1.add(drinkEntities.get(randInt(0, drinkEntities.size() - 1)));
        }

        return drinkEntities1;
    }

    public void makeOrder(int max) {
        EntityCore entityCore = new EntityCore();

        entityCore.start();

        for (int i = 0; i < max; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setKind(randInt(1, 3));
            orderEntity.setStatus(3);
            orderEntity.setStartDatetime(new Date());
            orderEntity.setEndDatetime(new Date());
            orderEntity.setDescriptionEntity(randOrderDescription());
            orderEntity.setDishEntities(chosenDish(entityCore));
            orderEntity.setDrinkEntities(chosenDrink(entityCore));

            entityCore.getEntityManager().persist(orderEntity);
        }

        entityCore.end();
    }


}
