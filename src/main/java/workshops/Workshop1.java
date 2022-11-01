package workshops;

import Model.City;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static utils.MySqlProperties.*;

public class Workshop1 {

    public static void main(String[] args) {


        System.out.println("Podaj kraj którego miasta chcesz wyświetlić");
        final String query = new Scanner(System.in).nextLine();

        final var cities = getCities(query);

        System.out.println("Miasta podanego przez ciebie kraju to: " + cities);
    }

    public static List<City> getCities(String query) {
        if (query == null || query.isBlank() || query.length() < 2){
            return Collections.emptyList();
        }
        List<City> cities = new LinkedList<>();
        try(final Connection connection = DriverManager.getConnection(DB_CONNECTION.getValue(), DB_USER.getValue(),
                DB_PASSWORD.getValue());){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ci.city FROM city as ci " +
                    "JOIN country as co ON ci.country_id = co.country_id " +
                    "WHERE UPPER(co.country) LIKE UPPER(?);");
            preparedStatement.setString(1,"%" + query + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                City city = new City(resultSet.getString(1));
                cities.add(city);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return cities;
    }
}
