package example.com.testzip.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/**
 * Created by shenzhixin on 2017/9/11.
 */

public class DexHelper {
    private static boolean mSubDexsLoaded = false;
    private static long mLoadSubdexStartTime = 0l;
    private static long mLoadSubdexEndTime = 0l;
    private static final String TAG = "DEXHELPER";


    public static void installDex(Context context){
        boolean system = false;
        if(system){
            long start = System.currentTimeMillis();
            android.support.multidex.MultiDex.install(context);
            long duration = System.currentTimeMillis() - start;
        }else{
            long start = System.currentTimeMillis();
            loadSubDex(context);
            long duration = System.currentTimeMillis() - start;
        }
    }
    static File lockFile = null;
    static FileLock lockFileLock = null;
    static FileOutputStream lockFileOutputStream = null;
    /**
     * 加载其他的dex
     * @param context
     */
    private static void loadSubDex(Context context){
        if(context == null) {
            return;
        }
        SecondaryDexEx.logpath('#');
        mLoadSubdexStartTime = System.currentTimeMillis();

        try {
            lockFile = new File(context.getFilesDir(), "ddddd" + "_subdex.lck");
            lockFileOutputStream = new FileOutputStream(lockFile);
            lockFileLock = lockFileOutputStream.getChannel().lock();
            //Log.e("lololo","lock");
            SecondaryDexEx.loadSecondaryDex(context);
            } catch (IOException e) {
                SecondaryDexEx.logpath(0);
                // Retry sub-dex inject again without file lock.
                SecondaryDexEx.loadSecondaryDex(context);
            } finally {
                if (null != lockFileLock)
                    try {
                        lockFileLock.release();
                    } catch (IOException e) {
                    }

                if (lockFileOutputStream != null) {
                    try {
                        lockFileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (lockFile.exists())
                    lockFile.delete();
            }

            mLoadSubdexEndTime = System.currentTimeMillis();
            mSubDexsLoaded = true;
    }


    private static void demo(ApplicationInfo applicationInfo){
        File sourceApk = new File(applicationInfo.sourceDir);
        try {
            long currentCrc = getZipCrc(sourceApk);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File sourceApk;
    private static long currentCrc;
    /**
     * apk有没有变过
     * @return
     */
    public static boolean isApkModified(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = getApplicationInfo(context);
        sourceApk = new File(applicationInfo.sourceDir);
        currentCrc = DexHelper.getZipCrc(sourceApk);
        return isModified(context,sourceApk,currentCrc)/*true*/;
    }


    private static ApplicationInfo getApplicationInfo(Context context) throws PackageManager.NameNotFoundException {
        PackageManager pm;
        String packageName;
        try {
            pm = context.getPackageManager();
            packageName = context.getPackageName();
        } catch (RuntimeException var4) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", var4);
            return null;
        }

        if(pm != null && packageName != null) {
            ApplicationInfo applicationInfo = pm.getApplicationInfo(packageName, 128);
            return applicationInfo;
        } else {
            return null;
        }
    }

    private static boolean isModified(Context context, File archive, long currentCrc) {
        SharedPreferences prefs = getMultiSp(context);
        long spTimeStamp = prefs.getLong("timestamp", -1L);
        long spCrc       = prefs.getLong("crc", -1L);
        return spTimeStamp != getTimeStamp(archive) || spCrc != currentCrc;
    }

    private static SharedPreferences getMultiSp(Context context) {
        return context.getSharedPreferences("multidexcml",Context.MODE_MULTI_PROCESS);
    }

    private static long getTimeStamp(File archive) {
        long timeStamp = archive.lastModified();
        if(timeStamp == -1L) {
            --timeStamp;
        }

        return timeStamp;
    }

    public static long getZipCrc(File archive) throws IOException{
        long computedValue = ZipUtil.getZipCrc(archive);
        if(computedValue == -1L) {
            --computedValue;
        }

        return computedValue;
    }


    public static void saveFileInfo(Context context) throws IOException{
        if(sourceApk != null){
            SharedPreferences prefs = getMultiSp(context);
            SharedPreferences.Editor edit = prefs.edit();
            long timeStamp = getTimeStamp(sourceApk);
            long crc = getZipCrc(sourceApk);
           // LauncherLog.e("shenzhixinjjj","timestamp:"+timeStamp);
           // LauncherLog.e("shenzhixinjjj","crc:"+crc);
            edit.putLong("timestamp", timeStamp);
            edit.putLong("crc", crc);
            edit.apply();
        }
    }



    public static boolean isFileModified(){
        return false;
    }
}
