package android.support.v4.os;

import android.os.Environment;
import java.io.File;

class EnvironmentCompatKitKat
{
  public static String getStorageState(File paramFile)
  {
    return Environment.getStorageState(paramFile);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/android/support/v4/os/EnvironmentCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */