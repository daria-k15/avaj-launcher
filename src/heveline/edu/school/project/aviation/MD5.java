package heveline.edu.school.project.aviation;

public class MD5 {
    public static final String BALOON = "994736b4f0aec72f6e5ae580051d012f";
    public static final String JETPLANE = "554cd647d6b135f7e36ab1214c5e816a";
    public static final String HELICOPTER = "2ab8b43468e8b92b0fc5c81e70e35a2d";

    public static Flyable newMD5Aircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
        switch (type){
            case(HELICOPTER):
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case(JETPLANE):
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
            case(BALOON):
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            default:
                throw new Exception(type);
        }
    }
}
