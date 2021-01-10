package lu_gauss;

import java.util.Objects;

/**
 *Klasa opisuje łuki  i ich kierunek
 * @author Luk
 */
public class Connection {
     
    //ID pierwszego wierzchołka łuku
    private int firstVerticeID;
    //ID drugiego wierzchołka łuku
    private int secondVerticeID;
    //Kierunek łuku
    private String directionOfConnection;

    /**
     *
     * @param firstVerticeID
     * @param secondVerticeID
     * @param directionOfConnection
     */
    public Connection(int firstVerticeID, int secondVerticeID, String directionOfConnection) {
        this.firstVerticeID = firstVerticeID;
        this.secondVerticeID = secondVerticeID;
        this.directionOfConnection = directionOfConnection;
    }

    public int getFirstVerticeID() {
        return firstVerticeID;
    }

    public int getSecondVerticeID() {
        return secondVerticeID;
    }

    public String getDirectionOfConnection() {
        return directionOfConnection;
    }

    @Override
    public String toString() {
        return "Connection{" +
                firstVerticeID +
                ", " + secondVerticeID +
                ", " + directionOfConnection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return firstVerticeID == that.firstVerticeID &&
                secondVerticeID == that.secondVerticeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVerticeID, secondVerticeID);
    }
}
