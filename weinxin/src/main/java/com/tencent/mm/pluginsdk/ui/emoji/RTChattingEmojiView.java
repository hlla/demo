package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import java.lang.ref.WeakReference;

public class RTChattingEmojiView
  extends FrameLayout
{
  private com.tencent.mm.storage.a.c kNK;
  private int mStatus;
  private TextView rbN;
  private int sPX;
  private int sPY;
  private int sPZ;
  private int sQa;
  private int sQb;
  public ChattingEmojiView sQc;
  private ProgressBar sQd;
  private FrameLayout.LayoutParams sQe;
  FrameLayout.LayoutParams sQf;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1196551045120L, 8915);
    this.mStatus = -1;
    GMTrace.o(1196551045120L, 8915);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1196685262848L, 8916);
    this.mStatus = -1;
    GMTrace.o(1196685262848L, 8916);
  }
  
  private void bGc()
  {
    GMTrace.i(1197490569216L, 8922);
    ci localci = new ci();
    localci.fFE.fFF = this.kNK;
    localci.fFE.scene = 0;
    a.uql.m(localci);
    GMTrace.o(1197490569216L, 8922);
  }
  
  private void xI(int paramInt)
  {
    GMTrace.i(1197624786944L, 8923);
    this.mStatus = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1197624786944L, 8923);
      return;
      this.sQd.setVisibility(0);
      this.rbN.setVisibility(4);
      this.sQc.setVisibility(4);
      setBackgroundResource(a.d.bkQ);
      GMTrace.o(1197624786944L, 8923);
      return;
      this.sQd.setVisibility(0);
      this.rbN.setVisibility(4);
      this.sQc.setVisibility(4);
      setBackgroundResource(a.d.kYq);
      GMTrace.o(1197624786944L, 8923);
      return;
      Drawable localDrawable = getResources().getDrawable(a.d.kYs);
      localDrawable.setBounds(0, 0, this.sPZ, this.sPZ);
      v.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.sPZ), Integer.valueOf(hashCode()) });
      this.rbN.setCompoundDrawables(null, localDrawable, null, null);
      this.rbN.setText(a.g.kYz);
      this.rbN.setVisibility(0);
      this.sQd.setVisibility(4);
      this.sQc.setVisibility(4);
      setBackgroundResource(a.d.kYq);
      GMTrace.o(1197624786944L, 8923);
      return;
      this.sQc.setVisibility(0);
      this.sQd.setVisibility(4);
      this.rbN.setVisibility(4);
      setBackgroundResource(a.d.bkQ);
    }
  }
  
  public void KD()
  {
    GMTrace.i(1196819480576L, 8917);
    this.sPX = getContext().getResources().getDimensionPixelSize(a.c.kBL);
    this.sPY = getContext().getResources().getDimensionPixelSize(a.c.kYm);
    this.sQa = getContext().getResources().getDimensionPixelSize(a.c.kYp);
    this.sQb = getContext().getResources().getDimensionPixelSize(a.c.kYo);
    this.sQc = new ChattingEmojiView(getContext());
    this.sQd = new ProgressBar(getContext());
    this.sQd.setIndeterminateDrawable(getResources().getDrawable(a.d.kYt));
    this.rbN = new TextView(getContext());
    this.rbN.setText(a.g.kYz);
    this.rbN.setTextColor(getResources().getColor(a.b.kYk));
    this.sQe = new FrameLayout.LayoutParams(-2, -2);
    this.sQf = new FrameLayout.LayoutParams(-2, -2);
    this.sQe.gravity = 17;
    addView(this.sQd, this.sQe);
    addView(this.rbN, this.sQe);
    GMTrace.o(1196819480576L, 8917);
  }
  
  public final void a(com.tencent.mm.storage.a.c paramc, long paramLong)
  {
    GMTrace.i(1196953698304L, 8918);
    a(paramc, paramLong, new aj(""));
    GMTrace.o(1196953698304L, 8918);
  }
  
  public final void a(com.tencent.mm.storage.a.c paramc, long paramLong, aj paramaj)
  {
    GMTrace.i(1197087916032L, 8919);
    v.d("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo");
    this.kNK = paramc;
    ChattingEmojiView localChattingEmojiView;
    boolean bool;
    int i;
    int[] arrayOfInt;
    String str1;
    String str2;
    b localb;
    Context localContext;
    if (this.kNK.bCM())
    {
      xI(2);
      localChattingEmojiView = this.sQc;
      if (!paramaj.hZO) {}
      for (bool = true;; bool = false)
      {
        i = ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().e(paramc);
        arrayOfInt = ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().f(paramc);
        str1 = paramc.getName();
        str2 = String.valueOf(paramLong + paramc.getName());
        if (bf.mA(str2)) {
          break label322;
        }
        localChattingEmojiView.kGi = str2;
        localb = b.aCO();
        localContext = localChattingEmojiView.getContext();
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
        paramc = null;
        if (bool != paramc.mIw) {
          break label300;
        }
        paramc.start();
        label176:
        localChattingEmojiView.setImageDrawable(paramc);
        GMTrace.o(1197087916032L, 8919);
        return;
      }
      if ((localb.mIn.get(str2) == null) || (((WeakReference)localb.mIn.get(str2)).get() == null)) {
        break label585;
      }
    }
    label300:
    label322:
    label585:
    for (paramaj = (com.tencent.mm.plugin.gif.c)((WeakReference)localb.mIn.get(str2)).get();; paramaj = null)
    {
      paramc = paramaj;
      if (paramaj != null) {
        break;
      }
      paramc = new com.tencent.mm.plugin.gif.c(localContext, false, bool, i, arrayOfInt, str1);
      localb.mIn.put(str2, new WeakReference(paramc));
      break;
      paramc.kXF = 0;
      paramc.mIy = 0;
      paramc.mIw = true;
      paramc.start();
      break label176;
      paramc = new com.tencent.mm.plugin.gif.c(localChattingEmojiView.getContext(), false, bool, i, arrayOfInt, str1);
      paramc.start();
      localChattingEmojiView.setImageDrawable(paramc);
      GMTrace.o(1197087916032L, 8919);
      return;
      if (this.kNK.bNj())
      {
        xI(2);
        this.sQc.a(com.tencent.mm.storage.a.c.bb(getContext(), paramc.getName()), String.valueOf(paramLong));
        GMTrace.o(1197087916032L, 8919);
        return;
      }
      paramaj = this.kNK.eN(this.kNK.field_groupId, this.kNK.EQ());
      if (e.aN(paramaj) > 0)
      {
        xI(2);
        paramc = e.c(paramaj, 0, 10);
        if ((paramc != null) && (!o.bg(paramc)))
        {
          this.sQc.a(this.kNK, ((PluginEmoji)h.j(PluginEmoji.class)).getEmojiMgr().g(this.kNK), String.valueOf(paramLong));
          GMTrace.o(1197087916032L, 8919);
          return;
        }
        this.sQc.cs(paramaj, String.valueOf(paramLong));
        GMTrace.o(1197087916032L, 8919);
        return;
      }
      if (paramc.field_state == com.tencent.mm.storage.a.c.uJt)
      {
        xI(0);
        bGc();
      }
      for (;;)
      {
        this.sQc.setImageBitmap(null);
        GMTrace.o(1197087916032L, 8919);
        return;
        xI(3);
        bGc();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    GMTrace.i(1197893222400L, 8925);
    super.onAttachedToWindow();
    GMTrace.o(1197893222400L, 8925);
  }
  
  protected void onDetachedFromWindow()
  {
    GMTrace.i(1198027440128L, 8926);
    super.onDetachedFromWindow();
    GMTrace.o(1198027440128L, 8926);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1197759004672L, 8924);
    if ((this.mStatus == 0) || (this.mStatus == 1) || (this.mStatus == 3))
    {
      if ((this.kNK != null) && (this.kNK.field_height != 0))
      {
        paramInt1 = (int)(this.kNK.field_height * this.sQc.aCN());
        if (paramInt1 < this.sPY) {}
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 > this.sPX) {
          paramInt2 = this.sPX;
        }
        this.sPZ = this.sQa;
        if ((paramInt2 >= this.sPY) && (paramInt2 < this.sPY + (this.sQa - this.sQb))) {
          this.sPZ = (this.sQb + (paramInt2 - this.sPY));
        }
        paramInt1 = this.sPX;
        setMeasuredDimension(paramInt1, paramInt2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        xI(this.mStatus);
        GMTrace.o(1197759004672L, 8924);
        return;
        paramInt1 = this.sPY;
        continue;
        paramInt1 = this.sPY;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    GMTrace.o(1197759004672L, 8924);
  }
  
  public boolean performClick()
  {
    GMTrace.i(1197356351488L, 8921);
    if (this.mStatus == 3)
    {
      xI(1);
      bGc();
      GMTrace.o(1197356351488L, 8921);
      return true;
    }
    if (this.mStatus == 2)
    {
      boolean bool = super.performClick();
      GMTrace.o(1197356351488L, 8921);
      return bool;
    }
    v.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
    GMTrace.o(1197356351488L, 8921);
    return true;
  }
  
  public final void setImageBitmap(Bitmap paramBitmap)
  {
    GMTrace.i(1197222133760L, 8920);
    xI(2);
    if ((this.sQc != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(320);
      this.sQc.setImageBitmap(paramBitmap);
    }
    GMTrace.o(1197222133760L, 8920);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/emoji/RTChattingEmojiView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */