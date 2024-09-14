package Test;

public class PhysicalTest {

    private boolean ColorBlindessTest;
    private boolean FarsightednessTest;
    private boolean AstigmatismTest;
    private boolean BodyResponseTest;



    public boolean isColorBlindessTest() {
        return ColorBlindessTest;
    }

    public void setColorBlindessTest(boolean colorBlindessTest) {
        ColorBlindessTest = colorBlindessTest;
    }

    public boolean isFarsightednessTest() {
        return FarsightednessTest;
    }

    public void setFarsightednessTest(boolean farsightednessTest) {
        FarsightednessTest = farsightednessTest;
    }

    public boolean isAstigmatismTest() {
        return AstigmatismTest;
    }

    public void setAstigmatismTest(boolean astigmatismTest) {
        AstigmatismTest = astigmatismTest;
    }

    public boolean isBodyResponseTest() {
        return BodyResponseTest;
    }

    public void setBodyResponseTest(boolean bodyResponseTest) {
        BodyResponseTest = bodyResponseTest;
    }


    public boolean estimatePhysicalTest() {
        int passTest = 0;
        if (ColorBlindessTest == true) {
            passTest = passTest + 1;
        }

        if (FarsightednessTest == true) {
            passTest = passTest + 1;
        }
        if (AstigmatismTest == true) {
            passTest = passTest + 1;
        }
        if (BodyResponseTest == true) {
            passTest = passTest + 1;
        }

        return passTest >= 3;
    }

}
