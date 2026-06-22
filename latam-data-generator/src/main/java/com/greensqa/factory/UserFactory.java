package com.greensqa.factory;

import com.greensqa.model.Company;
import com.greensqa.model.Person;
import com.greensqa.model.User;

public class UserFactory {

    public User createUser(boolean company){

        if(company){
            return new Company();
        }

        return new Person();
    }
}