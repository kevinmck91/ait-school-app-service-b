package com.school.students.feignclient;

import com.school.registrationdata.dtos.RegistrationData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("zuul")
public interface FeignClientRegistrationData {

    @GetMapping("registration-data/registration-data/{studentNumber}/")
    Optional<RegistrationData> getRegistrationDataByStudentNumber(@PathVariable String studentNumber);

}
