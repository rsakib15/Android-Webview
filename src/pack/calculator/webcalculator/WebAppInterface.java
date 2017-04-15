package pack.calculator.webcalculator;

import android.content.Context;
import android.util.Log;
import android.widget.Button;

public class WebAppInterface {
    MainActivity wa = null;
    static String display="";
    EvaluateString eva=new EvaluateString();

    WebAppInterface(Context c){
        wa = (MainActivity) c;
    }
    public void addNum(String num) {
    	display+=num+" ";
        wa.myWebView.loadUrl("javascript:document.getElementById('res').value = '"+display+"';");
    }

    public void addOperator(String opt) {
        display+=opt+" ";
        wa.myWebView.loadUrl("javascript:document.getElementById('res').value = '"+display+"';");

    }
    public String getResult(){
        double i=eva.evaluate(display);
        return  String.valueOf(i);
    }
}
