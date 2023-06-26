package com.projeto.model.response;

import com.projeto.model.Relatorio5Id;
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
@NamedStoredProcedureQuery(name = "PIL_REL5", procedureName = "PIL_REL5", resultClasses = {Relatorio5Response.class},
        parameters = {
                @StoredProcedureParameter(mode = REF_CURSOR, type = void.class),
                @StoredProcedureParameter(mode = IN, type = Integer.class)
        })
@IdClass(Relatorio5Id.class)
public class Relatorio5Response {

    @Id
    public Long year;
    @Id
    public String name;
    public Long quantity;
}
