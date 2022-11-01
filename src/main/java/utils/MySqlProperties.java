package utils;

public enum MySqlProperties {

    DB_DRIVER("com.mysql.cj.jdbc.Driver"),
    DB_CONNECTION("jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC"),
    DB_USER("root"),
    DB_PASSWORD("0918");

    private final String value;

    private MySqlProperties(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
