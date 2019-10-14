package com.ilegra.npsingest.service;

import java.io.IOException;
import java.io.InputStream;

import com.ilegra.npsingest.io.FileStream;
import com.ilegra.npsingest.io.LogFileStream;

public class IngesterService {
	
	private FileStream stream;
	
	public IngesterService() {
		stream = new LogFileStream();
	}
	
	public void ingest(InputStream file, String fileInfo) throws IOException {
		stream.write(file, fileInfo);
	}

}
