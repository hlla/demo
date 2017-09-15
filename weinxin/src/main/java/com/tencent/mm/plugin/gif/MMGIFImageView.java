package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.e.a.hp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMGIFImageView
  extends ImageView
{
  public String kGi;
  private float mDensity;
  public int mIB;
  private int mIC;
  private boolean mID;
  
  public MMGIFImageView(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(12896713048064L, 96088);
    GMTrace.o(12896713048064L, 96088);
  }
  
  public MMGIFImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    GMTrace.i(12896847265792L, 96089);
    GMTrace.o(12896847265792L, 96089);
  }
  
  public MMGIFImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(12896981483520L, 96090);
    this.mIB = a.d.kYr;
    this.mIC = a.d.bhQ;
    this.mID = true;
    this.mDensity = 0.0F;
    GMTrace.o(12896981483520L, 96090);
  }
  
  private void a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    a locala1 = null;
    GMTrace.i(12898055225344L, 96098);
    try
    {
      a locala2;
      if (!bf.mA(null))
      {
        this.kGi = null;
        b localb = b.aCO();
        if (localb.mIo.get(null) != null) {
          locala1 = (a)((WeakReference)localb.mIo.get(null)).get();
        }
        locala2 = locala1;
        if (locala1 == null)
        {
          locala2 = new a(paramResources, paramInt);
          localb.mIo.put(null, new WeakReference(locala2));
        }
      }
      while (paramBoolean)
      {
        setImageDrawable(locala2);
        GMTrace.o(12898055225344L, 96098);
        return;
        locala2 = new a(paramResources, paramInt);
      }
      return;
    }
    catch (IOException paramResources)
    {
      v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + paramResources.toString());
      if (paramBoolean)
      {
        super.setImageResource(paramInt);
        GMTrace.o(12898055225344L, 96098);
        return;
        setBackgroundDrawable(locala2);
        GMTrace.o(12898055225344L, 96098);
        return;
      }
      super.setBackgroundResource(paramInt);
      GMTrace.o(12898055225344L, 96098);
    }
  }
  
  public static void a(MMGIFException paramMMGIFException)
  {
    GMTrace.i(12898994749440L, 96105);
    hp localhp = new hp();
    localhp.fMV.errorCode = paramMMGIFException.getErrorCode();
    com.tencent.mm.sdk.b.a.uql.m(localhp);
    GMTrace.o(12898994749440L, 96105);
  }
  
  public final void a(InputStream paramInputStream, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    GMTrace.i(12897786789888L, 96096);
    for (;;)
    {
      try
      {
        if (bf.mA(paramString)) {
          continue;
        }
        this.kGi = paramString;
        localb = b.aCO();
        str = this.kGi;
        if (paramInputStream != null) {
          continue;
        }
        paramString = (String)localObject1;
      }
      catch (MMGIFException paramString)
      {
        b localb;
        String str;
        a(paramString);
        if (paramString.getErrorCode() != 103) {
          break label253;
        }
        paramInputStream = d.decodeStream(paramInputStream);
        if (paramInputStream == null) {
          break label233;
        }
        paramInputStream.setDensity(320);
        setImageBitmap(paramInputStream);
        GMTrace.o(12897786789888L, 96096);
        return;
        paramString = new a(paramInputStream);
        continue;
      }
      catch (IOException paramInputStream)
      {
        v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramInputStream.toString() });
      }
      setImageDrawable(paramString);
      GMTrace.o(12897786789888L, 96096);
      return;
      v.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "stream key:%s", new Object[] { str });
      localObject1 = localObject2;
      if (localb.mIo.get(str) != null) {
        localObject1 = (a)((WeakReference)localb.mIo.get(str)).get();
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = new a(paramInputStream);
        localb.mIo.put(str, new WeakReference(paramString));
      }
    }
    for (;;)
    {
      init();
      GMTrace.o(12897786789888L, 96096);
      return;
      label233:
      v.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
      init();
      GMTrace.o(12897786789888L, 96096);
      return;
      label253:
      v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void a(String paramString, e parame)
  {
    GMTrace.i(16406775070720L, 122240);
    try
    {
      localObject = new a(paramString);
      setImageDrawable((Drawable)localObject);
      ((a)localObject).mIc = Integer.MAX_VALUE;
      ((a)localObject).mIe = parame;
      GMTrace.o(16406775070720L, 122240);
      return;
    }
    catch (MMGIFException parame)
    {
      try
      {
        Object localObject;
        a(parame);
        if (parame.getErrorCode() == 103)
        {
          localObject = d.decodeStream(new FileInputStream(paramString));
          if (localObject == null) {
            break label155;
          }
          ((Bitmap)localObject).setDensity(320);
          setImageBitmap((Bitmap)localObject);
          GMTrace.o(16406775070720L, 122240);
          return;
        }
      }
      catch (FileNotFoundException paramString)
      {
        v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
        v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + parame.toString());
      }
      init();
      GMTrace.o(16406775070720L, 122240);
      return;
      v.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[] { paramString });
      init();
      com.tencent.mm.loader.stub.b.deleteFile(paramString);
      GMTrace.o(16406775070720L, 122240);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        label155:
        v.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
      }
    }
  }
  
  public final float aCN()
  {
    GMTrace.i(12897921007616L, 96097);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.bg.a.getDensity(aa.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label60;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      GMTrace.o(12897921007616L, 96097);
      return f;
      label60:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    GMTrace.i(12897518354432L, 96094);
    ct(paramString1, paramString2);
    GMTrace.o(12897518354432L, 96094);
  }
  
  /* Error */
  public final void ct(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc2_w 281
    //   3: ldc_w 283
    //   6: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_2
    //   10: invokestatic 70	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   13: ifne +35 -> 48
    //   16: aload_0
    //   17: aload_2
    //   18: putfield 72	com/tencent/mm/plugin/gif/MMGIFImageView:kGi	Ljava/lang/String;
    //   21: invokestatic 78	com/tencent/mm/plugin/gif/b:aCO	()Lcom/tencent/mm/plugin/gif/b;
    //   24: aload_0
    //   25: getfield 72	com/tencent/mm/plugin/gif/MMGIFImageView:kGi	Ljava/lang/String;
    //   28: aload_1
    //   29: invokevirtual 287	com/tencent/mm/plugin/gif/b:cr	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/gif/a;
    //   32: astore_2
    //   33: aload_0
    //   34: aload_2
    //   35: invokevirtual 109	com/tencent/mm/plugin/gif/MMGIFImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   38: ldc2_w 281
    //   41: ldc_w 283
    //   44: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   47: return
    //   48: new 95	com/tencent/mm/plugin/gif/a
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 231	com/tencent/mm/plugin/gif/a:<init>	(Ljava/lang/String;)V
    //   56: astore_2
    //   57: goto -24 -> 33
    //   60: astore_2
    //   61: aload_2
    //   62: invokestatic 196	com/tencent/mm/plugin/gif/MMGIFImageView:a	(Lcom/tencent/mm/plugin/gif/MMGIFException;)V
    //   65: aload_2
    //   66: invokevirtual 162	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   69: bipush 103
    //   71: if_icmpne +55 -> 126
    //   74: aload_1
    //   75: aconst_null
    //   76: invokestatic 291	com/tencent/mm/sdk/platformtools/d:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +59 -> 140
    //   84: aload_2
    //   85: sipush 320
    //   88: invokevirtual 207	android/graphics/Bitmap:setDensity	(I)V
    //   91: aload_0
    //   92: aload_2
    //   93: invokevirtual 211	com/tencent/mm/plugin/gif/MMGIFImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   96: ldc2_w 281
    //   99: ldc_w 283
    //   102: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   105: return
    //   106: astore_1
    //   107: ldc 111
    //   109: ldc_w 293
    //   112: iconst_1
    //   113: anewarray 187	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: invokestatic 297	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 215	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_0
    //   127: invokevirtual 218	com/tencent/mm/plugin/gif/MMGIFImageView:init	()V
    //   130: ldc2_w 281
    //   133: ldc_w 283
    //   136: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   139: return
    //   140: ldc 111
    //   142: ldc_w 299
    //   145: iconst_1
    //   146: anewarray 187	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_1
    //   152: aastore
    //   153: invokestatic 249	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload_0
    //   157: invokevirtual 218	com/tencent/mm/plugin/gif/MMGIFImageView:init	()V
    //   160: aload_1
    //   161: invokestatic 254	com/tencent/mm/loader/stub/b:deleteFile	(Ljava/lang/String;)Z
    //   164: pop
    //   165: ldc2_w 281
    //   168: ldc_w 283
    //   171: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   174: return
    //   175: astore_2
    //   176: ldc 111
    //   178: ldc_w 301
    //   181: iconst_1
    //   182: anewarray 187	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_2
    //   188: invokestatic 297	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 215	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_1
    //   196: invokestatic 254	com/tencent/mm/loader/stub/b:deleteFile	(Ljava/lang/String;)Z
    //   199: pop
    //   200: goto -74 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	MMGIFImageView
    //   0	203	1	paramString1	String
    //   0	203	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   9	33	60	com/tencent/mm/plugin/gif/MMGIFException
    //   33	38	60	com/tencent/mm/plugin/gif/MMGIFException
    //   48	57	60	com/tencent/mm/plugin/gif/MMGIFException
    //   61	80	106	java/lang/Exception
    //   84	105	106	java/lang/Exception
    //   140	165	106	java/lang/Exception
    //   9	33	175	java/io/IOException
    //   33	38	175	java/io/IOException
    //   48	57	175	java/io/IOException
  }
  
  /* Error */
  public final void h(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 304
    //   3: ldc_w 306
    //   6: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_2
    //   10: invokestatic 70	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   13: ifne +35 -> 48
    //   16: aload_0
    //   17: aload_2
    //   18: putfield 72	com/tencent/mm/plugin/gif/MMGIFImageView:kGi	Ljava/lang/String;
    //   21: invokestatic 78	com/tencent/mm/plugin/gif/b:aCO	()Lcom/tencent/mm/plugin/gif/b;
    //   24: aload_0
    //   25: getfield 72	com/tencent/mm/plugin/gif/MMGIFImageView:kGi	Ljava/lang/String;
    //   28: aload_1
    //   29: invokevirtual 309	com/tencent/mm/plugin/gif/b:o	(Ljava/lang/String;[B)Lcom/tencent/mm/plugin/gif/a;
    //   32: astore_2
    //   33: aload_0
    //   34: aload_2
    //   35: invokevirtual 109	com/tencent/mm/plugin/gif/MMGIFImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   38: ldc2_w 304
    //   41: ldc_w 306
    //   44: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   47: return
    //   48: new 95	com/tencent/mm/plugin/gif/a
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 312	com/tencent/mm/plugin/gif/a:<init>	([B)V
    //   56: astore_2
    //   57: goto -24 -> 33
    //   60: astore_2
    //   61: aload_2
    //   62: invokestatic 196	com/tencent/mm/plugin/gif/MMGIFImageView:a	(Lcom/tencent/mm/plugin/gif/MMGIFException;)V
    //   65: aload_2
    //   66: invokevirtual 162	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   69: bipush 103
    //   71: if_icmpne +67 -> 138
    //   74: aload_1
    //   75: invokestatic 316	com/tencent/mm/sdk/platformtools/d:bd	([B)Landroid/graphics/Bitmap;
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +25 -> 105
    //   83: aload_2
    //   84: sipush 320
    //   87: invokevirtual 207	android/graphics/Bitmap:setDensity	(I)V
    //   90: aload_0
    //   91: aload_2
    //   92: invokevirtual 211	com/tencent/mm/plugin/gif/MMGIFImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   95: ldc2_w 304
    //   98: ldc_w 306
    //   101: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   104: return
    //   105: ldc 111
    //   107: ldc_w 318
    //   110: iconst_1
    //   111: anewarray 187	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: invokevirtual 319	java/lang/Object:toString	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 249	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: invokevirtual 218	com/tencent/mm/plugin/gif/MMGIFImageView:init	()V
    //   128: ldc2_w 304
    //   131: ldc_w 306
    //   134: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   137: return
    //   138: ldc 111
    //   140: ldc_w 321
    //   143: iconst_1
    //   144: anewarray 187	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_2
    //   150: invokevirtual 224	com/tencent/mm/plugin/gif/MMGIFException:toString	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 215	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: invokevirtual 218	com/tencent/mm/plugin/gif/MMGIFImageView:init	()V
    //   161: ldc2_w 304
    //   164: ldc_w 306
    //   167: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   170: return
    //   171: astore_1
    //   172: ldc 111
    //   174: ldc_w 321
    //   177: iconst_1
    //   178: anewarray 187	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_1
    //   184: invokevirtual 122	java/io/IOException:toString	()Ljava/lang/String;
    //   187: aastore
    //   188: invokestatic 215	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: goto -34 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	MMGIFImageView
    //   0	194	1	paramArrayOfByte	byte[]
    //   0	194	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	33	60	com/tencent/mm/plugin/gif/MMGIFException
    //   33	38	60	com/tencent/mm/plugin/gif/MMGIFException
    //   48	57	60	com/tencent/mm/plugin/gif/MMGIFException
    //   9	33	171	java/io/IOException
    //   33	38	171	java/io/IOException
    //   48	57	171	java/io/IOException
  }
  
  public final void init()
  {
    GMTrace.i(12898457878528L, 96101);
    this.mID = h.vI().isSDCardAvailable();
    if (this.mID)
    {
      if (this.mIB > 0)
      {
        super.setImageResource(this.mIB);
        GMTrace.o(12898457878528L, 96101);
      }
    }
    else if (this.mIC > 0) {
      super.setImageResource(this.mIC);
    }
    GMTrace.o(12898457878528L, 96101);
  }
  
  public final void recycle()
  {
    GMTrace.i(12899128967168L, 96106);
    if ((getDrawable() != null) && ((getDrawable() instanceof a))) {
      ((a)getDrawable()).recycle();
    }
    GMTrace.o(12899128967168L, 96106);
  }
  
  public final void resume()
  {
    GMTrace.i(12898860531712L, 96104);
    if ((getDrawable() != null) && ((getDrawable() instanceof a)))
    {
      a locala = (a)getDrawable();
      if (!locala.mHK)
      {
        locala.lp = true;
        locala.d(locala.mIg, 0L);
      }
    }
    GMTrace.o(12898860531712L, 96104);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    GMTrace.i(12897249918976L, 96092);
    a(getResources(), paramInt, false);
    GMTrace.o(12897249918976L, 96092);
  }
  
  public void setImageResource(int paramInt)
  {
    GMTrace.i(12897115701248L, 96091);
    a(getResources(), paramInt, true);
    GMTrace.o(12897115701248L, 96091);
  }
  
  public final void yh(String paramString)
  {
    GMTrace.i(12897384136704L, 96093);
    ct(paramString, null);
    GMTrace.o(12897384136704L, 96093);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gif/MMGIFImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */