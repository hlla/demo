package com.tencent.mm.plugin.photoedit.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import java.util.ArrayList;
import java.util.List;

public class c
  implements Cloneable
{
  public float gj;
  private com.tencent.mm.storage.a.c kNK;
  public boolean ksK;
  protected Context mContext;
  private Matrix mMatrix;
  private Rect ojB;
  public String okF;
  public Bitmap okG;
  public PointF okH;
  public int okI;
  private float okJ;
  public PointF okK;
  private float okL;
  private float okM;
  public boolean okN;
  public List<PointF> okO;
  public float okP;
  private float okQ;
  
  public c(Context paramContext, Matrix paramMatrix, String paramString, com.tencent.mm.storage.a.c paramc, Rect paramRect)
  {
    GMTrace.i(9918824316928L, 73901);
    this.okI = 0;
    this.gj = 1.0F;
    this.okJ = 1.0F;
    this.okN = false;
    this.okO = new ArrayList();
    this.okF = paramString;
    this.mMatrix = paramMatrix;
    this.kNK = paramc;
    this.mContext = paramContext;
    this.ojB = paramRect;
    this.okH = new PointF();
    this.okK = new PointF();
    GMTrace.o(9918824316928L, 73901);
  }
  
  private int aSA()
  {
    GMTrace.i(9919898058752L, 73909);
    if (this.okG != null)
    {
      int i = this.okG.getHeight();
      GMTrace.o(9919898058752L, 73909);
      return i;
    }
    GMTrace.o(9919898058752L, 73909);
    return 0;
  }
  
  private int aSz()
  {
    GMTrace.i(9919763841024L, 73908);
    if (this.okG != null)
    {
      int i = this.okG.getWidth();
      GMTrace.o(9919763841024L, 73908);
      return i;
    }
    GMTrace.o(9919763841024L, 73908);
    return 0;
  }
  
  private Bitmap w(Bitmap paramBitmap)
  {
    GMTrace.i(9920166494208L, 73911);
    int i = (int)(paramBitmap.getWidth() + 80.0F);
    int j = (int)(paramBitmap.getHeight() + 80.0F);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, 40.0F, 40.0F, null);
    paramBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.beG).getNinePatchChunk();
    paramBitmap = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), R.g.beG), paramBitmap, new Rect(), null);
    paramBitmap.setBounds(0, 0, i, j);
    paramBitmap.draw(localCanvas);
    GMTrace.o(9920166494208L, 73911);
    return localBitmap;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    GMTrace.i(9918958534656L, 73902);
    this.okG = w(aSB());
    this.okL = (1.2F * this.ojB.width() / this.okG.getWidth());
    this.okM = (0.1F * this.ojB.width() / this.okG.getWidth());
    this.okJ = paramFloat3;
    this.okI = paramInt;
    this.gj /= paramFloat3;
    v.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[] { Float.valueOf(this.okL), Float.valueOf(this.okM), Float.valueOf(this.okJ) });
    this.okH.set(paramFloat1, paramFloat2);
    v.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[] { this.okH });
    aSC();
    GMTrace.o(9918958534656L, 73902);
  }
  
  protected Bitmap aSB()
  {
    GMTrace.i(9920032276480L, 73910);
    com.tencent.mm.storage.a.c localc = this.kNK;
    Object localObject;
    int i;
    if (localc != null) {
      if ((localc.field_catalog == a.uJc) || (localc.field_catalog == com.tencent.mm.storage.a.c.uJi) || (localc.field_catalog == com.tencent.mm.storage.a.c.uJh))
      {
        localObject = localc.getName();
        if (!bf.mA((String)localObject))
        {
          if (((String)localObject).startsWith("jsb")) {
            localObject = "jsb";
          }
          for (;;)
          {
            i = this.mContext.getResources().getIdentifier((String)localObject, "drawable", aa.getPackageName());
            localObject = com.tencent.mm.sdk.platformtools.d.t(this.mContext.getResources().getDrawable(i));
            v.i("MicroMsg.EmojiItem", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(localc.field_catalog), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
            GMTrace.o(9920032276480L, 73910);
            return (Bitmap)localObject;
            if (((String)localObject).startsWith("dice")) {
              localObject = "dice";
            } else {
              localObject = ((String)localObject).replaceAll(".png", "");
            }
          }
        }
        v.i("MicroMsg.EmojiItem", "name is null");
        v.i("MicroMsg.EmojiItem", "emoji:%s", new Object[] { localc });
      }
    }
    for (;;)
    {
      GMTrace.o(9920032276480L, 73910);
      return null;
      if (localc.field_catalog == a.uJb)
      {
        localObject = localc.getName();
        if (!bf.mA((String)localObject)) {
          if (bf.mA(localc.pM()))
          {
            localObject = localc.getName();
            localObject = ((String)localObject).replaceAll(".png", "");
          }
        }
        for (;;)
        {
          v.i("MicroMsg.EmojiItem", "[addEmoji] drawable name:%s", new Object[] { localObject });
          i = this.mContext.getResources().getIdentifier((String)localObject, "drawable", aa.getPackageName());
          localObject = com.tencent.mm.sdk.platformtools.d.t(this.mContext.getResources().getDrawable(i));
          v.i("MicroMsg.EmojiItem", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(localc.field_catalog), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          GMTrace.o(9920032276480L, 73910);
          return (Bitmap)localObject;
          localObject = localc.pM();
          break;
          v.i("MicroMsg.EmojiItem", "name is null");
        }
      }
      localObject = localc.eN(localc.field_groupId, localc.EQ()) + "_cover";
      boolean bool = e.aO((String)localObject);
      v.i("MicroMsg.EmojiItem", "[addEmoji] thumbPath:%s isExist:%s", new Object[] { localObject, Boolean.valueOf(bool) });
      if (!bool)
      {
        localObject = localc.eN(localc.field_groupId, localc.EQ());
        bool = e.aO((String)localObject);
        if (bool)
        {
          localObject = ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(localc);
          v.i("MicroMsg.EmojiItem", "bytes size:%s", new Object[] { Integer.valueOf(localObject.length) });
          localObject = com.tencent.mm.sdk.platformtools.d.decodeByteArray((byte[])localObject, 480, 480);
          if (localObject != null) {
            v.i("MicroMsg.EmojiItem", "emoji:%s width:%s height:%s", new Object[] { localc, Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
          }
          GMTrace.o(9920032276480L, 73910);
          return (Bitmap)localObject;
        }
        v.w("MicroMsg.EmojiItem", "[addEmoji] Path:%s isExist:%s", new Object[] { localObject, Boolean.valueOf(bool) });
        break;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile((String)localObject, localOptions);
      if ((localOptions.outHeight < 480) && (localOptions.outWidth < 480)) {}
      for (localObject = com.tencent.mm.sdk.platformtools.d.N((String)localObject, localOptions.outHeight, localOptions.outWidth);; localObject = com.tencent.mm.sdk.platformtools.d.N((String)localObject, 480, 480))
      {
        v.i("MicroMsg.EmojiItem", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(localc.field_catalog), Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        GMTrace.o(9920032276480L, 73910);
        return (Bitmap)localObject;
      }
      v.e("MicroMsg.EmojiItem", "emoji == null!");
    }
  }
  
  public final void aSC()
  {
    GMTrace.i(9920300711936L, 73912);
    double d1 = aSz() / 2;
    double d2 = aSA() / 2;
    this.okQ = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.okQ *= this.gj / this.okJ;
    this.okP = ((float)Math.toDegrees(Math.atan(d2 / d1)));
    GMTrace.o(9920300711936L, 73912);
  }
  
  public final c aSD()
  {
    GMTrace.i(9920569147392L, 73914);
    for (;;)
    {
      try
      {
        c localc = (c)super.clone();
        v.printErrStackTrace("MicroMsg.EmojiItem", localCloneNotSupportedException1, "", new Object[0]);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        try
        {
          localc.okH = new PointF(this.okH.x, this.okH.y);
          localc.kNK = this.kNK;
          GMTrace.o(9920569147392L, 73914);
          return localc;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException2)
        {
          for (;;) {}
        }
        localCloneNotSupportedException1 = localCloneNotSupportedException1;
        localc = null;
      }
    }
  }
  
  public final boolean aSy()
  {
    GMTrace.i(9919092752384L, 73903);
    v.d("MicroMsg.EmojiItem", "[checkBitmap]");
    if ((this.okG == null) || (this.okG.isRecycled()))
    {
      this.okG = w(aSB());
      GMTrace.o(9919092752384L, 73903);
      return true;
    }
    GMTrace.o(9919092752384L, 73903);
    return false;
  }
  
  public PointF ac(float paramFloat)
  {
    GMTrace.i(9920434929664L, 73913);
    PointF localPointF = new PointF();
    double d1 = (this.okI + paramFloat) * 3.141592653589793D / 180.0D;
    localPointF.x = (this.okH.x + (float)(this.okQ * Math.cos(d1)));
    paramFloat = this.okH.y;
    double d2 = this.okQ;
    localPointF.y = (paramFloat + (float)(Math.sin(d1) * d2));
    GMTrace.o(9920434929664L, 73913);
    return localPointF;
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    GMTrace.i(9919361187840L, 73905);
    this.okH.offset(paramFloat1, paramFloat2);
    if (0.0F != paramFloat3) {
      this.gj = paramFloat3;
    }
    this.okI = paramInt;
    GMTrace.o(9919361187840L, 73905);
  }
  
  public final void clear()
  {
    GMTrace.i(9919495405568L, 73906);
    v.i("MicroMsg.EmojiItem", "[clear]");
    if ((this.okG != null) && (!this.okG.isRecycled())) {
      this.okG.recycle();
    }
    GMTrace.o(9919495405568L, 73906);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    GMTrace.i(9919629623296L, 73907);
    if (this.okG == null)
    {
      v.w("MicroMsg.EmojiItem", "[draw] null == mEmojiBoxBmp");
      GMTrace.o(9919629623296L, 73907);
      return;
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    if (this.okL < this.gj * this.okJ)
    {
      this.gj = (this.okL / this.okJ);
      paramCanvas.save();
      paramCanvas.translate(this.okH.x, this.okH.y);
      paramCanvas.rotate(this.okI);
      paramCanvas.scale(this.gj, this.gj);
      if (!this.ksK) {
        break label205;
      }
      paramCanvas.drawBitmap(this.okG, -aSz() / 2, -aSA() / 2, null);
    }
    for (;;)
    {
      paramCanvas.restore();
      paramCanvas.setDrawFilter(null);
      GMTrace.o(9919629623296L, 73907);
      return;
      if (this.okM <= this.gj * this.okJ) {
        break;
      }
      this.gj = (this.okM / this.okJ);
      break;
      label205:
      paramCanvas.clipRect(-aSz() / 2 + 40.0F, -aSA() / 2 + 40.0F, this.okG.getWidth() / 2 - 40.0F, this.okG.getHeight() / 2 - 40.0F);
      paramCanvas.drawBitmap(this.okG, -aSz() / 2, -aSA() / 2, null);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    GMTrace.i(9919226970112L, 73904);
    this.ksK = paramBoolean;
    GMTrace.o(9919226970112L, 73904);
  }
  
  public String toString()
  {
    GMTrace.i(9920703365120L, 73915);
    String str = "mEmojiId:" + this.okF + "\n" + this.kNK.toString();
    GMTrace.o(9920703365120L, 73915);
    return str;
  }
  
  private final class a
  {
    public float[] okR;
    public float[] okS;
    public int okT;
    
    public a()
    {
      GMTrace.i(9918690099200L, 73900);
      Object localObject;
      this.okT = ((List)localObject).size();
      this.okR = new float[this.okT];
      this.okS = new float[this.okT];
      int i = 0;
      while (i < this.okT)
      {
        this.okR[i] = ((PointF)((List)localObject).get(i)).x;
        this.okS[i] = ((PointF)((List)localObject).get(i)).y;
        i += 1;
      }
      new StringBuilder("lasso size:").append(this.okT);
      GMTrace.o(9918690099200L, 73900);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */