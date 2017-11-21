package myPackage;

public class Main {

    public static void main(String[] args) {

      /*String initalPath=System.getProperty("user.dir");
      String input=initalPath+"\\conf.txt";
      String output=initalPath+"\\Output.txt";
      EnigmaFile machine=new EnigmaFile(input,output);
      machine.readFile();//file wil be read
      boolean write=machine.writeOutput();
      if(!write){
        System.out.println("In valide output path");
      }*/
      //upp to section 5
      EnigmaMachine EM=new EnigmaMachine();
      EM.addPlug('Q','F');
     /* EM.addPlug('R','I');
      EM.addPlug('S','M');
      EM.addPlug('A','F');*/

        TurnoverRotor Rotor1=new TurnoverRotor("I");
        Rotor1.setPosition(23);
        EM.addRotor(Rotor1,0);
        TurnoverRotor Rotor2=new TurnoverRotor("II");
        Rotor2.setPosition(11);
        EM.addRotor(Rotor2,1);
        Rotor1.setNextRotor(Rotor2);
        TurnoverRotor Rotor3=new TurnoverRotor("III");
        Rotor3.setPosition(7);
        EM.addRotor(Rotor3,2);
        Rotor2.setNextRotor(Rotor3);
        Reflector RE=new Reflector(1);
        EM.setReflector(RE);

        //OJVAYFGUOFIVOTAYRNIWJYQWMXUEJGXYGIFT
      //THE QUICK BROWNFOXJUMPED OVER THE LAZY DOG  (Without Spaces)
        System.out.println(EM.start(("OJVAYFGUOFIVOTAYRNIWJYQWMXUEJGXYGIFT").toUpperCase()));
    }
}
