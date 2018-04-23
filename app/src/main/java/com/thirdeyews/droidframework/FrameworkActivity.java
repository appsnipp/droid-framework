package com.thirdeyews.droidframework;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FrameworkActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //initialising Droid framework
    Df df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framework);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Create Droid Framework class
        df = new Df(this);

        //making dismissable alert
        df.registerDismissableAlert(R.id.darkAlert);
        df.registerDismissableAlert(R.id.primaryAlert);
        df.registerDismissableAlert(R.id.alertDismissible,R.id.alertCloseButton);
        df.showSmallNotification("Sample","Sample Message",new Intent(this,FrameworkActivity.class));

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.framework, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     df functions
     **/
    public void dfFunctions(View view){
        switch (view.getId()){
            case R.id.btnHide:
                df.hide(findViewById(R.id.btnHide));
                break;
            case R.id.btnShrink:
                df.shringToCenterAnimation(findViewById(R.id.btnShrink));
                break;
            case R.id.btnFadeOut:
                df.fadeOutAnimation(findViewById(R.id.btnFadeOut));
                break;
            case R.id.btnFadeIn:
                df.fadeInAnimation(findViewById(R.id.btnFadeIn));
                break;
            case R.id.btnGrowFromCenter:
                df.growFromCenterAnimation(findViewById(R.id.btnGrowFromCenter));
                break;
            case R.id.btnAlertMessage:
                df.alert("Sample ALert");
                break;
            case R.id.btnToastMessage:
                df.shortToast("Sample Toast");
                break;
            case R.id.btnDangerAlert:
                df.dfDangerAlert();
                break;
            case R.id.btnSuccessAlert:
                df.dfSuccessAlert();
                break;
            case R.id.btnInternet:
//                setTheme(R.style.AppThemeRed );
//                TaskStackBuilder.create(this)
//                        .addNextIntent(new Intent(this, FrameworkActivity.class))
//                        .addNextIntent(getIntent())
//                        .startActivities();
                df.getInternetStatus();
                break;
            case R.id.btnNotification:
                df.showSmallNotification("Sample","sample notification",new Intent(this,FrameworkActivity.class));
                break;
        }
    }
}
