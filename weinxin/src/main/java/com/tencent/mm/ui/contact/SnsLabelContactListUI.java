package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.e.a.hj;
import com.tencent.mm.e.a.hj.b;
import com.tencent.mm.e.a.nc;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SnsLabelContactListUI
  extends MMActivity
{
  private ListView mYn;
  private bbg pxg;
  private a vXR;
  private ArrayList<String> vXS;
  private int vXT;
  private String vXU;
  private b vXV;
  
  public SnsLabelContactListUI()
  {
    GMTrace.i(1833145729024L, 13658);
    this.vXS = new ArrayList();
    GMTrace.o(1833145729024L, 13658);
  }
  
  private void bYf()
  {
    GMTrace.i(1833414164480L, 13660);
    Iterator localIterator;
    if (this.pxg.tPn == 3)
    {
      this.vXU = getString(R.l.eWH);
      localIterator = this.pxg.uaM.iterator();
      while (localIterator.hasNext()) {
        this.vXS.add(((avu)localIterator.next()).tXF);
      }
      GMTrace.o(1833414164480L, 13660);
      return;
    }
    if (this.pxg.tPn == 5)
    {
      this.vXU = getString(R.l.eWI);
      localIterator = this.pxg.tOe.iterator();
      while (localIterator.hasNext()) {
        this.vXS.add(((avu)localIterator.next()).tXF);
      }
    }
    GMTrace.o(1833414164480L, 13660);
  }
  
  protected final void KD()
  {
    GMTrace.i(1833548382208L, 13661);
    qL(this.vXU);
    findViewById(R.h.cbM).setVisibility(8);
    this.mYn = ((ListView)findViewById(R.h.bnu));
    ((TextView)findViewById(R.h.bLF)).setVisibility(8);
    findViewById(R.h.bnE).setVisibility(8);
    this.mYn.setBackgroundColor(getResources().getColor(R.e.white));
    ((View)this.mYn.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1844822671360L, 13745);
        SnsLabelContactListUI.this.finish();
        GMTrace.o(1844822671360L, 13745);
        return true;
      }
    });
    kp(false);
    if ((this.vXS != null) && (this.vXS.size() != 0))
    {
      this.vXR = new a(this, this.vXS);
      this.mYn.setAdapter(this.vXR);
      this.mYn.setVisibility(0);
      this.mYn.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(1803215175680L, 13435);
          paramAnonymousView = new Intent();
          paramAnonymousAdapterView = (com.tencent.mm.j.a)SnsLabelContactListUI.a(SnsLabelContactListUI.this).getItem(paramAnonymousInt);
          g localg = m.pPd;
          if (localg == null)
          {
            SnsLabelContactListUI.this.finish();
            GMTrace.o(1803215175680L, 13435);
            return;
          }
          paramAnonymousView = localg.f(paramAnonymousView, paramAnonymousAdapterView.field_username);
          if (paramAnonymousView == null)
          {
            SnsLabelContactListUI.this.finish();
            GMTrace.o(1803215175680L, 13435);
            return;
          }
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.field_username);
          WorkerProfile.oC().fxk.d(paramAnonymousView, SnsLabelContactListUI.this);
          GMTrace.o(1803215175680L, 13435);
        }
      });
    }
    GMTrace.o(1833548382208L, 13661);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1833951035392L, 13664);
    int i = R.i.cTw;
    GMTrace.o(1833951035392L, 13664);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1833279946752L, 13659);
    super.onCreate(paramBundle);
    this.vXV = new b((byte)0);
    com.tencent.mm.sdk.b.a.uql.b(this.vXV);
    this.vXT = getIntent().getIntExtra("sns_label_sns_info", -1);
    if (this.vXT == -1)
    {
      finish();
      GMTrace.o(1833279946752L, 13659);
      return;
    }
    paramBundle = new hj();
    paramBundle.fME.fIz = this.vXT;
    com.tencent.mm.sdk.b.a.uql.m(paramBundle);
    this.pxg = paramBundle.fMF.fMG;
    if ((this.pxg != null) && (((this.pxg.tPn == 3) && (this.pxg.uaM != null) && (this.pxg.uaM.size() > 0)) || ((this.pxg.tPn == 5) && (this.pxg.tOe != null) && (this.pxg.tOe.size() > 0))))
    {
      bYf();
      KD();
    }
    GMTrace.o(1833279946752L, 13659);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(1833816817664L, 13663);
    com.tencent.mm.sdk.b.a.uql.c(this.vXV);
    super.onDestroy();
    GMTrace.o(1833816817664L, 13663);
  }
  
  public void onResume()
  {
    GMTrace.i(1833682599936L, 13662);
    super.onResume();
    if (this.vXR != null) {
      this.vXR.notifyDataSetChanged();
    }
    GMTrace.o(1833682599936L, 13662);
  }
  
  private static final class a
    extends BaseAdapter
  {
    private Context context;
    private ar qyj;
    private Map<Integer, com.tencent.mm.j.a> vXX;
    private ColorStateList vXY;
    private ColorStateList vXZ;
    
    public a(Context paramContext, List<String> paramList)
    {
      GMTrace.i(1778653331456L, 13252);
      this.context = null;
      this.vXX = new HashMap();
      this.qyj = null;
      this.context = paramContext;
      this.vXX.clear();
      ap.yY();
      this.qyj = com.tencent.mm.u.c.wR();
      paramList = paramList.iterator();
      int i = 0;
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        com.tencent.mm.j.a locala = new com.tencent.mm.j.a();
        locala.setUsername((String)localObject);
        this.vXX.put(Integer.valueOf(i), locala);
        i += 1;
      }
      try
      {
        paramList = paramContext.getResources().getXml(R.e.aVa);
        localObject = paramContext.getResources().getXml(R.e.aVb);
        this.vXY = ColorStateList.createFromXml(paramContext.getResources(), paramList);
        this.vXZ = ColorStateList.createFromXml(paramContext.getResources(), (XmlPullParser)localObject);
        GMTrace.o(1778653331456L, 13252);
        return;
      }
      catch (XmlPullParserException paramContext)
      {
        v.printErrStackTrace("MicroMsg.SnsLabelContactListUI", paramContext, "", new Object[0]);
        GMTrace.o(1778653331456L, 13252);
        return;
      }
      catch (IOException paramContext)
      {
        v.printErrStackTrace("MicroMsg.SnsLabelContactListUI", paramContext, "", new Object[0]);
        GMTrace.o(1778653331456L, 13252);
      }
    }
    
    public final int getCount()
    {
      GMTrace.i(1778787549184L, 13253);
      int i = this.vXX.size();
      GMTrace.o(1778787549184L, 13253);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(1778921766912L, 13254);
      if (paramInt < 0)
      {
        GMTrace.o(1778921766912L, 13254);
        return null;
      }
      com.tencent.mm.j.a locala = (com.tencent.mm.j.a)this.vXX.get(Integer.valueOf(paramInt));
      Object localObject = locala;
      if (locala.field_showHead == 0)
      {
        x localx = this.qyj.Rb(locala.field_username);
        localObject = locala;
        if (localx != null)
        {
          this.vXX.put(Integer.valueOf(paramInt), localx);
          localObject = localx;
        }
      }
      GMTrace.o(1778921766912L, 13254);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(1779055984640L, 13255);
      GMTrace.o(1779055984640L, 13255);
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(1779190202368L, 13256);
      com.tencent.mm.j.a locala;
      TextView localTextView;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.cZq, null);
        paramViewGroup = new SnsLabelContactListUI.c();
        paramViewGroup.mRQ = ((TextView)paramView.findViewById(R.h.bGd));
        paramViewGroup.kvj = ((MaskLayout)paramView.findViewById(R.h.bGb));
        paramViewGroup.jXN = ((TextView)paramView.findViewById(R.h.bGf));
        paramViewGroup.vYb = ((TextView)paramView.findViewById(R.h.bFZ));
        paramView.setTag(paramViewGroup);
        getItem(paramInt);
        locala = (com.tencent.mm.j.a)getItem(paramInt);
        paramViewGroup.mRQ.setVisibility(8);
        localTextView = paramViewGroup.jXN;
        if (o.fE(locala.field_username)) {
          break label241;
        }
      }
      label241:
      for (ColorStateList localColorStateList = this.vXY;; localColorStateList = this.vXZ)
      {
        localTextView.setTextColor(localColorStateList);
        a.b.b((ImageView)paramViewGroup.kvj.view, locala.field_username, true);
        paramViewGroup.vYb.setVisibility(8);
        paramViewGroup.kvj.setVisibility(0);
        paramViewGroup.jXN.setText(h.b(this.context, locala.tL(), paramViewGroup.jXN.getTextSize()));
        paramViewGroup.jXN.setVisibility(0);
        GMTrace.o(1779190202368L, 13256);
        return paramView;
        paramViewGroup = (SnsLabelContactListUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  private final class b
    extends com.tencent.mm.sdk.b.c<nc>
  {
    private b()
    {
      GMTrace.i(1748185907200L, 13025);
      this.uqt = nc.class.getName().hashCode();
      GMTrace.o(1748185907200L, 13025);
    }
  }
  
  private static final class c
  {
    TextView jXN;
    MaskLayout kvj;
    TextView mRQ;
    TextView vYb;
    
    public c()
    {
      GMTrace.i(1733958828032L, 12919);
      GMTrace.o(1733958828032L, 12919);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/SnsLabelContactListUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */