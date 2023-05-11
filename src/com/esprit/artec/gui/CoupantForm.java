/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.artec.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.artec.entities.Reservations;
import com.esprit.artec.services.ServiceReservations;
import java.util.ArrayList;

/**
 *
 * @author eyach
 */
public class CoupantForm extends BaseForm {

    public CoupantForm(int idRes, Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Your reservations:" + idRes);
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);

        tb.addSearchCommand(e -> {
        });

        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        TextField ratingTextField = new TextField("", "Rating", 20, TextField.ANY);
        Button submitRatingButton = new Button("Submit Rating");

        Container labelsContainer = BoxLayout.encloseY(
                ratingTextField,
                submitRatingButton
        );
        //  addModele(res.getImage("news-item-1.jpg"), "Série 3", 100, "BMW");
        //addModele(res.getImage("news-item-1.jpg"), "Série 3", 100, "BMW");

        submitRatingButton.addActionListener(e -> {
            ServiceReservations.getInstance().verifierCoupannt(idRes, ratingTextField.getText(), res);
        });

        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                        GridLayout.encloseIn(3
                        )
                ),
                labelsContainer
        ));

    }

}
