import java.io.IOException;




public class ReadBigDataDemo02 {
	static String filePath = args[0];
	static String saveFile2txt = args[1];
	
	
	public static void main(String[] args) throws IOException{
		long start = System.currentTimeMillis();
		CountFrequency.getWordFrequency(filePath,saveFile2txt);
		long end = System.currentTimeMillis();
		System.out.println("time cost: "+(end-start));
		}

	
}
