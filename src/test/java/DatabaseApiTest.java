import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseApiTest {

    @Test
    public void createUserTest() throws SQLException, IOException {
        String configString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            configString = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File sample.json could not be read");
            System.exit(0);
        }
        ConfigReader configReader = new ConfigReader(configString);
        DatabaseApi databaseApi = new DatabaseApi(configReader.getPostgres_url(), configReader.getPostgres_user(), configReader.getPostgres_pass());

        assertTrue(databaseApi.createUser(21612226, "person_first_name", "person_last_name", "person"));
    }

    @Test
    public void isUserExistsTest() throws SQLException, IOException {
        String configString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            configString = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File sample.json could not be read");
            System.exit(0);
        }
        ConfigReader configReader = new ConfigReader(configString);
        DatabaseApi databaseApi = new DatabaseApi(configReader.getPostgres_url(), configReader.getPostgres_user(), configReader.getPostgres_pass());

        assertTrue(databaseApi.isUserExists(21612226));
    }

    @Test
    public void saveMessageTest() throws SQLException, IOException {
        String configString = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.json"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            configString = stringBuilder.toString();
        } catch (FileNotFoundException exception) {
            ColorPrinter.printFatalError("File sample.json could not be read");
            System.exit(0);
        }
        ConfigReader configReader = new ConfigReader(configString);
        DatabaseApi databaseApi = new DatabaseApi(configReader.getPostgres_url(), configReader.getPostgres_user(), configReader.getPostgres_pass());

        assertTrue(databaseApi.saveMessage(21612226, 1621672947, "Message from person"));

    }
}