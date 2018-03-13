package com.thirdeyews.droidframework;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by kapil on 12/03/18.
 */

public class Df {
    private Context dfContext;

    public Df(Context dfContext){
        this.dfContext = dfContext;
    }

    public void registerDismissableAlert(View view){
//        Activity activity = (Activity)dfContext;
//        activity.findViewById(R.id.darkAlert);
        setRegisterDismissableAlertCliclListener(view,view);
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
        setAnimation(dfContext,R.anim.fade_out_animation,view);
    }
    public void blinkAnimation(View view){
        setAnimation(dfContext,R.anim.blink_animation,view);
    }

    public void zoomInAnimation(View view){
        setAnimation(dfContext,R.anim.zoom_in_animation,view);
    }
    public void zoomOutAnimation(View view){
        setAnimation(dfContext,R.anim.zoom_out_animation,view);
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
    public void hide(View view){
        view.setVisibility(View.GONE);
    }
    public void show(View view){
        view.setVisibility(View.VISIBLE);
    }
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
}
