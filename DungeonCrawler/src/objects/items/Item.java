/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects.items;

/**
 *
 * @author Corey
 */
public class Item {
    private String name;
    private String desc; //description
    private boolean equipped;
    
    public Item(){
        name = "default_name";
        desc = "default_desc";
        equipped = false;
    }
    
    public Item(String name, String desc){
        this.name = name;
        this.desc = desc;
        equipped = false;
    }
    
    public Item(String name, String desc, boolean equipped){
        this.name = name;
        this.desc = desc;
        this.equipped = equipped;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDesc(){
        return desc;
    }
    
    public void setEquip(boolean b){
        equipped = b;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDesc(String desc){
        this.desc = desc;
    }
    
    public boolean equals(Item item){
        if((name == item.getName())&&(desc == item.getDesc()))
            return true;
        else
            return false;
    }
}
