package com.company;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class NextHighestNumber {

    public Integer getNextHighestNumber(String value){
        CharacterIterator valueIterator = new StringCharacterIterator(value);
        StringBuffer valueBuffer = new StringBuffer();
        String current = "";
        String left = "";
        String right = "";
        Boolean isNextSkipped = false;
        Boolean isChanged = false;

        for (int i = value.length()-1; i > 0; i--) {


            current = String.valueOf(value.charAt(i));

            left = String.valueOf(value.charAt(i-1));

            //if changes happen copy the rest of the digit
            if(isChanged){
                valueBuffer.insert(0,current);
            }
            else{
                //swap happened
                if(isNextSkipped){
                    right = String.valueOf(value.charAt(i+1));
                    valueBuffer.insert(0,right);
                    isNextSkipped = false;
                    isChanged = true;
                }
                else{
                    //swapping starts at current index
                    if(isCurrentDigitValueGreaterThanLeftDigitValue( Integer.parseInt(current) ,
                            Integer.parseInt(left)) ) {
                        valueBuffer.insert(0,left);
                        isNextSkipped = true;
                    }
                    else{
                        valueBuffer.insert(0,current);
                    }

                }
            }

        }

        //add the first digit
        valueBuffer.insert(0,String.valueOf(value.charAt(0)));

        if(!isChanged)
            System.out.println("It's the highest number");
        //isNextSkipped = false;
        return Integer.parseInt(valueBuffer.toString());

    }

    public Boolean isStringInInteger(String value){
        try{
            int number = Integer.parseInt(value);
        }
        catch(NumberFormatException ex){
            return false;
        }
        return true;
    }

    public Boolean isLengthGreaterThan1(String value){
        return value.length() > 1;
    }

    public Boolean isCurrentDigitValueGreaterThanLeftDigitValue(int currentDigit, int leftDigit){
        return currentDigit > leftDigit;
    }
}
