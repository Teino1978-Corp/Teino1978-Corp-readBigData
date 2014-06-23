
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ReadBigDataDemo02 {
	static String filePath = "/media/xqcao/DC3C013E62AED233/ubuntuFile/temp/tempwikipedia0.txt";
	static String saveFile2txt = "/media/xqcao/DC3C013E62AED233/ubuntuFile/temp/b.txt";
	static BufferedReader br = null;
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		getWordFrequency(filePath);
		long end = System.currentTimeMillis();
		System.out.println("time cost: "+(end-start));
		}

	private static void getWordFrequency(String filePath) throws IOException {
		br = new BufferedReader(new FileReader(filePath));	
		String line = "";
		Map<String, Integer> myMap = new HashMap<String, Integer>(); 
		while((line=br.readLine()) != null) {
			String[] abc = line.split(" ");
			for(int i=0; i<abc.length; i++){
				if(!myMap.containsKey(abc[i])){
					myMap.put(abc[i], 1);
				} else{
					myMap.put(abc[i], myMap.get(abc[i])+1);
				}
			}			
		}
		Iterator<String> it = myMap.keySet().iterator();
		while(it.hasNext()){
	            String key = (String) it.next();
	            Integer v = (Integer) myMap.get(key);
	           // System.out.println("key="+key+" v="+ v);
	    }
		 List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(myMap.entrySet());
		 Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			 public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {  
	                return (o2.getValue()).compareTo(o1.getValue());  
	            } 	
		});
		 /*
		 for(Entry<String, Integer> a:list){
			 System.out.println(a.getKey()+"  "+a.getValue());
		 }
		*/
			try {
					BufferedWriter out = new BufferedWriter(new FileWriter(saveFile2txt));
					for(int i =0; i<list.size(); i++) {
						out.write(list.get(i).getKey() + "  " + list.get(i).getValue());
						out.newLine();
					}
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
}