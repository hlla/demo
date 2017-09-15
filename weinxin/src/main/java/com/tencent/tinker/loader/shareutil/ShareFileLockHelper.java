package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class ShareFileLockHelper
  implements Closeable
{
  private final FileOutputStream xgp;
  private final FileLock xgq;
  
  private ShareFileLockHelper(File paramFile)
  {
    this.xgp = new FileOutputStream(paramFile);
    Throwable localThrowable = null;
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (i < 3)
      {
        i += 1;
        localObject2 = localObject1;
      }
      try
      {
        localObject1 = this.xgp.getChannel().lock();
        if (localObject1 != null) {}
        for (int j = 1; j != 0; j = 0)
        {
          localObject2 = localObject1;
          if (localObject2 != null) {
            break label129;
          }
          throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + paramFile.getAbsolutePath(), localThrowable);
        }
        localObject2 = localObject1;
        Thread.sleep(10L);
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
      }
    }
    label129:
    this.xgq = ((FileLock)localObject2);
  }
  
  public static ShareFileLockHelper T(File paramFile)
  {
    return new ShareFileLockHelper(paramFile);
  }
  
  public void close()
  {
    try
    {
      if (this.xgq != null) {
        this.xgq.release();
      }
      return;
    }
    finally
    {
      if (this.xgp != null) {
        this.xgp.close();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/shareutil/ShareFileLockHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */