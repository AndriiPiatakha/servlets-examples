package json.gson;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  

public class GsonTester9 { 
   public static void main(String args[]) { 
      GsonBuilder builder = new GsonBuilder(); 
      builder.serializeNulls(); 
      builder.setPrettyPrinting(); 
      Gson gson = builder.create();  
      
      Student4 student = new Student4(); 
      student.setRollNo(1);  
      String jsonString = gson.toJson(student); 
      
      System.out.println(jsonString);  
      student = gson.fromJson(jsonString, Student4.class); 
      System.out.println(student); 
   }      
} 
class Student4 { 
   private int rollNo; 
   private String name;  
   
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
   public String toString() { 
      return "Student[ name = "+name+", roll no: "+rollNo+ "]"; 
   } 
}
