

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;

	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;

	String adjectivesFile;
	String nounsFile;

	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;
	}


	/**
	 * Load the adjectives file and initialize that part of the generator.
	 */
	public void loadAdjectives() {
		adjectives = loadTxt(adjectivesFile);

		if (adjectives.length > 0) {
			adjectivesLoaded = true;
		} else {
			System.err.println("Error loading adjectives from: " + adjectivesFile);
		}
	}

	/**
	 * Load the nouns file and initialize that part of the generator.
	 */
	public void loadNouns() {
		nouns = loadTxt(nounsFile);

		if (nouns.length > 0) {
			nounsLoaded = true;
		} else {
			System.err.println("Error loading adjectives from: " + nounsFile);
		}
	}

	/**
	 * Return a string that capitalizes the first letter of s and lowercases the rest. So for example,
	 * capitalizeFirst('cat') returns 'Cat', and capitalizeFirst('CHUBBY CAt') returns 'Chubby cat'. Read the assignment carefully and think about how
	 * to implement this part of the code.
	 * Want to slice the string into different words, then capitalize first letter of each of those words
	 * @param s
	 * @return
	 */
	public String capitalizeFirst(String s) {
		String y = s.substring(0, 1).toUpperCase() + s.substring(1);
		return y;
	}


	/**
	 * Generate a name for your band consisting of two adjectives and one noun.
	 * Make sure to return "UNINITIALIZED" if the band name generator is not initialized correctly yet.
	 * @return the generated name or "UNINITIALIZED"
	 */
	public String generateName() {
		// Make sure we have adjectives and nouns to read
		if (!adjectivesLoaded || !nounsLoaded) {
			return "UNINITIALIZED";
		}

		int randIndexAdj1 = (int) (Math.random() * adjectives.length) + 1;
		int randIndexAdj2 = (int) (Math.random() * adjectives.length) + 1;
		int randIndexNoun = (int) (Math.random() * nouns.length) + 1;

		String adj1 = capitalizeFirst(adjectives[randIndexAdj1]);
		String adj2 = capitalizeFirst(adjectives[randIndexAdj2]);
		String noun = capitalizeFirst(nouns[randIndexNoun]);

		return adj1 + " " + adj2 + " " + noun;
	}


	/**
	 * This method loads a text file into a String array. It assumes the number of
	 * lines in the file is on the first line of the file itself.
	 *
	 * Note: you are not allowed to make changes to this method. You can use this method for
	 * loading text files in the other lab and course assignments as well.
	 *
	 * @param file
	 * @return
	 */
	private String[] loadTxt(String file) {
		String[] data = new String[0];
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			while((line = in.readLine()) != null)
			{
				data[i] = line;
				i++;

			}
		} catch (Exception e) {
			System.err.println("Problem while reading file: " + file);
			e.printStackTrace();
		}
		finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Problem closing file: " + file);
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	/**
	 * Returns the list of adjectives.
	 * @return
	 */
	public String[] getAdjectives() {
		return adjectives;
	}

	/**
	 * Returns the list of nouns.
	 * @return
	 */
	public String[] getNouns() {
		return nouns;
	}

	public static void main(String[] args) {
		// create a BandNameGenerator and initialize it
		BandNameGenerator gen = new BandNameGenerator("../../../../adjectives.txt", "../../../../nouns.txt");
		gen.loadAdjectives();
		gen.loadNouns();

		// generate and print 20 names for your band
		for (int i = 0; i < 20; i++) {
			System.out.println(gen.generateName());
		}
	}
}
