package com.thirdeyews.droidframework.loginHandler;

import android.content.Context;
import android.content.SharedPreferences;

import com.thirdeyews.droidframework.config.Config;

/**
 * Created by kapil on 18/03/17.
 */

public class LoginPrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;



    private static final String PREF_LOGIN= Config.LOGIN_PREF_NAME;
    private static final String IS_LOGGED_IN="IsLoggedIn";
    private static final String LOGIN_NAME="LoginName";
    private static final String IS_SKIPPED="IsSkipped";
    private static final String LOGIN_MOB="LoginMob";
    private static final String FCM_ID="FcmID";



    public LoginPrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_LOGIN, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void setLoginStatus(boolean isFirstTime) {
        editor.putBoolean(IS_LOGGED_IN, isFirstTime);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGGED_IN, true);
    }

    public void setIsSkipped(boolean isSkipped) {
        editor.putBoolean(IS_SKIPPED, isSkipped);
        editor.commit();
    }

    public boolean isSkipped() {
        return pref.getBoolean(IS_SKIPPED, true);
    }

    public void setLoginName(String loginName)
    {
        editor.putString(LOGIN_NAME,loginName);
        editor.commit();
    }

    public String getLoginName()
    {
        return pref.getString(LOGIN_NAME,"0");
    }

    public void setLoginMob(String loginMob)
    {
        editor.putString(LOGIN_MOB,loginMob);
        editor.commit();
    }
    public String getLoginMob()
    {
        return pref.getString(LOGIN_MOB,null);
    }

    public void setFcmId(String fcmID)
    {
        editor.putString(FCM_ID,fcmID);
        editor.commit();
    }
    public String getFcmId()
    {
        return pref.getString(FCM_ID,"");
    }


    public void logout(){
        editor.putBoolean(IS_LOGGED_IN,true);
        editor.putString(LOGIN_NAME,"");
        editor.putString(FCM_ID,"");
        editor.commit();
    }


}
