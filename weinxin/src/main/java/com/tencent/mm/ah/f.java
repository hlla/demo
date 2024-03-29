package com.tencent.mm.ah;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.u;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class f
  extends com.tencent.mm.sdk.e.j
{
  public static final String[] gUn;
  public static int hFm;
  public static long hFz;
  public com.tencent.mm.a.f<String, Bitmap> hFn;
  com.tencent.mm.a.f<String, String> hFo;
  List<b> hFp;
  Map<Integer, WeakReference<ImageView>> hFq;
  Map<Integer, WeakReference<ImageView>> hFr;
  Map<Integer, WeakReference<View>> hFs;
  Set<Integer> hFt;
  private Map<String, String> hFu;
  private long hFv;
  FrameLayout.LayoutParams hFw;
  private SoftReference<ColorDrawable> hFx;
  public int hFy;
  public ad hgD;
  public com.tencent.mm.bj.g hnp;
  
  static
  {
    GMTrace.i(3526839238656L, 26277);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0)", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
    hFm = 0;
    hFz = 0L;
    GMTrace.o(3526839238656L, 26277);
  }
  
  public f(com.tencent.mm.bj.g paramg)
  {
    GMTrace.i(3519188828160L, 26220);
    this.hFn = new com.tencent.mm.a.f(40, new com.tencent.mm.a.f.b() {});
    this.hFo = new com.tencent.mm.a.f(40, new com.tencent.mm.a.f.b() {});
    this.hFp = new ArrayList();
    this.hFq = new HashMap();
    this.hFr = new HashMap();
    this.hFs = new HashMap();
    this.hFt = new HashSet();
    this.hgD = new ad(Looper.getMainLooper());
    this.hFu = new HashMap();
    this.hFv = 1L;
    this.hnp = null;
    this.hFw = new FrameLayout.LayoutParams(-2, -2);
    this.hFy = 150;
    a(paramg);
    this.hnp = paramg;
    GE();
    GMTrace.o(3519188828160L, 26220);
  }
  
  private String A(String paramString, int paramInt)
  {
    GMTrace.i(3524825972736L, 26262);
    paramString = z(FileOp.kp(paramString), paramInt);
    if (!bf.mA(paramString.hEJ))
    {
      paramString = v(paramString.hEJ, true);
      if (FileOp.aO(paramString))
      {
        GMTrace.o(3524825972736L, 26262);
        return paramString;
      }
    }
    GMTrace.o(3524825972736L, 26262);
    return null;
  }
  
  /* Error */
  public static String GF()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc2_w 205
    //   6: sipush 26264
    //   9: invokestatic 66	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   12: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   15: lstore_2
    //   16: getstatic 92	com/tencent/mm/ah/f:hFz	J
    //   19: lstore 4
    //   21: lload_2
    //   22: lstore_0
    //   23: lload 4
    //   25: lload_2
    //   26: lcmp
    //   27: ifne +11 -> 38
    //   30: lconst_1
    //   31: invokestatic 218	java/lang/Thread:sleep	(J)V
    //   34: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   37: lstore_0
    //   38: lload_0
    //   39: putstatic 92	com/tencent/mm/ah/f:hFz	J
    //   42: lload_0
    //   43: invokestatic 222	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   46: invokevirtual 226	java/lang/String:getBytes	()[B
    //   49: invokestatic 232	com/tencent/mm/a/g:n	([B)Ljava/lang/String;
    //   52: astore 6
    //   54: ldc2_w 205
    //   57: sipush 26264
    //   60: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload 6
    //   68: areturn
    //   69: astore 6
    //   71: goto -37 -> 34
    //   74: astore 6
    //   76: ldc 2
    //   78: monitorexit
    //   79: aload 6
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	21	0	l1	long
    //   15	11	2	l2	long
    //   19	5	4	l3	long
    //   52	15	6	str	String
    //   69	1	6	localInterruptedException	InterruptedException
    //   74	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	34	69	java/lang/InterruptedException
    //   3	21	74	finally
    //   30	34	74	finally
    //   34	38	74	finally
    //   38	63	74	finally
  }
  
  private Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    GMTrace.i(3524289101824L, 26258);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    GMTrace.o(3524289101824L, 26258);
    return paramString1;
  }
  
  private Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    GMTrace.i(3524154884096L, 26257);
    paramString1 = this.hnp.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    GMTrace.o(3524154884096L, 26257);
    return paramString1;
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    GMTrace.i(3522141618176L, 26242);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, paramBoolean5, null);
    GMTrace.o(3522141618176L, 26242);
    return paramString;
  }
  
  private d a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString2, long paramLong, String paramString3, String paramString4, com.tencent.mm.a.b paramb1, com.tencent.mm.a.b paramb2, m.a parama)
  {
    GMTrace.i(3525362843648L, 26266);
    if (!FileOp.aO(paramString1))
    {
      GMTrace.o(3525362843648L, 26266);
      return null;
    }
    String str2 = FileOp.kp(paramString1);
    v.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString1 });
    long l;
    if (!FileOp.aO(paramString1))
    {
      v.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      paramPInt1 = null;
      if ((parama != null) && (parama.hEK == paramInt1))
      {
        paramb1 = parama.GM();
        paramString2 = paramb1.hGW;
        paramString3 = paramb1.hGX;
        paramPInt2 = paramb1.hER;
        paramString4 = paramb1.hGY;
        paramb1 = paramb1.hGZ;
        v.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramb1.value });
        paramb1 = new d();
        paramb1.fRM = -1;
        l = this.hFv;
        this.hFv = (1L + l);
        paramb1.ah(l);
        paramb1.ag(paramLong);
        if (!bf.mA(paramPInt2)) {
          paramb1.js(paramPInt2);
        }
        paramb1.fR(0);
        paramb1.cFR = paramInt2;
        paramb1.hFf = true;
        if (paramInt2 != 4) {
          break label852;
        }
        if (!paramString1.startsWith(u.xh())) {
          break label843;
        }
        paramb1.fQ(3);
        label280:
        if (paramBoolean)
        {
          paramb1.jp(paramString2.value + ".jpg");
          if ((paramString4 != null) && (!bf.mA(paramString4.value))) {
            paramb1.jq(paramString4.value + ".jpg");
          }
          if (bf.mA(paramb1.hEJ)) {
            paramb1.jr(paramPInt1);
          }
          paramb1.fO((int)FileOp.kj(paramString3.value));
          if (paramb1.hrb == 0) {
            v.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString3.value });
          }
          paramb1.jo(str2);
        }
        paramb1.fN((int)bf.Nz());
        paramb1.fS(paramInt1);
        v.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramb1.hrb);
        GMTrace.o(3525362843648L, 26266);
        return paramb1;
      }
    }
    else
    {
      String str1 = paramString3;
      if (bf.mA(paramString3)) {
        str1 = GF();
      }
      str1 = "THUMBNAIL_DIRPATH://th_" + str1;
      paramString3 = a(str1, "th_", "", false);
      if (paramb1 == null) {
        paramString3 = m(str1, "th_", "");
      }
      if (paramBoolean)
      {
        if ((!bf.mA(paramString2)) && (FileOp.aO(paramString2))) {
          break label698;
        }
        l = bf.NB();
        a(paramString1, paramInt1, paramInt3, paramPInt1, paramPInt2, true, paramString3, paramb1);
        if (!FileOp.aO(paramString3)) {
          break label686;
        }
        com.tencent.mm.plugin.report.service.g.oSF.i(10921, new Object[] { Long.valueOf(FileOp.kj(paramString3)), Long.valueOf(FileOp.kj(paramString1)), Integer.valueOf(90), Long.valueOf(bf.aB(l)) });
      }
      for (;;)
      {
        v.d("MicroMsg.ImgInfoStorage", "insert: thumbName = " + str1);
        paramPInt1 = str1;
        break;
        label686:
        v.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
        continue;
        label698:
        FileOp.p(paramString2, paramString3);
      }
    }
    if ((parama != null) && (parama.hEK != paramInt1)) {
      paramString2 = null;
    }
    for (paramPInt2 = null;; paramPInt2 = paramString4)
    {
      paramb1 = new PString();
      paramString3 = new PString();
      paramString4 = new PString();
      paramb2 = new PString();
      paramPInt2 = a(paramString1, str2, paramInt1, paramBoolean, paramb1, paramString3, paramString4, paramb2, paramPInt2, paramString2);
      v.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramb2.value });
      paramString2 = paramb1;
      break;
      label843:
      paramb1.fQ(2);
      break label280;
      label852:
      paramb1.fQ(1);
      break label280;
      paramString2 = paramb2;
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(3521604747264L, 26238);
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.hFp.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (m == localb.hFG)
      {
        v.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.hFG), localb.url });
        localb.url = paramString;
        if (!this.hFt.contains(Integer.valueOf(k)))
        {
          this.hFt.add(Integer.valueOf(k));
          a(paramString, paramFloat, paramBoolean, paramInt);
        }
        GMTrace.o(3521604747264L, 26238);
        return;
      }
    }
    this.hFq.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i = 0;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.hFr.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    int j = 0;
    if (paramView != null)
    {
      j = paramView.hashCode();
      this.hFs.put(Integer.valueOf(j), new WeakReference(paramView));
    }
    paramImageView1 = new b(m, paramString, i, j);
    this.hFp.add(paramImageView1);
    if (!this.hFt.contains(Integer.valueOf(k)))
    {
      this.hFt.add(Integer.valueOf(k));
      a(paramString, paramFloat, paramBoolean, paramInt);
    }
    GMTrace.o(3521604747264L, 26238);
  }
  
  private static void a(com.tencent.mm.bj.g paramg)
  {
    int i = 0;
    GMTrace.i(3519457263616L, 26222);
    Cursor localCursor = paramg.a("PRAGMA table_info(ImgInfo2)", null, 2);
    int i7 = localCursor.getColumnIndex("name");
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (localCursor.moveToNext()) {
      if (i7 >= 0)
      {
        String str = localCursor.getString(i7);
        int i2 = i1;
        if ("hashdthumb".equals(str)) {
          i2 = 1;
        }
        int i3 = n;
        if ("iscomplete".equals(str)) {
          i3 = 1;
        }
        int i4 = m;
        if ("origImgMD5".equals(str)) {
          i4 = 1;
        }
        int i5 = k;
        if ("compressType".equals(str)) {
          i5 = 1;
        }
        int i6 = j;
        if ("midImgPath".equals(str)) {
          i6 = 1;
        }
        j = i6;
        k = i5;
        m = i4;
        n = i3;
        i1 = i2;
        if ("forwardType".equals(str))
        {
          i = 1;
          j = i6;
          k = i5;
          m = i4;
          n = i3;
          i1 = i2;
        }
      }
    }
    localCursor.close();
    long l = com.tencent.mm.kernel.h.vI().gXW.cs(Thread.currentThread().getId());
    if (i1 == 0) {
      paramg.eE("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
    }
    if (n == 0) {
      paramg.eE("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
    }
    if (m == 0) {
      paramg.eE("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
    }
    if (k == 0) {
      paramg.eE("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
    }
    if (j == 0) {
      paramg.eE("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
    }
    if (i == 0) {
      paramg.eE("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
    }
    if (l > 0L) {
      com.tencent.mm.kernel.h.vI().gXW.aD(l);
    }
    GMTrace.o(3519457263616L, 26222);
  }
  
  private void a(final String paramString, final float paramFloat, final boolean paramBoolean, final int paramInt)
  {
    GMTrace.i(3521738964992L, 26239);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3540663664640L, 26380);
        f.this.a(paramString, true, paramFloat, true, false, paramBoolean, paramInt);
        f.this.hgD.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3505632837632L, 26119);
            f localf = f.this;
            String str = f.4.this.hFB;
            v.d("MicroMsg.ImgInfoStorage", "checkrefresh load done, uri: %s", new Object[] { str });
            int i = str.hashCode();
            localf.hFt.remove(Integer.valueOf(i));
            Iterator localIterator = localf.hFp.iterator();
            while (localIterator.hasNext())
            {
              Object localObject = (f.b)localIterator.next();
              if (str.equals(((f.b)localObject).url))
              {
                Bitmap localBitmap = (Bitmap)localf.hFn.get(str);
                if ((localBitmap != null) && (!localBitmap.isRecycled()))
                {
                  ImageView localImageView = (ImageView)((WeakReference)localf.hFq.get(Integer.valueOf(((f.b)localObject).hFG))).get();
                  if (localImageView != null)
                  {
                    v.i("MicroMsg.ImgInfoStorage", "[checkrefresh] bitmap width %d,height %d", new Object[] { Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
                    f.a.a(localBitmap, localImageView);
                    localImageView.setLayoutParams(localf.hFw);
                    if (localBitmap.getWidth() >= localBitmap.getHeight() * 2)
                    {
                      i = 1;
                      label234:
                      if (localBitmap.getHeight() < localBitmap.getWidth() * 2) {
                        break label458;
                      }
                    }
                    label458:
                    for (int j = 1;; j = 0)
                    {
                      if ((i != 0) || (j != 0))
                      {
                        v.d("MicroMsg.ImgInfoStorage", "bm: w:%d, h:%d ", new Object[] { Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
                        localImageView.setScaleType(ImageView.ScaleType.CENTER);
                      }
                      if (localf.hFr.get(Integer.valueOf(((f.b)localObject).hFH)) != null)
                      {
                        localImageView = (ImageView)((WeakReference)localf.hFr.get(Integer.valueOf(((f.b)localObject).hFH))).get();
                        if (localImageView != null) {
                          localImageView.setLayoutParams(new FrameLayout.LayoutParams(localBitmap.getWidth(), localBitmap.getHeight()));
                        }
                      }
                      if (localf.hFs.get(Integer.valueOf(((f.b)localObject).hFI)) == null) {
                        break;
                      }
                      localObject = (View)((WeakReference)localf.hFs.get(Integer.valueOf(((f.b)localObject).hFI))).get();
                      if (localObject == null) {
                        break;
                      }
                      ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(localBitmap.getWidth(), localBitmap.getHeight()));
                      break;
                      i = 0;
                      break label234;
                    }
                  }
                }
              }
            }
            GMTrace.o(3505632837632L, 26119);
          }
        });
        GMTrace.o(3540663664640L, 26380);
      }
      
      public final String toString()
      {
        GMTrace.i(3540797882368L, 26381);
        String str = super.toString() + "|loadImginBackground";
        GMTrace.o(3540797882368L, 26381);
        return str;
      }
    });
    GMTrace.o(3521738964992L, 26239);
  }
  
  private long e(d paramd)
  {
    GMTrace.i(3524691755008L, 26261);
    long l = this.hnp.insert("ImgInfo2", "id", paramd.pv());
    if (l != -1L) {
      paramd.GD();
    }
    v.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramd.hEG), Long.valueOf(paramd.hEO), Long.valueOf(paramd.fTG), Integer.valueOf(paramd.hEQ) });
    GMTrace.o(3524691755008L, 26261);
    return l;
  }
  
  public static String ju(String paramString)
  {
    GMTrace.i(3519994134528L, 26226);
    paramString = "THUMBNAIL_DIRPATH://th_" + paramString;
    GMTrace.o(3519994134528L, 26226);
    return paramString;
  }
  
  public static String p(au paramau)
  {
    GMTrace.i(3526436585472L, 26274);
    if (paramau == null)
    {
      v.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      GMTrace.o(3526436585472L, 26274);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject1;
    if (paramau.field_isSend == 1)
    {
      localObject2 = n.GT().aj(paramau.field_msgId);
      localObject1 = localObject2;
      if (((d)localObject2).hEG != 0L) {}
    }
    else
    {
      localObject1 = n.GT().ai(paramau.field_msgSvrId);
    }
    if (com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
      if (paramau.field_isSend == 1)
      {
        paramau = e.c((d)localObject1);
        localObject2 = n.GT().m(paramau, "", "");
        if ((paramau != null) && (paramau.length() > 0) && (FileOp.aO((String)localObject2)))
        {
          GMTrace.o(3526436585472L, 26274);
          return (String)localObject2;
        }
        paramau = ((d)localObject1).hEH;
        localObject1 = n.GT().m(paramau, "", "");
        if ((paramau != null) && (paramau.length() > 0) && (FileOp.aO((String)localObject1)))
        {
          GMTrace.o(3526436585472L, 26274);
          return (String)localObject1;
        }
      }
      else if (((d)localObject1).GB())
      {
        paramau = ((d)localObject1).hEH;
        if (!((d)localObject1).GC()) {
          break label324;
        }
        localObject1 = e.a((d)localObject1);
        if ((localObject1 == null) || (((d)localObject1).hEG <= 0L) || (!((d)localObject1).GB()) || (!FileOp.aO(n.GT().m(((d)localObject1).hEH, "", "")))) {
          break label324;
        }
        paramau = ((d)localObject1).hEH;
      }
    }
    label324:
    for (;;)
    {
      GMTrace.o(3526436585472L, 26274);
      return paramau;
      v.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      GMTrace.o(3526436585472L, 26274);
      return null;
    }
  }
  
  private d z(String paramString, int paramInt)
  {
    GMTrace.i(3522946924544L, 26248);
    d locald = new d();
    paramString = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[] { paramString, String.valueOf(paramInt) }, null, null, null);
    if ((paramString != null) && (paramString.moveToFirst())) {
      locald.b(paramString);
    }
    paramString.close();
    GMTrace.o(3522946924544L, 26248);
    return locald;
  }
  
  public final void GE()
  {
    GMTrace.i(3519323045888L, 26221);
    Cursor localCursor = this.hnp.a("SELECT max(id) FROM ImgInfo2", null, 2);
    if (localCursor.moveToFirst()) {
      this.hFv = (localCursor.getLong(0) + 1L);
    }
    localCursor.close();
    v.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.hFv);
    GMTrace.o(3519323045888L, 26221);
  }
  
  public final int a(int paramInt, d paramd)
  {
    GMTrace.i(3525765496832L, 26269);
    paramInt = a(Long.valueOf(paramInt), paramd);
    GMTrace.o(3525765496832L, 26269);
    return paramInt;
  }
  
  public final int a(Long paramLong, d paramd)
  {
    GMTrace.i(3525899714560L, 26270);
    long l = System.currentTimeMillis();
    ContentValues localContentValues = paramd.pv();
    if (localContentValues.size() == 0) {}
    for (int i = 1;; i = this.hnp.update("ImgInfo2", localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      v.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString() });
      if (i != -1)
      {
        paramd.GD();
        doNotify();
      }
      GMTrace.o(3525899714560L, 26270);
      return i;
    }
  }
  
  public final long a(String paramString, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    GMTrace.i(3524423319552L, 26259);
    long l = a(paramString, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null);
    GMTrace.o(3524423319552L, 26259);
    return l;
  }
  
  public final long a(String paramString1, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, long paramLong, com.tencent.mm.a.b paramb1, com.tencent.mm.a.b paramb2, m.a parama)
  {
    GMTrace.i(3524557537280L, 26260);
    if (paramInt1 == 0)
    {
      paramString1 = a(paramString1, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString2, paramString3, paramb2, paramb1, parama);
      if (paramString1 == null)
      {
        GMTrace.o(3524557537280L, 26260);
        return -1L;
      }
      paramPString.value = paramString1.hEJ;
      paramLong = e(paramString1);
      if (paramLong != -1L) {
        doNotify();
      }
      GMTrace.o(3524557537280L, 26260);
      return paramLong;
    }
    if (paramInt1 == 1)
    {
      paramPInt1 = a(paramString1, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString2, paramString3, paramb2, paramb1, parama);
      if (paramPInt1 == null)
      {
        GMTrace.o(3524557537280L, 26260);
        return -1L;
      }
      paramPString.value = paramPInt1.hEJ;
      paramPInt1.ag(0L);
      paramPInt1.y(0L);
      paramPInt1.fO((int)FileOp.kj(m(paramPInt1.hEH, "", "")));
      paramString1 = a(paramString1, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString2, paramString3, paramb2, paramb1, parama);
      paramString1.jp(paramPInt1.hEH);
      paramString1.jr(paramPInt1.hEJ);
      paramString1.jq(paramPInt1.hEI);
      paramString1.fO(0);
      paramLong = this.hnp.cs(Thread.currentThread().getId());
      paramString1.fP((int)e(paramPInt1));
      long l = e(paramString1);
      v.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramString1.hEG), Long.valueOf(paramString1.hEO), paramString1.hEH, paramString1.hEI, Integer.valueOf(paramString1.hrb) });
      if (paramLong > 0L) {
        com.tencent.mm.kernel.h.vI().gXW.aD(paramLong);
      }
      if (l != -1L) {
        doNotify();
      }
      GMTrace.o(3524557537280L, 26260);
      return l;
    }
    Assert.assertTrue(false);
    GMTrace.o(3524557537280L, 26260);
    return 0L;
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    GMTrace.i(3525631279104L, 26268);
    String str1 = "SERVERID://" + paramLong;
    String str2 = com.tencent.mm.a.g.n(str1.getBytes());
    String str3 = m(str2, "th_", "");
    Bitmap localBitmap;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 0))
    {
      localBitmap = com.tencent.mm.sdk.platformtools.d.be(paramArrayOfByte);
      if (localBitmap == null) {
        v.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(paramArrayOfByte));
      }
      if ((paramBoolean) || (localBitmap == null)) {}
    }
    try
    {
      localBitmap = com.tencent.mm.sdk.platformtools.d.J(localBitmap);
      paramPInt1.value = localBitmap.getWidth();
      paramPInt2.value = localBitmap.getHeight();
      com.tencent.mm.sdk.platformtools.d.a(localBitmap, 90, Bitmap.CompressFormat.JPEG, str3, true);
      paramArrayOfByte = new d();
      if (!bf.mA(paramString1))
      {
        paramArrayOfByte.setOffset(paramInt);
        paramArrayOfByte.fO(paramInt);
        paramArrayOfByte.fRM = -1;
        long l = this.hFv;
        this.hFv = (1L + l);
        paramArrayOfByte.ah(l);
        paramArrayOfByte.jp(paramString1);
        paramArrayOfByte.jr("THUMBNAIL_DIRPATH://th_" + str2);
        paramPString.value = paramArrayOfByte.hEJ;
        if (paramBoolean)
        {
          paramArrayOfByte.y(0L);
          paramArrayOfByte.js(paramString2);
          paramArrayOfByte.fN((int)bf.Nz());
          paramLong = e(paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          GMTrace.o(3525631279104L, 26268);
          return paramLong;
        }
      }
    }
    catch (IOException paramPInt1)
    {
      for (;;)
      {
        v.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + str2 + " " + new String(paramArrayOfByte));
        continue;
        paramArrayOfByte.y(paramLong);
        continue;
        paramString1 = str1;
      }
    }
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    GMTrace.i(3525497061376L, 26267);
    paramLong = a(paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString, paramPString, paramPInt1, paramPInt2);
    GMTrace.o(3525497061376L, 26267);
    return paramLong;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    GMTrace.i(3526033932288L, 26271);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from" + paramLong;; str = "location_backgroup_key_tor" + paramLong)
    {
      Bitmap localBitmap2 = (Bitmap)this.hFn.get(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.d.f(paramString, paramInt1, paramInt2, paramInt3);
        this.hFn.k(str, localBitmap1);
      }
      GMTrace.o(3526033932288L, 26271);
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat)
  {
    GMTrace.i(3521873182720L, 26240);
    paramString = a(paramString, true, paramFloat, false, true, false, 0);
    GMTrace.o(3521873182720L, 26240);
    return paramString;
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext)
  {
    GMTrace.i(3522410053632L, 26244);
    paramString = a(paramString, paramFloat, paramContext, -1);
    GMTrace.o(3522410053632L, 26244);
    return paramString;
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext, int paramInt)
  {
    GMTrace.i(3522544271360L, 26245);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(3522544271360L, 26245);
      return null;
    }
    String str = paramString.trim();
    Bitmap localBitmap = (Bitmap)this.hFn.get(str);
    int k;
    int m;
    int j;
    int i;
    if (localBitmap != null)
    {
      paramString = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = BackwardSupportUtil.b.c(str, paramFloat);
      if (localBitmap == null) {
        break label373;
      }
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (k < m) {
        break label291;
      }
      j = BackwardSupportUtil.b.a(paramContext, this.hFy);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label319;
      }
      v.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 188L, 1L, false);
      paramString = null;
      label197:
      paramContext = paramString;
      if (paramInt != -1) {
        paramContext = com.tencent.mm.sdk.platformtools.d.b(paramString, paramInt);
      }
      if (localBitmap != paramContext)
      {
        v.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      v.d("MicroMsg.ImgInfoStorage", "cached file " + str);
      this.hFn.k(str, paramContext);
    }
    label291:
    label319:
    label373:
    for (paramString = paramContext;; paramString = localBitmap)
    {
      GMTrace.o(3522544271360L, 26245);
      return paramString;
      i = BackwardSupportUtil.b.a(paramContext, this.hFy);
      j = (int)(k / m * i);
      break;
      try
      {
        paramString = Bitmap.createScaledBitmap(localBitmap, j, i, true);
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[] { paramString.getMessage() });
        paramString = null;
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 188L, 1L, false);
      }
      break label197;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, boolean paramBoolean)
  {
    GMTrace.i(3521202094080L, 26235);
    paramString = a(paramString, false, paramFloat, paramBoolean, false, false, -1);
    GMTrace.o(3521202094080L, 26235);
    return paramString;
  }
  
  public final Bitmap a(String paramString1, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString2, com.tencent.mm.a.b paramb)
  {
    GMTrace.i(3524960190464L, 26263);
    v.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s]", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), bf.bJP() });
    Bitmap localBitmap = (Bitmap)this.hFn.get(paramString1);
    String str1;
    String str2;
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      str1 = A(paramString1, paramInt1);
      if (!bf.mA(str1)) {
        if (str1.endsWith("hd"))
        {
          str2 = str1;
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            break label367;
          }
          int i = com.tencent.mm.sdk.platformtools.d.Pe(str2);
          int j = BackwardSupportUtil.ExifHelper.Pb(str2);
          if (i <= 0) {
            break label330;
          }
          localBitmap = com.tencent.mm.sdk.platformtools.d.c(str2, 2000, 2000, i, j + paramInt2 * 90, 0);
        }
      }
    }
    for (;;)
    {
      label159:
      if (localBitmap != null)
      {
        this.hFn.k(paramString1, localBitmap);
        paramPInt1.value = localBitmap.getWidth();
        paramPInt2.value = localBitmap.getHeight();
        if (paramBoolean)
        {
          paramPInt1 = str1;
          if (str1 == null) {
            paramPInt1 = A(paramString1, paramInt1);
          }
          paramString1 = paramPInt1;
          if (!bf.mA(paramPInt1))
          {
            paramString1 = paramPInt1;
            if (paramPInt1.endsWith("hd")) {
              paramString1 = paramPInt1.substring(0, paramPInt1.length() - 2);
            }
          }
          if (paramb != null) {
            paramb.nV();
          }
          if ((bf.mA(paramString1)) || (!FileOp.aO(paramString1))) {
            break label347;
          }
          FileOp.p(paramString1, paramString2);
          v.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", new Object[] { paramString1 });
        }
      }
      for (;;)
      {
        GMTrace.o(3524960190464L, 26263);
        return localBitmap;
        localBitmap = com.tencent.mm.sdk.platformtools.d.cz(str1, 0);
        str2 = paramString1;
        break;
        label330:
        localBitmap = com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, true, false, 0);
        break label159;
        try
        {
          label347:
          com.tencent.mm.sdk.platformtools.d.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, paramString2, false);
        }
        catch (IOException paramString1) {}
      }
      label367:
      continue;
      str2 = paramString1;
      break;
      str1 = null;
    }
  }
  
  public final Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    GMTrace.i(3522007400448L, 26241);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, true);
    GMTrace.o(3522007400448L, 26241);
    return paramString;
  }
  
  public final Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5, Bitmap paramBitmap)
  {
    GMTrace.i(3522275835904L, 26243);
    String str = paramString;
    if (!paramBoolean1) {
      str = b(paramString, false, true);
    }
    if (str == null)
    {
      GMTrace.o(3522275835904L, 26243);
      return null;
    }
    Object localObject1 = null;
    int k;
    label83:
    Object localObject2;
    label142:
    long l;
    int m;
    int n;
    int i;
    int j;
    if (paramBitmap != null)
    {
      k = 1;
      if (paramBoolean5)
      {
        paramString = (Bitmap)this.hFn.get(str);
        localObject1 = paramString;
        if (paramString == null)
        {
          if (paramString != null) {
            break label697;
          }
          paramBoolean1 = true;
          v.h("MicroMsg.ImgInfoStorage", "bm is null:%b,  url:%s", new Object[] { Boolean.valueOf(paramBoolean1), str });
          localObject1 = paramString;
        }
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        localObject2 = localObject1;
        if (k == 0) {}
      }
      else
      {
        bf.NA();
        if (k == 0) {
          break label702;
        }
        paramString = paramBitmap;
        if (paramBitmap == null) {
          paramString = com.tencent.mm.platformtools.j.mu(str);
        }
        localObject2 = localObject1;
        if (paramString != null)
        {
          l = System.currentTimeMillis();
          m = paramString.getWidth();
          n = paramString.getHeight();
          i = n;
          j = m;
          if (paramBoolean3)
          {
            if (hFm == 0) {
              hFm = com.tencent.mm.bg.a.U(aa.getContext(), a.b.kBL);
            }
            if (m <= hFm)
            {
              i = n;
              j = m;
              if (n <= hFm) {}
            }
            else
            {
              if (m <= n) {
                break label714;
              }
              i = n * hFm / m;
              j = hFm;
            }
          }
          label259:
          n = i;
          m = j;
          if (paramBoolean4)
          {
            if (str.endsWith("hd")) {
              break label919;
            }
            j = (int)(paramString.getWidth() * paramFloat * 1.25F);
            i = (int)(paramString.getHeight() * paramFloat * 1.25F);
          }
        }
      }
    }
    label353:
    label510:
    label697:
    label702:
    label714:
    label907:
    label919:
    for (;;)
    {
      float f;
      if ((j >= 160.0F * paramFloat) || (i >= 160.0F * paramFloat)) {
        if (i > j)
        {
          f = 160.0F * paramFloat / i;
          j = (int)(j * f);
          i = (int)(f * i);
        }
      }
      for (;;)
      {
        m = j;
        if (j < 60.0F * paramFloat)
        {
          v.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(j) });
          m = (int)(60.0F * paramFloat);
        }
        j = i;
        if (i < 60.0F * paramFloat)
        {
          v.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(i) });
          j = (int)(60.0F * paramFloat);
        }
        paramBitmap = aa.getContext();
        localObject1 = new int[2];
        if (j >= m)
        {
          paramFloat = j / m;
          if (paramFloat <= 2.0F)
          {
            i = com.tencent.mm.bg.a.U(paramBitmap, a.b.aWG);
            j = (int)(i / paramFloat);
            localObject1[0] = j;
            localObject1[1] = i;
            m = localObject1[0];
            n = localObject1[1];
          }
        }
        try
        {
          paramBitmap = Bitmap.createScaledBitmap(paramString, m, n, true);
          if ((paramString != paramBitmap) && (k == 0))
          {
            v.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramString.toString() });
            paramString.recycle();
          }
          if (paramBoolean4)
          {
            paramString = com.tencent.mm.sdk.platformtools.d.b(paramBitmap, paramInt);
            localObject1 = System.currentTimeMillis() - l;
            if (paramString != null) {
              break label907;
            }
            paramBitmap = "";
            v.i("MicroMsg.ImgInfoStorage", "cached file :%s bitmap time:%s bitmap:%s", new Object[] { str, localObject1, paramBitmap });
            localObject2 = paramString;
            if (paramString != null)
            {
              localObject2 = paramString;
              if (k == 0)
              {
                this.hFn.k(str, paramString);
                localObject2 = paramString;
              }
            }
            GMTrace.o(3522275835904L, 26243);
            return (Bitmap)localObject2;
            k = 0;
            break;
            paramBoolean1 = false;
            break label83;
            paramBitmap = com.tencent.mm.sdk.platformtools.d.a(str, paramFloat, 0);
            break label142;
            if (m == n)
            {
              i = hFm;
              j = hFm;
              break label259;
            }
            j = m * hFm / n;
            i = hFm;
            break label259;
            f = 160.0F * paramFloat / j;
            break label353;
            j = com.tencent.mm.bg.a.U(paramBitmap, a.b.aWH);
            i = (int)(j * paramFloat);
            break label510;
            paramFloat = m / j;
            if (paramFloat <= 2.0F)
            {
              j = com.tencent.mm.bg.a.U(paramBitmap, a.b.aWG);
              i = (int)(j / paramFloat);
              break label510;
            }
            i = com.tencent.mm.bg.a.U(paramBitmap, a.b.aWH);
            j = (int)(i * paramFloat);
          }
        }
        catch (OutOfMemoryError paramBitmap)
        {
          for (;;)
          {
            paramBitmap = paramString;
            continue;
            if (paramBoolean2)
            {
              paramString = com.tencent.mm.sdk.platformtools.d.a(paramBitmap, true, com.tencent.mm.bg.a.fromDPToPix(aa.getContext(), 3));
              v.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
            }
            else
            {
              paramString = paramBitmap;
              continue;
              paramBitmap = paramString.toString();
            }
          }
        }
      }
    }
  }
  
  public final String a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    GMTrace.i(3520665223168L, 26231);
    paramArrayOfByte = a(paramInt, paramArrayOfByte, paramBoolean, paramCompressFormat, false);
    GMTrace.o(3520665223168L, 26231);
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc2_w 1059
    //   3: sipush 26232
    //   6: invokestatic 66	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_2
    //   10: invokestatic 1064	com/tencent/mm/sdk/platformtools/bf:bm	([B)Z
    //   13: ifeq +23 -> 36
    //   16: ldc_w 256
    //   19: ldc_w 1066
    //   22: invokestatic 446	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc2_w 1059
    //   28: sipush 26232
    //   31: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 347	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   43: invokestatic 1003	com/tencent/mm/sdk/platformtools/bf:NA	()J
    //   46: invokevirtual 713	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokevirtual 226	java/lang/String:getBytes	()[B
    //   55: invokestatic 232	com/tencent/mm/a/g:n	([B)Ljava/lang/String;
    //   58: astore 10
    //   60: aload_0
    //   61: aload 10
    //   63: ldc_w 407
    //   66: ldc_w 409
    //   69: invokevirtual 416	com/tencent/mm/ah/f:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 11
    //   74: new 347	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   81: aload 11
    //   83: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 1068
    //   89: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 9
    //   97: ldc_w 256
    //   100: new 347	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 1070
    //   107: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload 11
    //   112: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 9
    //   123: invokestatic 1074	com/tencent/mm/modelsfs/FileOp:gQ	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   126: astore 8
    //   128: aload 8
    //   130: aload_2
    //   131: invokevirtual 1079	java/io/OutputStream:write	([B)V
    //   134: aload 8
    //   136: invokevirtual 1082	java/io/OutputStream:flush	()V
    //   139: iload_3
    //   140: ifeq +133 -> 273
    //   143: sipush 128
    //   146: istore 6
    //   148: goto +385 -> 533
    //   151: new 1084	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   154: dup
    //   155: invokespecial 1085	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   158: astore 12
    //   160: iload 5
    //   162: ifeq +125 -> 287
    //   165: aload 9
    //   167: aconst_null
    //   168: invokestatic 1089	com/tencent/mm/sdk/platformtools/d:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +131 -> 304
    //   176: aload_2
    //   177: bipush 90
    //   179: aload 4
    //   181: aload 11
    //   183: iconst_1
    //   184: invokestatic 842	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   187: ldc_w 256
    //   190: ldc_w 1091
    //   193: iconst_2
    //   194: anewarray 260	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 9
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: aload 11
    //   206: aastore
    //   207: invokestatic 715	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload 9
    //   212: invokestatic 200	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
    //   215: ifeq +18 -> 233
    //   218: ldc_w 256
    //   221: ldc_w 1093
    //   224: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload 9
    //   229: invokestatic 1096	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   232: pop
    //   233: aload 8
    //   235: ifnull +8 -> 243
    //   238: aload 8
    //   240: invokevirtual 1097	java/io/OutputStream:close	()V
    //   243: new 347	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 405
    //   250: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 10
    //   255: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: astore_2
    //   262: ldc2_w 1059
    //   265: sipush 26232
    //   268: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   271: aload_2
    //   272: areturn
    //   273: bipush 120
    //   275: istore 6
    //   277: goto +256 -> 533
    //   280: bipush 120
    //   282: istore 7
    //   284: goto -133 -> 151
    //   287: aload 9
    //   289: iload 6
    //   291: iload 7
    //   293: iconst_0
    //   294: aload 12
    //   296: iconst_0
    //   297: invokestatic 1100	com/tencent/mm/sdk/platformtools/d:a	(Ljava/lang/String;IIZLcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)Landroid/graphics/Bitmap;
    //   300: astore_2
    //   301: goto -129 -> 172
    //   304: aload 12
    //   306: invokevirtual 1103	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   309: sipush 2000
    //   312: if_icmplt -102 -> 210
    //   315: ldc_w 256
    //   318: ldc_w 1105
    //   321: iconst_2
    //   322: anewarray 260	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: aload 9
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload 11
    //   334: aastore
    //   335: invokestatic 1107	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload 9
    //   340: iload_1
    //   341: aload 12
    //   343: invokestatic 1113	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   346: astore_2
    //   347: getstatic 428	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   350: sipush 12712
    //   353: aload_2
    //   354: invokevirtual 1116	com/tencent/mm/plugin/report/service/g:A	(ILjava/lang/String;)V
    //   357: goto -147 -> 210
    //   360: astore 4
    //   362: aload 8
    //   364: astore_2
    //   365: getstatic 428	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   368: ldc2_w 905
    //   371: ldc2_w 1117
    //   374: lconst_1
    //   375: iconst_0
    //   376: invokevirtual 911	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
    //   379: ldc_w 256
    //   382: new 347	java/lang/StringBuilder
    //   385: dup
    //   386: ldc_w 1120
    //   389: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   392: aload 10
    //   394: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 1122
    //   400: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload 4
    //   405: invokevirtual 931	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   408: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 446	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload 9
    //   419: invokestatic 200	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
    //   422: ifeq +18 -> 440
    //   425: ldc_w 256
    //   428: ldc_w 1093
    //   431: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload 9
    //   436: invokestatic 1096	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   439: pop
    //   440: aload_2
    //   441: ifnull +7 -> 448
    //   444: aload_2
    //   445: invokevirtual 1097	java/io/OutputStream:close	()V
    //   448: ldc2_w 1059
    //   451: sipush 26232
    //   454: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   457: aconst_null
    //   458: areturn
    //   459: astore_2
    //   460: aconst_null
    //   461: astore 8
    //   463: aload 9
    //   465: invokestatic 200	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
    //   468: ifeq +18 -> 486
    //   471: ldc_w 256
    //   474: ldc_w 1093
    //   477: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload 9
    //   482: invokestatic 1096	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   485: pop
    //   486: aload 8
    //   488: ifnull +8 -> 496
    //   491: aload 8
    //   493: invokevirtual 1097	java/io/OutputStream:close	()V
    //   496: aload_2
    //   497: athrow
    //   498: astore_2
    //   499: goto -256 -> 243
    //   502: astore_2
    //   503: goto -55 -> 448
    //   506: astore 4
    //   508: goto -12 -> 496
    //   511: astore_2
    //   512: goto -49 -> 463
    //   515: astore 4
    //   517: aload_2
    //   518: astore 8
    //   520: aload 4
    //   522: astore_2
    //   523: goto -60 -> 463
    //   526: astore 4
    //   528: aconst_null
    //   529: astore_2
    //   530: goto -165 -> 365
    //   533: iload_3
    //   534: ifeq -254 -> 280
    //   537: sipush 128
    //   540: istore 7
    //   542: goto -391 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	f
    //   0	545	1	paramInt	int
    //   0	545	2	paramArrayOfByte	byte[]
    //   0	545	3	paramBoolean1	boolean
    //   0	545	4	paramCompressFormat	Bitmap.CompressFormat
    //   0	545	5	paramBoolean2	boolean
    //   146	144	6	i	int
    //   282	259	7	j	int
    //   126	393	8	localObject	Object
    //   95	386	9	str1	String
    //   58	335	10	str2	String
    //   72	261	11	str3	String
    //   158	184	12	localDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    // Exception table:
    //   from	to	target	type
    //   128	139	360	java/lang/Exception
    //   151	160	360	java/lang/Exception
    //   165	172	360	java/lang/Exception
    //   176	210	360	java/lang/Exception
    //   287	301	360	java/lang/Exception
    //   304	357	360	java/lang/Exception
    //   121	128	459	finally
    //   238	243	498	java/lang/Exception
    //   444	448	502	java/lang/Exception
    //   491	496	506	java/lang/Exception
    //   128	139	511	finally
    //   151	160	511	finally
    //   165	172	511	finally
    //   176	210	511	finally
    //   287	301	511	finally
    //   304	357	511	finally
    //   365	417	515	finally
    //   121	128	526	java/lang/Exception
  }
  
  public final String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString3, com.tencent.mm.a.b paramb)
  {
    GMTrace.i(3525228625920L, 26265);
    String str = paramString3;
    if (bf.mA(paramString3)) {
      str = com.tencent.mm.a.g.n((paramString1 + System.currentTimeMillis()).getBytes());
    }
    paramString3 = a(str, "", ".jpg", false);
    if (paramb == null) {
      paramString3 = a(str, "", ".jpg", true);
    }
    paramPString1.value = str;
    paramPString2.value = paramString3;
    if ((paramBoolean) && (!bf.mA(paramString2)) && (paramInt == 0))
    {
      paramString2 = z(paramString2, paramInt);
      if (!bf.mA(paramString2.hEH))
      {
        str = m(paramString2.hEH, "", "");
        if (paramb != null) {
          paramb.nV();
        }
        FileOp.p(str, paramString3);
        if (FileOp.kj(str) > 0L)
        {
          if (!bf.mA(paramString2.hER))
          {
            paramString1 = paramString2.hER;
            GMTrace.o(3525228625920L, 26265);
            return paramString1;
          }
          GMTrace.o(3525228625920L, 26265);
          return null;
        }
        v.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString1, paramString3 });
      }
    }
    try
    {
      if (al.isWifi(aa.getContext())) {
        i = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressPicLevelForWifi")).intValue();
      }
      for (;;)
      {
        v.i("MicroMsg.ImgInfoStorage", "CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3025;
        }
        i4 = 70;
        j = 0;
        k = 0;
        i = j;
        try
        {
          if (!al.isWifi(aa.getContext())) {
            break;
          }
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressResolutionForWifi");
          i = j;
          m = paramString2.indexOf("*");
          if (-1 == m) {
            break label3016;
          }
          i = j;
          j = Integer.valueOf(paramString2.substring(0, m)).intValue();
          i = j;
          m = Integer.valueOf(paramString2.substring(m + 1)).intValue();
          i = m;
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            int m;
            j = k;
            continue;
            i = 0;
            j = 0;
          }
        }
        k = i;
        i = j;
        j = k;
        try
        {
          k = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.h.vG();
          paramString2 = new o(com.tencent.mm.kernel.a.uH());
          if ((int)(paramString2.longValue() / 100L) % 100 + 1 > k) {
            break label3010;
          }
          bool1 = true;
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            int i5;
            int i6;
            int i3;
            long l2;
            boolean bool2;
            long l3;
            v.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { bf.g(paramString2) });
            boolean bool1 = false;
            continue;
            i = -1;
            continue;
            j = -1;
            continue;
            k = 8;
            continue;
            int n = m;
            long l1 = l3 - l1;
            m = k;
            k = n;
            paramString2 = com.tencent.mm.sdk.platformtools.d.Pd(paramString3);
            if (paramString2 != null)
            {
              n = paramString2.outWidth;
              if (paramString2 == null) {
                break label2863;
              }
              i1 = paramString2.outHeight;
              l3 = FileOp.kj(paramString3);
              i5 = MMNativeJpeg.queryQuality(paramString3);
              boolean bool3 = MMNativeJpeg.IsJpegFile(paramString3);
              paramString2 = com.tencent.mm.plugin.report.service.g.oSF;
              if (!bool2) {
                break label2869;
              }
              i2 = 1;
              paramString2.i(11713, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i6), Integer.valueOf(i5) });
              v.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i6), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i5), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
              if ((paramInt == 0) && (l3 >= 40960L) && (bool3) && (!MMNativeJpeg.isProgressive(paramString3)))
              {
                paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNUploadImg");
                if ((!bf.mA(paramString2)) && (paramString2.equals("1")))
                {
                  l1 = bf.NA();
                  if (!paramBoolean) {
                    break label2898;
                  }
                  paramString2 = paramString3 + ".prog";
                  FileOp.p(paramString3, paramString2);
                  if ((!bf.mA(paramString2)) && (!bf.mA(paramString3)) && (new File(paramString2).exists())) {
                    break label2875;
                  }
                  bool1 = false;
                  FileOp.deleteFile(paramString2);
                  if (bool1) {
                    break label2931;
                  }
                  m = 29;
                  bool1 = MMNativeJpeg.convertToProgressive(paramString3, i4);
                  long l4 = bf.NA();
                  long l5 = FileOp.kj(paramString3);
                  paramString2 = com.tencent.mm.plugin.report.service.g.oSF;
                  if (!bool1) {
                    break label2914;
                  }
                  i2 = 1;
                  if (!bool2) {
                    break label2920;
                  }
                  i3 = 1;
                  paramString2.i(11713, new Object[] { Integer.valueOf(i2), Long.valueOf(l4 - l1), Integer.valueOf(m), Integer.valueOf(i3), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i6), Integer.valueOf(i5), Long.valueOf(l5) });
                  v.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i6), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i5), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                  if (!bool1)
                  {
                    com.tencent.mm.plugin.report.service.g.oSF.a(111L, 186L, 1L, false);
                    v.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString3 });
                  }
                }
              }
              GMTrace.o(3525228625920L, 26265);
              return null;
              v.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i6), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j) });
              FileOp.p(paramString1, paramString3);
              com.tencent.mm.modelcdntran.g.Em();
              if (c.fA(256)) {
                if (paramInt != 1) {
                  break label2841;
                }
              }
            }
            for (int i2 = 0;; i2 = i3) {
              for (;;)
              {
                try
                {
                  i3 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressMidPicLevel")).intValue();
                  i2 = i3;
                }
                catch (Exception localException2)
                {
                  continue;
                }
                try
                {
                  i3 = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressMidPicSize")).intValue();
                  v.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
                  if (i2 > 10)
                  {
                    i5 = i2;
                    if (i2 <= 100) {}
                  }
                  else
                  {
                    i5 = 52;
                  }
                  if ((i3 > 0) && (i3 <= 800)) {
                    break label2944;
                  }
                  i2 = 800;
                  if (k <= i2) {
                    break label2941;
                  }
                  k = i2;
                  if (m <= i2) {
                    break label2938;
                  }
                  m = i2;
                  bool1 = true;
                  paramBoolean = bool1;
                  if (i6 != 0)
                  {
                    paramBoolean = bool1;
                    if (i6 <= i5) {
                      paramBoolean = false;
                    }
                  }
                  if ((paramBoolean) || (l2 > 800L) || ((paramString2 != null) && ((i1 > i2) || (n > i2))))
                  {
                    paramPString3.value = com.tencent.mm.a.g.n((paramString1 + System.currentTimeMillis()).getBytes());
                    paramPString4.value = a(paramPString3.value, "", ".jpg", false);
                    n = com.tencent.mm.sdk.platformtools.d.a(false, paramString1, m, k, Bitmap.CompressFormat.JPEG, i5, paramPString4.value, paramb);
                    v.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.valueOf(false), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
                    k = n;
                    m = 38;
                    paramBoolean = false;
                    l1 = 0L;
                  }
                }
                catch (Exception localException1)
                {
                  i3 = 0;
                  continue;
                  paramPString3.value = paramPString1.value;
                  paramPString4.value = paramPString2.value;
                  v.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), paramPString3.value, paramPString4.value });
                  l1 = 0L;
                  k = 1;
                  m = 38;
                  paramBoolean = false;
                }
                break;
                v.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
                l1 = 0L;
                k = 1;
                m = 38;
                paramBoolean = false;
                break;
                n = -1;
                break label1455;
                i1 = -1;
                break label1465;
                i2 = 2;
                break label1498;
                if (MMJpegOptim.convertToProgressive(paramString2, paramString3, i4) == 0)
                {
                  bool1 = true;
                  break label1891;
                }
                bool1 = false;
                break label1891;
                m = 9;
                bool1 = MMNativeJpeg.convertToProgressive(paramString3, i4);
                break label1914;
                i2 = -1;
                break label1938;
                i3 = 2;
                break label1946;
                m = 19;
                break label1914;
              }
            }
            m = n;
            continue;
            paramBoolean = bool1;
            continue;
            k = i1;
            int i1 = m;
            m = k;
            continue;
            continue;
            i1 = j;
            n = i;
            continue;
            continue;
            k = i;
            continue;
            continue;
            continue;
            bool1 = false;
          }
        }
        v.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(k), Long.valueOf(paramString2.longValue()), Long.valueOf(paramString2.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIk()), Integer.valueOf(Build.VERSION.SDK_INT) });
        if (com.tencent.mm.sdk.a.b.bIk()) {
          bool1 = true;
        }
        if (!com.tencent.mm.compatible.util.d.ep(16)) {
          break label3007;
        }
        bool1 = false;
        v.i("MicroMsg.ImgInfoStorage", "CompressResolution-width:%d CompressResolution-height:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (i > 0) {
          break label3004;
        }
        i = 960;
        m = j;
        if (j <= 0) {
          m = 960;
        }
        if (i >= m) {
          break label2997;
        }
        k = m;
        m = i;
        j = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        i = j;
        if (j <= 0) {
          i = 100;
        }
        i5 = i * 1024;
        i2 = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((i2 > 0) && (i2 < 100)) {
          break label2994;
        }
        i2 = 10;
        i6 = MMNativeJpeg.queryQuality(paramString1);
        i = 1;
        i3 = i;
        if (i6 != 0)
        {
          i3 = i;
          if (i6 <= i4) {
            i3 = 0;
          }
        }
        v.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[] { paramString1, paramString3, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i5), Integer.valueOf(i2) });
        if (!paramBoolean) {
          break label2271;
        }
        paramString2 = com.tencent.mm.sdk.platformtools.d.Pd(paramString1);
        if (paramString2 == null) {
          break label1401;
        }
        i = paramString2.outWidth;
        if (paramString2 == null) {
          break label1407;
        }
        j = paramString2.outHeight;
        n = 0;
        i1 = 0;
        if (paramString2 != null)
        {
          if (i >= j) {
            break label2983;
          }
          i1 = i;
          n = j;
        }
        l2 = FileOp.kj(paramString1);
        bool2 = MMNativeJpeg.IsJpegFile(paramString1);
        if ((paramInt != 0) || ((i3 == 0) && (l2 <= 204800L) && ((paramString2 == null) || ((i1 <= m) && (n <= k)))) || (l2 <= i5)) {
          break label2282;
        }
        if (i1 >= m) {
          break label2980;
        }
        m = i1;
        i1 = k;
        if (n < k) {
          i1 = n;
        }
        if ((paramString2 == null) || (i >= j)) {
          break label2965;
        }
        if ((i6 >= 55) && (bool2)) {
          break label2958;
        }
        paramBoolean = false;
        if (!paramBoolean) {
          break label1413;
        }
        k = 18;
        l1 = bf.NA();
        n = com.tencent.mm.sdk.platformtools.d.a(paramBoolean, paramString1, i1, m, Bitmap.CompressFormat.JPEG, i4, paramString3, paramb);
        if ((n == 1) || (!paramBoolean)) {
          break label2951;
        }
        k = 28;
        m = com.tencent.mm.sdk.platformtools.d.a(false, paramString1, i1, m, Bitmap.CompressFormat.JPEG, i4, paramString3, paramb);
        paramBoolean = false;
        l3 = FileOp.kj(paramString3);
        v.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(100L * l3 / l2), Integer.valueOf(i2), paramString3 });
        if ((l2 - l3) * 100L < i2 * l2)
        {
          FileOp.p(paramString1, paramString3);
          paramBoolean = false;
          k = 48;
          m = 1;
        }
        l3 = bf.NA();
        if (m == 1) {
          break label1420;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 187L, 1L, false);
        v.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString1 });
        GMTrace.o(3525228625920L, 26265);
        return null;
        if (al.is2G(aa.getContext())) {
          i = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressPicLevelFor2G")).intValue();
        } else {
          i = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressPicLevelFor3G")).intValue();
        }
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i4;
        int j;
        int k;
        int i = 0;
        continue;
        i = j;
        if (al.is2G(aa.getContext()))
        {
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("CompressResolutionFor3G");
          continue;
          label1401:
          label1407:
          label1413:
          label1420:
          label1455:
          label1465:
          label1498:
          label1891:
          label1914:
          label1938:
          label1946:
          label2271:
          label2282:
          label2841:
          label2863:
          label2869:
          label2875:
          label2898:
          label2914:
          label2920:
          label2931:
          label2938:
          label2941:
          label2944:
          label2951:
          label2958:
          label2965:
          label2980:
          label2983:
          label2994:
          label2997:
          label3004:
          label3007:
          label3010:
          label3016:
          label3025:
          i4 = i;
        }
      }
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    GMTrace.i(3519591481344L, 26223);
    if (bf.mA(paramString1))
    {
      GMTrace.o(3519591481344L, 26223);
      return null;
    }
    if (paramString1.startsWith("SERVERID://")) {}
    for (String str1 = paramString1.substring(11);; str1 = "") {
      for (;;)
      {
        try
        {
          str1 = ai(Long.valueOf(str1).longValue()).hEH;
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = com.tencent.mm.plugin.n.b.xb();
            String str4 = com.tencent.mm.plugin.n.b.xc();
            String str2 = str1;
            if (bf.mA(str1)) {
              str2 = paramString1;
            }
            paramString1 = com.tencent.mm.sdk.platformtools.h.a(str3, str4, paramString2, str2, paramString3, 1, paramBoolean);
            GMTrace.o(3519591481344L, 26223);
            return paramString1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString1.getMessage());
          GMTrace.o(3519591481344L, 26223);
          return null;
        }
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat)
  {
    GMTrace.i(3520396787712L, 26229);
    if (bf.bm(paramArrayOfByte))
    {
      v.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      GMTrace.o(3520396787712L, 26229);
      return null;
    }
    String str1 = com.tencent.mm.a.g.n(bf.NA().getBytes());
    String str2 = m(str1, "th_", "");
    v.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[] { str2 });
    try
    {
      com.tencent.mm.sdk.platformtools.d.a(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length), 100, paramCompressFormat, str2, true);
      paramArrayOfByte = "THUMBNAIL_DIRPATH://th_" + str1;
      GMTrace.o(3520396787712L, 26229);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localIOException });
      paramArrayOfByte = a(9, paramArrayOfByte, true, paramCompressFormat);
      GMTrace.o(3520396787712L, 26229);
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localException });
      paramArrayOfByte = a(9, paramArrayOfByte, true, paramCompressFormat);
      GMTrace.o(3520396787712L, 26229);
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc2_w 1365
    //   3: ldc_w 1367
    //   6: invokestatic 66	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_1
    //   10: invokestatic 1064	com/tencent/mm/sdk/platformtools/bf:bm	([B)Z
    //   13: ifeq +23 -> 36
    //   16: ldc_w 256
    //   19: ldc_w 1066
    //   22: invokestatic 446	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc2_w 1365
    //   28: ldc_w 1367
    //   31: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 347	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   43: invokestatic 1003	com/tencent/mm/sdk/platformtools/bf:NA	()J
    //   46: invokevirtual 713	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokevirtual 226	java/lang/String:getBytes	()[B
    //   55: invokestatic 232	com/tencent/mm/a/g:n	([B)Ljava/lang/String;
    //   58: astore 10
    //   60: aload_0
    //   61: aload 10
    //   63: ldc_w 407
    //   66: ldc_w 409
    //   69: invokevirtual 416	com/tencent/mm/ah/f:m	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 11
    //   74: new 347	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   81: aload 11
    //   83: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 1068
    //   89: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 9
    //   97: ldc_w 256
    //   100: new 347	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 1070
    //   107: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload 11
    //   112: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aconst_null
    //   122: astore 5
    //   124: aload 9
    //   126: invokestatic 1074	com/tencent/mm/modelsfs/FileOp:gQ	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   129: astore 6
    //   131: aload 6
    //   133: astore 5
    //   135: aload 5
    //   137: astore 6
    //   139: aload 5
    //   141: aload_1
    //   142: invokevirtual 1079	java/io/OutputStream:write	([B)V
    //   145: aload 5
    //   147: astore 6
    //   149: aload 5
    //   151: invokevirtual 1082	java/io/OutputStream:flush	()V
    //   154: aload 5
    //   156: astore 6
    //   158: new 1084	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   161: dup
    //   162: invokespecial 1085	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   165: astore 7
    //   167: aload 5
    //   169: astore 6
    //   171: aload 9
    //   173: iload 4
    //   175: iload_3
    //   176: iconst_0
    //   177: aload 7
    //   179: iconst_0
    //   180: invokestatic 1100	com/tencent/mm/sdk/platformtools/d:a	(Ljava/lang/String;IIZLcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)Landroid/graphics/Bitmap;
    //   183: astore 12
    //   185: aload 12
    //   187: ifnull +379 -> 566
    //   190: aload 5
    //   192: astore 6
    //   194: aload_1
    //   195: arraylength
    //   196: istore_3
    //   197: iload_3
    //   198: ldc_w 1368
    //   201: if_icmple +643 -> 844
    //   204: aconst_null
    //   205: astore 8
    //   207: new 1370	java/io/ByteArrayOutputStream
    //   210: dup
    //   211: invokespecial 1371	java/io/ByteArrayOutputStream:<init>	()V
    //   214: astore 7
    //   216: aload 7
    //   218: astore 6
    //   220: aload 12
    //   222: aload_2
    //   223: bipush 100
    //   225: aload 7
    //   227: invokevirtual 1375	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   230: pop
    //   231: bipush 100
    //   233: istore_3
    //   234: iload_3
    //   235: istore 4
    //   237: aload 7
    //   239: astore 6
    //   241: aload 7
    //   243: invokevirtual 1378	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   246: arraylength
    //   247: ldc_w 1368
    //   250: if_icmple +196 -> 446
    //   253: iload_3
    //   254: bipush 15
    //   256: if_icmplt +190 -> 446
    //   259: iload_3
    //   260: istore 4
    //   262: aload 7
    //   264: astore 6
    //   266: aload 7
    //   268: invokevirtual 1381	java/io/ByteArrayOutputStream:reset	()V
    //   271: iload_3
    //   272: iconst_5
    //   273: isub
    //   274: istore_3
    //   275: iload_3
    //   276: istore 4
    //   278: aload 7
    //   280: astore 6
    //   282: aload 12
    //   284: aload_2
    //   285: iload_3
    //   286: aload 7
    //   288: invokevirtual 1375	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   291: pop
    //   292: goto -58 -> 234
    //   295: astore 6
    //   297: iload 4
    //   299: istore_3
    //   300: aload 7
    //   302: astore 6
    //   304: ldc_w 256
    //   307: ldc_w 1383
    //   310: invokestatic 446	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: iload_3
    //   314: istore 4
    //   316: aload 7
    //   318: ifnull +15 -> 333
    //   321: aload 5
    //   323: astore 6
    //   325: aload 7
    //   327: invokevirtual 1384	java/io/ByteArrayOutputStream:close	()V
    //   330: iload_3
    //   331: istore 4
    //   333: aload 5
    //   335: astore 6
    //   337: aload 12
    //   339: iload 4
    //   341: aload_2
    //   342: aload 11
    //   344: iconst_1
    //   345: invokestatic 842	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   348: aload 5
    //   350: astore 6
    //   352: ldc_w 256
    //   355: ldc_w 1386
    //   358: iconst_3
    //   359: anewarray 260	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: aload 9
    //   366: aastore
    //   367: dup
    //   368: iconst_1
    //   369: aload 11
    //   371: aastore
    //   372: dup
    //   373: iconst_2
    //   374: iload 4
    //   376: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: invokestatic 715	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: aload 9
    //   385: invokestatic 200	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
    //   388: ifeq +18 -> 406
    //   391: ldc_w 256
    //   394: ldc_w 1093
    //   397: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload 9
    //   402: invokestatic 1096	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   405: pop
    //   406: aload 5
    //   408: ifnull +8 -> 416
    //   411: aload 5
    //   413: invokevirtual 1097	java/io/OutputStream:close	()V
    //   416: new 347	java/lang/StringBuilder
    //   419: dup
    //   420: ldc_w 405
    //   423: invokespecial 394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   426: aload 10
    //   428: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: astore_1
    //   435: ldc2_w 1365
    //   438: ldc_w 1367
    //   441: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   444: aload_1
    //   445: areturn
    //   446: aload 5
    //   448: astore 6
    //   450: aload 7
    //   452: invokevirtual 1384	java/io/ByteArrayOutputStream:close	()V
    //   455: iload_3
    //   456: istore 4
    //   458: goto -125 -> 333
    //   461: astore 6
    //   463: iload_3
    //   464: istore 4
    //   466: goto -133 -> 333
    //   469: astore 7
    //   471: aload 8
    //   473: ifnull +12 -> 485
    //   476: aload 5
    //   478: astore 6
    //   480: aload 8
    //   482: invokevirtual 1384	java/io/ByteArrayOutputStream:close	()V
    //   485: aload 5
    //   487: astore 6
    //   489: aload 7
    //   491: athrow
    //   492: astore 6
    //   494: ldc_w 256
    //   497: ldc_w 1361
    //   500: iconst_1
    //   501: anewarray 260	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: aload 6
    //   508: aastore
    //   509: invokestatic 270	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   512: aload_0
    //   513: bipush 6
    //   515: aload_1
    //   516: iconst_1
    //   517: aload_2
    //   518: invokevirtual 1363	com/tencent/mm/ah/f:a	(I[BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   521: astore_1
    //   522: aload 9
    //   524: invokestatic 200	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
    //   527: ifeq +18 -> 545
    //   530: ldc_w 256
    //   533: ldc_w 1093
    //   536: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload 9
    //   541: invokestatic 1096	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   544: pop
    //   545: aload 5
    //   547: ifnull +8 -> 555
    //   550: aload 5
    //   552: invokevirtual 1097	java/io/OutputStream:close	()V
    //   555: ldc2_w 1365
    //   558: ldc_w 1367
    //   561: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   564: aload_1
    //   565: areturn
    //   566: aload 5
    //   568: astore 6
    //   570: aload 7
    //   572: invokevirtual 1103	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   575: sipush 2000
    //   578: if_icmplt -195 -> 383
    //   581: aload 5
    //   583: astore 6
    //   585: ldc_w 256
    //   588: ldc_w 1105
    //   591: iconst_2
    //   592: anewarray 260	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: aload 9
    //   599: aastore
    //   600: dup
    //   601: iconst_1
    //   602: aload 11
    //   604: aastore
    //   605: invokestatic 1107	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   608: aload 5
    //   610: astore 6
    //   612: aload 9
    //   614: bipush 6
    //   616: aload 7
    //   618: invokestatic 1113	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   621: astore 7
    //   623: aload 5
    //   625: astore 6
    //   627: getstatic 428	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   630: sipush 12712
    //   633: aload 7
    //   635: invokevirtual 1116	com/tencent/mm/plugin/report/service/g:A	(ILjava/lang/String;)V
    //   638: goto -255 -> 383
    //   641: astore 7
    //   643: aload 5
    //   645: astore 6
    //   647: ldc_w 256
    //   650: ldc_w 1361
    //   653: iconst_1
    //   654: anewarray 260	java/lang/Object
    //   657: dup
    //   658: iconst_0
    //   659: aload 7
    //   661: aastore
    //   662: invokestatic 270	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   665: aload 5
    //   667: astore 6
    //   669: aload_0
    //   670: bipush 6
    //   672: aload_1
    //   673: iconst_1
    //   674: aload_2
    //   675: invokevirtual 1363	com/tencent/mm/ah/f:a	(I[BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   678: astore_1
    //   679: aload 9
    //   681: invokestatic 200	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
    //   684: ifeq +18 -> 702
    //   687: ldc_w 256
    //   690: ldc_w 1093
    //   693: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: aload 9
    //   698: invokestatic 1096	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   701: pop
    //   702: aload 5
    //   704: ifnull +8 -> 712
    //   707: aload 5
    //   709: invokevirtual 1097	java/io/OutputStream:close	()V
    //   712: ldc2_w 1365
    //   715: ldc_w 1367
    //   718: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   721: aload_1
    //   722: areturn
    //   723: astore_1
    //   724: aconst_null
    //   725: astore 6
    //   727: aload 9
    //   729: invokestatic 200	com/tencent/mm/modelsfs/FileOp:aO	(Ljava/lang/String;)Z
    //   732: ifeq +18 -> 750
    //   735: ldc_w 256
    //   738: ldc_w 1093
    //   741: invokestatic 401	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: aload 9
    //   746: invokestatic 1096	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   749: pop
    //   750: aload 6
    //   752: ifnull +8 -> 760
    //   755: aload 6
    //   757: invokevirtual 1097	java/io/OutputStream:close	()V
    //   760: aload_1
    //   761: athrow
    //   762: astore 6
    //   764: iload_3
    //   765: istore 4
    //   767: goto -434 -> 333
    //   770: astore 6
    //   772: goto -287 -> 485
    //   775: astore_1
    //   776: goto -360 -> 416
    //   779: astore_2
    //   780: goto -225 -> 555
    //   783: astore_2
    //   784: goto -72 -> 712
    //   787: astore_2
    //   788: goto -28 -> 760
    //   791: astore_1
    //   792: goto -65 -> 727
    //   795: astore_1
    //   796: aload 5
    //   798: astore 6
    //   800: goto -73 -> 727
    //   803: astore 7
    //   805: aconst_null
    //   806: astore 5
    //   808: goto -165 -> 643
    //   811: astore 6
    //   813: goto -319 -> 494
    //   816: astore 7
    //   818: aload 6
    //   820: astore 8
    //   822: goto -351 -> 471
    //   825: astore 6
    //   827: aconst_null
    //   828: astore 7
    //   830: bipush 100
    //   832: istore_3
    //   833: goto -533 -> 300
    //   836: astore 6
    //   838: bipush 100
    //   840: istore_3
    //   841: goto -541 -> 300
    //   844: bipush 100
    //   846: istore 4
    //   848: goto -515 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	851	0	this	f
    //   0	851	1	paramArrayOfByte	byte[]
    //   0	851	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	851	3	paramInt1	int
    //   0	851	4	paramInt2	int
    //   122	685	5	localObject1	Object
    //   129	152	6	localObject2	Object
    //   295	1	6	localException1	Exception
    //   302	147	6	localObject3	Object
    //   461	1	6	localException2	Exception
    //   478	10	6	localObject4	Object
    //   492	15	6	localIOException1	IOException
    //   568	188	6	localObject5	Object
    //   762	1	6	localException3	Exception
    //   770	1	6	localException4	Exception
    //   798	1	6	localObject6	Object
    //   811	8	6	localIOException2	IOException
    //   825	1	6	localException5	Exception
    //   836	1	6	localException6	Exception
    //   165	286	7	localObject7	Object
    //   469	148	7	localDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    //   621	13	7	str1	String
    //   641	19	7	localException7	Exception
    //   803	1	7	localException8	Exception
    //   816	1	7	localObject8	Object
    //   828	1	7	localObject9	Object
    //   205	616	8	localIOException3	IOException
    //   95	650	9	str2	String
    //   58	369	10	str3	String
    //   72	531	11	str4	String
    //   183	155	12	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   241	253	295	java/lang/Exception
    //   266	271	295	java/lang/Exception
    //   282	292	295	java/lang/Exception
    //   450	455	461	java/lang/Exception
    //   207	216	469	finally
    //   139	145	492	java/io/IOException
    //   149	154	492	java/io/IOException
    //   158	167	492	java/io/IOException
    //   171	185	492	java/io/IOException
    //   194	197	492	java/io/IOException
    //   325	330	492	java/io/IOException
    //   337	348	492	java/io/IOException
    //   352	383	492	java/io/IOException
    //   450	455	492	java/io/IOException
    //   480	485	492	java/io/IOException
    //   489	492	492	java/io/IOException
    //   570	581	492	java/io/IOException
    //   585	608	492	java/io/IOException
    //   612	623	492	java/io/IOException
    //   627	638	492	java/io/IOException
    //   139	145	641	java/lang/Exception
    //   149	154	641	java/lang/Exception
    //   158	167	641	java/lang/Exception
    //   171	185	641	java/lang/Exception
    //   194	197	641	java/lang/Exception
    //   337	348	641	java/lang/Exception
    //   352	383	641	java/lang/Exception
    //   489	492	641	java/lang/Exception
    //   570	581	641	java/lang/Exception
    //   585	608	641	java/lang/Exception
    //   612	623	641	java/lang/Exception
    //   627	638	641	java/lang/Exception
    //   124	131	723	finally
    //   325	330	762	java/lang/Exception
    //   480	485	770	java/lang/Exception
    //   411	416	775	java/lang/Exception
    //   550	555	779	java/lang/Exception
    //   707	712	783	java/lang/Exception
    //   755	760	787	java/lang/Exception
    //   139	145	791	finally
    //   149	154	791	finally
    //   158	167	791	finally
    //   171	185	791	finally
    //   194	197	791	finally
    //   325	330	791	finally
    //   337	348	791	finally
    //   352	383	791	finally
    //   450	455	791	finally
    //   480	485	791	finally
    //   489	492	791	finally
    //   570	581	791	finally
    //   585	608	791	finally
    //   612	623	791	finally
    //   627	638	791	finally
    //   647	665	791	finally
    //   669	679	791	finally
    //   494	522	795	finally
    //   124	131	803	java/lang/Exception
    //   124	131	811	java/io/IOException
    //   220	231	816	finally
    //   241	253	816	finally
    //   266	271	816	finally
    //   282	292	816	finally
    //   304	313	816	finally
    //   207	216	825	java/lang/Exception
    //   220	231	836	java/lang/Exception
  }
  
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    GMTrace.i(3520262569984L, 26228);
    paramArrayOfByte = a(8, paramArrayOfByte, paramBoolean, paramCompressFormat);
    GMTrace.o(3520262569984L, 26228);
    return paramArrayOfByte;
  }
  
  public final HashMap<Long, d> a(Long... paramVarArgs)
  {
    GMTrace.i(3523349577728L, 26251);
    int i = 1;
    int k = paramVarArgs.length;
    Object localObject1 = "(";
    int j = 0;
    Object localObject2;
    if (j < k)
    {
      long l = paramVarArgs[j].longValue();
      localObject2 = new StringBuilder().append((String)localObject1);
      if (i != 0) {}
      for (localObject1 = Long.valueOf(l);; localObject1 = "," + l)
      {
        localObject1 = localObject1;
        j += 1;
        i = 0;
        break;
      }
    }
    paramVarArgs = (String)localObject1 + ")";
    paramVarArgs = a("ImgInfo2", null, "msgSvrId in " + paramVarArgs, null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new d();
      ((d)localObject2).b(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((d)localObject2).fTG), localObject2);
    }
    paramVarArgs.close();
    GMTrace.o(3523349577728L, 26251);
    return (HashMap<Long, d>)localObject1;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, View paramView)
  {
    GMTrace.i(14619800240128L, 108926);
    boolean bool = a(paramImageView1, paramString, false, paramFloat, paramInt1, paramInt2, true, paramInt3, paramImageView2, paramInt4, paramInt5, true, paramView);
    GMTrace.o(14619800240128L, 108926);
    return bool;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, boolean paramBoolean3, View paramView)
  {
    GMTrace.i(14619934457856L, 108927);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      GMTrace.o(14619934457856L, 108927);
      return false;
    }
    for (;;)
    {
      synchronized (this.hFu)
      {
        paramBoolean2 = this.hFu.containsKey(paramString);
        String str = b(paramString, paramBoolean1, false);
        if (bf.mA(str))
        {
          v.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { bf.mz(paramString) });
          GMTrace.o(14619934457856L, 108927);
          return false;
        }
        localObject = str;
        if (!paramBoolean2)
        {
          localObject = str;
          if (!str.endsWith("hd"))
          {
            localObject = str;
            if (FileOp.aO(str + "hd"))
            {
              this.hFu.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1148;
        }
        paramString = (Bitmap)this.hFn.get(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, true, paramInt3);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1145;
          }
          paramString = (Bitmap)this.hFn.get(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label667;
          }
          v.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label600;
          }
          localObject = this.hFw;
          if (paramInt5 != 0) {
            break label612;
          }
          ((FrameLayout.LayoutParams)localObject).gravity = 5;
          paramImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramString.getWidth() < paramString.getHeight() * 2.5D) {
            break label627;
          }
          paramInt1 = 1;
          if (paramString.getHeight() < paramString.getWidth() * 2.5D) {
            break label633;
          }
          paramInt2 = 1;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            paramImageView1.setScaleType(ImageView.ScaleType.CENTER);
          }
          if (paramImageView2 != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt5 != 0) {
              break label639;
            }
            paramImageView1.gravity = 5;
            paramImageView2.setLayoutParams(paramImageView1);
          }
          if (paramView != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt5 != 0) {
              break label653;
            }
            paramImageView1.gravity = 5;
            paramView.setLayoutParams(paramImageView1);
          }
          GMTrace.o(14619934457856L, 108927);
          return true;
        }
      }
      if (this.hFn.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
        v.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: " + (String)localObject);
      }
      int i = 0;
      continue;
      label600:
      Object localObject = (FrameLayout.LayoutParams)paramImageView1.getLayoutParams();
      continue;
      label612:
      if (paramInt5 == 1)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
        continue;
        label627:
        paramInt1 = 0;
        continue;
        label633:
        paramInt2 = 0;
        continue;
        label639:
        if (paramInt5 == 1)
        {
          paramImageView1.gravity = 3;
          continue;
          label653:
          if (paramInt5 == 1)
          {
            paramImageView1.gravity = 3;
            continue;
            label667:
            float f;
            if (paramInt4 > 0)
            {
              paramImageView1.setBackgroundResource(paramInt4);
              paramImageView1.setImageDrawable(null);
              if ((paramInt1 >= 160) || (paramInt2 >= 160)) {
                if (paramInt2 > paramInt1)
                {
                  f = 160.0F / paramInt2;
                  paramInt1 = (int)(paramInt1 * f);
                  paramInt2 = (int)(f * paramInt2);
                  if (paramInt1 <= 0) {
                    break label941;
                  }
                  label738:
                  paramInt4 = (int)(paramInt1 * paramFloat);
                  if (paramInt2 <= 0) {
                    break label948;
                  }
                  paramInt1 = paramInt2;
                  label756:
                  paramInt1 = (int)(paramInt1 * paramFloat);
                  paramInt2 = paramInt4;
                  if (paramInt2 >= 60.0F * paramFloat) {
                    break label1142;
                  }
                  v.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(paramInt2) });
                  paramInt2 = (int)(60.0F * paramFloat);
                }
              }
            }
            label881:
            label941:
            label948:
            label960:
            label1005:
            label1083:
            label1132:
            label1139:
            label1142:
            for (;;)
            {
              paramInt4 = paramInt1;
              if (paramInt1 < 60.0F * paramFloat)
              {
                v.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(paramInt1) });
                paramInt4 = (int)(60.0F * paramFloat);
              }
              paramString = new FrameLayout.LayoutParams(paramInt2, paramInt4);
              if (paramInt5 == 0)
              {
                paramString.gravity = 5;
                if (paramView == null) {
                  break label1139;
                }
                paramView.setLayoutParams(paramString);
              }
              for (;;)
              {
                paramImageView1.setLayoutParams(paramString);
                if (i == 0) {
                  a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, true, paramInt3);
                }
                GMTrace.o(14619934457856L, 108927);
                return false;
                f = 160.0F / paramInt1;
                break;
                paramInt1 = 120;
                break label738;
                paramInt1 = 75;
                break label756;
                if (paramInt1 > 0)
                {
                  paramInt4 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label1005;
                  }
                }
                for (;;)
                {
                  paramInt1 = (int)(paramInt2 * paramFloat * 1.25F);
                  paramInt2 = paramInt4;
                  break;
                  paramInt1 = 120;
                  break label960;
                  paramInt2 = 75;
                }
                if (paramInt5 != 1) {
                  break label881;
                }
                paramString.gravity = 3;
                break label881;
                if ((this.hFx == null) || (this.hFx.get() == null)) {
                  this.hFx = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.hFx.get());
                if (paramInt1 > 0)
                {
                  paramInt1 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label1132;
                  }
                }
                for (;;)
                {
                  paramString = new FrameLayout.LayoutParams(paramInt1, (int)(paramInt2 * paramFloat * 1.25F));
                  break;
                  paramInt1 = 120;
                  break label1083;
                  paramInt2 = 75;
                }
              }
            }
            label1145:
            continue;
            label1148:
            i = 0;
            paramString = null;
          }
        }
      }
    }
  }
  
  /* Error */
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc2_w 1496
    //   3: sipush 26272
    //   6: invokestatic 66	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc_w 256
    //   12: ldc_w 1499
    //   15: iconst_5
    //   16: anewarray 260	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_2
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: iload_3
    //   30: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: aastore
    //   34: dup
    //   35: iconst_3
    //   36: iload 4
    //   38: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: dup
    //   43: iconst_4
    //   44: invokestatic 947	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   47: aastore
    //   48: invokestatic 715	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   54: lstore 10
    //   56: invokestatic 1015	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   59: invokestatic 1503	com/tencent/mm/bg/a:getDensity	(Landroid/content/Context;)F
    //   62: fstore 5
    //   64: aload_1
    //   65: invokestatic 193	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   68: ifne +10 -> 78
    //   71: aload_2
    //   72: invokestatic 193	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   75: ifeq +14 -> 89
    //   78: ldc2_w 1496
    //   81: sipush 26272
    //   84: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   87: iconst_0
    //   88: ireturn
    //   89: aload_0
    //   90: aload_2
    //   91: iconst_0
    //   92: iconst_1
    //   93: invokevirtual 995	com/tencent/mm/ah/f:b	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   96: astore 14
    //   98: aload 14
    //   100: invokestatic 193	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   103: ifeq +14 -> 117
    //   106: ldc2_w 1496
    //   109: sipush 26272
    //   112: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 14
    //   119: ldc_w 951
    //   122: invokevirtual 954	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   125: ifne +91 -> 216
    //   128: new 347	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   135: aload 14
    //   137: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 951
    //   143: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 13
    //   151: aload 14
    //   153: invokestatic 1223	com/tencent/mm/sdk/platformtools/d:Pd	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   156: astore 16
    //   158: aload 16
    //   160: ifnull +23 -> 183
    //   163: aload 16
    //   165: getfield 1228	android/graphics/BitmapFactory$Options:outWidth	I
    //   168: ifle +15 -> 183
    //   171: aload 16
    //   173: astore 15
    //   175: aload 16
    //   177: getfield 1231	android/graphics/BitmapFactory$Options:outHeight	I
    //   180: ifgt +130 -> 310
    //   183: getstatic 428	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   186: ldc2_w 905
    //   189: ldc2_w 1504
    //   192: lconst_1
    //   193: iconst_0
    //   194: invokevirtual 911	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
    //   197: aload 14
    //   199: invokestatic 1510	com/tencent/mm/a/e:aN	(Ljava/lang/String;)I
    //   202: ifle +40 -> 242
    //   205: ldc2_w 1496
    //   208: sipush 26272
    //   211: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   214: iconst_0
    //   215: ireturn
    //   216: aload 14
    //   218: iconst_0
    //   219: aload 14
    //   221: invokevirtual 696	java/lang/String:length	()I
    //   224: iconst_2
    //   225: isub
    //   226: invokevirtual 969	java/lang/String:substring	(II)Ljava/lang/String;
    //   229: astore 15
    //   231: aload 14
    //   233: astore 13
    //   235: aload 15
    //   237: astore 14
    //   239: goto -88 -> 151
    //   242: new 1225	android/graphics/BitmapFactory$Options
    //   245: dup
    //   246: invokespecial 1511	android/graphics/BitmapFactory$Options:<init>	()V
    //   249: astore 15
    //   251: aload 15
    //   253: invokestatic 1514	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/BitmapFactory$Options;)V
    //   256: ldc_w 256
    //   259: ldc_w 1516
    //   262: iconst_3
    //   263: anewarray 260	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload 15
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: aload 15
    //   275: getfield 1228	android/graphics/BitmapFactory$Options:outWidth	I
    //   278: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: aload 15
    //   286: getfield 1231	android/graphics/BitmapFactory$Options:outHeight	I
    //   289: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   292: aastore
    //   293: invokestatic 265	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: getstatic 428	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   299: ldc2_w 905
    //   302: ldc2_w 1517
    //   305: lconst_1
    //   306: iconst_0
    //   307: invokevirtual 911	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
    //   310: aload 15
    //   312: getfield 1228	android/graphics/BitmapFactory$Options:outWidth	I
    //   315: i2f
    //   316: fload 5
    //   318: fmul
    //   319: ldc_w 1027
    //   322: fmul
    //   323: f2i
    //   324: istore 9
    //   326: aload 15
    //   328: getfield 1231	android/graphics/BitmapFactory$Options:outHeight	I
    //   331: i2f
    //   332: fload 5
    //   334: fmul
    //   335: ldc_w 1027
    //   338: fmul
    //   339: f2i
    //   340: istore 8
    //   342: iload 9
    //   344: i2f
    //   345: ldc_w 1028
    //   348: fload 5
    //   350: fmul
    //   351: fcmpl
    //   352: ifge +16 -> 368
    //   355: iload 8
    //   357: i2f
    //   358: ldc_w 1028
    //   361: fload 5
    //   363: fmul
    //   364: fcmpl
    //   365: iflt +359 -> 724
    //   368: iload 8
    //   370: iload 9
    //   372: if_icmple +237 -> 609
    //   375: ldc_w 1028
    //   378: fload 5
    //   380: fmul
    //   381: iload 8
    //   383: i2f
    //   384: fdiv
    //   385: fstore 5
    //   387: iload 9
    //   389: i2f
    //   390: fload 5
    //   392: fmul
    //   393: f2i
    //   394: istore 7
    //   396: fload 5
    //   398: iload 8
    //   400: i2f
    //   401: fmul
    //   402: f2i
    //   403: istore 6
    //   405: iload 7
    //   407: iload 9
    //   409: invokestatic 1524	java/lang/Math:max	(II)I
    //   412: istore 7
    //   414: iload 6
    //   416: iload 8
    //   418: invokestatic 1524	java/lang/Math:max	(II)I
    //   421: istore 6
    //   423: iload 4
    //   425: ifne +199 -> 624
    //   428: aload_1
    //   429: iload 6
    //   431: iload 7
    //   433: getstatic 839	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   436: aload 13
    //   438: new 787	com/tencent/mm/pointers/PInt
    //   441: dup
    //   442: invokespecial 788	com/tencent/mm/pointers/PInt:<init>	()V
    //   445: new 787	com/tencent/mm/pointers/PInt
    //   448: dup
    //   449: invokespecial 788	com/tencent/mm/pointers/PInt:<init>	()V
    //   452: invokestatic 1527	com/tencent/mm/sdk/platformtools/d:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   455: istore 12
    //   457: ldc_w 256
    //   460: ldc_w 1529
    //   463: iconst_4
    //   464: anewarray 260	java/lang/Object
    //   467: dup
    //   468: iconst_0
    //   469: new 347	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 348	java/lang/StringBuilder:<init>	()V
    //   476: invokestatic 212	java/lang/System:currentTimeMillis	()J
    //   479: lload 10
    //   481: lsub
    //   482: invokevirtual 713	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   485: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: aastore
    //   489: dup
    //   490: iconst_1
    //   491: iload 6
    //   493: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aastore
    //   497: dup
    //   498: iconst_2
    //   499: iload 7
    //   501: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   504: aastore
    //   505: dup
    //   506: iconst_3
    //   507: iload 12
    //   509: invokestatic 943	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   512: aastore
    //   513: invokestatic 715	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   516: aload_0
    //   517: aload 14
    //   519: iconst_1
    //   520: invokestatic 1015	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   523: invokestatic 1503	com/tencent/mm/bg/a:getDensity	(Landroid/content/Context;)F
    //   526: iconst_1
    //   527: iconst_0
    //   528: iconst_1
    //   529: iload_3
    //   530: iconst_0
    //   531: invokespecial 988	com/tencent/mm/ah/f:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   534: pop
    //   535: iload 12
    //   537: ifeq +170 -> 707
    //   540: aload_0
    //   541: getfield 149	com/tencent/mm/ah/f:hFu	Ljava/util/Map;
    //   544: astore_1
    //   545: aload_1
    //   546: monitorenter
    //   547: aload_0
    //   548: getfield 149	com/tencent/mm/ah/f:hFu	Ljava/util/Map;
    //   551: aload_2
    //   552: invokeinterface 1423 2 0
    //   557: ifeq +38 -> 595
    //   560: aload_0
    //   561: getfield 149	com/tencent/mm/ah/f:hFu	Ljava/util/Map;
    //   564: aload_2
    //   565: invokeinterface 1530 2 0
    //   570: checkcast 68	java/lang/String
    //   573: ldc_w 951
    //   576: invokevirtual 954	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   579: ifne +16 -> 595
    //   582: aload_0
    //   583: getfield 149	com/tencent/mm/ah/f:hFu	Ljava/util/Map;
    //   586: aload_2
    //   587: aload 13
    //   589: invokeinterface 511 3 0
    //   594: pop
    //   595: aload_1
    //   596: monitorexit
    //   597: ldc2_w 1496
    //   600: sipush 26272
    //   603: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   606: iload 12
    //   608: ireturn
    //   609: ldc_w 1028
    //   612: fload 5
    //   614: fmul
    //   615: iload 9
    //   617: i2f
    //   618: fdiv
    //   619: fstore 5
    //   621: goto -234 -> 387
    //   624: aload_1
    //   625: iload 6
    //   627: iload 7
    //   629: getstatic 839	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   632: aload 13
    //   634: new 787	com/tencent/mm/pointers/PInt
    //   637: dup
    //   638: invokespecial 788	com/tencent/mm/pointers/PInt:<init>	()V
    //   641: new 787	com/tencent/mm/pointers/PInt
    //   644: dup
    //   645: invokespecial 788	com/tencent/mm/pointers/PInt:<init>	()V
    //   648: invokestatic 1532	com/tencent/mm/sdk/platformtools/d:b	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   651: istore 12
    //   653: goto -196 -> 457
    //   656: astore_1
    //   657: getstatic 428	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   660: ldc2_w 905
    //   663: ldc2_w 1533
    //   666: lconst_1
    //   667: iconst_0
    //   668: invokevirtual 911	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
    //   671: ldc_w 256
    //   674: ldc_w 1536
    //   677: iconst_1
    //   678: anewarray 260	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: aload_1
    //   684: invokevirtual 1537	java/lang/Exception:toString	()Ljava/lang/String;
    //   687: aastore
    //   688: invokestatic 270	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   691: ldc2_w 1496
    //   694: sipush 26272
    //   697: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   700: iconst_0
    //   701: ireturn
    //   702: astore_2
    //   703: aload_1
    //   704: monitorexit
    //   705: aload_2
    //   706: athrow
    //   707: getstatic 428	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   710: ldc2_w 905
    //   713: ldc2_w 1533
    //   716: lconst_1
    //   717: iconst_0
    //   718: invokevirtual 911	com/tencent/mm/plugin/report/service/g:a	(JJJZ)V
    //   721: goto -124 -> 597
    //   724: iload 8
    //   726: istore 6
    //   728: iload 9
    //   730: istore 7
    //   732: goto -327 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	735	0	this	f
    //   0	735	2	paramString2	String
    //   0	735	3	paramInt1	int
    //   0	735	4	paramInt2	int
    //   62	558	5	f	float
    //   403	324	6	i	int
    //   394	337	7	j	int
    //   340	385	8	k	int
    //   324	405	9	m	int
    //   54	426	10	l	long
    //   455	197	12	bool	boolean
    //   149	484	13	localObject1	Object
    //   96	422	14	localObject2	Object
    //   173	154	15	localObject3	Object
    //   156	20	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   428	457	656	java/lang/Exception
    //   624	653	656	java/lang/Exception
    //   547	595	702	finally
    //   595	597	702	finally
    //   703	705	702	finally
  }
  
  public final d ai(long paramLong)
  {
    GMTrace.i(3523752230912L, 26254);
    d locald = new d();
    Cursor localCursor = a("ImgInfo2", null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      locald.b(localCursor);
    }
    localCursor.close();
    GMTrace.o(3523752230912L, 26254);
    return locald;
  }
  
  public final d aj(long paramLong)
  {
    GMTrace.i(3523886448640L, 26255);
    d locald = new d();
    Cursor localCursor = a("ImgInfo2", null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if ((localCursor != null) && (localCursor.moveToLast())) {
      locald.b(localCursor);
    }
    localCursor.close();
    GMTrace.o(3523886448640L, 26255);
    return locald;
  }
  
  public final d b(Long paramLong)
  {
    GMTrace.i(3522812706816L, 26247);
    d locald = new d();
    paramLong = a("ImgInfo2", null, "id=?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      locald.b(paramLong);
    }
    paramLong.close();
    GMTrace.o(3522812706816L, 26247);
    return locald;
  }
  
  public final String b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(14620068675584L, 108928);
    Object localObject;
    if ((paramString != null) && (this.hFu.containsKey(paramString)))
    {
      localObject = (String)this.hFu.get(paramString);
      GMTrace.o(14620068675584L, 108928);
      return (String)localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = v(paramString, paramBoolean2))
    {
      localObject = str;
      if (bf.mA(str)) {
        break;
      }
      this.hFu.put(paramString, str);
      localObject = str;
      break;
    }
  }
  
  public final HashMap<Long, d> b(Long... paramVarArgs)
  {
    GMTrace.i(3523483795456L, 26252);
    int i = 1;
    int k = paramVarArgs.length;
    Object localObject1 = "(";
    int j = 0;
    Object localObject2;
    if (j < k)
    {
      long l = paramVarArgs[j].longValue();
      localObject2 = new StringBuilder().append((String)localObject1);
      if (i != 0) {}
      for (localObject1 = Long.valueOf(l);; localObject1 = "," + l)
      {
        localObject1 = localObject1;
        j += 1;
        i = 0;
        break;
      }
    }
    paramVarArgs = (String)localObject1 + ")";
    paramVarArgs = a("ImgInfo2", null, "msglocalid in " + paramVarArgs, null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new d();
      ((d)localObject2).b(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((d)localObject2).fTG), localObject2);
    }
    paramVarArgs.close();
    GMTrace.o(3523483795456L, 26252);
    return (HashMap<Long, d>)localObject1;
  }
  
  public final String d(d paramd)
  {
    Object localObject = null;
    GMTrace.i(3523215360000L, 26250);
    if (paramd == null)
    {
      GMTrace.o(3523215360000L, 26250);
      return null;
    }
    if (paramd.GC())
    {
      paramd = paramd.hEQ;
      Cursor localCursor = a("ImgInfo2", new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { paramd });
      paramd = (d)localObject;
      if (localCursor.moveToFirst()) {
        paramd = localCursor.getString(0);
      }
      localCursor.close();
      GMTrace.o(3523215360000L, 26250);
      return paramd;
    }
    GMTrace.o(3523215360000L, 26250);
    return null;
  }
  
  public final String f(int paramInt, byte[] paramArrayOfByte)
  {
    GMTrace.i(3520933658624L, 26233);
    if (bf.bm(paramArrayOfByte))
    {
      v.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      GMTrace.o(3520933658624L, 26233);
      return null;
    }
    Object localObject = new MMBitmapFactory.DecodeResultLogger();
    if (!MMBitmapFactory.checkIsImageLegal(paramArrayOfByte, (MMBitmapFactory.DecodeResultLogger)localObject))
    {
      if (((MMBitmapFactory.DecodeResultLogger)localObject).getDecodeResult() >= 2000)
      {
        v.e("MicroMsg.ImgInfoStorage", "img in thumbBuf hits hole.");
        paramArrayOfByte = MMBitmapFactory.KVStatHelper.getKVStatString(paramArrayOfByte, paramInt, (MMBitmapFactory.DecodeResultLogger)localObject);
        com.tencent.mm.plugin.report.service.g.oSF.A(12712, paramArrayOfByte);
      }
      GMTrace.o(3520933658624L, 26233);
      return null;
    }
    localObject = com.tencent.mm.a.g.n(bf.NA().getBytes());
    String str = m((String)localObject, "th_", "");
    v.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + str);
    FileOp.deleteFile(str);
    FileOp.k(str, paramArrayOfByte);
    paramArrayOfByte = "THUMBNAIL_DIRPATH://th_" + (String)localObject;
    GMTrace.o(3520933658624L, 26233);
    return paramArrayOfByte;
  }
  
  public final d fT(int paramInt)
  {
    GMTrace.i(3523618013184L, 26253);
    d locald = b(Long.valueOf(paramInt));
    GMTrace.o(3523618013184L, 26253);
    return locald;
  }
  
  /* Error */
  public final d fU(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc2_w 1586
    //   8: sipush 26256
    //   11: invokestatic 66	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   14: aload_0
    //   15: ldc_w 578
    //   18: aconst_null
    //   19: ldc_w 1589
    //   22: iconst_1
    //   23: anewarray 68	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: iload_1
    //   29: invokestatic 721	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   32: aastore
    //   33: invokespecial 1405	com/tencent/mm/ah/f:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +156 -> 194
    //   41: aload_2
    //   42: invokeinterface 724 1 0
    //   47: ifeq +147 -> 194
    //   50: new 183	com/tencent/mm/ah/d
    //   53: dup
    //   54: invokespecial 310	com/tencent/mm/ah/d:<init>	()V
    //   57: astore 4
    //   59: aload 4
    //   61: aload_2
    //   62: invokevirtual 727	com/tencent/mm/ah/d:b	(Landroid/database/Cursor;)V
    //   65: aload 4
    //   67: astore_3
    //   68: aload_3
    //   69: astore 4
    //   71: aload_2
    //   72: ifnull +12 -> 84
    //   75: aload_2
    //   76: invokeinterface 555 1 0
    //   81: aload_3
    //   82: astore 4
    //   84: ldc2_w 1586
    //   87: sipush 26256
    //   90: invokestatic 95	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   93: aload 4
    //   95: areturn
    //   96: astore 4
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_3
    //   101: astore 5
    //   103: ldc_w 256
    //   106: ldc_w 1591
    //   109: iconst_1
    //   110: anewarray 260	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload 4
    //   117: invokevirtual 1537	java/lang/Exception:toString	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 1107	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_2
    //   125: astore 4
    //   127: aload_3
    //   128: ifnull -44 -> 84
    //   131: aload_3
    //   132: invokeinterface 555 1 0
    //   137: aload_2
    //   138: astore 4
    //   140: goto -56 -> 84
    //   143: astore_2
    //   144: aload 5
    //   146: ifnull +10 -> 156
    //   149: aload 5
    //   151: invokeinterface 555 1 0
    //   156: aload_2
    //   157: athrow
    //   158: astore_3
    //   159: aload_2
    //   160: astore 5
    //   162: aload_3
    //   163: astore_2
    //   164: goto -20 -> 144
    //   167: astore 4
    //   169: aconst_null
    //   170: astore 5
    //   172: aload_2
    //   173: astore_3
    //   174: aload 5
    //   176: astore_2
    //   177: goto -77 -> 100
    //   180: astore 5
    //   182: aload_2
    //   183: astore_3
    //   184: aload 4
    //   186: astore_2
    //   187: aload 5
    //   189: astore 4
    //   191: goto -91 -> 100
    //   194: aconst_null
    //   195: astore_3
    //   196: goto -128 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	f
    //   0	199	1	paramInt	int
    //   36	102	2	localCursor1	Cursor
    //   143	17	2	localObject1	Object
    //   163	24	2	localObject2	Object
    //   4	128	3	localObject3	Object
    //   158	5	3	localObject4	Object
    //   173	23	3	localObject5	Object
    //   57	37	4	localObject6	Object
    //   96	20	4	localException1	Exception
    //   125	14	4	localCursor2	Cursor
    //   167	18	4	localException2	Exception
    //   189	1	4	localException3	Exception
    //   1	174	5	localObject7	Object
    //   180	8	5	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   14	37	96	java/lang/Exception
    //   14	37	143	finally
    //   103	124	143	finally
    //   41	59	158	finally
    //   59	65	158	finally
    //   41	59	167	java/lang/Exception
    //   59	65	180	java/lang/Exception
  }
  
  public final String jt(String paramString)
  {
    GMTrace.i(3519859916800L, 26225);
    if (bf.mA(paramString))
    {
      GMTrace.o(3519859916800L, 26225);
      return null;
    }
    String str1 = "";
    if (paramString.startsWith("SERVERID://")) {
      str1 = paramString.substring(11);
    }
    for (;;)
    {
      try
      {
        str1 = ai(Long.valueOf(str1).longValue()).hEH;
        String str2 = com.tencent.mm.plugin.n.b.xb();
        String str3 = com.tencent.mm.plugin.n.b.xc();
        if (bf.mA(str1))
        {
          paramString = com.tencent.mm.sdk.platformtools.h.f(str2, str3, "th_", paramString, "");
          GMTrace.o(3519859916800L, 26225);
          return paramString;
        }
      }
      catch (NumberFormatException paramString)
      {
        v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        GMTrace.o(3519859916800L, 26225);
        return null;
      }
      paramString = str1;
    }
  }
  
  public final String jv(String paramString)
  {
    GMTrace.i(3520128352256L, 26227);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(3520128352256L, 26227);
      return null;
    }
    String str1 = "";
    String str2 = paramString.trim();
    if (str2.startsWith("THUMBNAIL://")) {
      paramString = str2.substring(12);
    }
    for (;;)
    {
      try
      {
        paramString = fT(Integer.valueOf(paramString).intValue()).hEJ;
        paramString = m(paramString, str1, "");
        GMTrace.o(3520128352256L, 26227);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        GMTrace.o(3520128352256L, 26227);
        return null;
      }
      paramString = str2;
      if (str2.startsWith("THUMBNAIL_DIRPATH://"))
      {
        paramString = str2.substring(23);
        str1 = "th_";
      }
    }
  }
  
  public final String jw(String paramString)
  {
    GMTrace.i(15342965358592L, 114314);
    paramString = b(paramString, false, true);
    GMTrace.o(15342965358592L, 114314);
    return paramString;
  }
  
  public final String m(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(3519725699072L, 26224);
    paramString1 = a(paramString1, paramString2, paramString3, true);
    GMTrace.o(3519725699072L, 26224);
    return paramString1;
  }
  
  public final d n(au paramau)
  {
    GMTrace.i(3522678489088L, 26246);
    d locald = aj(paramau.field_msgId);
    Object localObject = locald;
    if (locald.hEG == 0L)
    {
      paramau = ai(paramau.field_msgSvrId);
      localObject = paramau;
      if (paramau.hEG == 0L)
      {
        v.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        GMTrace.o(3522678489088L, 26246);
        return null;
      }
    }
    GMTrace.o(3522678489088L, 26246);
    return (d)localObject;
  }
  
  public final void o(au paramau)
  {
    GMTrace.i(3523081142272L, 26249);
    paramau = n(paramau);
    if ((paramau == null) || (paramau.hEG == 0L))
    {
      v.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      GMTrace.o(3523081142272L, 26249);
      return;
    }
    FileOp.deleteFile(m(paramau.hEH, "", ""));
    FileOp.deleteFile(m(paramau.hEJ, "", ""));
    FileOp.deleteFile(m(paramau.hEJ, "", "") + "hd");
    this.hnp.delete("ImgInfo2", "id=?", new String[] { paramau.hEG });
    if (paramau.GC())
    {
      paramau = fT(paramau.hEQ);
      if (paramau == null)
      {
        GMTrace.o(3523081142272L, 26249);
        return;
      }
      FileOp.deleteFile(m(paramau.hEH, "", ""));
      FileOp.deleteFile(m(paramau.hEJ, "", ""));
      FileOp.deleteFile(m(paramau.hEJ, "", "") + "hd");
      this.hnp.delete("ImgInfo2", "id=?", new String[] { paramau.hEG });
    }
    GMTrace.o(3523081142272L, 26249);
  }
  
  public final String v(String paramString, boolean paramBoolean)
  {
    GMTrace.i(3521067876352L, 26234);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(3521067876352L, 26234);
      return null;
    }
    String str = paramString.trim();
    if (str.startsWith("THUMBNAIL://")) {
      paramString = str.substring(12);
    }
    do
    {
      try
      {
        paramString = fT(Integer.valueOf(paramString).intValue()).hEJ;
        paramString = a(paramString, "", "", paramBoolean);
        GMTrace.o(3521067876352L, 26234);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        v.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        GMTrace.o(3521067876352L, 26234);
        return null;
      }
      paramString = str;
    } while (!str.startsWith("THUMBNAIL_DIRPATH://"));
    paramString = a(str.substring(20).substring(3), "th_", "", paramBoolean);
    GMTrace.o(3521067876352L, 26234);
    return paramString;
  }
  
  public static final class a
    extends BitmapDrawable
  {
    private a(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
      GMTrace.i(3542676930560L, 26395);
      GMTrace.o(3542676930560L, 26395);
    }
    
    public static void a(Bitmap paramBitmap, ImageView paramImageView)
    {
      GMTrace.i(3542542712832L, 26394);
      if ((paramImageView == null) || (paramImageView.getResources() == null))
      {
        GMTrace.o(3542542712832L, 26394);
        return;
      }
      paramBitmap = new a(paramImageView.getResources(), paramBitmap);
      if (paramImageView.getLayerType() == 1)
      {
        paramImageView.destroyDrawingCache();
        paramImageView.setLayerType(0, null);
      }
      paramImageView.setImageDrawable(paramBitmap);
      GMTrace.o(3542542712832L, 26394);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      GMTrace.i(3542811148288L, 26396);
      if ((getBitmap() != null) && (!getBitmap().isRecycled()))
      {
        super.draw(paramCanvas);
        GMTrace.o(3542811148288L, 26396);
        return;
      }
      if (getBitmap() != null) {
        v.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", new Object[] { getBitmap().toString() });
      }
      GMTrace.o(3542811148288L, 26396);
    }
  }
  
  static final class b
  {
    int hFG;
    int hFH;
    int hFI;
    String url;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      GMTrace.i(3530597335040L, 26305);
      this.hFG = paramInt1;
      this.url = paramString;
      this.hFH = paramInt2;
      this.hFI = paramInt3;
      GMTrace.o(3530597335040L, 26305);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */