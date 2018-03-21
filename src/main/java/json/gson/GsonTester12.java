package json.gson;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 
import com.google.gson.annotations.Expose;  

public class GsonTester12 { 
   public static void main(String args[]) { 
      GsonBuilder builder = new GsonBuilder();     
      builder.excludeFieldsWithoutExposeAnnotation(); 
      Gson gson = builder.create();  
      
      Student7 student = new Student7(); 
      student.setRollNo(1); 
      student.setName("Mahesh Kumar"); 
      student.setVerified(true); 
      student.setId(1); 
      student.className = "VI"; 
      
      String jsonString = gson.toJson(student); 
      System.out.println(jsonString);    
   }      
} 
class Student7 { 
   @Expose 
   private int rollNo; 
   
   @Expose 
   private String name; 
   private boolean verified;  
   private int id; 
   public static String className;  
   
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
   public int getId() { 
      return id; 
   }  
   public void setId(int id) { 
      this.id = id; 
   } 
}
