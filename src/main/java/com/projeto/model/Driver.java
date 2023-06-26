package com.projeto.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder(setterPrefix = "with")
@Table(name = "driver")
public class Driver {

    @Id
    public Long driverid;
    public String driverref;
    public Long number;
    public String code;
    public String forename;
    public String surname;
    public Date dob;
    public String nationality;
    public String url;
}
