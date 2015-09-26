package task;

import java.util.List;

/**
 * Created by zlatkov on 9/26/15.
 */
public class ConcordanceCalculator {
	private Paragraph paragraph;

	public ConcordanceCalculator(String text) {
		this.paragraph = new Paragraph(text);
	}

	public Concordance calculate() {
		Concordance result = new Concordance();
		List<Sentence> sentences = this.paragraph.extractSentences();
		int sentenceIndex = 0;
		for (Sentence sentence : sentences) {
			List<String> words = sentence.extractWords();
			for (String word : words) {
				result.addWord(word, sentenceIndex);
			}

			sentenceIndex++;
		}

		return result;
	}
}
