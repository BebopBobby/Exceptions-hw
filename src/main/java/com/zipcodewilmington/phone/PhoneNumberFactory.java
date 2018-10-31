package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        ArrayList<PhoneNumber> randomPhoneNumberArray = new ArrayList<PhoneNumber>(phoneNumberCount);

        return randomPhoneNumberArray.toArray(new PhoneNumber[phoneNumberCount]);
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
       int num1 = RandomNumberFactory.createInteger(100, 999);
        int num2 = RandomNumberFactory.createInteger(100, 999);
       int num3 = RandomNumberFactory.createInteger(1000, 9999);

        return createPhoneNumberSafely(num1, num2, num3);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely (int areaCode, int centralOfficeCode, int phoneLineCode) {
        String fullNumber = "(" + areaCode + ")" + "-" + centralOfficeCode + "-" + phoneLineCode;

        logger.log(Level.WARNING, fullNumber + " is not a valid phone number");

        try {
            return createPhoneNumber(fullNumber);
        } catch (InvalidPhoneNumberFormatException i){
            logger.log(Level.WARNING, fullNumber + " is not a valid phone number");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);

        logger.log(Level.INFO, "Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);

        return phoneNumber;
    }
}
