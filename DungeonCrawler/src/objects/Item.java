/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Corey
 */
public class Item {
    private String name;
    private String desc; //description
    
    public Item(){
        name = "default_name";
        desc = "default_desc";
    }
    
    public Item(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDesc(){
        return desc;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDesc(String desc){
        this.desc = desc;
    }
}
