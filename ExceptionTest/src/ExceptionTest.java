
public class ExceptionTest { 
private static void test(int x) throws Exception{ 
System.out.println("Calling with "+x); 
if(x>5) { 
System.out.println("Output "+x); 
} 
else{ 
try{ 
test(x+1); 
} 
catch(Exception e){ 
System.out.println("Exception on "+x); 
} 
throw new Exception(); 
} 
} 
public static void main(String args[]){ 
try{ test(3); } catch(Exception e){} 
} 
} 
