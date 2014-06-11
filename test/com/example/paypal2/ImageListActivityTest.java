package com.example.paypal2;

import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

public class ImageListActivityTest extends ActivityInstrumentationTestCase2<ImageListActivity>{

	private Solo solo;
	public ImageListActivityTest(Class<ImageListActivity> activityClass) {
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
	
	public void testGridViewImages() throws Exception {
		
		// Assert if ImageListActivity is opened by default when user lands on this page
		solo.assertCurrentActivity("Expected ImageListActivity activity", "ImageListActivity");

		// Check if we can scrolldown to view images
		solo.scrollDown();
		
		// Check by clicking on image 1, 2 & 3 by default
		solo.clickOnImage(1);
		solo.clickOnImage(2);
		solo.clickOnImage(3);
	}
}
