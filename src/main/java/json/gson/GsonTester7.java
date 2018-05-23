package json.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTester7 {
	public static void main(String args[]) {
		Gson gson = new Gson();
		Collection<Integer> marks = new ArrayList<Integer>();
		marks.add(100);
		marks.add(90);
		marks.add(85);

		// Serialization
		System.out.print("{");
		System.out.print("marks:" + gson.toJson(marks));
		System.out.println("}");

		// De-serialization
		Type listType = new TypeToken<Collection<Integer>>() {
		}.getType();
		marks = gson.fromJson("[100,90,85]", listType);
		System.out.println("marks:" + marks);
	}
}
