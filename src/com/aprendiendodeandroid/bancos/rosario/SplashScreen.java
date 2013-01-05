package com.aprendiendodeandroid.bancos.rosario;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

// con esta anotation seteamos la vista que vamos a cargar por medio de RoboGuice
@ContentView(R.layout.splashscreen)
public class SplashScreen extends RoboFragmentActivity{
	protected EstadoSalvado data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.data = (EstadoSalvado) getLastCustomNonConfigurationInstance();
        if (this.data == null) {
            this.data = new EstadoSalvado();
        }
        if (this.data.doInit) {
            doInit();
        }
    }
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return this.data;
    }
    // y aca configuramos a la vista que vamos a pasar
    protected void startNextActivity() {
        Intent intent = new Intent(this, ManageTabsActivity.class);
        this.startActivity(intent);
        this.finish();
    }
    // Este metodoes el que maneja el delay en la carga del splashscreen
    protected void doInit() {
        this.data.doInit = false;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //TODO: Your application init goes here.
				startNextActivity();
            }
        }, 3000);
    }
    private class EstadoSalvado {
        public boolean doInit = true;
    }
}
