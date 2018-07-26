package com.thirdeyews.droidframework.support;

import android.text.TextUtils;

/**
 * Created by kapil on 15/03/17.
 */

public class Validator {

    public boolean STATUS;
    public static final String MOB_PATTERN="((\\+*)((0[ -]+)*|(91 )*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}";

    public static boolean isEmpty(String content) {
        return content.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidMobile(String number) {
        return number.matches(MOB_PATTERN)&& !TextUtils.isEmpty(number);
    }

    public static boolean isMinString(String name, int len) {
        return name.length()>len-1;
    }

    public static boolean isFixedLength(String name, int len){
        return name.length() != len;
    }
    public  static boolean isLessThan(Double number1,Double number2){
        return number1<number2?true:false;
    }
    public static boolean isEmptyNumber(String numb){
        int num = 0;
        try{
            num = Integer.parseInt(numb);
        }catch (Exception e){

        }
        return num>0;
    }



}
