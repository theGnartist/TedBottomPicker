package gun0912.tedbottompicker.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

import java.util.logging.Handler;

import gun0912.tedbottompicker.R;

public class PhotoVideoToggleButton extends AppCompatImageButton {
    private static final int[] STATE_VIDEO = {R.attr.state_video};
    private boolean isVideo = false;
    public PhotoVideoToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        if (isVideo) {
            mergeDrawableStates(drawableState, STATE_VIDEO);
        }
        return drawableState;
    }

    public void setVideo(boolean video) {
        isVideo = video;
        if ( getHandler() != null ) {
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    refreshDrawableState();
                }
            });
        }
    }
}
