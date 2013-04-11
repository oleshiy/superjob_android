package com.funnycodes.android.SJCalendar.Model;

/**
 * Created with IntelliJ IDEA.
 * User: dimich
 * Date: 4/11/13
 * Time: 2:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataManager {
    private static DataManager ourInstance = new DataManager();


    private Month[] monthes = new Month[12];

    public static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
        monthes = new Month[] {
                new Month("Январь", 31f, 17f, 14f, 136f, 122.4f, 81.6f)
                , new Month("Февраль", 28f, 20f, 8f, 159f, 143f, 95f)
                , new Month("Март", 31f, 20f, 11f, 159f, 143f, 95f)
                , new Month("Апрель", 30f, 22f, 8f, 175f, 157.4f, 104.6f)
                , new Month("Май", 31f, 18f, 13f, 143f, 128.6f, 85.4f)
                , new Month("Июнь", 30f, 19f, 11f, 151f, 135.8f, 90.2f)
                , new Month("Июль", 31f, 23f, 8f, 184f, 165.6f, 110.4f)
                , new Month("Август", 31f, 22f, 9f, 176f, 158.4f, 105.6f)
                , new Month("Сентябрь", 30f, 21f, 9f, 168f, 151.2f, 100.8f)
                , new Month("Октябрь", 31f, 23f, 8f, 184f, 165.6f, 110.4f)
                , new Month("Ноябрь", 30f, 20f, 10f, 160f, 144f, 96f)
                , new Month("Декабрь", 31f, 22f, 9f, 175f, 157.4f, 104.6f)
        };
    }

    public Month[] getMonthes() {
        return monthes;
    }
}
