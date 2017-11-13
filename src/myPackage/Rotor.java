package myPackage;

public abstract class Rotor {
    protected String name;
    private int position;
    private int[] mapping;
    public static final int ROTORSIZE = 26;

    //will set the position
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public abstract void initialise(String name);

    public abstract int substitute(int position);
}

