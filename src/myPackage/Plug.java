package myPackage;

public class Plug {
    private char end1;
    private char end2;

    //constructor
    public Plug(char first,char second){
       this.end1=first;
       this.end2=second;
    }
    //get the  end1
    public char getEnd1() {
        return this.end1;
    }
    //get the second end
    public char getEnd2(){
        return this.end2;
    }
    //will set the end1 char
    public void setEnd1(char a){
        this.end1=a;
    }
    //will set the end2 chat
    public void setEnd2(char a) {
        this.end2 = a;
    }
    //will return letter for the another end plug it does match ,if there no match will return letter passed
    public char encode(char letterIn){

        if(letterIn==this.getEnd1())
            return  this.getEnd2();
        else if (letterIn==this.getEnd2())
            return this.getEnd1();
        return letterIn;
    }
    //wil check if there clash with the plug passed into method
    public boolean clashWith(Plug plugin){
        char currentFirstEnd=this.getEnd1();
        char currentsecondEnd=this.getEnd2();

        if(currentFirstEnd==plugin.getEnd1() || currentsecondEnd==plugin.getEnd2() ) {
            return true;
        }else if(currentsecondEnd==plugin.getEnd1() || currentFirstEnd==plugin.getEnd2() ) {
            return true;
        }

        return false;
    }
}
