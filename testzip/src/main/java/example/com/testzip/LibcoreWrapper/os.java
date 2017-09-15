package example.com.testzip.LibcoreWrapper;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class os {
	public static void close(FileDescriptor fd) {
		try {
			Class<?> clz = Class.forName("libcore.io.Libcore");
			try {
				Field field = clz.getDeclaredField("os");
				try {
					field.setAccessible(true);
					Object obj = field.get(null);
					Class<?> os = obj.getClass(); 
					try {
						Method mtdClose = os.getMethod("close", FileDescriptor.class);
						try {
							mtdClose.invoke(obj, fd);
						} catch (InvocationTargetException e) {
						} catch (NullPointerException e){
						} catch (IllegalAccessException e) {
						} catch (IllegalArgumentException e) {
						}
					} catch (NoSuchMethodException e) {
					}
				} catch (NullPointerException e) {
				} catch (IllegalAccessException e) {
				} catch (IllegalArgumentException e) {
				}
			} catch (NoSuchFieldException e) {
			}
		} catch (ClassNotFoundException e) {
		}
	}
	public static StructStat stat(String path) {
		StructStat sta = null;
		try {
			Class<?> clz = Class.forName("libcore.io.Libcore");
			try {
				Field field = clz.getDeclaredField("os");
				try {
					field.setAccessible(true);
					Object obj = field.get(null);
					Class<?> os = obj.getClass(); 
					try {
						Method mtdStat = os.getMethod("stat", String.class);
						try {
							sta = (StructStat)mtdStat.invoke(obj, path);
						} catch (InvocationTargetException e) {
						} catch (NullPointerException e){
						} catch (IllegalAccessException e) {
						} catch (IllegalArgumentException e) {
						}
					} catch (NoSuchMethodException e) {
					}
				} catch (NullPointerException e) {
				} catch (IllegalAccessException e) {
				} catch (IllegalArgumentException e) {
				}
			} catch (NoSuchFieldException e) {
			}
		} catch (ClassNotFoundException e) {
		}
		return sta;
	}
}
