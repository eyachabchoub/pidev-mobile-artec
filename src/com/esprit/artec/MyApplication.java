package com.esprit.artec;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.esprit.artec.gui.EvenementsForm;
import com.esprit.artec.gui.MesReservationsForm;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener((err) -> {
            // prevent the event from propagating
            err.consume();
            System.out.println("error: " + err.getMessage());
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            //Dialog.show("Connection Error", err.getMessage(), "OK", null);
        });  
    }
    
    public void start() {
         if(current != null){
            current.show();
            return;
        }
        //new WalkthruForm(theme).show();
        //new SignInForm(theme).show();
        //new MesReservationsForm(theme).show();
        new EvenementsForm(theme).show();
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
