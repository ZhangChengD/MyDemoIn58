package com.zc.design.ext;

import com.zc.util.ToastUtills;
import com.zc.util.UIUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张程 on 16/12/26.
 */

public class Father {

    public void say(Map map){
        ToastUtills.showToast("father say Map");
    }

    public void otherSay(HashMap map){
        ToastUtills.showToast("father other say HashMap");
    }

}
