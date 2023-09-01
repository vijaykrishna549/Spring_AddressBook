package com.employee.EmployeePayrollApp.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class AddressBookdao {

    public String name;
    public int phone;
//    @JsonFormat(pattern = "dd MMM yyyy")
//    public LocalDate startDate;
    public String city;
    public String state;

    public String email;

    public String zip;
//    public List<String> department;

}
