/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import chatbot.HttpRequest;
import chatbot.UserInterface;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author DREAM-TECH
 */
public class Icndb implements ResponseBot {

    private String icndb;

    @Override
    public String bot() {
        HttpRequest http = new HttpRequest("http://api.icndb.com/jokes/random");
        try {
            this.icndb = function(http.sendGet());
            return this.icndb;
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Not Found!";
    }
    
    private String function(StringBuffer response) {
        JSONObject json = new JSONObject(response.toString());
        return json.getJSONObject("value").getString("joke");
    }
    
}
