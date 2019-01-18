/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import chatbot.HttpRequest;
import chatbot.UserInterface;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author DREAM-TECH
 */
public class Advice implements ResponseBot {

    private String advice;

    @Override
    public String bot() {
        HttpRequest http = new HttpRequest("https://api.adviceslip.com/advice");
        try {
            this.advice = function(http.sendGet());
            return this.advice;
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Not Found!";
    }

    private String function(StringBuffer response) {
        JSONObject json = new JSONObject(response.toString());
        return json.getJSONObject("slip").getString("advice");
    }
}
