package com.ragheb;

import com.ragheb.dao.CategoryDao;
import com.ragheb.dao.impl.CategoryDaoImpl;
import entity.Category;
import entity.Product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class Tester {
    public static void main(String[] args) throws IOException {

        CategoryDao dao = new CategoryDaoImpl();

        // save category
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Electronics");

        Product product = new Product();
        product.setId(22);
        product.setProductName("Mobile");

        File file = new File("D:\\images\\mobile.jpg");
        byte[] imageBytes = new byte[(int) file.length()];

        FileInputStream fis = new FileInputStream(file);
        fis.read(imageBytes);
        product.setProductImage(imageBytes);

        Product product1 = new Product();
        product1.setId(23);
        product1.setProductName("TV");

        File file1 = new File("D:\\images\\tv1.jpg");
        byte[] imageBytes_tv = new byte[(int) file.length()];

        FileInputStream fis1 = new FileInputStream(file1);
        fis1.read(imageBytes_tv);
        product1.setProductImage(imageBytes_tv);

        Product product2 = new Product();
        product2.setId(24);
        product2.setProductName("MicroOwen");

        File file2 = new File("D:\\images\\micro.jpg");
        byte[] imageBytes_micro = new byte[(int) file.length()];

        FileInputStream fis2 = new FileInputStream(file2);
        fis2.read(imageBytes_micro);
        product2.setProductImage(imageBytes_micro);

        List<Product> productList = Arrays.asList(product, product1, product2);
        category.setProducts(productList);
        dao.saveCategory(category);

        // fetch category
        Category fetchCategory = dao.fetchCategory(23);
        System.out.println("Fetched category: " + fetchCategory.getCategoryName());
        System.out.println("Contains products: " + fetchCategory.getProducts().size());
        // Verify products
        for (Product p : fetchCategory.getProducts()) {
            System.out.println(" - Product: " + p.getProductName() +
                    " (Image size: " + (p.getProductImage() != null ? p.getProductImage().length : 0) + " bytes)");
        }

        // Verify deletion
        int categoryId = 24;
        dao.removeCategory(categoryId);
    }
}
