package android.support.e;

import java.io.File;
import java.io.FileFilter;

final class c
  implements FileFilter
{
  c(String paramString) {}
  
  public final boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (!paramFile.startsWith(this.a)) && (!paramFile.equals("MultiDex.lock"));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */