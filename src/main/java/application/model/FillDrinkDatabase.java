package application.model;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FillDrinkDatabase extends RandValue {
    private String[] drinkName = {"Coca-Cola", "Pepsi", "Mirinda", "Sprite", "Cisowianka", "Capi", "Tymbark", "Lipton", "Minutka", "Earl Grey",
            "Czarna", "Gorąca Czekolada", "Espresso", "Cappuccino", "Tyskie", "Warka", "Harnaś", "Miodne", "Rżnięte", "Koźlak",
    "Pan Tadeusz", "Sierra", "Cymes", "Krajowa"};

    private String[] drinkDescription = {"Opcja w temp. Pokojowej", "Opcja Zimna", "Opcja Ciepła"};

    private Double[] drinkSize = {0.25, 0.33, 0.5, 0.75, 1.0, 1.5, 2.0};

    private DescriptionEntity randDrinkDescription(){
        StringBuilder desc = new StringBuilder();
        desc.append("");

        DescriptionEntity descriptionEntity = new DescriptionEntity();

        int hMuch = randInt(1, 3);
        for (int i = 0; i < hMuch; i++) {
            desc.append(", ").append(drinkDescription[i]);
        }

        descriptionEntity.setDescription(desc.toString());


        EntityCore entityCore = new EntityCore();
        entityCore.start();

        entityCore.getEntityManager().persist(descriptionEntity);

        entityCore.end();


        return descriptionEntity;
    }

    private List<DrinkDetailsEntity> randDrinkDetails(DrinkEntity drinkEntity, EntityCore entityCore){
        List<DrinkDetailsEntity> drinkDetailsEntities = new ArrayList<>();

        for (Double aDishSize : drinkSize) {
            DrinkDetailsEntity drinkDetailsEntity = new DrinkDetailsEntity();
            drinkDetailsEntity.setAvailability(randBoolean(0.2f));
            drinkDetailsEntity.setPrice(randDouble(5, 50));
            drinkDetailsEntity.setSizes(aDishSize);
            drinkDetailsEntity.setTax(26.0);
            drinkDetailsEntity.setDrinkEntity(drinkEntity);
            entityCore.getEntityManager().persist(drinkDetailsEntity);

            drinkDetailsEntities.add(drinkDetailsEntity);

        }

        return drinkDetailsEntities;
    }

    public void randDrink(){
        EntityCore entityCore = new EntityCore();

        entityCore.start();

        for (String aDrinkName : drinkName) {
            DrinkEntity drinkEntity = new DrinkEntity();
            drinkEntity.setAdults(randBoolean(0.5f));
            drinkEntity.setKind(1);
            drinkEntity.setName(aDrinkName);
            drinkEntity.setDescriptionEntity(randDrinkDescription());
            entityCore.getEntityManager().persist(drinkEntity);

            randDrinkDetails(drinkEntity, entityCore);
        }

        entityCore.end();
    }
}
