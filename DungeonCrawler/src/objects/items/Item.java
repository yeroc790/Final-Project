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
    private String stat;
    private String desc; //description
    private String rarity; //common, rare, epic, legendary
    private boolean equipped;
    
    public Item(){
        name = "default_name";
        stat = "default_stat";
        desc = "default_desc";
        rarity = "common";
        equipped = false;
    }
    
    public Item(String name, String desc){
        this.name = name;
        this.desc = desc;
        equipped = false;
        stat = "";
    }
    
    public Item(String name, String desc, boolean equipped){
        this.name = name;
        this.desc = desc;
        this.equipped = equipped;
        stat = "";
    }
    
    public Item(String name, String stat, String desc, String rarity){
        this.name = name;
        this.stat = stat;
        this.desc = desc;
        this.rarity = rarity;
        equipped = false;
    }
    
    public Item(String name, String stat, String desc, String rarity, boolean equipped){
        this.name = name;
        this.stat = stat;
        this.desc = desc;
        this.rarity = rarity;
        this.equipped = equipped;
    }
    
    public String getRarity(){
        return rarity;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDesc(){
        return desc;
    }
    
    public String getStat(){
        return stat;
    }
    
    public boolean isEquipped(){
        return equipped;
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
