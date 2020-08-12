package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 16:04
 * Description
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
