import java.io.*;
import java.net.URL;
import java.net.*;
import java.net.URLConnection;
import java.net.URLEncoder;

class smsDemo
{
	public static void main(String args[])
	{
			String msg = "This is sms foor testing";
			String no = "9823339451";			
			try
			{
				//api key provided by specific smsgayway for authentication
				String apikey="your key";
				msg = URLEncoder.encode(msg,"UTF-8");	//Msg encoder			
				
				String lang="english";					//language provided to sms gateway
				String route="q";						//route provided by sms gateway
				//making url string of all properties for authentication with sms gateway company
				String myurl = "https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&route="+route+"&message="+msg+"&language="+lang+"&flash=0&numbers="+no;
								
				URL url = new URL(myurl); //making URL
				HttpURLConnection con = (HttpURLConnection)url.openConnection();//URL send for authentication
				
				con.setRequestMethod("GET");		//there are two method GET And Post
				con.setRequestProperty("cache-control","no-cache");
				con.getResponseCode();				
				
				//after this all are optional part no need to write its only for checking any error occurs or Not
				StringBuffer response=new StringBuffer();
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				while(true)
				{
					String line = br.readLine();
					if(line==null)
						break;
					response.append(line);
				}					
				System.out.println(response);					
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
}