class Count extends Thread
{
	private String nome;
	private int Iterazione;
	private int tempo;
   Count(String n,int it,int temp)
   {
     super("MIO THREAD ESTESO CREATO");
    // System.out.println("THREAD CREATO" + this);
     start();
     this.nome=n;
     this.Iterazione=it;
     this.tempo=temp;
   }
   public void run()
   {
	   int i=0;
	   while(i<Iterazione)
	   {
		     try {
			 		Thread.sleep(tempo);
			 		System.out.println(nome+"     sec."+tempo/1000+"   iterazione:"+i+"/"+Iterazione);
			 	} catch (InterruptedException e) {
			 		// TODO Auto-generated catch block
			 		e.printStackTrace();
			 	}
		     if(Iterazione==999)	//loop infinito
		     {
		    	 i--;
		     }
		   i++;
	   }
   }
}
class MultithreadingDemo
{
   public static void main(String args[])
   {
	   Count a = new Count("A",15,1000);
	   Count b = new Count("B",15,2000);
	   Count c = new Count("C",999,3000);	
	   
	   a.start();
	   b.start();
	   c.start();
	   
   }
}