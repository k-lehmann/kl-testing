package roman10.tutorial.tcpcommclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TcpClient extends Activity {
    /** Called when the activity is first created. */
	
	public EditText et;
	public TextView textDisplay;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textDisplay = (TextView) this.findViewById(R.id.text1);
        textDisplay.setText("");
        
        
        
        et = (EditText)findViewById(R.id.etEdit);
       
        Button btn = (Button)findViewById(R.id.button1);
        
        btn.setOnClickListener(new OnClickListener() {
            
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
            	runTcpClient();
            	//while(true){
            		
            		runTcpClient2();
            	//}
            }
        });
        
        
        
    }
    
    BufferedReader in = null;
    BufferedWriter out = null;
    private static final int TCP_SERVER_PORT = 8888;
    
    String outMsg = "";
	private void runTcpClient() {
    	try {
			Socket s = new Socket(et.getText().toString(), TCP_SERVER_PORT);
			 in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			 out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			//send output msg
			//String outMsg = "TCP connecting to " + TCP_SERVER_PORT + System.getProperty("line.separator"); 
			//out.write(outMsg);
			//out.flush();
			////Log.i("TcpClient", "sent: " + outMsg);
			//accept server response
			//String inMsg = in.readLine() + System.getProperty("line.separator");
			//textDisplay.append("received: " + inMsg);

			//Log.i("TcpClient", "received: " + inMsg);
			//close connection
			//s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
	
	
	private void runTcpClient2() {
    	try {
			//Socket s = new Socket(et.getText().toString(), TCP_SERVER_PORT);
			 //in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			//send output msg
			outMsg = "TCP connecting to " + TCP_SERVER_PORT + System.getProperty("line.separator"); 
			out.write(outMsg);
			out.flush();
			Log.i("TcpClient", "sent: " + outMsg);
			//accept server response
			//String inMsg = in.readLine() + System.getProperty("line.separator");
			//textDisplay.append("received: " + inMsg);

			//Log.i("TcpClient", "received: " + inMsg);
			//close connection
			//s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
	
	//replace runTcpClient() at onCreate with this method if you want to run tcp client as a service
	private void runTcpClientAsService() {
		Intent lIntent = new Intent(this.getApplicationContext(), TcpClientService.class);
        this.startService(lIntent);
	}
}