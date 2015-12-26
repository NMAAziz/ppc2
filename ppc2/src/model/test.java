/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Abdel Aziz NGOUH
 */
public class test {
    public static void main(String[] args) {
        ModelPPC test = new ModelPPC("aziz", "abdel");
        ArrayList<String> couts = new ArrayList<String>();
        couts = test.getLcouts();
        String elt = couts.get(2);
        System.out.println(elt);
    }
    
}
