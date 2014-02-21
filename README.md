slogo
=====

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


	For the GUI, we will have a Main Window Class. This class will hold the evaluation console, command line, reset button, command history, and the SLogo graphic window (using JGEngine). The evaluation console only prints the results of the user’s commands and prints errors if the user’s commands don’t correspond to an existing command. The SLogo Graphic Window holds instances of the Turtle Class and the Turtle Path Class. It also holds a variable, color, that is used to set the background color for the turtle’s display area and toggles the reference grid based off of the user’s input.  Because of the functionality of the evaluation Console and the SLogo graphic window, they will only use getters since they do not need to change anything in the Engine.

The command line, unlike the other two classes, will use setters. It responds to user input and therefore modifies the Engine. It evaluates the inputs of the user line by line when the 'enter' button is pressed. Each command will be sent to the parser part of the engine to verify its validity. The commands will only be acted on if the engine returns true for its validity (checking syntax and if the end of a loop has been reached). It also prints the user’s input. The final aspect of the GUI is the reset button, which is just an action listener that triggers a reset. A rough diagram is shown below that displays what we want our GUI to look like.


[ “-” : uses/contains, “+” : subclass of]

Class Hierarchy for Main Window Class

Main Window

	- Evaluation console

		- Engine

	- Command line

		- Parser

	- Command history

		- Parser

	- SLogo graphic window

		- Turtle

		- Turtle Path

		- Color

		- Reference Grid

	- Reset

UI Mockup:
![UI mockup sketch] (https://raw2.github.com/duke-compsci308-spring2014/slogo_team12/master/design/UISketch.png?token=5981803__eyJzY29wZSI6IlJhd0Jsb2I6ZHVrZS1jb21wc2NpMzA4LXNwcmluZzIwMTQvc2xvZ29fdGVhbTEyL21hc3Rlci9kZXNpZ24vVUlTa2V0Y2gucG5nIiwiZXhwaXJlcyI6MTM5MzU3MDk5Mn0%3D--331bf95ec9d01ee49cb79d27409b9d3381ec7d01)

Example Code (Pseudo-Code):
```
//User Input: “fd 50”
//GUI:
i
f(parser.parseCommand(userInput)){ //rejection of command here due to improper syntax will throw an exception in the console and not execute
	clearTextBox();
	addCommandToHistory(userInput);
}

//Parser:
boolean parseCommand(String s){
	if(simpleCommand){
		return parseSimple(String s);
	}
	if(complexCommand){
//		...
	}
}

boolean parseSimpleCommand(String s){
	obtain command
engine.obey(turtleChange change) //Overload this method and let it be part of the turtle’s role. Simple commands can be issued directly to turtle and handled by GUI
}
engine.obey{
	turtle.obey(command)
}
turtle.obey{
	offsets()
}
```

We discussed various alternatives in coming up with this design. For example, we had initially discussed a method of moving the turtle forward that did not utilize the abstract turtle data structure for the class. Instead, we had initially thought it would be best to write a class for every command. However,  shown above, we ended up implementing a different method for Turtle Commands. Our initial idea was to have a ForwardCommand be created and then be added to a queue, and then the Engine would handle running that ForwardCommand to manipulte the TurtlePhysicalObject. Instead, we decided to implement a Turtle Data Structure that would be responsible for running a TurtleCommand. This TurtleCommand is based upon offsets. 
We also altered the way that Advanced Commands are run, and instead of writing a class for each type of AdvancedCommand, we decided to utilize a method that would digest diverse advanced commands into queues of simple commands. 
We decided that this would allow us to have more elegant of a hierarchy, and also allow for much more flexibility in terms of being able to add new Turtle Commands and Advanced Commands easily. 