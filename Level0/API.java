package week4_assignment6;

class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("Old feature");
    }

    void newFeature() {
        System.out.println("New feature");
    }
}

public class API {
    public static void main(String[] args) {
        LegacyAPI obj = new LegacyAPI();

        obj.oldFeature();

        obj.newFeature();
    }
}
