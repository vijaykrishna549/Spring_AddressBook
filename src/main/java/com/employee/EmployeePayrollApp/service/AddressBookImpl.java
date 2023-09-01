package com.employee.EmployeePayrollApp.service;


import com.employee.EmployeePayrollApp.dao.AddressBookdao;
import com.employee.EmployeePayrollApp.entity.AddressBook;
import com.employee.EmployeePayrollApp.exceptions.AddressBookException;
import com.employee.EmployeePayrollApp.repository.AddressBookRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookImpl implements IAddressBook {

    @Autowired
    AddressBookRepo addressBookRepo;

    @Override
    public AddressBook createPersonData(AddressBook addressBook) {
        AddressBook persondata = new AddressBook(addressBook);
        log.debug("Person data :" + persondata.toString()); // Debug log

        return addressBookRepo.save(persondata);
    }

    @Override
    public List<AddressBook> getAllPersonsData() {
        return (List<AddressBook>)
                addressBookRepo.findAll();
    }

    @Override
    public AddressBook getPersonDataById(int personId) {
        return addressBookRepo.findById(personId).orElseThrow(() -> new AddressBookException("Person with !!" + personId + "does not exists"));
    }

    @Override
    public void deletePersonData(int personId) {
        AddressBook personData = this.getPersonDataById(personId);
        addressBookRepo.delete(personData);
    }

    @Override
    public AddressBook updatePersonData(int personId, AddressBookdao addressBookdao) {
        AddressBook personData = this.getPersonDataById(personId);
        personData.updatePersonData(addressBookdao);
        return addressBookRepo.save(personData);
    }

    @Override
    public AddressBook deleteAllPersons(AddressBook addressBook) {
        addressBookRepo.deleteAll();
        return addressBook;
    }


}
