/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatientDashboard;


public class PatientIDandUsername {
    private int id;
    private String name;
    
    private static PatientIDandUsername data = new PatientIDandUsername();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private PatientIDandUsername(int id,String name){
        this.id=id;
        this.name=name;
        
    }
    
      private PatientIDandUsername(){     
    }
    public static PatientIDandUsername getInstance(){
       return data;
    }
}
