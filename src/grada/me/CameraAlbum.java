package grada.me;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CameraAlbum extends Activity implements OnClickListener {
	
	//keep track of camera capture intent
	final int CAMERA_CAPTURE = 1;
	
	Button headerButtonAddBug;
	Button cameraListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cameraalbum);
		
		headerButtonAddBug = (Button) findViewById(R.id.headerButtonAddBug);
		headerButtonAddBug.setOnClickListener(this);
		
		cameraListener = (Button) findViewById(R.id.cameraListener);
		cameraListener.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.headerButtonAddBug:
			Intent intent = new Intent(CameraAlbum.this ,CameraAlbum.class);
			startActivity(intent);
			break;
		
		case R.id.cameraListener:
			try
			{
				//use standart intent to capture an image
				Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				//we will handle the returned data in onActivityResult
				startActivityForResult(captureIntent, CAMERA_CAPTURE);
			}
			catch (ActivityNotFoundException e) 
			{
				////display an error message
				Toast toast = Toast.makeText(this, "Please load camera", Toast.LENGTH_SHORT);
				toast.show();
			}
			break;
			
		default:
			break;
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		if (requestCode == CAMERA_CAPTURE && resultCode == RESULT_OK)
		{
			Intent intent = new Intent(CameraAlbum.this, CategoryList.class);	
			CameraAlbum.this.startActivity(intent);
		}
	}

}
