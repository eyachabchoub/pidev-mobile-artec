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
import com.esprit.artec.entities.Reservations;
import com.esprit.artec.utils.Statics;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author eyach
 */
public class ServiceReservations {

    public static ServiceReservations instance = null;

    private ConnectionRequest req;

    public static ServiceReservations getInstance() {
        if (instance == null) {
            instance = new ServiceReservations();
        }
        return instance;
    }

    public ServiceReservations() {
        req = new ConnectionRequest();

    }

    public ArrayList<Reservations> getMesReservations(Resources rs) {
        ArrayList<Reservations> reservationsList = new ArrayList<>();
        String url = Statics.BASE_URL + "/api/reservation/mes";
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
                        if (obj instanceof JSONObject) {
                            JSONObject jsonObject = (JSONObject) obj;
                            Reservations reservation = new Reservations();
                            reservation.setIdRes(jsonObject.getInt("idRes"));
                            reservation.setDate(jsonObject.getString("date"));
                            reservation.setPrixr((float) jsonObject.getDouble("prixr"));
                            reservation.setPayer(jsonObject.getBoolean("payer"));
                            reservation.setNomGalerie(jsonObject.getJSONObject("idEvent").getString("nomGalerie"));
                            reservation.setDescriptionGalerie(jsonObject.getJSONObject("idEvent").getString("descriptionGalerie"));
                            reservationsList.add(reservation);
                        }
                        i++;
                    }
                    // TODO: do something with the modelesList here
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservationsList;
    }

    public void participer(Resources rs) {
        String url = Statics.BASE_URL + "/api/rating/add";
        req = new ConnectionRequest(url, false);
        req.addResponseListener((e) -> {
            int statusCode = req.getResponseCode();
            if (statusCode == 200) {
                Dialog.show("Success", "Particer avec success", "OK", null);
            } else {
                Dialog.show("Error", "Failed", "OK", null);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    public void verifierCoupannt(int idRes, String value, Resources rs) {
        String url = Statics.BASE_URL + "/api/coupant/coupant/" + idRes+"?code="+value;
        System.out.println("url: " + url);
        req = new ConnectionRequest(url, false);
        req.addResponseListener((e) -> {
            int statusCode = req.getResponseCode();
            if (statusCode == 200) {
                Dialog.show("Success", "Coupant vérifié avec success", "OK", null);
            } else {
                Dialog.show("Error", "Failed", "OK", null);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
}
