package myPackage;

public class TurnoverRotor extends BasicRotor{
    private TurnoverRotor nextRotor;
    private int turnOverPosition ;
    public TurnoverRotor(String mappingType) {
        super(mappingType);
        if(mappingType.equals("I"))
           this.turnOverPosition=24;
        else if (mappingType.equals("II"))
            this.turnOverPosition=12;
        else if (mappingType.equals("III"))
            this.turnOverPosition=3;
        else if (mappingType.equals("IV"))
            this.turnOverPosition=17;
        else if (mappingType.equals("V"))
            this.turnOverPosition=7;


    }

    public void setNextRotor(TurnoverRotor nextRotor) {
        this.nextRotor = nextRotor;
    }

    @Override
    public void rotor(){
        this.setPosition(this.getPosition()+1);
        if((this.getPosition()==this.turnOverPosition) && this.nextRotor!=null){
            this.nextRotor.rotor();
        }else
        {
            if(this.getPosition()==this.ROTORSIZE)
                this.setPosition(0);
        }

    }
}
