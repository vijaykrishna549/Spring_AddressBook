package com.employee.EmployeePayrollApp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, AddressBook data) {
        this.message = message;
        this.data = data;
    }
}
