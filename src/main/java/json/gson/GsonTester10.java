package json.gson;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 
import com.google.gson.annotations.Since;  

public class GsonTester10 { 
   public static void main(String args[]) { 
      GsonBuilder builder = new GsonBuilder(); 
      builder.setVersion(1.0);   
      Gson gson = builder.create();
      
      Student5 student = new Student5(); 
      student.setRollNo(1); 
      student.setName("Mahesh Kumar"); 
      student.setVerified(true);  
      
      String jsonString = gson.toJson(student); 
      System.out.println(jsonString);  
      
      gson = new Gson();     
      jsonString = gson.toJson(student); 
      System.out.println(jsonString); 
   }      
} 
class Student5 { 
   @Since(1.0) 
   private int rollNo; 
   
   @Since(1.0) 
   private String name; 
   
   @Since(1.1) 
   private boolean verified;   
   
   public int getRollNo() { 
      return rollNo; 
   }  
   public void setRollNo(int rollNo) { 
      this.rollNo = rollNo; 
   }  
   public String getName() { 
      return name; 
   }  
   public void setName(String name) { 
      this.name = name; 
   }
   public void setVerified(boolean verified) { 
      this.verified = verified; 
   }  
   public boolean isVerified() { 
      return verified; 
   } 
} 
