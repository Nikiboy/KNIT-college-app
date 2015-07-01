package com.knit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ResultActivity extends Activity {


//    public void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2" };
//        // use your custom layout
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                R.layout.rowlayout, R.id.label, values);
//        setListAdapter(adapter);
//    }
//
//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        String item = (String) getListAdapter().getItem(position);
//        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
//    }
//}


    String url;
//    Dialog dialog;
    Button rezBut;
    EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
//        dialog = new Dialog(this.getBaseContext());
        //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.result_dialog);
        //dialog.setCanceledOnTouchOutside(true);
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }


    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:
                System.out.println("yooo.....butt1");
                url = "http://knit.ac.in/coe/odd_2014/odx41fsp47g.asp?rollno=";
                System.out.println("yooo.....butt1");
                rezBut = (Button) findViewById(R.id.resultButton);
                rezBut.setVisibility(View.VISIBLE);
                et = (EditText) findViewById(R.id.rollno);
                et.setVisibility(View.VISIBLE);


                break;
            case R.id.button2:
                System.out.println("yooo.....butt2");
                url = "http://knit.ac.in/coe/Even_2013_14/mtechodd1314.asp?rollno=";

                rezBut = (Button) findViewById(R.id.resultButton);
                rezBut.setVisibility(View.VISIBLE);
                et = (EditText) findViewById(R.id.rollno);
                et.setVisibility(View.VISIBLE);
                break;

            case R.id.button3:
                url = "http://knit.ac.in/coe/even_2013_14/bt2nd.asp?rollno=";
                System.out.println("yooo.....butt3");
                rezBut = (Button) findViewById(R.id.resultButton);
                rezBut.setVisibility(View.VISIBLE);
                et = (EditText) findViewById(R.id.rollno);
                et.setVisibility(View.VISIBLE);
                break;

            case R.id.resultButton:
                System.out.println("yooo.....rez butt");
                url = url + et.getText();
                et.setText("");
                Intent i = new Intent(this, RNO_Webview.class);
                i.putExtra("URL", url);
                Log.d("URL",url);
                startActivity(i);
                break;
        }
    }
}