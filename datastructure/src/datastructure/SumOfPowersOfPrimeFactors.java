package datastructure;

public class SumOfPowersOfPrimeFactors {
    public static void main(String[] args) {
        SumOfPowersOfPrimeFactors sumOfPowersOfPrimeFactors = new SumOfPowersOfPrimeFactors();
        System.out.println(sumOfPowersOfPrimeFactors.sumOfPowersOfPrimeFactors(24, 27));
    }

    private long sumOfPowersOfPrimeFactors(int a, int b) {
        long totalPoints = 0;

        for (int i = a; i <= b; i++) {
            totalPoints += sumOfPrimeFactorsPower(i);
        }

        return totalPoints;
    }
    private static long sumOfPrimeFactorsPower(int n) {
        long sum = 0;

        // Calculate powers of prime factors
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    n /= i;
                    count++;
                }
                sum += count;
            }
        }

        // If n is a prime number greater than 1
        if (n > 1) {
            sum++;
        }

        return sum;
    }
}
