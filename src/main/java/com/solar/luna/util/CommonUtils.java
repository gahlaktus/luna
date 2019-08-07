package com.solar.luna.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

import static com.google.common.net.HttpHeaders.X_FORWARDED_FOR;

/**
 * @author huangzhibo
 * @date 2019-08-07
 */
public class CommonUtils {

    public static Map<String, String> generateParamMap(Object bean) throws Exception {
        Map<String, String> paramMap = BeanUtils.describe(bean);
        paramMap.remove("class");
        return paramMap;
    }

    public static Map<String, String> convertJson2Map(String jsonStr) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>() {};
        return mapper.readValue(jsonStr, typeReference);
    }


    private static final String UNKNOWN_STRING = "unknown";
    private static final String COMMA = ",";
    private static final int IP_LENGTH = 15;
    public static String getClientAddress(HttpServletRequest request) {

        String ip = request.getHeader(X_FORWARDED_FOR);
        if (StringUtils.isBlank(ip) || UNKNOWN_STRING.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || UNKNOWN_STRING.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || UNKNOWN_STRING.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip != null && ip.length() > IP_LENGTH) {
            if (ip.indexOf(COMMA) > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    public static <T> T toJavaObject(String jsonStr, Class<T> clazz) {
        T obj;
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            obj = mapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return obj;
    }

    public static String toJsonString(Object obj) {
        String jsonStr;
        if (obj == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return jsonStr;
    }

}
