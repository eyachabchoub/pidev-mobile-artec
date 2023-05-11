/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import com.esprit.artec.entities.Evenements;
import com.esprit.artec.entities.Reservations;
import com.esprit.artec.services.ServiceEvenements;
import java.util.ArrayList;
import javafx.scene.control.Separator;

/**
 *
 * @author Asus
 */
public class EvenementsForm extends BaseForm {

    private Resources res;

    public EvenementsForm(Resources res) {
        super("Evenements", BoxLayout.y());
        this.res = res;

        // Add a side menu
        super.addSideMenu(res);

        // Set the title
        setTitle("Evenements");

        // Add a search bar to the toolbar
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.addSearchCommand(e -> {
        });

        // Load the evenements
        ArrayList<Evenements> evenementsList = ServiceEvenements.getInstance().getEvenements(res);
        System.out.println("EvenementsList: " + evenementsList);

        // Add the evenements to the form
        for (Evenements evenement : evenementsList) {
            addEvenement(res.getImage("news-item-1.jpg"), evenement, evenement.getIdEvent(), evenement.getNomGalerie(), evenement.getDescriptionGalerie(), evenement.getDateGal(), evenement.getPrix());
        }
    }

    private void addEvenement(Image img, Evenements evenement, int idEvent, String nomGalerie, String descriptionGalerie, String date, int prix) {
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

        Label idEventLabel = new Label("Evenement ID: " + idEvent);
        idEventLabel.setUIID("NewsTopLineBig");
        idEventLabel.getStyle().setMargin(0, 0, 10, 0);
        idEventLabel.getStyle().setPadding(0, 0, 0, 0);

        Label nomGalerieLabel = new Label("Nom Galerie: " + nomGalerie);
        nomGalerieLabel.setUIID("NewsTopLineBig");
        nomGalerieLabel.getStyle().setMargin(0, 0, 10, 0);
        nomGalerieLabel.getStyle().setPadding(0, 0, 0, 0);

        Label descriptionGalerieLabel = new Label("Description : " + descriptionGalerie);
        descriptionGalerieLabel.setUIID("NewsTopLineBig");
        descriptionGalerieLabel.getStyle().setMargin(0, 0, 10, 0);
        descriptionGalerieLabel.getStyle().setPadding(0, 0, 0, 0);

        Label categorieGalerieLabel = new Label("Categorie: " + evenement.getCategGal());
        categorieGalerieLabel.setUIID("NewsTopLineBig");
        categorieGalerieLabel.getStyle().setMargin(0, 0, 10, 0);
        categorieGalerieLabel.getStyle().setPadding(0, 0, 0, 0);

        Label dateLabel = new Label("Date: " + date);
        dateLabel.setUIID("NewsTopLineBig");
        dateLabel.getStyle().setMargin(0, 0, 10, 0);
        dateLabel.getStyle().setPadding(0, 0, 0, 0);

        Label prixLabel = new Label("Prix: " + prix + " €");
        prixLabel.setUIID("NewsTopLineBig");
        prixLabel.getStyle().setMargin(0, 0, 10, 0);

        infoContainer.add(idEventLabel);
        infoContainer.add(nomGalerieLabel);
        infoContainer.add(descriptionGalerieLabel);
        infoContainer.add(dateLabel);
        infoContainer.add(prixLabel);
        infoContainer.add(categorieGalerieLabel);

        cnt.add(BorderLayout.CENTER, infoContainer);
        Button visiterButton = new Button("Visiter");
        visiterButton.setUIID("Button");
        cnt.add(BorderLayout.EAST, visiterButton);
        add(cnt);
        
        visiterButton.addActionListener(evt -> {
            new CommentaireForm(res).show();
});


    }
}
