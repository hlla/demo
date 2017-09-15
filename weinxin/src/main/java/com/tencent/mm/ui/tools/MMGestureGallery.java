package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import android.widget.SpinnerAdapter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MMGestureGallery
  extends Gallery
{
  private int abb;
  private int abc;
  private int count;
  private VelocityTracker fk;
  private ad handler;
  private int jWD;
  private int jWE;
  private long mgP;
  private long mgQ;
  private float mgR;
  private float mgS;
  private long mgT;
  private boolean mgU;
  private OverScroller mgV;
  private GestureDetector mgW;
  private RectF mgX;
  private float mgZ;
  private float mha;
  private boolean mhb;
  private boolean mhc;
  private boolean mhd;
  private boolean mhe;
  private MultiTouchImageView mhn;
  private float mvu;
  private float qCT;
  private boolean qCU;
  private boolean qCV;
  private boolean qCW;
  private boolean vlA;
  private boolean vlB;
  private boolean vlC;
  private int vlD;
  private final int vlM;
  private final int vlN;
  public boolean vly;
  private boolean vlz;
  public l wkH;
  public l wkI;
  public l wkJ;
  private a wkK;
  public f wkL;
  public c wkM;
  public e wkN;
  public boolean wkO;
  public b wkP;
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2037156675584L, 15178);
    this.mgU = false;
    this.vlz = false;
    this.vlA = false;
    this.vlB = false;
    this.vlC = false;
    this.mhb = false;
    this.mhc = false;
    this.mhd = false;
    this.mhe = false;
    this.vlD = 0;
    this.count = 0;
    this.mgP = 0L;
    this.mgQ = 0L;
    this.mgR = 0.0F;
    this.mgS = 0.0F;
    this.mgT = 0L;
    this.mgX = new RectF();
    this.handler = new ad(Looper.getMainLooper());
    this.wkO = true;
    this.mvu = 0.0F;
    this.qCT = 0.0F;
    this.qCU = false;
    this.qCV = false;
    this.qCW = false;
    this.vly = false;
    this.vlM = 60;
    this.vlN = 500;
    setStaticTransformationsEnabled(true);
    this.mgW = new GestureDetector(paramContext, new d((byte)0));
    this.wkH = new l(new WeakReference(this));
    this.wkI = new l(new WeakReference(this));
    this.wkJ = new l(new WeakReference(this));
    this.mgV = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.vlD = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
    setOnTouchListener(new View.OnTouchListener()
    {
      private void bZz()
      {
        GMTrace.i(1994072784896L, 14857);
        MMGestureGallery.e(MMGestureGallery.this).removeMessages(2);
        GMTrace.o(1994072784896L, 14857);
      }
      
      private void lG(boolean paramAnonymousBoolean)
      {
        GMTrace.i(1994341220352L, 14859);
        MMGestureGallery.J(MMGestureGallery.this).p(350L, paramAnonymousBoolean);
        GMTrace.o(1994341220352L, 14859);
      }
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(1994207002624L, 14858);
        if (MMGestureGallery.f(MMGestureGallery.this) == null) {
          MMGestureGallery.a(MMGestureGallery.this, VelocityTracker.obtain());
        }
        MMGestureGallery.f(MMGestureGallery.this).addMovement(paramAnonymousMotionEvent);
        View localView = MMGestureGallery.this.getSelectedView();
        paramAnonymousView = localView;
        if ((localView instanceof ViewGroup))
        {
          paramAnonymousView = localView.findViewById(a.g.bWH);
          if ((paramAnonymousView == null) || (paramAnonymousView.getVisibility() == 8))
          {
            if ((MMGestureGallery.g(MMGestureGallery.this)) && (MMGestureGallery.h(MMGestureGallery.this) != null) && (paramAnonymousMotionEvent.getAction() == 1)) {
              lG(true);
            }
            GMTrace.o(1994207002624L, 14858);
            return false;
          }
          localView = paramAnonymousView.findViewById(a.g.Kd);
          paramAnonymousView = localView;
          if (localView == null)
          {
            GMTrace.o(1994207002624L, 14858);
            return false;
          }
        }
        float f3;
        if ((paramAnonymousView instanceof MultiTouchImageView))
        {
          MMGestureGallery.a(MMGestureGallery.this, (MultiTouchImageView)paramAnonymousView);
          v.d("dktest", "MMGestureGallery onTouch event.getAction():" + paramAnonymousMotionEvent.getAction());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            bZz();
            MMGestureGallery.e(MMGestureGallery.this).d(2, 500L, 0L);
            MMGestureGallery.a(MMGestureGallery.this).bSD();
            MMGestureGallery.a(MMGestureGallery.this, paramAnonymousMotionEvent.getX());
            MMGestureGallery.b(MMGestureGallery.this, paramAnonymousMotionEvent.getY());
            MMGestureGallery.c(MMGestureGallery.this, 0.0F);
            MMGestureGallery.d(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
            v.d("dktest", "originalScale :" + MMGestureGallery.i(MMGestureGallery.this));
            MMGestureGallery.a(MMGestureGallery.this, false);
            MMGestureGallery.j(MMGestureGallery.this);
            if (MMGestureGallery.k(MMGestureGallery.this) == 1)
            {
              MMGestureGallery.a(MMGestureGallery.this, System.currentTimeMillis());
              MMGestureGallery.e(MMGestureGallery.this, f.i(paramAnonymousMotionEvent, 0));
              MMGestureGallery.f(MMGestureGallery.this, f.j(paramAnonymousMotionEvent, 0));
            }
          }
          else
          {
            if ((paramAnonymousMotionEvent.getAction() == 6) || (paramAnonymousMotionEvent.getAction() == 262))
            {
              bZz();
              MMGestureGallery.c(MMGestureGallery.this, 0.0F);
              MMGestureGallery.d(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
              MMGestureGallery.a(MMGestureGallery.this, true);
              float f4;
              if (MMGestureGallery.i(MMGestureGallery.this) < MMGestureGallery.a(MMGestureGallery.this).oZL)
              {
                f1 = f.i(paramAnonymousMotionEvent, 0);
                f2 = f.i(paramAnonymousMotionEvent, 1);
                f3 = f.j(paramAnonymousMotionEvent, 0);
                f4 = f.j(paramAnonymousMotionEvent, 1);
                MMGestureGallery.a(MMGestureGallery.this).E(f1 - f2 + f.i(paramAnonymousMotionEvent, 1), f3 - f4 + f.j(paramAnonymousMotionEvent, 1));
              }
              if (MMGestureGallery.i(MMGestureGallery.this) > MMGestureGallery.a(MMGestureGallery.this).bSE() * 2.0F)
              {
                f1 = f.i(paramAnonymousMotionEvent, 0);
                f2 = f.i(paramAnonymousMotionEvent, 1);
                f3 = f.j(paramAnonymousMotionEvent, 0);
                f4 = f.j(paramAnonymousMotionEvent, 1);
                MMGestureGallery.a(MMGestureGallery.this).at(MMGestureGallery.a(MMGestureGallery.this).bSE() * 2.0F);
                MMGestureGallery.a(MMGestureGallery.this).f(MMGestureGallery.a(MMGestureGallery.this).bSE() * 2.0F, f1 - f2 + f.i(paramAnonymousMotionEvent, 1), f3 - f4 + f.j(paramAnonymousMotionEvent, 1));
              }
            }
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              bZz();
              MMGestureGallery.p(MMGestureGallery.this);
              MMGestureGallery.q(MMGestureGallery.this);
              MMGestureGallery.r(MMGestureGallery.this);
              if (((!MMGestureGallery.s(MMGestureGallery.this)) && (!MMGestureGallery.t(MMGestureGallery.this)) && (!MMGestureGallery.u(MMGestureGallery.this)) && (!MMGestureGallery.v(MMGestureGallery.this))) || ((!MMGestureGallery.w(MMGestureGallery.this)) && (!MMGestureGallery.x(MMGestureGallery.this)))) {
                break label1249;
              }
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.h(MMGestureGallery.this));
              MMGestureGallery.y(MMGestureGallery.this);
              MMGestureGallery.z(MMGestureGallery.this);
              MMGestureGallery.A(MMGestureGallery.this);
              MMGestureGallery.B(MMGestureGallery.this);
              MMGestureGallery.C(MMGestureGallery.this);
              MMGestureGallery.D(MMGestureGallery.this);
              MMGestureGallery.E(MMGestureGallery.this);
              label800:
              MMGestureGallery.c(MMGestureGallery.this, 0.0F);
              MMGestureGallery.d(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
              if (MMGestureGallery.k(MMGestureGallery.this) == 1)
              {
                MMGestureGallery.c(MMGestureGallery.this, System.currentTimeMillis());
                if (MMGestureGallery.m(MMGestureGallery.this) - MMGestureGallery.K(MMGestureGallery.this) >= 350L) {
                  break label1548;
                }
                if ((Math.abs(MMGestureGallery.n(MMGestureGallery.this) - f.i(paramAnonymousMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.o(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) < 10.0F)) {
                  lG(false);
                }
              }
            }
          }
          for (;;)
          {
            if ((paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261))
            {
              MMGestureGallery.c(MMGestureGallery.this, 0.0F);
              MMGestureGallery.d(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
              MMGestureGallery.a(MMGestureGallery.this, true);
            }
            if (paramAnonymousMotionEvent.getAction() != 2) {
              break label1650;
            }
            if (f.G(paramAnonymousMotionEvent) != 2) {
              break label1721;
            }
            bZz();
            if ((!MMGestureGallery.L(MMGestureGallery.this)) && (!MMGestureGallery.u(MMGestureGallery.this)) && (!MMGestureGallery.v(MMGestureGallery.this))) {
              break label1569;
            }
            GMTrace.o(1994207002624L, 14858);
            return true;
            if (MMGestureGallery.k(MMGestureGallery.this) != 2) {
              break;
            }
            MMGestureGallery.b(MMGestureGallery.this, System.currentTimeMillis());
            if (MMGestureGallery.l(MMGestureGallery.this) - MMGestureGallery.m(MMGestureGallery.this) < 350L)
            {
              if ((Math.abs(MMGestureGallery.n(MMGestureGallery.this) - f.i(paramAnonymousMotionEvent, 0)) < 35.0F) && (Math.abs(MMGestureGallery.o(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) < 35.0F))
              {
                MMGestureGallery.a(MMGestureGallery.this, 0);
                v.d("MicroMsg.MMGestureGallery", "double click!");
                if (MMGestureGallery.a(MMGestureGallery.this).getScale() <= MMGestureGallery.a(MMGestureGallery.this).oZL)
                {
                  MMGestureGallery.a(MMGestureGallery.this).F(f.i(paramAnonymousMotionEvent, 0), f.j(paramAnonymousMotionEvent, 0));
                  break;
                }
                MMGestureGallery.a(MMGestureGallery.this).E(f.i(paramAnonymousMotionEvent, 0), f.j(paramAnonymousMotionEvent, 0));
                MMGestureGallery.a(MMGestureGallery.this).bSC();
                break;
              }
              MMGestureGallery.a(MMGestureGallery.this, 1);
              break;
            }
            MMGestureGallery.a(MMGestureGallery.this, 1);
            break;
            label1249:
            if ((MMGestureGallery.u(MMGestureGallery.this)) || (MMGestureGallery.s(MMGestureGallery.this)))
            {
              MMGestureGallery.B(MMGestureGallery.this);
              MMGestureGallery.z(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.i(MMGestureGallery.this));
              MMGestureGallery.y(MMGestureGallery.this);
            }
            if ((MMGestureGallery.v(MMGestureGallery.this)) || (MMGestureGallery.t(MMGestureGallery.this)))
            {
              MMGestureGallery.C(MMGestureGallery.this);
              MMGestureGallery.A(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.j(MMGestureGallery.this));
              MMGestureGallery.y(MMGestureGallery.this);
            }
            if (MMGestureGallery.w(MMGestureGallery.this))
            {
              MMGestureGallery.D(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.k(MMGestureGallery.this));
              MMGestureGallery.y(MMGestureGallery.this);
            }
            if (MMGestureGallery.x(MMGestureGallery.this))
            {
              MMGestureGallery.E(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.g(MMGestureGallery.this));
              MMGestureGallery.y(MMGestureGallery.this);
            }
            if (MMGestureGallery.F(MMGestureGallery.this))
            {
              if (MMGestureGallery.G(MMGestureGallery.this) != null) {
                MMGestureGallery.G(MMGestureGallery.this).C(0.0F, 0.0F);
              }
              MMGestureGallery.b(MMGestureGallery.this, false);
            }
            if ((!MMGestureGallery.H(MMGestureGallery.this)) || (MMGestureGallery.I(MMGestureGallery.this))) {
              break label800;
            }
            MMGestureGallery.J(MMGestureGallery.this).p(0L, true);
            MMGestureGallery.b(MMGestureGallery.this, false);
            break label800;
            label1548:
            MMGestureGallery.a(MMGestureGallery.this, 0);
            v.d("MicroMsg.MMGestureGallery", "single long click over!");
          }
          label1569:
          MMGestureGallery.a(MMGestureGallery.this, true);
          MMGestureGallery.a(MMGestureGallery.this, 0);
          f1 = f.i(paramAnonymousMotionEvent, 0) - f.i(paramAnonymousMotionEvent, 1);
          f2 = f.j(paramAnonymousMotionEvent, 0) - f.j(paramAnonymousMotionEvent, 1);
          f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
          if (MMGestureGallery.M(MMGestureGallery.this) != 0.0F) {
            break label1661;
          }
          MMGestureGallery.c(MMGestureGallery.this, f3);
        }
        for (;;)
        {
          label1650:
          GMTrace.o(1994207002624L, 14858);
          return false;
          label1661:
          f3 /= MMGestureGallery.M(MMGestureGallery.this);
          if (MMGestureGallery.N(MMGestureGallery.this)) {
            MMGestureGallery.a(MMGestureGallery.this).f(f3 * MMGestureGallery.i(MMGestureGallery.this), f1 + f.i(paramAnonymousMotionEvent, 1), f2 + f.j(paramAnonymousMotionEvent, 1));
          }
        }
        label1721:
        paramAnonymousView = MMGestureGallery.f(MMGestureGallery.this);
        paramAnonymousView.computeCurrentVelocity(1000);
        int i = (int)paramAnonymousView.getXVelocity();
        int j = (int)paramAnonymousView.getYVelocity();
        float f1 = paramAnonymousMotionEvent.getX() - MMGestureGallery.O(MMGestureGallery.this);
        float f2 = paramAnonymousMotionEvent.getY() - MMGestureGallery.P(MMGestureGallery.this);
        if ((MMGestureGallery.G(MMGestureGallery.this) != null) && (!MMGestureGallery.I(MMGestureGallery.this)) && (!MMGestureGallery.N(MMGestureGallery.this)) && (MMGestureGallery.i(MMGestureGallery.this) <= MMGestureGallery.a(MMGestureGallery.this).oZL))
        {
          MMGestureGallery.G(MMGestureGallery.this).D(f1, f2);
          if (((Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (j <= 0) || (MMGestureGallery.Q(MMGestureGallery.this))) && (!MMGestureGallery.H(MMGestureGallery.this))) {
            break label2025;
          }
          MMGestureGallery.G(MMGestureGallery.this).C(f1, f2);
          MMGestureGallery.b(MMGestureGallery.this, true);
          label1916:
          if (f2 <= 200.0F) {
            break label2037;
          }
          MMGestureGallery.c(MMGestureGallery.this, false);
        }
        for (;;)
        {
          if (MMGestureGallery.f(MMGestureGallery.this) != null)
          {
            MMGestureGallery.f(MMGestureGallery.this).recycle();
            MMGestureGallery.a(MMGestureGallery.this, null);
          }
          if ((Math.abs(MMGestureGallery.n(MMGestureGallery.this) - f.i(paramAnonymousMotionEvent, 0)) <= 35.0F) && (Math.abs(MMGestureGallery.o(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) <= 35.0F)) {
            break;
          }
          bZz();
          MMGestureGallery.a(MMGestureGallery.this, 0);
          break;
          label2025:
          MMGestureGallery.b(MMGestureGallery.this, false);
          break label1916;
          label2037:
          MMGestureGallery.c(MMGestureGallery.this, true);
        }
      }
    });
    GMTrace.o(2037156675584L, 15178);
  }
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(2036888240128L, 15176);
    this.mgU = false;
    this.vlz = false;
    this.vlA = false;
    this.vlB = false;
    this.vlC = false;
    this.mhb = false;
    this.mhc = false;
    this.mhd = false;
    this.mhe = false;
    this.vlD = 0;
    this.count = 0;
    this.mgP = 0L;
    this.mgQ = 0L;
    this.mgR = 0.0F;
    this.mgS = 0.0F;
    this.mgT = 0L;
    this.mgX = new RectF();
    this.handler = new ad(Looper.getMainLooper());
    this.wkO = true;
    this.mvu = 0.0F;
    this.qCT = 0.0F;
    this.qCU = false;
    this.qCV = false;
    this.qCW = false;
    this.vly = false;
    this.vlM = 60;
    this.vlN = 500;
    setStaticTransformationsEnabled(true);
    GMTrace.o(2036888240128L, 15176);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat)
  {
    GMTrace.i(2038364635136L, 15187);
    float f3 = paramMotionEvent1.getX();
    float f4 = paramMotionEvent2.getX();
    float f1 = paramMotionEvent1.getY();
    float f2 = paramMotionEvent2.getY();
    boolean bool = b(paramMotionEvent1, paramMotionEvent2);
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    if (Math.abs(paramFloat) <= 500.0F)
    {
      GMTrace.o(2038364635136L, 15187);
      return;
    }
    if (f3 < 60.0F)
    {
      GMTrace.o(2038364635136L, 15187);
      return;
    }
    if (f3 < f1)
    {
      GMTrace.o(2038364635136L, 15187);
      return;
    }
    if (bool)
    {
      onKeyDown(21, null);
      GMTrace.o(2038364635136L, 15187);
      return;
    }
    onKeyDown(22, null);
    GMTrace.o(2038364635136L, 15187);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView, float paramFloat3)
  {
    GMTrace.i(2037559328768L, 15181);
    int i;
    if ((this.vlA) || (this.vlz)) {
      i = 0;
    }
    while (i != 0)
    {
      GMTrace.o(2037559328768L, 15181);
      return true;
      if (getPositionForView(paramView) == getAdapter().getCount() - 1)
      {
        if (this.vlC)
        {
          if (paramFloat3 > 0.0F)
          {
            if (paramFloat2 >= this.jWD) {
              this.mhn.G(-paramFloat3, 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if ((paramFloat2 > this.jWD * 0.7F) && (paramFloat2 < this.jWE)) {
                this.mhn.G(-(paramFloat3 * 0.3F), 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 > 0.0F)
        {
          if (paramFloat2 < this.jWD) {
            this.vlC = true;
          }
          if (paramFloat2 >= this.jWD) {
            this.mhn.G(-paramFloat3, 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if ((paramFloat2 > this.jWD * 0.7F) && (paramFloat2 < this.jWE)) {
              this.mhn.G(-(paramFloat3 * 0.3F), 0.0F);
            }
          }
        }
      }
      this.vlC = false;
      i = 0;
    }
    if ((this.vlA) || (this.vlz)) {
      i = 0;
    }
    while (i != 0)
    {
      GMTrace.o(2037559328768L, 15181);
      return true;
      if (getPositionForView(paramView) == 0)
      {
        if (this.vlB)
        {
          if (paramFloat3 < 0.0F)
          {
            if ((paramFloat1 > 0.0F) && (paramFloat1 < this.jWD * 0.3F)) {
              this.mhn.G(-(paramFloat3 * 0.3F), 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if (paramFloat1 <= 0.0F) {
                this.mhn.G(-paramFloat3, 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 < 0.0F)
        {
          if (paramFloat1 > 0.0F) {
            this.vlB = true;
          }
          if ((paramFloat1 > 0.0F) && (paramFloat1 < this.jWD * 0.3F)) {
            this.mhn.G(-(paramFloat3 * 0.3F), 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if (paramFloat1 <= 0.0F) {
              this.mhn.G(-paramFloat3, 0.0F);
            }
          }
        }
      }
      this.vlB = false;
      i = 0;
    }
    GMTrace.o(2037559328768L, 15181);
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(2037425111040L, 15180);
    if (this.vlz)
    {
      GMTrace.o(2037425111040L, 15180);
      return true;
    }
    this.vlA = true;
    if (this.wkN != null) {
      this.wkN.bkm();
    }
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    GMTrace.o(2037425111040L, 15180);
    return bool;
  }
  
  private void ayW()
  {
    GMTrace.i(2037022457856L, 15177);
    this.wkH.removeMessages(1);
    GMTrace.o(2037022457856L, 15177);
  }
  
  private static boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    GMTrace.i(2038230417408L, 15186);
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() < 0.0F)
    {
      GMTrace.o(2038230417408L, 15186);
      return true;
    }
    GMTrace.o(2038230417408L, 15186);
    return false;
  }
  
  public void computeScroll()
  {
    int m = 0;
    GMTrace.i(2038901506048L, 15191);
    if (this.mhn == null)
    {
      GMTrace.o(2038901506048L, 15191);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.mgV.computeScrollOffset())
    {
      i = this.mgV.getCurrX() - this.abb;
      int n = this.mgV.getCurrY() - this.abc;
      this.abb = this.mgV.getCurrX();
      this.abc = this.mgV.getCurrY();
      float f3 = this.mhn.getScale();
      f4 = this.mhn.imageWidth;
      float f1 = this.mhn.getScale() * this.mhn.imageHeight;
      float[] arrayOfFloat = new float[9];
      this.mhn.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.mgX.right - Math.round(f3)) {
          j = (int)(this.mgX.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.mgX.left - Math.round(f2)) {
          i = (int)(this.mgX.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.mgX.bottom - Math.round(f5)) {
          k = (int)(this.mgX.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.mgX.top - Math.round(f4)) {
          j = (int)(this.mgX.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.mgX.left) && (Math.round(f3) > this.mgX.right)) {
        break label442;
      }
      k = 0;
      if (f1 >= this.jWE) {
        break label490;
      }
    }
    label442:
    label490:
    for (int i = m;; i = j)
    {
      this.mhn.G(k, i);
      postInvalidate();
      GMTrace.o(2038901506048L, 15191);
      return;
      if (Math.round(f4) < this.mgX.top)
      {
        k = i;
        if (Math.round(f5) > this.mgX.bottom) {
          break;
        }
      }
      j = 0;
      k = i;
      break;
    }
  }
  
  public boolean isFocused()
  {
    GMTrace.i(2039035723776L, 15192);
    GMTrace.o(2039035723776L, 15192);
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    GMTrace.i(2037827764224L, 15183);
    if (this.mgV != null) {
      this.mgV.forceFinished(true);
    }
    boolean bool = super.onDown(paramMotionEvent);
    GMTrace.o(2037827764224L, 15183);
    return bool;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(2037961981952L, 15184);
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(a.g.bWH);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        GMTrace.o(2037961981952L, 15184);
        return false;
      }
      localObject2 = ((View)localObject1).findViewById(a.g.Kd);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        GMTrace.o(2037961981952L, 15184);
        return false;
      }
    }
    float f2;
    float f5;
    float f3;
    float f4;
    float f6;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      localObject1 = (MultiTouchImageView)localObject1;
      f2 = ((MultiTouchImageView)localObject1).getScale() * ((MultiTouchImageView)localObject1).imageWidth;
      f5 = ((MultiTouchImageView)localObject1).getScale() * ((MultiTouchImageView)localObject1).imageHeight;
      if ((((MultiTouchImageView)localObject1).vmx) || (((MultiTouchImageView)localObject1).vmy) || ((int)f2 > this.jWD) || ((int)f5 > this.jWE))
      {
        localObject2 = new float[9];
        ((MultiTouchImageView)localObject1).getImageMatrix().getValues((float[])localObject2);
        f3 = localObject2[2];
        f4 = f3 + f2;
        f6 = localObject2[5];
        v.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(b(paramMotionEvent1, paramMotionEvent2)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f3) < this.mgX.left) && (Math.round(f4) > this.mgX.right)) {
          break label683;
        }
      }
    }
    label459:
    label589:
    label618:
    label647:
    label683:
    for (float f1 = 0.0F;; f1 = paramFloat1)
    {
      if ((Math.round(f6) >= this.mgX.top) || (Math.round(f6 + f5) <= this.mgX.bottom)) {
        paramFloat2 = 0.0F;
      }
      int i;
      int j;
      int k;
      int m;
      if (Math.round(f6) < this.mgX.top)
      {
        this.vly = true;
        i = (int)(this.mgX.right - f2);
        j = (int)(f2 + this.mgX.right);
        k = (int)(this.mgX.bottom - f5);
        m = (int)(this.mgX.bottom + f5);
        if (f1 < 0.0F) {
          break label589;
        }
        f2 = f1;
        if (Math.abs(f1) >= this.vlD) {
          f2 = this.vlD;
        }
        if (paramFloat2 < 0.0F) {
          break label618;
        }
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= this.vlD) {
          f1 = this.vlD;
        }
      }
      for (;;)
      {
        this.mgV.forceFinished(true);
        this.mgV.fling(this.mgV.getCurrX(), this.mgV.getCurrY(), (int)f2, (int)f1, i, j, k, m, 0, 0);
        if (((b(paramMotionEvent1, paramMotionEvent2)) && (f3 >= 0.0F)) || ((!b(paramMotionEvent1, paramMotionEvent2)) && (f4 <= this.jWD))) {
          break label647;
        }
        GMTrace.o(2037961981952L, 15184);
        return true;
        this.vly = false;
        break;
        f2 = f1;
        if (Math.abs(f1) >= this.vlD) {
          f2 = -this.vlD;
        }
        break label459;
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= this.vlD) {
          f1 = -this.vlD;
        }
      }
      if (this.mgU)
      {
        GMTrace.o(2037961981952L, 15184);
        return true;
      }
      a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
      GMTrace.o(2037961981952L, 15184);
      return true;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    GMTrace.i(2038633070592L, 15189);
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
    GMTrace.o(2038633070592L, 15189);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    GMTrace.i(2038096199680L, 15185);
    this.qCW = true;
    super.onLongPress(paramMotionEvent);
    GMTrace.o(2038096199680L, 15185);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(2037290893312L, 15179);
    super.onMeasure(paramInt1, paramInt2);
    this.jWD = View.MeasureSpec.getSize(paramInt1);
    this.jWE = View.MeasureSpec.getSize(paramInt2);
    this.mgX.set(0.0F, 0.0F, this.jWD, this.jWE);
    v.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.jWD + " height:" + this.jWE);
    GMTrace.o(2037290893312L, 15179);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(2037693546496L, 15182);
    if ((this.mgU) || (this.qCU))
    {
      GMTrace.o(2037693546496L, 15182);
      return true;
    }
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    boolean bool;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(a.g.bWH);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        GMTrace.o(2037693546496L, 15182);
        return bool;
      }
      localObject2 = ((View)localObject1).findViewById(a.g.Kd);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        GMTrace.o(2037693546496L, 15182);
        return bool;
      }
    }
    float f1;
    float f5;
    float f4;
    float f6;
    float f7;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      this.mhn = ((MultiTouchImageView)localObject1);
      localObject2 = new float[9];
      this.mhn.getImageMatrix().getValues((float[])localObject2);
      f1 = this.mhn.getScale() * this.mhn.imageWidth;
      float f2 = this.mhn.getScale() * this.mhn.imageHeight;
      f5 = localObject2[2];
      f4 = f5 + f1;
      f6 = localObject2[5];
      f7 = f6 + f2;
      localObject2 = new Rect();
      this.mhn.getGlobalVisibleRect((Rect)localObject2);
      if (((int)f1 <= this.jWD) && ((int)f2 <= this.jWE))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          GMTrace.o(2037693546496L, 15182);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.jWD)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
            GMTrace.o(2037693546496L, 15182);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          GMTrace.o(2037693546496L, 15182);
          return bool;
        }
        if (!this.vlA) {
          this.mhn.G(-paramFloat1, 0.0F);
        }
        GMTrace.o(2037693546496L, 15182);
        return true;
      }
      if (((int)f1 <= this.jWD) && ((int)f2 > this.jWE))
      {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        {
          if ((this.vlA) || (this.vlB) || (this.vlC))
          {
            GMTrace.o(2037693546496L, 15182);
            return true;
          }
          this.vlz = true;
          f2 = 0.0F;
          float f3 = 0.0F;
          if (paramFloat2 < 0.0F)
          {
            if (f6 > this.mgX.top) {
              this.mhb = true;
            }
            if ((f6 <= this.mgX.top) || (f7 < this.jWE))
            {
              f1 = -paramFloat2;
              if ((paramFloat1 >= 0.0F) || (f5 <= this.mgX.left)) {
                break label721;
              }
              this.mhd = true;
              paramFloat2 = -(0.3F * paramFloat1);
            }
          }
          for (;;)
          {
            this.mhn.G(paramFloat2, f1);
            GMTrace.o(2037693546496L, 15182);
            return true;
            f1 = f3;
            if (f6 <= this.mgX.top) {
              break;
            }
            f1 = f3;
            if (f6 >= this.jWE * 0.3F) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            if (f7 < this.mgX.bottom) {
              this.mhc = true;
            }
            if ((f6 > 0.0F) || (f7 >= this.jWE))
            {
              f1 = -paramFloat2;
              break;
            }
            f1 = f3;
            if (f7 <= this.jWE * 0.7F) {
              break;
            }
            f1 = f3;
            if (f7 >= this.jWE) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            label721:
            paramFloat2 = f2;
            if (paramFloat1 > 0.0F)
            {
              paramFloat2 = f2;
              if (f4 < this.mgX.right)
              {
                this.mhe = true;
                paramFloat2 = -(0.3F * paramFloat1);
              }
            }
          }
        }
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          GMTrace.o(2037693546496L, 15182);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.jWD)
          {
            if (f4 > this.jWD * 0.7F)
            {
              bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
              GMTrace.o(2037693546496L, 15182);
              return bool;
            }
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
            GMTrace.o(2037693546496L, 15182);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          if (f5 < this.jWD * 0.3F)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
            GMTrace.o(2037693546496L, 15182);
            return bool;
          }
          bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
          GMTrace.o(2037693546496L, 15182);
          return bool;
        }
        if (!this.vlA) {
          this.mhn.G(-paramFloat1, 0.0F);
        }
        GMTrace.o(2037693546496L, 15182);
        return true;
      }
      if (((int)f1 > this.jWD) && ((int)f2 <= this.jWE))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          GMTrace.o(2037693546496L, 15182);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.jWD)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
            GMTrace.o(2037693546496L, 15182);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          GMTrace.o(2037693546496L, 15182);
          return bool;
        }
        if (!this.vlA) {
          this.mhn.G(-paramFloat1, 0.0F);
        }
        GMTrace.o(2037693546496L, 15182);
        return true;
      }
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        if (paramFloat1 == 0.0F) {
          break label1659;
        }
        this.vlA = true;
        if (paramFloat1 < 0.0F)
        {
          if (f5 > this.mgX.left) {
            this.mhd = true;
          }
          f1 = paramFloat1;
          if (f5 > this.mgX.left)
          {
            if (f4 >= this.jWD) {
              break label1276;
            }
            f1 = paramFloat1;
          }
        }
      }
    }
    for (;;)
    {
      if (paramFloat2 != 0.0F)
      {
        this.vlz = true;
        if (paramFloat2 < 0.0F)
        {
          if (f6 > this.mgX.top) {
            this.mhb = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > this.mgX.top)
          {
            if (f7 >= this.jWE) {
              break label1392;
            }
            paramFloat1 = paramFloat2;
          }
        }
      }
      for (;;)
      {
        this.mhn.G(-f1, -paramFloat1);
        GMTrace.o(2037693546496L, 15182);
        return true;
        label1276:
        if ((f5 <= this.mgX.left) || (f5 >= this.jWD * 0.3F)) {
          break label1659;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        if (f4 < this.mgX.right) {
          this.mhe = true;
        }
        f1 = paramFloat1;
        if (f5 > 0.0F) {
          break;
        }
        f1 = paramFloat1;
        if (f4 >= this.jWD) {
          break;
        }
        if ((f4 <= this.jWD * 0.7F) || (f4 >= this.jWE)) {
          break label1659;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        label1392:
        if ((f6 > this.mgX.top) && (f6 < this.jWE * 0.3F))
        {
          paramFloat1 = paramFloat2 * 0.3F;
          continue;
          if (f7 < this.mgX.bottom) {
            this.mhc = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > 0.0F) {
            continue;
          }
          paramFloat1 = paramFloat2;
          if (f7 >= this.jWE) {
            continue;
          }
          if ((f7 > this.jWE * 0.7F) && (f7 < this.jWE))
          {
            paramFloat1 = paramFloat2 * 0.3F;
            continue;
            if (a(f5, f4, (View)localObject1, paramFloat1))
            {
              GMTrace.o(2037693546496L, 15182);
              return true;
            }
            if (paramFloat1 > 0.0F)
            {
              if (f4 <= this.jWD)
              {
                bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
                GMTrace.o(2037693546496L, 15182);
                return bool;
              }
            }
            else if (f5 >= 0.0F)
            {
              bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
              GMTrace.o(2037693546496L, 15182);
              return bool;
            }
            if (!this.vlA) {
              this.mhn.G(-paramFloat1, -paramFloat2);
            }
            GMTrace.o(2037693546496L, 15182);
            return true;
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
            GMTrace.o(2037693546496L, 15182);
            return bool;
          }
        }
        paramFloat1 = 0.0F;
      }
      label1659:
      f1 = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(2038498852864L, 15188);
    this.mgW.onTouchEvent(paramMotionEvent);
    v.d("dktest", "onTouchEvent event.getAction()" + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      computeScroll();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      GMTrace.o(2038498852864L, 15188);
      return bool;
      Object localObject = getSelectedView();
      if ((localObject instanceof MultiTouchImageView))
      {
        this.mhn = ((MultiTouchImageView)localObject);
        float f2 = this.mhn.getScale() * this.mhn.imageWidth;
        float f1 = this.mhn.getScale() * this.mhn.imageHeight;
        if (((int)f2 <= this.jWD) && ((int)f1 <= this.jWE))
        {
          v.i("dktest", "onTouchEvent width:" + f2 + "height:" + f1);
        }
        else
        {
          localObject = new float[9];
          this.mhn.getImageMatrix().getValues((float[])localObject);
          f2 = localObject[5];
          v.d("dktest", "onTouchEvent top:" + f2 + " height:" + f1 + " bottom:" + (f2 + f1));
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    GMTrace.i(2038767288320L, 15190);
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
    GMTrace.o(2038767288320L, 15190);
  }
  
  private abstract class a
  {
    protected boolean mhk;
    
    public a()
    {
      GMTrace.i(1929245622272L, 14374);
      this.mhk = false;
      GMTrace.o(1929245622272L, 14374);
    }
    
    public final boolean ayY()
    {
      GMTrace.i(1929379840000L, 14375);
      boolean bool = this.mhk;
      GMTrace.o(1929379840000L, 14375);
      return bool;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b
  {
    public abstract void C(float paramFloat1, float paramFloat2);
    
    public abstract void D(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface c
  {
    public abstract void atY();
  }
  
  private final class d
    extends GestureDetector.SimpleOnGestureListener
  {
    private d()
    {
      GMTrace.i(1919850381312L, 14304);
      GMTrace.o(1919850381312L, 14304);
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      GMTrace.i(1919984599040L, 14305);
      GMTrace.o(1919984599040L, 14305);
      return true;
    }
  }
  
  public static abstract interface e
  {
    public abstract void bkm();
  }
  
  public static abstract interface f
  {
    public abstract void ahu();
  }
  
  private final class g
    extends MMGestureGallery.a
  {
    public float[] mhm;
    
    public g()
    {
      super();
      GMTrace.i(1929916710912L, 14379);
      this.mhm = new float[9];
      GMTrace.o(1929916710912L, 14379);
    }
    
    public final void play()
    {
      GMTrace.i(1930050928640L, 14380);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1940788346880L, 14460);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.g.this.mhm);
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.a(MMGestureGallery.this).imageHeight * f1;
          float f3 = MMGestureGallery.g.this.mhm[5];
          f1 = MMGestureGallery.d(MMGestureGallery.this);
          if (f2 < MMGestureGallery.d(MMGestureGallery.this)) {
            f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.g.this.mhk = true;
          }
          for (;;)
          {
            MMGestureGallery.a(MMGestureGallery.this).G(0.0F, f1);
            GMTrace.o(1940788346880L, 14460);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.g.this.mhk = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      GMTrace.o(1930050928640L, 14380);
    }
  }
  
  private final class h
    extends MMGestureGallery.a
  {
    public float[] mhm;
    
    public h()
    {
      super();
      GMTrace.i(1968168763392L, 14664);
      this.mhm = new float[9];
      GMTrace.o(1968168763392L, 14664);
    }
    
    public final void play()
    {
      GMTrace.i(1968302981120L, 14665);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2033130143744L, 15148);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.h.this.mhm);
          float f4 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).imageWidth;
          float f7 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).imageHeight;
          float f6 = MMGestureGallery.h.this.mhm[2];
          float f9 = MMGestureGallery.h.this.mhm[5];
          float f5 = MMGestureGallery.h.this.mhm[2];
          float f8 = MMGestureGallery.h.this.mhm[5];
          float f1 = MMGestureGallery.d(MMGestureGallery.this);
          float f3 = MMGestureGallery.b(MMGestureGallery.this);
          float f2;
          if (f7 < MMGestureGallery.d(MMGestureGallery.this))
          {
            f2 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F;
            float f11 = f7 / 2.0F;
            f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F;
            float f10 = f7 / 2.0F;
            f2 -= f11;
            f1 += f10;
          }
          for (;;)
          {
            f2 -= f9;
            f1 -= f8 + f7;
            if (f2 < 0.0F) {
              f1 = f2;
            }
            for (;;)
            {
              if (f4 < MMGestureGallery.b(MMGestureGallery.this))
              {
                f3 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F;
                f8 = f4 / 2.0F;
                f2 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F;
                f7 = f4 / 2.0F;
                f3 -= f8;
                f2 += f7;
              }
              for (;;)
              {
                f3 -= f6;
                f2 -= f5 + f4;
                if (f3 < 0.0F) {
                  f2 = f3;
                }
                for (;;)
                {
                  label336:
                  if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
                    MMGestureGallery.h.this.mhk = true;
                  }
                  for (;;)
                  {
                    MMGestureGallery.a(MMGestureGallery.this).G(f2, f1);
                    GMTrace.o(2033130143744L, 15148);
                    return;
                    if (f1 <= 0.0F) {
                      break label546;
                    }
                    break;
                    if (f2 <= 0.0F) {
                      break label534;
                    }
                    break label336;
                    if (f2 >= 0.0F) {}
                    for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
                    {
                      if (f1 < 0.0F) {
                        break label504;
                      }
                      f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                      break;
                    }
                    label504:
                    f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                  }
                  label534:
                  f2 = 0.0F;
                }
                f2 = f3;
                f3 = 0.0F;
              }
              label546:
              f1 = 0.0F;
            }
            f2 = 0.0F;
          }
        }
      });
      GMTrace.o(1968302981120L, 14665);
    }
  }
  
  private final class i
    extends MMGestureGallery.a
  {
    public float[] mhm;
    
    public i()
    {
      super();
      GMTrace.i(1915958067200L, 14275);
      this.mhm = new float[9];
      GMTrace.o(1915958067200L, 14275);
    }
    
    public final void play()
    {
      GMTrace.i(1916092284928L, 14276);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1922534735872L, 14324);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.i.this.mhm);
          float f2 = MMGestureGallery.i.this.mhm[2];
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).imageWidth;
          if (f1 < MMGestureGallery.b(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.i.this.mhk = true;
            }
            for (;;)
            {
              MMGestureGallery.a(MMGestureGallery.this).G(f1, 0.0F);
              GMTrace.o(1922534735872L, 14324);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.i.this.mhk = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      GMTrace.o(1916092284928L, 14276);
    }
  }
  
  private final class j
    extends MMGestureGallery.a
  {
    public float[] mhm;
    
    public j()
    {
      super();
      GMTrace.i(2028969394176L, 15117);
      this.mhm = new float[9];
      GMTrace.o(2028969394176L, 15117);
    }
    
    public final void play()
    {
      GMTrace.i(2029103611904L, 15118);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1930319364096L, 14382);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.j.this.mhm);
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.a(MMGestureGallery.this).imageWidth * f1;
          float f3 = MMGestureGallery.j.this.mhm[2];
          f1 = MMGestureGallery.b(MMGestureGallery.this);
          if (f2 < MMGestureGallery.b(MMGestureGallery.this)) {
            f1 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.j.this.mhk = true;
          }
          for (;;)
          {
            MMGestureGallery.a(MMGestureGallery.this).G(f1, 0.0F);
            GMTrace.o(1930319364096L, 14382);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.j.this.mhk = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      GMTrace.o(2029103611904L, 15118);
    }
  }
  
  private final class k
    extends MMGestureGallery.a
  {
    public float[] mhm;
    
    public k()
    {
      super();
      GMTrace.i(1966960803840L, 14655);
      this.mhm = new float[9];
      GMTrace.o(1966960803840L, 14655);
    }
    
    public final void play()
    {
      GMTrace.i(1967095021568L, 14656);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1952331071488L, 14546);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.k.this.mhm);
          float f2 = MMGestureGallery.k.this.mhm[5];
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).imageHeight;
          if (f1 < MMGestureGallery.d(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.k.this.mhk = true;
            }
            for (;;)
            {
              MMGestureGallery.a(MMGestureGallery.this).G(0.0F, f1);
              GMTrace.o(1952331071488L, 14546);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.k.this.mhk = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      GMTrace.o(1967095021568L, 14656);
    }
  }
  
  public static final class l
    extends ad
  {
    private long mht;
    private boolean mhu;
    WeakReference<MMGestureGallery> vlU;
    
    public l(WeakReference<MMGestureGallery> paramWeakReference)
    {
      GMTrace.i(1947230797824L, 14508);
      this.vlU = paramWeakReference;
      GMTrace.o(1947230797824L, 14508);
    }
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      GMTrace.i(1947499233280L, 14510);
      this.mht = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      GMTrace.o(1947499233280L, 14510);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      GMTrace.i(1947365015552L, 14509);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.vlU != null)
      {
        final MMGestureGallery localMMGestureGallery = (MMGestureGallery)this.vlU.get();
        if (localMMGestureGallery != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MMGestureGallery.k(localMMGestureGallery) == 1) || (this.mhu))
            {
              v.d("MicroMsg.MMGestureGallery", "single click over!");
              if (MMGestureGallery.h(localMMGestureGallery) != null) {
                MMGestureGallery.c(localMMGestureGallery).post(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(1955686514688L, 14571);
                    MMGestureGallery.h(localMMGestureGallery).ahu();
                    GMTrace.o(1955686514688L, 14571);
                  }
                });
              }
            }
            MMGestureGallery.a(localMMGestureGallery, 0);
            GMTrace.o(1947365015552L, 14509);
            return;
          }
          if (paramMessage.what == 1)
          {
            if ((MMGestureGallery.R(localMMGestureGallery) != null) && (!MMGestureGallery.R(localMMGestureGallery).ayY()))
            {
              MMGestureGallery.R(localMMGestureGallery).play();
              sendEmptyMessageDelayed(paramMessage.what, this.mht);
              GMTrace.o(1947365015552L, 14509);
              return;
            }
            MMGestureGallery.S(localMMGestureGallery);
            GMTrace.o(1947365015552L, 14509);
            return;
          }
          removeMessages(2);
          if (MMGestureGallery.T(localMMGestureGallery) != null) {
            MMGestureGallery.c(localMMGestureGallery).post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(1930587799552L, 14384);
                MMGestureGallery.T(localMMGestureGallery).atY();
                GMTrace.o(1930587799552L, 14384);
              }
            });
          }
        }
      }
      GMTrace.o(1947365015552L, 14509);
    }
    
    public final void p(long paramLong, boolean paramBoolean)
    {
      GMTrace.i(1947633451008L, 14511);
      this.mhu = paramBoolean;
      d(0, paramLong, 0L);
      GMTrace.o(1947633451008L, 14511);
    }
    
    public final void release()
    {
      GMTrace.i(1947767668736L, 14512);
      removeMessages(0);
      removeMessages(1);
      removeMessages(2);
      GMTrace.o(1947767668736L, 14512);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/MMGestureGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */