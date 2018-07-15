/*
 * Metodi Avanzati di Programmazione
Corso di Laurea in Informatica
Anno Accademico 2015/2016
Prova scritta del 12/04/2017 ore 9:00-12:00
1) Fornire le specifiche algebriche (semantiche e di restrizione) in forma di equazioni per il tipo astratto Colonna di cui si forniscono le seguenti specifiche sintattiche:
Tipi:
Colonna, Mattone, Intero, Booleano
Operatori:
creaColonna()Colonna //istanzia una colonna inizialmente vuota
aggiungiMattone(Colonna, Mattone) Colonna // aggiunge un mattone in testa ad una colonna
rimuoviMattone(Colonna) Colonna //rimuove il Mattone in testa alla Colonna
leggiMattone (Colonna)  Mattone // restituisce il mattone sulla sommità della colonna
contaMattone(Colonna) Intero //restituisce il numero dei mattoni nella colonna
filtra(Colonna) Colonna //restituisce la colonna ottenuta selezionando solo i mattoni in posizione dispari
maggiore(Colonna, Colonna)Boolean //restituisce vero se le due colonne hanno uguale numero di mattoni e ciascun mattone della prima colonna ha diametro maggiore del mattone nella corrispondente posizione nella seconda colonna, falso altrimenti
(7 punti)
2) Descrivere la astrazione di funzione. Illustrare la anomalia con cui alcuni linguaggi di programmazione realizzano tale astrazione. Riportare esempi a supporto dei concetti esposti.
(5 punti)
3) Descrivere esaustivamente il modello concettuale di metaclasse nel paradigma OO e come e se tale modello concettuale è supportato dalle primitive del linguaggio Java.
(7 punti)
4) Commentare l'uso della serializzazione in Java. Mostrare i passi necessari alla serializzazione di oggetti istanza della classe Colonna (collezione di Mattoni). Modellare la classe Mattone e la classe Colonna. Estendere la classe Colonna con i metodi per il salvataggio e il caricamento dell'oggetto istanza di Colonna. Scrivere un main che mostri l’uso di tali metodi.
(7 punti)
5) Descrivere il meccanismo di RMI in Java. Usare lo stesso per scrivere
a. un server che metta a disposizione il metodo somma(Intero,Intero)Intero e il metodo potenza(Intero,intero)Intero
b. un JFrame che permetta l'inserimento di due interi, invochi il metodo remoto somma o potenza (in base alla decisione dell’utente) passando tali interi e visualizzi il risultato.
(7 punti)
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class colonna.
 */
public class colonna implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		colonna c= new colonna();
		int i=0;
		while(i<10)
		{
			mattone m=new mattone();
			m.setDiametro(i);
			//m.visualizzaMattone();
			c.aggiungiMattone(m);
			i++;
		}
		c.save();
		c.load();
		c.vedicolonna();

	}


	/** The costruzione. */
	private List<mattone> costruzione;

	/** The creata. */
	private boolean creata;


	/**
	 * Instantiates a new colonna.
	 */
	colonna()
	{	setCreata(false);
		creacolonna();
	}


	/**
	 * Creacolonna.
	 */
	public void creacolonna()
	{
	    //si inizializza la lista costruzione come array
	    costruzione = new ArrayList<>();
		setCreata(true);
	}


	/**
	 * Aggiungi mattone.
	 *
	 * @param e the e
	 */
	public void aggiungiMattone(mattone e)
	{
		costruzione.add(e);
	}


	/**
	 * Leggi mattone.
	 *
	 * @return the mattone
	 */
	public mattone leggiMattone()
	{
		return costruzione.get(this.contaMattone()); //restituisce l'ultimo mattone nella pos max
	}


	/**
	 * Checks if is creata.
	 *
	 * @return true, if is creata
	 */
	public boolean isCreata() {
		return creata;
	}


	/**
	 * Sets the creata.
	 *
	 * @param creata the new creata
	 */
	public void setCreata(boolean creata) {
		this.creata = creata;
	}


	/**
	 * Rimuovi mattone.
	 */
	public void rimuoviMattone()
	{
		costruzione.remove(this.contaMattone());
	}


	/**
	 * Conta mattone.
	 *
	 * @return the int
	 */
	public int contaMattone()
	{
		return costruzione.size();
	}


	/**
	 * Filtra.
	 *
	 * @return the colonna
	 */
	public colonna filtra()
	{
		colonna obj = new colonna () ;
		int i=0;
		while(i<this.contaMattone())
		{
			if(i/2==0)
			{
				i++;
			}
			else
			{
				obj.aggiungiMattone(costruzione.get(i));
			}
			i++;
		}
		return obj;
	}


	/**
	 * Maggiore.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean maggiore(colonna obj)
	{
		boolean flag = false;
		int i=0;
		if(obj.contaMattone()> this.contaMattone() || obj.contaMattone()< this.contaMattone())
		{
			return flag;
		}
		else
		{
			while(i<obj.contaMattone())
			{
				if(this.leggiMattone().getDiametro() < obj.leggiMattone().getDiametro() )
				{
					return flag;
				}
				i++;
			}
		}
		flag=true;	//se fin'ora non sono uscito sarà vero
		return flag;
	}


	/**
	 * Vedicolonna.
	 */
	public void vedicolonna()
	{
		int i=0;
		while(i<this.contaMattone())
		{
			System.out.println(costruzione.get(i));
			i++;
		}
	}


	/**
	 * Save.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void save() throws FileNotFoundException, IOException
	{
		String filename = "colonna.dat";
		// Serialization
		try
		{
			//Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(this);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}


	}


	/**
	 * Load.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void load() throws FileNotFoundException, IOException
	{
		this.creacolonna();	//invochiamo il costruttore di colonna così this si azzera
		String filename = "colonna.dat";	//dove salveremo file
		colonna c1= new colonna();		//colonna di passaggio
		// Deserialization
		try
		{
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			c1= (colonna)in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
			//abbiamo deserializzato l'oggetto, ma se non facciamo le assegnazioni lo perdiamo
			//ecco fatto!

			this.costruzione=c1.costruzione;
			this.creata=c1.creata;
		}

		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}

		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}
	}
}