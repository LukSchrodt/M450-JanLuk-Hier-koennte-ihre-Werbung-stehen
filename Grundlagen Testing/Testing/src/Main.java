public class Main {

    public static void main(String[] args) {
        double basePrice = 100.0;
        double specialPrice = 50.0;
        double extraPrice = 20.0;
        int extras = 8;
        double discount = 0;

        double totalPrice = calculatePrice(basePrice, specialPrice, extraPrice, extras, discount);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("extra: " + extras);

        // Call the test method
        boolean testResult = testCalculatePrice(basePrice, specialPrice, extraPrice, extras, discount);
        if (testResult) {
            System.out.println("calculatePrice test passed.");
        } else {
            System.out.println("calculatePrice test failed.");
        }
    }

    public static double calculatePrice(double basePrice, double specialPrice, double extraPrice, int extras, double discount) {
        double addonDiscount = 0;

        if (extras >= 3) {
            System.out.println("discount: " + 10);
            addonDiscount = 10;
        } else if (extras >= 5) {
            System.out.println("discount: " + 15);
            addonDiscount = 15;
        }

        if (discount > addonDiscount) {
            addonDiscount = discount;
        }

        double totalPrice = (basePrice / 100.0 * (100 - addonDiscount)) + specialPrice + (extraPrice / 100.0 * (100 - addonDiscount));
        return totalPrice;
    }

    // Test method
    public static boolean testCalculatePrice(double basePrice, double specialPrice,double extraPrice,int extras,double discount) {
        double expectedPrice = 152.0;  // Replace with the expected total price for the given inputs
        double calculatedPrice = calculatePrice(basePrice, specialPrice, extraPrice, extras, discount);

        // Compare the expected price with the calculated price and return the result
        return Math.abs(expectedPrice - calculatedPrice) < 1e-6;
    }
}