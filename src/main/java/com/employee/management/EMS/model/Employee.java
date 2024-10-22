package com.employee.management.EMS.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    public int employeeId;
    public String firstName;
    public String middleName;
    public String lastName;
    public String address;
    public Date dateOfBirth;
    public String gender;
    public String phoneNumber;
}
