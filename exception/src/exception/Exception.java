package exception;

public class Exception { 
	int prova(int n) 
	{ 
		if (n == 0) return n+1; 
		else if (n == 1) throw new RuntimeException("Eccezione"); 
		else if (n==2) return prova(1); 
		else try { return prova(n-1); } 
		catch (RuntimeException e) 
			{ System.out.println(n+1); return n+1; } 
	} 
	
	public static void main (String args[]){ 
	System.out.println(new Exception().prova(5)); 
	} 
	} 

