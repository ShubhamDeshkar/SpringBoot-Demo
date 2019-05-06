package com.spring.demoApplication.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

// this is one method to do filtering
//@JsonIgnoreProperties(value = {"field1", "field2"})
@JsonFilter("SomeBean Filter")
public class SomeBean {
    private String field1;
    // Lets say I don't want this field to appear in the response.
//    @JsonIgnore
    private String field2;

//    @JsonIgnore
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }
}
