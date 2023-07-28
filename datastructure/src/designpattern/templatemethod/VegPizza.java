package designpattern.templatemethod;

public class VegPizza extends PizzaTemplate {
    @Override
    protected void selectBread() {
        System.out.println("select bread for Veg Pizza");
    }

    @Override
    protected void addIngredients() {
        System.out.println("select ingredients for Veg pizza");
    }
}
