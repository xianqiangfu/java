package fileDownload;

import java.io.IOException;
import java.util.ArrayList;

public class DownloadFilesWrapper extends Thread {
	private String url;
	private ArrayList<String> listUrl = new ArrayList<String>();

	public DownloadFilesWrapper(String url) {
		this.url = url;
	}

	@Override
	public void run() {

		DownloadUrl loadUrl = new DownloadUrl(url);
		try {
			listUrl = loadUrl.GetUrl();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			if (listUrl.size() >= Config.IMAGE_COUNT) {
				System.out.println("多线程！！！");
				int delta = listUrl.size() / Config.THREAD_NUM;
				DownloadFilesThread[] threads = new DownloadFilesThread[Config.THREAD_NUM];

				for (int i = 0; i < threads.length; ++i) {
					threads[i] = new DownloadFilesThread(listUrl, i, delta);
					threads[i].setName("Thread:" + i);
					threads[i].start();
				}

				for (int i = 0; i < threads.length; ++i) {
					threads[i].join();
				}
			} else {
				System.out.println("单线程！！！");
				DownloadFiles dfile = new DownloadFiles(listUrl);
				dfile.DownloadAllFiles();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
