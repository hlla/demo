package test.example.com.testrx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;

public class FileUtils {
    @SuppressLint("SimpleDateFormat")
    private static SimpleDateFormat sSDF = new SimpleDateFormat("\r\n\r\nyyyy-MM-dd HH:mm:ss.Z : ");
    private static File sFileDir;
    final static private ArrayMap<String, String> MIMETYPE_SET;

    static {
        MIMETYPE_SET = new ArrayMap<String, String>();
        MIMETYPE_SET.put(".3gp", "video/3gpp");
        MIMETYPE_SET.put(".apk", "application/vnd.android.package-archive");
        MIMETYPE_SET.put(".asf", "video/x-ms-asf");
        MIMETYPE_SET.put(".avi", "video/x-msvideo");
        MIMETYPE_SET.put(".bin", "application/octet-stream");
        MIMETYPE_SET.put(".bmp", "image/bmp");
        MIMETYPE_SET.put(".c", "text/plain");
        MIMETYPE_SET.put(".class", "application/octet-stream");
        MIMETYPE_SET.put(".conf", "text/plain");
        MIMETYPE_SET.put(".cpp", "text/plain");
        MIMETYPE_SET.put(".doc", "application/msword");
        MIMETYPE_SET.put(".exe", "application/octet-stream");
        MIMETYPE_SET.put(".gif", "image/gif");
        MIMETYPE_SET.put(".gtar", "application/x-gtar");
        MIMETYPE_SET.put(".gz", "application/x-gzip");
        MIMETYPE_SET.put(".h", "text/plain");
        MIMETYPE_SET.put(".htm", "text/html");
        MIMETYPE_SET.put(".html", "text/html");
        MIMETYPE_SET.put(".jar", "application/java-archive");
        MIMETYPE_SET.put(".java", "text/plain");
        MIMETYPE_SET.put(".jpeg", "image/jpeg");
        MIMETYPE_SET.put(".jpg", "image/jpeg");
        MIMETYPE_SET.put(".js", "application/x-javascript");
        MIMETYPE_SET.put(".log", "text/plain");
        MIMETYPE_SET.put(".m3u", "audio/x-mpegurl");
        MIMETYPE_SET.put(".m4a", "audio/mp4a-latm");
        MIMETYPE_SET.put(".m4b", "audio/mp4a-latm");
        MIMETYPE_SET.put(".m4p", "audio/mp4a-latm");
        MIMETYPE_SET.put(".m4u", "video/vnd.mpegurl");
        MIMETYPE_SET.put(".m4v", "video/x-m4v");
        MIMETYPE_SET.put(".mov", "video/quicktime");
        MIMETYPE_SET.put(".mp2", "audio/x-mpeg");
        MIMETYPE_SET.put(".mp3", "audio/x-mpeg");
        MIMETYPE_SET.put(".mp4", "video/mp4");
        MIMETYPE_SET.put(".mpc", "application/vnd.mpohun.certificate");
        MIMETYPE_SET.put(".mpe", "video/mpeg");
        MIMETYPE_SET.put(".mpeg", "video/mpeg");
        MIMETYPE_SET.put(".mpg", "video/mpeg");
        MIMETYPE_SET.put(".mpg4", "video/mp4");
        MIMETYPE_SET.put(".mpga", "audio/mpeg");
        MIMETYPE_SET.put(".msg", "application/vnd.ms-outlook");
        MIMETYPE_SET.put(".ogg", "audio/ogg");
        MIMETYPE_SET.put(".pdf", "application/pdf");
        MIMETYPE_SET.put(".png", "image/png");
        MIMETYPE_SET.put(".pps", "application/vnd.ms-powerpoint");
        MIMETYPE_SET.put(".ppt", "application/vnd.ms-powerpoint");
        MIMETYPE_SET.put(".prop", "text/plain");
        MIMETYPE_SET.put(".rar", "application/x-rar-compressed");
        MIMETYPE_SET.put(".rc", "text/plain");
        MIMETYPE_SET.put(".rmvb", "video/x-pn-realaudio");
        MIMETYPE_SET.put(".rtf", "application/rtf");
        MIMETYPE_SET.put(".sh", "text/plain");
        MIMETYPE_SET.put(".tar", "application/x-tar");
        MIMETYPE_SET.put(".tgz", "application/x-compressed");
        MIMETYPE_SET.put(".txt", "text/plain");
        MIMETYPE_SET.put(".wav", "audio/x-wav");
        MIMETYPE_SET.put(".wma", "audio/x-ms-wma");
        MIMETYPE_SET.put(".wmv", "audio/x-ms-wmv");
        MIMETYPE_SET.put(".wps", "application/vnd.ms-works");
        //MIMETYPE_SET.put(".xml", "text/xml");
        MIMETYPE_SET.put(".xml", "text/plain");
        MIMETYPE_SET.put(".z", "application/x-compress");
        MIMETYPE_SET.put(".zip", "application/zip");
        MIMETYPE_SET.put("", "*/*");
        MIMETYPE_SET.put(".amr", "audio/amr");
    }

    public static Object deserializeFromFile(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        Object o = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileLock lock = null;

        try {
            fis = new FileInputStream(file);
            lock = fis.getChannel().lock(0L, Long.MAX_VALUE, true);
            ois = new ObjectInputStream(fis);
            o = ois.readUnshared();
            return o;
        } catch (FileNotFoundException e) {
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
        } catch (Exception e) {
            file.delete();
        } catch (OutOfMemoryError oom) {
        } finally {
            if (lock != null)
                try {
                    lock.release();
                } catch (IOException e) {
                }
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

    public static boolean serializeToFile(Serializable o, File file) {
        if (o == null || file == null)
            return false;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileLock lock = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            lock = fos.getChannel().lock();

            oos.writeUnshared(o);
            oos.flush();
            fos.flush();
            return true;
        } catch (Exception e) {
        } catch (OutOfMemoryError oom) {
        } finally {
            if (oos != null) {
                try {
                    oos.reset();
                } catch (IOException e) {
                }
            }
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException e) {
                }

                lock = null;
            }
            try {
                if (oos != null) {
                    oos.close();
                    oos = null;
                }
            } catch (IOException e) {
            }
            try {
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
            }
        }
        return false;
    }

    public static void copyFolder(String srcFolderPath, String destFolderPath) {
        try {
            if (!TextUtils.isEmpty(srcFolderPath)) {
                File srcFolder = new File(srcFolderPath);
                if (srcFolder.exists()) {
                    File[] files = srcFolder.listFiles();
                    if (files == null) {
                        return;
                    }
                    if (!TextUtils.isEmpty(destFolderPath)) {
                        File destFolder = new File(destFolderPath);
                        destFolder.mkdirs();
                        for (File file : files) {
                            String destPath = destFolder.getPath() + "/" + file.getName();
                            if (file.isDirectory()) {
                                copyFolder(file.getPath(), destPath);
                            } else {
                                copyFile(file.getPath(), destPath);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    public static boolean copyFile(String srcPath, String destPath) {
        boolean result = false;
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            File srcFile = new File(srcPath);
            if (srcFile.exists()) {
                input = new FileInputStream(srcFile);
                File libFile = new File(destPath);
                if (!libFile.exists()) {
                    libFile.createNewFile();
                } else {
                    libFile.delete();
                    libFile.createNewFile();
                }
                output = new FileOutputStream(libFile);

                byte[] buf = new byte[1024 * 4];
                int count = 0;
                while (true) {
                    count = input.read(buf);
                    if (count == -1)
                        break;
                    output.write(buf, 0, count);
                }
                input.close();
                input = null;
                output.flush();
                output.close();
                output = null;
                buf = null;
                result = true;
            }
        } catch (Exception ex) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                    input = null;
                } catch (IOException e) {
                }

            }
            if (output != null) {
                try {
                    output.close();
                    output = null;
                } catch (IOException e) {
                }
            }
        }
        return result;
    }

    public static boolean deleteFolder(File folder) {
        if (!folder.exists()) return true;
        if (!folder.isDirectory()) return false;

        boolean flag = true;
        File[] files = folder.listFiles();
        if (files == null) {
            return true;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                flag = deleteFolder(f);
            }
            flag = f.delete();
        }

        return flag;
    }

    public static boolean saveFile(InputStream stream, File target) {
        boolean bSuccess = true;
        FileOutputStream os = null;
        File temp_f = new File(target.getParentFile(), target.getName() + ".tmp");
        try {
            os = new FileOutputStream(target);
            byte[] buffer = new byte[8 * 1024];
            int readedLength = stream.read(buffer);
            while (readedLength >= 0) {
                os.write(buffer, 0, readedLength);
                readedLength = stream.read(buffer);
            }
            temp_f.renameTo(target);
        } catch (FileNotFoundException fne) {
            bSuccess = false;
        } catch (IOException e) {
            bSuccess = false;
        } catch (Exception e) {
            bSuccess = false;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                }
                os = null;
            }
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                }
                stream = null;
            }
        }

        if (!bSuccess) {
            temp_f.delete();
        }
        return bSuccess;
    }

    public static File getFilesDir(Context ctx) {
        if (null != sFileDir && sFileDir.exists()) {
            return sFileDir;
        }
        if (null == ctx) {
            return null;
        }
        File result = null;
        for (int i = 0; i < 3; ++i) {
            // 因为有时候getFilesDir()在无法创建目录时会返回失败，所以我们在此等待并于半秒内尝试三次。
            result = ctx.getFilesDir();
            if (null != result) {
                break;
            } else {
                try {
                    Thread.sleep(166);
                } catch (InterruptedException e) {
                }
            }
        }
        if (null == result) {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File externalFile = ctx.getExternalFilesDir(null);
                if (null == externalFile) {
                    return null;
                }
                if (!externalFile.exists()) {
                    boolean isCreated = externalFile.mkdirs();
                    if (!isCreated) {
                        return null;
                    }
                }
                result = externalFile;
            }
        }
        if (null != result) {
            sFileDir = result;
        }
        return result;
    }

    public static String addSlash(final String path) {
        if (path == null || path.length() == 0) {
            return File.separator;
        }

        if (path.charAt(path.length() - 1) != File.separatorChar) {
            return path + File.separatorChar;
        }

        return path;
    }

    /**
     * 创建文件
     *
     * @param filePath
     * @return 文件对象
     * @throws IOException
     */
    public static File createFile(String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
        return file;
    }

    /**
     * 判断文件是否存在
     *
     * @param filePath
     * @return true:存在 false:不存在
     */
    public static boolean isFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * 删除文件
     *
     * @param filePath
     * @return true:成功 false:失败
     */
    public static boolean deleteFileByPath(String filePath) {
        File file = new File(filePath);
        return deleteFile(file);
//        if (file.isFile() && file.exists()) {
//            file.delete();
//            return true;
//        } else {
//            return false;
//        }
    }

    public static boolean deleteFile(File file) {
        if (null == file) {
            return false;
        }
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        } else if (file.isDirectory() && file.exists()) {
            delFolder(file.getPath());
            return true;
        }
        return false;
    }

    /**
     * 删除文件夹
     *
     * @param folderPath
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath);
            File myFilePath = new File(folderPath);
            myFilePath.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件夹中的所有文件
     *
     * @param path
     * @return true:成功 false:失败
     */
    public static boolean delAllFile(String path) {
        if (path == null || path.length() <= 0) {
            return false;
        }

        boolean bReturn = false;
        File file = new File(path);
        if (!file.exists()) {
            return bReturn;
        }
        if (!file.isDirectory()) {
            return bReturn;
        }
        String[] tempList = file.list();
        if (tempList != null) {
            File temp = null;
            for (int i = 0; i < tempList.length; i++) {
                if (path.endsWith(File.separator)) {
                    temp = new File(path + tempList[i]);
                } else {
                    temp = new File(path + File.separator + tempList[i]);
                }
                if (temp.isFile()) {
                    temp.delete();
                }
                if (temp.isDirectory()) {
                    delAllFile(path + File.separatorChar + tempList[i]);
                    delFolder(path + File.separatorChar + tempList[i]);
                    bReturn = true;
                }
            }
        }

        return bReturn;
    }

    public static int pathFileCount(String path) {
        if (null == path || path.length() <= 0) {
            return 0;
        }

        File pathFile = new File(path);
        if (!pathFile.exists() || !pathFile.isDirectory()) {
            return 0;
        }

        String[] pathFileNames = pathFile.list();
        if (null == pathFileNames) {
            return 0;
        }

        return pathFileNames.length;
    }

    public static String getFileName(String path) {
        try {
            if (!TextUtils.isEmpty(path)) {
                int nBegin = path.lastIndexOf("/");
                //int end = path.lastIndexOf(".");
                if (nBegin != -1) {
                    return path.substring(nBegin + 1, path.length());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static File createDirIfNeed(String dirPath) {
        if (TextUtils.isEmpty(dirPath)) {
            return null;
        }
        final File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static boolean isAssetsFile(String imageUrl) {
        return imageUrl != null && imageUrl.contains("/android_asset/");
    }

//    public static String getStringFromFile(File file) {
//        if (file == null || !file.exists() || !file.isFile())
//            return null;
//
//        String result = null;
//        FileInputStream fis = null;
//
//        try {
//            fis = new FileInputStream(file);
//            int len = fis.available();
//            if (len <= 0)
//                return null;
//
//            byte[] buffer = new byte[len];
//            fis.read(buffer);
//
//            result = EncodingUtils.getString(buffer, "utf-8");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } finally {
//            try {
//                if (fis != null)
//                    fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return result;
//    }
}
