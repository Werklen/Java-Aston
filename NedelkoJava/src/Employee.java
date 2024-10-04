public class Employee {
    String fullName;
    String jobStatus;
    String email;
    String phone;
    int salary;
    int age;

    Employee(String fullName1, String jobStatus1, String email1, String phone1, int salary1, int age1) {
        fullName = fullName1;
        jobStatus = jobStatus1;
        email = email1;
        phone = phone1;
        salary = salary1;
        age = age1;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "fullName='" + fullName + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}