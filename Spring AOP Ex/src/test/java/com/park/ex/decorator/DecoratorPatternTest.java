package com.park.ex.decorator;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		
		// noDecorator 
//		Component component= new RealComponent(); 
//		
//		DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(component);
//		
//		decoratorPatternClient.excute();
		
		
		
		// Decorator 1
//		Component component= new RealComponent(); 
//		
//		DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(new MessageDecorator(component));
//		
//		decoratorPatternClient.excute();
		
		
		// Decorator 2
		Component component= new RealComponent(); 
		Component messageDecorator = new MessageDecorator(component);
				
		DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(new TimeDecorator(new MessageDecorator(component)));
		decoratorPatternClient.excute();
		
	}

}
