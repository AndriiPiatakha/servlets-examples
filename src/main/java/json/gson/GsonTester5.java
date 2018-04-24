package json.gson;

import java.io.IOException; 
import java.io.StringReader;  

import com.google.gson.stream.JsonReader; 
import com.google.gson.stream.JsonToken;  

public class GsonTester5 { 
   public static void main(String args[]) { 
      String jsonString = 
         "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";  
      JsonReader reader = new JsonReader(new StringReader(jsonString));    
      try { 
         handleJsonObject(reader); 
      } 
      catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }    
   private static void handleJsonObject(JsonReader reader) throws IOException { 
      reader.beginObject(); 
      String fieldname = null; 
      
      while (reader.hasNext()) { 
         JsonToken token = reader.peek(); 
         
         if (token.equals(JsonToken.BEGIN_ARRAY)) { 
            System.out.print("Marks [ "); 
            handleJsonArray(reader); 
            System.out.print("]"); 
         } else if (token.equals(JsonToken.END_OBJECT)) { 
            reader.endObject(); 
            return; 
         } else {            
            if (token.equals(JsonToken.NAME)) {     
               //get the current token 
               fieldname = reader.nextName(); 
            } 
            if ("name".equals(fieldname)) {       
               //move to next token 
               token = reader.peek(); 
               System.out.println("Name: "+reader.nextString());           
            } 
            if("age".equals(fieldname)) { 
               //move to next token 
               token = reader.peek(); 
               System.out.println("Age:" + reader.nextInt());       
            } 
            if("verified".equals(fieldname)) { 
               //move to next token 
               token = reader.peek(); 
               System.out.println("Verified:" + reader.nextBoolean());           
            }             
         } 
      } 
   }  
   private static void handleJsonArray(JsonReader reader) throws IOException { 
      reader.beginArray(); 
      String fieldname = null; 
      
      while (true) { 
         JsonToken token = reader.peek(); 
         
         if (token.equals(JsonToken.END_ARRAY)) { 
            reader.endArray(); 
            break; 
         } else if (token.equals(JsonToken.BEGIN_OBJECT)) { 
            handleJsonObject(reader); 
         } else if (token.equals(JsonToken.END_OBJECT)) { 
            reader.endObject(); 
         } else {            
            System.out.print(reader.nextInt() + " ");            
         } 
      } 
   } 
}
