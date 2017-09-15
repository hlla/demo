package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.d;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

public final class s
  extends Toast
{
  private final Context context;
  public long duration;
  public final ai fyz;
  private View iUq;
  public int kmG;
  private int level;
  private final TextView mSa;
  
  public s(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(3242297655296L, 24157);
    this.fyz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3154116608000L, 23500);
        if (s.a(s.this) == -1L)
        {
          s.this.show();
          GMTrace.o(3154116608000L, 23500);
          return true;
        }
        s.b(s.this);
        if (s.c(s.this) >= 0)
        {
          s.this.show();
          GMTrace.o(3154116608000L, 23500);
          return true;
        }
        s.this.cancel();
        GMTrace.o(3154116608000L, 23500);
        return false;
      }
    }, true);
    this.context = paramContext;
    reset();
    this.iUq = View.inflate(paramContext, a.h.heF, null);
    setView(this.iUq);
    setGravity(55, 0, BackwardSupportUtil.b.a(paramContext, 40.0F));
    setDuration(0);
    this.mSa = ((TextView)this.iUq.findViewById(a.g.hdv));
    switch (this.level)
    {
    }
    for (;;)
    {
      GMTrace.o(3242297655296L, 24157);
      return;
      this.mSa.setTextColor(-1);
      GMTrace.o(3242297655296L, 24157);
      return;
      this.mSa.setTextColor(this.context.getResources().getColor(a.d.hbu));
    }
  }
  
  public static o a(final Activity paramActivity, int paramInt, String paramString)
  {
    GMTrace.i(3243102961664L, 24163);
    View localView = View.inflate(paramActivity, a.h.hdN, null);
    Object localObject = (TextView)localView.findViewById(a.g.cbp);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    paramString = (ImageView)localView.findViewById(a.g.cbo);
    if (paramInt == 0) {
      paramString.setVisibility(8);
    }
    for (;;)
    {
      paramString = new o(localView);
      paramString.setWidth(-1);
      paramString.setHeight(-2);
      localObject = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      int i = ((Rect)localObject).top;
      int j = bG(paramActivity);
      paramInt = i;
      if (i == 0) {
        paramInt = ab(paramActivity, 25);
      }
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18741760884736L, 139637);
          this.vlt.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, this.vlu);
          GMTrace.o(18741760884736L, 139637);
        }
      });
      ae.f(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18742029320192L, 139639);
          this.vlt.dismiss();
          GMTrace.o(18742029320192L, 139639);
        }
      }, 2000L);
      paramActivity = (ImageButton)localView.findViewById(a.g.cbn);
      paramActivity.setVisibility(8);
      paramActivity.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(18742431973376L, 139642);
          this.vlt.dismiss();
          GMTrace.o(18742431973376L, 139642);
        }
      });
      GMTrace.o(3243102961664L, 24163);
      return paramString;
      paramString.setImageResource(paramInt);
    }
  }
  
  public static o a(Activity paramActivity, String paramString, long paramLong)
  {
    GMTrace.i(3242834526208L, 24161);
    Object localObject = View.inflate(paramActivity, a.h.heF, null);
    ((TextView)((View)localObject).findViewById(a.g.hdv)).setText(paramString);
    paramString = new o((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = bG(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(3287126376448L, 24491);
        this.vlt.dismiss();
        super.handleMessage(paramAnonymousMessage);
        GMTrace.o(3287126376448L, 24491);
      }
    }.sendEmptyMessageDelayed(0, paramLong);
    GMTrace.o(3242834526208L, 24161);
    return paramString;
  }
  
  public static int ab(Context paramContext, int paramInt)
  {
    GMTrace.i(3243639832576L, 24167);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = bf.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      i = paramContext.getResources().getDimensionPixelSize(i);
      paramInt = i;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.MMToast", paramContext, "", new Object[0]);
      }
    }
    GMTrace.o(3243639832576L, 24167);
    return paramInt;
  }
  
  private static int bG(Context paramContext)
  {
    GMTrace.i(3242968743936L, 24162);
    int i;
    if (((paramContext instanceof ActionBarActivity)) && (((ActionBarActivity)paramContext).cO().cP() != null)) {
      i = ((ActionBarActivity)paramContext).cO().cP().getHeight();
    }
    for (;;)
    {
      GMTrace.o(3242968743936L, 24162);
      return i;
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = paramContext.getResources().getDimensionPixelSize(a.e.aWQ);
      } else {
        i = paramContext.getResources().getDimensionPixelSize(a.e.aWR);
      }
    }
  }
  
  public static void eP(Context paramContext)
  {
    GMTrace.i(3243237179392L, 24164);
    if (h.getExternalStorageState().equals("mounted_ro"))
    {
      a.ac(paramContext, 3);
      GMTrace.o(3243237179392L, 24164);
      return;
    }
    a.ac(paramContext, 1);
    GMTrace.o(3243237179392L, 24164);
  }
  
  public static void eQ(Context paramContext)
  {
    GMTrace.i(3243371397120L, 24165);
    a.ac(paramContext, 2);
    GMTrace.o(3243371397120L, 24165);
  }
  
  public static int eR(Context paramContext)
  {
    GMTrace.i(15690186620928L, 116901);
    int i = ab(paramContext, 25);
    GMTrace.o(15690186620928L, 116901);
    return i;
  }
  
  public final void reset()
  {
    GMTrace.i(3242700308480L, 24160);
    this.level = 1;
    this.duration = 2000L;
    this.kmG = ((int)(this.duration / 70L) + 1);
    GMTrace.o(3242700308480L, 24160);
  }
  
  public final void setText(int paramInt)
  {
    GMTrace.i(3242566090752L, 24159);
    this.mSa.setText(paramInt);
    GMTrace.o(3242566090752L, 24159);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    GMTrace.i(3242431873024L, 24158);
    this.mSa.setText(paramCharSequence);
    GMTrace.o(3242431873024L, 24158);
  }
  
  private static final class a
  {
    private static Toast sPG;
    public static int vlv;
    
    static
    {
      GMTrace.i(3369804496896L, 25107);
      sPG = null;
      vlv = 0;
      GMTrace.o(3369804496896L, 25107);
    }
    
    public static void ac(Context paramContext, int paramInt)
    {
      GMTrace.i(3369670279168L, 25106);
      paramContext = paramContext.getApplicationContext();
      if (vlv != paramInt)
      {
        sPG = null;
        vlv = paramInt;
      }
      if (sPG == null) {
        sPG = Toast.makeText(paramContext, "", 1);
      }
      paramContext = View.inflate(paramContext, a.h.hez, null);
      if (paramInt == 1) {
        ((TextView)paramContext.findViewById(a.g.hcP)).setText(a.k.heZ);
      }
      for (;;)
      {
        sPG.setView(paramContext);
        sPG.show();
        GMTrace.o(3369670279168L, 25106);
        return;
        if (paramInt == 3) {
          ((TextView)paramContext.findViewById(a.g.hcP)).setText(a.k.hfa);
        } else {
          ((TextView)paramContext.findViewById(a.g.hcP)).setText(a.k.hfb);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */