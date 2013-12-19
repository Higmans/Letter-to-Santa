package biz.lungo.lettertosanta;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}
	
	public void begin(View v){
		Intent i = new Intent(this, FormActivity.class);
		startActivity(i);
	}

}
