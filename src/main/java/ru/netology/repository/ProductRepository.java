package ru.netology.repository;


import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    //добавить
    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    //показать все
    public Product[] findAll() {

        return this.products;
    }

    //удалить по id
    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
