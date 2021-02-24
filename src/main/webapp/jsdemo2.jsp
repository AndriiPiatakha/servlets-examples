<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
 // you may here
</script>

<script src="./resources/js/test2.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello )
	<script type="text/javascript">
		function switchHtml() {
			debugger;
			console.log("here");
			document.getElementById('demo2').innerHTML = 'Hello JavaScript';
			document.getElementById('demo2').style.fontSize = '35px';
			document.getElementById("demo2").style.display = "none";
			document.getElementById("demo2").style.display = "block";
		}

		var fruits = [ "Banana", "Orange", "Apple", "Mango" ];
		fruits.pop();

		var fruits = [ "Banana", "Orange", "Apple", "Mango" ];
		var x = fruits.push("Kiwi"); //  the value of x is 5

		var fruits = [ "Banana", "Orange", "Apple", "Mango" ];
		fruits.unshift("Lemon"); // Adds a new element "Lemon" to fruits at the beginning

		var fruits = [ "Banana", "Orange", "Apple", "Mango" ];
		delete fruits[0]; // Changes the first element in fruits to undefined

		var fruits = [ "Banana", "Orange", "Apple", "Mango" ];
		fruits.splice(2, 0, "Lemon", "Kiwi");

		//The first parameter (2) defines the position where new elements should be added (spliced in).
		//The second parameter (0) defines how many elements should be removed.
		//The rest of the parameters ("Lemon" , "Kiwi") define the new elements to be added.

		var fruits = [ "Banana", "Orange", "Apple", "Mango" ];
		fruits.splice(0, 1); // Removes the first element of fruits

		var arr1 = [ "Cecilie", "Lone" ];
		var arr2 = [ "Emil", "Tobias", "Linus" ];
		var arr3 = [ "Robin", "Morgan" ];
		var myChildren = arr1.concat(arr2, arr3); // Concatenates arr1 with arr2 and arr3

		// sorting

		var fruits = [ "Banana", "Orange", "Apple", "Mango" ];
		fruits.sort(); // Sorts the elements of fruits 
		fruits.reverse(); // Reverses the order of the elements

		var points = [ 40, 100, 1, 5, 25, 10 ];
		points.sort(function(a, b) {
			return b - a
		});
		
		points.sort( (a, b) => {return b - a});

		typeof "John" // Returns "string" 
		typeof 3.14 // Returns "number"
		typeof NaN // Returns "number"
		typeof false // Returns "boolean"
		typeof [ 1, 2, 3, 4 ] // Returns "object"
		typeof {
			name : 'John',
			age : 34
			//otherObject : {
				//oneMoreObject : {
					
				//}
			//}
		} // Returns "object"
		typeof new Date() // Returns "object"
		typeof function() {
		} // Returns "function"
		typeof myCar // Returns "undefined" *
		typeof null // Returns "object"
		//debugger;
		
		// =======================  DEMO how boolean works
			var a = "asd"
			if (a) {alert('true')}
			if (undefined) { alert()}
			if (0) { alert()}
			if (1) { alert()}
			if (null) { alert()}

		// JSON

		var text = '{ "employees" : ['
				+ '{ "firstName":"John" , "lastName":"Doe" },'
				+ '{ "firstName":"Anna" , "lastName":"Smith" },'
				+ '{ "firstName":"Peter" , "lastName":"Jones" } ]}';
		
		//text.firstName
		
		var obj = JSON.parse(text);
		//obj.firstName
		
		var myObj = { "name":"John", "age":31, "city":"New York" };
		var myJSON = JSON.stringify(myObj);
		
		//Storing data:
		myObj = { "name":"John", "age":31, "city":"New York" };
		myJSON = JSON.stringify(myObj);
		localStorage.setItem("testJSON", myJSON);

		//Retrieving data:
		text = localStorage.getItem("testJSON");
		obj = JSON.parse(text);
		
		
		
		var myObj, i, j, x = "";
		myObj = {
		    "name":"John",
		    "age":30,
		    "cars": [
		        { "name":"Ford", "models":[ "Fiesta", "Focus", "Mustang" ] },
		        { "name":"BMW", "models":[ "320", "X3", "X5" ] },
		        { "name":"Fiat", "models":[ "500", "Panda" ] }
		    ]
		}

		/* for (i = 0; i < 10; i++) */
		for (i in myObj.cars) {
		    x += "<h2>" + myObj.cars[i].name + "</h2>";
		    for (j in myObj.cars[i].models) {
		        x += myObj.cars[i].models[j] + "<br>";
		    }
		}

		document.getElementById("demo").innerHTML = x;
		
		

		// OBJECTS

		var person = {
			firstName : "John",
			lastName : "Doe",
			age : 50,
			eyeColor : "blue"
		};

		//The syntax for accessing the property of an object is:
		objectName.property // person.age
		//or
		objectName["property"] // person["age"]
		//or
		objectName[expression] // x = "age"; person[x]

		// Methods
		person.name = function() {
			return this.firstName + " " + this.lastName;
		};

		// Constructor function for Person objects
		function Person(first, last, age, eye) {
			this.firstName = first;
			this.lastName = last;
			this.age = age;
			this.eyeColor = eye;
			this.nationality = "English";
		}

		// Create 2 Person objects
		var myFather = new Person("John", "Doe", 50, "blue");
		var myMother = new Person("Sally", "Rally", 48, "green");

		var x1 = new Object(); // A new Object object
		var x2 = new String(); // A new String object
		var x3 = new Number(); // A new Number object
		var x4 = new Boolean(); // A new Boolean object
		var x5 = new Array(); // A new Array object
		var x6 = new RegExp(); // A new RegExp object
		var x7 = new Function(); // A new Function object
		var x8 = new Date(); // A new Date object

		var x1 = {}; // new object
		var x2 = ""; // new primitive string
		var x3 = 0; // new primitive number
		var x4 = false; // new primitive boolean
		var x5 = []; // new array object
		var x6 = /()/ // new regexp object
		var x7 = function() {
		}; // new function object

		//Prototype Inheritance
		//All JavaScript objects inherit properties and methods from a prototype.
		//Date objects inherit from Date.prototype. Array objects inherit from Array.prototype. Person objects inherit from Person.prototype.
		//The Object.prototype is on the top of the prototype inheritance chain:
		//Date objects, Array objects, and Person objects inherit from Object.prototype.

		function Person(first, last, age, eyecolor) {
			this.firstName = first;
			this.lastName = last;
			this.age = age;
			this.eyeColor = eyecolor;
		}
		Person.prototype.nationality = "English";
		
		function Person(first, last, age, eyecolor) {
		    this.firstName = first;
		    this.lastName = last;
		    this.age = age;
		    this.eyeColor = eyecolor;
		}
		Person.prototype.name = function() {
		    return this.firstName + " " + this.lastName;
		};
		
		
		// FUNCTIONS 
		//self invoking
		
		(function () {
		    var x = "Hello!!";      // I will invoke myself
		})();
		
		
		// functions as values
		
		function myFunction(a, b) {
		    return a * b;
		}

		var x = myFunction(4, 3);
		
		// arguments object
		
		x = findMax(1, 123, 500, 115, 44, 88);

		function findMax() {
		    var i;
		    var max = -Infinity;
		    for (i = 0; i < arguments.length; i++) {
		        if (arguments[i] > max) {
		            max = arguments[i];
		        }
		    }
		    return max;
		}
		
		// DOM
		
		//JavaScript can change all the HTML elements in the page
		//JavaScript can change all the HTML attributes in the page
		//JavaScript can change all the CSS styles in the page
		//JavaScript can remove existing HTML elements and attributes
		//JavaScript can add new HTML elements and attributes
		//JavaScript can react to all existing HTML events in the page
		//JavaScript can create new HTML events in the page
		
		document.getElementById("demo5").innerHTML = "Hello World!";
		
		
		// METHODS
		
//		var element = document.getElementById(id)	Find an element by element id
//		document.getElementsByTagName(name)	Find elements by tag name
//		document.getElementsByClassName(name)	Find elements by class name
//		document.querySelectorAll("p.intro");

//		Changing HTML Elements

//		element.innerHTML =  new html content	Change the inner HTML of an element
//		element.attribute = new value	Change the attribute value of an HTML element
//		element.setAttribute(attribute, value)	Change the attribute value of an HTML element
//		element.style.property = new style	Change the style of an HTML element

//		Adding and Deleting Elements

//		document.createElement(element)	Create an HTML element
//		document.removeChild(element)	Remove an HTML element
//		document.appendChild(element)	Add an HTML element
//		document.replaceChild(element)	Replace an HTML element
//		document.write(text)	Write into the HTML output stream

		// Cookie
		
		document.cookie = "username=John Doe; expires=Thu, 18 Dec 2013 12:00:00 UTC";
		
		function setCookie(cname, cvalue, exdays) {
		    var d = new Date();
		    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
		    var expires = "expires="+d.toUTCString();
		    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
		}

		function getCookie(cname) {
		    var name = cname + "=";
		    var ca = document.cookie.split(';');
		    for(var i = 0; i < ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0) == ' ') {
		            c = c.substring(1);
		        }
		        if (c.indexOf(name) == 0) {
		            return c.substring(name.length, c.length);
		        }
		    }
		    return "";
		}

		function checkCookie() {
		    var user = getCookie("username");
		    if (user != "") {
		        alert("Welcome again " + user);
		    } else {
		        user = prompt("Please enter your name:", "");
		        if (user != "" && user != null) {
		            setCookie("username", user, 365);
		        }
		    }
		}
		
		
	</script>

	<div id="demo2">test</div>

	<button type="button" onclick="switchHtml()">Switch</button>


	<h2>My First JavaScript</h2>

	<button type="button"
		onclick="document.getElementById('demo').innerHTML = Date()">
		Click me to display Date and Time.</button>

	<p id="demo" class="some"></p>

	<noscript>Sorry...JavaScript is needed to go ahead.</noscript>



</body>
</html>