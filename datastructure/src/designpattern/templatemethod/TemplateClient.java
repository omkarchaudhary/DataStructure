package designpattern.templatemethod;

public class TemplateClient {
    public static void main(String[] args) {
        System.out.println("Template design pattern");
        /* Template Design pattern
        * This provides the skeleton of an algorithm and define the common method in parent class and let concrete steps are implemented by child class
        * for example, preparing Pizza where selecting bread, adding ingredient will be different based on Pizza types but cooking, adding cheese is common to all types of pizza
        * */
        System.out.println("-----------Veg Pizza-------------");
        PizzaTemplate vegPizza = new VegPizza();
        vegPizza.preparePizza();

        System.out.println("------------Non-Veg Pizza-----------");
        PizzaTemplate nonVegPizza = new VegPizza();
        nonVegPizza.preparePizza();
    }
}
