package workshops;

import java.sql.*;
import java.util.Scanner;

import static utils.MySqlProperties.*;

public class Workshop2 {

    public static void main(java.lang.String[] args) {


        int countryIdFromUser = ask();

        System.out.println("Jakie miasto chcesz dodać?");


        final var query = new Scanner(System.in).nextLine();

        final var addCity = insertCity(query, countryIdFromUser);

        if (addCity) {
            System.out.println("Miasto zostało poprawnie dodane!");
        }
    }

    private static int ask() {
        System.out.println("Do jakiego kraju chcesz dodać miasto?");
        System.out.println("Aby wybrać polskę wybierz - 1 ");
        System.out.println("Aby wybrać niemcy wybierz - 2");
        System.out.println("Aby wybrać meksyk wybierz - 3");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String select = "0";
            if (scanner.hasNextLine()) {
                select = scanner.nextLine();
            }

            switch (select) {
                case "1":
                    int polandId = 76;
                    return polandId;
                case "2":
                    int germanyId = 38;
                    return germanyId;
                case "3":
                    int mexicoID = 60;
                    return mexicoID;
                default:
                    System.out.println("Wybierz od  1 do 3");
            }
        }
        return 0;
    }

    public static boolean insertCity(String query, int countryId) {
        if (query == null || query.isBlank() || query.length() < 2) {
            System.out.println("Zbyt krótka nazwa miasta!");
            return false;
        }

        try (final Connection connection = DriverManager.getConnection(DB_CONNECTION.getValue(), DB_USER.getValue(),
                DB_PASSWORD.getValue())) {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO city (city, country_id, last_update)" +
                    " VALUES (?, ? , ?);");
            preparedStatement.setString(1, query);
            preparedStatement.setInt(2, countryId);
            preparedStatement.setTimestamp(3, timestamp);

            preparedStatement.executeUpdate();

            int executeUpdate = preparedStatement.executeUpdate();

            if (executeUpdate == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
