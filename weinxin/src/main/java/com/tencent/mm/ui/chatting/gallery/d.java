package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.ee;
import com.tencent.mm.ui.chatting.ee.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends a
  implements c.a, e.a
{
  private HashMap<String, WeakReference<Bitmap>> rZX;
  private com.tencent.mm.sdk.b.c vPn;
  public HashMap<Long, Integer> vPo;
  public final e vPp;
  private HashMap<au, String> vPq;
  private HashMap<au, String> vPr;
  private long vPs;
  int xV;
  
  public d(b paramb)
  {
    super(paramb);
    GMTrace.i(2441017819136L, 18187);
    this.vPo = new HashMap();
    this.vPp = new e(this);
    this.rZX = new HashMap();
    this.vPq = new HashMap();
    this.vPr = new HashMap();
    this.vPs = 0L;
    this.xV = 0;
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.uql;
    paramb = new ee(ee.a.vMm, paramb.vNW);
    this.vPn = paramb;
    locala.b(paramb);
    paramb = f.a.vPH.mfs.snapshot();
    this.vPp.aj(paramb);
    k.bXo().vRH = this;
    GMTrace.o(2441017819136L, 18187);
  }
  
  private static boolean Bu(int paramInt)
  {
    GMTrace.i(2444104826880L, 18210);
    if (paramInt == 1)
    {
      GMTrace.o(2444104826880L, 18210);
      return true;
    }
    GMTrace.o(2444104826880L, 18210);
    return false;
  }
  
  private static Bitmap T(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(2443299520512L, 18204);
    Object localObject = null;
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = com.tencent.mm.compatible.util.d.ep(16);
      if (bool1)
      {
        GMTrace.o(2443299520512L, 18204);
        return null;
      }
      bool1 = com.tencent.mm.sdk.a.b.bIk();
      if (!bool1) {
        try
        {
          i = bf.getInt(com.tencent.mm.i.g.sV().getValue("UseOptImageRecv"), 0);
          ap.yY();
          o localo = new o(com.tencent.mm.u.c.uH());
          v.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Integer.valueOf(i), Long.valueOf(localo.longValue()), Long.valueOf(localo.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIk()), Integer.valueOf(Build.VERSION.SDK_INT) });
          j = (int)(localo.longValue() / 100L);
          if (j % 100 + 1 > i)
          {
            GMTrace.o(2443299520512L, 18204);
            return null;
          }
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[] { bf.g(localException) });
          GMTrace.o(2443299520512L, 18204);
          return null;
        }
      }
      com.tencent.mm.sdk.platformtools.j.p(paramString, str, false);
      bool2 = MMNativeJpeg.IsJpegFile(str);
      bool3 = MMNativeJpeg.isProgressive(str);
      if (bf.mA(str)) {
        break label469;
      }
      if (new File(str).exists()) {
        break label403;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        int i;
        int j;
        boolean bool2;
        boolean bool3;
        Bitmap localBitmap = null;
        v.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, bf.g(localThrowable1) });
        continue;
        localBitmap = null;
        continue;
        boolean bool1 = false;
      }
    }
    j = com.tencent.mm.a.e.aN(str);
    if ((bool2) && (bool3))
    {
      if (bool1) {
        localBitmap = MMNativeJpeg.decodeAsBitmap(str);
      }
      if (localBitmap != null) {}
      for (i = j;; i = 0 - j)
      {
        try
        {
          a.g(paramString, paramInt2, paramInt1, i);
        }
        catch (Throwable localThrowable2)
        {
          label403:
          for (;;) {}
        }
        try
        {
          v.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap, paramString });
          com.tencent.mm.loader.stub.b.deleteFile(str);
          GMTrace.o(2443299520512L, 18204);
          return localBitmap;
        }
        catch (Throwable localThrowable3)
        {
          break label426;
        }
        bool1 = MMJpegOptim.checkIntegrity(str);
        break;
      }
    }
  }
  
  private int a(long paramLong, Object paramObject)
  {
    GMTrace.i(2443836391424L, 18208);
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.vNV.Bh(i);
      if ((paramObject != null) && (((ce)paramObject).field_msgId == paramLong))
      {
        GMTrace.o(2443836391424L, 18208);
        return i;
      }
    }
    paramObject = this.vNV.vlW.values().iterator();
    while (((Iterator)paramObject).hasNext())
    {
      i = ((Integer)((Iterator)paramObject).next()).intValue();
      au localau = this.vNV.Bh(i);
      if ((localau != null) && (localau.field_msgId == paramLong))
      {
        GMTrace.o(2443836391424L, 18208);
        return i;
      }
    }
    GMTrace.o(2443836391424L, 18208);
    return -1;
  }
  
  public static String a(au paramau, com.tencent.mm.ah.d paramd, boolean paramBoolean)
  {
    GMTrace.i(2443433738240L, 18205);
    if (paramau.field_isSend == 1)
    {
      paramau = n.GT().d(paramd);
      paramau = n.GT().m(paramau, "", "");
      if (com.tencent.mm.a.e.aO(paramau))
      {
        GMTrace.o(2443433738240L, 18205);
        return paramau;
      }
      paramau = paramd.hEH;
      paramau = n.GT().m(paramau, "", "");
      if (com.tencent.mm.a.e.aO(paramau))
      {
        GMTrace.o(2443433738240L, 18205);
        return paramau;
      }
      GMTrace.o(2443433738240L, 18205);
      return null;
    }
    if ((!paramBoolean) && (!paramd.GB()))
    {
      v.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(paramd.GB()) });
      GMTrace.o(2443433738240L, 18205);
      return null;
    }
    String str = paramd.hEH;
    if (paramd.GC())
    {
      paramau = n.GT().d(paramd);
      if (paramau != null)
      {
        paramau = n.GT().m(paramau, "", "");
        if (com.tencent.mm.a.e.aO(paramau)) {
          v.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      paramd = paramau;
      if (paramau == null) {
        paramd = n.GT().m(str, "", "");
      }
      v.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { paramd });
      GMTrace.o(2443433738240L, 18205);
      return paramd;
      paramau = null;
    }
  }
  
  private void a(au paramau, j paramj, int paramInt1, int paramInt2)
  {
    GMTrace.i(2442628431872L, 18199);
    v.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = n.GT().v(paramau.field_imgPath, true);
    j.M(paramj.vRu, 8);
    j.M(paramj.vRp, 8);
    j.M(paramj.vRy, 8);
    paramj.bXl().vRv.setVisibility(0);
    if ((str == null) || (!com.tencent.mm.a.e.aO(str)))
    {
      paramj.bXl().vRx.setImageResource(R.k.dxj);
      paramj.bXl().vRw.setText(R.l.eso);
      GMTrace.o(2442628431872L, 18199);
      return;
    }
    ImageView localImageView = paramj.bXl().vRx;
    if (localImageView != null)
    {
      if ((!bf.mA(str)) && (com.tencent.mm.a.e.aO(str))) {
        break label187;
      }
      localImageView.setImageBitmap(null);
    }
    while (paramInt2 == 6)
    {
      paramj.bXl().vRw.setText(R.l.esm);
      GMTrace.o(2442628431872L, 18199);
      return;
      label187:
      Bitmap localBitmap;
      if (this.vPp.mfs.aV(str))
      {
        localBitmap = (Bitmap)this.vPp.mfs.get(str);
        if (!localBitmap.isRecycled())
        {
          localImageView.setImageBitmap(localBitmap);
          continue;
        }
      }
      if (this.vNV.vOg)
      {
        localBitmap = TI(str);
        if (localBitmap != null)
        {
          c(localImageView, localBitmap);
          continue;
        }
      }
      if (!this.vPp.b(localImageView, paramInt1)) {
        this.vPp.q(localImageView, str);
      }
    }
    if (paramau.bMj())
    {
      paramj.bXl().vRw.setText(R.l.esk);
      GMTrace.o(2442628431872L, 18199);
      return;
    }
    paramj.bXl().vRw.setText(R.l.esl);
    GMTrace.o(2442628431872L, 18199);
  }
  
  private static void a(au paramau, String paramString, boolean paramBoolean)
  {
    GMTrace.i(2443970609152L, 18209);
    v.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(paramau.field_msgId), paramString });
    b.b(aa.getContext(), paramau, paramBoolean);
    GMTrace.o(2443970609152L, 18209);
  }
  
  private void a(j paramj, au paramau, com.tencent.mm.ah.d paramd, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(2442359996416L, 18197);
    a(paramj, paramau, paramd, paramBoolean, true, paramInt);
    GMTrace.o(2442359996416L, 18197);
  }
  
  private void a(j paramj, au paramau, com.tencent.mm.ah.d paramd, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    GMTrace.i(2442494214144L, 18198);
    v.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = " + paramBoolean1);
    j.M(paramj.vRv, 8);
    String str = null;
    if (!paramBoolean1) {
      paramj.vRy.setVisibility(0);
    }
    com.tencent.mm.ah.d locald = com.tencent.mm.ah.e.a(paramd);
    if ((paramBoolean1) && (paramInt == this.vNV.vNW.bWV()))
    {
      localObject = this.vNV.vNW;
      ((ImageGalleryUI)localObject).eu(true);
      ((ImageGalleryUI)localObject).bWU();
      ((ImageGalleryUI)localObject).bWJ().vPX.setVisibility(0);
      ((ImageGalleryUI)localObject).bWJ().vPY.setVisibility(8);
      ((ImageGalleryUI)localObject).bWJ().vPZ.setVisibility(0);
      ((ImageGalleryUI)localObject).bWJ().vQa.setVisibility(8);
      ((ImageGalleryUI)localObject).bWX();
      ((ImageGalleryUI)localObject).bWY();
      ((ImageGalleryUI)localObject).bWJ().vPZ.setText("0%");
    }
    if (paramBoolean1) {
      str = a(paramau, paramd, true);
    }
    Object localObject = str;
    if (bf.mA(str)) {
      localObject = n.GT().m(locald.hEJ, "", "");
    }
    str = n.GT().v(paramau.field_imgPath, true);
    if (paramBoolean2) {
      a(paramj, str, (String)localObject, paramau);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = paramd.hrb;
      int i = paramd.offset;
      if (paramInt == 0) {
        break label357;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label363;
      }
      paramj.bXk().vRu.setVisibility(8);
    }
    for (;;)
    {
      paramj.bXk().vRs.setVisibility(8);
      paramj.bXk().vRr.setVisibility(8);
      paramj.bXk().vRq.setVisibility(8);
      GMTrace.o(2442494214144L, 18198);
      return;
      label357:
      l = 0L;
      break;
      label363:
      paramj.bXk().vRu.setVisibility(0);
    }
  }
  
  private boolean a(j paramj, au paramau, com.tencent.mm.ah.d paramd, int paramInt)
  {
    GMTrace.i(2442225778688L, 18196);
    v.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = c(paramau, paramd);
    j.M(paramj.vRu, 8);
    String str1 = (String)this.vPr.get(paramau);
    paramd = str1;
    if (str1 == null)
    {
      paramd = n.GT().v(paramau.field_imgPath, true);
      this.vPr.put(paramau, paramd);
    }
    boolean bool = a(paramj, paramd, str2, paramau);
    if ((paramInt == this.vNV.vNW.bWV()) && (this.vNV.vOa))
    {
      this.vNV.ba(paramau);
      this.vNV.vOa = false;
    }
    GMTrace.o(2442225778688L, 18196);
    return bool;
  }
  
  private boolean a(j paramj, String paramString1, String paramString2, au paramau)
  {
    GMTrace.i(2442762649600L, 18200);
    j.M(paramj.vRy, 0);
    j.M(paramj.vRp, 8);
    j.M(paramj.vRu, 8);
    j.M(paramj.vRv, 8);
    boolean bool = a(true, paramj.vRy, paramString1, paramString2, false, paramj.kC);
    GMTrace.o(2442762649600L, 18200);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, int paramInt)
  {
    GMTrace.i(2442896867328L, 18201);
    v.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    String str = null;
    boolean bool = true;
    if ((paramString2 != null) && (com.tencent.mm.a.e.aO(paramString2)))
    {
      str = paramString2;
      if ((str != null) || (paramString1 == null) || (!com.tencent.mm.a.e.aO(paramString1))) {
        break label382;
      }
      if (!com.tencent.mm.a.e.aO(paramString1 + "hd")) {
        break label376;
      }
      str = paramString1 + "hd";
    }
    label376:
    label382:
    for (;;)
    {
      if (str == null)
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[] { paramString2 });
        GMTrace.o(2442896867328L, 18201);
        return false;
        bool = false;
        break;
      }
      Object localObject;
      if ((!paramBoolean2) && (this.vPp.mfs.aV(str)))
      {
        localObject = (Bitmap)this.vPp.mfs.get(str);
        if (!((Bitmap)localObject).isRecycled())
        {
          v.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { str });
          b(paramMultiTouchImageView, (Bitmap)localObject);
          GMTrace.o(2442896867328L, 18201);
          return true;
        }
      }
      if (paramBoolean1) {
        paramMultiTouchImageView.setImageBitmap(null);
      }
      if (!this.vNV.vOg) {
        if (paramInt >= 0) {
          this.vPp.b(paramMultiTouchImageView, paramInt);
        }
      }
      do
      {
        this.vPp.q(paramMultiTouchImageView, str);
        GMTrace.o(2442896867328L, 18201);
        return bool;
        Bitmap localBitmap = TI(str);
        localObject = localBitmap;
        if (localBitmap == null) {
          localObject = TI(paramString1);
        }
      } while (localObject == null);
      c(paramMultiTouchImageView, (Bitmap)localObject);
      if (str.equals(paramString2)) {
        this.vPp.t(str, (Bitmap)localObject);
      }
      GMTrace.o(2442896867328L, 18201);
      return bool;
      str = paramString1;
    }
  }
  
  @TargetApi(11)
  private void b(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    GMTrace.i(2444507480064L, 18213);
    if ((this.vNV == null) || (this.vNV.vNW == null))
    {
      GMTrace.o(2444507480064L, 18213);
      return;
    }
    v.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.qAx = false;
      paramMultiTouchImageView.dZ(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(null);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.invalidate();
      GMTrace.o(2444507480064L, 18213);
      return;
      com.tencent.mm.sdk.platformtools.k.h((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  public static com.tencent.mm.ah.d bg(au paramau)
  {
    GMTrace.i(2441823125504L, 18193);
    if (!b.aR(paramau))
    {
      GMTrace.o(2441823125504L, 18193);
      return null;
    }
    long l;
    com.tencent.mm.ah.d locald1;
    if (paramau.field_isSend == 1)
    {
      l = paramau.field_msgId;
      com.tencent.mm.ah.d locald2 = n.GT().aj(l);
      locald1 = locald2;
      if (locald2.hEG != 0L) {}
    }
    else
    {
      l = paramau.field_msgSvrId;
      locald1 = n.GT().ai(l);
    }
    GMTrace.o(2441823125504L, 18193);
    return locald1;
  }
  
  private String c(au paramau, com.tencent.mm.ah.d paramd)
  {
    GMTrace.i(2442091560960L, 18195);
    String str2 = (String)this.vPq.get(paramau);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(paramau, paramd, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        GMTrace.o(2442091560960L, 18195);
        return null;
      }
      this.vPq.put(paramau, str1);
    }
    GMTrace.o(2442091560960L, 18195);
    return str1;
  }
  
  private void g(au paramau, int paramInt)
  {
    GMTrace.i(2441420472320L, 18190);
    this.vPo.put(Long.valueOf(paramau.field_msgId), Integer.valueOf(paramInt));
    GMTrace.o(2441420472320L, 18190);
  }
  
  private void x(long paramLong, int paramInt)
  {
    GMTrace.i(2441554690048L, 18191);
    this.vPo.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    GMTrace.o(2441554690048L, 18191);
  }
  
  public final Bitmap Bv(int paramInt)
  {
    GMTrace.i(2444641697792L, 18214);
    if (this.vNV == null)
    {
      GMTrace.o(2444641697792L, 18214);
      return null;
    }
    au localau = this.vNV.vNX.Bs(paramInt);
    if (localau != null)
    {
      String str = (String)this.vPr.get(localau);
      Object localObject = str;
      if (str == null)
      {
        localObject = n.GT().v(localau.field_imgPath, true);
        this.vPr.put(localau, localObject);
      }
      str = (String)localObject + "hd";
      if (com.tencent.mm.a.e.aO(str))
      {
        localObject = TI(str);
        GMTrace.o(2444641697792L, 18214);
        return (Bitmap)localObject;
      }
      localObject = TI((String)localObject);
      GMTrace.o(2444641697792L, 18214);
      return (Bitmap)localObject;
    }
    GMTrace.o(2444641697792L, 18214);
    return null;
  }
  
  public final Bitmap TI(String paramString)
  {
    GMTrace.i(2443165302784L, 18203);
    if (paramString == null)
    {
      GMTrace.o(2443165302784L, 18203);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap != null)
    {
      v.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
      localBitmap.recycle();
    }
    int i;
    int j;
    label135:
    boolean bool;
    if ((u.bh(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
    {
      i = 1;
      if ((!u.bg(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
        break label288;
      }
      j = 1;
      if ((i != 0) || (j != 0))
      {
        i = ((BitmapFactory.Options)localObject).outHeight;
        i = ((BitmapFactory.Options)localObject).outWidth;
      }
      i = BackwardSupportUtil.ExifHelper.Pb(paramString);
      localBitmap = T(paramString, ((BitmapFactory.Options)localObject).outHeight, ((BitmapFactory.Options)localObject).outWidth);
      localObject = localBitmap;
      if (localBitmap == null) {
        localObject = com.tencent.mm.sdk.platformtools.d.cz(paramString, 0);
      }
      if ((localObject != null) || (!MMNativeJpeg.IsJpegFile(paramString)) || (!MMNativeJpeg.isProgressive(paramString))) {
        break label362;
      }
      localObject = MMNativeJpeg.decodeAsBitmap(paramString);
      if (localObject != null) {
        break label293;
      }
      bool = true;
      label225:
      v.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
    }
    label288:
    label293:
    label362:
    for (;;)
    {
      if (localObject == null)
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = " + paramString);
        GMTrace.o(2443165302784L, 18203);
        return null;
        i = 0;
        break;
        j = 0;
        break label135;
        bool = false;
        break label225;
      }
      paramString = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, i);
      if ((paramString == localObject) && (i % 360 != 0))
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[] { Integer.valueOf(i) });
        GMTrace.o(2443165302784L, 18203);
        return null;
      }
      GMTrace.o(2443165302784L, 18203);
      return paramString;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    GMTrace.i(2444239044608L, 18211);
    if (!(paramObject instanceof Integer))
    {
      v.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
      GMTrace.o(2444239044608L, 18211);
      return;
    }
    paramInt1 = ((Integer)paramObject).intValue();
    v.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos " + paramInt1, new Object[0]);
    GMTrace.o(2444239044608L, 18211);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2443567955968L, 18206);
    if ((this.vNV == null) || (this.vNV.vNW == null))
    {
      GMTrace.o(2443567955968L, 18206);
      return;
    }
    if (this.xV != 0)
    {
      GMTrace.o(2443567955968L, 18206);
      return;
    }
    int i;
    if (k.bXo().eU(paramLong2))
    {
      i = a(paramLong2, paramObject);
      if (i == -1)
      {
        GMTrace.o(2443567955968L, 18206);
        return;
      }
      paramObject = new Integer(i);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        GMTrace.o(2443567955968L, 18206);
        return;
      }
      i = ((Integer)paramObject).intValue();
      v.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1) });
      if (i == -1)
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
        GMTrace.o(2443567955968L, 18206);
        return;
      }
      if (this.vNV.Ag(i) == null)
      {
        GMTrace.o(2443567955968L, 18206);
        return;
      }
      paramObject = (j)this.vNV.Ag(i).getTag();
      if (paramObject == null)
      {
        GMTrace.o(2443567955968L, 18206);
        return;
      }
      if ((i == this.vNV.vNW.bWV()) && (!Bu(paramInt1))) {
        this.vNV.vNW.eu(false);
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.vNV.vNW.bWV()) && (Bu(paramInt1)))
        {
          v.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.vNV.vNW.BB(paramInt2);
        }
        paramk = (com.tencent.mm.ah.j)paramk;
        boolean bool1 = MMNativeJpeg.isProgressive(paramk.hGi);
        boolean bool2 = paramk.hGk;
        paramLong1 = bf.aB(this.vPs);
        a.cT(paramk.hGi, paramInt4);
        v.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramk.hGi });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label691;
        }
        this.vPs = bf.NB();
        paramk = this.vNV.Bh(i);
        com.tencent.mm.ah.d locald = e(paramk, true);
        if (!a(false, ((j)paramObject).vRy, n.GT().v(paramk.field_imgPath, true), a(paramk, locald, true), true, -1)) {
          break label691;
        }
        j.M(((j)paramObject).vRy, 0);
        j.M(((j)paramObject).vRs, 8);
        j.M(((j)paramObject).vRv, 8);
        if ((i != this.vNV.vNW.bWV()) || (Bu(paramInt1))) {
          break label691;
        }
        if (paramInt2 > 50)
        {
          j.M(((j)paramObject).vRu, 8);
          GMTrace.o(2443567955968L, 18206);
        }
      }
      else
      {
        if (paramInt4 != 0) {}
        for (float f = paramInt3 / paramInt4 * 100.0F - 1.0F;; f = 0.0F)
        {
          paramInt2 = (int)f;
          break;
        }
      }
      j.M(((j)paramObject).vRu, 0);
      label691:
      GMTrace.o(2443567955968L, 18206);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, final int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2443702173696L, 18207);
    if ((this.vNV == null) || (this.vNV.vNW == null))
    {
      GMTrace.o(2443702173696L, 18207);
      return;
    }
    if (k.bXo().eU(paramLong2))
    {
      paramInt2 = a(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        ap.yY();
        a(com.tencent.mm.u.c.wT().cA(paramLong2), "background", false);
        GMTrace.o(2443702173696L, 18207);
        return;
      }
      paramObject = new Integer(paramInt2);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        GMTrace.o(2443702173696L, 18207);
        return;
      }
      paramInt2 = ((Integer)paramObject).intValue();
      v.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = " + paramInt2);
      if (paramInt2 == -1)
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 3L, 1L, true);
        GMTrace.o(2443702173696L, 18207);
        return;
      }
      if (this.vNV.Ag(paramInt2) != null) {}
      for (paramObject = (j)this.vNV.Ag(paramInt2).getTag();; paramObject = null)
      {
        boolean bool = k.bXo().eU(paramLong2);
        if ((paramInt3 != 0) || (paramInt4 != 0))
        {
          if (bool)
          {
            paramObject = this.vNV.Bh(paramInt2);
            paramString = "hd_failed:" + paramInt2;
            if (paramInt2 == this.vNV.vNW.bWV())
            {
              bool = true;
              a((au)paramObject, paramString, bool);
            }
          }
          else
          {
            if (paramInt2 == this.vNV.vNW.bWV()) {
              this.vNV.vNW.eu(true);
            }
            if (paramInt4 != -5103059) {
              break label424;
            }
            x(paramLong2, 5);
            com.tencent.mm.plugin.report.service.g.oSF.a(111L, 0L, 1L, true);
          }
          for (;;)
          {
            v.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
            this.vNV.vOb.Bg(paramInt2);
            GMTrace.o(2443702173696L, 18207);
            return;
            bool = false;
            break;
            label424:
            x(paramLong2, 6);
            com.tencent.mm.plugin.report.service.g.oSF.a(111L, 1L, 1L, true);
          }
        }
        if (bool)
        {
          paramString = this.vNV.Bh(paramInt2);
          paramk = "hd_suc:" + paramInt2;
          if (paramInt2 == this.vNV.vNW.bWV())
          {
            bool = true;
            a(paramString, paramk, bool);
          }
        }
        else
        {
          v.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.vNV.vNW.bWV(), new Object[0]);
          x(paramLong2, 4);
          paramString = this.vNV.Bh(paramInt2);
          paramk = e(paramString, true);
          if (paramObject == null) {
            break label902;
          }
          this.vNV.vNW.eu(true);
          if (paramInt2 == this.vNV.vNW.bWV())
          {
            if (!Bu(paramInt1)) {
              break label858;
            }
            ImageGalleryUI localImageGalleryUI = this.vNV.vNW;
            localImageGalleryUI.eu(true);
            localImageGalleryUI.eu(true);
            Animation localAnimation = ImageGalleryUI.BA(1000);
            localAnimation.setAnimationListener(new ImageGalleryUI.10(localImageGalleryUI));
            localImageGalleryUI.bWU();
            localImageGalleryUI.bWJ().vPX.setVisibility(0);
            localImageGalleryUI.bWJ().vPY.setVisibility(8);
            localImageGalleryUI.bWJ().vPZ.setVisibility(8);
            localImageGalleryUI.bWJ().vQa.setVisibility(0);
            localImageGalleryUI.bWJ().vQa.startAnimation(localAnimation);
          }
        }
        for (;;)
        {
          if (!a(false, ((j)paramObject).vRy, n.GT().v(paramString.field_imgPath, true), a(paramString, paramk, true), true, -1)) {
            break label880;
          }
          j.M(((j)paramObject).vRy, 0);
          j.M(((j)paramObject).vRp, 8);
          j.M(((j)paramObject).vRu, 8);
          j.M(((j)paramObject).vRv, 8);
          if ((bf(paramString) != 4) || (!this.vNV.vOa)) {
            break label902;
          }
          this.vNV.ba(paramString);
          this.vNV.vOa = false;
          GMTrace.o(2443702173696L, 18207);
          return;
          bool = false;
          break;
          label858:
          ((j)paramObject).vRy.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2446252310528L, 18226);
              if ((d.this.vNV == null) || (d.this.vNV.vNW == null))
              {
                GMTrace.o(2446252310528L, 18226);
                return;
              }
              d.this.vNV.vNW.Bx(paramInt2);
              GMTrace.o(2446252310528L, 18226);
            }
          });
        }
        label880:
        v.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 2L, 1L, true);
        label902:
        GMTrace.o(2443702173696L, 18207);
        return;
      }
    }
  }
  
  public final boolean a(j paramj, au paramau, int paramInt)
  {
    GMTrace.i(2441688907776L, 18192);
    super.a(paramj, paramau, paramInt);
    if ((paramj == null) || (paramau == null) || (paramInt < 0))
    {
      GMTrace.o(2441688907776L, 18192);
      return false;
    }
    int i = bf(paramau);
    v.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s", new Object[] { Integer.valueOf(paramj.vRy.hashCode()), Integer.valueOf(paramInt) });
    j.M(paramj.vRp, 8);
    com.tencent.mm.ah.d locald = e(paramau, false);
    if (locald == null)
    {
      GMTrace.o(2441688907776L, 18192);
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      GMTrace.o(2441688907776L, 18192);
      return true;
      v.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
      v.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
      boolean bool;
      if (paramau.field_isSend == 1) {
        bool = paramau.bMj();
      }
      Object localObject;
      for (;;)
      {
        if (!bool) {
          break label325;
        }
        g(paramau, 5);
        a(paramau, paramj, paramInt, 5);
        break;
        if (paramau.bMj())
        {
          bool = true;
        }
        else
        {
          localObject = c(paramau, locald);
          if ((locald.GB()) && ((localObject == null) || (!com.tencent.mm.a.e.aO((String)localObject))))
          {
            bool = true;
          }
          else
          {
            if ((System.currentTimeMillis() - paramau.field_createTime > 259200000L) && ((bf.mA((String)localObject)) || (!com.tencent.mm.a.e.aO((String)localObject)))) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label319;
              }
              bool = true;
              break;
            }
            label319:
            bool = false;
          }
        }
      }
      label325:
      label360:
      long l1;
      long l2;
      if (a(paramj, paramau, locald, paramInt))
      {
        if (locald.GB())
        {
          g(paramau, 4);
          continue;
        }
        g(paramau, 1);
        localObject = n.GU();
        l1 = locald.hEG;
        l2 = paramau.field_msgId;
        if (paramau.field_isSend != 1) {
          break label479;
        }
      }
      label479:
      for (i = R.g.bdI;; i = R.g.bdG)
      {
        i = ((com.tencent.mm.ah.c)localObject).a(l1, l2, 0, Integer.valueOf(paramInt), i, this, 0);
        v.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
        if (i != -2) {
          break label586;
        }
        v.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
        locald = e(paramau, true);
        if (locald != null) {
          break label487;
        }
        v.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
        break;
        g(paramau, 2);
        break label360;
      }
      label487:
      if (a(paramj, paramau, locald, paramInt))
      {
        if ((paramau.field_isSend == 1) || (locald.GB())) {
          g(paramau, 4);
        } else {
          g(paramau, 1);
        }
      }
      else
      {
        for (;;)
        {
          v.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(locald.hEG), Boolean.valueOf(locald.GB()) });
          a(paramj, paramau, locald, false, paramInt);
          break;
          g(paramau, 2);
        }
        label586:
        a(paramj, paramau, locald, false, paramInt);
        continue;
        a(paramj, paramau, locald, paramInt);
        continue;
        a(paramj, paramau, locald, false, paramInt);
        continue;
        a(paramj, paramau, locald, true, paramInt);
        continue;
        a(paramau, paramj, paramInt, i);
        paramj.mgy.invalidate();
      }
    }
  }
  
  public final void al(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2444373262336L, 18212);
    v.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = " + paramInt);
    Object localObject1 = this.vNV.Bh(paramInt);
    if ((localObject1 == null) || (((ce)localObject1).field_msgId == 0L))
    {
      v.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      GMTrace.o(2444373262336L, 18212);
      return;
    }
    if (!b.aR((au)localObject1))
    {
      v.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      GMTrace.o(2444373262336L, 18212);
      return;
    }
    com.tencent.mm.ah.d locald = e((au)localObject1, true);
    if ((locald == null) || (locald.hEG == 0L))
    {
      localObject2 = new StringBuilder("viewHdImg fail, msgLocalId = ");
      if (localObject1 == null)
      {
        localObject1 = "null";
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", imgLocalId = ");
        if (locald != null) {
          break label209;
        }
      }
      label209:
      for (localObject1 = "null";; localObject1 = Long.valueOf(locald.hEG))
      {
        v.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        GMTrace.o(2444373262336L, 18212);
        return;
        localObject1 = Long.valueOf(((ce)localObject1).field_msgId);
        break;
      }
    }
    g((au)localObject1, 3);
    if (Bf(paramInt) != null) {
      a(Bf(paramInt), (au)localObject1, locald, true, false, paramInt);
    }
    if (paramBoolean)
    {
      localObject2 = k.bXo();
      v.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((ce)localObject1).field_msgId) });
      ((k)localObject2).vRG.add(Long.valueOf(((ce)localObject1).field_msgId));
      com.tencent.mm.ah.c localc = n.GU();
      l1 = locald.hEG;
      l2 = ((ce)localObject1).field_msgId;
      if (((ce)localObject1).field_isSend == 1) {}
      for (i = R.g.bdI;; i = R.g.bdG)
      {
        localc.a(l1, l2, 1, Integer.valueOf(paramInt), i, (c.a)localObject2, 0);
        GMTrace.o(2444373262336L, 18212);
        return;
      }
    }
    Object localObject2 = n.GU();
    long l1 = locald.hEG;
    long l2 = ((ce)localObject1).field_msgId;
    if (((ce)localObject1).field_isSend == 1) {}
    for (int i = R.g.bdI;; i = R.g.bdG)
    {
      ((com.tencent.mm.ah.c)localObject2).a(l1, l2, 1, Integer.valueOf(paramInt), i, this, 0);
      GMTrace.o(2444373262336L, 18212);
      return;
    }
  }
  
  public final int bf(au paramau)
  {
    GMTrace.i(2441286254592L, 18189);
    if ((paramau != null) && (this.vPo.containsKey(Long.valueOf(paramau.field_msgId))))
    {
      int i = ((Integer)this.vPo.get(Long.valueOf(paramau.field_msgId))).intValue();
      GMTrace.o(2441286254592L, 18189);
      return i;
    }
    GMTrace.o(2441286254592L, 18189);
    return 0;
  }
  
  public final void c(ImageView paramImageView, Bitmap paramBitmap)
  {
    GMTrace.i(2443031085056L, 18202);
    if (paramBitmap == null)
    {
      GMTrace.o(2443031085056L, 18202);
      return;
    }
    if (paramImageView != null)
    {
      int i = paramImageView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.vPp.mft.indexOfValue(i);
      if (k >= 0) {
        this.vPp.mft.removeAt(k);
      }
      this.vPp.mft.put(j, i);
      if ((paramImageView instanceof MultiTouchImageView))
      {
        b((MultiTouchImageView)paramImageView, paramBitmap);
        GMTrace.o(2443031085056L, 18202);
        return;
      }
      paramImageView.setImageBitmap(paramBitmap);
    }
    GMTrace.o(2443031085056L, 18202);
  }
  
  public final void detach()
  {
    GMTrace.i(2441152036864L, 18188);
    super.detach();
    com.tencent.mm.sdk.b.a.uql.c(this.vPn);
    if (this.rZX != null)
    {
      localObject = this.rZX.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.rZX.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          v.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.vPp;
    ((e)localObject).vPy = null;
    ((e)localObject).mfo.clear();
    ((e)localObject).mfr.clear();
    ((e)localObject).mfq.clear();
    ((e)localObject).mfp.clear();
    ((e)localObject).ayP();
    n.GU().a(this);
    localObject = k.bXo();
    if (equals(((k)localObject).vRH)) {
      ((k)localObject).vRH = null;
    }
    GMTrace.o(2441152036864L, 18188);
  }
  
  public final com.tencent.mm.ah.d e(au paramau, boolean paramBoolean)
  {
    GMTrace.i(2441957343232L, 18194);
    if (!b.aR(paramau))
    {
      GMTrace.o(2441957343232L, 18194);
      return null;
    }
    if ((this.vNV == null) || (this.vNV.vNX == null))
    {
      v.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      GMTrace.o(2441957343232L, 18194);
      return null;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (!paramBoolean)
    {
      if (paramau.field_isSend == 1) {
        localObject2 = (com.tencent.mm.ah.d)this.vNV.vNX.vOv.get(Long.valueOf(paramau.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramau.field_msgSvrId > 0L) {
          localObject1 = (com.tencent.mm.ah.d)this.vNV.vNX.vOu.get(Long.valueOf(paramau.field_msgSvrId));
        }
      }
    }
    localObject2 = localObject1;
    long l;
    if (localObject1 == null)
    {
      int i = 0;
      if (paramau.field_isSend == 1)
      {
        l = paramau.field_msgId;
        localObject2 = n.GT().aj(l);
        localObject1 = localObject2;
        if (((com.tencent.mm.ah.d)localObject2).hEG != 0L) {}
      }
      else
      {
        l = paramau.field_msgSvrId;
        localObject1 = n.GT().ai(l);
        i = 1;
      }
      paramau = this.vNV.vNX;
      if (i == 0) {
        break label263;
      }
      paramau.vOu.put(Long.valueOf(l), localObject1);
    }
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      GMTrace.o(2441957343232L, 18194);
      return (com.tencent.mm.ah.d)localObject2;
      label263:
      paramau.vOv.put(Long.valueOf(l), localObject1);
    }
  }
  
  private static final class a
  {
    private static HashMap<String, a> vPx;
    private int height;
    private int hrb;
    private long urP;
    private int vPu;
    private String vPv;
    private int vPw;
    private int width;
    
    static
    {
      GMTrace.i(2461016260608L, 18336);
      vPx = new HashMap();
      GMTrace.o(2461016260608L, 18336);
    }
    
    private a()
    {
      GMTrace.i(2460613607424L, 18333);
      this.urP = 0L;
      this.vPu = 0;
      this.vPv = "";
      this.vPw = 0;
      GMTrace.o(2460613607424L, 18333);
    }
    
    public static void cT(String paramString, int paramInt)
    {
      GMTrace.i(2460747825152L, 18334);
      Object localObject;
      try
      {
        boolean bool = bf.mA(paramString);
        if ((bool) || (paramInt == 0))
        {
          GMTrace.o(2460747825152L, 18334);
          return;
        }
        paramString = (a)vPx.get(paramString);
        if (paramString != null) {
          paramString.hrb = paramInt;
        }
        paramString = new HashSet();
        localObject = vPx.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          a locala = (a)vPx.get(str);
          if (locala != null)
          {
            long l = bf.aA(locala.urP);
            v.i("MicroMsg.ImageGalleryHolderImage", "dkprog report: diff:%d [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Long.valueOf(l), Integer.valueOf(locala.hrb), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.vPu), Integer.valueOf(locala.vPw), locala.vPv, str });
            if (l >= 60000L)
            {
              if ((locala.hrb > 0) && (!bf.mA(locala.vPv))) {
                com.tencent.mm.plugin.report.service.g.oSF.i(11713, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.hrb), Integer.valueOf(locala.width), Integer.valueOf(locala.height), Integer.valueOf(locala.vPu), Integer.valueOf(locala.vPw), locala.vPv });
              }
              paramString.add(str);
            }
          }
        }
        paramString = paramString.iterator();
      }
      catch (Throwable paramString)
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "get useopt  setTotalLen :%s", new Object[] { bf.g(paramString) });
        GMTrace.o(2460747825152L, 18334);
        return;
      }
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        vPx.remove(localObject);
      }
      GMTrace.o(2460747825152L, 18334);
    }
    
    public static void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(2460882042880L, 18335);
      try
      {
        boolean bool = bf.mA(paramString);
        if ((bool) || (paramInt1 == 0) || (paramInt2 == 0))
        {
          GMTrace.o(2460882042880L, 18335);
          return;
        }
        a locala2 = (a)vPx.get(paramString);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a();
          locala1.urP = bf.NA();
          vPx.put(paramString, locala1);
        }
        locala1.height = paramInt2;
        locala1.width = paramInt1;
        locala1.vPv = (locala1.vPv + paramInt3 + "|");
        if (paramInt3 > 0) {
          if (locala1.vPu == 0) {
            locala1.vPu = paramInt3;
          }
        }
        for (;;)
        {
          v.i("MicroMsg.ImageGalleryHolderImage", "dkprog addBit: [%d,%d,%d] succ:%d change:%d str:%s file:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(locala1.vPu), Integer.valueOf(locala1.vPw), locala1.vPv, paramString });
          GMTrace.o(2460882042880L, 18335);
          return;
          if (locala1.vPu != 0)
          {
            locala1.vPw += 1;
            locala1.vPu = 0;
          }
        }
        return;
      }
      catch (Throwable paramString)
      {
        v.e("MicroMsg.ImageGalleryHolderImage", "get useopt  addBit :%s", new Object[] { bf.g(paramString) });
        GMTrace.o(2460882042880L, 18335);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */