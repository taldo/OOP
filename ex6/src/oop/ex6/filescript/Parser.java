package oop.ex6.filescript;
import java.io.*;
import java.util.*;

import oop.ex6.filescript.Exceptions.BadCommandFileException;
import oop.ex6.filescript.Section.Section;
import oop.ex6.filescript.Section.SectionFactory;
import oop.ex6.filescript.Section.Filter.FilterAll;
import oop.ex6.filescript.Section.SectionFactory.TempSection;

/**
 * This class takes a given command file and reads it. reading the command file
 * is basically going over the file line by line, and make sure that the 
 * expected line structure was given and that the program will not encounter 
 * any fatal errors that would make it crash.
 * @author taldovrat1988
 *
 */
public class Parser {
	
	//the files that are given by the user.
	private File sourceDir, commandsFile;
	
	/*
	 * an array of TempSection objects that will later on be used to create the
	 * the real sections.
	 */
	private ArrayList<TempSection> structure;
	//a SectionFactory object for creating the sections.
	private SectionFactory sectionFac;
	
	/**
	 * Creates a new Parser Object from two given input files.
	 * @param sourceDir - The dir to be ordered and filtered.
	 * @param commandsFile - The command file that says which files are 
	 * accepted and on which order they are printed.
	 */
	public Parser(File sourceDir, File commandsFile) {
		
		this.sourceDir = sourceDir;
		this.commandsFile = commandsFile;
		//initialize the structure.
		this.structure = new ArrayList<TempSection>();
		
	}
	
	/**
	 * This method goes over the file and makes sure that its structure is ok.
	 * The structure created during this method runtime is later on used to
	 * build the different sections.
	 * @return - true if structure is ok and it was created, false if there was
	 * a problem during the runtime of the method. 
	 */
	public boolean createStructure() {
		
		//create empty arraylist for the lines from the file
		ArrayList<String> linesOfCommandFile = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(this.commandsFile);
			while (scanner.hasNextLine()) {
				linesOfCommandFile.add(scanner.nextLine());
			}
			
			//to create the SectionFactory object.
			ListIterator<String> linesIter = linesOfCommandFile.listIterator();
			
			this.sectionFac = new SectionFactory(linesIter);
			
			return true;	
		}
		catch(FileNotFoundException | BadCommandFileException ex) {
			System.out.println(ex.getLocalizedMessage());
			return false;
		}
		
	}
	
	/**
	 * After the structure was created successfully, this method creates the 
	 * sections and prints the filtered and ordered files. 
	 */
	public void createSections() {
		/*
		 * creates and iterator from the tempSection array that is used to
		 * iterate over the tempSections and create the sections one by one.
		 */
		ListIterator<TempSection> tempSectionIter = this.sectionFac.tempSections.listIterator();
		
		File[] dir;
		//while there are more sections:
		while (tempSectionIter.hasNext()) {
		
			Section sec = this.sectionFac.createSection(tempSectionIter.next());
			//get list of files filtered by the specific section file.
			dir = this.sourceDir.listFiles(sec.getFilter());
			//Sort the file array to the given order of the section
			Arrays.sort(dir, sec.getOrder());
			//print only the files.
			for (File file:dir) {
				if (file.isFile()) 
					System.out.println(file.getName());
			}	
		}	
	}
}