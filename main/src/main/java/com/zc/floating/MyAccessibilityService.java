package com.zc.floating;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by 张程 on 17/1/6.
 */

public class MyAccessibilityService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if(FloatingActivity.isShow) {
            MyWindow.getInstance().setText(event.getClassName() + "");
        }
    }
    @Override
    public void onInterrupt() {

    }
}
