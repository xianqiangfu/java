package fileDownload;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello,world");
		
		//single thread , work ok
		/*
		Downloadfiles downloadfiles = new Downloadfiles("http://localhost:8072/loadimguri/CA1111?access_token=1&database=test");
		downloadfiles.DownloadFilesUri();
		downloadfiles.ParseUrl();
		downloadfiles.DownloadAllFiles(); */
		
		// mutil threads
		Downloadfiles downloadfiles = new Downloadfiles("http://localhost:8072/loadimguri/CA1111?access_token=1&database=test");
		System.out.println("Hello,world2");
		downloadfiles.start();
		// downloadfiles.DownloadOneFile("http://localhost:8072/loadimg/CA1111/QQ20150728163748.png?access_token=1&database=test", "1.png");
		
	}

}


 
