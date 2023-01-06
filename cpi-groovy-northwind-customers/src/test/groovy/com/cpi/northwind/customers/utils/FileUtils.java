package com.cpi.northwind.customers.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.cxf.helpers.IOUtils;

public class FileUtils {
	public static String readFileToString(String path, Class aClazz) throws IOException {

		try (InputStream stream = aClazz.getClassLoader().getResourceAsStream(path)) {
			if (stream == null) {
				throw new IOException("Stream is null");
			}
			return IOUtils.toString(stream, String.valueOf(StandardCharsets.UTF_8));
		}
	}
}
