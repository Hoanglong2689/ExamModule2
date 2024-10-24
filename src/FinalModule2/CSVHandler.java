package FinalModule2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
    public List<Contact> readCSV(String filePath) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 7) {
                    contacts.add(new Contact(values[0], values[1], values[2], values[3], values[4], values[5], values[6]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void writeCSV(String filePath, List<Contact> contacts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Số điện thoại,Nhóm,Họ tên,Gới tính,Địa chỉ,Ngày sinh,Email\n");
            for (Contact contact : contacts) {
                bw.write(String.format("%s,%s,%s,%s,%s,%s,%s\n",
                        contact.getPhone(), contact.getGroup(), contact.getName(), contact.getGender(),
                        contact.getAddress(), contact.getBirthdate(), contact.getEmail()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

