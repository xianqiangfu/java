package fileDownload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class DownloadFiles {

	private ArrayList<String> listUrl = new ArrayList<String>();

	public DownloadFiles(ArrayList<String> listUrl) {
		this.listUrl = listUrl;
	}

	public void DownloadOneFile(String uri, String fileName) throws IOException {
		// System.out.println(uri);

		URL url = new URL(uri);
		URLConnection conn = url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		int fileSize = conn.getContentLength();
		// System.out.println("fileSize = " + String.valueOf(fileSize));
		byte[] buffer = new byte[fileSize];
		BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

		File file = new File(fileName);
		int size = 0;
		FileOutputStream outStream = new FileOutputStream(file);
		;
		// DataOutputStream outStream = new DataOutputStream(new
		// FileOutputStream("xxxx.png"));
		while ((size = bis.read(buffer, 0, fileSize)) > 0) {
			// System.out.println("size = " + String.valueOf(size));
			outStream.write(buffer, 0, size);
			outStream.flush();
		}
		// ¹Ø±ÕÊä³öÁ÷
		outStream.close();
	}

	public void DownloadAllFiles() throws IOException {
		for (int i = 0; i < listUrl.size(); ++i) {

			String fileName = String.valueOf(listUrl.get(i)).substring(
					String.valueOf(listUrl.get(i)).lastIndexOf("/") + 1,
					String.valueOf(listUrl.get(i)).lastIndexOf("?"));
			// System.out.println("2222 file name = " + fileName);
			DownloadOneFile(String.valueOf(listUrl.get(i)), fileName);
		}
	}
}
