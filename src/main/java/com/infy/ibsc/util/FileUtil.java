package com.infy.ibsc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.infy.ibsc.vos.VO;

public class FileUtil {

	public static ArrayList<String> readFile(String Filename) {
		LogUtil logUtil = new LogUtil();
		logUtil.debug("Reading file: " + Filename);
		ArrayList<String> list = new ArrayList<String>();
		try {
			File file = new File(Filename);
			FileReader fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			fr.close();
		} catch (IOException e) {
			logUtil.error("Error reading file : " + e.getMessage());
		}
		logUtil.debug("List read=" + list);
		return list;

	}

	public static void writeFile(String Filename, String contents) {
		LogUtil logUtil = new LogUtil();
		logUtil.info("Writing file: " + Filename);
		try {
			FileWriter fileWriter = new FileWriter(Filename);
			fileWriter.append(contents);
			fileWriter.close();
		} catch (IOException e) {
			logUtil.error("Error writing file : " + e.getMessage());
		}
		logUtil.debug("File written successfully ... ");
	}

	public static void writeDataFile(String Filename, ArrayList list) {

		String contents = "";int count=0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			VO vo = (VO) iterator.next();count++;
			if(count ==1) {
				contents =vo.getTitle()+ "\r\n";
			}
			contents += vo.getLine() + "\r\n";

		}
		if (contents.length() > 1)
			writeFile(Filename, contents);
	}

	public static void main(String args[]) {
		FileUtil.readFile("D:/Workshop1/Demo5.txt");
		FileUtil.writeFile("D:/Workshop1/Demo1.txt", "This is dummy file\r\n123456");
	}
}
