package datastructure;

public class ProductSumDiff {
    public static void main(String[] args) {
        System.out.println(getProductSumDiff(123456));
        //System.out.println(1.0/0.0);
    }

    public static int getProductSumDiff(int num){
        int sum = 0;
        int product = 1;
        while(num>0){
            int temp = num % 10;
            sum = sum + temp;
            product = product * temp;
            num = num/10;
        }
        return product-sum;
    }
}
