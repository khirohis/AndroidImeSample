package net.hogelab.android.imesample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


//--------------------------------------------------
// class InputView

public class InputView extends RelativeLayout
		implements View.OnClickListener {

	private static final String TAG = InputView.class.getSimpleName();

	private TextView		mTextInput;


	//--------------------------------------------------
	// public functions

	public InputView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InputView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}


	public void setInputTextView(TextView inputTextView) {
		mTextInput = inputTextView;
	}

	public void addInputText(String s) {
		mTextInput.setText(mTextInput.getText() + s);
	}


	@SuppressLint("NewApi")
	@Override
    public boolean onHoverEvent(MotionEvent event) {
		Log.v(TAG, "onHoverEvent");

		return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent me) {
		Log.v(TAG, "onTouchEvent");

        boolean result = true;

        return result;
    }


    //--------------------------------------------------
	// View.OnClickListener implements

    @Override
	public void onClick(View v) {
		Log.v(TAG, "onClick");
	}
}
