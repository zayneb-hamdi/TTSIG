public class Layer {
private int id;
private String nom;
private double latitude,longitude;


public Layer(int id, String nom,double latitude,double longitude)
{

    this.id=id;
    this.nom=nom;
    this.latitude=latitude;
    this.longitude=longitude;
}


public int getId() {
    return id;
}


public void setId(int id) {
    this.id = id;
}


public String getNom() {
    return nom;
}


public void setNom(String name) {
    this.nom = name;
}


public double getLatitude() {
    return latitude;
}


public void setLatitude(double latitude) {
    this.latitude = latitude;
}


public double getLongitude() {
    return longitude;
}


public void setLongitude(double longitude) {
    this.longitude = longitude;
}


@Override
public String toString() {
    return "Layer [id=" + id + ", nom=" + nom + ", latitude=" + latitude + ", longitude=" + longitude + "]\n";
}




}
