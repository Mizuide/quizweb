package quizweb;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class TestUtil {
    /**
     * privateメソッドの実行を行うためのメソッドです。 （テスト用）
     * 
     * @param executor   メソッドを実行するインタンス
     * @param methodName メソッド名
     * @param args       引数の配列
     * @param argClasses 引数のクラスの配列
     * @return 実行結果
     */
    public static Object doPrivateMethod(Object executor, String methodName, Object[] args, Class[] argClasses) {
        try {
            Class clazz = executor.getClass();
            Method method = clazz.getDeclaredMethod(methodName, argClasses);
            method.setAccessible(true);
            return method.invoke(executor, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setPrivateField(Object owner, String fieldName, Object value) {
        Class clazz = owner.getClass();
        try {
            Field field = owner.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            field.set(owner, value);

        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
