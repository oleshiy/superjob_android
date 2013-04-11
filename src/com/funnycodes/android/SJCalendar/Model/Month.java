package com.funnycodes.android.SJCalendar.Model;

/**
 * Created with IntelliJ IDEA.
 * User: dimich
 * Date: 4/11/13
 * Time: 2:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Month {

    private String name;
    private float calend;
    private float work;
    private float dayoff;
    private float day40hr;
    private float day36hr;
    private float day24hr;

    public Month(String $name, float $calend, float $work, float $dayoff, float $day40hr, float $day36hr, float $day24hr)
    {
        name = $name;
        calend = $calend;
        work = $work;
        dayoff = $dayoff;
        day40hr = $day40hr;
        day36hr = $day36hr;
        day24hr = $day24hr;
    }

    public String getName() {
        return name;
    }

    public float getCalend() {
        return calend;
    }

    public float getWork() {
        return work;
    }

    public float getDayoff() {
        return dayoff;
    }

    public float getDay40hr() {
        return day40hr;
    }

    public float getDay36hr() {
        return day36hr;
    }

    public float getDay24hr() {
        return day24hr;
    }
}
