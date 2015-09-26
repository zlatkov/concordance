package task;

public class Main {

    public static void main(String[] args) {

		String text = "A \"concordance\" is an alphabetical list of the words present in a text with a count of how\n" +
				"often each word appears and citations of where each word appears in the text (e.g., page\n" +
				"number). Write a program -- in the programming language of your choice -- that will\n" +
				"generate a concordance of an arbitrary text document written in English: the text can be\n" +
				"read from stdin, and the program should output the concordance to stdout or a file. For\n" +
				"each word, it should print the count and the sorted list of citations, in this case the\n" +
				"zero-indexed sentence number in which that word occurs. You may assume that the input\n" +
				"contains only spaces, newlines, standard English letters, and standard English punctuation\n" +
				"marks.";

		ConcordanceCalculator calculator = new ConcordanceCalculator(text);
		Concordance concordance = calculator.calculate();
		System.out.println(concordance.toString());
    }
}
