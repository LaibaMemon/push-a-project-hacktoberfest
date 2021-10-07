class MyEmployee{
    private int id;
    private String name;
    public void setName(String n){
        name=n;
    }
    public String getName(){
        return name;
    }
     public void setId(int i){
         id=i;
     }
     public int getId(){
         return id;
     }
 }
 public class Acessmodifiers {
     public static void main(String[] args) {
         MyEmployee samrat = new MyEmployee();
 //        samrat.id=145;
 //        samrat.name="Samrat Ghosh";      >>- Throws An Error Because we have used Private access modifiers
         samrat.setId(145);
         samrat.setName("Ranchod DAs");
         System.out.println(samrat.getId());
         System.out.println(samrat.getName());
     }
 }