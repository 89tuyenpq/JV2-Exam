package org.t2303e;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManagement {
    private Map<String, Customer> customerMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CustomerManagement customerManagement = new CustomerManagement();
        customerManagement.runMenu();
    }

    void addCustomer() {
        System.out.println("Nhập thông tin khách hàng:");
        System.out.print("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        Customer newCustomer = new Customer(name, email, phoneNumber);
        customerMap.put(name, newCustomer);
        System.out.println("Thêm khách hàng thành công!\n");
    }


    void findByName() {
        System.out.print("Nhập tên khách hàng cần tìm: ");
        String nameToFind = scanner.nextLine();

        Customer customer = customerMap.get(nameToFind);
        if (customer != null && customer.getPhoneNumber() != null) {
            System.out.println("Thông tin khách hàng:\n" + customer);
        } else {
            System.out.println("Không tìm thấy khách hàng.\n");
        }
    }

    void displayAllCustomers() {
        if (customerMap.isEmpty()) {
            System.out.println("Thông tin khách hàng không hiển thị.\n");
        } else {
            System.out.println("Thông tin tất cả khách hàng:\n");
            for (Customer customer : customerMap.values()) {
                System.out.println(customer);
            }
        }
    }

    void runMenu() {
        int choice;
        do {
            System.out.println("Customer Relationship Management Menu:");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Tìm kiếm bằng tên");
            System.out.println("3. Hiển thị tất cả");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn danh mục Menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    displayAllCustomers();
                    break;
                case 4:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp. Vui lòng chọn lại.\n");
            }
        } while (choice != 4);
    }
}
