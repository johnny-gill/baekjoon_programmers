import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String sentence = br.readLine();
    	sentence += " ";
    	Stack<Character> stack = new Stack<>();
    	StringBuilder sb = new StringBuilder();
    	
    	boolean isTag = false;
    	for (int i = 0; i < sentence.length(); i++) {
    		char ch = sentence.charAt(i);
    		if (ch == '<' || ch == '>') {
    			pop(stack, sb);
    			isTag = (ch == '<') ? true : false;
    			sb.append(ch);
    		} else if (isTag) {
    			sb.append(ch);
    		} else if (ch == ' ') {
    			pop(stack, sb);
    			sb.append(ch);
    		} else {
    			stack.push(sentence.charAt(i));
    		}
    	}
    	
    	System.out.println(sb);
	}

	private static void pop(Stack<Character> stack, StringBuilder sb) {
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
	}
}