import java.util.*;

public class TaxCalculator {

    public static class Tax {
        double base, rate;
        public Tax(double base, double rate) {
            this.base = base;
            this.rate = rate;
        }
    }

    public double calculate(Tax[] taxs, double money) {
        Arrays.sort(taxs, new Comparator<Tax>(){
            public int compare(Tax a, Tax b) {
                if (a.base < b.base) return -1;
                else if (a.base == b.base) return 0;
                else return 1;
            }
        });
        double pay = 0;
        for (int i = 0; i < taxs.length; i ++) {
            if (i < taxs.length - 1 && money >= taxs[i + 1].base)
                pay += (taxs[i + 1].base - taxs[i].base) * taxs[i].rate;
            else {
                pay += (money - taxs[i].base) * taxs[i].rate;
                break;
            }
        }
        return pay;
    }

    public static void main(String[] args) {
        TaxCalculator sol = new TaxCalculator();
        Tax[] taxs = new Tax[4];
        taxs[0] = new Tax(10000, 0.1);
        taxs[1] = new Tax(8000, 0.2);
        taxs[2] = new Tax(6000, 0.3);
        taxs[3] = new Tax(0, 0.4);
        System.out.println(sol.calculate(taxs, 4000));
    }
}