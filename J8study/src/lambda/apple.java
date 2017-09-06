package lambda;

import java.util.Arrays;
import java.util.List;

import stream.Dish;

public class apple {
	 private int weight = 0;
    private String color = "";

    public  apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
               "color='" + color + '\'' +
               ", weight=" + weight +
               '}';
    }    
    public enum Type { Weight, Color, country,OTHER }
    
    public static final List<apple> menu = Arrays.asList( 
    				new apple(80,"green"),
                    new apple(155, "green"),
                    new apple(120, "red"));
}