package manager;

import model.Product;
import readAndWriteFile.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements iManager<Product> {
    private List<Product> productList;
    private ReadAndWrite readAndWriteFile;

    public  ProductManager() {
        readAndWriteFile = new ReadAndWrite();
        productList = readAndWriteFile.readListProduct();
    }

    @Override
    public void add(Product product) {
        productList.add(product);
        readAndWriteFile.writeListProduct(productList);
    }

    @Override
    public boolean update(int id, Product product) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        }
        productList.set(index, product);
        readAndWriteFile.writeListProduct(productList);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        } else {
            productList.remove(index);
            readAndWriteFile.writeListProduct(productList);
        }
        return true;

    }

    @Override
    public List<Product> findAll() {
        readAndWriteFile.readListProduct();
        return productList;
    }

    @Override
    public List<Product> searchByHighPrice() {
        List<Product> productsHighPrice = new ArrayList<>();
        double max = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() > max) {
                max = productList.get(i).getPrice();
            }
        }
        for (Product product : productList) {
            if (product.getPrice() == max) {
                productsHighPrice.add(product);
            }
        }
        return productsHighPrice;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

        public void arrangeLowToHigh(){
            for (int i = 1; i < productList.size(); i++) {
                for (int j = 0; j < productList.size() - i; j++) {
                    if (productList.get(j).getPrice() > productList.get(j + 1).getPrice()) {
                        Product temp = productList.get(j);
                        productList.set(j, productList.get(j + 1));
                        productList.set(j + 1, temp);
                    }
                }
            }
            for (Product product : productList) {
                System.out.println(product);
            }
    }
    public void arrangeHighToLow() {
        for (int i = 1; i < productList.size(); i++) {
            for (int j = 0; j < productList.size() - i; j++) {
                if (productList.get(j).getPrice() < productList.get(j + 1).getPrice()) {
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
        for (Product product : productList
        ) {
            System.out.println(product);
        }
    }
    public List<Product> getMaxPrice(){
        List<Product> maxPrice=new ArrayList<>();
        double maxPrice1=productList.get(0).getPrice();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice()>maxPrice1){
                maxPrice1=productList.get(i).getPrice();
            }
        }
        for (Product product:productList) {
            if (product.getPrice()==maxPrice1){
                maxPrice.add(product);
            }
        }
       return maxPrice;
    }


}
