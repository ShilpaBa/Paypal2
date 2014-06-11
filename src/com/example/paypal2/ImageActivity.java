package com.example.paypal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paypal2.util.ImageInformation;
import com.example.paypal2.util.ImageMetadata;

/**
 * This class expands the selected image and also shows the image information
 * 
 * @author Shilpa Bambore
 * 
 */
public class ImageActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		// get intent data
		Intent i = getIntent();

		// Selected image id
		int position = i.getExtras().getInt("id");
		TextView view = (TextView) findViewById(R.id.textView1);
		view.setText("Photo " + (position + 1));

		ImageAdapter imageAdapter = new ImageAdapter();
		ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
		imageAdapter.getImageDownloader().download(
				imageAdapter.getItem(position), imageView);

		// Let's display location and date
		ImageInformation info = ImageMetadata.getInstance().getImageDetails(
				imageAdapter.getItem(position));

		view = (TextView) findViewById(R.id.textView2);
		view.setText("Location:  "
				+ ((info.getLocation() != null) ? info.getLocation() : "")
				+ " " + ((info.getName() != null) ? info.getName() : ""));

		view = (TextView) findViewById(R.id.textView3);
		view.setText("Date:  "
				+ ((info.getCurrentDate() != null) ? info.getCurrentDate() : ""));
	}

	public void backButton(View v) {
		Intent intent = new Intent(this, ImageListActivity.class);
		startActivity(intent);

	}
}
