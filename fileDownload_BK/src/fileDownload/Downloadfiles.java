package fileDownload;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import net.sf.json.JSONObject;

public class Downloadfiles extends Thread{
	public String downloadurl;
	
	public Downloadfiles() {
		
	}
	
	public Downloadfiles(String downloadurl)
	{
		this.downloadurl = downloadurl;
	}
	
	public ArrayList<String> list = new ArrayList();
	public ArrayList<String> listUri = new ArrayList();
	
	public void DownloadFilesUri() throws IOException
	{
		URL url = new URL(downloadurl);
		URLConnection conn = url.openConnection();
		int fileSize = conn.getContentLength();
		byte[] buffer = new byte[fileSize];
		BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
		
		if (bis.read(buffer, 0, fileSize) != fileSize) {
			System.out.println("Error: when to load image url");
		}
		String str = new String(buffer, "UTF-8");  
		System.out.println(str);
		
		JSONObject jsonObject = JSONObject.fromObject(str);
		System.out.println(jsonObject);
		System.out.println(jsonObject.get("msg"));;
		System.out.println(jsonObject.getJSONArray("msg").getString(0));

		for (int i = 0; i <jsonObject.getJSONArray("msg").length(); ++i)
			list.add(jsonObject.getJSONArray("msg").getString(i));
		
	    System.out.println("1111111");
	}
	
	public void DownloadOneFile(String uri, String fileName) throws IOException {
		System.out.println(uri);
		// listUri.add(uri);
		
		URL url = new URL(uri);
		URLConnection conn = url.openConnection();
        conn.setConnectTimeout(5 * 1000);  
		int fileSize = conn.getContentLength();
		System.out.println("fileSize = " + String.valueOf(fileSize));
		byte[] buffer = new byte[fileSize];
		BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
		
		File file = new File(fileName);
		int size = 0;
		FileOutputStream outStream = new FileOutputStream(file);;
		//DataOutputStream outStream = new DataOutputStream(new FileOutputStream("xxxx.png"));
		while((size = bis.read(buffer, 0, fileSize)) >0 )
		{
			System.out.println("size = " + String.valueOf(size));
			outStream.write(buffer, 0, size); 
			outStream.flush();
		}
        //¹Ø±ÕÊä³öÁ÷  
		outStream.close();  
	}
	
	public void ParseUrl() throws IOException{
		for (int i = 0; i < list.size(); ++i) {
			String uri = "http://" + Config.IP + ":" + Config.PORT + "/" + list.get(i) + "?" + Config.TOKEN + "&" + Config.DATABASE;
			System.out.println(uri);
			listUri.add(uri);
			
		}
	}
	
	public void DownloadAllFiles() throws IOException {
		for (int i = 0; i < listUri.size(); ++ i) {
			
			String fileName = String.valueOf(list.get(i)).substring(String.valueOf(list.get(i)).lastIndexOf("/")+1);
			System.out.println("2222 file name = " + fileName);
			DownloadOneFile(String.valueOf(listUri.get(i)), fileName);
		}
	}
	
	@Override
    public void run() {
		try {
			DownloadFilesUri();
			ParseUrl();
			if (listUri.size() >= 20) {
				int delta = listUri.size() / Config.THREAD_NUM;
				DownloadFilesThread[] threads = new DownloadFilesThread[Config.THREAD_NUM];
				
				for (int i = 0; i < threads.length; ++ i) {
                    threads[i] = new DownloadFilesThread(listUri, i, delta);
                    threads[i].setName("Thread:" + i);
                    threads[i].start();
                }
				
				boolean is_finished = true;
				for (int i = 0; i < threads.length; ++i) {
					threads[i].join();
				}
			}
		}
		catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
