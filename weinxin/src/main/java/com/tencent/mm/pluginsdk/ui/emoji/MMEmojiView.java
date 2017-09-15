package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.storage.a.c;

public class MMEmojiView
  extends MMGIFImageView
{
  private c kNK;
  private int mScreenWidth;
  private int sPO;
  private int sPP;
  boolean sPQ;
  
  public MMEmojiView(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(1195611521024L, 8908);
    init(paramContext);
    GMTrace.o(1195611521024L, 8908);
  }
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    GMTrace.i(1195745738752L, 8909);
    init(paramContext);
    GMTrace.o(1195745738752L, 8909);
  }
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1195879956480L, 8910);
    this.sPQ = false;
    init(paramContext);
    GMTrace.o(1195879956480L, 8910);
  }
  
  private void init(Context paramContext)
  {
    GMTrace.i(1196014174208L, 8911);
    this.sPO = paramContext.getResources().getDimensionPixelSize(a.c.kBL);
    this.sPP = paramContext.getResources().getDimensionPixelSize(a.c.kYn);
    this.mScreenWidth = a.dO(paramContext);
    GMTrace.o(1196014174208L, 8911);
  }
  
  public final void a(c paramc, String paramString)
  {
    GMTrace.i(1196148391936L, 8912);
    this.kNK = paramc;
    String str = paramc.eN(paramc.field_groupId, paramc.EQ());
    if ((paramc.field_reserved4 & c.uJy) == c.uJy)
    {
      if (b.aCO().yf(paramString) != null)
      {
        setImageDrawable(b.aCO().yf(paramString));
        GMTrace.o(1196148391936L, 8912);
        return;
      }
      a(this.kNK, ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().g(this.kNK), paramString);
      GMTrace.o(1196148391936L, 8912);
      return;
    }
    cs(str, paramString);
    GMTrace.o(1196148391936L, 8912);
  }
  
  /* Error */
  public final void a(c paramc, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 146
    //   3: sipush 8913
    //   6: invokestatic 25	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 82	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:kNK	Lcom/tencent/mm/storage/a/c;
    //   14: aload_2
    //   15: invokestatic 153	com/tencent/mm/sdk/platformtools/bf:bm	([B)Z
    //   18: ifne +198 -> 216
    //   21: aload_3
    //   22: invokestatic 157	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   25: ifne +35 -> 60
    //   28: aload_0
    //   29: aload_3
    //   30: putfield 160	com/tencent/mm/plugin/gif/MMGIFImageView:kGi	Ljava/lang/String;
    //   33: invokestatic 108	com/tencent/mm/plugin/gif/b:aCO	()Lcom/tencent/mm/plugin/gif/b;
    //   36: aload_0
    //   37: getfield 160	com/tencent/mm/plugin/gif/MMGIFImageView:kGi	Ljava/lang/String;
    //   40: aload_2
    //   41: invokevirtual 163	com/tencent/mm/plugin/gif/b:o	(Ljava/lang/String;[B)Lcom/tencent/mm/plugin/gif/a;
    //   44: astore_1
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 116	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   50: ldc2_w 146
    //   53: sipush 8913
    //   56: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   59: return
    //   60: new 165	com/tencent/mm/plugin/gif/a
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 168	com/tencent/mm/plugin/gif/a:<init>	([B)V
    //   68: astore_1
    //   69: goto -24 -> 45
    //   72: astore_1
    //   73: aload_1
    //   74: invokestatic 171	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:a	(Lcom/tencent/mm/plugin/gif/MMGIFException;)V
    //   77: aload_1
    //   78: invokevirtual 175	com/tencent/mm/plugin/gif/MMGIFException:getErrorCode	()I
    //   81: bipush 103
    //   83: if_icmpne +94 -> 177
    //   86: ldc -79
    //   88: ldc -77
    //   90: invokestatic 184	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_2
    //   94: invokestatic 190	com/tencent/mm/sdk/platformtools/d:bd	([B)Landroid/graphics/Bitmap;
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +25 -> 124
    //   102: aload_1
    //   103: sipush 320
    //   106: invokevirtual 196	android/graphics/Bitmap:setDensity	(I)V
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 200	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   114: ldc2_w 146
    //   117: sipush 8913
    //   120: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   123: return
    //   124: ldc -79
    //   126: ldc -54
    //   128: iconst_1
    //   129: anewarray 204	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_2
    //   135: invokevirtual 207	java/lang/Object:toString	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 211	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_0
    //   143: getfield 82	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:kNK	Lcom/tencent/mm/storage/a/c;
    //   146: ifnull +17 -> 163
    //   149: aload_0
    //   150: getfield 82	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:kNK	Lcom/tencent/mm/storage/a/c;
    //   153: invokevirtual 215	com/tencent/mm/storage/a/c:bNi	()V
    //   156: ldc -79
    //   158: ldc -39
    //   160: invokestatic 219	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokevirtual 221	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:init	()V
    //   167: ldc2_w 146
    //   170: sipush 8913
    //   173: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   176: return
    //   177: ldc -79
    //   179: ldc -33
    //   181: iconst_1
    //   182: anewarray 204	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_1
    //   188: invokevirtual 224	com/tencent/mm/plugin/gif/MMGIFException:toString	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 227	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload_0
    //   196: getfield 82	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:kNK	Lcom/tencent/mm/storage/a/c;
    //   199: ifnull +17 -> 216
    //   202: aload_0
    //   203: getfield 82	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:kNK	Lcom/tencent/mm/storage/a/c;
    //   206: invokevirtual 215	com/tencent/mm/storage/a/c:bNi	()V
    //   209: ldc -79
    //   211: ldc -39
    //   213: invokestatic 219	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_0
    //   217: getfield 82	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:kNK	Lcom/tencent/mm/storage/a/c;
    //   220: ifnull +17 -> 237
    //   223: aload_0
    //   224: getfield 82	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:kNK	Lcom/tencent/mm/storage/a/c;
    //   227: invokevirtual 215	com/tencent/mm/storage/a/c:bNi	()V
    //   230: ldc -79
    //   232: ldc -39
    //   234: invokestatic 219	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_0
    //   238: invokevirtual 221	com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView:init	()V
    //   241: ldc2_w 146
    //   244: sipush 8913
    //   247: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   250: return
    //   251: astore_1
    //   252: ldc -79
    //   254: ldc -33
    //   256: iconst_1
    //   257: anewarray 204	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_1
    //   263: invokevirtual 228	java/io/IOException:toString	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 227	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: goto -54 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	MMEmojiView
    //   0	273	1	paramc	c
    //   0	273	2	paramArrayOfByte	byte[]
    //   0	273	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   14	45	72	com/tencent/mm/plugin/gif/MMGIFException
    //   45	50	72	com/tencent/mm/plugin/gif/MMGIFException
    //   60	69	72	com/tencent/mm/plugin/gif/MMGIFException
    //   14	45	251	java/io/IOException
    //   45	50	251	java/io/IOException
    //   60	69	251	java/io/IOException
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    GMTrace.i(1196416827392L, 8914);
    super.onMeasure(paramInt1, paramInt2);
    int i;
    label35:
    float f;
    if (getDrawable() == null)
    {
      i = 0;
      if (getDrawable() != null) {
        break label237;
      }
      paramInt2 = i;
      paramInt1 = j;
      if (this.kNK != null)
      {
        paramInt2 = i;
        paramInt1 = j;
        if (i == 0)
        {
          paramInt2 = i;
          paramInt1 = j;
          if (j == 0)
          {
            paramInt2 = (int)(this.kNK.field_width * aCN());
            paramInt1 = (int)(this.kNK.field_height * aCN());
          }
        }
      }
      if (paramInt1 >= this.sPP)
      {
        i = paramInt2;
        j = paramInt1;
        if (paramInt2 >= this.sPP) {}
      }
      else
      {
        if (paramInt2 >= paramInt1) {
          break label249;
        }
        f = this.sPP / paramInt2;
        i = this.sPP;
        j = (int)(paramInt1 * f);
      }
      label149:
      if (!this.sPQ) {
        break label339;
      }
      if (i <= this.sPO)
      {
        paramInt1 = i;
        paramInt2 = j;
        if (j <= this.sPO) {}
      }
      else
      {
        if (i <= j) {
          break label294;
        }
        f = this.sPO / i;
        paramInt1 = this.sPO;
        paramInt2 = (int)(j * f);
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      GMTrace.o(1196416827392L, 8914);
      return;
      i = getDrawable().getIntrinsicWidth();
      break;
      label237:
      j = getDrawable().getIntrinsicHeight();
      break label35;
      label249:
      if (paramInt1 < paramInt2)
      {
        f = this.sPP / paramInt1;
        j = this.sPP;
        i = (int)(paramInt2 * f);
        break label149;
      }
      j = this.sPP;
      i = this.sPP;
      break label149;
      label294:
      if (j > i)
      {
        f = this.sPO / j;
        paramInt2 = this.sPO;
        paramInt1 = (int)(i * f);
      }
      else
      {
        paramInt1 = this.sPO;
        paramInt2 = this.sPO;
        continue;
        label339:
        if (i <= this.mScreenWidth)
        {
          paramInt1 = i;
          paramInt2 = j;
          if (j <= this.mScreenWidth) {}
        }
        else if (i > j)
        {
          f = this.mScreenWidth / i;
          paramInt1 = this.mScreenWidth;
          paramInt2 = (int)(j * f);
        }
        else if (j > i)
        {
          f = this.mScreenWidth / j;
          paramInt2 = this.mScreenWidth;
          paramInt1 = (int)(i * f);
        }
        else
        {
          paramInt1 = this.mScreenWidth;
          paramInt2 = this.mScreenWidth;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/emoji/MMEmojiView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */