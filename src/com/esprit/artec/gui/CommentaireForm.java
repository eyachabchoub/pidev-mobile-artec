/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.artec.gui;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import com.esprit.artec.entities.Commentaire;

import com.esprit.artec.services.ServiceEvenements;
import com.esprit.artec.services.ServiceCommentaire;
import java.util.ArrayList;
import javafx.scene.control.Separator;

/**
 *
 * @author Asus
 */
public class CommentaireForm extends BaseForm {

    private Resources res;

    public CommentaireForm(Resources res) {
        super("Commentaires", BoxLayout.y());
        this.res = res;

        // Add a side menu
        super.addSideMenu(res);

        // Set the title
        setTitle("Commentaires");

        // Add a search bar to the toolbar
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.addSearchCommand(e -> {
        });

        // Load the evenements
        ArrayList<Commentaire> evenementsList = ServiceCommentaire.getInstance().getCommentaires(res);
        System.out.println("CommentairesList: " + evenementsList);

        // Add the evenements to the form
        for (Commentaire commentaire : evenementsList) {
            addCommentaire(res.getImage("news-item-1.jpg"), commentaire);
        }
    }

    private void addCommentaire(Image img, Commentaire commentaire) {
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

        Label idEventLabel = new Label("Commentaire ID: " + commentaire.getIdComm());
        idEventLabel.setUIID("NewsTopLineBig");
        idEventLabel.getStyle().setMargin(0, 0, 10, 0);
        idEventLabel.getStyle().setPadding(0, 0, 0, 0);

        Label nomGalerieLabel = new Label("Text: " + commentaire.getText());
        nomGalerieLabel.setUIID("NewsTopLineBig");
        nomGalerieLabel.getStyle().setMargin(0, 0, 10, 0);
        nomGalerieLabel.getStyle().setPadding(0, 0, 0, 0);

      
        Label dateLabel = new Label("Date: " + commentaire.getDate());
        dateLabel.setUIID("NewsTopLineBig");
        dateLabel.getStyle().setMargin(0, 0, 10, 0);
        dateLabel.getStyle().setPadding(0, 0, 0, 0);

        
        infoContainer.add(idEventLabel);
        infoContainer.add(nomGalerieLabel);
        infoContainer.add(dateLabel);
        

        cnt.add(BorderLayout.CENTER, infoContainer);

        add(cnt);

    }
}

