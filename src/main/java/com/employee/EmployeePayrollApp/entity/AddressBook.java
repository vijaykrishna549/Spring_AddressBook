package com.employee.EmployeePayrollApp.entity;

import com.employee.EmployeePayrollApp.dao.AddressBookdao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addressbooktb")
@Data
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    private String name;
    private String city;
//    private LocalDate startDate;
    private String state;
    private int phone;

    private String email;
    private String zip;

    public AddressBook() {
    }

    // Add a copy constructor
    public AddressBook(AddressBook addressBook) {
        this.name = addressBook.getName();
        this.city = addressBook.getCity();

        this.state = addressBook.getState();
        this.phone = addressBook.getPhone();

        this.email = addressBook.getEmail();
        this.zip = addressBook.getZip();
//        this.department = addressBook.getDepartment();
    }

    public void updatePersonData(AddressBookdao addressBookdao) {
        this.name = addressBookdao.name;
        this.city = addressBookdao.city;
//        this.startDate = employeedao.startDate;
        this.state = addressBookdao.state;
        this.phone = addressBookdao.phone;
        this.zip = addressBookdao.zip;
        this.email = addressBookdao.email;
    }
}
