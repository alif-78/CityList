package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * test delete city
     */
    @Test
    public void testDelete()
    {
        CityList cityList = new CityList();
        City city = new City("jessore","khulna");
        City city1 = new City ("mirpur","dhaka");
        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertTrue(!cityList.getCities(1).contains(city));
    }

    /**
     * test delete exception
     */
    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * counting city list
     */
    @Test
    public void countCityList()
    {
        CityList cityList = new CityList();
        City city = new City("jessore","khulna");
        City city1 = new City ("mirpur","dhaka");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(2,cityList.count());

    }

    /**
     * delete exception
     */
    @Test
    public void deleteException()
    {
        CityList cityList = new CityList();
        City city = new City("jessore","khulna");
        City city1 = new City ("mirpur","dhaka");
        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });

    }

    /**
     * sorted by province
     */

    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1 =new City("Lon","Sing");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));
    }
}
