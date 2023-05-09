
public class Container implements Comparable<Container>{
    private String Id;
    private String ShortName;
    private String LongName;
    
    public String getID(){
        return Id;
    }
    public void setID(String ID){
        Id=ID;
    }
    
    public String getShortName(){
        return ShortName;
    }
    public void setShortName(String ShortName){
        this.ShortName = ShortName;
    }
    
    public String getLongName(){
        return LongName;
    }
    public void setLongName(String LongName){
        this.LongName = LongName;
    }
    
    @Override 
    public String toString(){
        return "  <CONTAINER "+this.getID()+">\n" +
                "        <SHORT-NAME>"+this.getShortName()+"</SHORT-NAME>\n" +
                "        <LONG-NAME>"+this.getLongName()+"</LONG-NAME>\n"+
				"  </CONTAINER>\n";
    }
    
    @Override 
    public int compareTo(Container a){
        if(this.getShortName().charAt(9) > a.getShortName().charAt(9)){
            return 1;
        } else if(this.getShortName().charAt(9)< a.getShortName().charAt(9)){
            return -1;
        }
        else {
            return 0;
        } 
    }
}
