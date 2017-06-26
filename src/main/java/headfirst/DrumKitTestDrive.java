package headfirst;

/**
 * Created by Dell-SSD on 27.05.2017.
 */
public class DrumKitTestDrive {
    public static void main(String[] args) {
        DrumKit d = new DrumKit();

        d.playSnare();
        d.snare = false;

        if (d.snare==true){
            d.playSnare();
        }

        d.playTopHat();
    }
}
