package com.ilegra.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;

import com.ilegra.npsingest.service.IngesterService;

public class FileStreamTest { 
	
	private final String FILE_OUT_PUT_NAME = "/test.log";
	private InputStream file;
	private IngesterService service;
	
	@Before
	public void createALogFile() throws Exception{
		service = new IngesterService();
		String string = "/pets/exotic/cats/10 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 1";
        file = new ByteArrayInputStream(string.getBytes(Charset.forName("UTF-8")));
		
	}

	@Test
	public void shouldConvertFileIntoStringList() throws Exception{
		service.ingest(file, FILE_OUT_PUT_NAME);
	}
	
}
