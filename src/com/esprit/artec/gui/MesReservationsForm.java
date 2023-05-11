/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.esprit.artec.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.artec.entities.Reservations;
import com.esprit.artec.services.ServiceReservations;
import java.util.ArrayList;

/**
 * The newsfeed form
 *
 * @author Shai Almog
 */
public class MesReservationsForm extends BaseForm {

    public MesReservationsForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Your reservations:");
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

        ArrayList<Reservations> mesReservationList = ServiceReservations.getInstance().getMesReservations(res);
        System.out.println("mes reservations: " + mesReservationList);

        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                        GridLayout.encloseIn(3
                        )
                )
        ));
        for (Reservations resevation : mesReservationList) {
            //addModele(res.getImage(modele.getMgsrc()), modele.getNom(), modele.getPrix(), modele.getMarque());
            addReservation(res.getImage("news-item-1.jpg"), resevation.getIdRes(), resevation.getDate(), resevation.getPrixr(), resevation.isPayer(), resevation.getNomGalerie(), resevation.getDescriptionGalerie(), res);
        }
        //  addModele(res.getImage("news-item-1.jpg"), "Série 3", 100, "BMW");
        //addModele(res.getImage("news-item-1.jpg"), "Série 3", 100, "BMW");

    }

    private void addReservation(Image img, int idRes, String date, float prixr, boolean payer, String nomGalerie, String descriptionGalerie, Resources res) {
        int height = Display.getInstance().convertToPixels(20f);
        int width = Display.getInstance().convertToPixels(25f);
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");

        Container cnt = new Container(new BorderLayout());
        cnt.getStyle().setMargin(10, 0, 0, 0);
        cnt.getStyle().setPadding(0, 0, 0, 0);

        cnt.add(BorderLayout.WEST, image);

        Container infoContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        infoContainer.getStyle().setMargin(30, 0, 0, 0);
        infoContainer.getStyle().setPadding(0, 0, 0, 0);

        Label idResLabel = new Label("Reservation ID: " + idRes);
        idResLabel.setUIID("NewsTopLineBig");
        idResLabel.getStyle().setMargin(0, 0, 10, 0);
        idResLabel.getStyle().setPadding(0, 0, 0, 0);

        Label dateLabel = new Label("Date: " + date);
        dateLabel.setUIID("NewsTopLineBig");
        dateLabel.getStyle().setMargin(0, 0, 10, 0);
        dateLabel.getStyle().setPadding(0, 0, 0, 0);

        Label prixLabel = new Label("Prix: " + prixr + " €");
        prixLabel.setUIID("NewsTopLineBig");
        prixLabel.getStyle().setMargin(0, 0, 10, 0);
        prixLabel.getStyle().setPadding(0, 0, 0, 0);

        Label payerLabel = new Label("Payer: " + payer);
        payerLabel.setUIID("NewsTopLineBig");
        payerLabel.getStyle().setMargin(0, 0, 10, 0);
        payerLabel.getStyle().setPadding(0, 0, 0, 0);

        Label nomGalerieLabel = new Label("Nom Galerie: " + nomGalerie);
        nomGalerieLabel.setUIID("NewsTopLineBig");
        nomGalerieLabel.getStyle().setMargin(0, 0, 10, 0);
        nomGalerieLabel.getStyle().setPadding(0, 0, 0, 0);

        Label descriptionLabel = new Label("Description Galerie: " + descriptionGalerie);
        descriptionLabel.setUIID("NewsTopLineBig");
        descriptionLabel.getStyle().setMargin(0, 0, 0, 0);
        descriptionLabel.getStyle().setPadding(0, 0, 0, 0);

        infoContainer.addAll(idResLabel, dateLabel, prixLabel, payerLabel, nomGalerieLabel, descriptionLabel);

        cnt.add(BorderLayout.CENTER, infoContainer);

        add(cnt);

        Button payerButton = new Button("Payer");
        payerButton.addActionListener(e -> {
            System.out.println("selected reservation: " + idRes);
            new CoupantForm(idRes, res).show();
        });
        infoContainer.add(payerButton);

        Button deleteButton = new Button("Delete");
        deleteButton.addActionListener(e -> {
            System.out.println("selected reservation: " + idRes);
            
        });
        infoContainer.add(deleteButton);

        image.addActionListener(e -> ToastBar.showMessage(nomGalerie, FontImage.MATERIAL_INFO));
    }

}
