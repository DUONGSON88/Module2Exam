package validate;

import java.util.Scanner;

public class ValidatorInput {
    public static Scanner input = new Scanner(System.in);

    public static int inputInt() {
        int number;
        do {
            try {
                number = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Bạn nhập sai định dạng! Hãy nhập lại :");
            }
        } while (true);
        return number;
    }

    public static String inputString() {
        return input.nextLine();
    }

    public static int choice() {
        int choice;
        do {
            try {
                choice = Integer.parseInt(ValidatorInput.inputString());
                break;
            } catch (Exception e) {
                System.out.println("Bạn hãy nhập đúng số!");
            }
        } while (true);
        return choice;
    }

    public static int InputId() {
        String regexId = "\\d{3,}";
        String id;
        do {
            System.out.println("Nhập Id: ");
            id = ValidatorInput.inputString();
            if (id.matches(regexId)) {
                break;
            }else {
                System.out.println("Hãy nhập Id là số có 3 chữ số trở lên!");
            }
        } while (true);
        return Integer.parseInt(id);
    }

    public static String nameInput() {
        String regexName = "^.{6,8}$";
        String name;
        do {
            System.out.println("Nhập tên sản phẩm: ");
            name = ValidatorInput.inputString();
            if (name.matches(regexName)) {
                break;
            }else{
                System.out.println("Hãy nhập tên sản phẩm phải có 6-8 kí tự!");
            }

        } while (true);
        return name;
    }

    public static int priceInput() {
        String regexPrice = "^(?!0$)([1-9]\\d{0,2}|1000)$";
        String price;
        do {
            System.out.println("Nhập giá sản phẩm: ");
            price = ValidatorInput.inputString();
            if (price.matches(regexPrice)) {
                break;
            } else {
                System.out.println("Không nhập giá cao hơn 1000");
            }
        } while (true);
        return Integer.parseInt(price);
    }

    public static int quantityInput() {
        String regexQuantity = "^(?!0$)([1-9]\\d{0,2}|100)$";
        String quantity;
        do {
            System.out.println("Nhập số lượng sản phẩm : ");
            quantity = ValidatorInput.inputString();
            if (quantity.matches(regexQuantity)) {
                break;
            } else {
                System.out.println("Số lượng sản phẩm không vượt quá 100!");
            }
        } while (true);
        return Integer.parseInt(quantity);
    }
}
