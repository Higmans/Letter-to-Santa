package biz.lungo.lettertosanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class LetterActivity extends Activity {
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.letter_activity);
		tv = (TextView) findViewById(R.id.textViewLetter);
		Intent i = getIntent();
		tv.setText(i.getStringExtra("response"));
	}

}
