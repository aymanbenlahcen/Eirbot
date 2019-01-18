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
public class Bored implements ResponseBot{
    private String bored;

    @Override
    public String bot() {
        HttpRequest http = new HttpRequest("https://www.boredapi.com/api/activity");
        try {
            this.bored = function(http.sendGet());
            return this.bored;
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Not Found!";
    }
    
    private String function(StringBuffer response) {
        JSONObject json = new JSONObject(response.toString());
        return json.getString("activity");
    }
 
}
