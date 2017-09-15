package example.com.testzip.loader;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class CMDexPathInfo {

    public static int APK_DEX_SUM = 0;
    public static int INJECT_DEX_SUM = 0;
    public static String DOING_INJECT = "";

    public static final String getClassPathList(Context app) {
        if (Build.VERSION.SDK_INT >= 14) {
            return getClassPathList_GE_api14(app);
        } else {
            return getClassPathList_BL_api14(app);
        }
    }

    private static String getClassPathList_BL_api14(Context app) {
        String pathInfo = "";
        ClassLoader cl = app.getClassLoader();
        try {
            Object paths = getField(cl, cl.getClass(), "mPaths");
            int i = Array.getLength(paths);
            for (int k = 0; k < i; ++k) {
                String elem = (String) Array.get(paths, k);
                pathInfo += Integer.toString(k) + " Path:" + elem+ " ";
            }
            Object files = getField(cl, cl.getClass(), "mFiles");
            i = Array.getLength(files);
            for (int k = 0; k < i; ++k) {
                File file = (File)  Array.get(files, k);
                pathInfo += Integer.toString(k) + " File:" + file.toString() + " ";
            }
            Object zips = getField(cl, cl.getClass(), "mZips");
            i = Array.getLength(zips);
            for (int k = 0; k < i; ++k) {
                Object zip = Array.get(zips, k);
                String fileName = (String)getField(zip, zip.getClass(), "fileName");
                pathInfo += Integer.toString(k) + " Zip:" + fileName + " ";
            }
            Object dexs = getField(cl, cl.getClass(), "mDexs");
            i = Array.getLength(dexs);
            for (int k = 0; k < i; ++k) {
                Object dex = Array.get(dexs, k);
                String fileName = (String)getField(dex, dex.getClass(), "mFileName");
                pathInfo += Integer.toString(k) + " Dex:" + fileName + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathInfo;
    }

    private static String getClassPathList_GE_api14(Context app) {
        String pathInfo = "";
        ClassLoader cl = app.getClassLoader();
        try {
            Object pathList = getField(cl, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
            if (null == pathList)
                return pathInfo;

            Object elems = getField(pathList, pathList.getClass(), "dexElements");
            if (null == elems)
                return pathInfo;

            int i = Array.getLength(elems);
            for (int k = 0; k < i; ++k) {
                Object elem = Array.get(elems, k);

                Object objFile = getField(elem, elem.getClass(), "file");
                if (objFile == null)
                    continue;

                File file = (File) objFile;
                pathInfo += "#" + Integer.toString(k) + " File:" + file.toString();

                Object zipFile = getField(elem, elem.getClass(), "zipFile");
                if (zipFile == null)
                    continue;

                Object objFileName = getField(zipFile, zipFile.getClass(), "fileName");
                if (objFileName == null)
                    continue;

                String zipFileName = (String)objFileName;
                pathInfo += " Zip:" + zipFileName;
                Object dexFile = getField(elem, elem.getClass(), "dexFile");
                if (null == dexFile)
                    continue;

                Object objdexFileName = getField(dexFile, dexFile.getClass(), "mFileName");
                if (objdexFileName == null)
                    continue;

                String dexFileName = (String)objdexFileName;
                pathInfo += " Dex:" + dexFileName + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathInfo;
    }

    private static Object getField(Object obj, Class<?> cl, String field)
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field localField = cl.getDeclaredField(field);
        localField.setAccessible(true);
        return localField.get(obj);
    }

    public static boolean isSingleDexInjectSuccess(Context app, String dexName) {
        ClassLoader cl = app.getClassLoader();
        try {
            Object pathList = getField(cl, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
            if (null == pathList)
                return false;

            Object elems = getField(pathList, pathList.getClass(), "dexElements");
            if (null == elems) {
                return false;
            }

            if(INJECT_DEX_SUM == 0){
                INJECT_DEX_SUM = Array.getLength(elems);
            }
            Object[] elem = (Object[]) elems;
            for (Object object : elem) {
                Object file = getField(object, object.getClass(), "file");
                if(dexName.trim().equals(((File) file).getName())){
                    Log.i("DexInject", "found! # " + ((File) file).getName());
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e("DexInject", e.toString());
        }
        return false;
    }
}
