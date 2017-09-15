package com.tencent.mm.au;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.c.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;

public final class e
{
  private static e hTL;
  byte[] gWs;
  public aq hCD;
  public String hTM;
  public com.tencent.mm.y.e hTN;
  
  static
  {
    GMTrace.i(3503888007168L, 26106);
    hTL = null;
    GMTrace.o(3503888007168L, 26106);
  }
  
  public e()
  {
    GMTrace.i(3502545829888L, 26096);
    this.hCD = new aq(1, "speex_worker");
    this.gWs = new byte[0];
    this.hTN = new com.tencent.mm.y.e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(3502008958976L, 26092);
        if (e.this.hTM == null)
        {
          GMTrace.o(3502008958976L, 26092);
          return;
        }
        v.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramAnonymousk).filename + " filepath " + e.this.hTM + " errCode " + paramAnonymousInt2);
        if (((a)paramAnonymousk).filename.equals(e.this.hTM))
        {
          h.vd().b(240, e.this.hTN);
          if (paramAnonymousInt2 == 0)
          {
            d.JL();
            d.JN();
          }
          paramAnonymousString = new File(e.this.hTM);
          try
          {
            boolean bool = paramAnonymousString.delete();
            v.d("MicroMsg.SpeexUploadCore", "delete " + e.this.hTM + " delete " + bool + " errCode " + paramAnonymousInt2);
            e.JS().start();
            e.this.hTM = null;
            GMTrace.o(3502008958976L, 26092);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            v.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { bf.g(paramAnonymousString) });
            e.JS().start();
            e.this.hTM = null;
            GMTrace.o(3502008958976L, 26092);
            return;
          }
          finally
          {
            e.JS().start();
            e.this.hTM = null;
          }
        }
        GMTrace.o(3502008958976L, 26092);
      }
    };
    GMTrace.o(3502545829888L, 26096);
  }
  
  public static e JS()
  {
    GMTrace.i(3502680047616L, 26097);
    if (hTL == null) {
      hTL = new e();
    }
    e locale = hTL;
    GMTrace.o(3502680047616L, 26097);
    return locale;
  }
  
  static File aZ(int paramInt1, int paramInt2)
  {
    GMTrace.i(3503082700800L, 26100);
    Object localObject1 = new File(b.JK());
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      GMTrace.o(3503082700800L, 26100);
      return null;
    }
    File[] arrayOfFile = ((File)localObject1).listFiles();
    int i = 0;
    localObject1 = null;
    Object localObject2 = localObject1;
    if (arrayOfFile != null)
    {
      localObject2 = localObject1;
      if (i < arrayOfFile.length)
      {
        localObject2 = arrayOfFile[i];
        localObject1 = localObject2;
        long l;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((File)localObject2).isFile())
          {
            v.d("MicroMsg.SpeexUploadCore", "file " + ((File)localObject2).getPath());
            localObject1 = ((File)localObject2).getPath();
            l = ((File)localObject2).length();
            if (((File)localObject2).getName().endsWith(".spx")) {
              break label168;
            }
          }
        }
        for (localObject1 = null;; localObject1 = null)
        {
          i += 1;
          break;
          label168:
          if ((l >= paramInt1) && (l <= paramInt2)) {
            break label224;
          }
          v.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          com.tencent.mm.loader.stub.b.deleteFile((String)localObject1);
        }
      }
    }
    label224:
    GMTrace.o(3503082700800L, 26100);
    return (File)localObject2;
  }
  
  public final void b(aq.a parama)
  {
    GMTrace.i(3502814265344L, 26098);
    v.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.hCD.c(parama);
    GMTrace.o(3502814265344L, 26098);
  }
  
  public final void start()
  {
    GMTrace.i(3502948483072L, 26099);
    if (!al.isWifi(aa.getContext()))
    {
      GMTrace.o(3502948483072L, 26099);
      return;
    }
    new ad(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3497848209408L, 26061);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            GMTrace.i(3497311338496L, 26057);
            e.this.b(new aq.a()
            {
              public final boolean Bn()
              {
                GMTrace.i(3502277394432L, 26094);
                GMTrace.o(3502277394432L, 26094);
                return true;
              }
              
              public final boolean Bo()
              {
                GMTrace.i(3502411612160L, 26095);
                e locale = e.this;
                v.d("MicroMsg.SpeexUploadCore", "uploadOneFile");
                Object localObject2;
                int i;
                synchronized (locale.gWs)
                {
                  if (locale.hTM != null)
                  {
                    v.d("MicroMsg.SpeexUploadCore", "uploading...");
                    GMTrace.o(3502411612160L, 26095);
                    return false;
                  }
                  localObject2 = d.a.JR();
                  if (localObject2 != null)
                  {
                    if (1 == g.j("EnableSpeexVoiceUpload", 0)) {
                      break label600;
                    }
                    if (((d.a)localObject2).JP() == 0)
                    {
                      i = 0;
                      break label588;
                    }
                  }
                  else
                  {
                    v.d("MicroMsg.SpeexUploadCore", "SpeexConfig not allow");
                  }
                }
                boolean bool;
                if (!al.isWifi(aa.getContext()))
                {
                  i = 0;
                }
                else
                {
                  h.vJ();
                  i = bf.a((Integer)h.vI().vr().get(12290, null), 0);
                  if (((d.a)localObject2).gkh == 0) {}
                  for (bool = true;; bool = true)
                  {
                    label165:
                    v.d("upload", "fitSex " + ((d.a)localObject2).gkh + " " + bool + " " + ((d.a)localObject2).gkh);
                    if (bool) {
                      break;
                    }
                    i = 0;
                    break label588;
                    if (((d.a)localObject2).gkh != i) {
                      break label595;
                    }
                  }
                  if (((d.a)localObject2).JO()) {
                    break label600;
                  }
                  i = 0;
                }
                label443:
                label553:
                label588:
                label595:
                label600:
                label603:
                for (;;)
                {
                  localObject2 = e.aZ(((d.a)localObject2).hTE, ((d.a)localObject2).hTF);
                  if (localObject2 == null)
                  {
                    v.d("MicroMsg.SpeexUploadCore", "no target to upload");
                    break;
                  }
                  Object localObject3 = ((File)localObject2).getPath();
                  try
                  {
                    localObject3 = new File(((String)localObject3).replace(".spx", ".uploading"));
                    if (!((File)localObject2).renameTo((File)localObject3)) {
                      break label553;
                    }
                    ((e)localObject1).hTM = ((File)localObject3).getPath();
                    localObject2 = ((File)localObject3).getName();
                    v.d("MicroMsg.SpeexUploadCore", "upload file " + ((e)localObject1).hTM);
                    localObject3 = new d.b();
                    arrayOfString = ((String)localObject2).substring(0, ((String)localObject2).indexOf('.')).split("_");
                    i = arrayOfString.length;
                    if (i != 5) {}
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      String[] arrayOfString;
                      a locala;
                      v.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { bf.g(localException) });
                      continue;
                      v.d("MicroMsg.SpeexUploadCore", "delete " + ((File)localObject2).getPath());
                      ((File)localObject2).delete();
                    }
                  }
                  try
                  {
                    ((d.b)localObject3).hQT = arrayOfString[0];
                    ((d.b)localObject3).sampleRate = bf.getInt(arrayOfString[1], 0);
                    ((d.b)localObject3).hTq = bf.getInt(arrayOfString[2], 0);
                    ((d.b)localObject3).hTr = bf.getInt(arrayOfString[3], 0);
                    h.vd().a(240, ((e)localObject1).hTN);
                    locala = new a(((e)localObject1).hTM, d.kO((String)localObject2), ((d.b)localObject3).sampleRate, ((d.b)localObject3).hTq, ((d.b)localObject3).hTr);
                    h.vd().a(locala, 0);
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    v.e("upload", "wrong format", new Object[] { localNumberFormatException });
                    break label443;
                  }
                  for (;;)
                  {
                    if (i != 0) {
                      break label603;
                    }
                    break;
                    bool = false;
                    break label165;
                    i = 1;
                  }
                }
              }
            });
            GMTrace.o(3497311338496L, 26057);
            return false;
          }
        });
        GMTrace.o(3497848209408L, 26061);
      }
    }, 100L);
    GMTrace.o(3502948483072L, 26099);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/au/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */