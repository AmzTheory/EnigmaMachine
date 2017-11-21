package myPackage;

import java.io.*;
import java.sql.Ref;

public class EnigmaFile {
    private String letter="";
    private EnigmaMachine machine;
    private String inputpath;
    private String outputPath;
    private String encrypted="";
    public EnigmaFile(String input,String output){
            machine=new EnigmaMachine();
            this.inputpath=input;
            this.outputPath=output;
    }

    public void readFile(){
        try{

        FileReader FS=new FileReader(this.inputpath);
        BufferedReader reader=new BufferedReader(FS);
        String currentLine="";
        while ((currentLine=reader.readLine())!=null){
            if(currentLine.equals("Plugs")){
                currentLine=reader.readLine();
                String[] lines=currentLine.split(",");
                addPlugs(lines);
            }else if (currentLine.equals("Rotors")){
                int counter=0;
                while(counter<3) {
                    currentLine = reader.readLine();
                    String det[]=currentLine.split(",");
                    this.addRotor(Integer.parseInt(det[0]),Integer.parseInt(det[1]),det[2]);
                    counter+=1;
                }
            }else if (currentLine.equals("Reflector")){
                currentLine=reader.readLine();
                addReflec(Integer.parseInt(currentLine));
            }else if (currentLine.equals("letter")){
                this.letter+=reader.readLine()+" ";
                while ((currentLine=reader.readLine())!=null){
                    this.letter+=currentLine;
                }

            }

        }
            reader.close();
            FS.close();
    }catch (Exception EX){

    }
    }
    //will Add the plugs to Machine
    public void addPlugs(String[] plugs){
        for(String P : plugs){
            char First=P.charAt(0);
            char Second=P.charAt(2);
            machine.addPlug(First,Second);
        }
    }

    public void addRotor(int position,int initial,String type){
        TurnoverRotor Ro=new TurnoverRotor(type);
        Ro.setPosition(initial);
        machine.addRotor(Ro,position);
    }

    public void addReflec(int type){
        Reflector RF=new Reflector(type);
        this.machine.setReflector(RF);

    }
    //will run the machine
    public String Encoded(){
        this.letter=this.letter.toUpperCase().trim();
        String res=this.machine.start(letter.toUpperCase());
        return res;
    }
    //public write in outPutFile
    public boolean writeOutput(){
      try{
          FileWriter FS=new FileWriter(this.outputPath);
          BufferedWriter writer=new BufferedWriter(FS);
          String Result=this.Encoded();
          writer.write(Result);

          writer.close();
          FS.close();
          return true;
      }catch (Exception EX){
          return  false;
      }
    }
}
