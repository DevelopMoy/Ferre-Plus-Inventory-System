package com.company;
//This class will contain all the Data-structure and variables that will be used by the GUI
public class MainData {
    public boolean isCanClose() {
        return canClose;
    }

    public void setCanClose(boolean canClose) {
        this.canClose = canClose;
    }

    private boolean canClose=true; //VERIFFY IF THE USER CAN CLOSE THE MAIN WINDOW
}
