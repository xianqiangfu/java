package fileDownload;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import net.sf.json.JSONObject;

public class DownloadUrl {
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<String> listUri = new ArrayList<String>();
	private String URL = null;

	public DownloadUrl(String downloadurl) {
		this.URL = downloadurl;
	}

	private void DownloadFilesUri() throws IOException {
		URL url = new URL(URL);
		URLConnection conn = url.openConnection();
		int fileSize = conn.getContentLength();
		byte[] buffer = new byte[fileSize];
		BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

		if (bis.read(buffer, 0, fileSize) != fileSize) {
			System.out.println("Error: when to load image url");
		}
		String str = new String(buffer, "UTF-8");
		// System.out.println(str);

		JSONObject jsonObject = JSONObject.fromObject(str);
		// System.out.println(jsonObject);
		// System.out.println(jsonObject.get("msg"));;
		// System.out.println(jsonObject.getJSONArray("msg").getString(0));

		for (int i = 0; i < jsonObject.getJSONArray("msg").length(); ++i)
			list.add(jsonObject.getJSONArray("msg").getString(i));
	}

	private void ParseUrl() throws IOException {
		for (int i = 0; i < list.size(); ++i) {
			String uri = "http://" + Config.IP + ":" + Config.PORT + "/" + list.get(i) + "?" + Config.TOKEN + "&"
					+ Config.DATABASE;
			// System.out.println(uri);
			listUri.add(uri);
		}
	}

	public ArrayList<String> GetUrl() throws IOException {
		DownloadFilesUri();
		ParseUrl();
		return listUri;
	}
}
