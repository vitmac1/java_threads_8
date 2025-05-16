package au.id.deejay.webserver.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for parsing query parameters from a URI.
 */
public class QueryParams {

    /**
     * Parses the query string from a given URI and returns a map of key-value pairs.
     *
     * @param uri the URI containing the query string
     * @return a map of query parameters
     */
    public static Map<String, String> parse(URI uri) {
        Map<String, String> params = new HashMap<>();
        String query = uri.getQuery();

        if (query == null || query.isEmpty()) {
            return params;
        }

        String[] pairs = query.split("&");

        for (String pair : pairs) {
            String[] kv = pair.split("=", 2);
            try {
                String key = URLDecoder.decode(kv[0], "UTF-8");
                String value = kv.length > 1 ? URLDecoder.decode(kv[1], "UTF-8") : "";
                params.put(key, value);
            } catch (UnsupportedEncodingException e) {
                // Nunca deve acontecer com UTF-8, mas necessário no Java 8
                throw new RuntimeException("UTF-8 encoding not supported", e);
            }
        }

        return params;
    }

}
