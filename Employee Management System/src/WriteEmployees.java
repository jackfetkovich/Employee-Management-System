import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteEmployees {
    public static void main(String[] args) {
        try(FileOutputStream fs  = new FileOutputStream("employees.bin")){
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(Employee.list);
            os.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }




}
