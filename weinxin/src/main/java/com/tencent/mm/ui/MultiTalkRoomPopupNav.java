package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.al.b;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.h;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiTalkRoomPopupNav
  extends LinearLayout
{
  public View uTA;
  public TextView uTB;
  public TextView uTC;
  public TextView uTD;
  public String uTE;
  public String uTF;
  public boolean uTG;
  public int uTH;
  public a uTI;
  private final int uTJ;
  public LinearLayout uTK;
  public boolean uTL;
  public b uTM;
  public LinearLayout uTz;
  
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1906428608512L, 14204);
    this.uTH = b.uTR;
    this.uTJ = 6;
    this.uTL = false;
    this.uTM = new b();
    KD();
    GMTrace.o(1906428608512L, 14204);
  }
  
  @TargetApi(11)
  public MultiTalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1906294390784L, 14203);
    this.uTH = b.uTR;
    this.uTJ = 6;
    this.uTL = false;
    this.uTM = new b();
    KD();
    GMTrace.o(1906294390784L, 14203);
  }
  
  private void KD()
  {
    GMTrace.i(1906562826240L, 14205);
    inflate(getContext(), R.i.djz, this);
    this.uTz = ((LinearLayout)findViewById(R.h.clF));
    this.uTA = findViewById(R.h.clE);
    this.uTB = ((TextView)findViewById(R.h.clI));
    this.uTC = ((TextView)findViewById(R.h.clJ));
    this.uTD = ((TextView)findViewById(R.h.clK));
    this.uTK = ((LinearLayout)findViewById(R.h.clA));
    this.uTz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2075811381248L, 15466);
        if ((l.a.szS != null) && (l.a.szT.aJ(MultiTalkRoomPopupNav.this.getContext())))
        {
          v.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
          GMTrace.o(2075811381248L, 15466);
          return;
        }
        if ((l.a.szS != null) && (l.a.szS.aGn()))
        {
          Toast.makeText(aa.getContext(), aa.getContext().getString(R.l.esq), 0).show();
          v.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
          GMTrace.o(2075811381248L, 15466);
          return;
        }
        MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
        GMTrace.o(2075811381248L, 15466);
      }
    });
    GMTrace.o(1906562826240L, 14205);
  }
  
  private void d(String paramString1, List<String> paramList, final String paramString2)
  {
    GMTrace.i(1906965479424L, 14208);
    this.uTA.setVisibility(8);
    this.uTz.setVisibility(8);
    if (this.uTH == b.uTP) {}
    a locala;
    View.OnClickListener local2;
    for (boolean bool = true;; bool = false)
    {
      this.uTI = new a(bool);
      if (l.a.szT == null) {
        break label293;
      }
      locala = this.uTI;
      local2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int i = 0;
          GMTrace.i(2070308454400L, 15425);
          v.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
          if (paramString2 != null)
          {
            if (l.a.szT.aMU())
            {
              v.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
              com.tencent.mm.ui.base.g.b(MultiTalkRoomPopupNav.this.getContext(), aa.getContext().getString(R.l.eBV), null, true);
              GMTrace.o(2070308454400L, 15425);
              return;
            }
            paramAnonymousView = l.a.szT.AZ(MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this));
            if (paramAnonymousView.size() != 1) {
              break label247;
            }
            MultiTalkRoomPopupNav.SI(paramString2);
            com.tencent.mm.plugin.report.service.g.oSF.i(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
          for (;;)
          {
            MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
            MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
            GMTrace.o(2070308454400L, 15425);
            return;
            label247:
            if (paramAnonymousView.size() >= 9)
            {
              v.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + paramAnonymousView.size());
              com.tencent.mm.ui.base.g.b(MultiTalkRoomPopupNav.this.getContext(), aa.getContext().getString(R.l.eBX, new Object[] { Integer.valueOf(9) }), null, true);
              paramAnonymousView = com.tencent.mm.plugin.report.service.g.oSF;
              if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.uTP) {
                i = 1;
              }
              paramAnonymousView.i(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
              GMTrace.o(2070308454400L, 15425);
              return;
            }
            if (l.a.szT.aMT())
            {
              v.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
              com.tencent.mm.ui.base.g.b(MultiTalkRoomPopupNav.this.getContext(), aa.getContext().getString(R.l.eBU), null, true);
              paramAnonymousView = com.tencent.mm.plugin.report.service.g.oSF;
              if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.uTP) {}
              for (i = 1;; i = 0)
              {
                paramAnonymousView.i(13945, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
                GMTrace.o(2070308454400L, 15425);
                return;
              }
            }
            MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, paramString2);
          }
        }
      };
      paramString2 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int i = 1;
          GMTrace.i(2087354105856L, 15552);
          v.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
          if (MultiTalkRoomPopupNav.d(MultiTalkRoomPopupNav.this) == MultiTalkRoomPopupNav.b.uTP)
          {
            v.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
            boolean bool = l.a.szT.Bb(paramString2);
            l.a.szT.Bc(paramString2);
            paramAnonymousView = com.tencent.mm.plugin.report.service.g.oSF;
            if (bool) {
              i = 0;
            }
            paramAnonymousView.i(13945, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
          for (;;)
          {
            MultiTalkRoomPopupNav.e(MultiTalkRoomPopupNav.this).close();
            MultiTalkRoomPopupNav.f(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.g(MultiTalkRoomPopupNav.this).setVisibility(0);
            MultiTalkRoomPopupNav.h(MultiTalkRoomPopupNav.this).setVisibility(8);
            GMTrace.o(2087354105856L, 15552);
            return;
            com.tencent.mm.plugin.report.service.g.oSF.i(13945, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(MultiTalkRoomPopupNav.this), Integer.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(MultiTalkRoomPopupNav.this).field_roomKey) });
          }
        }
      };
      locala.titleView.setText(paramString1);
      locala.uTO.setVisibility(0);
      locala.uTN.uTK.setVisibility(0);
      locala.uTN.uTK.removeAllViews();
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (String)paramString1.next();
        ImageView localImageView = new ImageView(locala.uTN.getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(aa.getContext(), 26), a.fromDPToPix(aa.getContext(), 26));
        localLayoutParams.rightMargin = a.fromDPToPix(aa.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        locala.uTN.uTK.addView(localImageView);
        a.b.a(localImageView, paramList, 0.1F, false);
      }
    }
    ((Button)locala.uTN.findViewById(R.h.clx)).setOnClickListener(local2);
    ((Button)locala.uTN.findViewById(R.h.clw)).setOnClickListener(paramString2);
    label293:
    GMTrace.o(1906965479424L, 14208);
  }
  
  public static List<String> k(List<String> paramList, String paramString)
  {
    GMTrace.i(1907233914880L, 14210);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = paramList;
    if (paramString != null)
    {
      localObject = paramList;
      if (paramString != "")
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          if ((localObject != null) && (!((String)localObject).equals(paramString))) {
            localArrayList1.add(localObject);
          }
        }
        localObject = localArrayList1;
      }
    }
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext()) {
      localArrayList2.add((String)paramList.next());
    }
    GMTrace.o(1907233914880L, 14210);
    return localArrayList2;
  }
  
  public final void SH(String paramString)
  {
    GMTrace.i(1906697043968L, 14206);
    this.uTA.setBackgroundResource(R.g.bhk);
    this.uTB.setTextColor(getResources().getColor(R.e.aVf));
    this.uTB.setText(paramString);
    if ((this.uTK == null) || (this.uTK.getVisibility() != 0))
    {
      this.uTB.setVisibility(0);
      this.uTD.setVisibility(8);
      this.uTC.setVisibility(8);
      this.uTK.setVisibility(8);
    }
    GMTrace.o(1906697043968L, 14206);
  }
  
  public final void bQn()
  {
    GMTrace.i(1906831261696L, 14207);
    this.uTL = false;
    setVisibility(8);
    if (this.uTI != null) {
      this.uTI.close();
    }
    GMTrace.o(1906831261696L, 14207);
  }
  
  public final void cr(List<String> paramList)
  {
    GMTrace.i(1907099697152L, 14209);
    if ((this.uTK != null) && (this.uTK.getVisibility() == 0))
    {
      this.uTK.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        ImageView localImageView = new ImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(aa.getContext(), 26), a.fromDPToPix(aa.getContext(), 26));
        localLayoutParams.rightMargin = a.fromDPToPix(aa.getContext(), 10);
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setLayoutParams(localLayoutParams);
        this.uTK.addView(localImageView);
        a.b.a(localImageView, str, 0.1F, false);
      }
    }
    GMTrace.o(1907099697152L, 14209);
  }
  
  public final class a
  {
    private Button lye;
    TextView titleView;
    LinearLayout uTO;
    
    public a(boolean paramBoolean)
    {
      GMTrace.i(3086605090816L, 22997);
      this.lye = ((Button)MultiTalkRoomPopupNav.this.findViewById(R.h.clw));
      this.titleView = ((TextView)MultiTalkRoomPopupNav.this.findViewById(R.h.clH));
      this.uTO = ((LinearLayout)MultiTalkRoomPopupNav.this.findViewById(R.h.cly));
      if (paramBoolean)
      {
        this.uTO.setBackgroundResource(R.g.bhl);
        this.lye.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(R.e.aVf));
        GMTrace.o(3086605090816L, 22997);
        return;
      }
      this.uTO.setBackgroundResource(R.g.bhk);
      this.lye.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(R.e.aTe));
      GMTrace.o(3086605090816L, 22997);
    }
    
    public final void close()
    {
      GMTrace.i(16020362231808L, 119361);
      this.uTO.setVisibility(8);
      GMTrace.o(16020362231808L, 119361);
    }
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(1881732546560L, 14020);
      uTP = 1;
      uTQ = 2;
      uTR = 3;
      uTS = new int[] { uTP, uTQ, uTR };
      GMTrace.o(1881732546560L, 14020);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/MultiTalkRoomPopupNav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */