package com.example.paypal2;


import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

public class ImageActivityTest extends ActivityInstrumentationTestCase2<ImageActivity> {

	private Solo solo;
	
	public ImageActivityTest(Class<ImageActivity> activityClass) {
		super(activityClass);
	}
	
	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	  
	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
	
	public void testLoadImage() throws Exception {
		
		// Assert if ImageActivity is opened by default when user lands on this page
		solo.assertCurrentActivity("Expected ImageActivity activity", "ImageActivity");
		
		// validate back button.
		solo.clickOnImageButton(R.id.imageButton1);
		
		// Check if the selected image is displayed
		solo.clickOnImage(R.id.full_image_view);
		
		//Validate viewText - photo, location and date
		solo.clickOnText("Photo", R.id.textView1);
		solo.clickOnText("Location", R.id.textView2);
		solo.clickOnText("Date", R.id.textView3);
	}
}
