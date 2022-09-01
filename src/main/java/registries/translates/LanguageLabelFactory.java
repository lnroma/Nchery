package registries.translates;

import java.util.HashMap;

public class LanguageLabelFactory {
    private final String namespace = "registries.translates";
    private HashMap<String, TranslateInterface> objectList;

    /**
     *  get class translates factory
     * @param key
     * @return Object
     * @throws Exception
     */
    public TranslateInterface getClassTranslates(String key) throws Exception {
        String locale = "en";
        key = key.substring(0,1).toUpperCase() + key.substring(1).toUpperCase();
        key = namespace + locale + key + "Translates";

        if (objectList.containsKey(key)) {
            return objectList.get(key);
        }

        try {
            Class translateClass = Class.forName(key);
            TranslateInterface object = (TranslateInterface) translateClass.getDeclaredConstructor().newInstance();
            objectList.put(key, object);

            return object;
        } catch (Exception classNotFoundException) {
            throw new Exception("class translates " + key + " not found");
        }
    }
}
