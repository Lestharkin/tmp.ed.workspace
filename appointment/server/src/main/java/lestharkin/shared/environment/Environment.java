package lestharkin.shared.environment;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Environment {
  /**
   * Singleton instance
   */
  private static Environment instance;
  private HashMap<String, String> variables;

  private Environment() {
    variables = new HashMap<>();
    loadVariables(getPathProperties());
  }
  
    private String getPathProperties() {
      return "/home/lestharkin/Projects/edu/java/lectures/issues/i007-appointment/server/env/env-linux.properties";
    }
  
  private void loadVariables(String path) {
    Properties properties = new Properties();
    try (FileInputStream fis = new FileInputStream(new File(path));) {
      properties.load(fis);
      String[] port = (properties.getProperty("PORTS")).split(",");
      String[] service = (properties.getProperty("SERVICES")).split(",");
      this.variables.put("IP", (String) properties.get("IP"));
      this.variables.put("PORT0", port[0]);
      this.variables.put("SERVICE0", service[0]);
      this.variables.put("PORT1", port[1]);
      this.variables.put("SERVICE1", service[1]);
      this.variables.put("DBPATH", (String) properties.get("DBPATH"));
      this.variables.put("DBDATEFMT", (String) properties.get("DBDATEFMT"));
      this.variables.put("DBTIMEFMT", (String) properties.get("DBTIMEFMT"));
    } catch (Exception e) {
      Logger.getLogger("Server").log(Level.WARNING, e.getMessage(), e);
    }
  }
  
  public static Environment getInstance() {
    if (Environment.instance == null) {
      Environment.instance = new Environment();
    }
    return Environment.instance;
  }

  public Map<String, String> getVariables() {
    return variables;
  }
}
