package example.com.testzip.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import example.com.testzip.LibcoreWrapper.StructStat;
import example.com.testzip.LibcoreWrapper.os;

/**
 * Created by koala on 15/6/25.
 */
public class SecondaryDexEx {
    private static final int SUB_DEX_NUM_DEBUG = 3;
    private static final int SUB_DEX_NUM_RELEASE = 2;
    public static final boolean ON = true;

    //use classes2.dex.lzma in apk from android 4.x+
    //use classes2.dex in apk for android 5.x+ 4.x-

    private static final String TAG = "SubDex";

    /***************************************/
    private static int SUB_DEX_NUM = 10;       // 当前subDex个数
    private static final String CLASSES_PREFIX = "classes";
    private static final String DEX_POSTFIX = ".dex";
    private static final String JAR_POSTFIX = ".jar";
    private static final String LZMA_POSTFIX = ".lzma";
    private static final String HASH_POSTFIX = ".hash";
    private static final String SUBDEX_CFG = "subdex_cfg2.hash";
    private static final HashSet<LoadedDex> msLoadedDexList = new HashSet<>();
    /***************************************/

    private static final int BUF_SIZE = 1024 * 32;//大点有什么问题？
    private static boolean mIsLoaded = false;
    private static final long system_cache_limit = 32 * 1024 * 1024l;
    static String mSubdexExt = DEX_POSTFIX;

    private static class LoadedDex {
        String dexFileName;
        String dexHashName;
        File dexFile;
        ZipEntry zipEntry;

        LoadedDex(File dir, String name) {
            dexFile = new File(dir, name);
            dexFileName = dexFile.getName();
            dexHashName = dexFileName + HASH_POSTFIX;
        }

        LoadedDex(File dir, String name, ZipEntry zipE) {
            dexFile = new File(dir, name);
            dexFileName = dexFile.getName();
            dexHashName = dexFileName + HASH_POSTFIX;
            zipEntry = zipE;
        }
    }

    static {
        msLoadedDexList.clear();
    }

    private static boolean canWrite(File filesDir, int mode) {
        if (filesDir.canWrite())
            return true;
        int setPer = FileUtils.setPermissions(filesDir.getAbsolutePath(), mode, -1, -1);
        Log.e(TAG, "FileUtils.setPermissions(): filesDir:" + filesDir + "  return: " + setPer);

        if (filesDir.canWrite())
            return true;
        return false;
    }

//    private static void cleanSysCache(Context context) {
//        PackageManager pm = context.getPackageManager();
//        if (pm == null)
//            return;
//
//        try {
//            Method deleteCachefile = pm.getClass().getMethod("freeStorageAndNotify", Long.TYPE,
// IPackageDataObserver.class);
//            if (null == deleteCachefile)
//                return;
//
//            Long localLong = system_cache_limit;
//            deleteCachefile.invoke(pm, localLong, new IPackageDataObserver.Stub() {
//                @Override
//                public void onRemoveCompleted(String s, boolean b) throws RemoteException {
//                    return;
//                }
//            });
//        } catch (InvocationTargetException e) {
//        } catch (NoSuchMethodException e) {
//        } catch (IllegalAccessException e) {
//        }
//    }

    /**
     * Returns the absolute path to the application specific cache directory on
     * the filesystem designed for storing cached code. On devices running
     * {@link Build.VERSION_CODES#LOLLIPOP} or later, the system will delete
     * any files stored in this location both when your specific application is
     * upgraded, and when the entire platform is upgraded.
     * <p>
     * This location is optimal for storing compiled or optimized code generated
     * by your application at runtime.
     * <p>
     * Apps require no extra permissions to read or write to the returned path,
     * since this path lives in their private storage.
     *
     * @return The path of the directory holding application code cache files.
     */
    @SuppressLint("NewApi")
    public static final File getCodeCacheDir(Context context) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            return context.getCodeCacheDir();
        } else {
            ApplicationInfo appInfo = context.getApplicationInfo();
            return createFilesDir(new File(appInfo.dataDir, "code_cache_cj"));
        }
    }

    private synchronized static File createFilesDir(File file) {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                if (file.exists()) {
                    // spurious failure; probably racing with another process for this app
                    return file;
                }
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
                return null;
            }
        }
        return file;
    }

    public static File getDataCache(Context context) {

        if (null == context) {
            return null;
        }

        File code_cache = getCodeCacheDir(context);
        if (null != code_cache) {
            Log.i(TAG, "code_cache_cj : " + code_cache.getAbsolutePath());
            return code_cache;
        }
        logpath('c');
        File filesDir = context.getDir("dex2", Context.MODE_PRIVATE);
        if (null != filesDir) {
            if (filesDir.exists() && canWrite(filesDir, 0775))
                return filesDir;
            else if (!filesDir.exists()) {
                filesDir.mkdirs();
                if (filesDir.exists() && canWrite(filesDir, 0775))
                    return filesDir;
            }
        }

        filesDir = context.getFilesDir();
        if (null != filesDir) {
            if (filesDir.exists() && canWrite(filesDir, 0755))
                return filesDir;
            else if (!filesDir.exists()) {
                filesDir.mkdirs();
                if (filesDir.exists() && canWrite(filesDir, 0755))
                    return filesDir;
            }
        }

        ApplicationInfo appInfo = context.getApplicationInfo();
        if (null != appInfo) {
            filesDir = new File(appInfo.dataDir, "files");
            if (filesDir.exists() == false) {

                Log.e(TAG, "files folder is not exist, try recreate");

                for (int i = 0; i < 5; ++i) {
                    filesDir.mkdirs();

                    if (filesDir.exists()) {
                        if (canWrite(filesDir, 0755)) {
                            return filesDir;
                        } else {
                            break;
                        }
                    }

                    Log.e(TAG, "files folder is not exist, recreate failed, sleep 166ms");

                    SystemClock.sleep(166);
                }
            }
        }

        String pkgDir = "/data/data/" + appInfo.packageName;
        File fpkgDir = new File(pkgDir);

        if (fpkgDir.exists() && !fpkgDir.canWrite()) {
            int retVal = FileUtils.setPermissions(fpkgDir.getAbsolutePath(), 0755, -1, -1);
            // drwxr-xr-x

            Log.e(TAG, "data/data/pkg can not write, setPermissions, return: " + retVal);
        } else if (!fpkgDir.exists()) {
            Log.e(TAG, "data/data/pkg is not exist, recreate");

            fpkgDir.mkdirs();
            if (fpkgDir.exists() && !fpkgDir.canWrite())
                FileUtils.setPermissions(fpkgDir.getAbsolutePath(), 0755, -1, -1);    // drwxr-xr-x
        }

        if (fpkgDir.exists() == false) {

            _handleException(context, "**CRITICAL ERROR *" + fpkgDir.getAbsolutePath() + " is not" +
                    " EXIST!!!", null);
            return null;
        }

        filesDir = new File(fpkgDir, "files");
        if (filesDir.exists() == false) {

            Log.e(TAG, "[**] files folder is not exist, try recreate");

            for (int i = 0; i < 5; ++i) {
                filesDir.mkdirs();

                if (filesDir.exists()) {
                    if (canWrite(filesDir, 0755)) {
                        return filesDir;
                    } else {
                        break;
                    }
                }

                Log.e(TAG, "[**] files folder is not exist, recreate failed, sleep 166ms");
                SystemClock.sleep(166);
            }
        }

        if (fpkgDir.canWrite())
            return fpkgDir;

        Log.e(TAG, "[********** FAILED *****************");
        return null;
    }

    private static boolean extractSubdex(InputStream inputStream, File outputFile)
    {//data/data/pkg/code_cache

        BufferedInputStream bis = null;
        OutputStream dexWriter = null;

        try {
            bis = new BufferedInputStream(inputStream);
            assert bis != null;

            dexWriter = new BufferedOutputStream(new FileOutputStream(outputFile));
            byte[] buf = new byte[BUF_SIZE];
            int len;
            while ((len = bis.read(buf, 0, BUF_SIZE)) > 0) {
                dexWriter.write(buf, 0, len);
            }

        } catch (IOException e) {
            return false;
        } finally {
            if (null != dexWriter)
                try {
                    dexWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        logpath('o');
        return true;
    }

    static void _handleException(final Context appContext, String msg, Exception e) {
        if (e != null)
            e.printStackTrace();

        String logMsg = "";
        if (e != null) {
            logMsg = msg + e.getMessage();
        } else {
            logMsg = msg;
        }

        Log.e(TAG, logMsg);
        SubDexLog.log(appContext, TAG, logMsg);

//        android.os.Process.killProcess(android.os.Process.myPid());

        return;
    }

    private static long getDataPartitionAvailableSize() {
        File dataDirectory = Environment.getDataDirectory();
        if (null != dataDirectory && dataDirectory.exists()) {
            try {
                StatFs stat = new StatFs(dataDirectory.getPath());
                long availableSize = (long) stat.getAvailableBlocks() * stat.getBlockSize();
                return availableSize;
            } catch (Exception e) {
            }
        }
        return 0;
    }


    public static void loadSecondaryDex(Context appContext) {
        msLoadedDexList.clear();
        logpath('*');

        logpath('a');

        if (appContext == null) {
            logpath('b');
            return;
        }

        long time = System.currentTimeMillis();
        Log.d(TAG, "Start of the Loading " + time);

        File filesDir = getDataCache(appContext);//data/data/pkg/code_cache
        if (null == filesDir) {
            Log.e(TAG, "filesDir is null!!!");

            int oldUid = 11;  //set default value not to 0, due to 0 should be root
            int cuUid = 22;   //and the app uid should more than 10000
            ApplicationInfo appInfo = appContext.getApplicationInfo();
            if (appInfo != null) {
                String dataDir = appInfo.dataDir;
                if (dataDir == null) {
                    dataDir = "/data/data/" + appInfo.packageName;
                }
                File dir = new File(dataDir);
                if (dir != null) {
                    if (Build.VERSION.SDK_INT < 16) {// getPermissions was
                        // deprecated after 4.1,
                        // use Os.stat(String)
                        // instead.
                        int[] outPermissions = new int[3];
                        outPermissions[1] = oldUid;
                        try {
                            Method mtdClose = Class.forName("android.os.FileUtils").getMethod(
                                    "getPermissions", String.class, int[].class);
                            mtdClose.invoke(null, dir.getAbsolutePath(), outPermissions);
                            oldUid = outPermissions[1];
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {

                        StructStat stat = os.stat(dir.getAbsolutePath());
                        oldUid = stat.st_uid;
                    }
                }
                cuUid = appInfo.uid;
            }

            _handleException(
                    appContext,
                    "**CRITICAL ERROR ** getDataCache return NULL, OldUID = "
                            + Integer.toString(oldUid)
                            + " CurrentUID = "
                            + Integer.toString(cuUid), null);
            return;
        }

        if (!filesDir.exists()) {
            _handleException(appContext,
                    "**CRITICAL ERROR ** getDataCache NOT EXIST. file not exist, can't load " +
                            "secondary dex", null);
            return;
        }

        /************internal start**********/

        getFinalDexFileExt(appContext);//后缀+num
        String[] dexFiles = filesDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                if (filename != null && filename.startsWith(CLASSES_PREFIX) && filename.endsWith
                        (mSubdexExt))
                    return true;
                return false;
            }
        });
        // 已释放过subdex
//        if (dexFiles != null && dexFiles.length > 0) {
//            Log.d(TAG, "Extracted subDex :" + Arrays.toString(dexFiles));
//            logpath(SUB_DEX_NUM);
//            if (SUB_DEX_NUM == dexFiles.length) {
//                // 为了保证subdex是正确的dex，和我们加载的配置进行一次检查，不通过的话，重新释放一次subdex
//                for (int i = 0; i < SUB_DEX_NUM; i++) {
//                    String possibleDexName = buildDexFullName(i);
//                    msLoadedDexList.add(new LoadedDex(filesDir, possibleDexName));
//                }
//                /***********校验crc***********/
//                logpath('d');
//                boolean bCRCCheckSuccess = true;
//                /*for (LoadedDex dexFileInfo : msLoadedDexList) {
//                    File dexFile = dexFileInfo.dexFile;
//                    Log.d(TAG, "Internal Storage Path for Dex file: " + dexFile.getAbsolutePath
// ());
//                    if (dexFileInfo != null && dexFile.exists()) {
//                        //subdex 本地已经存在，检查crc32
//                        byte[] hashBuffer = new byte[8];
//                        try {
//                            //d406d3c3
//                            BufferedInputStream bisHash = new BufferedInputStream(appContext
//                            .getAssets().open(dexFileInfo.dexHashName), 8);
//                            assert bisHash != null;
//                            bisHash.read(hashBuffer);
//                            bisHash.close();
//                        } catch (IOException e1) {
//                        }
//                        String hashString = new String(hashBuffer);
//                        if (!TextUtils.isEmpty(hashString)) {
//                            long crc32 = CRC32Util.getFileCRC32(dexFile);
//                            String crc32Str = String.format("%08x", crc32);
//                            Log.d(TAG, dexFileInfo.dexFileName + " File " + crc32Str);
//                            Log.d(TAG, dexFileInfo.dexHashName + " Assets " + hashString);
//                            if (!crc32Str.equalsIgnoreCase(hashString)) {
//                                logpath('e');
//                                bCRCCheckSuccess = false;
//                                break;
//                            }
//                        } else {
//                            logpath('g');
//                            bCRCCheckSuccess = false;
//                            break;
//                        }
//                    } else{
//                        bCRCCheckSuccess = false;
//                        break;
//                    }
//                }*/      //y
//
//                try {
//                    bCRCCheckSuccess = !DexHelper.isApkModified(appContext);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    bCRCCheckSuccess = false;
//                    Log.e("sas", "lll");
//                }
//                if (bCRCCheckSuccess) {
//                    Log.d(TAG, "SKIP EXTRACT SUBDEX FROM APK");
//                    logpath('f');
//                    doDexInject(appContext, filesDir, msLoadedDexList);
//                    return;
//                }
//
//            }
//            /***********需要重新解压或者释放***********/
//            Log.d(TAG, "SUBDEX MISMATCH OR NOT EXISTS. RECREATE IT");
//
//            for (int i = 0; i < dexFiles.length; i++) {
//                String possibleDexName = buildDexFullName(i);
//                msLoadedDexList.add(new LoadedDex(filesDir, possibleDexName));
//            }
//
//            for (LoadedDex dexFile : msLoadedDexList) {
//                if (dexFile != null && dexFile.dexFileName != null) {
//                    //规避VM bug，如果同时存在 classes.jar 和 classes.dex，系统执行dexopt的时候会崩溃
//                    File fOldFile = new File(filesDir, dexFile.dexFileName);
//                    if (fOldFile.exists()) {
//                        fOldFile.delete();
//                    }
//                    fOldFile = new File(filesDir, dexFile.dexFileName.replace(DEX_POSTFIX,
//                            JAR_POSTFIX));
//                    if (fOldFile.exists()) {
//                        fOldFile.delete();
//                    }
//                }
//            }
//        }

//        /************是否使用lzma流程************///没走，cm貌似也没有这个
//        msLoadedDexList.clear();
//        InputStream lzmaIs = null;
//        long lzmastart = System.currentTimeMillis();
//        for (int i = 0; i < SUB_DEX_NUM; i++) {
//            String possibleLzmaName = buildDexFullName(i) + LZMA_POSTFIX;
//            try {
//                lzmaIs = appContext.getAssets().open(possibleLzmaName);
//                Log.i(TAG," Lzma try to find : " + possibleLzmaName);
//                LoadedDex loadedDex = new LoadedDex(filesDir, buildDexFullName(i));
//                if (loadedDex.dexFile.exists()) {
//                    int setPer = FileUtils.setPermissions(loadedDex.dexFile.getAbsolutePath(),
// 0755, -1, -1);
//                    if (setPer != 0) {
//                        Log.d(TAG, "Set Dex File Permissions error, error code is : " + Integer
// .toString(setPer));
//                    }
//                    if (!loadedDex.dexFile.delete()) {
//                        SystemClock.sleep(10);
//                        if (!loadedDex.dexFile.delete()) {
//                            _handleException(appContext,
//                                    "**CRITICAL ERROR ** DELETE SECONDARY_DEX_NAME FAILED ",
// null);
//                            return;
//                        }
//                    }
//                }
//
//                long availableSize = getDataPartitionAvailableSize();
//                if (availableSize < system_cache_limit) {
//                    //installd 清理系统缓存是一个异步过程，稍稍等一下
//                    SystemClock.sleep(1500);
//                    Log.i(TAG," Lzma try to cleanSysCache " + possibleLzmaName);
//                }
//
//                boolean succeed = false;
//
//                if (!succeed) {
//                    _handleException(appContext, "**CRITICAL ERROR ** unzipFromStream failed",
// null);
//                    return;
//                }
//                logpath('h');
//                msLoadedDexList.add(loadedDex);
//            }   catch (IOException e) {
//                // 当无法打开lzma认为已经找完了，跳出查找
//                logpath('q');
//                logpath(i);
//                Log.i(TAG, "Not found Lzma");
//                break;
//            }
//        }
//        if(lzmaIs != null){
//            try {
//                lzmaIs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        if (msLoadedDexList.size() > 0) {
//            //Use Lzma
//            Log.i(TAG, msLoadedDexList.size() + " Lzma be found : " + (System.currentTimeMillis
// () - lzmastart));
//            logpath('i');
//            doDexInject(appContext, filesDir ,msLoadedDexList);
//        } else {
        ZipFile apkFile = null;
        try {
            File sourceApk = new File(Environment.getExternalStorageDirectory() +
                    "/test_cm.apk");
            apkFile = new ZipFile(sourceApk);//DATA/APP/PKG/  .dex  .....
        } catch (IOException e) {
            _handleException(appContext, "**CRITICAL ERROR ** Unable Open sourceDir", e);
            return;
        }

        if (null == apkFile) {
            _handleException(appContext,
                    "**CRITICAL ERROR ** unable open ZipFile", null);
            return;
        }

        for (int i = 0; i < SUB_DEX_NUM; i++) {
            String possibleDexName = buildDexFullName(i);
            ZipEntry zipEntry = apkFile.getEntry(possibleDexName);
            if (zipEntry == null) {
                break;
            }
            msLoadedDexList.add(new LoadedDex(filesDir, possibleDexName, zipEntry));
        }
        logpath('k');
        logpath(msLoadedDexList.size());
        Log.i(TAG, "zipfile has dex list : " + msLoadedDexList.size());

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            if (msLoadedDexList.size() <= 0) {
//                Log.e(TAG, "[Warning] Not found subDex....");
//            }
//            //for android 5.0 version! no need do custom subdex load
//            if (mSubdexExt.equals(DEX_POSTFIX)) {
//                Log.d(TAG, "For android 5.0+ version! No need do custom subdex load.");
//                try {
//                    apkFile.close();
//                } catch (IOException e) {
//                }
//                logpath('l');
//                return;
//            }
//        } else {
//            if (msLoadedDexList.size() <= 0) {
//                _handleException(appContext,
//                        "**CRITICAL ERROR ** Not found SubDex in ZipFile ", null);
//                return;
//            }
//            logpath('m');
//        }

        for (LoadedDex loadedDex : msLoadedDexList) {
            if (null == loadedDex.zipEntry) {
                _handleException(appContext,
                        "**CRITICAL ERROR ** Unable Open secondary dex " + loadedDex.dexFileName,
                        null);
                return;
            }
            File dexFile = loadedDex.dexFile;
//            if (dexFile.exists()) {
//                int setPer = FileUtils.setPermissions(dexFile.getAbsolutePath(), 0755, -1, -1);
//                if (setPer != 0) {
//                    Log.d(TAG, "Set Dex File Permissions error, error code is : "
//                            + Integer.toString(setPer));
//                }
//
//                if (!dexFile.delete()) {
//                    SystemClock.sleep(10);
//
//                    if (!dexFile.delete()) {
//                        _handleException(appContext,
//                                "**CRITICAL ERROR ** DELETE SECONDARY_DEX_NAME FAILED ", null);
//                        return;
//                    }
//                }
//            }
//            long availableSize = getDataPartitionAvailableSize();
//            if (availableSize < system_cache_limit) {
////                    cleanSysCache(appContext);
//                //installd 清理系统缓存是一个异步过程，稍稍等一下
//                SystemClock.sleep(1500);
//                logpath('n');
//            }
            boolean result = false;
            int step = 1;
            try {
                result = extractSubdex(apkFile.getInputStream(loadedDex.zipEntry), dexFile);
                Log.i(TAG, " zipfile extractSubdex : " + dexFile.getName() + " " + result + " " +
                        "dexFile=" + dexFile.lastModified());
//                if (false == result) {
////                        cleanSysCache(appContext);
//                    SystemClock.sleep(1500);
//                    step++;
//                    result = extractSubdex(apkFile.getInputStream(loadedDex.zipEntry), dexFile);
//                }
            } catch (Exception e) {
                step = 3;
                e.printStackTrace();
            }

//            if (result == false) {
//
//                _handleException(appContext,
//                        "**CRITICAL ERROR ** extractSubdex, step= " + step, null);
//                return;
//            }
            loadedDex.dexFile = dexFile;
        }
//        try {
//            DexHelper.saveFileInfo(appContext);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (apkFile != null) {
            try {
                apkFile.close();
            } catch (Exception e) {
            }
        }
        logpath('p');
        // Log.e("demoui","line 706");
        //  Log.e("opooop","filesDir:"+filesDir.list().length);
        doDexInject(appContext, filesDir, msLoadedDexList);
        //  Log.e("demoui","line 708");
//        }
    }

    private static String buildDexFullName(int index) {
        return CLASSES_PREFIX + (index + 2) + mSubdexExt;
    }

//Comment by purger     private static boolean toFindKey(String[] sourceData, String key) {
//Comment by purger         Arrays.sort(sourceData);
//Comment by purger         return Arrays.binarySearch(sourceData, key) >= 0;
//Comment by purger     }


    /**
     * 读取assets下的subdex_cfg2.hash配置
     * .dex|3
     *
     * @param appContext
     */
    private static void getFinalDexFileExt(Context appContext) {
        mSubdexExt = DEX_POSTFIX;
        SUB_DEX_NUM = SUB_DEX_NUM_DEBUG;
        /*BufferedInputStream bisHash = null;
        byte[] hashBuffer = new byte[6];
        try {
            // 把subdex的打包配置通过文件加载进来
            // 格式(6个字节：dex类型.jar或.dex|dex数量)： .dex|2
            bisHash = new BufferedInputStream(appContext.getAssets().open(SUBDEX_CFG),6);
            assert bisHash != null;
            bisHash.read(hashBuffer);
        } catch (IOException e1) {
        }
        finally {
            try {
                if(bisHash != null)
                    bisHash.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String hashString = new String(hashBuffer);
        if(!TextUtils.isEmpty(hashString)){
            String[] config = hashString.split("\\|");
            if(config != null && config.length == 2){
                String dexType = config[0];
                String dexNum = config[1];
                if(dexType != null){
                    if(dexType.equalsIgnoreCase(DEX_POSTFIX)){
                        mSubdexExt = DEX_POSTFIX;
                    } else if(dexType.equalsIgnoreCase(JAR_POSTFIX)){
                        mSubdexExt = JAR_POSTFIX;
                    }
                } else{
                    _handleException(appContext,
                            "**CRITICAL ERROR ** SUBDEX CONFIG TYPE CHECK FAILURE", null);
                }
                if(dexNum != null){
                    try {
                        SUB_DEX_NUM = Integer.valueOf(dexNum);
                    }catch (Exception e){
                        _handleException(appContext,
                                "**CRITICAL ERROR ** SUBDEX CONFIG NUM CHECK FAILURE", e);
                    }
                } else{
                    _handleException(appContext,
                            "**CRITICAL ERROR ** SUBDEX CONFIG NUM CHECK FAILURE", null);
                }
            } else{
                if(Build.VERSION.SDK_INT < 21){
                    _handleException(appContext,
                            "**CRITICAL ERROR ** SUBDEX CONFIG FORMAT ERROR", null);
                }
            }
        } else{
            if(Build.VERSION.SDK_INT < 21){
                _handleException(appContext,
                        "**CRITICAL ERROR ** NOT FOUND SUBDEX CONFIG ", null);
            }
        }*/
        Log.e(TAG, "SubDex Config : " + mSubdexExt + " " + SUB_DEX_NUM);
    }

    public static void logpath(char c) {
        CMDexPathInfo.DOING_INJECT += c;
    }

    public static void logpath(int i) {
        CMDexPathInfo.DOING_INJECT += i;
    }

    private static void doDexInject(final Context appContext, File filesDir, HashSet<LoadedDex>
            loadedDex) {
        logpath('x');
        if (Build.VERSION.SDK_INT >= 23) {
            // No need to do dex inject
            Log.w(TAG, "Unable to do dex inject on SDK " + Build.VERSION.SDK_INT);
//            return;
        }
        File[] files = filesDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File fi = files[i];
            // Log.e("sasasaqqq","file:"+fi.getName());
        }
        long s = System.currentTimeMillis();

        File fopt = null;
        try {
            String optimizeDir = filesDir.getAbsolutePath() + File.separator + "opt_dex";
            fopt = new File(optimizeDir);
            if (!fopt.exists())
                fopt.mkdirs();
        } catch (Exception e) {
            _handleException(appContext,
                    "**CRITICAL ERROR ** SUBDEX LOAD FAILED at=" + e.getMessage(), null);
        }

        try {
            ArrayList<File> dexFiles = new ArrayList<>();
            logpath(loadedDex.size());
            String log = "";
            for (LoadedDex dex : loadedDex) {
                dexFiles.add(dex.dexFile);
                log += dex.dexFileName + " ";
            }
            Log.i(TAG, "doDexInject " + log);
            MultiDex.installMultiDex(appContext.getClassLoader(), fopt, dexFiles);
            mIsLoaded = true;
        } catch (Exception e) {
            _handleException(appContext,
                    "**CRITICAL ERROR ** SUBDEX LOAD FAILED at=" + e.getMessage(), null);
        }

        // inject double check
        HashSet<LoadedDex> injectFailedDexes = new HashSet<>();
        CMDexPathInfo.APK_DEX_SUM = loadedDex.size() + 1;
        for (LoadedDex dex : loadedDex) {
            boolean success = CMDexPathInfo.isSingleDexInjectSuccess(appContext, dex.dexFileName);
            if (!success) {
                injectFailedDexes.add(dex);
            }
        }

        if (injectFailedDexes.size() > 0) {
            // If one dex inject failed , try again to inject this dex by another way ;
            logpath('f');
            doDexInjectMultiThread(appContext, fopt, injectFailedDexes);
        }
        logpath('s');
    }

    static Integer mInvokeInjectCount = 0;

    /**
     * Try using multi thread to do dexInject
     *
     * @param appContext
     * @param fopt
     * @param loadedDex
     */
    private static void doDexInjectMultiThread(final Context appContext, File fopt,
                                               HashSet<LoadedDex> loadedDex) {
        if (fopt == null)
            return;

        mInvokeInjectCount = 0;
        try {
            for (final LoadedDex dex : loadedDex) {
                new InjectThread(appContext, fopt, dex).start();
            }
        } catch (Exception e) {
            _handleException(appContext,
                    "**CRITICAL ERROR ** SUBDEX LOAD FAILED at = " + e.getMessage(), null);
        }
        while (mInvokeInjectCount != loadedDex.size()) {
            SystemClock.sleep(100);
        }
        mIsLoaded = true;
    }

    private static class InjectThread extends Thread {
        Context appContext;
        File fopt;
        LoadedDex dex;

        public InjectThread(final Context context, File foptx, LoadedDex dexx) {
            appContext = context;
            fopt = foptx;
            dex = dexx;
        }

        @Override
        public void run() {
            ArrayList<File> dexFiles = new ArrayList<>();
            dexFiles.add(dex.dexFile);
            try {
                MultiDex.installMultiDex(appContext.getClassLoader(), fopt, dexFiles);
                if (!CMDexPathInfo.isSingleDexInjectSuccess(appContext, dex.dexFileName)) {
                    // if failed , try again
                    logpath('r');
                    MultiDex.installMultiDex(appContext.getClassLoader(), fopt, dexFiles);
                }
            } catch (Exception e) {
                _handleException(appContext,
                        "**CRITICAL ERROR ** SUBDEX LOAD FAILED at=" + e.getMessage(), null);
            }
            synchronized (mInvokeInjectCount) {
                mInvokeInjectCount++;
            }
        }
    }

//    public static void cleanOldversionSubdexFiles(Context appContext) {
//        final String oldsubdex[] = {
//                "/app_dex/permanentsubdex.dex",
//                "/app_dex/permanentsubdex.jar",
//                "/app_dex/subdex.dex",
//                "/app_dex/subdex.jar",
//                "/app_dex/floatsubdex.dex",
//                "/app_dex/floatsubdex.jar",
//
//                "/files/permanentsubdex.dex",
//                "/files/permanentsubdex.jar",
//                "/files/subdex.dex",
//                "/files/subdex.jar",
//                "/files/floatsubdex.dex",
//                "/files/floatsubdex.jar",
//
//                "/app_dex/classes2_ui.dex",
//                "/app_dex/classes2_float.dex",
//                "/app_dex/classes2_svc.dex",
//                "/app_dex/classes2_bgscan.dex",
//                "/app_dex/classes2_login.dex",
//                "/app_dex/classes2_phototrim.dex",
//                "/app_dex/classes2_gameboxweb.dex",
//                "/app_dex/classes2_storage.dex",
//                "/app_dex/classes2_perms.dex",
//                "/app_dex/classes2_sdscanservice.dex",
//                "/app_dex/classes2_applock.dex",
//
//                "/app_dex/opt_dex/classes2_ui.dex",
//                "/app_dex/opt_dex/classes2_float.dex",
//                "/app_dex/opt_dex/classes2_svc.dex",
//                "/app_dex/opt_dex/classes2_bgscan.dex",
//                "/app_dex/opt_dex/classes2_login.dex",
//                "/app_dex/opt_dex/classes2_phototrim.dex",
//                "/app_dex/opt_dex/classes2_gameboxweb.dex",
//                "/app_dex/opt_dex/classes2_storage.dex",
//                "/app_dex/opt_dex/classes2_perms.dex",
//                "/app_dex/opt_dex/classes2_sdscanservice.dex",
//                "/app_dex/opt_dex/classes2_applock.dex",
//        };
//
//        final Context context = appContext;
//        ThreadManager.postDelayed(ThreadManager.THREAD_BACKGROUND,new Runnable() {
//            @Override
//            public void run() {
//                ApplicationInfo appInfo = context.getApplicationInfo();
//                String rootDir = appInfo.dataDir;
//                if (rootDir == null) {
//                    return;
//                }
//                for (String path : oldsubdex) {
//                    File f = new File(rootDir +  path);
//                    if (f.exists())
//                        f.delete();
//                }
//            }
//        }, 5000);
//    }
}
