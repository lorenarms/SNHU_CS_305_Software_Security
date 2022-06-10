package com.snhu.Module21;



import java.util.concurrent.atomic.AtomicLong;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	ExpressionParser parser = new SpelExpressionParser();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		
		Expression exp = parser.parseExpression(name);
		String message = (String) exp.getValue();
		System.out.println(message);
		return new Greeting(counter.incrementAndGet(), String.format(template, message));
	}
	
	@GetMapping("/number/{id}")
	public Greeting number(@PathVariable int id) {
		int[] myArray = {897, 56, 78, 90, 12, 123, 75};
	      String message = "Element in the given index is :: "+myArray[id];
	      System.out.println(message);
	      return new Greeting(counter.incrementAndGet(), String.format(template, message));
	}
	
}
