package pack.calculator.webcalculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	WebView myWebView =null;
	Button button =null;
	
	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Entry-Log", "OnCreate() on MainActivity");  
        setContentView(R.layout.main);
        button= (Button)this.findViewById(R.id.button1);
        myWebView = (WebView)findViewById(R.id.webView1);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
    }
	
	public void clicked(View V){
		WebAppInterface.display="";
		myWebView.loadUrl("javascript:document.getElementById('res').value = '"+" "+"';");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("Entry-Log", "onRestart() on MainActivity");  
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("Entry-Log", "onPause() on MainActivity"); 
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("Entry-Log", "onResume() on MainActivity"); 
		myWebView.loadUrl("file:///android_asset/index.html");
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("Entry-Log", "OnDestroy() on MainActivity");  
	}
}
