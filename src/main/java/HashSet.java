import java.util.Set;

public class HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString = "fdsjsfgfdkgffgewq";
		String result = wordCount(testString);

	}

	public static String wordCount(String input)

	{

		System.out.println(input);

		// Create a HashSet to store the unique characters
		Set<Character> uniqueChars = new java.util.HashSet<Character>();

		// Loop through the characters in the string
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			// Add the character to the HashSet
			uniqueChars.add(c);
		}

		// Loop through the HashSet and print the counts for each character
		for (char c : uniqueChars) {
			int count = 0;

			// Loop through the characters in the string again and count the occurrences of
			// the current character
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == c) {
					count++;
				}
			}

			if(count>1)
			System.out.println(c + "=" + count);

		}
		return null;
	}
}
