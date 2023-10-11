package readAndWriteFile;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    File fileProduct=new File("data/listProduct.csv");
    public void writeListProduct(List<Product> productList){
        try{
            FileWriter fileWriter=new FileWriter(fileProduct);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            String line="";
            for (Product product:productList) {
                line+=product.getId()+","+ product.getName()+ ","+ product.getQuantity()+","+product.getPrice()+","+product.getDescribe()+"\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public List<Product> readListProduct(){
        List<Product> productList=new ArrayList<>();
        try {
            FileReader fileReader=new FileReader(fileProduct);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line=null;
            while ((line= bufferedReader.readLine())!=null){
                String[] string=line.split(",");
                Product product=new Product(Integer.parseInt(string[0]), string[1],Integer.parseInt(string[2]),Integer.parseInt(string[3]),string[4]);
                productList.add(product);
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return productList;
    }
}
