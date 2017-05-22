package sample;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Contains the configuration of the application. The preferences
 * of an user are saved in this object and then serialized to a json
 * file.
 */
public class AppConfig {

    private static final String CONFIG_FILE_PATH = "./config.json";

    @Getter
    @Setter
    private String defaultSavePath;

    @Getter
    @Setter
    private String defaultExportFormat;

    @Getter
    @Setter
    private Boolean syntaxHStatus;

    @Getter
    @Setter
    private Double convertFromSyntaxVersion;

    @Getter
    @Setter
    private Double convertToSyntaxVersion;

    @Getter
    @Setter
    private String instanceExportFormat;

    @Getter
    @Setter
    private String instanceSavePath;

    public AppConfig() {
        loadConfig();
    }

    /**
     * Loads the configuration from the json configuration file into this class.
     */
    private void loadConfig() {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(CONFIG_FILE_PATH));
            String configString = new String(encoded, "UTF-8");
            JSONObject jsonObject = new JSONObject(configString);

            this.setDefaultSavePath((String) jsonObject.get("defaultSavePath"));
            this.setDefaultExportFormat((String) jsonObject.get("defaultExportFormat"));
            this.setConvertFromSyntaxVersion((Double) jsonObject.get("convertFromSyntaxVersion"));
            this.setConvertToSyntaxVersion((Double) jsonObject.get("convertToSyntaxVersion"));
            this.setSyntaxHStatus((Boolean) jsonObject.get("syntaxHStatus"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the changes made to the default setting of the application to the
     * configuration file, this way those changes will also be available when the user
     * open the app the next time.
     */
    public void saveConfig() {

        JSONObject jsonConfig = new JSONObject();
        jsonConfig.put("defaultSavePath", defaultSavePath);
        jsonConfig.put("defaultExportFormat", defaultExportFormat);
        jsonConfig.put("syntaxHStatus", syntaxHStatus);
        jsonConfig.put("convertFromSyntaxVersion", convertFromSyntaxVersion);
        jsonConfig.put("convertToSyntaxVersion", convertToSyntaxVersion);

        try {
            Files.write(Paths.get(CONFIG_FILE_PATH), jsonConfig.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


