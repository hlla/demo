package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bl.b;

public final class c
{
  public c()
  {
    GMTrace.i(1849386074112L, 13779);
    GMTrace.o(1849386074112L, 13779);
  }
  
  public static void eI(Context paramContext)
  {
    GMTrace.i(1849520291840L, 13780);
    paramContext = new a(paramContext, LayoutInflater.from(paramContext).inflate(R.i.doW, null));
    paramContext.fwb.addView(paramContext.fwa, paramContext.fwc);
    GMTrace.o(1849520291840L, 13780);
  }
  
  public static final class a
  {
    private ImageView fMP;
    public FrameLayout fwa;
    public WindowManager fwb;
    public WindowManager.LayoutParams fwc;
    private ViewGroup.LayoutParams fwd;
    private View mView;
    
    public a(final Context paramContext, View paramView)
    {
      GMTrace.i(1848178114560L, 13770);
      if ((this.fwa != null) && (this.fwb != null))
      {
        GMTrace.o(1848178114560L, 13770);
        return;
      }
      paramView.findViewById(R.h.clX).setVisibility(8);
      this.fMP = ((ImageView)paramView.findViewById(R.h.button));
      ((ImageView)paramView.findViewById(R.h.bHR)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1848043896832L, 13769);
          c.a.this.ol();
          GMTrace.o(1848043896832L, 13769);
        }
      });
      this.fwc = new WindowManager.LayoutParams();
      this.fwc.height = -2;
      this.fwc.width = -2;
      this.fwb = ((WindowManager)paramContext.getSystemService("window"));
      this.fwc.x = 0;
      this.fwc.y = 0;
      this.fwc.flags = 40;
      this.fwc.type = 2002;
      this.mView = paramView;
      this.fwc.gravity = 51;
      this.fwc.format = 1;
      this.fwa = new FrameLayout(paramContext);
      this.fwa.setPadding(4, 4, 4, 4);
      this.fwd = new ViewGroup.LayoutParams(-2, -2);
      this.fwa.addView(this.mView, this.fwd);
      paramContext = paramContext.getResources().getDisplayMetrics();
      this.fwa.setOnTouchListener(new View.OnTouchListener()
      {
        int vdr;
        int vds;
        int vdt;
        int vdu;
        long vdv;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(1846164848640L, 13755);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            GMTrace.o(1846164848640L, 13755);
            return false;
            this.vdr = ((int)paramAnonymousMotionEvent.getRawX() - c.a.this.fwc.x);
            this.vds = ((int)paramAnonymousMotionEvent.getRawY() - c.a.this.fwc.y);
            this.vdv = System.currentTimeMillis();
            continue;
            this.vdt = (paramContext.widthPixels - c.a.this.fwc.width - 1);
            this.vdu = (paramContext.heightPixels - c.a.this.fwc.height - 1);
            c.a.this.fwc.x = ((int)paramAnonymousMotionEvent.getRawX() - this.vdr);
            c.a.this.fwc.y = ((int)paramAnonymousMotionEvent.getRawY() - this.vds);
            paramAnonymousView = c.a.this.fwc;
            if (c.a.this.fwc.x < 0)
            {
              i = 0;
              label212:
              paramAnonymousView.x = i;
              paramAnonymousView = c.a.this.fwc;
              if (c.a.this.fwc.x <= this.vdt) {
                break label358;
              }
              i = this.vdt;
              label247:
              paramAnonymousView.x = i;
              paramAnonymousView = c.a.this.fwc;
              if (c.a.this.fwc.y >= 0) {
                break label372;
              }
              i = 0;
              label275:
              paramAnonymousView.y = i;
              paramAnonymousView = c.a.this.fwc;
              if (c.a.this.fwc.y <= this.vdu) {
                break label386;
              }
            }
            label358:
            label372:
            label386:
            for (int i = this.vdu;; i = c.a.this.fwc.y)
            {
              paramAnonymousView.y = i;
              c.a.this.fwb.updateViewLayout(c.a.this.fwa, c.a.this.fwc);
              break;
              i = c.a.this.fwc.x;
              break label212;
              i = c.a.this.fwc.x;
              break label247;
              i = c.a.this.fwc.y;
              break label275;
            }
            if (System.currentTimeMillis() - this.vdv < 300L)
            {
              b.bNW();
              b.G(false, true);
              c.a.this.ol();
            }
          }
        }
      });
      GMTrace.o(1848178114560L, 13770);
    }
    
    public final void ol()
    {
      GMTrace.i(1848312332288L, 13771);
      try
      {
        if (this.fwb != null)
        {
          if (this.fwa != null) {
            this.fwb.removeView(this.fwa);
          }
          this.fwb = null;
        }
        if (this.fwa != null)
        {
          this.fwa.removeAllViews();
          this.fwa = null;
        }
        this.mView = null;
        GMTrace.o(1848312332288L, 13771);
        return;
      }
      catch (Exception localException)
      {
        GMTrace.o(1848312332288L, 13771);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/applet/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */