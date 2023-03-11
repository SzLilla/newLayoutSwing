package dep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import app.constant.AppConstants;


public class DataFileHandler {	
	private static DataFileHandler instance;
	
	private DataFileHandler() {
	}
	
	public static DataFileHandler getInstance() {
		if (instance == null) {
			instance = new DataFileHandler();
		}
		return instance;
	}

	/**
	 * 
	 * @param keyword ConfigPathType.FOLDER_WITH_LAYOUT_IMAGES.getKeyWord()
	 * @return
	 */
	public String getStringDataFromConfigFile(String keyword) {
		String result = new String();
		try {
			File configFile = new File(FileConstants.configFile);
			Scanner scanner = new Scanner(configFile);
			String regex = keyword + "," + ".+";

			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (Pattern.matches(regex, data)){
					String[] matcherParts = Pattern.compile(",").split(data);
					if (matcherParts.length >= 2){
						result = matcherParts[1];
					}
				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void writeTypeAndDataToFile(ConfigPathType type, String data) { // todo not overwrite
        try {
			File myFile = new File(FileConstants.configFile);
			myFile.createNewFile();

			FileWriter myWriter = new FileWriter(FileConstants.configFile);
            myWriter.write(type.getKeyWord() + "," + data + "\n");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void replaceKeyData(String keyword, String data) {
		try {
			BufferedReader file = new BufferedReader(new FileReader(FileConstants.configFile));
			StringBuffer inputBuffer = new StringBuffer();
			String line;
			String regex = keyword + "," + ".+";
			boolean found = false;

	
			while ((line = file.readLine()) != null) {
				System.out.println(line);
				if (Pattern.matches(regex, line)){
					System.out.println("matched!");
					inputBuffer.append(keyword + "," + data);
					inputBuffer.append('\n');
					found = true;
				} else {
					inputBuffer.append(line);
					inputBuffer.append('\n');
				}

			}
			
			if (!found){		
				System.out.println("Not found in file, so write it.");			
				inputBuffer.append(keyword + "," + data);
				inputBuffer.append('\n');
			}

			file.close();
			String inputStr = inputBuffer.toString();
	
			// write the new string with the replaced line OVER the same file
			FileOutputStream fileOut = new FileOutputStream(FileConstants.configFile);
			fileOut.write(inputStr.getBytes());
			fileOut.close();
	
		} catch (Exception e) {
			System.out.println("Problem reading file.");
		}
	}
}
