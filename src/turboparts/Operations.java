/*
* Copyright (C) Dominic Castaneda - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited 
* Proprietary and confidential
* Written by Dominic Castaneda <dcastaneda2828@gmail.com>, November 2021
*/
package turboparts;

public class Operations {
    public String moneyFormat(String string1) {
        return "$" + string1;
    }
    
    public String concatenate(String string1, String string2) {
        return string1 + string2;
    }
    
    public String clear(String string1) {
        return "";
    }
    
    public static double smallestDouble(double num1, double num2) {
        return Math.min(num1, num2);
    }
}
