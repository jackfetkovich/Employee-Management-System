import java.util.ArrayList;
import java.io.Serializable;

public class Employee implements Serializable {
    String firstName;
    String lastName;
    String position;
    String salary;
    int id;
    int deptNumber;

    public Employee(String firstName, String lastName, String position, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;

    }
    public static ArrayList<Employee> list = new ArrayList<Employee>();

    public static void addToList(String firstName, String lastName, String position, String salary){
        list.add(new Employee(firstName, lastName, position, salary));
    }

    public static void removeFromList(int i){
        list.remove(i);
    }


    @Override
   public String toString(){
        String s = lastName + ", " + firstName + " -  " + position + ", $" + salary;
       return s;
   }

    public String getFirstNameName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(int deptNumber) {
        this.deptNumber = deptNumber;
    }
}
