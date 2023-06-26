package com.projeto.mapper;

import com.projeto.model.Constructor;
import com.projeto.model.request.ConstructorRequest;
import org.springframework.stereotype.Component;

@Component
public class ConstructorMapper {

    public static Long i = 211L;

    public static Constructor toEntity(ConstructorRequest constructorRequest) {
        Constructor constructor =
                Constructor.builder().
                        withConstructorid(i)
                        .withConstructorref(constructorRequest.getConstructorref())
                        .withNationality(constructorRequest.getNationality())
                        .withName(constructorRequest.getName())
                        .build();

        i = i + 1L;

        return constructor;
    }

}
