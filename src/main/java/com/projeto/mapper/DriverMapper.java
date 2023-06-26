package com.projeto.mapper;

import com.projeto.model.Driver;
import com.projeto.model.request.DriverRequest;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public static Long i = 859L;

    public static Driver toEntity(DriverRequest driverRequest){
        Driver driver =
                Driver.builder()
                .withDriverid(i)
                .withDriverref(driverRequest.getDriverref())
                .withCode(driverRequest.getCode())
                .withDob(driverRequest.getDob())
                .withForename(driverRequest.getForename())
                .withSurname(driverRequest.getSurname())
                .withNationality(driverRequest.getNationality())
                .withNumber(driverRequest.getNumber())
                .build();

        i = i +1L;

        return driver;
    }

}
