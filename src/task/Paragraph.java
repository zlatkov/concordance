package task;

import java.util.*;
import java.util.regex.Pattern;

public class Paragraph extends TextElement {
	// Terminators are ".", "!", "?"  or they can be wrapped ".)", "!]" etc.
	private static final Pattern TERMINATORS_PATTERN = Pattern.compile("[.?!][)}\\]]?");
	// Abbreviations are special words such as e.g., i.e., dr.
	private static final Pattern ABBREVIATIONS_PATTERN = Pattern.compile("e\\.g\\.|mr\\.|i\\.e\\.|dr\\.");

	public Paragraph(String text) {
		super(text);
	}

	public List<Sentence> extractSentences() {
		List<TextMatch> possibleLineEndings = Utils.findMatches(this.getText(), TERMINATORS_PATTERN);
		List<TextMatch> abbreviations = Utils.findMatches(this.getText(), ABBREVIATIONS_PATTERN);

		int textPosition = 0;
		List<Sentence> sentences = new ArrayList<>();
		for (TextMatch ending : possibleLineEndings) {
			if (isValidSentenceEnd(ending, abbreviations)) {
				String sentenceText = this.getText().substring(textPosition, ending.getEnd() + 1);
				Sentence sentence = new Sentence(sentenceText);
				sentences.add(sentence);

				textPosition = ending.getEnd() + 1;
			}
		}

		return sentences;
	}

	private static boolean isValidSentenceEnd(TextMatch ending, List<TextMatch> abbreviations) {
		for (TextMatch abbreviation : abbreviations) {
			if (ending.getStart() >= abbreviation.getStart() && ending.getEnd() <= abbreviation.getEnd()) {
				return false;
			}
		}

		return true;
	}
}
