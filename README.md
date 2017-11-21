# EnigmaMachine
   Basic Engima Machine simulator<br/>
## How does it work
### Using Main Method
        EnigmaMachine EM=new EnigmaMachine();
        EM.addPlug('Q','F');(you can add up to 13 plugs without duplication
        There are 5 Kind of Rotors
        I,II,III,IV,V  (passed the type when Initiating the rotor)
        TurnoverRotor Rotor1=new TurnoverRotor("I");
        Use SetPosition to the set the inital posttion of the rotor
        Rotor1.setPosition(23);
        use AddRotor to add the Rotor into the Machine
        EM.addRotor(Rotor1,0);
        TurnoverRotor Rotor2=new TurnoverRotor("II");
        Rotor2.setPosition(11);
        EM.addRotor(Rotor2,1);
        Rotor1.setNextRotor(Rotor2);
        TurnoverRotor Rotor3=new TurnoverRotor("III");
        Rotor3.setPosition(7);
        EM.addRotor(Rotor3,2);
        Rotor2.setNextRotor(Rotor3);
        relector has two types   1,2 make sure you pass when inistaiting 
        Reflector RE=new Reflector(1);
        will set the reflector that will be used in the Enigma Machine
        EM.setReflector(RE);
 ### using File  
   
