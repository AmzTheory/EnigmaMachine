package myPackage;

public class BasicRotor extends Rotor {
//    I = { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 }
//    II = { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 }
//    III = { 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 }
//    IV = {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 }
//    V = { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 }
    private int[] selectedMapping;
    public BasicRotor(String mappingType, int position){
        this.setPosition(position);
        mappingType=mappingType.toUpperCase();
        if(mappingType.equals("|")) {
            this.selectedMapping =new int[] { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
        }else if(mappingType.equals("||")){
            this.selectedMapping=new int[] { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
        }else if(mappingType.equals("|||")){
            this.selectedMapping=new int[] { 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
        }else if(mappingType.equals("IV")){
            this.selectedMapping=new int[] {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
        }else if(mappingType.equals("V")){
            this.selectedMapping=new int[] { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
        }
    }
    @Override
    public void initialise(String name) {

    }

    @Override
    public int substitute(int position) {
      if(this.getPosition()==0){
          return this.selectedMapping[position];

      }else{
          int index=this.shiftedValue(position);

          return this.selectedMapping[position+this.getPosition()];
      }
    }
    // mapping[x]=y   inversMapping[y]=x
    public int inverseMapping(int position){
        int index=0;
        for(int i=0;i<this.selectedMapping.length;i++){
            if(this.selectedMapping[i]==position){
                index=i;
                break;
            }

        }

        if(this.getPosition()!=0){
             index=this.shiftedValue(position);
        }
        return index;
    }
    //basically if it's not in position zero it will bring back the new index after shitfing
    public int shiftedValue(int position){
        int index=position+this.getPosition();
        //in case if it finished the loop
        if(index>25){
            index=(index%25)-1;
        }
        return index;
    }
    //wil increment the position value by one,if it reache the length of the rotoe it will set back to zero
    public void rotor(){
        this.setPosition(this.getPosition()+1);
        if(this.getPosition()==this.ROTORSIZE)
            this.setPosition(0);
    }
}
