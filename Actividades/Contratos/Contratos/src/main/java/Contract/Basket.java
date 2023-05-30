package Contract;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Basket {
    private BigDecimal totalValue = BigDecimal.ZERO;
    private Map<Product, Integer> basket = new HashMap< >();

    /**
     * @param product: A product that is sell in the online store.
     * @param qtyToAdd: Quantity of products of the same type that the user wants buy.
     *
     * @pre
     *  product != null,
     *  qtyToAdd > 0
     * @post
     *  product is in basket,
     *  basket[product] >= qtyToAdd,
     *  (new) totalValue > (old) totalValue
     */
    public void add(Product product, int qtyToAdd) {
        assert product != null : "El producto no puede ser nulo.";
        assert qtyToAdd > 0 : "Se debe añadir al menos un producto.";
        BigDecimal oldTotalValue = totalValue;

        // Method implementation
        assert basket.containsKey(product) : "El producto debe estar en el carrito.";
        assert totalValue.compareTo(oldTotalValue) == 1 :
                "El nuevo valor total debe ser mayor al que se tenía " +
                        "antes de ejecutar este método.";
        assert totalValue.compareTo(BigDecimal.ZERO) >= 0 :
                "El valor total no puede ser negativo.";
    }

    /**
     * @param product: A product that is sell in the online store.
     * @pre
     * product != null,
     * product is in basket
     * @post
     * product is not in basket,
     * (new) totalValue <= (old) totalValue
     */
    public void remove(Product product) {
        assert product != null : "El producto no puede ser nulo.";
        assert basket.containsKey(product) : "El producto debe estar previamente en el carrito.";

        // Method implementation

        assert !basket.containsKey(product) : "El producto ya no debe estar en el carrito.";
        assert totalValue.compareTo(BigDecimal.ZERO) >= 0 :
                "El valor total no puede ser negativo.";
    }
    private boolean invariant() {
        return totalValue.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public int quantityOf(Product product) {
        assert basket.containsKey(product);
        return basket.get(product);
    }

    public Set<Product> products() {
        return Collections.unmodifiableSet(basket.keySet());
    }
    @Override
    public String toString() {
        return "BasketCase{" +
                "totalValue=" + totalValue +
                ", basket=" + basket +
                '}';
    }
}
