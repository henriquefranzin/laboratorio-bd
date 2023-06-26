package com.projeto.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequest {

    public String driverref;
    public Long number;
    public String code;
    public String forename;
    public String surname;
    public Date dob;
    public String nationality;

}
