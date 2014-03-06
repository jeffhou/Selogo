package commands.commandFactories;


public class CommandFactoryMaker {
	//TODO: Modify this to use reflection
	private static CommandFactoryInterface cf =null;
	
	
	static CommandFactoryInterface getFactory(String choice){
		if(choice.equals("math")){
			cf= MathCommandFactory.getInstance();
			
		}else if(choice.equals("turtle")){
				cf= TurtleCommandFactory.getInstance();
				
			} else if (choice.equals("advanced")) {
				cf = AdvancedCommandFactory.getInstance();
				
			} else if (choice.equals("boolean")) {
				cf = BooleanCommandFactory.getInstance();
			}
					return cf;
	}

}
