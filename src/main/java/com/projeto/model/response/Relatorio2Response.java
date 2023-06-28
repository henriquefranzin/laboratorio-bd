package com.projeto.model.response;

import com.projeto.model.Relatorio2Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.ParameterMode.IN;
import static javax.persistence.ParameterMode.REF_CURSOR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(name = "ADMIN_REL2", procedureName = "ADMIN_REL2", resultClasses = {Relatorio2Response.class},
        parameters = {
                @StoredProcedureParameter(mode = IN, type = String.class)
        })
@IdClass(Relatorio2Id.class)
public class Relatorio2Response {

    @Id
    private String city;
    private String iatacode;
    @Id
    private String airport;
    private String airportcity;
    private String distance;
    private String airptype;

}
