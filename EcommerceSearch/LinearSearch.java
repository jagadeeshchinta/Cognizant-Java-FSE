package EcommerceSearch;

public class LinearSearch {

    public static Product search(Product[] products, int productId) {

        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }

        return null;
    }
}