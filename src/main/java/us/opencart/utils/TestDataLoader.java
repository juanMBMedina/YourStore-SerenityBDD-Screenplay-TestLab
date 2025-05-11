package us.opencart.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import us.opencart.exceptions.TestDataLoadException;
import us.opencart.models.LoginUser;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TestDataLoader {

    private static final String DEFAULT_PATH = "src/test/resources/testdata/";

    private TestDataLoader() {
    }

    /**
     * Loads an object from a JSON file using a key inside a map.
     * @param fileName the name of the file (e.g., "users.json")
     * @param key the key within the JSON map
     * @param clazz the class type of the expected object
     * @return an object of the specified type
     * @param <T> the type of the object to return
     */
    public static <T> T load(String fileName, String key, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(DEFAULT_PATH + fileName);

            Map<String, T> data = mapper.readValue(
                    file,
                    mapper.getTypeFactory().constructMapType(Map.class, String.class, clazz)
            );

            if (!data.containsKey(key)) {
                throw new IllegalArgumentException("No data found for key: " + key);
            }

            return data.get(key);
        } catch (IOException e) {
            throw new TestDataLoadException("Error loading test data from " + fileName, e);
        }
    }

    public static LoginUser loadCorrectUser() {
        return load("dataLoginFeature.json", "loginExistUser", LoginUser.class);
    }

    public static LoginUser loadWrongLabelUser() {
        // Can Throws: TestDataLoadException
        return load("wrongDataLoginFeature.json", "loginWrongUser", LoginUser.class);
    }

    public static LoginUser loadKeyDoesNotExistUser() {
        // Can Throws: IllegalArgumentException
        return load("dataLoginFeature.json", "noKey", LoginUser.class);

    }

}

