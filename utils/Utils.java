package utils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Utils {
    private static int counter = 1;

    public static String formatRupiah(double amount) {
        Locale indonesia = Locale.of("id", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(indonesia);
        formatRupiah.setCurrency(Currency.getInstance("IDR"));
        return formatRupiah.format(amount);
    }

    public static String generateID() {
        return "ID" + counter++; 
    }
}