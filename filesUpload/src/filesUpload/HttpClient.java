package filesUpload;

import com.loopj.android.http.AsyncHttpClient;

public class HttpClient {
	private static AsyncHttpClient client=new AsyncHttpClient();
    private void IHttp(){
        client.setTimeout(5*1000);
        client.setURLEncodingEnabled(true);
        client.setEnableRedirects(true);
    }
    public static void post(String url,File file,final IHttpClientListener listener){
       RequestParams params = new RequestParams();

        try {
            params.put(file.getName(),file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        client.post( url,params,new AsyncHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  byte[] responseBody) {
                if (listener != null) {
                    String value = "";
                    if (responseBody != null && responseBody.length > 0) {
                        value = new String(responseBody);
                    }
                    listener.onSuccess(statusCode, value);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] responseBody, Throwable error) {
                //Logger.e("statusCode " + statusCode + "  " + error,
                //		"IHttpClient");
                if (listener != null) {
                    listener.onFailure(statusCode, error);
                }

            }
        });
    }

    public interface IHttpClientListener {
        void onSuccess(int statusCode, String responseValue);

        void onFailure(int statusCode, Throwable error);
    }
}
