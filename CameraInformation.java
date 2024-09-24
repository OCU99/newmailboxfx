package com.mycompany.newmailboxfx;

public class CameraInformation {

    private String CameraName;
    private int CameraIndex;

    public String getCameraName() {
        return CameraName;
    }

    public void setCameraName(String CameraName) {
        this.CameraName = CameraName;
    }

    public int getCameraIndex() {
        return CameraIndex;
    }

    public void setCameraIndex(int CameraIndex) {
        this.CameraIndex = CameraIndex;
    }

    @Override
    public String toString() {
        return CameraName;
    }
}