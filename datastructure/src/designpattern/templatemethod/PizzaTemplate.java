package designpattern.templatemethod;

/**
 * Creating an abstract for Pizza template
 */

public abstract class PizzaTemplate {
    // This method is same for all types of pizzaa which includes all other steps for making pizza
    public void preparePizza(){
        selectBread();
        addIngredients();
        cooking();
        addingCheese();
    }

    public void cooking(){
        System.out.println("Cooking Pizza");
    }
    public void addingCheese(){
        System.out.println("Adding Cheese ");
    }
    //diiferent step for different types of Pizza
    protected abstract void selectBread();
    protected abstract void addIngredients();
}
