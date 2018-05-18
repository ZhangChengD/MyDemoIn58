package com.zc.design.ext;

import com.zc.util.ToastUtills;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张程 on 16/12/26.
 */

public class Son extends Father {

    public void say(HashMap map) {
        ToastUtills.showToast("son say HashMap");
    }

    public void otherSay(Map map) {
        ToastUtills.showToast("son say Map");
    }
}
