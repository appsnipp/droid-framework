package com.thirdeyews.droidframework;

/**
 * Created by kapil on 22/01/18.
 */

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.thirdeyews.droidframework.support.Validator;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Use these codes for validation **/
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    /**
     * sample for empty error, can create similarly for other errors
     * For required validation just invoke empty error function with layout,edittext and error message*/
    private boolean emptyError(TextInputLayout inputLayout, View TextWid, String error){

        String dataText=((EditText)TextWid).getText().toString().trim();

        if(Validator.isEmpty(dataText))
        {
            inputLayout.setErrorEnabled(true);
            inputLayout.setError(error);
            requestFocus(TextWid);
            return false;
        }
        else {
            inputLayout.setError(null);
            inputLayout.setErrorEnabled(false);
        }
        return true;
    }
}



