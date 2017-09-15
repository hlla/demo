package example.com.testzip.loader;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Only used for subdex print log, please don't use it for other task
 */
public final class SubDexLog {
    private static SimpleDateFormat LogFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String LOG_TAG = "SubDexLog";

    private static String getLogFilePath(Context appContext) {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File externalFile = appContext.getExternalFilesDir(null);
            if (null == externalFile)
                return null;

            if (!externalFile.exists())
                externalFile.mkdirs();

            File fileLog = new File(externalFile, "logs");
            if (!fileLog.exists())
                fileLog.mkdirs();

            if (!fileLog.exists() || !fileLog.canWrite())
                return null;

            return fileLog.getAbsolutePath() + File.separator + "subdex_debug.log";
        }

        return null;
    }

    //no need to add synchronized, only used by subdex only
    public static void log(Context appContext, String tag, String msg) {

        Date now = new Date();
        String needWriteMessage = LogFormat.format(now) + ":[" + tag + "]" + msg;
        String logName = getLogFilePath(appContext);

        if (logName != null) {

            File file = new File(logName);
            FileWriter fileWriter = null;
            BufferedWriter bufWriter = null;
            try {
                fileWriter = new FileWriter(file, true);
                bufWriter = new BufferedWriter(fileWriter);
                bufWriter.write(needWriteMessage);
                bufWriter.newLine();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Write log error");
                e.printStackTrace();
            } finally {
                if (bufWriter != null) {
                    try {
                        bufWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
