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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author DREAM-TECH
 */
public class BreakingBad implements ResponseBot{
    private String breakingBad;

    @Override
    public String bot() {
        HttpRequest http = new HttpRequest("https://breaking-bad-quotes.herokuapp.com/v1/quotes");
        try {
            this.breakingBad = function(http.sendGet());
            return this.breakingBad;
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Not Found!";
    }
    
    private String function(StringBuffer response) {
        //JSONObject json = new JSONObject(response.toString());
        //System.out.println(json);
        
        JSONArray array = new JSONArray(response.toString());
        return ((JSONObject) array.get(0)).getString("quote");
    }
}
