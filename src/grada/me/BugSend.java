package grada.me;

import grada.me.GPSTracker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BugSend extends Activity implements OnClickListener{

	String TAG = CategoryList.class.getName();
	
	EditText gpsLocation;
	Button saveBug;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bugsend);
		
		gpsLocation = (EditText) gpsLocation;
		saveBug = (Button) saveBug;
	}

	@Override
	public void onClick(View v) {
		
		int id = v.getId();
		switch (id) {
		case R.id.headerButtonAddBug:
			Intent intent = new Intent(BugSend.this ,CameraAlbum.class);
			startActivity(intent);
			break;
			
		default:
			break;
		}
		
	}
	
	/**
	 * Set city name
	 */
	private void setGPS() {
		// check if GPS enabled
		GPSTracker gpsTracker = new GPSTracker(this);
		if (gpsTracker.canGetLocation()) {
			String locality = gpsTracker.getLocality(this);
			String value = gpsLocation.getText().toString();
			if (value.length() == 0) {
				gpsLocation.setText(locality);
			}
		} else {
			// can't get location
			// GPS or Network is not enabled
			// Ask user to enable GPS/network in settings
			gpsTracker.showSettingsAlert();
		}
	}
	
}
