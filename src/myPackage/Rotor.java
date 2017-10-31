package myPackage;

public abstract class Rotor {
    private String name;
    private int position;
    private int[] mapping;
    public static final int ROTORSIZE = 26;

    //will set the position
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.getPosition();
    }

    public abstract void initialise(String name);

    public abstract int substitute(int position);
}

