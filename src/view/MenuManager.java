package view;

import manager.ProductManager;
import model.Product;
import validate.ValidatorInput;

public class MenuManager {
    ProductManager productManager = new ProductManager();
    public void showMenu() {


        int choice;
        do {
            System.out.println("=====Chương Trình Quản Lý Sản Phẩm=====");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Sắp xếp");
            System.out.println("6.Tìm sản phẩm đắt nhất");
            System.out.println("0.Thoát ứng dụng");
            System.out.println("Hãy nhập lựa chọn của bạn:");
            choice = ValidatorInput.choice();
            switch (choice) {
                case 1:
                    showAllProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    menuArrangeProduct();
                    break;
                case 6:
                    getMaxPrice();
                    break;

                default:
                    System.out.println("Hãy nhập đúng số lựa chọn ở trên!");
            }
        } while (choice != 0);
    }

    public void updateProduct() {
        System.out.println("Hãy nhập Id của sản phẩm bạn cần sửa thông tin:");
        int idEdit = ValidatorInput.inputInt();
        if (productManager.findIndexById(idEdit) == -1) {
            System.out.println("Không tìm thấy sản phẩm có id " + idEdit);
        } else {
            System.out.println("Sửa thông tin của sản phẩm id " + idEdit);
            int id = ValidatorInput.InputId();
            String name = ValidatorInput.nameInput();
            int price = ValidatorInput.priceInput();
            int quantity = ValidatorInput.quantityInput();
            System.out.println("Nhập Mô Tả: ");
            String describe = ValidatorInput.inputString();
            productManager.update(idEdit, new Product(id, name,  price,quantity, describe));
            System.out.println("Bạn đã sửa thành công sản phẩm có id " + idEdit);
        }
    }


    public void deleteProduct() {
        System.out.println("Nhập id của sản phẩm cần xóa: ");
        int idDelete = ValidatorInput.inputInt();
        int index = productManager.findIndexById(idDelete);
        if (index != -1) {
            int choice;
            System.out.println("Bạn chắc chắn muốn xóa hay không?");
            System.out.println("1.Có.");
            System.out.println("2.Không.");
            System.out.println("--------------------------------");
            System.out.println("Hãy nhập lựa chọn của bạn:");
            choice = ValidatorInput.choice();
            switch (choice) {
                case 1:
                    productManager.delete(idDelete);
                    System.out.println("Bạn đã xóa thành công bài hát id " + idDelete);
                    break;
                case 2:
                    System.out.println("Danh sách sản phẩm vẫn giữ nguyên.");
                    break;
                default:
                    System.out.println("Bạn nhập sai lựa chọn ! Album của bạn vẫn giữ nguyên.");
            }
        } else {
            productManager.delete(idDelete);
            System.out.println("Không tìm thấy sản phẩm có id " + idDelete);
        }
    }

    public void addProduct() {
        System.out.println("===Thêm Sản Phẩm Mới===");
        int id = ValidatorInput.InputId();

        String name = ValidatorInput.nameInput();
        int price = ValidatorInput.priceInput();
        int quantity = ValidatorInput.quantityInput();
        System.out.println("Nhập Mô Tả Sản Phẩm Mới:");
        String describe = ValidatorInput.inputString();
        productManager.add(new Product(id, name,  price,quantity, describe));
        System.out.println("Bạn đã thêm thành công sản phẩm " + name + " vào kho.");
    }

    public void showAllProduct() {
        System.out.println("Tất cả sản phẩm trong kho là:");
        for (Product product : productManager.findAll()) {
            System.out.println(product);
        }
    }
    public void menuArrangeProduct(){
        int choice;
        do {
            System.out.println("====Sắp xếp theo giá=====");
            System.out.println("1.Từ Thấp đến cao.");
            System.out.println("2.Từ cao xuống thấp");
            System.out.println("0.Thoát.");
            System.out.println("Hãy nhập lựa chon của bạn");
            choice=ValidatorInput.choice();
            switch (choice){
                case 1:
                    System.out.println("Danh sách sản phẩm sắp xếp giá từ thấp đến cao là:");
                    productManager.arrangeLowToHigh();
                    break;
                case 2:
                    productManager.arrangeHighToLow();
                    System.out.println("Danh sách sản phẩm sắp xếp giá từ cao xuống thấp là:");
                    break;
                default:
                    System.out.println("Hãy nhập đúng số lựa chọn ở trên!");

            }
        }while (choice!=0);
    }
    public void getMaxPrice(){
        System.out.println("Product có giá cao nhất là:");
        for (Product product: productManager.getMaxPrice()) {
            System.out.println(product);
        }
    }
}