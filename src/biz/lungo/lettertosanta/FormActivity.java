package biz.lungo.lettertosanta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class FormActivity extends Activity implements OnClickListener {
	RadioGroup rgSex;
	EditText et01, et02, et03, et04, et05, et06, et07, et08, et09, 
	et10, et11, et12, et13, et14, et15, et16, et17, et18, et19, et20;	
	EditText etArray[] = new EditText[20];
	Button buttonDone;
	ProgressBar pb;
	StringBuilder sbUnfilledForms;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.form_activity);
		
		rgSex = (RadioGroup) findViewById(R.id.radioGroupSex);
		et01 = (EditText) findViewById(R.id.editText1);
		etArray[0] = et01;
		et02 = (EditText) findViewById(R.id.editText2);
		etArray[1] = et02;
		et03 = (EditText) findViewById(R.id.editText3);
		etArray[2] = et03;
		et04 = (EditText) findViewById(R.id.editText4);
		etArray[3] = et04;
		et05 = (EditText) findViewById(R.id.editText5);
		etArray[4] = et05;
		et06 = (EditText) findViewById(R.id.editText6);
		etArray[5] = et06;
		et07 = (EditText) findViewById(R.id.editText7);
		etArray[6] = et07;
		et08 = (EditText) findViewById(R.id.editText8);
		etArray[7] = et08;
		et09 = (EditText) findViewById(R.id.editText9);
		etArray[8] = et09;
		et10 = (EditText) findViewById(R.id.editText10);
		etArray[9] = et10;
		et11 = (EditText) findViewById(R.id.editText11);
		etArray[10] = et11;
		et12 = (EditText) findViewById(R.id.editText12);
		etArray[11] = et12;
		et13 = (EditText) findViewById(R.id.editText13);
		etArray[12] = et13;
		et14 = (EditText) findViewById(R.id.editText14);
		etArray[13] = et14;
		et15 = (EditText) findViewById(R.id.editText15);
		etArray[14] = et15;
		et16 = (EditText) findViewById(R.id.editText16);
		etArray[15] = et16;
		et17 = (EditText) findViewById(R.id.editText17);
		etArray[16] = et17;
		et18 = (EditText) findViewById(R.id.editText18);
		etArray[17] = et18;
		et19 = (EditText) findViewById(R.id.editText19);
		etArray[18] = et19;
		et20 = (EditText) findViewById(R.id.editText20);
		etArray[19] = et20;
		buttonDone = (Button) findViewById(R.id.buttonDone);
		pb = (ProgressBar) findViewById(R.id.progressBar);
		
		pb.setVisibility(ProgressBar.GONE);
		buttonDone.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		if (isAllFormsFilled()){
			buttonDone.setVisibility(Button.GONE);
			pb.setVisibility(ProgressBar.VISIBLE);
			new Thread(new Runnable() {				
				@Override
				public void run() {
					sendRequest();
				}
			}).start();
		}
		else{
			showAlert();
		}
	}
	
	protected void sendRequest() {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://httpbin.org/post");
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		nameValuePairs.add(new BasicNameValuePair("sex", rgSex.getCheckedRadioButtonId() + ""));
		for (int i = 0; i < etArray.length; i++){
			nameValuePairs.add(new BasicNameValuePair(etArray[i].getTag().toString(), encodeSpaces(etArray[i].getText().toString())));
		}
        try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        HttpResponse response = null;
        try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        HttpEntity entity = response.getEntity();
        InputStream is = null;
		try {
			is = entity.getContent();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String responseString = "";
		try {
			responseString = inputStreamToString(is);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		Intent i = new Intent(this, LetterActivity.class);
		i.putExtra("response", responseString);
		startActivity(i);
		finish();
	}
	private String encodeSpaces(String string) {
		return string.replace(" ", "%20");
	}
	private void showAlert() {
		AlertDialog.Builder ab = new AlertDialog.Builder(this);
		ScrollView svRoot = new ScrollView(this);
		TextView tv = new TextView(this);
		svRoot.addView(tv);
		tv.setText(sbUnfilledForms.toString());
		ab.setTitle(getResources().getString(R.string.form_alert));
		ab.setView(svRoot);
		ab.setPositiveButton(android.R.string.ok, null);
		ab.show();
	}
	private boolean isAllFormsFilled() {
		sbUnfilledForms = new StringBuilder();		
		for (int i = 0; i < etArray.length; i++){
			if (etArray[i].getText().toString().matches("")){
				sbUnfilledForms.append(etArray[i].getHint().toString() + "\n");
			}
		}
		return sbUnfilledForms.length() == 0;
	}
	private String inputStreamToString(InputStream in) throws IOException {
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
	    StringBuilder stringBuilder = new StringBuilder();
	    String line = null;

	    while ((line = bufferedReader.readLine()) != null) {
	        stringBuilder.append(line + "\n");
	    }

	    bufferedReader.close();
	    return stringBuilder.toString();
	}

}
