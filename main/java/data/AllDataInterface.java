package data;

import database.ReadData;

import java.util.List;

public class AllDataInterface {
    private static int idofWeapon;
    private static int idofEquipment;
    private static int idofKnight;
    private static Login user;
    private static List<EquipList> knightsEquip;
    private static List<WeaponList> knightsWeapon;

    public static Login getUser() {
        return user;
    }

    public static void setUser(Login user) {
        AllDataInterface.user = user;
    }
    public int getIdofWeapon() {
        return idofWeapon;
    }

    public void setIdofWeapon(int id) {
        idofWeapon = id;
    }

    public int getIdofEquipment() {
        return idofEquipment;
    }

    public void setIdofEquipment(int id) {
        idofEquipment = id;
    }

    public List<EquipList> getKnightsEquip() {
        return knightsEquip;
    }

    public static void setKnightsEquip(List<EquipList> knightsEquip1) {
        knightsEquip = knightsEquip1;
    }

    public List<WeaponList> getKnightsWeapon() {
        return knightsWeapon;
    }

    public void setKnightsWeapon(List<WeaponList> knightsWeapon1) {
        knightsWeapon = knightsWeapon1;
    }

    public int getIdofKnight() {
        return idofKnight;
    }

    public void setIdofKnight(int id) {
        idofKnight = id;
    }
}
