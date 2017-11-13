package myPackage;

public class Main {

    public static void main(String[] args) {
      EnigmaMachine EM=new EnigmaMachine();
      EM.addPlug('B','C');
      EM.addPlug('R','I');
      EM.addPlug('S','M');
      EM.addPlug('A','F');

      BasicRotor Rotor1=new BasicRotor("IV");
      Rotor1.setPosition(23);
      EM.addRotor(Rotor1,0);

        BasicRotor Rotor2=new BasicRotor("V");
        Rotor2.setPosition(4);
        EM.addRotor(Rotor2,1);

        BasicRotor Rotor3=new BasicRotor("II");
        Rotor3.setPosition(9);
        EM.addRotor(Rotor3,2);

        Reflector RE=new Reflector(2);
        EM.setReflector(RE);

        System.out.println(EM.start(("GACIG").toUpperCase()));
    }
}
