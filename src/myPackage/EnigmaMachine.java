package myPackage;

public class EnigmaMachine {
      private PlugBoard plugBoard;
      private BasicRotor[] rotors=new BasicRotor[3];

      private Reflector reflector;
      public EnigmaMachine(){
          plugBoard=new PlugBoard();

      }
      //will run the Machine
      public void start(){

      }

     //will add plug into the list of plugs of plugboard
    public void addPlug(char firtEnd,char secondEnd){
         boolean tryAdd=this.plugBoard.addPlug(firtEnd,secondEnd);
         if(!tryAdd)
             System.out.println("there clash with plugs added");
    }

    //will clear all the plugs in the plugboard
    public void clearPlugboard(){
        this.plugBoard.clear();
    }

    //will add Rotor into the list of rotors
    public void addRotor(BasicRotor rotor, int slot){
        if(slot<3)
            this.rotors[slot]=rotor;
    }
    //will return the rotor corresponding the slot passed
    public BasicRotor getRotor(int slot){
        if(slot<3)
            return  this.rotors[slot];

        return null;
    }
    //will return the reflector
    public Reflector getReflector() {
        return reflector;
    }
    //will set reflector for the plugboard
    public void setReflector(Reflector R){
        this.reflector=R;
    }

    //will set the position for the rotor
    public void setPosition(int slot,int position){
        if(slot<3 && position<26)
            this.rotors[slot].setPosition(position);
    }

    //will get the index that represent the letter which basically in term alpahptcal Order
    public int encode(char letter){
        int value=0;
        letter=Character.toLowerCase(letter);
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0;i<alphabet.length;i++){
            if(alphabet[i]==letter){
                value=i;
                break;
            }

        }
        return value;
    }
}
