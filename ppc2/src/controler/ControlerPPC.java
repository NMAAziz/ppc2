/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.ModelPPC;

/**
 *
 * @author Abdel Aziz NGOUH
 */
public class ControlerPPC {
    
    public String control(ModelPPC player1, ModelPPC player2)
    {
        String result="";
        String cout1=player1.getCout();
        String cout2=player2.getCout();
        String name1 = player1.getName();
        String name2 = player2.getName();
        switch(cout1){
            case "pierre": switch(cout2){
                case "pierre":
                    result="null";
                    break;
                case "papier": result=name2;
                    break;
                case "ciseau": result = name1;
                    break;
                default: result="error";    
            };break;
            case "papier": switch(cout2){
                case "pierre":
                    result=name1;
                    break;
                case "papier": result="null";
                    break;
                case "ciseau": result = name2;
                    break;
                default: result="error";    
            };break;
            case "ciseau": switch(cout2){
                case "pierre":
                    result=name2;
                    break;
                case "papier": result=name1;
                    break;
                case "ciseau": result = "null";
                    break;
                default: result="error";    
            };break;
            default:
                result= "error";
        }
        
        return result;
    }
    
}
