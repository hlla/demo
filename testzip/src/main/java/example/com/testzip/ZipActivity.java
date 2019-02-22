package example.com.testzip;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.testzip.loader.DexHelper;

public class ZipActivity extends Activity {
    private static final String TAG = "ZipActivity";
    private static final String SECONDARY_FOLDER_NAME = "code_cache" + File.separator +
            "secondary-dexes";
    private static final int BUF_SIZE = 1024 * 32;
    @BindView(R.id.source_zip)
    Button sourceZip;
    @BindView(R.id.test_zip)
    Button testZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);
        File anrDir = new File("/data/anr/");
        Log.d(TAG, "onCreate: trace=" + anrDir.exists() + " can=" + anrDir.canRead() + " anrDir" +
                ".canwrite=" + anrDir.canWrite());
        File[] anrTraceFiles = anrDir.listFiles();
        Log.d(TAG, "onCreate: anrTraceFiles=" + anrTraceFiles);
        if (null != anrTraceFiles) {
            Log.d(TAG, "onCreate: anrTraceFiles.size=" + anrTraceFiles.length);
            for (File file : anrTraceFiles) {
                Log.d(TAG, "onCreate: file111=" + file.getPath());
            }
        }

        File trace = new File("/data/anr/traces.txt.anr");
        Log.d(TAG, "onCreate: canRead=" + trace.canRead() + " trace.canwrite=" + trace.canWrite());
        File dropbox = new File("/data/system/dropbox/");
        Log.d(TAG, "onCreate: dropbox.canRead=" + dropbox.canRead() + " exist=" + dropbox.exists());
        ButterKnife.bind(this);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("letv.com.testanr", "letv.com.testanr" +
                ".MyService"));
        intent.setAction("test.service");
        intent.putExtra("abc", "cj");
        boolean result = bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(TAG, "onServiceConnected: ");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
        Log.d(TAG, "onBindServiceClicked: end result=" + result);
//        getDataPartitionAvailableSize();
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
//        activityManager.getMemoryInfo(info);
//
//        Log.d(TAG, "largeMemoryClass = " + largeMemoryClass);
//        Log.d(TAG, "memoryClass = " + memoryClass / 1024 / 1024 + "   availMem=" + info.availMem
//                / 1024 / 1024 + " totalMem="
//                + info.totalMem / 1024 / 1024 + " threshold=" + info.threshold / 1024 / 1024 + " " +
//                " freeMemory=" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + " " +
//                "totalMemory=" + Runtime
//                .getRuntime().totalMemory() / 1024 / 1024 + " max=" + Runtime.getRuntime()
//                .maxMemory());
    }

    @OnClick({R.id.source_zip, R.id.test_zip})
    public void onViewClicked(View view) {
        ApplicationInfo e = getApplicationInfo();
        File dexDir = new File(e.dataDir, SECONDARY_FOLDER_NAME);
        dexDir.mkdirs();
        switch (view.getId()) {
            case R.id.source_zip:
                try {
                    ClassLoader classLoader = getClassLoader();
//                    Class.forName("example.com.testzip.MultiDexExtractor");
                    getClassLoader().loadClass("example.com.testzip.MultiDexExtractor");
                    Class class11 = classLoader.loadClass("com.chengjian.ui.cover" +
                            ".CoverViewContainer");
                    Class class111 = classLoader.loadClass("dalvik.system.DexPathList");
//                    Method[] methods = class111.getDeclaredMethods();
//                    for (Method method : methods) {
//                        Log.d(TAG, "onViewClicked: method=" + method + " class111=" + class111);
//                    }
                    Log.d(TAG, "onViewClicked: classLoader=" + classLoader + " class11=" + class11);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                    Log.d(TAG, "onViewClicked: e1=" + e1);
                }
//                try {
//                    MultiDexExtractor.load(ZipActivity.this, dexDir);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
                break;
            case R.id.test_zip:
//                Log.d(TAG, "onViewClicked: test 1");
//                ZipFile apkFile = null;
//                try {
//                    File sourceApk = new File(Environment.getExternalStorageDirectory() +
//                            "/test_cm.apk");
//                    apkFile = new ZipFile(sourceApk);
//                } catch (Exception ee) {
//                    return;
//                }
//                Log.d(TAG, "onViewClicked: test 2");
//                for (int i = 2; i < 10; i++) {
//                    ZipEntry zipEntry = apkFile.getEntry("classes" + i + ".dex");
//                    try {
//                        extractSubdex(apkFile.getInputStream(zipEntry), new File(dexDir,
//                                "classes" + i + ".dex"));
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                    }
//                }
//                Log.d(TAG, "onViewClicked: test 3");
                Log.d(TAG, "install start");
                DexHelper.installDex(this);
                ClassLoader classLoader = getClassLoader();
                Log.d(TAG, "install onViewClicked: classLoader=" + classLoader);
                break;
        }
    }

//    private static long getDataPartitionAvailableSize() {
//        File dataDirectory = Environment.getDataDirectory();
//        if (null != dataDirectory && dataDirectory.exists()) {
//            try {
//                StatFs stat = new StatFs(dataDirectory.getPath());
//                long availableSize = (long) stat.getAvailableBlocks() * stat.getBlockSize();
//                long totalSize = (long) stat.getBlockCount() * stat.getBlockSize();
//                Log.d(TAG, "getDataPartitionAvailableSize: availableSize=" + availableSize /
//                        (1024 * 1024) + "  size=" + stat.getBlockSize() + " totalSize=" +
//                        totalSize / (1024 * 1024));
//                File es = Environment.getRootDirectory();
//                Log.d(TAG, "getDataPartitionAvailableSize: root=" + es.getPath() + "  data=" +
//                        dataDirectory.getPath());
//                StatFs stat1 = new StatFs(es.getPath());
//                long stat1Size = (long) stat1.getAvailableBlocks() * stat1.getBlockSize();
//                long totalSize1 = (long) stat1.getBlockCount() * stat.getBlockSize();
//                Log.d(TAG, "getDataPartitionAvailableSize: stat1Size=" + stat1Size /
//                        (1024 * 1024) + "  size=" + stat1.getBlockSize() + " totalSize1=" +
//                        totalSize1 / (1024 * 1024));
//                return availableSize;
//            } catch (Exception e) {
//            }
//        }
//        return 0;
//    }

//    private static boolean extractSubdex(InputStream inputStream, File outputFile) {
//
//        BufferedInputStream bis = null;
//        OutputStream dexWriter = null;
//
//        try {
//            bis = new BufferedInputStream(inputStream);
//            assert bis != null;
//
//            dexWriter = new BufferedOutputStream(new FileOutputStream(outputFile));
//            byte[] buf = new byte[BUF_SIZE];
//            int len;
//            while ((len = bis.read(buf, 0, BUF_SIZE)) > 0) {
//                dexWriter.write(buf, 0, len);
//            }
//
//        } catch (IOException e) {
//            return false;
//        } finally {
//            if (null != dexWriter)
//                try {
//                    dexWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            if (bis != null)
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        }
//        return true;
//    }
}
