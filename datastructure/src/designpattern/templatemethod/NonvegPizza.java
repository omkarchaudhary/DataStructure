package designpattern.templatemethod;

public class NonvegPizza extends PizzaTemplate{
    @Override
    protected void selectBread() {
        System.out.println("select bread for Non-veg Pizza");
    }

    @Override
    protected void addIngredients() {
        System.out.println("select ingredients for non-veg pizza");
    }
}
