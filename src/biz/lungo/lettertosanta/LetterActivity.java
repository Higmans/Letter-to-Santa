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
	JSONObject jo;
	String et01, et02, et03, et04, et05, et06, et07, et08, et09, 
	et10, et11, et12, et13, et14, et15, et16, et17, et18, et19, et20;
	StringBuilder sb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.letter_activity);
		tv = (TextView) findViewById(R.id.textViewLetter);
		Intent i = getIntent();
		tv.setText(i.getStringExtra("response"));
		/*try {
			jo = new JSONObject(i.getStringExtra("response"));
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
		tv.setText(sb.toString());*/
	}

	private void getStrings() throws JSONException {
		et01 = jo.getString("et01");
		et02 = jo.getString("et02");
		et03 = jo.getString("et03");
		et04 = jo.getString("et04");
		et05 = jo.getString("et05");
		et06 = jo.getString("et06");
		et07 = jo.getString("et07");
		et08 = jo.getString("et08");
		et09 = jo.getString("et09");
		et11 = jo.getString("et11");
		et12 = jo.getString("et12");
		et13 = jo.getString("et13");
		et14 = jo.getString("et14");
		et15 = jo.getString("et15");
		et16 = jo.getString("et16");
		et17 = jo.getString("et17");
		et18 = jo.getString("et18");
		et19 = jo.getString("et19");
		et20 = jo.getString("et20");
	}

}
