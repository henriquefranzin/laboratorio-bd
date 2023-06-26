package com.projeto.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.ParameterMode.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedStoredProcedureQuery(name = "getResultByStatus", procedureName = "ADM_REL1", resultClasses = {Relatorio1Response.class},
parameters = {
        @StoredProcedureParameter(mode = REF_CURSOR, type = void.class)
})
public class Relatorio1Response {

    @Id
    public String status;
    @Column(name = "quantity")
    public Long quantity;

}
