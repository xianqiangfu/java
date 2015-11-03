package fileDownload;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello,world");

		DownloadFilesWrapper run = new DownloadFilesWrapper(Config.START_URL);
		run.start();

	}

}
