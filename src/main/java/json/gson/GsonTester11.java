package json.gson;

import java.lang.reflect.Modifier;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  


//By default, GSON excludes transient and static fields from 
//the serialization/deserialization process. 
//
//GsonBuilder provides control over excluding fields with particular
//modifier using excludeFieldsWithModifiers() method from serialization/deserialization 
//process. See the following example.


public class GsonTester11 { 
   public static void main(String args[]) { 
      GsonBuilder builder = new GsonBuilder(); 
      builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);    
      Gson gson = builder.create();  
      
      Student6 student = new Student6(); 
      student.setRollNo(1); 
      student.setName("Mahesh Kumar"); 
      student.setVerified(true); 
      student.setId(1); 
      student.className = "VI";  
      
      String jsonString = gson.toJson(student); 
      System.out.println(jsonString);    
   }      
} 
class Student6 { 
   private int rollNo; 
   private String name;
   private boolean verified;  
   private transient int id; 
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
