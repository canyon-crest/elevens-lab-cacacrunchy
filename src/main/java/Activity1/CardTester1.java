package Activity1;
/**
 * This is a class that tests the Card class.
 */
public class CardTester1 {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card1 c0 = new Card1("Jack", "Spades", 10);
		Card1 c1 = new Card1("Queen", "Hearts", 11);
		Card1 c2 = new Card1("Jack", "Spades", 10);
		
		System.out.println(c1.toString());
		System.out.println(c0.matches(c2));
		
	}
}
