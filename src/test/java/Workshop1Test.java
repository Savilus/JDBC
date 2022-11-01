import Model.City;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.DbConnector;
import workshops.Workshop1;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Workshop1Test {

    @BeforeEach
    void setUp() throws Exception{
        DbConnector.importSakilaDatabase();
    }

    @AfterEach
    void tearDown(){
        DbConnector.cleanUp();
    }

    @Test
    void shouldReturnPolishCities() {
        //WHEN
        final List<String> polishCities = Workshop1.getCities(DbConnector.JDBC_URL);

        //THEN
        assertThat(polishCities).containsExactly(
                "Bydgoszcz",
                "Czestochowa",
                "Jastrzebie-Zdrj",
                "Kalisz",
                "Lublin",
                "Plock",
                "Tychy",
                "Wroclaw"
        );
    }
    @Test
    void shouldReturnMexicoCities(){
        final List<String> mexicoCities = Workshop1.getCities(DbConnector.JDBC_URL);

        assertThat(mexicoCities).containsExactly(
                "Acua",
                "Allende",
                "Atlixco",
                "Carmen",
                "Celaya",
                "Coacalco de Berriozbal",
                "Coatzacoalcos",
                "Cuauhtmoc",
                "Cuautla",
                "Cuernavaca",
                "El Fuerte",
                "Guadalajara",
                "Hidalgo",
                "Huejutla de Reyes",
                "Huixquilucan",
                "Jos Azueta",
                "Jurez",
                "La Paz",
                "Matamoros",
                "Mexicali",
                "Monclova",
                "Nezahualcyotl",
                "Pachuca de Soto",
                "Salamanca",
                "San Felipe del Progreso",
                "San Juan Bautista Tuxtepec",
                "Torren",
                "Uruapan",
                "Valle de Santiago",
                "Zapopan"
        );
    }
}
