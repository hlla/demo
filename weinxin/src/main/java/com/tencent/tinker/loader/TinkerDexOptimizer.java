package com.tencent.tinker.loader;

import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer
{
  public static boolean a(Collection<File> paramCollection, File paramFile, ResultCallback paramResultCallback)
  {
    return a(paramCollection, paramFile, false, null, paramResultCallback);
  }
  
  public static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, ResultCallback paramResultCallback)
  {
    paramCollection = new ArrayList(paramCollection);
    Collections.sort(paramCollection, new Comparator() {});
    Collections.reverse(paramCollection);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!new OptimizeWorker((File)paramCollection.next(), paramFile, paramBoolean, paramString, paramResultCallback).cgI()) {
        return false;
      }
    }
    return true;
  }
  
  private static class OptimizeWorker
  {
    private static String xfb = null;
    private final boolean xey;
    private final File xfc;
    private final File xfd;
    private final TinkerDexOptimizer.ResultCallback xfe;
    
    OptimizeWorker(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, TinkerDexOptimizer.ResultCallback paramResultCallback)
    {
      this.xfc = paramFile1;
      this.xfd = paramFile2;
      this.xey = paramBoolean;
      this.xfe = paramResultCallback;
      xfb = paramString;
    }
    
    public final boolean cgI()
    {
      try
      {
        if ((!SharePatchFileUtil.U(this.xfc)) && (this.xfe != null))
        {
          this.xfe.b(this.xfc, new IOException("dex file " + this.xfc.getAbsolutePath() + " is not exist!"));
          return false;
        }
        if (this.xfe != null) {
          this.xfe.N(this.xfc);
        }
        String str = SharePatchFileUtil.l(this.xfc, this.xfd);
        if (!this.xey) {
          break label453;
        }
        localObject1 = this.xfc.getAbsolutePath();
        localObject2 = new File(str);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).getParentFile().mkdirs();
        }
        localObject2 = new ArrayList();
        ((List)localObject2).add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24)
        {
          ((List)localObject2).add("--runtime-arg");
          ((List)localObject2).add("-classpath");
          ((List)localObject2).add("--runtime-arg");
          ((List)localObject2).add("&");
        }
        ((List)localObject2).add("--dex-file=" + (String)localObject1);
        ((List)localObject2).add("--oat-file=" + str);
        ((List)localObject2).add("--instruction-set=" + xfb);
        if (Build.VERSION.SDK_INT <= 25) {
          break label440;
        }
        ((List)localObject2).add("--compiler-filter=quicken");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          new StringBuilder("Failed to optimize dex: ").append(this.xfc.getAbsolutePath());
          if (this.xfe == null) {
            break;
          }
          this.xfe.b(this.xfc, localThrowable);
          return false;
          label440:
          ((List)localObject2).add("--compiler-filter=interpret-only");
        }
        label453:
        DexFile.loadDex(this.xfc.getAbsolutePath(), localThrowable, 0);
        if (this.xfe == null) {
          break label494;
        }
        this.xfe.j(this.xfc, new File(localThrowable));
      }
      localObject1 = new ProcessBuilder((List)localObject2);
      ((ProcessBuilder)localObject1).redirectErrorStream(true);
      localObject1 = ((ProcessBuilder)localObject1).start();
      TinkerDexOptimizer.StreamConsumer.r(((Process)localObject1).getInputStream());
      TinkerDexOptimizer.StreamConsumer.r(((Process)localObject1).getErrorStream());
      try
      {
        int i = ((Process)localObject1).waitFor();
        if (i != 0) {
          throw new IOException("dex2oat works unsuccessfully, exit code: " + i);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new IOException("dex2oat is interrupted, msg: " + localInterruptedException.getMessage(), localInterruptedException);
      }
      label494:
      return true;
    }
  }
  
  public static abstract interface ResultCallback
  {
    public abstract void N(File paramFile);
    
    public abstract void b(File paramFile, Throwable paramThrowable);
    
    public abstract void j(File paramFile1, File paramFile2);
  }
  
  private static class StreamConsumer
  {
    static final Executor xff = ;
    
    static void r(InputStream paramInputStream)
    {
      xff.execute(new Runnable()
      {
        public final void run()
        {
          if (this.xfg == null) {
            return;
          }
          byte[] arrayOfByte = new byte['Ā'];
          try
          {
            int i;
            do
            {
              i = this.xfg.read(arrayOfByte);
            } while (i > 0);
            try
            {
              this.xfg.close();
              return;
            }
            catch (Exception localException1)
            {
              return;
            }
            try
            {
              this.xfg.close();
              throw ((Throwable)localObject);
            }
            catch (Exception localException3)
            {
              for (;;) {}
            }
          }
          catch (IOException localIOException)
          {
            localIOException = localIOException;
            try
            {
              this.xfg.close();
              return;
            }
            catch (Exception localException2) {}
          }
          finally
          {
            localObject = finally;
          }
        }
      });
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/TinkerDexOptimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */