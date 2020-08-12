package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 16:06
 * Description
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
