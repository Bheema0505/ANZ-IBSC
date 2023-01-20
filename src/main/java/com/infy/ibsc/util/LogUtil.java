package com.infy.ibsc.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogUtil {

	public static int FATAL = 1;
	public static int ERROR = 2;
	public static int WARN = 3;
	public static int INFO = 4;
	public static int DEBUG = 5;

	private int logLvl = 5;

	public void setLogLvl(int logLvl) {
		this.logLvl = logLvl;
	}

	public void log(int logLevel, String message) {
		if(logLevel == DEBUG)
			System.out.println(message);
		if (logLevel <= this.logLvl) {
			try {
				String Filename= IBConstants.PATH_LOG_FILE;
				FileWriter fileWriter = new FileWriter(Filename,true);
				fileWriter.append(new Date()+": "+message+"\r\n");
				fileWriter.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public void debug(String message) {
		this.log(DEBUG, "DEBUG: " + message);
	}

	public void warn(String message) {
		this.log(WARN, "WARNING: " + message);

	}

	public void error(String message) {
		this.log(ERROR, "ERROR: " + message);

	}

	public void info(String message) {
		this.log(INFO, "INFO: " + message);
	}

	public void fatal(String message) {
		this.log(FATAL, "FATAL: " + message);
	}
}
