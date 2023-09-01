package com.employee.EmployeePayrollApp.repository;

import com.employee.EmployeePayrollApp.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBook,Integer> {

}
