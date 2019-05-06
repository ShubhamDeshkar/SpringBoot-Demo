package com.spring.demoApplication.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Shubham Deshkar");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Shubham", "Deshkar"));
    }

    @GetMapping(value = "/person/params", params = "v=1")
    public PersonV1 getParamsV1() {
        return new PersonV1("Shubham Deshkar");
    }

    @GetMapping(value = "/person/params", params = "v=2")
    public PersonV2 getParamsV2() {
        return new PersonV2(new Name("Shubham", "Deshkar"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getHeaderV1() {
        return new PersonV1("Shubham Deshkar");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getHeader2() {
        return new PersonV2(new Name("Shubham", "Deshkar"));
    }


    @GetMapping(value = "/person/produces", produces = "application/vnd.company.api-v1+json")
    public PersonV1 getProduceV1() {
        return new PersonV1("Shubham Deshkar");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.api-v2+json")
    public PersonV2 getProduceV2() {
        return new PersonV2(new Name("Shubham", "Deshkar"));
    }
}
