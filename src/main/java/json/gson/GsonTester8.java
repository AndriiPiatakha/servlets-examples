package json.gson;

import java.io.IOException;  

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 
import com.google.gson.TypeAdapter; 
import com.google.gson.stream.JsonReader; 
import com.google.gson.stream.JsonToken; 
import com.google.gson.stream.JsonWriter;  

public class GsonTester8 { 
   public static void main(String args[]) { 
      GsonBuilder builder = new GsonBuilder(); 
      builder.registerTypeAdapter(Student3.class, new StudentAdapter()); 
      builder.setPrettyPrinting(); 
      Gson gson = builder.create();  
      
      
      String jsonString = "{\"name\":\"Mahesh\", \"rollNo\":1}";  
      Student3 student = gson.fromJson(jsonString, Student3.class); 
      System.out.println(student);  
      
      jsonString = gson.toJson(student); 
      System.out.println(jsonString);  
   }      
}  
class StudentAdapter extends TypeAdapter<Student3> { 
   @Override 
   public Student3 read(JsonReader reader) throws IOException { 
      Student3 student = new Student3(); 
      reader.beginObject(); 
      String fieldname = null; 
      
      while (reader.hasNext()) { 
         JsonToken token = reader.peek();            
         
         if (token.equals(JsonToken.NAME)) {     
            //get the current token 
            fieldname = reader.nextName(); 
         } 
         if ("name".equals(fieldname)) {       
            //move to next token 
            token = reader.peek(); 
            student.setName(reader.nextString()); 
         } 
         if("rollNo".equals(fieldname)) { 
            //move to next token 
            token = reader.peek(); 
            student.setRollNo(reader.nextInt()); 
         }               
      } 
      reader.endObject(); 
      return student; 
   }  
   @Override 
   public void write(JsonWriter writer, Student3 student) throws IOException { 
      writer.beginObject(); 
      writer.name("name"); 
      writer.value(student.getName()); 
      writer.name("rollNo"); 
      writer.value(student.getRollNo()); 
      writer.endObject(); 
   } 
}  
class Student3 { 
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
