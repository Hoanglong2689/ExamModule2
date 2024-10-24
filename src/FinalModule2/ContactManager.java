package FinalModule2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> contacts;
    private Scanner scanner;
    private CSVHandler csvHandler;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.csvHandler = new CSVHandler();
    }

    public void displayMenu() {
        System.out.println("------- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ -------");
        System.out.println("Chọn chức năng theo số (để tiếp tục) ");
        while (true) {
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Lưu vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: displayContacts(); break;
                case 2: addContact(); break;
                case 3: updateContact(); break;
                case 4: deleteContact(); break;
                case 5: searchContact(); break;
                case 6: readFromFile(); break;
                case 7: saveToFile(); break;
                case 8: System.exit(0);
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void displayContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
            if ((i + 1) % 5 == 0) {
                System.out.print("Nhấn Enter để xem tiếp...");
                scanner.nextLine();
            }
        }
    }

    public void addContact() {
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Ngày sinh: ");
        String birthdate = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (isValidEmail(email) && isValidPhone(phone)) {
            contacts.add(new Contact(phone, group, name, gender, address, birthdate, email));
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Dữ liệu không hợp lệ.");
        }
    }

    public void updateContact() {
        System.out.print("Nhập số điện thoại cần sửa: ");
        String phone = scanner.nextLine();
        Contact contact = findContactByPhone(phone);

        if (contact != null) {
            System.out.print("Nhập nhóm mới: ");
            contact.setGroup(scanner.nextLine());
            System.out.print("Nhập họ tên mới: ");
            contact.setName(scanner.nextLine());
            System.out.print("Nhập giới tính mới: ");
            contact.setGender(scanner.nextLine());
            System.out.print("Nhập địa chỉ mới: ");
            contact.setAddress(scanner.nextLine());
            System.out.print("Nhập ngày sinh mới: ");
            contact.setBirthdate(scanner.nextLine());
            System.out.print("Nhập email mới: ");
            String email = scanner.nextLine();
            if (isValidEmail(email)) {
                contact.setEmail(email);
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Email không hợp lệ.");
            }
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại này.");
        }
    }

    public void deleteContact() {
        System.out.print("Nhập số điện thoại cần xóa: ");
        String phone = scanner.nextLine();
        Contact contact = findContactByPhone(phone);

        if (contact != null) {
            System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                contacts.remove(contact);
                System.out.println("Xóa thành công!");
            }
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại này.");
        }
    }

    public void searchContact() {
        System.out.print("Nhập số điện thoại hoặc họ tên để tìm: ");
        String query = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getPhone().contains(query) || contact.getName().contains(query)) {
                System.out.println(contact);
            }
        }
    }

    public void readFromFile() {
        System.out.print("Bạn có chắc chắn muốn cập nhật từ file? (Y/N): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            contacts = csvHandler.readCSV("src/FinalModule2/contacts.csv");
            System.out.println("Đã cập nhật từ file!");
        }
    }

    public void saveToFile() {
        System.out.print("Bạn có chắc chắn muốn lưu vào file? (Y/N): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            csvHandler.writeCSV("src/FinalModule2/contacts.csv", contacts);
            System.out.println("Đã lưu vào file!");
        }
    }

    private Contact findContactByPhone(String phone) {
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                return contact;
            }
        }
        return null;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10,13}");
    }
}

