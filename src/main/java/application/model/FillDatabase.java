package application.model;

import entities.DescriptionEntity;
import entities.DishDetailsEntity;
import entities.DishEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class FillDatabase {

    private String[] dishName = {"Margerita", "Prosciutto", "Prataiolo", "Salame", "Cacciatore", "Spinace", "Capri", "Giulia", "Romeo", "Verona",
            "Romana", "Livorno", "Novara", "Capricciosa", "Cosa nostra", "Vegetariana", "Vegetariana", "Etiva", "Serowa", "Pollo",
            "Pompea", "Vetresca", "Primavera", "Piacenza", "Specjale", "Frutti Di Mare", "Quatro-Stragoni"};

    private String[] dishDescription = {"Pieczarki", "Kukurydza", "Groszek", "Cebula", "Ananas", "Szparagi", "Oliwki", "Ogórek", "Papryka", "Jalapeno",
            "Brokuły", "Szynka", "Salami", "Kurczak", "Wołowina", "Bekon", "Łosoś", "Tuńczyk", "Mozzarella", "Ser Pleśniowy", "Camember",
            "Sos pomidorowy", "Musztarda", "Jajka"};

    private Double[] dishSize = {26.0, 35.0, 42.0, 55.0};

    private Integer randInt(int min, int max){
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private Double randDouble(int min, int max){
        Random random = new Random();
        double roundOff = Math.round(min + (max - min) * random.nextDouble() * 100.0) / 100.0;
        return roundOff;
    }

    private Boolean randBoolean(){
        return Math.random() < 0.8;
    }

    private DescriptionEntity randDishDescription(){
        StringBuilder desc = new StringBuilder();
        desc.append("ser");

        DescriptionEntity descriptionEntity = new DescriptionEntity();

        int hMuch = randInt(1, 7);
        for (int i = 0; i < hMuch; i++) {
            int idx = randInt(0 ,dishDescription.length - 1);
            desc.append(", ").append(dishDescription[idx]);
        }

        descriptionEntity.setDescription(desc.toString());


        EntityCore entityCore = new EntityCore();
        entityCore.start();

        entityCore.getEntityManager().persist(descriptionEntity);
        entityCore.commit();
        entityCore.end();


        return descriptionEntity;
    }

    private List<DishDetailsEntity> randDishDetails(DishEntity dishEntity, EntityCore entityCore){
        List<DishDetailsEntity> dishDetailsEntities = new ArrayList<>();

        for (Double aDishSize : dishSize) {
            DishDetailsEntity dishDetailsEntity = new DishDetailsEntity();
            dishDetailsEntity.setAvailability(randBoolean());
            dishDetailsEntity.setPrice(randDouble(16, 35));
            dishDetailsEntity.setSizes(aDishSize);
            dishDetailsEntity.setTax(8.0);
            dishDetailsEntity.setDishEntity(dishEntity);
            entityCore.getEntityManager().persist(dishDetailsEntity);

            dishDetailsEntities.add(dishDetailsEntity);

        }

        return dishDetailsEntities;
    }

    public void randDish(){
        DescriptionEntity descriptionEntity = new DescriptionEntity();
        EntityCore entityCore = new EntityCore();

        entityCore.start();

        for (String aDishName : dishName) {
            DishEntity dishEntity = new DishEntity();
            dishEntity.setKind(1);
            dishEntity.setName(aDishName);
            dishEntity.setDescriptionEntity(randDishDescription());
            entityCore.getEntityManager().persist(dishEntity);

            randDishDetails(dishEntity, entityCore);

        }
        entityCore.commit();
        entityCore.end();
    }
}
