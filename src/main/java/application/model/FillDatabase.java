package application.model;

import entities.DescriptionEntity;
import entities.DishEntity;

import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.round;


public class FillDatabase {

    private String[] dishName = {"Margerita", "Prosciutto", "Prataiolo", "Salame", "Cacciatore", "Spinace", "Capri", "Giulia", "Romeo", "Verona",
            "Romana", "Livorno", "Novara", "Capricciosa", "Cosa nostra", "Vegetariana", "Vegetariana", "Etiva", "Serowa", "Pollo",
            "Pompea", "Vetresca", "Primavera", "Piacenza", "Specjale", "Frutti Di Mare", "Quatro-Stragoni"};

    private String[] dishDescription = {"Pieczarki", "Kukurydza", "Groszek", "Cebula", "Ananas", "Szparagi", "Oliwki", "Ogórek", "Papryka", "Jalapeno",
            "Brokuły", "Szynka", "Salami", "Kurczak", "Wołowina", "Bekon", "Łosoś", "Tuńczyk", "Mozzarella", "Ser Pleśniowy", "Camember",
            "Sos pomidorowy", "Musztarda", "Jajka"};

    private Integer randInt(int i){
        Random random = new Random();
        return random.nextInt(i);
    }

    private Double randDouble(int i){
        Random random = new Random();
        return round(random.nextDouble()*i, 2);
    }

    private DescriptionEntity randDishDescription(){
        StringBuilder desc = new StringBuilder();

        DescriptionEntity descriptionEntity = new DescriptionEntity();

        int hMuch = randInt(7);

        for (int i = 0; i < hMuch; i++) {
            int idx = randInt(dishDescription.length);
            desc.append(dishDescription[idx]);
        }

        descriptionEntity.setDescription(desc.toString());

        return descriptionEntity;
    }

    public DishEntity randDish(){

        DishEntity dishEntity = new DishEntity();
        DescriptionEntity descriptionEntity = new DescriptionEntity();



        return dishEntity;
    }
}
