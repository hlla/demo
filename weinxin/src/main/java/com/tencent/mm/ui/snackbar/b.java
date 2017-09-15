package com.tencent.mm.ui.snackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.x;
import java.util.Queue;

public final class b
{
  public ad mHandler;
  View mParentView;
  public SnackContainer whH;
  public b whI;
  c whJ;
  private final View.OnClickListener whK;
  
  public b(Activity paramActivity, int paramInt)
  {
    GMTrace.i(2863937880064L, 21338);
    this.mHandler = new ad();
    this.whK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2863401009152L, 21334);
        if ((b.this.whI != null) && (b.this.whH.isShowing())) {
          b.this.whI.aAm();
        }
        b.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2868501282816L, 21372);
            b.this.whH.hide();
            GMTrace.o(2868501282816L, 21372);
          }
        }, 100L);
        GMTrace.o(2863401009152L, 21334);
      }
    };
    Object localObject2 = ((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramActivity.findViewById(16908290);
    }
    localObject2 = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    ((LayoutInflater)localObject2).inflate(a.h.heB, (ViewGroup)localObject1);
    localObject2 = ((LayoutInflater)localObject2).inflate(a.h.heC, (ViewGroup)localObject1, false);
    a((ViewGroup)localObject1, (View)localObject2, paramInt, paramActivity);
    GMTrace.o(2863937880064L, 21338);
  }
  
  public b(Context paramContext, View paramView, int paramInt)
  {
    GMTrace.i(2864072097792L, 21339);
    this.mHandler = new ad();
    this.whK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2863401009152L, 21334);
        if ((b.this.whI != null) && (b.this.whH.isShowing())) {
          b.this.whI.aAm();
        }
        b.this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2868501282816L, 21372);
            b.this.whH.hide();
            GMTrace.o(2868501282816L, 21372);
          }
        }, 100L);
        GMTrace.o(2863401009152L, 21334);
      }
    };
    Object localObject = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    ((LayoutInflater)localObject).inflate(a.h.heB, (ViewGroup)paramView);
    localObject = ((LayoutInflater)localObject).inflate(a.h.heC, (ViewGroup)paramView, false);
    a((ViewGroup)paramView, (View)localObject, paramInt, paramContext);
    GMTrace.o(2864072097792L, 21339);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, int paramInt, Context paramContext)
  {
    GMTrace.i(2864206315520L, 21340);
    this.whH = ((SnackContainer)paramViewGroup.findViewById(a.g.hcT));
    if (this.whH == null) {
      this.whH = new SnackContainer(paramViewGroup);
    }
    this.mParentView = paramView;
    if (paramInt == 36) {
      this.whH.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(2869709242368L, 21381);
          if ((a.ash()) && (b.this.whH.isShowing()))
          {
            a.lA(false);
            b.this.mHandler.postDelayed(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2865414275072L, 21349);
                b.this.whH.hide();
                GMTrace.o(2865414275072L, 21349);
              }
            }, 100L);
          }
          GMTrace.o(2869709242368L, 21381);
          return true;
        }
      });
    }
    ((TextView)paramView.findViewById(a.g.hcS)).setOnClickListener(this.whK);
    boolean bool2 = x.eF(paramContext);
    paramInt = x.eE(paramContext);
    v.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(paramInt) });
    paramViewGroup = (Activity)paramContext;
    if (d.eo(19))
    {
      paramViewGroup = paramViewGroup.getWindow().getAttributes();
      if (paramViewGroup.flags != (paramViewGroup.flags & 0xF7FFFFFF | 0x8000000)) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      v.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[] { Boolean.valueOf(bool1) });
      if ((bool1) && (bool2))
      {
        paramViewGroup = (LinearLayout)paramView.findViewById(a.g.hcR);
        paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
        paramView.bottomMargin = paramInt;
        paramViewGroup.setLayoutParams(paramView);
      }
      GMTrace.o(2864206315520L, 21340);
      return;
    }
  }
  
  public static final class a
  {
    private Context mContext;
    String mMessage;
    String whC;
    private int whD;
    private Parcelable whE;
    private short whF;
    b whO;
    int whP;
    private int xT;
    
    public a(Activity paramActivity)
    {
      GMTrace.i(2860582436864L, 21313);
      this.whD = 0;
      this.whF = 3500;
      this.xT = -1;
      this.whP = 0;
      this.mContext = paramActivity.getApplicationContext();
      this.whO = new b(paramActivity, this.whP);
      GMTrace.o(2860582436864L, 21313);
    }
    
    public a(Context paramContext, View paramView)
    {
      GMTrace.i(2860716654592L, 21314);
      this.whD = 0;
      this.whF = 3500;
      this.xT = -1;
      this.whP = 0;
      this.mContext = paramContext;
      this.whO = new b(paramContext, paramView, this.whP);
      GMTrace.o(2860716654592L, 21314);
    }
    
    public final a a(Short paramShort)
    {
      GMTrace.i(2860850872320L, 21315);
      this.whF = paramShort.shortValue();
      GMTrace.o(2860850872320L, 21315);
      return this;
    }
    
    public final b bZf()
    {
      GMTrace.i(2861119307776L, 21317);
      Object localObject2 = this.mMessage;
      Object localObject1;
      int j;
      Object localObject3;
      short s;
      if (this.whC != null)
      {
        localObject1 = this.whC.toUpperCase();
        j = this.whD;
        localObject3 = this.whE;
        s = this.whF;
        if (this.xT == -1) {
          break label210;
        }
      }
      label210:
      for (int i = this.xT;; i = this.mContext.getResources().getColor(a.d.aWt))
      {
        localObject2 = new Snack((String)localObject2, (String)localObject1, j, (Parcelable)localObject3, s, i);
        Object localObject4 = this.whO;
        localObject1 = ((b)localObject4).whH;
        localObject3 = ((b)localObject4).mParentView;
        localObject4 = ((b)localObject4).whJ;
        if ((((View)localObject3).getParent() != null) && (((View)localObject3).getParent() != localObject1)) {
          ((ViewGroup)((View)localObject3).getParent()).removeView((View)localObject3);
        }
        localObject2 = new SnackContainer.a((Snack)localObject2, (View)localObject3, (b.c)localObject4);
        ((SnackContainer)localObject1).whQ.offer(localObject2);
        if (((SnackContainer)localObject1).whQ.size() == 1) {
          ((SnackContainer)localObject1).a((SnackContainer.a)localObject2, false);
        }
        localObject1 = this.whO;
        GMTrace.o(2861119307776L, 21317);
        return (b)localObject1;
        localObject1 = null;
        break;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void aAm();
  }
  
  public static abstract interface c
  {
    public abstract void azg();
    
    public abstract void azh();
    
    public abstract void onHide();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/snackbar/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */