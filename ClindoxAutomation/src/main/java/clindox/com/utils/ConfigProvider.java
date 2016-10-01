package clindox.com.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Ritesh on 01/10/2016.
 */
public class ConfigProvider {
    public static Properties Config;

    public  void LoadConfig()
    {
        try {
            /************ File properties configuration ***************/
            // Get the inputStream
            //final InputStream inputStream =
             //       this.getClass().getClassLoader().getResourceAsStream("config.properties");
            Config = new Properties();
            Config.load(new FileInputStream("src/test/Resources/config.properties"));
            // load the inputStream using the Properties
            //Config.load(inputStream);

            /*********** End configuration properties file **************/
        }
        catch (Exception ex)
        {
            System.out.println("error loading config.");
        }

    }

    public String getConfiguration(String configuration)
    {
        if(Config == null) LoadConfig();
        return Config.getProperty(configuration,"");
    }

    public void SetConfiguration(String configuration, String value)
    {
        if(Config == null) LoadConfig();
        Config.setProperty(configuration,value);
    }

}
