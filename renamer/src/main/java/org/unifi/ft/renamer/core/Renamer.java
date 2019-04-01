package org.unifi.ft.renamer.core;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;

public class Renamer {
	
	private Reader r;
	
	private String root;
	
	public Renamer(String filename, String directoryName) {
		r = new Reader(filename);
		this.root = directoryName;
	}
	
	public void rename() throws IOException {
		Hashtable<String, BigInteger> table = r.readFile();
		Enumeration<String> keys = table.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String s = root + "/" + key + ".pdf";
			File oldFile = new File(s);
			System.out.println(oldFile);
			File newFile = new File(root+"/"+table.get(key).toString()+".pdf");
			System.out.println(newFile);
			System.out.println(oldFile.renameTo(newFile));
		}
	}
	
}
