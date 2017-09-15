package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author=20, fComment="checked", lastDate="201400504", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
{
  private static Toast vfU;
  
  public static Dialog a(Context paramContext, String paramString, List<String> paramList, List<Integer> paramList1, d paramd)
  {
    GMTrace.i(3253571944448L, 24241);
    paramContext = b(paramContext, paramString, paramList, paramList1, null, true, paramd);
    GMTrace.o(3253571944448L, 24241);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, d paramd)
  {
    GMTrace.i(3253303508992L, 24239);
    paramContext = b(paramContext, paramString1, paramList, paramList1, paramString2, true, paramd);
    GMTrace.o(3253303508992L, 24239);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, List<String> paramList, List<Integer> paramList1, String paramString2, boolean paramBoolean, d paramd)
  {
    GMTrace.i(3253437726720L, 24240);
    paramContext = b(paramContext, paramString1, paramList, paramList1, paramString2, paramBoolean, paramd);
    GMTrace.o(3253437726720L, 24240);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString, String[] paramArrayOfString, c paramc)
  {
    GMTrace.i(3253840379904L, 24243);
    paramContext = a(paramContext, paramString, paramArrayOfString, null, true, paramc, null);
    GMTrace.o(3253840379904L, 24243);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, c paramc)
  {
    GMTrace.i(3253974597632L, 24244);
    paramContext = a(paramContext, paramString1, paramArrayOfString, paramString2, true, paramc, null);
    GMTrace.o(3253974597632L, 24244);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, c paramc, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3254243033088L, 24246);
    paramContext = a(paramContext, paramString1, paramArrayOfString, paramString2, true, paramc, paramOnCancelListener);
    GMTrace.o(3254243033088L, 24246);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean, c paramc)
  {
    GMTrace.i(3254108815360L, 24245);
    paramContext = a(paramContext, paramString1, paramArrayOfString, paramString2, paramBoolean, paramc, null);
    GMTrace.o(3254108815360L, 24245);
    return paramContext;
  }
  
  @Deprecated
  public static Dialog a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean, c paramc, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3254377250816L, 24247);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3254377250816L, 24247);
      return null;
    }
    if (((paramArrayOfString == null) || (paramArrayOfString.length == 0)) && (bf.mA(paramString2)))
    {
      GMTrace.o(3254377250816L, 24247);
      return null;
    }
    final ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Collections.addAll(localArrayList, paramArrayOfString);
    }
    if (!bf.mA(paramString2)) {
      localArrayList.add(paramString2);
    }
    if (paramBoolean)
    {
      paramArrayOfString = new com.tencent.mm.ui.tools.l(paramContext);
      paramArrayOfString.qHD = new n.c()
      {
        public final void a(l paramAnonymousl)
        {
          GMTrace.i(3337189588992L, 24864);
          paramAnonymousl.setHeaderTitle(this.ihG);
          int i = 0;
          while (i < localArrayList.size())
          {
            paramAnonymousl.e(i, (CharSequence)localArrayList.get(i));
            i += 1;
          }
          GMTrace.o(3337189588992L, 24864);
        }
      };
      paramArrayOfString.qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(3287394811904L, 24493);
          if (this.vfX != null) {
            this.vfX.hp(paramAnonymousMenuItem.getItemId());
          }
          GMTrace.o(3287394811904L, 24493);
        }
      };
      paramArrayOfString.e(paramOnCancelListener);
      paramString1 = paramArrayOfString.bkT();
      a(paramContext, paramString1);
      GMTrace.o(3254377250816L, 24247);
      return paramString1;
    }
    paramContext = new e(paramContext, e.wsK, false);
    paramContext.qHD = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        GMTrace.i(3281891885056L, 24452);
        paramAnonymousl.setHeaderTitle(this.ihG);
        int i = 0;
        while (i < localArrayList.size())
        {
          paramAnonymousl.e(i, (CharSequence)localArrayList.get(i));
          i += 1;
        }
        GMTrace.o(3281891885056L, 24452);
      }
    };
    paramContext.qHE = new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(3184181379072L, 23724);
        if (this.vfX != null) {
          this.vfX.hp(paramAnonymousMenuItem.getItemId());
        }
        GMTrace.o(3184181379072L, 23724);
      }
    };
    paramContext.byZ();
    GMTrace.o(3254377250816L, 24247);
    return null;
  }
  
  public static h a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3251021807616L, 24222);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3251021807616L, 24222);
      return null;
    }
    h.a locala = new h.a(paramContext);
    if (paramInt2 != 0) {
      locala.zR(paramInt2);
    }
    locala.zS(paramInt1);
    locala.zU(paramInt3).a(paramOnClickListener1);
    locala.zV(paramInt4).b(paramOnClickListener2);
    locala.d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3277865353216L, 24422);
        if (this.rYL != null) {
          this.rYL.onClick(paramAnonymousDialogInterface, 0);
        }
        GMTrace.o(3277865353216L, 24422);
      }
    });
    paramOnClickListener1 = locala.WD();
    paramOnClickListener1.show();
    a(paramContext, paramOnClickListener1);
    GMTrace.o(3251021807616L, 24222);
    return paramOnClickListener1;
  }
  
  public static h a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt5)
  {
    GMTrace.i(3250887589888L, 24221);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label76;
      }
    }
    label76:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramContext.getString(paramInt3), paramContext.getString(paramInt4), false, paramOnClickListener1, paramOnClickListener2, paramInt5);
      GMTrace.o(3250887589888L, 24221);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static h a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3250753372160L, 24220);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label75;
      }
    }
    label75:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramContext.getString(paramInt3), paramContext.getString(paramInt4), paramBoolean, paramOnClickListener1, paramOnClickListener2);
      GMTrace.o(3250753372160L, 24220);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static h a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3249142759424L, 24208);
    paramContext = a(paramContext, paramInt1, paramInt2, true, paramOnClickListener);
    GMTrace.o(3249142759424L, 24208);
    return paramContext;
  }
  
  public static h a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3250484936704L, 24218);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label61;
      }
    }
    label61:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, paramOnClickListener1, paramOnClickListener2);
      GMTrace.o(3250484936704L, 24218);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static h a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3249276977152L, 24209);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3249276977152L, 24209);
      return null;
    }
    h.a locala = new h.a(paramContext);
    if (paramInt2 > 0) {
      locala.zR(paramInt2);
    }
    locala.zS(paramInt1);
    locala.zU(a.k.dHL).a(paramOnClickListener);
    locala.kH(paramBoolean);
    paramOnClickListener = locala.WD();
    paramOnClickListener.show();
    a(paramContext, paramOnClickListener);
    GMTrace.o(3249276977152L, 24209);
    return paramOnClickListener;
  }
  
  public static h a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3251692896256L, 24227);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3251692896256L, 24227);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString);
    locala.db(paramView);
    locala.zU(a.k.dHL).a(paramOnClickListener);
    paramString = locala.WD();
    paramString.show();
    a(paramContext, paramString);
    GMTrace.o(3251692896256L, 24227);
    return paramString;
  }
  
  public static h a(Context paramContext, String paramString, View paramView, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3252363984896L, 24232);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3252363984896L, 24232);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString);
    locala.SW(null);
    locala.db(paramView);
    locala.zU(a.k.dHL).a(paramOnClickListener1);
    locala.zV(a.k.dGk).b(paramOnClickListener2);
    locala.d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3201227030528L, 23851);
        if (this.rYL != null) {
          this.rYL.onClick(paramAnonymousDialogInterface, 0);
        }
        GMTrace.o(3201227030528L, 23851);
      }
    });
    paramString = locala.WD();
    paramString.show();
    a(paramContext, paramString);
    GMTrace.o(3252363984896L, 24232);
    return paramString;
  }
  
  public static h a(Context paramContext, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3251827113984L, 24228);
    paramContext = a(paramContext, true, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    GMTrace.o(3251827113984L, 24228);
    return paramContext;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3249411194880L, 24210);
    paramContext = a(paramContext, paramString1, paramString2, true, paramOnClickListener);
    GMTrace.o(3249411194880L, 24210);
    return paramContext;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3252766638080L, 24235);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3252766638080L, 24235);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.zU(a.k.dHL).a(paramOnClickListener);
    locala.d(paramOnCancelListener);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3252766638080L, 24235);
    return paramString1;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3249948065792L, 24214);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3249948065792L, 24214);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.zU(a.k.dHL).a(paramOnClickListener1);
    locala.zV(a.k.dGk).b(paramOnClickListener2);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3249948065792L, 24214);
    return paramString1;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, View paramView, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3252229767168L, 24231);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3252229767168L, 24231);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString1);
    locala.db(paramView);
    locala.SY(paramString2).a(paramOnClickListener);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3252229767168L, 24231);
    return paramString1;
  }
  
  public static h a(final Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, b paramb)
  {
    GMTrace.i(3252498202624L, 24233);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3252498202624L, 24233);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.kH(false);
    locala.kI(true);
    locala.zV(a.k.dGk).b(null);
    locala.SV(paramString1);
    paramString1 = View.inflate(paramContext, a.h.hdQ, null);
    final MMEditText localMMEditText = (MMEditText)paramString1.findViewById(a.g.bKI);
    if (!bf.mA(paramString2)) {
      localMMEditText.Uw(paramString2);
    }
    paramString2 = (TextView)paramString1.findViewById(a.g.cIJ);
    if (bf.mA(paramString3)) {
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      locala.zU(a.k.dHL).a(false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3153848172544L, 23498);
          boolean bool = true;
          if (this.rNh != null) {
            bool = this.rNh.u(localMMEditText.getText().toString().trim());
          }
          if (bool)
          {
            paramAnonymousDialogInterface.dismiss();
            if ((paramContext instanceof MMActivity)) {
              ae.v(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(3153445519360L, 23495);
                  ((MMActivity)g.12.this.val$context).aGY();
                  GMTrace.o(3153445519360L, 23495);
                }
              });
            }
          }
          GMTrace.o(3153848172544L, 23498);
        }
      });
      if (paramInt > 0) {
        c.d(localMMEditText).Cc(paramInt).a(null);
      }
      locala.db(paramString1);
      paramString2 = locala.WD();
      paramString2.show();
      a(paramContext, paramString2);
      if ((paramContext instanceof MMActivity)) {
        paramString1.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3308735430656L, 24652);
            ((MMActivity)this.val$context).aHc();
            GMTrace.o(3308735430656L, 24652);
          }
        });
      }
      GMTrace.o(3252498202624L, 24233);
      return paramString2;
      paramString2.setText(paramString3);
    }
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3249679630336L, 24212);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, true, paramOnClickListener);
    GMTrace.o(3249679630336L, 24212);
    return paramContext;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    GMTrace.i(3251290243072L, 24224);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3251290243072L, 24224);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.SY(paramString3).a(paramOnClickListener1);
    locala.SZ(paramString4).b(paramOnClickListener2);
    paramString1 = locala.WD();
    paramString1.zP(paramContext.getResources().getColor(paramInt));
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3251290243072L, 24224);
    return paramString1;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3250216501248L, 24216);
    paramContext = a(paramContext, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramOnClickListener1, paramOnClickListener2, -1);
    GMTrace.o(3250216501248L, 24216);
    return paramContext;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    GMTrace.i(3250350718976L, 24217);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3250350718976L, 24217);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.SY(paramString3).a(paramOnClickListener1);
    locala.SZ(paramString4).b(paramOnClickListener2);
    locala.kH(paramBoolean);
    paramString1 = locala.WD();
    if (paramInt > 0) {
      paramString1.zP(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3250350718976L, 24217);
    return paramString1;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3249813848064L, 24213);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3249813848064L, 24213);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.SY(paramString3).a(paramOnClickListener);
    locala.kH(paramBoolean);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3249813848064L, 24213);
    return paramString1;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    GMTrace.i(3249545412608L, 24211);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3249545412608L, 24211);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.zU(a.k.dHL).a(paramOnClickListener);
    locala.kH(paramBoolean);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3249545412608L, 24211);
    return paramString1;
  }
  
  public static h a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3250082283520L, 24215);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3250082283520L, 24215);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.zU(a.k.dHL).a(paramOnClickListener1);
    locala.zV(a.k.dGk).b(paramOnClickListener2);
    locala.kH(paramBoolean);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3250082283520L, 24215);
    return paramString1;
  }
  
  public static h a(Context paramContext, String paramString, List<String> paramList, int paramInt, final a parama)
  {
    GMTrace.i(3252632420352L, 24234);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3252632420352L, 24234);
      return null;
    }
    if (paramList.isEmpty())
    {
      v.w("MicroMsg.MMAlert", "show switch alert fail");
      GMTrace.o(3252632420352L, 24234);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.kH(false);
    locala.zV(a.k.dGk);
    locala.SV(paramString);
    View localView = View.inflate(paramContext, a.h.dil, null);
    paramString = (LinearLayout)localView.findViewById(a.g.cGQ);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      TextView localTextView = (TextView)View.inflate(paramContext, a.h.dlx, null);
      localTextView.setText((CharSequence)paramList.get(i));
      if (i == paramInt) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(a.j.dyU, 0, 0, 0);
      }
      if (i == paramList.size() - 1)
      {
        paramContext.getResources().getDimensionPixelSize(a.e.aXG);
        localTextView.setBackgroundResource(a.f.bkn);
      }
      localTextView.setTag(Integer.valueOf(i));
      paramString.addView(localTextView, 0);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3200287506432L, 23844);
          int i = 0;
          while (i < this.pim.getChildCount())
          {
            TextView localTextView = (TextView)this.pim.getChildAt(i);
            if (localTextView.getId() != a.g.cIJ) {
              localTextView.setCompoundDrawablesWithIntrinsicBounds(a.j.dyT, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(a.j.dyU, 0, 0, 0);
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(3331015573504L, 24818);
              ((Dialog)g.14.this.pim.getTag()).dismiss();
              if (g.14.this.vga != null) {
                g.14.this.vga.rK(this.vgb);
              }
              GMTrace.o(3331015573504L, 24818);
            }
          });
          GMTrace.o(3200287506432L, 23844);
        }
      });
      i -= 1;
    }
    locala.db(localView);
    paramList = locala.WD();
    paramString.setTag(paramList);
    paramList.show();
    a(paramContext, paramList);
    GMTrace.o(3252632420352L, 24234);
    return paramList;
  }
  
  public static h a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3251961331712L, 24229);
    paramContext = a(paramContext, paramBoolean, paramString1, paramView, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, -1);
    GMTrace.o(3251961331712L, 24229);
    return paramContext;
  }
  
  public static h a(Context paramContext, boolean paramBoolean, String paramString1, View paramView, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    GMTrace.i(3252095549440L, 24230);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3252095549440L, 24230);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString1);
    locala.db(paramView);
    locala.SY(paramString2).a(paramOnClickListener1);
    locala.SZ(paramString3).b(paramOnClickListener2);
    locala.kH(paramBoolean);
    paramString1 = locala.WD();
    if (paramInt > 0) {
      paramString1.zP(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3252095549440L, 24230);
    return paramString1;
  }
  
  public static h a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3251424460800L, 24225);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3251424460800L, 24225);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.SY(paramString3).a(paramOnClickListener1);
    locala.SZ(paramString4).b(paramOnClickListener2);
    locala.kH(paramBoolean);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3251424460800L, 24225);
    return paramString1;
  }
  
  public static h a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    GMTrace.i(18741895102464L, 139638);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(18741895102464L, 139638);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.SY(paramString3).a(paramOnClickListener1);
    locala.SZ(paramString4).b(paramOnClickListener2);
    locala.kH(paramBoolean);
    paramString1 = locala.WD();
    if (paramInt > 0) {
      paramString1.zP(paramContext.getResources().getColor(paramInt));
    }
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(18741895102464L, 139638);
    return paramString1;
  }
  
  private static p a(Context paramContext, int paramInt, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3253169291264L, 24238);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3253169291264L, 24238);
      return null;
    }
    x.a(true, null);
    paramString = p.b(paramContext, paramString, paramBoolean, paramInt, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3158277357568L, 23531);
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)this.vgd.get();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        x.a(false, null);
        GMTrace.o(3158277357568L, 23531);
      }
    });
    a(paramContext, paramString);
    GMTrace.o(3253169291264L, 24238);
    return paramString;
  }
  
  public static p a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3253035073536L, 24237);
    paramContext = a(paramContext, 2, paramString, true, paramOnCancelListener);
    GMTrace.o(3253035073536L, 24237);
    return paramContext;
  }
  
  public static p a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3252900855808L, 24236);
    paramContext = a(paramContext, 0, paramString, paramBoolean, paramOnCancelListener);
    GMTrace.o(3252900855808L, 24236);
    return paramContext;
  }
  
  public static void a(Context paramContext, Dialog paramDialog)
  {
    GMTrace.i(3248203235328L, 24201);
    if ((paramContext instanceof MMActivity)) {
      ((MMActivity)paramContext).a(paramDialog);
    }
    GMTrace.o(3248203235328L, 24201);
  }
  
  @Deprecated
  private static Dialog b(Context paramContext, String paramString1, List<String> paramList, final List<Integer> paramList1, final String paramString2, boolean paramBoolean, d paramd)
  {
    GMTrace.i(3253706162176L, 24242);
    if (((paramList == null) || (paramList.size() == 0)) && (bf.mA(paramString2)))
    {
      GMTrace.o(3253706162176L, 24242);
      return null;
    }
    final Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (paramBoolean)
    {
      paramList = new com.tencent.mm.ui.tools.l(paramContext);
      paramList.qHD = new n.c()
      {
        public final void a(l paramAnonymousl)
        {
          GMTrace.i(3315446317056L, 24702);
          if (!bf.mA(this.ihG)) {
            paramAnonymousl.setHeaderTitle(this.ihG);
          }
          int i = 0;
          while (i < localObject.size())
          {
            paramAnonymousl.e(((Integer)paramList1.get(i)).intValue(), (CharSequence)localObject.get(i));
            i += 1;
          }
          if (!bf.mA(paramString2)) {
            paramAnonymousl.e(-1, paramString2);
          }
          GMTrace.o(3315446317056L, 24702);
        }
      };
      paramList.qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(3176262533120L, 23665);
          if (this.vfW != null) {
            this.vfW.bN(paramAnonymousInt, paramAnonymousMenuItem.getItemId());
          }
          GMTrace.o(3176262533120L, 23665);
        }
      };
      paramList.e(null);
      paramString1 = paramList.bkT();
      a(paramContext, paramString1);
      GMTrace.o(3253706162176L, 24242);
      return paramString1;
    }
    paramContext = new e(paramContext, e.wsK, false);
    paramContext.qHD = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        GMTrace.i(3172370219008L, 23636);
        if (!bf.mA(this.ihG)) {
          paramAnonymousl.setHeaderTitle(this.ihG);
        }
        int i = 0;
        while (i < localObject.size())
        {
          paramAnonymousl.e(((Integer)paramList1.get(i)).intValue(), (CharSequence)localObject.get(i));
          i += 1;
        }
        if (!bf.mA(paramString2)) {
          paramAnonymousl.e(-1, paramString2);
        }
        GMTrace.o(3172370219008L, 23636);
      }
    };
    paramContext.qHE = new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(3299205971968L, 24581);
        if (this.vfW != null) {
          this.vfW.bN(paramAnonymousInt, paramAnonymousMenuItem.getItemId());
        }
        GMTrace.o(3299205971968L, 24581);
      }
    };
    paramContext.byZ();
    GMTrace.o(3253706162176L, 24242);
    return null;
  }
  
  public static h b(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3250619154432L, 24219);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label62;
      }
    }
    label62:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = a(paramContext, str1, str2, false, paramOnClickListener1, paramOnClickListener2);
      GMTrace.o(3250619154432L, 24219);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static h b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(3251156025344L, 24223);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3251156025344L, 24223);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.SY(paramString3).a(paramOnClickListener1);
    locala.SZ(paramString4).b(paramOnClickListener2);
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3251156025344L, 24223);
    return paramString1;
  }
  
  public static h b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    GMTrace.i(3248874323968L, 24206);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      GMTrace.o(3248874323968L, 24206);
      return null;
    }
    h.a locala = new h.a(paramContext);
    locala.SV(paramString2);
    locala.SW(paramString1);
    locala.kH(paramBoolean);
    locala.zU(a.k.dHL).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(3198542675968L, 23831);
        paramAnonymousDialogInterface.cancel();
        GMTrace.o(3198542675968L, 23831);
      }
    });
    paramString1 = locala.WD();
    paramString1.show();
    a(paramContext, paramString1);
    GMTrace.o(3248874323968L, 24206);
    return paramString1;
  }
  
  public static Toast bh(Context paramContext, String paramString)
  {
    GMTrace.i(3248337453056L, 24202);
    paramContext = bk(paramContext, paramString);
    GMTrace.o(3248337453056L, 24202);
    return paramContext;
  }
  
  public static Toast bi(Context paramContext, String paramString)
  {
    GMTrace.i(3248471670784L, 24203);
    paramContext = bk(paramContext, paramString);
    GMTrace.o(3248471670784L, 24203);
    return paramContext;
  }
  
  public static void bj(Context paramContext, String paramString)
  {
    GMTrace.i(15231296208896L, 113482);
    if (vfU == null) {
      vfU = Toast.makeText(paramContext, paramString, 0);
    }
    for (;;)
    {
      vfU.show();
      GMTrace.o(15231296208896L, 113482);
      return;
      vfU.setText(paramString);
    }
  }
  
  public static Toast bk(Context paramContext, String paramString)
  {
    GMTrace.i(3248605888512L, 24204);
    paramContext = Toast.makeText(paramContext, paramString, 0);
    paramContext.show();
    GMTrace.o(3248605888512L, 24204);
    return paramContext;
  }
  
  public static h h(Context paramContext, int paramInt1, int paramInt2)
  {
    GMTrace.i(3249008541696L, 24207);
    String str1;
    if (paramInt1 > 0)
    {
      str1 = paramContext.getString(paramInt1);
      if (paramInt2 <= 0) {
        break label56;
      }
    }
    label56:
    for (String str2 = paramContext.getString(paramInt2);; str2 = "")
    {
      paramContext = b(paramContext, str1, str2, true);
      GMTrace.o(3249008541696L, 24207);
      return paramContext;
      str1 = "";
      break;
    }
  }
  
  public static h z(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(3248740106240L, 24205);
    paramContext = b(paramContext, paramString1, paramString2, true);
    GMTrace.o(3248740106240L, 24205);
    return paramContext;
  }
  
  public static abstract interface a
  {
    public abstract void rK(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean u(CharSequence paramCharSequence);
  }
  
  public static abstract interface c
  {
    public abstract void hp(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bN(int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */