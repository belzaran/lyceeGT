package com.garehn.lyceesgt.lycees;

import java.util.ArrayList;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Lycee implements Parcelable {

    protected int id;

    protected ArrayList<Langues> langues = new ArrayList();
    protected ArrayList<Techno> techno = new ArrayList();
    protected ArrayList<Specialities> specialities = new ArrayList();
    protected ArrayList<DoubleCursus> doubleCursus = new ArrayList();

    protected String name = "";
    //protected int time = 0;

    protected int population; // reference : https://ville-data.com/
    protected int rank; // reference : https://ville-data.com/
    //Best Rank is 1. Calcul = (Taux de mention * 3) + (Taux de réussite * 2) + (Taux d'accès seconde bac ) + (effectif seconde/50))*100).

    protected int distance;
    protected double longitude;
    protected double latitude;
    final double matisseLongitude = 2.4019898;
    final double matisseLatitude = 48.8564542;
    protected Location matisseLocation;
    protected Location lyceeLocation;



    protected int resultRank;

    protected int points = 0;

    /*----------------------------------------------------------------------------------------------
    CONSTRUCTOR
    ----------------------------------------------------------------------------------------------*/

    public Lycee(String n, double lat, double lng){
        this.name = n;
        this.longitude = lng;
        this.latitude = lat;
        Log.i("GAREHN_LYCEE", "* Creating lycee " + name);
        matisseLocation = new Location("Matisse location");
        lyceeLocation = new Location(name + " location");
        distance = calculateDistance();
    }

    protected Lycee(Parcel in) {
        name = in.readString();
        population = in.readInt();
        rank = in.readInt();
        distance = in.readInt();
        longitude = in.readDouble();
        latitude = in.readDouble();
        points = in.readInt();
        ArrayList<Langues> list1 = new ArrayList();
        in.readList(list1, Langues.class.getClassLoader());
        langues = list1;
        ArrayList<Specialities> list2 = new ArrayList();
        in.readList(list2, Specialities.class.getClassLoader());
        specialities = list2;
        ArrayList<Techno> list3 = new ArrayList();
        in.readList(list3, Techno.class.getClassLoader());
        techno = list3;
        ArrayList<DoubleCursus> list4 = new ArrayList();
        in.readList(list4, DoubleCursus.class.getClassLoader());
        doubleCursus = list4;
    }

    public static final Creator<Lycee> CREATOR = new Creator<Lycee>() {
        @Override
        public Lycee createFromParcel(Parcel in) {
            return new Lycee(in);
        }

        @Override
        public Lycee[] newArray(int size) {
            return new Lycee[size];
        }
    };

    public void addLangue(Langues LV){
        this.langues.add(LV);
    }

    public void addSpecialities(Specialities Op){
        this.specialities.add(Op);
    }

    public void addDoubleCursus(DoubleCursus DC){
        this.doubleCursus.add(DC);
    }

    public void addTechno(Techno T){
        this.techno.add(T);
    }

    public void addPoints (int p){
        this.points += p;
    }

    /*----------------------------------------------------------------------------------------------
    GETTERS AND SETTERS
    ----------------------------------------------------------------------------------------------*/
    public int getResultRank() {
        return resultRank;
    }

    public void setResultRank(int resultRank) {
        this.resultRank = resultRank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<DoubleCursus> getDoubleCursus() {
        return doubleCursus;
    }

    public void setDoubleCursus(ArrayList<DoubleCursus> doubleCursuses) {
        this.doubleCursus = doubleCursuses;
    }

    public ArrayList<Langues> getLangues() {
        return langues;
    }

    public void setLangues(ArrayList<Langues> langues) {
        this.langues = langues;
    }

    public ArrayList<Techno> getTechno() {
        return techno;
    }

    public void setTechno(ArrayList<Techno> techno) {
        this.techno = techno;
    }

    public ArrayList<Specialities> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<Specialities> specialities) {
        this.specialities = specialities;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }*/

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


 /*----------------------------------------------------------------------------------------------
    FUNCTIONS
    ----------------------------------------------------------------------------------------------*/

    public int calculateDistance(){
        int d = 0;
        matisseLocation.setLatitude(matisseLatitude);
        matisseLocation.setLongitude(matisseLongitude);
        lyceeLocation.setLatitude(latitude);
        lyceeLocation.setLongitude(longitude);
        d = (int) lyceeLocation.distanceTo(matisseLocation);
        return d ;
    }

    public void showInformation(){
        Log.i("GAREHN_LYCEE", "------------------------");
        Log.i("GAREHN_LYCEE", "  " + name);
        Log.i("GAREHN_LYCEE", "  rang : " + rank);
        Log.i("GAREHN_LYCEE", "  " + population + " élèves");
        Log.i("GAREHN_LYCEE", "  distance : " + distance + " m");
        Log.i("GAREHN_LYCEE", "  langues : " + getLangues());
        Log.i("GAREHN_LYCEE", "  spécialités : " + getSpecialities());
        Log.i("GAREHN_LYCEE", "  double cursus: " + getDoubleCursus());
        Log.i("GAREHN_LYCEE", "  techno: " + getTechno());
        Log.i("GAREHN_LYCEE", "  POINTS: " + getPoints());
        Log.i("GAREHN_LYCEE", "------------------------");
    }

    // Don't change this method
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(population);
        dest.writeInt(rank);
        dest.writeInt(distance);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
        dest.writeInt(points);
        dest.writeList(langues);
        dest.writeList(specialities);
        dest.writeList(techno);
        dest.writeList(doubleCursus);
    }
}

