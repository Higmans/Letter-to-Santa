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
		tv.setText(formatLetter());
	}

    private String formatLetter() {
        boolean male = true;
        try {
            male = Integer.parseInt(form.getString("sex")) == R.id.radioMale;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sb = new StringBuilder();
        sb.append(getResources().getString(R.string.part_1))
                .append(et01)
                .append(getResources().getString(R.string.part_2))
                .append(et02)
                .append(getResources().getString(R.string.part_3))
                .append(et18)
                .append(getResources().getString(R.string.part_4))
                .append(et03)
                .append(getResources().getString(R.string.part_5))
                .append(et16)
                .append(getResources().getString(R.string.part_6))
                .append(et09)
                .append(male?getResources().getString(R.string.part_7):getResources().getString(R.string.part_7_f))
                .append(et06)
                .append(getResources().getString(R.string.part_8))
                .append(et11)
                .append(getResources().getString(R.string.part_9))
                .append(et08)
                .append(getResources().getString(R.string.part_10))
                .append(et04)
                .append(getResources().getString(R.string.part_11))
                .append(et05)
                .append(getResources().getString(R.string.part_12))
                .append(et12)
                .append(getResources().getString(R.string.part_13))
                .append(et01)
                .append(getResources().getString(R.string.part_14))
                .append(et19)
                .append(getResources().getString(R.string.part_15))
                .append(et20)
                .append(getResources().getString(R.string.part_16))
                .append(et14)
                .append(getResources().getString(R.string.part_17))
                .append(et10)
                .append(getResources().getString(R.string.part_18))
                .append(et16)
                .append(getResources().getString(R.string.part_19))
                .append(et17)
                .append(getResources().getString(R.string.part_20))
                .append(et15)
                .append(getResources().getString(R.string.part_21))
                .append(et14)
                .append(getResources().getString(R.string.part_22))
                .append(et13)
                .append(getResources().getString(R.string.part_23))
                .append(et07)
                .append(getResources().getString(R.string.part_24));
        return sb.toString();
    }


    private void getStrings() throws JSONException {
		et01 = formatSpaces(form.getString("et01")); 
		et02 = formatSpaces(form.getString("et02")); 
		et03 = formatSpaces(form.getString("et03")); 
		et04 = formatSpaces(form.getString("et04")); 
		et05 = formatSpaces(form.getString("et05")); 
		et06 = formatSpaces(form.getString("et06")); 
		et07 = formatSpaces(form.getString("et07")); 
		et08 = formatSpaces(form.getString("et08")); 
		et09 = formatSpaces(form.getString("et09")); 
		et10 = formatSpaces(form.getString("et10")); 
		et11 = formatSpaces(form.getString("et11")); 
		et12 = formatSpaces(form.getString("et12")); 
		et13 = formatSpaces(form.getString("et13")); 
		et14 = formatSpaces(form.getString("et14"));
		et15 = formatSpaces(form.getString("et15")); 
		et16 = formatSpaces(form.getString("et16")); 
		et17 = formatSpaces(form.getString("et17")); 
		et18 = formatSpaces(form.getString("et18")); 
		et19 = formatSpaces(form.getString("et19")); 
		et20 = formatSpaces(form.getString("et20")); 
	}

    private String formatSpaces(String string) {
        return string.replace("%20", " ");
    }

}
