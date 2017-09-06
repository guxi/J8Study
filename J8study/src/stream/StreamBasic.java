package stream;

import java.util.*;
import java.util.stream.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import static stream.Dish.menu;

public class StreamBasic {
	
//	 public static final List<Dish> menu =
//	            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
//	                           new Dish("beef", false, 700, Dish.Type.MEAT),
//	                           new Dish("chicken", false, 400, Dish.Type.MEAT),
//	                           new Dish("french fries", true, 530, Dish.Type.OTHER),
//	                           new Dish("rice", true, 350, Dish.Type.OTHER),
//	                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
//	                           new Dish("pizza", true, 550, Dish.Type.OTHER),
//	                           new Dish("prawns", false, 400, Dish.Type.FISH),
//	                           new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
