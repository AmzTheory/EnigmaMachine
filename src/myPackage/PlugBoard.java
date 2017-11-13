package myPackage;

import java.util.ArrayList;

public class PlugBoard {
    private ArrayList<Plug> plugs;
    public PlugBoard(){
        plugs=new ArrayList<Plug>();
    }
    //will add plugs to the array of plugs
    public boolean addPlug(char end1,char end2){

        Plug P=new Plug(end1,end2);
        for(Plug current :this.plugs){
            if(P.clashWith(current)) {
                return false;//if it clashed wil return false
            }
        }
        this.plugs.add(P);
        return true;
    }
    public int getNumPlugs(){
        return  this.plugs.size();
    }
    //will clear all the plugs
    public void clear(){
        this.plugs=null;
        plugs=new ArrayList<Plug>();

    }
    //will substuite the letter if the plug that matches
    public char substitute(char letter){
        for(Plug current: this.plugs){
            if(current.encode(letter)!=letter)
                return current.encode(letter);

        }
       return letter;
    }


}
