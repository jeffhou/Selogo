slogo
=====

Empty repository for SLogo project

Part 1 Design:

Design Goals

For our design, we break the SLogo project into three main modules. These are the Interpreter, the GUI, and the Engine.

The interpreter has several sub-modules. The interpreter contains a parser and factory. The parser uses the factory to create commands. These commands are created by extending an abstract commands class. The four main sub-command classes are turtle commands, math commands, boolean operations, and advanced operations. This makes our code very flexible because you just need to extend the command class to make a new command. The interpreter holds a map of user defined variable names to numeric values. The interpreter, after obtaining the parsed list of commands, will then pass a digested form of the commands to the engines for execution.

[ “-” : uses/contains, “+” : subclass of] 

Class Hierarchy for Interpreter

Interpreter

	- Parser

	- CommandFactory

		- Command

			+ Turtle Command

			+ Math Command

			+ Boolean Command

			+ Advanced Command

				- List of Commands

	- Map of Variables (Or a special database editor)		

For the GUI, we will have a Main Window Class. This class will hold instances of the Evaluation Console, Text Editor, and the SLogo Graphic Window. The evaluation console only prints the results of the user’s commands and prints errors if the user’s commands don’t correspond to an existing command. The SLogo Graphic Window holds instances of the Turtle Class and the Turtle Path Class. It also holds a variable, color, that is used to set the background color for the turtle’s display area and toggles the reference grid based off of the user’s input.  Because of the functionality of the Evaluation Console and the SLogo Graphic Window, they will only use getters since they do not need to change anything in the Engine.

The text editor, unlike the other two classes, will use setters. It responds to user input and therefore modifies the Engine. It evaluates the inputs of the user line by line and each line can also be clicked to execute specific lines. It also prints the user’s input. The final aspect of the GUI is the Run button, which is just an action listener that triggers the parser. A rough diagram is shown below that displays what we want our GUI to look like.

[ “-” : uses/contains, “+” : subclass of]

Class Hierarchy for Main Window Class

Main Window

	- Evaluation Console

		- Parser

	- Text Editor

		- Parser

	- SLogo Graphic Window

		- Turtle

		- Turtle Path

		- Color

		- Reference Grid

	- Run

Example Code (Pseudo-Code):

JTextfield sends input to Interpreter.

Interpreter calls parser (with a string as parameter) and the parser calls the Factory. 

Then a ForwardObject is created. 

The Interpreter then adds the ForwardObject to a queue 

Interpreter sends front of queue to the Engine class
