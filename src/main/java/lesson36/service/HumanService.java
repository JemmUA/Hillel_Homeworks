package lesson36.service;

import lesson36.exception.WrongAgeException;
import lesson36.exception.WrongGenderException;
import lesson36.exception.WrongNameException;

public class HumanService {
    public String validateName(String name) throws WrongNameException {
        if (name == null || name.isEmpty()) {
            throw new WrongNameException("Name is null or empty");
        }
        return name;
    }

    public Integer validateAge(Integer age) throws WrongAgeException {
        if (age == null) {
            throw new WrongAgeException("Age is null");
        }
        if (age < 0) {
            throw new WrongAgeException("Age is negative");
        }
        if (age > 9 && age < 18) {
            throw new WrongAgeException("Human is teenager");
        }
        return age;
    }

    public String validateGender(String gender) throws WrongGenderException {
        if (gender != "man" && gender != "woman") {
            throw new WrongGenderException("Gender is wrong");
        }
        return gender;
    }

}
