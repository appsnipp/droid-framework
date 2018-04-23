package com.thirdeyews.droidframework;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thirdeyews.droidframework.firebase.MyNotificationManager;

/**
 * Created by kapil on 12/03/18.
 */

public class Df {
    private Context dfContext;
    private Activity activity;

    /**
     * Declaring constants
     */
    public static final Boolean REQUIRE_DIALOG = Boolean.TRUE;
    public static final Boolean REQUIRE_NO_DIALOG = Boolean.FALSE;
    //for alert
    private DialogInterface.OnClickListener dialogListener;

    public Df(Context dfContext){
        this.dfContext = dfContext;
        activity = (Activity)dfContext;
    }

    public void registerDismissableAlert(View view){
        setRegisterDismissableAlertCliclListener(view,view);
    }
    public void registerDismissableAlert(int viewId){
        registerDismissableAlert(activity.findViewById(viewId));
    }

    /**
     * use @func registerDismissableAlert() for registering a new alert, can be invoked from any view.
     * incase you use a close button, need to pass the parent container which needs to be gone and clickable content for registering click event!
     * @param parentView refers to id of parent to be hidden
     * @param clickableView refers to icon button , which would be pressed to hide alert
     * **/
    public void registerDismissableAlert(int parentView, int clickableView){
        registerDismissableAlert(activity.findViewById(parentView),activity.findViewById(clickableView));
    }

    /**
     * use @func registerDismissableAlert() for registering a new alert, can be invoked from any view.
     * incase you use a close button, need to pass the parent container which needs to be gone and clickable content for registering click event!
     * @param parentView refers to parent to be hidden
     * @param clickableContent refers to icon button , which would be pressed to hide alert
     * **/

    public void registerDismissableAlert(View parentView,View clickableContent){
        setRegisterDismissableAlertCliclListener(parentView,clickableContent);
    }

    private void setRegisterDismissableAlertCliclListener(final View parentView,View clickableContent){
        clickableContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shringToCenterAnimation(parentView);
            }
        });
    }

    /**
     * animation function can be invoked directly by passing the view
     * animation would be directly attached to view
     * @param view
     */

    public void shringToCenterAnimation(final View view){
        Animation shrinkAnimation = AnimationUtils.loadAnimation(dfContext, R.anim.shring_to_center);
        view.startAnimation(shrinkAnimation);
        setGoneForAnimationListener(shrinkAnimation,view);
    }
    public void growFromCenterAnimation(View view){
        view.setVisibility(View.VISIBLE);
        Animation growFromCenterAnimation = AnimationUtils.loadAnimation(dfContext, R.anim.grow_from_center);
        view.startAnimation(growFromCenterAnimation);
    }
    public void fadeOutAnimation(final View view){
        Animation fadeOutAnimation = AnimationUtils.loadAnimation(dfContext, R.anim.fade_out_animation);
        view.startAnimation(fadeOutAnimation);
        setGoneForAnimationListener(fadeOutAnimation,view);
    }
    public void fadeInAnimation(View view){
        view.setVisibility(View.VISIBLE);
        setAnimation(R.anim.fade_out_animation,view);
    }
    public void blinkAnimation(View view){
        setAnimation(R.anim.blink_animation,view);
    }

    public void zoomInAnimation(View view){
        setAnimation(R.anim.zoom_in_animation,view);
    }
    public void zoomOutAnimation(View view){
        setAnimation(R.anim.zoom_out_animation,view);
    }
    public void sequentialAnimation(View view){
        setAnimation(R.anim.sequential_animation,view);
    }



    /**
     * set animation can be invoked for setting new animations, need to pass
     * @param context invoking context
     * @param resource resource should be of type anim resource
     * @param view view to be affected
     * **/
    public void setAnimation(Context context,int resource,View view){
        Animation animation = AnimationUtils.loadAnimation(context, resource);
        view.startAnimation(animation);
    }
    public void setAnimation(int resource,View view){
        Animation animation = AnimationUtils.loadAnimation(dfContext, resource);
        view.startAnimation(animation);
    }
    public void hide(View view){
        view.setVisibility(View.GONE);
    }
    public void show(View view){
        view.setVisibility(View.VISIBLE);
    }

    /**
     * toggles the visibility to visible and hidden
     * requires a view parameter
     * @param view
     */
    public void toggleVisibility(View view){
        switch (view.getVisibility()){
            case View.VISIBLE:
                hide(view);
                break;
            case View.INVISIBLE:
            case View.GONE:
                show(view);
        }
    }

    private void setGoneForAnimationListener(Animation animation,final  View view){
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
    }


    /**
     * df alert echo and prompt
     *
     */

    public void echo(String message){
        shortToast(message);
    }

    /**
     * similar to alert in web
     * no optional callback available
     *
     * @param message
     */

    public void alert(String message){

        alert(message,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    }
    public void alert(String message, DialogInterface.OnClickListener onClickListener){
        AlertDialog alertDialog = new AlertDialog.Builder(dfContext).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok",onClickListener);
        alertDialog.show();
    }

    /**
     * default danger alert , would be created automatically , danger layout required
     */
    public void dfDangerAlert() {
        dfDangerAlert("Failed","Sorry Task Failed");
    }
    public void dfDangerAlert(String title,String message){
        dfDangerAlert(title,message,R.color.df_red);
    }
    public void dfDangerAlert(String title,String message,int color){
        dfDangerAlert(title,message,color,R.drawable.df_dialog_danger);
    }
    public void dfDangerAlert(String title,String message,int color,int image){

        dfAlert(title,message,color,image);
    }

    /**
     * success alert
     */
    public void dfSuccessAlert() {
        dfSuccessAlert("Success","Task Completed!");
    }
    public void dfSuccessAlert(String title,String message){
        dfSuccessAlert(title,message,R.color.df_green);
    }
    public void dfSuccessAlert(String title,String message,int color){
        dfSuccessAlert(title,message,color,R.drawable.df_dialog_success);
    }
    public void dfSuccessAlert(String title,String message,int color,int image){
        dfAlert(title,message,color,image);
    }

    /**
     *
     * @param title title of dialog
     * @param message message to be shown
     * @param color color of button to be displayed
     * @param image image to be displayed on top
     */
    public void dfAlert(String title,String message,int color, int image){
        final Dialog dialog = new Dialog(dfContext,R.style.df_dialog);
        dialog.setContentView(R.layout.df_dialog_danger);
        ((TextView)(dialog.findViewById(R.id.dfDialogTitle))).setText(title);
        ((TextView)(dialog.findViewById(R.id.dfDialogMessage))).setText(message);
        ((ImageView)dialog.findViewById(R.id.dfDialogImage)).setImageResource(image);
        ((dialog.findViewById(R.id.btnContinue))).setBackgroundColor(activity.getResources().getColor(color));
        dialog.findViewById(R.id.btnContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void longToast(String message){
        toast(message, Toast.LENGTH_LONG);
    }
    public void shortToast(String message){
        toast(message,Toast.LENGTH_SHORT);
    }
    public void toast(String message,int toastLength){
        Toast.makeText(dfContext,message,toastLength).show();
    }


    public  boolean getInternetStatus() {
        return getInternetStatus(REQUIRE_NO_DIALOG);
    }

    /**
     * if require a non dismissable alert, for no internet access, then invoke by passing Df.REQUIRE_DIALOG
     * @param isAlertRequired
     * @return current internet status
     */
    public boolean getInternetStatus(boolean isAlertRequired){
        ConnectivityManager cm = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(!isConnected) {
            if(isAlertRequired)noInternetAlert();
        }
        return isConnected;
    }

    private void noInternetAlert(){
        final Dialog dialog = new Dialog(dfContext,R.style.df_dialog);
        dialog.setContentView(R.layout.df_dialog_no_internet);
        dialog.findViewById(R.id.btnNoInternetRetry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                getInternetStatus(Df.REQUIRE_DIALOG);
            }
        });
        dialog.show();
    }

    /**
     * current priority for notifications is set to min, if you need to have high priority notification, then change it on the main function
     * Notification reuses the MyNotificationManager class, which is used for sending notification in firebase.
     * @param title title of message
     * @param message message to be displayed
     * @param intent intent to be invoked on clicking the notification
     */

    public void showSmallNotification(String title, String message, Intent intent) {
        new MyNotificationManager(dfContext).showSmallNotification(title,message,intent);
    }

    public void showBigNotification(final String title,final String message,final String url,final Intent intent) {
        new MyNotificationManager(dfContext).showBigNotification(title,message,url,intent);
    }


}
