package org.lesson10;

import java.math.BigDecimal;

public class Employee {
    private String firstName;
    private String lastName;
    private String jobStatus;
    private String email;
    private String phone;
    private BigDecimal salary;
    private int age;

    public Employee(String firstName1, String lastName1, String jobStatus1, String email1, String phone1, BigDecimal salary1, int age1) {
        firstName = firstName1;
        lastName = lastName1;
        jobStatus = jobStatus1;
        email = email1;
        phone = phone1;
        salary = salary1;
        age = age1;
    }

    public Employee(String firstName1, String lastName1, String jobStatus1, String email1, String phone1, int salary1, int age1) {
        firstName = firstName1;
        lastName = lastName1;
        jobStatus = jobStatus1;
        email = email1;
        phone = phone1;
        salary = new BigDecimal(salary1);
        age = age1;
    }

    public Employee(String firstName1, String lastName1, String jobStatus1, String email1, String phone1, double salary1, int age1) {
        firstName = firstName1;
        lastName = lastName1;
        jobStatus = jobStatus1;
        email = email1;
        phone = phone1;
        salary = new BigDecimal(salary1);
        age = age1;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "first name='" + firstName + '\'' +
                "last name='" + lastName + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
