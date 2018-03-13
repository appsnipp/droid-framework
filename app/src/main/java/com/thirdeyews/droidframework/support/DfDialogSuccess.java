package com.thirdeyews.droidframework.support;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.thirdeyews.droidframework.R;


/**
 * Created by kapil on 23/02/18.
 */

public class DfDialogSuccess extends Dialog implements
        View.OnClickListener {

    public Activity activity;
    public Dialog dialog;
    public Button btnUnderstand, no;

    public DfDialogSuccess(Activity activity) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.df_dialog_success);
        btnUnderstand = findViewById(R.id.btnUnderstand);
//        no = (Button) findViewById(R.id.btn_no);
//        btnUnderstand.setOnClickListener(this);
//        no.setOnClickListener(this);

    }
    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = this;
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnUnderstand:
////                dismiss();
//                break;
////            case R.id.btn_no:
////                dismiss();
////                break;
//            default:
//                break;
//        }
        dismiss();
    }
}
