package util;

import util.http.Parameter;
import util.http.ReqParameter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReverseReqParameter extends ReqParameter {
    Object javaShellReverse;
    public ReverseReqParameter(Object javaShellReverse){
        super();
        this.javaShellReverse = javaShellReverse;
    }

    public Parameter add(String key, byte[] value) {
        key = getKey(key, "parmaMap");
        this.addParameterByteArray(key, value);
        return this;
    }

    public Parameter add(String key, String value) {
        if (key.equals("evalClassName") || key.equals("methodName")){
            value = getKey(value, "funMap");
        }
        key = getKey(key, "parmaMap");
        this.addParameterString(key, value);
        return this;
    }

    public String getKey(String key, String fieldName){
        String result = null;
        try {
            Field field = this.javaShellReverse.getClass().getField(fieldName);
            field.setAccessible(true);
            Object object = field.get(this.javaShellReverse);
            Method method = object.getClass().getDeclaredMethod("get", Object.class);;
            method.setAccessible(true);
            result = (String) method.invoke(object, key);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result == null ? key: result;
    }
}
