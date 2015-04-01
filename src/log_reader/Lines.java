package log_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lines {

	String url;
	String date;
	String time;
	String value;
	
	public Lines(){
		url="url";
		date="date";
		time="time";
		value="value";
	}
	public static  String[] readLines (int firstLine, int numLines, String fileName) throws IOException{
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		String[] tmpLines=new String[1000];
		int tmp=0;
		while(reader.readLine()!=null){
			tmpLines[tmp]=reader.readLine();
			tmp++;
		}
		String[] lines=new String[numLines];
		for(int i=0;i<numLines;i++){
			lines[i]=tmpLines[firstLine];
			firstLine++;
		}
		reader.close();
		return lines;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int firstLine=Integer.valueOf(args[0]);
		int numLines=Integer.valueOf(args[1]);
		String fileName=args[2];
		String[] lines=readLines(firstLine,numLines,fileName);
		for(int i=0;i<lines.length;i++){
			System.out.println(lines[i]);
		}
	}

}
