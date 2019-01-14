/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author kdriley0
 */
public class MySet extends MyVector  {
        
    public int cardinality(){//returns the (int) value of the size... returns the size 
        return this.size();
    }
    /**
     *  returns a new set = this set – B
     * @param vector2
     * @return 
     */
    public MySet complement( MySet vector2){
        MySet newSet = new MySet();
        newSet=this.clone();
        
        for(int i= 0;i<vector2.size;++i){
            if(newSet.contains(vector2.elementAt(i)))
                newSet.removeAt(i);
        }
       
    
      return newSet;  
    }
    public void add(Object element)//adds the object element if it is not already there
    {
        if(this.contains(element)){
            return;
        } else
            this.append(element);
    }

    /**
     *returns a new set = this set ∩ B
     * @param vector2
     */
    public MySet intersection( MySet vector2){
        
    MySet newSet = new MySet(); 
         for(int i = 0;i<this.size();i++){
            if(this.contains(vector2.elementAt(i))){
                newSet.append(vector2.elementAt(i));
            }
          }
         return newSet;
    }
    /**
     * check to see if setB is a subset
     * @param setB
     * @return 
     */
    public boolean subsetOf(MySet setB){
        for(int i =0;i<this.size();i++){
            if(!this.contains(setB.data[i]))
                return false;
        }
        return true;
    }
    /**
     * returns a union of this set and set b 
     * @param b
     * @return 
     */
    public MySet union(MySet b){
         MySet newSet=new MySet();
         for(int i = 0; i < this.size();i ++ ){
             newSet.add(this.data[i]);
             
         }
         for(int i =0;i<b.size;i++)
         {
             
             newSet.add(b.data[i]);
         }
        return newSet;
    }
    public MySet symmetricDifference(MySet setB){//returns a new set = (this set – B) U (B – this set) takes  MySet object B
        MySet newSet=new MySet();
       
        newSet=((this.complement(setB)).union(setB.complement(this)));
               
        return newSet;
    }
    /**
     * overrides the previous ToString 
     * returns the cardinality
     * plus everything in the set 5 at a time
     */
    @Override
    public String toString(){
        String str = "";
        str+= "cardinality = "+this.cardinality() + "\n";
    
    for(int i =0; i<this.cardinality();i++){
        str+= i+ " : " + data[i] + "\t";
        if((i+1)%5==0){
            str+="\n";
        }
    }        
        str+="\n+++++++++++++++++\n";
    
        return str;
    }
    /**
    * provides a to string method for MySet
    * that provides the cardinality
    *  and the elements with a new line every 5th element 
    */
    @Override
    public MySet clone(){
        MySet vecCopy = new MySet();
        for(int i = 0;i<this.cardinality();i++){
            vecCopy.data[i]=this.data[i];
        }
        vecCopy.size=this.size;
        return vecCopy;
    }
      public void swap(int[][] box){
          
          if(box.length%2==0){
              System.out.println();
              
          }
      }   
          
}
