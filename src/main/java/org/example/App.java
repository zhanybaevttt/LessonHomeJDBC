package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* таблица бар - Шаарлар, Олколор, Шаар башчылары

        Ар бир таблицага жок дегенде 5тен маалымат киргизуу керек

        Statement жана PreparedStatement-ти колдонуу

        Шаарларды жана олколорду ArrayList-ке сактоо
        Базадан шаарды id менен алып консолго чыгарышыбыз керек
       / *
/**
 * Hello world!
 *
 */

public class App {
    public static void main(String[] args) {

        insertTablecity(1,"London");
        insertTablecity(2,"Paris");
        insertTablecity(3,"Chicago");
        insertTablecity(4,"Tocyo");
        insertTablecity(5,"Seul");
        System.out.println("_______________________");
        insertTablestange(1,"USA");
        insertTablestange(2,"France");
        insertTablestange(3,"Germany");
        insertTablestange(4,"Japan");
        insertTablestange(5,"Italy");
        System.out.println("_________________________");

        insertTablecitylider(1,"Atabek","Meer");
        insertTablecitylider(2,"Azamat","programmist");
        insertTablecitylider(3,"Talant","Meer");
        insertTablecitylider(4,"Kylymbek","IT");
        insertTablecitylider(5,"Syimyk","It");

    }

    public static void creatstange() {
        String sql = "CREATE TABLE IF NOT EXISTS stange(\n" +
                "    id INT PRIMARY KEY ,\n" +
                "    name VARCHAR(40) NOT NULL ,\n" +
                "    stange_id INT REFERENCES stange(id),\n" +
                "    city_id  INT REFERENCES city (id)\n" +
                "\n" +
                "\n" +
                ");";
        try (Connection conn = Dbase.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("uspeshno koshuldu");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void creatCity() {
        String sql = "CREATE TABLE IF NOT EXISTS city\n" +
                "(" +
                "    id         INT PRIMARY KEY," +
                "    name       VARCHAR(30) NOT NULL," +
                "    lider_id INT REFERENCES citylider(id)" +
                "" +
                "" +
                ");";

        try (Connection conn = Dbase.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("creat table is succesfylly");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertTablecity(int id, String name) {
        String SQL = "Insert into city(id,name ) values(?,?)";
        try (Connection connection = Dbase.connection();
             PreparedStatement prep = connection.prepareStatement(SQL)) {
            prep.setInt(1, id);
            prep.setString(2, name);
            prep.executeUpdate();
            System.out.println(" Succesfully added  " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void creatcitylider() {

        String sql = "\n" +
                "CREATE TABLE IF NOT EXISTS citylider(\n" +
                "    id INT PRIMARY KEY ,\n" +
                "    name VARCHAR(40) NOT NULL\n" +
                "\n" +
                ");";
        try (Connection conn = Dbase.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("uspeshno koshuldu");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void insertTablecitylider(int id, String name,String position) {
        String SQL = "Insert into citilider(id,name ,position) values(?,?,?)";
        try (Connection connection = Dbase.connection();
             PreparedStatement prep = connection.prepareStatement(SQL)) {
            prep.setInt(1, id);
            prep.setString(2, name);
            prep.setString(2,position);
            prep.executeUpdate();
            System.out.println(" Succesfully added  " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Stange> stangeList() {
        String sql = "SELECT * FROM stange";
        List<Stange> list = new ArrayList<>();
        try (Connection conn = Dbase.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Stange stange = new Stange();
                stange.setId(resultSet.getInt(1));
                stange.setName(resultSet.getCursorName());
                list.add(stange);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public static void insertTablestange(int id, String name) {
        String SQL = "Insert into stange(id,name ) values(?,?)";
        try (Connection connection = Dbase.connection();
             PreparedStatement prep = connection.prepareStatement(SQL)) {
            prep.setInt(1, id);
            prep.setString(2, name);
            prep.executeUpdate();
            System.out.println(" Succesfully added  " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Stange> cityeList() {
        String sql = "SELECT * FROM sity";
        List<City> list = new ArrayList<>();
        try (Connection conn = Dbase.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt(1));
                city.setName(resultSet.getCursorName());
                list.add(city);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityeList();
    }

    public static List<CityLeder> cityLederList() {
        String sql = "SELECT * FROM citylider";
        List<CityLeder> list = new ArrayList<>();
        try (Connection conn = Dbase.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                CityLeder leder = new CityLeder();
                leder.setId(resultSet.getInt(1));
                leder.setName(resultSet.getCursorName());
                list.add(leder);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}