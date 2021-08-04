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
            System.out.println(valueBuffer.toString());
            System.out.println(value.charAt(i));

            current = String.valueOf(value.charAt(i));

            System.out.println(current);

            left = String.valueOf(value.charAt(i-1));

            if(isChanged){
                System.out.println("first ;" + current);
                valueBuffer.insert(0,current);
            }
            else{
                if(isNextSkipped){
                    right = String.valueOf(value.charAt(i+1));
                    valueBuffer.insert(0,right);
                    isNextSkipped = false;
                    isChanged = true;
                }
                else{
                    if(isCurrentDigitValueGreaterThanLeftDigitValue( Integer.parseInt(current) ,
                            Integer.parseInt(left)) ) {
                        valueBuffer.insert(0,left);
                        isNextSkipped = true;
                    }
                    else{
                        System.out.println("last ;" + current);
                        valueBuffer.insert(0,current);
                    }

                }
            }

        }
        valueBuffer.insert(0,String.valueOf(value.charAt(0)));
        if(!isChanged)
            System.out.println("It's the highest number");
        //isNextSkipped = false;
        return Integer.parseInt(valueBuffer.toString());

//        for (char ch = valueIterator.last(); ch != CharacterIterator.DONE; ch = valueIterator.previous()) {
//            current = String.valueOf(ch);
//            left = String.valueOf(valueIterator.previous());
//
//            System.out.println("1 :12" +
//                    "" + current);
//            System.out.println(left);
//
//            if(isCurrentDigitValueGreaterThanLeftDigitValue( Integer.parseInt(current) ,
//                                    Integer.parseInt(left)) ) {
//                valueBuffer.insert(0,current);
//                valueBuffer.insert(0,left);
//            }
//            else{
//                if(isNextSkipped){
//                    valueBuffer.insert(0,current);
//                }
//                else {
//                    valueBuffer.insert(0,left);
//                }
//
//            }
//        }
//
//        if(isNextSkipped)
//            System.out.println("It's the highest number");
//
//        return Integer.parseInt(valueBuffer.toString());
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
