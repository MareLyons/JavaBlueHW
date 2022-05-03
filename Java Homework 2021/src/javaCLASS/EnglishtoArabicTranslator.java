package javaCLASS;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.HashMap;

import com.sun.java.accessibility.util.Translator;

	public class EnglishtoArabicTranslator {
	
	 HashMap<String, String> translate = new HashMap<String, String>();

		
	public EnglishtoArabicTranslator() {
			try {
				BufferedReader in = new BufferedReader(
						new FileReader("EnglishToArabicDictionary.txt"));
				
				for(String line = in.readLine(); line !=null;line = in.readLine()) {
					translate.put(line, in.readLine());		
				}
				
				in.close();
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		
		public String ToString(String word) {
			return translate.get(word);
		}
			
		
		public static void main(String[] args)  {
			
			EnglishtoArabicTranslator test = new EnglishtoArabicTranslator();
			
			//System.out.print(test.translate);
			System.out.print(test.ToString("tax"));
			
		}
	}
	

