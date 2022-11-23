package data;

import java.util.List;

public class AllDataInterface {
    private int idofWeapon;
    private int idofEquipment;
    private int idofKnight;
    private EquipList equipList;
    private WeaponList weaponList;
    private List<EquipList> knightsEquip;
    private List<WeaponList> knightsWeapon;
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

    public EquipList getEquipList() {
        return equipList;
    }

    public void setEquipList(EquipList equipList1) {
        equipList = equipList1;
    }

    public WeaponList getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(WeaponList weaponList1) {
        weaponList = weaponList1;
    }

    public List<EquipList> getKnightsEquip() {
        return knightsEquip;
    }

    public void setKnightsEquip(List<EquipList> knightsEquip1) {
        knightsEquip = knightsEquip1;
    }

    public List<WeaponList> getKnightsWeapon() {
        return knightsWeapon;
    }

    public void setKnightsWeapon(List<WeaponList> knightsWeapon1) {
        knightsWeapon = knightsWeapon1;
    }

    public int getIdofKnight() {
        return this.idofKnight;
    }

    public void setIdofKnight(int id) {
        this.idofKnight = id;
    }
}
