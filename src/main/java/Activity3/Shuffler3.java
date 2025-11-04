package Activity3;

import java.util.Arrays;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler3 {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(arePermutations(values1, values2));
		
		for(int i = 0; i <= 9; i++) {
			System.out.println(flip());
		}
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int mid = values.length / 2;
		int[] left = new int[mid];
		int[] right = new int[values.length - mid];
		for(int i = 0; i < mid; i++) {
			left[i] = values[i];
		}
		for(int j = mid; j < values.length; j++) {
			right[j - mid] = values[j];
		}
		
		for(int i = 0; i < left.length; i++)
			values[2 * i] = left[i];
		for(int j = 0; j < right.length; j++)
			values[2 * j + 1] = right[j];
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		
		for(int i = values.length - 1; i > 0; i--) {
			int rand = (int) (Math.random() * (i + 1));
			int temp = values[i];
			
			values[i] = values[rand];
			values[rand] = temp;
		}
		
	}
	
	public static String flip() {
		if((int) (Math.random() * (2+1)) != 2)
			return "heads";
		return "tails";
	}
	
	public static boolean arePermutations(int[] a1, int[] a2) {
		int l1 = a1.length;
		if(l1 == a2.length) {
			Arrays.sort(a1);
			Arrays.sort(a2);
			for(int i = 0; i < l1; i++) {
				if(a1[i] != a2[i])
					return false;
			}
			return true;
		}
		
		return false;
	}
}
