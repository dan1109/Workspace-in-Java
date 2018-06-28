class Prova 
{ 
int testEccezione(int n) 
{ 
if (n < 0) throw new RuntimeException("Eccezione0"); 
else if (n == 10) throw new RuntimeException("Eccezione1"); 
else try { return testEccezione(n-2); } 
catch (RuntimeException e) { 
System.out.println(e.toString()); 
return n; 
} 
} 
public static void main(String[] args) 
{ 
System.out.println(new Prova().testEccezione(14)); 
System.out.println(new Prova().testEccezione(-14)); 
System.out.println(new Prova().testEccezione(4)); 
} 
}
