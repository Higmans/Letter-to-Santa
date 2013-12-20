package biz.lungo.lettertosanta;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class LetterActivity extends Activity {
	TextView tv;
	String et01, et02, et03, et04, et05, et06, et07, et08, et09, 
	et10, et11, et12, et13, et14, et15, et16, et17, et18, et19, et20;
	StringBuilder sb;
	JSONObject form;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.letter_activity);
		tv = (TextView) findViewById(R.id.textViewLetter);
		Intent i = getIntent();
		JSONObject response;
		try {
			response = new JSONObject(i.getStringExtra("response"));
			form = response.getJSONObject("form");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		try {
			getStrings();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		sb = new StringBuilder();
		sb.append(et01 + "\n")
		.append(et02 + "\n")
		.append(et03 + "\n")
		.append(et04 + "\n")
		.append(et05 + "\n")
		.append(et06 + "\n")
		.append(et07 + "\n")
		.append(et08 + "\n")
		.append(et09 + "\n")
		.append(et10 + "\n")
		.append(et11 + "\n")
		.append(et12 + "\n")
		.append(et13 + "\n")
		.append(et14 + "\n")
		.append(et15 + "\n")
		.append(et16 + "\n")
		.append(et17 + "\n")
		.append(et18 + "\n")
		.append(et19 + "\n")
		.append(et20 + "\n");
		tv.setText(sb.toString());
	}

	private void getStrings() throws JSONException {
		et01 = form.getString("et01");
		et02 = form.getString("et02");
		et03 = form.getString("et03");
		et04 = form.getString("et04");
		et05 = form.getString("et05");
		et06 = form.getString("et06");
		et07 = form.getString("et07");
		et08 = form.getString("et08");
		et09 = form.getString("et09");
		et10 = form.getString("et10");
		et11 = form.getString("et11");
		et12 = form.getString("et12");
		et13 = form.getString("et13");
		et14 = form.getString("et14");
		et15 = form.getString("et15");
		et16 = form.getString("et16");
		et17 = form.getString("et17");
		et18 = form.getString("et18");
		et19 = form.getString("et19");
		et20 = form.getString("et20");
	}

}
