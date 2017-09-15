package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bl.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public final class d
{
  public static int vdF;
  
  static
  {
    GMTrace.i(1846701719552L, 13759);
    vdF = 0;
    GMTrace.o(1846701719552L, 13759);
  }
  
  public d()
  {
    GMTrace.i(1846299066368L, 13756);
    GMTrace.o(1846299066368L, 13756);
  }
  
  public static void eJ(Context paramContext)
  {
    GMTrace.i(1846433284096L, 13757);
    if (vdF > 0)
    {
      GMTrace.o(1846433284096L, 13757);
      return;
    }
    paramContext = new a(paramContext, LayoutInflater.from(paramContext).inflate(R.i.doW, null));
    paramContext.fwb.addView(paramContext.fwa, paramContext.fwc);
    vdF += 1;
    GMTrace.o(1846433284096L, 13757);
  }
  
  public static final class a
  {
    public Context context;
    ImageView fMP;
    public ProgressBar fMR;
    public FrameLayout fwa;
    public WindowManager fwb;
    public WindowManager.LayoutParams fwc;
    private ViewGroup.LayoutParams fwd;
    View mView;
    public TextView mxJ;
    public boolean vdG;
    d.b vdH;
    com.tencent.mm.bl.d.a vdI;
    public int vdJ;
    ad vdK;
    
    public a(final Context paramContext, View paramView)
    {
      GMTrace.i(1852338864128L, 13801);
      this.vdG = false;
      this.vdH = new d.b()
      {
        public final void bOa()
        {
          GMTrace.i(1845896413184L, 13753);
          d.a.this.eK(d.a.this.context);
          Toast.makeText(d.a.this.context, "trace file has saved ", 0).show();
          GMTrace.o(1845896413184L, 13753);
        }
      };
      this.vdJ = 0;
      this.vdK = new ad()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          GMTrace.i(1852204646400L, 13800);
          if (d.a.this.mxJ.getVisibility() != 0)
          {
            d.a.this.vdJ = 0;
            GMTrace.o(1852204646400L, 13800);
            return;
          }
          d.a locala = d.a.this;
          locala.vdJ += 1;
          d.a.this.bRq();
          super.handleMessage(paramAnonymousMessage);
          GMTrace.o(1852204646400L, 13800);
        }
      };
      if ((this.fwa != null) && (this.fwb != null))
      {
        GMTrace.o(1852338864128L, 13801);
        return;
      }
      com.tencent.mm.bl.d.bNY().uLY = new WeakReference(this.vdH);
      this.mxJ = ((TextView)paramView.findViewById(R.h.cId));
      this.fMP = ((ImageView)paramView.findViewById(R.h.button));
      ((ImageView)paramView.findViewById(R.h.bHR)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1853278388224L, 13808);
          if ((d.a.this.vdG) && (d.a.this.fMR.getVisibility() != 0)) {
            com.tencent.mm.bl.d.bNY().b(d.a.this.vdI);
          }
          paramAnonymousView = d.a.this;
          try
          {
            if (paramAnonymousView.fwb != null)
            {
              if (paramAnonymousView.fwa != null) {
                paramAnonymousView.fwb.removeView(paramAnonymousView.fwa);
              }
              paramAnonymousView.fwb = null;
            }
            if (paramAnonymousView.fwa != null)
            {
              paramAnonymousView.fwa.removeAllViews();
              paramAnonymousView.fwa = null;
            }
            paramAnonymousView.mView = null;
          }
          catch (Exception paramAnonymousView)
          {
            for (;;) {}
          }
          d.vdF -= 1;
          GMTrace.o(1853278388224L, 13808);
        }
      });
      this.fMR = ((ProgressBar)paramView.findViewById(R.h.clX));
      this.fMR.setVisibility(8);
      this.context = paramContext;
      this.fwc = new WindowManager.LayoutParams();
      this.fwc.height = -2;
      this.fwc.width = -2;
      this.fwb = ((WindowManager)paramContext.getSystemService("window"));
      this.fwc.x = 0;
      this.fwc.y = 0;
      this.fwc.flags = 40;
      this.fwc.type = 2002;
      this.mView = paramView;
      this.mxJ.setVisibility(8);
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
          GMTrace.i(1853546823680L, 13810);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            GMTrace.o(1853546823680L, 13810);
            return false;
            this.vdr = ((int)paramAnonymousMotionEvent.getRawX() - d.a.this.fwc.x);
            this.vds = ((int)paramAnonymousMotionEvent.getRawY() - d.a.this.fwc.y);
            this.vdv = System.currentTimeMillis();
            continue;
            this.vdt = (paramContext.widthPixels - d.a.this.fwc.width - 1);
            this.vdu = (paramContext.heightPixels - d.a.this.fwc.height - 1);
            d.a.this.fwc.x = ((int)paramAnonymousMotionEvent.getRawX() - this.vdr);
            d.a.this.fwc.y = ((int)paramAnonymousMotionEvent.getRawY() - this.vds);
            paramAnonymousView = d.a.this.fwc;
            if (d.a.this.fwc.x < 0)
            {
              i = 0;
              label212:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.fwc;
              if (d.a.this.fwc.x <= this.vdt) {
                break label358;
              }
              i = this.vdt;
              label247:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.fwc;
              if (d.a.this.fwc.y >= 0) {
                break label372;
              }
              i = 0;
              label275:
              paramAnonymousView.y = i;
              paramAnonymousView = d.a.this.fwc;
              if (d.a.this.fwc.y <= this.vdu) {
                break label386;
              }
            }
            label358:
            label372:
            label386:
            for (int i = this.vdu;; i = d.a.this.fwc.y)
            {
              paramAnonymousView.y = i;
              d.a.this.fwb.updateViewLayout(d.a.this.fwa, d.a.this.fwc);
              break;
              i = d.a.this.fwc.x;
              break label212;
              i = d.a.this.fwc.x;
              break label247;
              i = d.a.this.fwc.y;
              break label275;
            }
            if (System.currentTimeMillis() - this.vdv < 300L)
            {
              paramAnonymousView = d.a.this;
              paramAnonymousView.vdK.removeMessages(0);
              paramAnonymousView.vdJ = 0;
              if (!paramAnonymousView.vdG) {
                break;
              }
              paramAnonymousView.fMR.setVisibility(0);
              paramAnonymousView.fMP.setVisibility(4);
              if (!com.tencent.mm.bl.d.bNY().b(paramAnonymousView.vdI)) {
                paramAnonymousView.eK(paramAnonymousView.context);
              }
            }
          }
          paramAnonymousView.fMP.setVisibility(0);
          paramAnonymousView.fMP.setBackgroundDrawable(paramAnonymousView.context.getResources().getDrawable(R.g.bkN));
          if (!paramAnonymousView.vdG) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.vdG = bool;
            paramAnonymousView.vdI = new com.tencent.mm.bl.d.a(null, 6, 8, 0);
            com.tencent.mm.bl.d.bNY().c(paramAnonymousView.vdI);
            paramAnonymousView.bRq();
            break;
          }
        }
      });
      GMTrace.o(1852338864128L, 13801);
    }
    
    public final void bRq()
    {
      GMTrace.i(1852607299584L, 13803);
      this.mxJ.setText(this.vdJ);
      this.vdK.sendEmptyMessageDelayed(0, 1000L);
      GMTrace.o(1852607299584L, 13803);
    }
    
    public final void eK(Context paramContext)
    {
      boolean bool = false;
      GMTrace.i(1852473081856L, 13802);
      this.fMP.setVisibility(0);
      this.fMR.setVisibility(4);
      if (!this.vdG) {
        bool = true;
      }
      this.vdG = bool;
      this.fMP.setBackgroundDrawable(paramContext.getResources().getDrawable(R.g.bkM));
      this.mxJ.setVisibility(8);
      GMTrace.o(1852473081856L, 13802);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/applet/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */