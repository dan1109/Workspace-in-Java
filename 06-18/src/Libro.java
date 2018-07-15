/**
 * @author Daniele Bufalo
 * @version 1.0
 */
import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class Libro.
 */
public class Libro implements Comparable<Libro>{

/** The codice. */
private int codice;

/** The prezzo. */
private float prezzo;

/** The autore. */
private String autore;

/** The titolo. */
private String titolo;

/**
 * Instantiates a new libro.
 */
Libro()
{
	this.setAutore("NULL");
	this.setCodice(0000);
	this.setPrezzo(0);
	this.setTitolo("NULL");
}

/**
 * Gets the codice.
 *
 * @return the codice
 */
public int getCodice() {
	return codice;
}

/**
 * Sets the codice.
 *
 * @param codice the new codice
 */
public void setCodice(int codice) {
	this.codice = codice;
}

/**
 * Gets the prezzo.
 *
 * @return the prezzo
 */
public float getPrezzo() {
	return prezzo;
}

/**
 * Sets the prezzo.
 *
 * @param prezzo the new prezzo
 */
public void setPrezzo(float prezzo) {
	this.prezzo = prezzo;
}

/**
 * Gets the autore.
 *
 * @return the autore
 */
public String getAutore() {
	return autore;
}

/**
 * Sets the autore.
 *
 * @param autore the new autore
 */
public void setAutore(String autore) {
	this.autore = autore;
}

/**
 * Gets the titolo.
 *
 * @return the titolo
 */
public String getTitolo() {
	return titolo;
}

/**
 * Sets the titolo.
 *
 * @param titolo the new titolo
 */
public void setTitolo(String titolo) {
	this.titolo = titolo;
}

/**
 * Sets the.
 *
 * @param c the c
 * @param p the p
 * @param a the a
 * @param t the t
 */
public void set(int c, float p, String a, String t)
{
	setTitolo(t);
	setAutore(a);
	setPrezzo(p);
	setCodice(c);
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String toString()
{
	String string = null;
	string="Codice :"+this.getCodice()+", Autore:"+this.getAutore()+", Prezzo:"+this.getPrezzo()+", Titolo:"+this.getTitolo()+"\n";
	return string;
}

/**
 * Stampa libro.
 */
public void stampaLibro()
{
	System.out.println(this.toString());
}
/* (non-Javadoc)
 * @see java.lang.Comparable#compareTo(java.lang.Object)
 */
@Override
public int compareTo(Libro o) {
	// TODO Auto-generated method stub
	//ritorna il prezzo crescente
	 return (int) (this.getPrezzo() - o.getPrezzo());
}


/** The Libro name comparator. */
public static Comparator<Libro> LibroNameComparator= new Comparator<Libro>() {

	/**
	 * Compara per autore
	 */
public int compare(Libro lib1, Libro lib2) {

String libName1 = lib1.getAutore().toUpperCase();
String libName2 = lib2.getAutore().toUpperCase();

//ascending order
return libName1.compareTo(libName2);

//descending order
//return libName2.compareTo(libName1);
}

};
}
