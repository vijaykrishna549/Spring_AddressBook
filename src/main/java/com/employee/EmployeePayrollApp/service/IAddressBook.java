package com.employee.EmployeePayrollApp.service;

import com.employee.EmployeePayrollApp.dao.AddressBookdao;
import com.employee.EmployeePayrollApp.entity.AddressBook;

import java.util.List;

public interface IAddressBook {

    AddressBook createPersonData(AddressBook addressBook);

    List<AddressBook> getAllPersonsData();

    AddressBook getPersonDataById(int empId);

    void deletePersonData(int empId);

    AddressBook updatePersonData(int empId, AddressBookdao addressBookdao);

    AddressBook deleteAllPersons(AddressBook addressBook);

//    Employee getAllEmployeeData();
}
