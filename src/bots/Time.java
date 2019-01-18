/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import java.time.ZonedDateTime;

/**
 *
 * @author DREAM-TECH
 */
public class Time implements ResponseBot{
    private ZonedDateTime zdt;
    private String time;
    
    public Time() {
        this.zdt = ZonedDateTime.now();
    }
    public String bot() {
        return "Nous sommes " + zdt;
    }
}
