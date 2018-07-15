/**
 * @author Daniele Bufalo
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Biblioteca.
 */
public class Biblioteca {

/** The biblioteca. */
private static List<Libro> biblioteca;

/** The e. */
private static Libro e;

/**
 * Instantiates a new biblioteca.
 */
Biblioteca()
{
	biblioteca=new ArrayList<Libro>();
}

/**
 * The main method.
 *
 * @param args the arguments
 */
public static void main(String args[])
{
Biblioteca a=new Biblioteca();	//inizializza una biblioteca nel main
a.AddElements(5);				//aggiungi elementi casuali in base al numero
Collections.sort(Biblioteca.biblioteca);	//: riordina per prezzo crescente!
System.out.print("\nOrdine per Prezzo:\n");	//messaggio
a.stampa();
System.out.print("\nOrdine per Autore:\n");	//messaggio
a.stampa();
biblioteca.sort(Libro.LibroNameComparator);	//comparator: per nome crescente
}

/**
 * Gets the biblioteca.
 *
 * @return the biblioteca
 */
public List<Libro> getBiblioteca() {
	return biblioteca;
}

/**
 * Gets the char for number. In ASCII Code
 *
 * @param i the i
 * @return the char for number
 */
private String getCharForNumber(int i) {
    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
}

/**
 * Adds num elements.
 *
 * @param num the num
 */
public void AddElements(int num)
{
	int max=20;	//qui si stabilisce il valore massimo rand
	int min=1;  //qui si stabilisce il valore minimo  rand

	int i=0;
	while(i<num)
	{
		Libro e = new Libro();
		int codice= this.casuale(min, max);
		float prezzo=this.casuale(min, max);
		String autore=this.getCharForNumber(this.casuale(min, max))+"autore";
		String titolo=this.getCharForNumber(this.casuale(min, max))+"titolo";
		e.set(codice,prezzo,autore,titolo);
		Biblioteca.biblioteca.add(e);
		i++;
	}
}

/**
 * Casuale.
 * return a casual number from min and max
 *
 * @param min the min
 * @param max the max
 * @return the int
 */
public int casuale(int min,int max)
{
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
}

/**
 * Stampa biblioteca.
 */
public void stampa()
{
	int i=0;
	while(i<Biblioteca.biblioteca.size())
	{
		System.out.print("Elemento N."+(i+1)+":   "+biblioteca.get(i).toString());
		i++;
	}
}

/**
 * Sets the biblioteca.
 *
 * @param biblioteca the new biblioteca
 */
public void setBiblioteca(List<Libro> biblioteca) {
	Biblioteca.biblioteca = biblioteca;
}

/**
 * Gets the e.
 *
 * @return the e
 */
public static Libro getE() {
	return e;
}

/**
 * Sets the e.
 *
 * @param e the new e
 */
public static void setE(Libro e) {
	Biblioteca.e = e;
}

}
