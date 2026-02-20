import java.util.Map;

public class MonedasDeCambio {

    Map<String, Double> conversion_rates;

    public double getTasa(String moneda){
        return conversion_rates.get(moneda);
    }
}
