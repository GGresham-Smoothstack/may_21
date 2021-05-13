package com.ss.training.w1.d3.a1;

import java.io.File;

public class W1D3Assignment1 {

	public static void main(String[] args) {
		
		W1D3Assignment1 assign = new W1D3Assignment1();
		
		if(args.length >= 1) {
			System.out.println("contents of " + args[0] + ":");
			assign.listFilesInDirectory(args[0]);
		}else {
			System.out.println("contents of " + System.getProperty("user.dir") + ":");
			assign.listFilesInDirectory(System.getProperty("user.dir"));
		}

	}
	
	public void listFilesInDirectory(String directoryPath) {
		listFilesInDirectory(directoryPath, "");
	}
	
	public void listFilesInDirectory(String directoryPath, String appendTo) {
		File curDir = new File(directoryPath);

		if(curDir.exists()) {
			File[] files = curDir.listFiles();

			for(File file : files) {
				System.out.println(appendTo + file.getName());
				if(file.isDirectory()) {
					listFilesInDirectory(file.getPath(), appendTo + file.getName() + "/");
				}
			}
		}else {
			System.out.println("The given file path does not exist. Please input a valid path.");
		}
	}

}
