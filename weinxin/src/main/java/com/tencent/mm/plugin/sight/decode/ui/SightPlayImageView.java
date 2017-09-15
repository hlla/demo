package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.af.a.a;
import com.tencent.mm.plugin.af.a.d;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class SightPlayImageView
  extends QPictureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  public b ptA;
  private int ptC;
  private int ptD;
  private int ptE;
  private int ptF;
  public f.a ptG;
  public boolean ptH;
  private boolean ptI;
  public boolean ptJ;
  
  public SightPlayImageView(Context paramContext)
  {
    this(paramContext, null, 0);
    GMTrace.i(9242366967808L, 68861);
    GMTrace.o(9242366967808L, 68861);
  }
  
  public SightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(9242232750080L, 68860);
    GMTrace.o(9242232750080L, 68860);
  }
  
  public SightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(9242098532352L, 68859);
    this.ptH = true;
    this.ptI = false;
    this.ptJ = false;
    this.ptA = new a(this);
    v.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { new ag().toString() });
    GMTrace.o(9242098532352L, 68859);
  }
  
  public final void B(Bitmap paramBitmap)
  {
    GMTrace.i(9242903838720L, 68865);
    super.setImageBitmap(paramBitmap);
    GMTrace.o(9242903838720L, 68865);
  }
  
  public final String Lt()
  {
    GMTrace.i(9242501185536L, 68862);
    String str = this.ptA.psm;
    GMTrace.o(9242501185536L, 68862);
    return str;
  }
  
  public final void a(b.e parame)
  {
    GMTrace.i(9245051322368L, 68881);
    this.ptA.psS = parame;
    GMTrace.o(9245051322368L, 68881);
  }
  
  public final void a(b.f paramf)
  {
    GMTrace.i(9245319757824L, 68883);
    this.ptA.psT = paramf;
    GMTrace.o(9245319757824L, 68883);
  }
  
  public final void ak(String paramString, boolean paramBoolean)
  {
    GMTrace.i(9243172274176L, 68867);
    this.ptA.ak(paramString, paramBoolean);
    GMTrace.o(9243172274176L, 68867);
  }
  
  public final void bbK()
  {
    GMTrace.i(9244246016000L, 68875);
    this.ptI = true;
    if ((this.ptF > 0) && (this.ptE > 0)) {
      if (this.ptE < this.ptF) {
        break label127;
      }
    }
    label127:
    for (this.ptC = com.tencent.mm.bg.a.fromDPToPix(getContext(), 150);; this.ptC = com.tencent.mm.bg.a.fromDPToPix(getContext(), 85))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.ptD = (this.ptC * this.ptF / this.ptE);
      if ((localLayoutParams.width != this.ptC) || (localLayoutParams.height != this.ptD))
      {
        localLayoutParams.width = this.ptC;
        localLayoutParams.height = this.ptD;
        setLayoutParams(localLayoutParams);
      }
      GMTrace.o(9244246016000L, 68875);
      return;
    }
  }
  
  public final void bbL()
  {
    GMTrace.i(9244111798272L, 68874);
    setImageBitmap(null);
    setImageResource(a.d.bhN);
    GMTrace.o(9244111798272L, 68874);
  }
  
  public final Object bbM()
  {
    GMTrace.i(9244514451456L, 68877);
    Object localObject = getTag();
    GMTrace.o(9244514451456L, 68877);
    return localObject;
  }
  
  public final Context bbN()
  {
    GMTrace.i(9244648669184L, 68878);
    Context localContext = getContext();
    GMTrace.o(9244648669184L, 68878);
    return localContext;
  }
  
  public final boolean bbO()
  {
    GMTrace.i(9243306491904L, 68868);
    boolean bool = this.ptA.bbT();
    GMTrace.o(9243306491904L, 68868);
    return bool;
  }
  
  public final void bbP()
  {
    GMTrace.i(9245856628736L, 68887);
    GMTrace.o(9245856628736L, 68887);
  }
  
  public final void bbQ()
  {
    GMTrace.i(9245185540096L, 68882);
    this.ptA.psU = null;
    GMTrace.o(9245185540096L, 68882);
  }
  
  public final void bi(Object paramObject)
  {
    GMTrace.i(9244380233728L, 68876);
    setTag(paramObject);
    GMTrace.o(9244380233728L, 68876);
  }
  
  public void cR(int paramInt1, int paramInt2)
  {
    GMTrace.i(9244782886912L, 68879);
    this.ptH = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.ptC = paramInt1;
    this.ptD = (this.ptC * paramInt2 / paramInt1);
    localLayoutParams.width = this.ptC;
    localLayoutParams.height = this.ptD;
    setLayoutParams(localLayoutParams);
    postInvalidate();
    GMTrace.o(9244782886912L, 68879);
  }
  
  public final void clear()
  {
    GMTrace.i(9243038056448L, 68866);
    this.ptA.clear();
    GMTrace.o(9243038056448L, 68866);
  }
  
  public final void g(TextView paramTextView)
  {
    GMTrace.i(9245453975552L, 68884);
    this.ptA.g(paramTextView);
    GMTrace.o(9245453975552L, 68884);
  }
  
  public final void gY(boolean paramBoolean)
  {
    GMTrace.i(9244917104640L, 68880);
    this.ptA.psH = paramBoolean;
    GMTrace.o(9244917104640L, 68880);
  }
  
  public int getDuration()
  {
    GMTrace.i(9246125064192L, 68889);
    if (this.ptA == null)
    {
      GMTrace.o(9246125064192L, 68889);
      return 0;
    }
    int i = (int)this.ptA.bbX();
    GMTrace.o(9246125064192L, 68889);
    return i;
  }
  
  public final void ha(boolean paramBoolean)
  {
    GMTrace.i(9245588193280L, 68885);
    b localb = this.ptA;
    v.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.psB == null)
      {
        localb.psB = new b.i(localb);
        GMTrace.o(9245588193280L, 68885);
      }
    }
    else
    {
      if (localb.psB != null)
      {
        localb.psB.type = 0;
        o.b(localb.psB, 0L);
      }
      localb.psB = null;
    }
    GMTrace.o(9245588193280L, 68885);
  }
  
  public final void kf(int paramInt)
  {
    GMTrace.i(9243440709632L, 68869);
    this.ptA.position = paramInt;
    GMTrace.o(9243440709632L, 68869);
  }
  
  protected void onAttachedToWindow()
  {
    GMTrace.i(9243709145088L, 68871);
    v.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.uql.b(this.ptA.bbW());
    GMTrace.o(9243709145088L, 68871);
  }
  
  protected void onDetachedFromWindow()
  {
    GMTrace.i(9243574927360L, 68870);
    super.onDetachedFromWindow();
    v.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ptA.clear();
    com.tencent.mm.sdk.b.a.uql.c(this.ptA.bbW());
    GMTrace.o(9243574927360L, 68870);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(9246259281920L, 68890);
    super.onDraw(paramCanvas);
    GMTrace.o(9246259281920L, 68890);
  }
  
  public void sB(int paramInt)
  {
    GMTrace.i(9243843362816L, 68872);
    this.ptH = false;
    this.ptC = paramInt;
    if ((this.ptE > 0) && (this.ptF > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.ptD = (this.ptC * this.ptF / this.ptE);
      if ((localLayoutParams.width != this.ptC) || (localLayoutParams.height != this.ptD))
      {
        localLayoutParams.width = this.ptC;
        localLayoutParams.height = this.ptD;
        setLayoutParams(localLayoutParams);
      }
    }
    GMTrace.o(9243843362816L, 68872);
  }
  
  public final void setImageBitmap(Bitmap paramBitmap)
  {
    GMTrace.i(9242635403264L, 68863);
    super.setImageBitmap(paramBitmap);
    if (this.ptJ)
    {
      GMTrace.o(9242635403264L, 68863);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.ptD == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label154;
        }
        if (this.ptC != 0) {
          break label145;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != this.ptC * i / j)
      {
        paramBitmap.width = this.ptC;
        float f = this.ptC;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      GMTrace.o(9242635403264L, 68863);
      return;
      i = this.ptD;
      break;
      i = paramBitmap.getHeight();
      break;
      label145:
      j = this.ptC;
      continue;
      label154:
      j = paramBitmap.getWidth();
    }
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    GMTrace.i(9242769620992L, 68864);
    super.setImageDrawable(paramDrawable);
    if (this.ptJ)
    {
      GMTrace.o(9242769620992L, 68864);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.ptD == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label164;
        }
        if (this.ptC != 0) {
          break label155;
        }
        j = 320;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        paramDrawable = getLayoutParams();
        if (paramDrawable.height != this.ptC * i / j)
        {
          paramDrawable.width = this.ptC;
          float f = this.ptC;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      GMTrace.o(9242769620992L, 68864);
      return;
      i = this.ptD;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label155:
      j = this.ptC;
      continue;
      label164:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public final void y(Bitmap paramBitmap)
  {
    GMTrace.i(9243977580544L, 68873);
    setImageBitmap(paramBitmap);
    GMTrace.o(9243977580544L, 68873);
  }
  
  private static final class a
    extends b
  {
    private WeakReference<SightPlayImageView> ptB;
    
    public a(SightPlayImageView paramSightPlayImageView)
    {
      super(paramSightPlayImageView);
      GMTrace.i(9248138330112L, 68904);
      this.ptB = new WeakReference(paramSightPlayImageView);
      GMTrace.o(9248138330112L, 68904);
    }
    
    public final void A(Bitmap paramBitmap)
    {
      GMTrace.i(9248406765568L, 68906);
      SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.ptB.get();
      if (localSightPlayImageView == null)
      {
        v.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        GMTrace.o(9248406765568L, 68906);
        return;
      }
      localSightPlayImageView.setImageBitmap(paramBitmap);
      GMTrace.o(9248406765568L, 68906);
    }
    
    protected final int bbR()
    {
      GMTrace.i(9248004112384L, 68903);
      int i = a.a.aRJ;
      GMTrace.o(9248004112384L, 68903);
      return i;
    }
    
    public final void bp(int paramInt1, int paramInt2)
    {
      GMTrace.i(9248272547840L, 68905);
      final SightPlayImageView localSightPlayImageView = (SightPlayImageView)this.ptB.get();
      if (localSightPlayImageView == null)
      {
        v.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
        clear();
        GMTrace.o(9248272547840L, 68905);
        return;
      }
      if (SightPlayImageView.a(localSightPlayImageView))
      {
        GMTrace.o(9248272547840L, 68905);
        return;
      }
      SightPlayImageView.a(localSightPlayImageView, paramInt1);
      SightPlayImageView.b(localSightPlayImageView, paramInt2);
      if (localSightPlayImageView.ptG != null) {
        localSightPlayImageView.ptG.bp(paramInt1, paramInt2);
      }
      if (SightPlayImageView.b(localSightPlayImageView))
      {
        if (SightPlayImageView.c(localSightPlayImageView) < SightPlayImageView.d(localSightPlayImageView)) {
          break label280;
        }
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.bg.a.fromDPToPix(localSightPlayImageView.getContext(), 150));
      }
      for (;;)
      {
        if (SightPlayImageView.e(localSightPlayImageView) > 0)
        {
          final ViewGroup.LayoutParams localLayoutParams = localSightPlayImageView.getLayoutParams();
          if ((localLayoutParams.width != SightPlayImageView.e(localSightPlayImageView)) || (localLayoutParams.height != SightPlayImageView.e(localSightPlayImageView) * paramInt2 / paramInt1))
          {
            localLayoutParams.width = SightPlayImageView.e(localSightPlayImageView);
            localLayoutParams.height = (SightPlayImageView.e(localSightPlayImageView) * paramInt2 / paramInt1);
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(9241695879168L, 68856);
                localSightPlayImageView.setLayoutParams(localLayoutParams);
                GMTrace.o(9241695879168L, 68856);
              }
            });
            localSightPlayImageView.postInvalidate();
          }
          v.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
        }
        v.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", new Object[] { Integer.valueOf(SightPlayImageView.e(localSightPlayImageView)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        GMTrace.o(9248272547840L, 68905);
        return;
        label280:
        SightPlayImageView.c(localSightPlayImageView, com.tencent.mm.bg.a.fromDPToPix(localSightPlayImageView.getContext(), 85));
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */