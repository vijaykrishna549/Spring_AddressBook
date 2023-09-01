package com.employee.EmployeePayrollApp.controller;

import com.employee.EmployeePayrollApp.dao.AddressBookdao;
import com.employee.EmployeePayrollApp.entity.AddressBook;
import com.employee.EmployeePayrollApp.entity.ResponseDTO;
import com.employee.EmployeePayrollApp.repository.AddressBookRepo;
import com.employee.EmployeePayrollApp.service.AddressBookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persondata")
public class AddressBookController {

    @Autowired
    AddressBookImpl addressBookImpl;

    @Autowired
    AddressBookRepo addressBookRepo;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody AddressBook addressBook) {
        System.out.println("Received employee data: " + addressBook.toString()); // Debug log
        AddressBook addressBook1 = addressBookImpl.createPersonData(addressBook);
        ResponseDTO responseDTO = new ResponseDTO("Created person data successfully", addressBook1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllPeople")
    public ResponseEntity<List<AddressBook>> getAllEmployeeData() {
        try {
            List<AddressBook> addressBooks = new ArrayList<>();
            addressBooks = addressBookImpl.getAllPersonsData();
            return new ResponseEntity<>(addressBooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPersonById/{id}")
    public ResponseEntity <AddressBook>  getEmployeeById(@PathVariable Integer id){
        Optional<AddressBook> empData = addressBookRepo.findById(id);
        if(empData.isPresent()){
            return  new ResponseEntity<>(empData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteById/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        addressBookImpl.deletePersonData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted person data Successfully", "Delete Id : " +empId);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }



    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody AddressBookdao addressBookdao)
    {
        AddressBook empData = addressBookImpl.updatePersonData(empId, addressBookdao);
        ResponseDTO respDTO = new ResponseDTO("Updated Address Book Data Successfully",empData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }



}
