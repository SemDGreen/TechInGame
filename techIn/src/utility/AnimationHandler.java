package utility;

public class AnimationHandler {

    //LOADER FUNCTION FOR ANIMATIONS THAT TAKES HASHMAPS OR ARRAYS AND FILLS
    //THEM WITH THE CORRECT ANIMATIONS

    private static AnimationHandler singleton;

    public AnimationHandler() {

    }

    public static AnimationHandler getSingleton() {
        if  (singleton == null) {
            singleton = new AnimationHandler();
        }
        return singleton;
    }
}
