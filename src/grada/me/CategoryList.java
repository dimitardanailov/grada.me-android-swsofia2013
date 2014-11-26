package grada.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CategoryList extends Activity implements OnClickListener {

	String TAG = CategoryList.class.getName();
	
	Button listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categorylist);
		
		listView = (Button) findViewById(R.id.listView);
		listView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		int id = v.getId();
		switch (id) {
		case R.id.headerButtonAddBug:
			Intent intent = new Intent(CategoryList.this ,CameraAlbum.class);
			startActivity(intent);
			break;
			
		case R.id.listView:
			Intent intent1 = new Intent(CategoryList.this ,BugSend.class);
			startActivity(intent1);
			break;	
			
		default:
			break;
		}
	}
}
