import java.io.*;
import java.util.ArrayList;

public class ReadEmployees implements Serializable {
    public static void main(String[] args) {

        try (FileInputStream fi = new FileInputStream("employees.bin")) {
            ObjectInputStream os = new ObjectInputStream(fi);
            Employee.list = (ArrayList<Employee>) os.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}