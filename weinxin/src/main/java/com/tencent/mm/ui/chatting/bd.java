package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.o;

public final class bd
{
  public static b vAN;
  
  static
  {
    GMTrace.i(2300089204736L, 17137);
    vAN = new b();
    GMTrace.o(2300089204736L, 17137);
  }
  
  public static void dismiss()
  {
    GMTrace.i(2299820769280L, 17135);
    try
    {
      if (vAN != null) {
        vAN.dismiss();
      }
      GMTrace.o(2299820769280L, 17135);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", new Object[] { localException.getMessage() });
      GMTrace.o(2299820769280L, 17135);
    }
  }
  
  public static void dm(View paramView)
  {
    GMTrace.i(2299686551552L, 17134);
    Object localObject = vAN;
    if ((paramView == null) || (localObject == null))
    {
      v.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
      GMTrace.o(2299686551552L, 17134);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      dz localdz = dz.bWe();
      if ((Build.VERSION.SDK_INT >= 14) && (localdz.vLZ == null)) {
        localdz.vLZ = new dz.a((dz.b)localObject);
      }
      localObject = localdz.vLZ;
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 14) && ((localObject instanceof View.OnHoverListener))) {
        paramView.setOnHoverListener((View.OnHoverListener)localObject);
      }
    }
    GMTrace.o(2299686551552L, 17134);
  }
  
  public static void l(Context paramContext, String paramString, int paramInt)
  {
    GMTrace.i(16016604135424L, 119333);
    rr localrr = new rr();
    localrr.fYy.fJB = 5;
    localrr.fYy.fJC = paramString;
    localrr.fYy.context = paramContext;
    localrr.fYy.fYt = paramInt;
    a.uql.m(localrr);
    g.oSF.i(11033, new Object[] { Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0) });
    GMTrace.o(16016604135424L, 119333);
  }
  
  public static final class a
    implements View.OnTouchListener
  {
    private int sl;
    
    public a()
    {
      this(Color.argb(255, 136, 136, 136));
      GMTrace.i(2162247598080L, 16110);
      GMTrace.o(2162247598080L, 16110);
    }
    
    private a(int paramInt)
    {
      GMTrace.i(2162381815808L, 16111);
      this.sl = paramInt;
      GMTrace.o(2162381815808L, 16111);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      GMTrace.i(2162516033536L, 16112);
      int i = paramMotionEvent.getAction();
      if ((paramView instanceof ImageView))
      {
        paramView = ((ImageView)paramView).getDrawable();
        if (paramView != null)
        {
          if (i != 0) {
            break label67;
          }
          paramView.setColorFilter(this.sl, PorterDuff.Mode.MULTIPLY);
        }
      }
      for (;;)
      {
        GMTrace.o(2162516033536L, 16112);
        return false;
        paramView = paramView.getBackground();
        break;
        label67:
        if ((i == 3) || (i == 1)) {
          paramView.clearColorFilter();
        }
      }
    }
  }
  
  public static final class b
    implements View.OnClickListener, View.OnTouchListener, dz.b
  {
    public View Ih;
    private ai irw;
    private int jjy;
    public o vAO;
    private View vAP;
    private View vAQ;
    private int vAR;
    private int vAS;
    public int vAT;
    public int vAU;
    private int vAV;
    private boolean vAW;
    public bd.a vAX;
    private View.OnTouchListener vAY;
    public View vAZ;
    private int vBa;
    private ai.a vBb;
    
    public b()
    {
      GMTrace.i(2202915569664L, 16413);
      this.vAX = new bd.a();
      this.vAY = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(2142920245248L, 15966);
          if (bd.b.this.vAX != null) {
            bd.b.this.vAX.onTouch(bd.b.this.Ih, paramAnonymousMotionEvent);
          }
          GMTrace.o(2142920245248L, 15966);
          return false;
        }
      };
      this.vBa = 300;
      this.vBb = new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(2297136414720L, 17115);
          if ((bd.b.this.vAZ != null) && (bd.b.this.vAO != null)) {
            bd.b.this.vAO.showAsDropDown(bd.b.this.vAZ, bd.b.this.vAT, bd.b.this.vAU);
          }
          GMTrace.o(2297136414720L, 17115);
          return false;
        }
      };
      GMTrace.o(2202915569664L, 16413);
    }
    
    public final void dismiss()
    {
      GMTrace.i(2203049787392L, 16414);
      if (this.vAO != null) {
        this.vAO.dismiss();
      }
      GMTrace.o(2203049787392L, 16414);
    }
    
    public final boolean e(View paramView, MotionEvent paramMotionEvent)
    {
      GMTrace.i(2203184005120L, 16415);
      Object localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof ds)))
      {
        v.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
        GMTrace.o(2203184005120L, 16415);
        return false;
      }
      localObject1 = (ds)paramView.getTag();
      Object localObject2 = ((ds)localObject1).userName;
      Object localObject3 = m.xL();
      if ((u.mA((String)localObject3)) || (((String)localObject3).equals(localObject2))) {
        v.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
      }
      for (int i = 0; i == 0; i = 1)
      {
        GMTrace.o(2203184005120L, 16415);
        return false;
      }
      localObject2 = paramView.getContext();
      if (this.vAO == null)
      {
        localObject3 = ((Context)localObject2).getResources();
        float f = ((Resources)localObject3).getDimension(R.f.aXz);
        this.vAR = ((int)(((Resources)localObject3).getDimension(R.f.aWz) * 2.0F + f));
        this.Ih = View.inflate((Context)localObject2, R.i.cXp, null);
        this.vAP = this.Ih.findViewById(R.h.cLu);
        this.vAQ = this.Ih.findViewById(R.h.bqr);
        this.vAQ.setOnClickListener(this);
        this.vAP.setOnClickListener(this);
        this.vAQ.setOnTouchListener(this.vAY);
        this.vAP.setOnTouchListener(this.vAY);
        this.vAO = new o(this.Ih, -2, this.vAR, false);
        this.vAO.setOutsideTouchable(true);
        localObject3 = new Rect();
        if ((localObject2 instanceof Activity)) {
          ((Activity)localObject2).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
        }
        this.jjy = ((Rect)localObject3).top;
        localObject3 = ((Context)localObject2).getResources().getDisplayMetrics();
        if (((DisplayMetrics)localObject3).widthPixels > ((DisplayMetrics)localObject3).heightPixels)
        {
          this.vAS = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.aWQ);
          this.vAO.setBackgroundDrawable(new ColorDrawable(16777215));
          this.vAV = 0;
          this.irw = new ai(Looper.getMainLooper(), this.vBb, false);
          v.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
      }
      else
      {
        localObject2 = this.vAO;
        switch (paramMotionEvent.getAction())
        {
        }
      }
      do
      {
        for (;;)
        {
          GMTrace.o(2203184005120L, 16415);
          return true;
          this.vAS = ((Context)localObject2).getResources().getDimensionPixelSize(R.f.aWR);
          break;
          this.vAW = false;
          this.vAZ = null;
        }
        this.vAZ = paramView;
        paramView.setOnTouchListener(this);
        if (((o)localObject2).isShowing()) {
          ((o)localObject2).dismiss();
        }
      } while (this.vAW);
      this.vAQ.setTag(localObject1);
      this.vAP.setTag(localObject1);
      this.vAQ.setVisibility(0);
      this.vAP.setVisibility(8);
      paramMotionEvent = new int[2];
      paramView.getLocationInWindow(paramMotionEvent);
      i = paramMotionEvent[1];
      paramView.getWidth();
      int j = paramView.getHeight();
      this.vAU = this.vAV;
      if (i > this.jjy + this.vAS + this.vAR) {
        this.vAU = (-j - this.vAR - this.vAV);
      }
      this.vAT = 0;
      if (this.vAU >= 0) {
        this.Ih.setBackgroundResource(R.g.bec);
      }
      for (;;)
      {
        paramView = this.irw;
        long l = this.vBa;
        paramView.v(l, l);
        break;
        this.Ih.setBackgroundResource(R.g.bed);
      }
    }
    
    public final void onClick(View paramView)
    {
      GMTrace.i(2203452440576L, 16417);
      ds localds = (ds)paramView.getTag();
      if (paramView == this.vAQ) {
        bd.l(paramView.getContext(), localds.userName, 3);
      }
      for (;;)
      {
        dismiss();
        GMTrace.o(2203452440576L, 16417);
        return;
        bd.l(paramView.getContext(), localds.userName, 2);
      }
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      GMTrace.i(2203318222848L, 16416);
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        GMTrace.o(2203318222848L, 16416);
        return false;
        this.vAW = true;
        dismiss();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */