package grada.me;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class GradaMainActivity extends Activity implements OnClickListener {
	
	String TAG = GradaMainActivity.class.getName();
	
	Button facebookLoginButton;
	Button googleLoginButton;
	Button anonimousButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grada_main);
		
		facebookLoginButton = (Button) findViewById(R.id.facebookLogin);
		facebookLoginButton.setOnClickListener(this);
		
		googleLoginButton = (Button) findViewById(R.id.googlePlusLogin);
		googleLoginButton.setOnClickListener(this);
		
		anonimousButton = (Button) findViewById(R.id.anonimousButton);
		anonimousButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grada_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		Log.d(TAG, id + "");
		switch (id) {
		case R.id.facebookLogin:
		case R.id.googlePlusLogin:
		case R.id.anonimousButton:
			Intent intent = new Intent(GradaMainActivity.this ,CameraAlbum.class);
			startActivity(intent);
			break;
		}
	}
	
}
