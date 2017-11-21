package myPackage;

public class EnigmaMachine {
      private PlugBoard plugBoard;
      private BasicRotor[] rotors=new BasicRotor[3];

      private Reflector reflector;
      public EnigmaMachine(){
          plugBoard=new PlugBoard();

      }
      //will run the Machine
      public String start(String con) {
          String text = "";
          for (int i = 0; i < con.length(); i++) {
              text += this.encodeLetter(con.charAt(i));
          }
          return text;
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

    //will perform process of encoding letter plugboard,Rotors,Reflector
    public char encodeLetter(char letter){
        System.out.println("orginal "+letter);
        letter=this.plugBoard.substitute(letter);
        int indexLetter=getAlpahpticalOrder((letter));
        System.out.println("plugboard in");
        System.out.println(letter);
        //will iterate through the rotors
        System.out.println("Rotors");
        for(int i=0;i<3;i++){
            BasicRotor currentRotor=this.getRotor(i);
            indexLetter=currentRotor.substitute(indexLetter);
            System.out.println(indexLetter);
        }
        System.out.println("Reflector");
        //will use the reflector
        Reflector theReflector=this.getReflector();
        indexLetter=theReflector.substitute(indexLetter);
        System.out.println(indexLetter);
        System.out.println("inverse Mapping");
        //will iterate through the rotors using inverse mapping start from the the third rotor to First
        for(int i=2;i>-1;i--){

           BasicRotor current=this.getRotor(i);
           indexLetter=current.substituteBack(indexLetter);
           System.out.println(indexLetter);
        }
        System.out.println("plugboard out");
        this.getRotor(0).rotor();

        char encoded=this.plugBoard.substitute(getAccrodingToOrder(indexLetter));
        System.out.println(indexLetter);
        return encoded;
    }
    //will get the index that represent the letter which basically in term alpahptcal Order
    private int getAlpahpticalOrder(char letter){
        int value=0;
        letter=Character.toUpperCase(letter);// it was lower case instead of uppper case;) it took time tp figure it out
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i=0;i<alphabet.length;i++){
            if(alphabet[i]==letter){
                value=i;
                break;
            }

        }

        return value;
    }
    //get letter according to alpahptical Order
    public char getAccrodingToOrder(int order){
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        return alphabet[order];
    }
}
