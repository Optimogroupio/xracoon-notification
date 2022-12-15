package io.optimogroup.xracoon.xracoonnotification.utils;

import org.apache.logging.log4j.util.Strings;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Paata Lominadze
 * @version 1.0.0.1
 */
public class Utils {

    private static Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static double round(double value, int decimalPlace) {
        double power_of_ten = 1;
        double fudge_factor = 0.05;
        while (decimalPlace-- > 0) {
            power_of_ten *= 10.0d;
            fudge_factor /= 10.0d;
        }
        return Math.round((value + fudge_factor) * power_of_ten) / power_of_ten;
    }

    public static String formatTimestamp(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return sdf.format(timestamp);
    }

    public static Long formatTimestampInMillis(Timestamp timestamp) {
        if (timestamp == null) {
            return -1L;
        }
        return timestamp.getTime();
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNumeric(String str) {
        if (str == null)
            return false;
        return numberPattern.matcher(str).matches();
    }

    public static <T> T isNull(T check_expression, T replacement_value) {
        if (check_expression == null)
            return replacement_value;
        return check_expression;
    }

    public static <T> T iif(boolean boolean_expression, T true_value, T false_value) {
        if (boolean_expression)
            return true_value;
        return false_value;
    }

    public static boolean isNullOrEmpty(Collection c) {
        return c == null || c.isEmpty();
    }

    public static Boolean getBoolean(Object o) {
        if (o == null)
            return null;
        if (o instanceof Boolean)
            return (Boolean) o;
        if (o instanceof Number)
            return 0 != ((Number) o).longValue();
        return Boolean.parseBoolean(o.toString());
    }

    public static Byte getByte(Object o) {
        if (o == null)
            return null;
        if (o instanceof Byte)
            return (Byte) o;
        if (o instanceof Number)
            return ((Number) o).byteValue();
        if (Strings.isBlank(o.toString()))
            return null;
        return Byte.parseByte(o.toString());
    }

    public static Short getShort(Object o) {
        if (o == null)
            return null;
        if (o instanceof Short)
            return (Short) o;
        if (o instanceof Number)
            return ((Number) o).shortValue();
        if (Strings.isBlank(o.toString()))
            return null;
        return Short.parseShort(o.toString());
    }

    public static Integer getInteger(Object o) {
        if (o == null)
            return null;
        if (o instanceof Integer)
            return (Integer) o;
        if (o instanceof Number)
            return ((Number) o).intValue();
        if (Strings.isBlank(o.toString()))
            return null;
        return Integer.parseInt(o.toString());
    }

    public static Long getLong(Object o) {
        if (o == null)
            return null;
        if (o instanceof Long)
            return (Long) o;
        if (o instanceof Number)
            return ((Number) o).longValue();
        if (Strings.isBlank(o.toString()))
            return null;
        return Long.parseLong(o.toString());
    }

    public static Float getFloat(Object o) {
        if (o == null)
            return null;
        if (o instanceof Float)
            return (Float) o;
        if (o instanceof Number)
            return ((Number) o).floatValue();
        if (Strings.isBlank(o.toString()))
            return null;
        return Float.parseFloat(o.toString());
    }

    public static Double getDouble(Object o) {
        if (o == null)
            return null;
        if (o instanceof Double)
            return (Double) o;
        if (o instanceof Number)
            return ((Number) o).doubleValue();
        if (Strings.isBlank(o.toString()))
            return null;
        return Double.parseDouble(o.toString());
    }

    public static String getString(Object o) {
        if (o == null)
            return null;
        if (o instanceof String)
            return (String) o;
        return o.toString();
    }

    public static String getNonEmptyString(Object o) {
        if (o == null)
            return null;
        String s = toString(o).trim();
        if (Strings.isEmpty(s))
            return null;
        return s;
    }

    public static Timestamp getTimestamp(Object o) {
        if (o == null)
            return null;
        if (o instanceof Timestamp)
            return (Timestamp) o;
        if (o instanceof Number)
            return new Timestamp(((Number) o).longValue());
        return null;
    }

    public static boolean isTrue(Boolean b) {
        if (b == null)
            return false;
        return b;
    }


    public static boolean stringIsEmpty(String parameter) {
        return parameter == null || parameter.trim().equalsIgnoreCase("");
    }

    public static boolean stringIsNotEmpty(String parameter) {
        return parameter != null && !parameter.trim().equalsIgnoreCase("");
    }

    public static boolean longIsEmpty(Long parameter) {
        return parameter == null;
    }

    public static boolean doubleIsEmpty(Double parameter) {
        return parameter == null;
    }

    public static boolean integerIsEmpty(Integer parameter) {
        return parameter == null;
    }

    public static boolean booleanIsEmpty(Boolean parameter) {
        return parameter == null;
    }

    public static boolean listIsEmpty(List parameter) {
        return parameter == null || parameter.isEmpty();
    }

    public static boolean listIsNotEmpty(List parameter) {
        return parameter != null && !parameter.isEmpty();
    }

    public static boolean mapIsEmpty(Map parameter) {
        return parameter == null || parameter.isEmpty();
    }

    public static boolean mapIsNotEmpty(Map parameter) {
        return parameter != null && !parameter.isEmpty();
    }

    public static boolean arrayIsNotEmpty(Object[] parameter) {
        return !arrayIsEmpty(parameter);
    }

    public static boolean arrayIsEmpty(Object[] parameter) {
        return parameter == null || parameter.length == 0;
    }

    public static boolean longIsNotEmpty(Long parameter) {
        return parameter != null;
    }

    public static boolean doubleIsNotEmpty(Double parameter) {
        return parameter != null;
    }

    public static boolean integerIsNotEmpty(Integer parameter) {
        return parameter != null;
    }


    public static boolean stringIsEmptyObj(Object parameter) {
        return parameter == null || parameter.toString().trim().equalsIgnoreCase("");
    }

    public static boolean stringNotEmptyObj(Object parameter) {
        return parameter != null && !parameter.toString().trim().equalsIgnoreCase("");
    }

    public static boolean isLong(Object object) {
        try {
            Long.parseLong(object.toString().trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkVariableToBoolean(Object variable) {
        return !(variable instanceof Boolean);
    }

    public static boolean checkVariableToListEmpty(Object variable) {
        return !(variable instanceof List) || ((List) variable).isEmpty();
    }

    public static boolean checkVariableToList(Object variable) {
        return !(variable instanceof List);
    }


    public static Long getRowValueLong(Object val) {
        return val == null || val.toString().trim().equalsIgnoreCase("") ? null : isLong(val) ? Long.parseLong(val.toString().trim()) : null;
    }

    public static Boolean getRowValueBoolean(Object val) {
        return val == null ? null : (val instanceof Boolean ? (Boolean) val : Long.parseLong(val.toString().trim()) == 1);
    }

    public static Double getRowValueDouble(Object val) {
        return val == null ? null : Double.parseDouble(val.toString().trim());
    }

    public static List<String> getRowValueList(Object val) {
        return val == null ? null : (List<String>) val;
    }

    public static List getRowValueListObject(Object val) {
        return val == null ? null : (List) val;
    }


    public static String getRowValueSt(Object val) {
        return val == null ? null : val.toString();
    }

    public static String stigifyCommaString(String data) {
        if (stringIsEmpty(data)) {
            return data;
        }
        return data.replaceAll(",", ";");
    }

    public static Long getLongDefault(Object object, Long defaultValue) throws Exception {
        try {
            return object == null ? defaultValue : Long.parseLong(object.toString());
        } catch (Exception var2) {
            throw new Exception("Utils.getLongDefault:" + var2.toString());
        }
    }

    public static Integer getIntegerDefault(Object object, Integer defaultValue) throws Exception {
        try {
            return object == null ? defaultValue : Integer.parseInt(object.toString());
        } catch (Exception var2) {
            throw new Exception("Utils.getLongDefault:" + var2.toString());
        }
    }

    public static Long getLongDefault(Long parameter, Long defaultValue) {
        try {
            return parameter == null ? defaultValue : parameter;
        } catch (Exception var2) {
            return defaultValue;
        }
    }

    public static Double getDoubleDefault(Double parameter, Double defaultValue)  {
        try {
            return parameter == null ? defaultValue : parameter;
        } catch (Exception var2) {
            return defaultValue;
        }
    }

    public static String getStringDefault(String parameter, String defaultValue) throws Exception {
        try {
            return stringIsEmpty(parameter) ? defaultValue : parameter;
        } catch (Exception var2) {
            throw new Exception("Utils.getStringDefault:" + var2.toString());
        }
    }

    public static Long getLongDefault(Object object) throws Exception {
        return getLongDefault(object, -1L);
    }

    public static String getUniqueFileName(String objectName) {
        String fileName = String.valueOf(System.nanoTime());
        if (!objectName.isEmpty()) {
            String[] strs = objectName.split("\\.");
            String extension = strs[strs.length - 1];
            if (!extension.isEmpty()) {
                fileName = String.format("%s.%s", fileName, extension);
            }
        }
        return fileName;
    }


    public static Timestamp getRowValueDateTime(Object val) {
        return val == null ? null : (Timestamp) val;
    }

    public static Date getRowValueDate(Object val) {
        return val == null ? null : (Date) val;
    }

    public static Map getRowValueMap(Object val) {
        return val == null ? null : (Map) val;
    }

    public static Integer getRowValueInteger(Object val) {
        return val == null ? null : Integer.parseInt(val.toString().trim());
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }


}
