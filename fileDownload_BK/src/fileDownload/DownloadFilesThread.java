package fileDownload;

import java.io.IOException;
import java.util.ArrayList;

public class DownloadFilesThread extends Thread {
	public int start = 0;
	public int end = 0;
	public ArrayList list;
	
	public DownloadFilesThread(ArrayList list, int thread_id, int delta)
	{
		this.list = list;
		this.start = thread_id * delta;
		this.end   = (thread_id  + 1) * delta;
		
		if (thread_id == Config.THREAD_NUM - 1) {
			this.end = list.size();
		}
	}
	
	@Override
    public void run() {
		Downloadfiles down = new Downloadfiles();
		for (int i = start; i < end; ++ i) {
			String fileName = String.valueOf(list.get(i)).substring(String.valueOf(list.get(i)).lastIndexOf("/") + 1, String.valueOf(list.get(i)).lastIndexOf("?"));
			System.out.println("fileName = " + fileName);
			try {
				System.out.println("1111 uri = " + String.valueOf(list.get(i)));
				down.DownloadOneFile(String.valueOf(list.get(i)), fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
