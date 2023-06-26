package com.projeto.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "constructors")
@Builder(setterPrefix = "with")
public class Constructor {

    @Id
    public Long constructorid;
    public String constructorref;
    public String name;
    public String nationality;
    public String url;
}
