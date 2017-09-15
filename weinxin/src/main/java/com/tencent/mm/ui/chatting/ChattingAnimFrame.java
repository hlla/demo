package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ap.d;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.c.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String kIl;
  private int jpS;
  private int jym;
  private int mScreenHeight;
  private int uuR;
  List<MMGIFImageView> vyP;
  private int vyQ;
  private int vyR;
  private boolean vyS;
  private int vyT;
  private ArrayList<Integer> vyU;
  
  static
  {
    GMTrace.i(2113794998272L, 15749);
    kIl = "";
    GMTrace.o(2113794998272L, 15749);
  }
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2112050167808L, 15736);
    this.vyP = new ArrayList();
    this.vyQ = 30;
    this.vyR = 30;
    this.uuR = 40;
    this.vyS = false;
    this.vyT = 0;
    this.vyU = new ArrayList();
    this.mScreenHeight = com.tencent.mm.bg.a.dP(getContext());
    GMTrace.o(2112050167808L, 15736);
  }
  
  private void AG(int paramInt)
  {
    GMTrace.i(2112587038720L, 15740);
    if (paramInt <= 0)
    {
      v.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      GMTrace.o(2112587038720L, 15740);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.vyU != null) {
      this.vyU.clear();
    }
    while (this.vyU.size() < i)
    {
      int j = (int)m(0.0F, paramInt);
      if (!this.vyU.contains(Integer.valueOf(j)))
      {
        this.vyU.add(Integer.valueOf(j));
        continue;
        this.vyU = new ArrayList();
      }
    }
    GMTrace.o(2112587038720L, 15740);
  }
  
  static float m(float paramFloat1, float paramFloat2)
  {
    GMTrace.i(2112855474176L, 15742);
    float f = (float)Math.random();
    GMTrace.o(2112855474176L, 15742);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  public final void a(d paramd)
  {
    GMTrace.i(2112452820992L, 15739);
    stop();
    if (paramd == null)
    {
      v.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
      GMTrace.o(2112452820992L, 15739);
      return;
    }
    Object localObject = new StringBuilder();
    if (bf.mA(kIl))
    {
      kIl = com.tencent.mm.compatible.util.e.hgh.replace("/data/user/0", "/data/data");
      kIl += "/emoji";
    }
    localObject = kIl + "/egg/" + paramd.hNH;
    if (!com.tencent.mm.a.e.aO((String)localObject))
    {
      v.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      GMTrace.o(2112452820992L, 15739);
      return;
    }
    setVisibility(0);
    label189:
    label204:
    int i;
    label278:
    int j;
    int k;
    boolean bool;
    if (paramd.hNJ > 0)
    {
      this.vyQ = paramd.hNJ;
      if (this.vyQ > 60) {
        this.vyQ = 60;
      }
      if (paramd.hNK <= 0) {
        break label511;
      }
      this.vyR = paramd.hNK;
      if (paramd.maxSize <= 0) {
        break label520;
      }
      this.uuR = paramd.maxSize;
      v.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.vyQ), Integer.valueOf(this.vyR), Integer.valueOf(this.uuR), Integer.valueOf(paramd.hNI), Integer.valueOf(paramd.hND) });
      l = 0L;
      AG(this.vyQ);
      i = 0;
      if (i >= this.vyQ) {
        break label632;
      }
      j = this.vyR;
      k = this.uuR;
      j = (int)m(j, k);
      j = com.tencent.mm.bg.a.fromDPToPix(getContext(), j);
      k = paramd.hNI;
      if ((this.vyU == null) || (!this.vyU.contains(Integer.valueOf(i)))) {
        break label529;
      }
      bool = true;
      label346:
      c localc = new c(k, j, l, bool);
      MMGIFImageView localMMGIFImageView = new MMGIFImageView(getContext());
      localMMGIFImageView.yh((String)localObject);
      localMMGIFImageView.setAnimation(localc);
      localMMGIFImageView.setLayerType(2, null);
      localc.vzf = localMMGIFImageView;
      localMMGIFImageView.setLayoutParams(new FrameLayout.LayoutParams(localc.hP, localc.hP));
      this.vyP.add(localMMGIFImageView);
      addView(localMMGIFImageView);
      j = paramd.hNI;
      k = this.vyQ;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(m(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label278;
        this.vyQ = 30;
        break;
        label511:
        this.vyR = 30;
        break label189;
        label520:
        this.uuR = 40;
        break label204;
        label529:
        bool = false;
        break label346;
      }
    }
    if (i < 2) {}
    for (long l = 800L + l;; l = ((Math.abs(i - k * 0.5D - 5.0D) / (k * 3) + 0.01D) * 1000.0D) + l) {
      break;
    }
    label632:
    if (this.vyP != null)
    {
      paramd = this.vyP.iterator();
      while (paramd.hasNext())
      {
        localObject = (View)paramd.next();
        if ((localObject != null) && ((((View)localObject).getAnimation() instanceof c))) {
          c.a((c)((View)localObject).getAnimation());
        }
      }
    }
    GMTrace.o(2112452820992L, 15739);
  }
  
  protected void onFinishInflate()
  {
    GMTrace.i(2112184385536L, 15737);
    super.onFinishInflate();
    this.jym = getMeasuredHeight();
    this.jpS = getMeasuredWidth();
    v.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.jpS), Integer.valueOf(this.jym) });
    GMTrace.o(2112184385536L, 15737);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(2112318603264L, 15738);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jym = (paramInt4 - paramInt2);
    this.jpS = (paramInt3 - paramInt1);
    if (this.jym < this.mScreenHeight) {
      this.vyS = true;
    }
    for (this.vyT = (this.mScreenHeight - this.jym);; this.vyT = 0)
    {
      v.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.jpS), Integer.valueOf(this.jym), Boolean.valueOf(this.vyS), Integer.valueOf(this.vyT) });
      GMTrace.o(2112318603264L, 15738);
      return;
      this.vyS = false;
    }
  }
  
  public final void stop()
  {
    GMTrace.i(2112721256448L, 15741);
    Iterator localIterator = this.vyP.iterator();
    while (localIterator.hasNext())
    {
      MMGIFImageView localMMGIFImageView = (MMGIFImageView)localIterator.next();
      localMMGIFImageView.clearAnimation();
      localMMGIFImageView.recycle();
    }
    removeAllViews();
    GMTrace.o(2112721256448L, 15741);
  }
  
  class a
    implements Animation.AnimationListener
  {
    a()
    {
      GMTrace.i(2232711905280L, 16635);
      GMTrace.o(2232711905280L, 16635);
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      GMTrace.i(2232980340736L, 16637);
      GMTrace.o(2232980340736L, 16637);
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      GMTrace.i(2233114558464L, 16638);
      GMTrace.o(2233114558464L, 16638);
    }
    
    public void onAnimationStart(Animation paramAnimation)
    {
      GMTrace.i(2232846123008L, 16636);
      GMTrace.o(2232846123008L, 16636);
    }
  }
  
  private final class b
    extends Animation
  {
    private int hP;
    private float jTK;
    private float jTL;
    private float jTM;
    private float jTN;
    private float jTO;
    private float jTP;
    private float vyW;
    private float vyX;
    private float vyY;
    private float vyZ;
    private int vza;
    private boolean vzb;
    private View.OnLayoutChangeListener vzc;
    
    public b(int paramInt1, int paramInt2)
    {
      GMTrace.i(2273916747776L, 16942);
      this.vza = 0;
      this.hP = 0;
      this.vzb = false;
      this.vzc = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          GMTrace.i(2232577687552L, 16634);
          ChattingAnimFrame.b.this.ads();
          GMTrace.o(2232577687552L, 16634);
        }
      };
      this.vza = paramInt1;
      this.hP = paramInt2;
      this.vzb = false;
      GMTrace.o(2273916747776L, 16942);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      GMTrace.i(2274050965504L, 16943);
      this.vza = 0;
      this.hP = 0;
      this.vzb = false;
      this.vzc = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          GMTrace.i(2232577687552L, 16634);
          ChattingAnimFrame.b.this.ads();
          GMTrace.o(2232577687552L, 16634);
        }
      };
      this.vza = paramInt1;
      this.hP = paramInt2;
      this.vzb = paramBoolean;
      GMTrace.o(2274050965504L, 16943);
    }
    
    public final void ads()
    {
      GMTrace.i(2274587836416L, 16947);
      this.jTM = (this.vyW * ChattingAnimFrame.a(ChattingAnimFrame.this));
      this.jTN = (this.vyX * ChattingAnimFrame.a(ChattingAnimFrame.this));
      if (this.vza == 2)
      {
        this.jTO = (this.vyY * ChattingAnimFrame.b(ChattingAnimFrame.this));
        this.jTP = (this.vyZ * ChattingAnimFrame.b(ChattingAnimFrame.this));
        GMTrace.o(2274587836416L, 16947);
        return;
      }
      if (this.vza == 3)
      {
        this.jTO = (this.vyY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.jTP = (this.vyZ * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.jTO = (this.vyY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.jTP = (this.vyZ * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.jTP < 0.0F)
        {
          this.jTP = 0.0F;
          GMTrace.o(2274587836416L, 16947);
        }
      }
      else
      {
        this.jTO = (this.vyY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.jTP = (this.vyZ * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      GMTrace.o(2274587836416L, 16947);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      GMTrace.i(2274319400960L, 16945);
      float f2 = this.jTM;
      float f1 = this.jTO;
      if (this.jTM != this.jTN) {
        f2 = this.jTM + (this.jTN - this.jTM) * paramFloat;
      }
      if (this.jTO != this.jTP)
      {
        float f3 = this.jTO + (this.jTP - this.jTO) * paramFloat;
        f1 = f3;
        if (this.vza == 2) {
          f1 = f3 - this.hP;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.jTK != this.jTL) && (3 == this.vza))
      {
        paramFloat = this.jTK + (this.jTL - this.jTK) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      GMTrace.o(2274319400960L, 16945);
    }
    
    protected final void finalize()
    {
      GMTrace.i(2274453618688L, 16946);
      super.finalize();
      v.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.vzc);
      GMTrace.o(2274453618688L, 16946);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      GMTrace.i(2274185183232L, 16944);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.vza)
      {
      default: 
        this.vyW = ChattingAnimFrame.m(0.1F, 0.9F);
        this.vyX = ChattingAnimFrame.m(this.vyW - 0.5F, this.vyW + 0.5F);
        this.vyY = -0.2F;
        this.vyZ = 1.2F;
        setInterpolator(new LinearInterpolator());
      }
      for (;;)
      {
        if ((this.vza != 0) && (this.vza != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.vzc);
        }
        ads();
        GMTrace.o(2274185183232L, 16944);
        return;
        this.vyW = ChattingAnimFrame.m(0.1F, 0.9F);
        this.vyX = ChattingAnimFrame.m(this.vyW - 0.25F, this.vyW + 0.25F);
        this.vyY = 1.5F;
        this.vyZ = -0.2F;
        setInterpolator(new LinearInterpolator());
        continue;
        this.vyW = 0.0F;
        this.vyX = 0.0F;
        this.vyY = 1.5F;
        if (this.vzb) {}
        for (this.vyZ = ChattingAnimFrame.m(0.4F, 0.55F);; this.vyZ = ChattingAnimFrame.m(0.54999995F, 0.85F))
        {
          setInterpolator(new b());
          break;
        }
        this.vyW = 0.0F;
        this.vyX = 0.0F;
        this.vyY = 0.0F;
        this.vyZ = 1.0F;
        setInterpolator(new com.tencent.mm.ui.c.a.a());
        continue;
        this.vyW = ChattingAnimFrame.m(0.1F, 0.9F);
        this.vyX = ChattingAnimFrame.m(this.vyW - 0.5F, this.vyW + 0.5F);
        this.vyY = 0.0F;
        this.vyZ = 0.0F;
        this.jTK = 0.8F;
        this.jTL = 1.1F;
        setInterpolator(new LinearInterpolator());
      }
    }
  }
  
  final class c
    extends AnimationSet
  {
    int hP;
    private long vze;
    MMGIFImageView vzf;
    
    public c(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
    {
      super();
      GMTrace.i(2516448182272L, 18749);
      this.hP = paramInt2;
      switch (paramInt1)
      {
      default: 
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, 0, this.hP));
      }
      for (;;)
      {
        setAnimationListener(new ChattingAnimFrame.a(ChattingAnimFrame.this)
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            GMTrace.i(2269353345024L, 16908);
            paramAnonymousAnimation = ChattingAnimFrame.c.this;
            if (paramAnonymousAnimation.vzf != null)
            {
              paramAnonymousAnimation.vzf.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              GMTrace.o(2269353345024L, 16908);
              return;
            }
            v.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            GMTrace.o(2269353345024L, 16908);
          }
        });
        this.vze = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.AH(paramInt1));
        GMTrace.o(2516448182272L, 18749);
        return;
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, 999, this.hP));
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, paramInt1, this.hP));
        continue;
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, paramInt1, this.hP, paramBoolean));
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, 999, this.hP));
        continue;
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, paramInt1, this.hP));
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ChattingAnimFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */