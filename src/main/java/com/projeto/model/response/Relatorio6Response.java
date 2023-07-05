package com.projeto.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;

import static javax.persistence.ParameterMode.IN;
import static javax.persistence.ParameterMode.REF_CURSOR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(name = "PIL_REL6", procedureName = "PIL_REL6", resultClasses = {Relatorio6Response.class},
        parameters = {
                @StoredProcedureParameter(mode = REF_CURSOR, type = void.class),
                @StoredProcedureParameter(mode = IN, type = String.class)
        })
public class Relatorio6Response {

    @Id
    public String status;
    public Long quantity;
}
