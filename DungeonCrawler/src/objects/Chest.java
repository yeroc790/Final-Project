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
public class Chest extends BoardObject{
    Item[] contents;
    boolean empty;
    
    public Chest(){
        super(0, 0, 'C', "chest");
        //put random number
        contents = new Item[3];
        contents[0] = new Item("Mjolnir", "Attack +3");
        contents[1] = new Item("Sting", "Attack +2");
        contents[2] = new Item("Banana", "Restore 1 health");
        empty = false;
    }
    
    public Chest(int x, int y){
        super(x, y, 'C', "chest");
        //put random number
        contents = new Item[3];
        contents[0] = new Item("Mjolnir", "Attack +3");
        contents[1] = new Item("Sting", "Attack +2");
        contents[2] = new Item("Banana", "Restore 1 health");
        empty = false;
    }
    
    //broken
    public void takeItem(int index){
        int num = contents.length;
        Item[] temp = new Item[num-1];
        
        int counter = 0;
        for (int i = 0; i < num; i++) {
            System.out.println("iteration " + i);
            if(i != index){
                temp[counter] = contents[i];
                counter++;
            }else{
                counter++;
            }
        }
        contents = temp;
    }
    
    public Item getItem(int index){
        return contents[index];
    }
    
    public void displayContents(){
        System.out.println("-- Chest Contents --");
        for(Item temp : contents){
            System.out.println(temp.getName());
        }
    }
}
