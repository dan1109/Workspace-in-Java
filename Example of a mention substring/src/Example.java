
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String mention = "ciao, ciga <@vivalavita> sono <bauuu> <gay> ciao ciao.";
		 String str =  mention.substring(mention.lastIndexOf("<@") + 1, mention.indexOf(">"));
		 System.out.println(str);
	}

}
