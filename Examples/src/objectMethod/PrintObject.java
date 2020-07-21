package objectMethod;

/**
 * @author Nina
 * DateTime 2020/7/21 15:15
 * Description method:toString
 */
public class PrintObject {
    public static void main(String[] args) {
        Apple apple = new Apple(16.5, "红色");
        System.out.println(apple);
        System.out.println(apple.equals(null));
    }

}

class Apple {
    private double weight;
    private String color;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Apple(double weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple[weight=" + weight + ", color=" + color + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == Apple.class) {
            Apple appleObj = (Apple) obj;
            if (this.getColor() == appleObj.getColor() && this.getWeight() == appleObj.getWeight())
                return true;
        }
        return false;
    }
}