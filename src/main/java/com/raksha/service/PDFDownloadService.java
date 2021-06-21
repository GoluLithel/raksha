package com.raksha.service;

public interface PDFDownloadService {
	
	String API_URL = "https://v2018.api2pdf.com/chrome/html";
	String API_KEY = "4b213d69-78c0-4472-9578-5a305f7c6306";
	
	String getPDFDownloadURL(int policyNumber);
	
}
