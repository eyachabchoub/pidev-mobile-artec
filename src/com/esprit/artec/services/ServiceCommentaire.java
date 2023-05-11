/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.artec.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.esprit.artec.entities.Commentaire;
import com.esprit.artec.entities.Reservations;
import com.esprit.artec.utils.Statics;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Asus
 */
public class ServiceCommentaire {

    public static ServiceCommentaire instance = null;

    private ConnectionRequest req;

    public static ServiceCommentaire getInstance() {
        if (instance == null) {
            instance = new ServiceCommentaire();
        }
        return instance;
    }

    public ServiceCommentaire() {
        req = new ConnectionRequest();

    }

    public ArrayList<Commentaire> getCommentaires(Resources rs) {
        ArrayList<Commentaire> commentairesList = new ArrayList<>();
        String url = Statics.BASE_URL + "/api/comm";
        req = new ConnectionRequest(url, false);
        req.setPost(false);
        req.addResponseListener((e) -> {
            JSONParser j = new JSONParser();
            String json = new String(req.getResponseData()) + "";
            int statusCode = req.getResponseCode();
            try {
                if (statusCode == 404) {
                    Dialog.show("Echec", "Error: 404 Not Found", "OK", null);
                } else if (statusCode == 200) {
                    JSONArray jsonArray = new JSONArray(new JSONArray(json).get(0).toString());

                    int i = 0;
                    while (i < jsonArray.length()) {
                        Object obj = jsonArray.get(i);
                        System.out.println("obj: " + obj);

                        if (obj instanceof JSONObject) {
                            JSONObject jsonObject = (JSONObject) obj;
                            Commentaire commentaire = new Commentaire();
                            commentaire.setIdComm(jsonObject.getInt("idComm"));
                            commentaire.setDate(jsonObject.getString("date"));
                            commentaire.setText(jsonObject.getString("text"));

                            commentairesList.add(commentaire);
                        }
                        i++;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return commentairesList;
    }
}
