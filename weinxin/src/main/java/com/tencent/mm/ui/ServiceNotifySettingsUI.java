package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.e.a.md;
import com.tencent.mm.e.a.ri;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.e;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI
  extends MMActivity
  implements e
{
  private DataSetObserver Br;
  private ListView Fg;
  private String jkM;
  private int mMode;
  private MMSwitchBtn rxS;
  private a uUm;
  private p uUn;
  
  public ServiceNotifySettingsUI()
  {
    GMTrace.i(2102654926848L, 15666);
    GMTrace.o(2102654926848L, 15666);
  }
  
  private boolean bQq()
  {
    GMTrace.i(2103326015488L, 15671);
    w.a locala = w.a.uCW;
    if (this.mMode == 1) {
      locala = w.a.uCX;
    }
    ap.yY();
    boolean bool = com.tencent.mm.u.c.vr().c(locala, true);
    GMTrace.o(2103326015488L, 15671);
    return bool;
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2103191797760L, 15670);
    if (this.uUn != null) {
      this.uUn.dismiss();
    }
    v.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      s.makeText(this, R.l.eEL, 0).show();
      GMTrace.o(2103191797760L, 15670);
      return;
    }
    paramString = ((com.tencent.mm.modelappbrand.k)paramk).AR();
    if (this.mMode == 1) {
      this.rxS.lP(paramString.tFq);
    }
    for (;;)
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2915611705344L, 21723);
          if (ServiceNotifySettingsUI.b(ServiceNotifySettingsUI.this) == 1)
          {
            ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.tFr);
            GMTrace.o(2915611705344L, 21723);
            return;
          }
          ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, paramString.thx);
          GMTrace.o(2915611705344L, 21723);
        }
      });
      GMTrace.o(2103191797760L, 15670);
      return;
      this.rxS.lP(paramString.thw);
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2102789144576L, 15667);
    int i = R.i.dnJ;
    GMTrace.o(2102789144576L, 15667);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2102923362304L, 15668);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.mMode = paramBundle.getIntExtra("mode", 0);
    this.jkM = paramBundle.getStringExtra("scene_id");
    paramBundle.putExtra("scene_id", this.jkM);
    paramBundle = paramBundle.getStringExtra("title");
    if (TextUtils.isEmpty(paramBundle))
    {
      zd(R.l.eEU);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2870782984192L, 21389);
          ServiceNotifySettingsUI.this.finish();
          GMTrace.o(2870782984192L, 21389);
          return false;
        }
      });
      this.rxS = ((MMSwitchBtn)findViewById(R.h.checkbox));
      this.Fg = ((ListView)findViewById(R.h.cbq));
      paramBundle = (TextView)findViewById(R.h.cbi);
      if (this.mMode != 1) {
        break label329;
      }
      i = R.l.eEG;
      label138:
      paramBundle.setText(i);
      paramBundle = (TextView)findViewById(R.h.cIK);
      if (this.mMode != 1) {
        break label336;
      }
    }
    label329:
    label336:
    for (int i = R.l.eEH;; i = R.l.eEI)
    {
      paramBundle.setText(i);
      this.uUm = new a(this, getLayoutInflater(), this.mMode, this.jkM);
      this.Fg.setAdapter(this.uUm);
      getString(R.l.dIG);
      this.uUn = com.tencent.mm.ui.base.g.a(this, getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2070040018944L, 15423);
          ServiceNotifySettingsUI.this.finish();
          GMTrace.o(2070040018944L, 15423);
        }
      });
      this.Br = new DataSetObserver()
      {
        public final void onChanged()
        {
          GMTrace.i(2874675298304L, 21418);
          View localView = ServiceNotifySettingsUI.this.findViewById(R.h.cbi);
          if (ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this).isEmpty()) {}
          for (int i = 4;; i = 0)
          {
            localView.setVisibility(i);
            GMTrace.o(2874675298304L, 21418);
            return;
          }
        }
      };
      this.uUm.registerDataSetObserver(this.Br);
      i = 3;
      if (this.mMode == 1) {
        i = 12;
      }
      ap.vd().a(1145, this);
      ap.vd().a(new com.tencent.mm.modelappbrand.k(i), 0);
      this.rxS.lP(bQq());
      GMTrace.o(2102923362304L, 15668);
      return;
      qL(paramBundle);
      break;
      i = R.l.eED;
      break label138;
    }
  }
  
  protected void onDestroy()
  {
    int j = 3;
    GMTrace.i(2103057580032L, 15669);
    ap.vd().b(1145, this);
    final boolean bool3 = bQq();
    final boolean bool1;
    final LinkedList localLinkedList;
    Object localObject2;
    final int i;
    label75:
    label91:
    boolean bool2;
    label113:
    Object localObject1;
    if (this.rxS.wuu != bool3)
    {
      bool1 = true;
      localLinkedList = new LinkedList();
      if (bool1)
      {
        localObject2 = new beg();
        if (!this.rxS.wuu) {
          break label430;
        }
        i = 1;
        ((beg)localObject2).udy = i;
        if (this.mMode != 1) {
          break label435;
        }
        i = 2;
        ((beg)localObject2).jMq = i;
        localLinkedList.add(localObject2);
        if (bool3) {
          break label440;
        }
        bool2 = true;
        localObject1 = w.a.uCW;
        if (this.mMode == 1) {
          localObject1 = w.a.uCX;
        }
        ap.yY();
        com.tencent.mm.u.c.vr().a((w.a)localObject1, Boolean.valueOf(bool2));
        com.tencent.mm.sdk.b.a.uql.m(new md());
        if (this.mMode != 1) {
          break label451;
        }
        if (((beg)localObject2).udy != 1) {
          break label446;
        }
        i = 3;
        label181:
        v.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(i), this.jkM });
        com.tencent.mm.plugin.report.service.g.oSF.i(13798, new Object[] { Integer.valueOf(i), "", Integer.valueOf(0), this.jkM, Long.valueOf(bf.Nz()) });
      }
      if (this.mMode != 1) {
        break label520;
      }
      i = 2;
      label275:
      localObject1 = this.uUm.uUv;
      if ((localObject1 == null) || (((LinkedList)localObject1).isEmpty())) {
        break label530;
      }
      if (this.mMode != 1) {
        break label525;
      }
    }
    for (;;)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ServiceNotifySettingsUI.a.a)((Iterator)localObject1).next();
        Object localObject3 = new beg();
        ((beg)localObject3).udz = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((beg)localObject3).jMq = j;
        ((beg)localObject3).udy = 1;
        localLinkedList.add(localObject3);
        localObject3 = new ri();
        ((ri)localObject3).fYg.fCA = ((ServiceNotifySettingsUI.a.a)localObject2).username;
        ((ri)localObject3).fYg.action = 2;
        ((ri)localObject3).fYg.fYi = i;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
      }
      bool1 = false;
      break;
      label430:
      i = 0;
      break label75;
      label435:
      i = 0;
      break label91;
      label440:
      bool2 = false;
      break label113;
      label446:
      i = 2;
      break label181;
      label451:
      if (((beg)localObject2).udy == 1) {}
      for (i = 11;; i = 10)
      {
        com.tencent.mm.plugin.report.service.g.oSF.i(13796, new Object[] { Integer.valueOf(i), "", "", Integer.valueOf(0), Long.valueOf(bf.Nz()) });
        break;
      }
      label520:
      i = 1;
      break label275;
      label525:
      j = 1;
    }
    label530:
    if (!localLinkedList.isEmpty())
    {
      ap.vd().a(1176, new e()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
        {
          GMTrace.i(2070576889856L, 15427);
          ap.vd().b(1176, this);
          v.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            s.makeText(ServiceNotifySettingsUI.this, R.l.eET, 0).show();
            if (bool1)
            {
              ap.yY();
              com.tencent.mm.u.c.vr().a(w.a.uCW, Boolean.valueOf(bool3));
              com.tencent.mm.sdk.b.a.uql.m(new md());
            }
            paramAnonymousString = localLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousk = (beg)paramAnonymousString.next();
              ri localri = new ri();
              localri.fYg.fCA = paramAnonymousk.udz;
              localri.fYg.action = 1;
              localri.fYg.fYi = i;
              com.tencent.mm.sdk.b.a.uql.m(localri);
            }
            GMTrace.o(2070576889856L, 15427);
            return;
          }
          GMTrace.o(2070576889856L, 15427);
        }
      });
      ap.vd().a(new j(localLinkedList), 0);
    }
    if (this.uUm != null) {
      this.uUm.unregisterDataSetObserver(this.Br);
    }
    super.onDestroy();
    GMTrace.o(2103057580032L, 15669);
  }
  
  private static final class a
    extends BaseAdapter
  {
    private LayoutInflater dZ;
    private String jkM;
    private Context mContext;
    private int mMode;
    private View.OnClickListener mOnClickListener;
    LinkedList<a> uUu;
    LinkedList<a> uUv;
    private com.tencent.mm.ah.a.a.c uUw;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, final int paramInt, String paramString)
    {
      GMTrace.i(2068295188480L, 15410);
      this.mContext = paramContext;
      this.mMode = paramInt;
      this.jkM = paramString;
      this.dZ = paramLayoutInflater;
      this.uUu = new LinkedList();
      this.uUv = new LinkedList();
      this.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2078227300352L, 15484);
          final String str = (String)paramAnonymousView.getTag();
          if (TextUtils.isEmpty(str))
          {
            GMTrace.o(2078227300352L, 15484);
            return;
          }
          paramAnonymousView = paramAnonymousView.getContext();
          int i;
          if (paramInt == 1)
          {
            i = R.l.eEP;
            if (paramInt != 1) {
              break label114;
            }
          }
          label114:
          for (int j = R.l.eEQ;; j = R.l.dHL)
          {
            com.tencent.mm.ui.base.g.a(paramAnonymousView, i, 0, j, R.l.cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(3469930921984L, 25853);
                paramAnonymous2Int = 0;
                while (paramAnonymous2Int < ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).size())
                {
                  paramAnonymous2DialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).get(paramAnonymous2Int);
                  if ((paramAnonymous2DialogInterface != null) && (str.equals(paramAnonymous2DialogInterface.username)))
                  {
                    ServiceNotifySettingsUI.a.b(ServiceNotifySettingsUI.a.this).add(ServiceNotifySettingsUI.a.a(ServiceNotifySettingsUI.a.this).remove(paramAnonymous2Int));
                    ServiceNotifySettingsUI.a.this.notifyDataSetChanged();
                    paramAnonymous2DialogInterface = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
                    if (paramAnonymous2DialogInterface == null) {}
                    for (paramAnonymous2DialogInterface = ""; ServiceNotifySettingsUI.a.1.this.uUx == 1; paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.field_appId)
                    {
                      v.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramAnonymous2DialogInterface, ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this) });
                      com.tencent.mm.plugin.report.service.g.oSF.i(13798, new Object[] { Integer.valueOf(4), paramAnonymous2DialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(ServiceNotifySettingsUI.a.this), Long.valueOf(bf.Nz()) });
                      GMTrace.o(3469930921984L, 25853);
                      return;
                    }
                    com.tencent.mm.plugin.report.service.g.oSF.i(13796, new Object[] { Integer.valueOf(12), paramAnonymous2DialogInterface, "", Integer.valueOf(0), Long.valueOf(bf.Nz()) });
                    GMTrace.o(3469930921984L, 25853);
                    return;
                  }
                  paramAnonymous2Int += 1;
                }
                GMTrace.o(3469930921984L, 25853);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(3087947268096L, 23007);
                GMTrace.o(3087947268096L, 23007);
              }
            }, R.e.aUd);
            GMTrace.o(2078227300352L, 15484);
            return;
            i = R.l.eES;
            break;
          }
        }
      };
      paramContext = new c.a();
      paramContext.hIQ = true;
      paramContext.hIN = com.tencent.mm.modelappbrand.a.a.AX();
      this.uUw = paramContext.Hh();
      GMTrace.o(2068295188480L, 15410);
    }
    
    private a zs(int paramInt)
    {
      GMTrace.i(2068563623936L, 15412);
      a locala = (a)this.uUu.get(paramInt);
      GMTrace.o(2068563623936L, 15412);
      return locala;
    }
    
    public final int getCount()
    {
      GMTrace.i(2068429406208L, 15411);
      int i = this.uUu.size();
      GMTrace.o(2068429406208L, 15411);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(2068697841664L, 15413);
      long l = paramInt;
      GMTrace.o(2068697841664L, 15413);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(2068832059392L, 15414);
      a locala = zs(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.dZ.inflate(R.i.dnI, paramViewGroup, false);
        paramView = new b();
        paramView.ioB = ((ImageView)localView.findViewById(R.h.bqB));
        paramView.ioD = ((TextView)localView.findViewById(R.h.cIM));
        paramView.uUA = ((TextView)localView.findViewById(R.h.cyz));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        com.tencent.mm.ah.n.GX().a(locala.url, paramViewGroup.ioB, this.uUw);
        paramViewGroup.ioD.setText(locala.title);
        if (this.mMode != 1) {
          break label200;
        }
        paramViewGroup.uUA.setText(this.mContext.getString(R.l.eEM));
      }
      for (;;)
      {
        paramViewGroup.uUA.setTag(locala.username);
        paramViewGroup.uUA.setOnClickListener(this.mOnClickListener);
        GMTrace.o(2068832059392L, 15414);
        return localView;
        paramViewGroup = (b)paramView.getTag();
        localView = paramView;
        break;
        label200:
        paramViewGroup.uUA.setText(this.mContext.getString(R.l.eEN));
      }
    }
    
    private static final class a
    {
      String title;
      String url;
      String username;
      
      public a()
      {
        GMTrace.i(2961514168320L, 22065);
        GMTrace.o(2961514168320L, 22065);
      }
    }
    
    private static final class b
    {
      ImageView ioB;
      TextView ioD;
      TextView uUA;
      
      public b()
      {
        GMTrace.i(2102386491392L, 15664);
        GMTrace.o(2102386491392L, 15664);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/ServiceNotifySettingsUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */