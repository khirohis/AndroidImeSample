package net.hogelab.android.imesample;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.Keyboard.Key;
import android.util.AttributeSet;


//--------------------------------------------------
//class InputView

public class InputView extends KeyboardView {

	public InputView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InputView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}


	@Override
    protected boolean onLongPress(Key key) {
        if (key.codes[0] == Keyboard.KEYCODE_CANCEL) {
//            getOnKeyboardActionListener().onKey(KEYCODE_OPTIONS, null);
//            return true;
        }

        return super.onLongPress(key);
    }
}
