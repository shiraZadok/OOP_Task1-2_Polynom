# Polynom
Introduction:
The project deals with Complex Function that build from Polynom and Monom. 
There is in the project option to draw the functions with the class Functio_GUI.

Monom class:
Is the basic Polynom. 
An object from the Monom class is represented by 'a' and 'b'.
a =is a double number that represent the coefficient of the monom
b =is a integer number that represent the power of the Monom.
Proper input for example: a*x^b (without space).

Polynom class:
An object from the Polynom class is a collection of Monoms.
In order to realize a Polynom we used the LinkedList class where each node contains Monom. 
Proper input foe example: a*x^b+c*x^g (without space).

Main Methods in classes Monom and Polynom:
	Add - Monom+Monom, Polynom+Monom , Polynom+Polynom.
	Multiply - Monom*Monom, Polynom*Monom , Polynom*Polynom.
	Subtract - Polynom-Polynom.
	Equals - check if Monom=Monom, check if Polynom=Polynom.
	Root - check and calculator if there is a point with X-axis on this Polynom. If return (-1) its error.
	Area - calculator the area between the function(Polynom) to the X-axis.
	Derivative - calculate derivative of this Polynom

Complex_Function class:
Object from the Complex_Function class contain Monom, Polynom and Complex_Function. They all type of function.
An object from the Complex_Function class is structure of 'right', left' and 'operation'.
Right = represent one of function
Left = represent the second function
Operation = represent one of this arithmetic actions between the two function. The arithmetic actions that exist is: plus, mul, div, max, min, comp. 
Proper input for example: Div(Max(f(x),g(x)),h(x)) (without space).

Main Methods in Complex_Function:
	Plus
	Mul 
	Div
	Max
	Min
	Copy 
	Comp – substitute one function in the second one.
	F –  calculates the result when put X value in the function.
	InitFromString – get string that represent function and build from the string object of Complex_Function.

Functions_GUI class:
An object in Functions_GUI class is a collection of function.
In order to realize a Functions_GUI we used the LinkedList class where each node contains function.
This class draw all the functions on graph that represent X-axis and Y-axis.

Main Methods in Functions_GUI:
	InitFromFile – the function read from file that contain functions and made them to Complex_Function structure.  
	saveToFile - the function get object of Complex_Function structure and save him as txt file. 
	drawFunctions – the method draw all the functions from width and high datum or from JSON file.
