package net.hogelab.android.imesample;

import android.annotation.SuppressLint;
import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.TextView;


//--------------------------------------------------
// class ImeService

public class ImeService extends InputMethodService {

	private static final String TAG = ImeService.class.getSimpleName();

    private InputView		mInputView;


    //--------------------------------------------------
	// InputMethodService implements

	/**
	 * Main initialization of the input method component.  Be sure to call
	 * to super class.
	 */
	@Override
	public void onCreate() {
		Log.v(TAG, "onCreate");
		super.onCreate();
	}


	/**
     * This is the point where you can do all of your UI initialization.  It
     * is called after creation and any configuration change.
     */
    @Override
    public void onInitializeInterface() {
		Log.v(TAG, "onInitializeInterface");
    }


    /**
     * Called by the framework when your view for creating input needs to
     * be generated.  This will be called the first time your input method
     * is displayed, and every time it needs to be re-created such as due to
     * a configuration change.
     */
    @Override
    public View onCreateInputView() {
		Log.v(TAG, "onCreateInputView");

		mInputView = (InputView)getLayoutInflater().inflate(R.layout.view_input, null);
		TextView textInput = (TextView)mInputView.findViewById(R.id.textInput);
		mInputView.setInputTextView(textInput);

    	return mInputView;
    }


    /**
     * Called by the framework when your view for showing candidates needs to
     * be generated, like {@link #onCreateInputView}.
     */
    @Override
    public View onCreateCandidatesView() {
		Log.v(TAG, "onCreateCandidatesView");

		return null;
    }


    /**
     * This is the main point where we do our initialization of the input method
     * to begin operating on an application.  At this point we have been
     * bound to the client, and are now receiving all of the detailed information
     * about the target of our edits.
     */
    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
		Log.v(TAG, "onStartInput");
        super.onStartInput(attribute, restarting);
    }


    /**
     * This is called when the user is done editing a field.  We can use
     * this to reset our state.
     */
    @Override
    public void onFinishInput() {
		Log.v(TAG, "onFinishInput");
        super.onFinishInput();
    }


    @Override
    public void onStartInputView(EditorInfo attribute, boolean restarting) {
		Log.v(TAG, "onStartInputView");
        super.onStartInputView(attribute, restarting);
    }


    @SuppressLint("NewApi")
	@Override
    public void onCurrentInputMethodSubtypeChanged(InputMethodSubtype subtype) {
		Log.v(TAG, "onCurrentInputMethodSubtypeChanged");
    }


    /**
     * Deal with the editor reporting movement of its cursor.
     */
    @Override
    public void onUpdateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd,
            int candidatesStart, int candidatesEnd) {
		Log.v(TAG, "onUpdateSelection");
		Log.v(TAG, String.format("    (%d, %d, %d, %d, %d, %d)", oldSelStart, oldSelEnd, newSelStart, newSelEnd, candidatesStart, candidatesEnd));
        super.onUpdateSelection(oldSelStart, oldSelEnd, newSelStart, newSelEnd,
                candidatesStart, candidatesEnd);
    }


    /**
     * This tells us about completions that the editor has determined based
     * on the current text in it.  We want to use this in fullscreen mode
     * to show the completions ourself, since the editor can not be seen
     * in that situation.
     */
    @Override
    public void onDisplayCompletions(CompletionInfo[] completions) {
		Log.v(TAG, "onDisplayCompletions");
    }


    /**
     * Use this to monitor key events being delivered to the application.
     * We get first crack at them, and can either resume them or let them
     * continue to the app.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		Log.v(TAG, "onKeyDown");

		boolean handled = false;

		switch (keyCode) {

		case KeyEvent.KEYCODE_BACK:
            // The InputMethodService already takes care of the back
            // key for us, to dismiss the input method if it is shown.
            // However, our keyboard could be showing a pop-up window
            // that back should dismiss, so we first allow it to do that.
            break;

        case KeyEvent.KEYCODE_DEL:
            // Special handling of the delete key: if we currently are
            // composing text for the user, we want to modify that instead
            // of let the application to the delete itself.
            break;

        case KeyEvent.KEYCODE_ENTER:
            // Let the underlying text editor always handle these.
            return false;

        default:
            // For all other keys, if we want to do transformations on
            // text being entered with a hard keyboard, we need to process
            // it and do the appropriate action.
        	mInputView.addInputText(String.valueOf((char)keyCode));
        	handled = true;
        	break;
        }

		if (!handled) {
			return super.onKeyDown(keyCode, event);
		}

		return false;
    }

    /**
     * Use this to monitor key events being delivered to the application.
     * We get first crack at them, and can either resume them or let them
     * continue to the app.
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
		Log.v(TAG, "onKeyUp");
        // If we want to do transformations on text being entered with a hard
        // keyboard, we need to process the up events to update the meta key
        // state we are tracking.

        return super.onKeyUp(keyCode, event);
    }


    //--------------------------------------------------
	// KeyboadView.OnKeyboadActionListener implements

    /*
	@Override
	public void onKey(int primaryCode, int[] keyCodes) {
	}

	@Override
	public void onPress(int primaryCode) {
	}

	@Override
	public void onRelease(int primaryCode) {
	}

	@Override
	public void onText(CharSequence text) {
	}

	@Override
	public void swipeDown() {
	}

	@Override
	public void swipeLeft() {
	}

	@Override
	public void swipeRight() {
	}

	@Override
	public void swipeUp() {
	}
	*/
}
