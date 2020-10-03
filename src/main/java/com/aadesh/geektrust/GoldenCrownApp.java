package com.aadesh.geektrust;

import static com.aadesh.geektrust.constants.AppConstants.RULER_NAME;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.imageio.IIOException;

import com.aadesh.geektrust.dto.Kingdom;
import com.aadesh.geektrust.service.RegisterKingdom;
import com.aadesh.geektrust.service.TameOfThrones;
import com.aadesh.geektrust.service.TameOfThronesImpl;
import com.aadesh.geektrust.utils.FileParser;
import com.aadesh.geektrust.utils.FileParserFactory;

/**
 * Description - This is the main executable class, that is reponsible for
 * starting the whole process of crowning a kingdom.
 * 
 * 
 * @author Aadesh Singhai
 * @version 0.0.1
 */

public class GoldenCrownApp {

	/**
	 * Description - This is main method of the Program, responsible for - 1.
	 * Reading the input file path. 2. Executing the File Parser, to read the
	 * contents of the file. 3. Starting the process of registering the kingdoms. 4.
	 * Starting the process of alliance seeking by a kingdom. 5. Calling for
	 * printing of the ruler.
	 * 
	 * @param args - Command line arguements passed, here File path passed that will
	 *             contain the kingdom messages.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException, FileNotFoundException {
		try {
			String uri = args[0];
			if (uri.length() == 0)
				throw new IIOException("No File Path Found");
			FileParser fileParser = FileParserFactory.INSTANCE.getFileParser("txt", uri);
			LinkedHashMap<String,String> input = fileParser.parseFile();
			
			RegisterKingdom registerKingdom = new RegisterKingdom();
			List<Kingdom> kingdomList = registerKingdom.getKingdoms();
			
			Kingdom ruler = null;
			for ( Kingdom temp : kingdomList) {
				String kingdomName = temp.getName();
				if ( kingdomName.equalsIgnoreCase(RULER_NAME) ) {
					ruler = temp;
					kingdomList.remove(temp);
					break ;
				}
			}
		
			TameOfThrones tameOfThrones = new TameOfThronesImpl();
			List<Kingdom> allies = tameOfThrones.allegianceInitializer(kingdomList, input);
			
			ruler.setAllies(allies);
			tameOfThrones.displayRuler(ruler);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
