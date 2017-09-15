package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class j
{
  static String sRU;
  
  private static void a(Activity paramActivity, x paramx, String paramString, ArrayList<String> paramArrayList)
  {
    GMTrace.i(1210241253376L, 9017);
    Object localObject = new amo();
    ((amo)localObject).tPo = paramString;
    aqi localaqi = new aqi();
    localaqi.jLr = paramArrayList.size();
    localaqi.tTt = new LinkedList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aqh localaqh = new aqh();
      localaqh.tTs = str;
      localaqi.tTt.add(localaqh);
    }
    ((amo)localObject).tPk = localaqi;
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(60, (com.tencent.mm.bd.a)localObject));
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if ((paramString != null) && ((int)paramString.gTG > 0) && (com.tencent.mm.j.a.ez(paramString.field_type)))
    {
      paramArrayList = paramArrayList.iterator();
      for (paramString = ""; paramArrayList.hasNext(); paramString = paramString + ",")
      {
        localObject = (String)paramArrayList.next();
        paramString = paramString + (String)localObject;
      }
      paramx.cr(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Q(paramx);
    }
    Toast.makeText(paramActivity, paramActivity.getString(R.l.eWX), 0).show();
    GMTrace.o(1210241253376L, 9017);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    GMTrace.i(16012309168128L, 119301);
    String str = bf.mz(paramBundle.getString("Contact_User"));
    if (str == null)
    {
      v.e("MicroMsg.MailPhoneMenuHelper", "username is null");
      GMTrace.o(16012309168128L, 119301);
      return;
    }
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(str);
    if (localx == null)
    {
      v.e("MicroMsg.MailPhoneMenuHelper", "contact is null");
      GMTrace.o(16012309168128L, 119301);
      return;
    }
    Object localObject = paramBundle.getString("Contact_Mobile_MD5");
    paramBundle = localx.gkG;
    int i;
    if (!bf.mA((String)localObject)) {
      if (localObject == paramString) {
        i = 0;
      }
    }
    for (;;)
    {
      localObject = new ArrayList();
      if (!bf.mA(paramBundle))
      {
        paramBundle = paramBundle.split(",");
        int j = 0;
        for (;;)
        {
          if (j < paramBundle.length)
          {
            ((ArrayList)localObject).add(paramBundle[j]);
            j += 1;
            continue;
            if (localx.tH()) {
              break label303;
            }
            i = 1;
            break;
          }
        }
        if (((ArrayList)localObject).contains(paramString)) {
          ((ArrayList)localObject).remove(paramString);
        }
      }
      ((ArrayList)localObject).add(paramString);
      if (((ArrayList)localObject).size() + i <= 5)
      {
        a(paramActivity, localx, str, (ArrayList)localObject);
        com.tencent.mm.plugin.report.service.g.oSF.i(12040, new Object[] { localx.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + ((ArrayList)localObject).size()) });
        GMTrace.o(16012309168128L, 119301);
        return;
      }
      Toast.makeText(paramActivity, paramActivity.getString(R.l.eBm), 0).show();
      GMTrace.o(16012309168128L, 119301);
      return;
      label303:
      i = 0;
    }
  }
  
  public static void a(final Context paramContext, String paramString, final DialogInterface.OnDismissListener paramOnDismissListener, final Bundle paramBundle)
  {
    GMTrace.i(1209838600192L, 9014);
    if (!(paramContext instanceof Activity)) {
      v.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[] { bf.bJP() });
    }
    if (com.tencent.mm.kernel.h.vG().uV()) {}
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.h.vI().vr().get(w.a.uAb, Boolean.valueOf(false))).booleanValue();; bool = false)
    {
      final int i;
      int j;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("fromScene");
        if ((!bGl()) && (!bGm())) {
          break label464;
        }
        j = 1;
        label95:
        if (j == 0) {
          break label680;
        }
        localObject = bf.mz(paramBundle.getString("Contact_User"));
        if ((localObject != null) && (localObject != "") && (!((String)localObject).endsWith("@chatroom")) && (!m.eH((String)localObject))) {
          break label507;
        }
        if (!bool) {
          break label470;
        }
        localObject = new String[3];
        localObject[0] = paramContext.getResources().getString(R.l.dUT);
        localObject[1] = paramContext.getResources().getString(R.l.dUU);
        localObject[2] = paramContext.getResources().getString(R.l.dUM);
      }
      label195:
      label464:
      label470:
      label507:
      label680:
      for (final Object localObject = bf.f((String[])localObject);; localObject = bf.f(new String[] { paramContext.getResources().getString(R.l.dUT), paramContext.getResources().getString(R.l.dUO) }))
      {
        com.tencent.mm.plugin.report.service.g.oSF.i(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
        if (o.oz())
        {
          ((List)localObject).add(paramContext.getResources().getString(R.l.dUP));
          com.tencent.mm.plugin.report.service.g.oSF.i(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(3) });
          if (PlatformComm.C2Java.isNetworkConnected())
          {
            j = bf.a((Integer)com.tencent.mm.kernel.h.vI().vr().get(w.a.uyD, null), 3);
            v.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[] { Integer.valueOf(j) });
            com.tencent.mm.kernel.h.vI().vr().a(w.a.uyD, Integer.valueOf(j - 1));
          }
        }
        final k localk = new k(paramContext);
        localk.setTitle(paramString);
        a locala = new a((List)localObject, paramContext, paramOnDismissListener, paramBundle);
        locala.sSc = new j.a.a()
        {
          public final void fd(boolean paramAnonymousBoolean)
          {
            GMTrace.i(1214670438400L, 9050);
            if (paramAnonymousBoolean)
            {
              this.sRY.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            GMTrace.o(1214670438400L, 9050);
          }
        };
        localk.khv = locala;
        com.tencent.mm.ui.base.g.a(paramContext, localk);
        localk.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(1209570164736L, 9012);
            if (this.sRV != null) {
              this.sRV.onDismiss(null);
            }
            GMTrace.o(1209570164736L, 9012);
          }
        });
        localk.sTD = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            GMTrace.i(1208093769728L, 9001);
            paramAnonymousView = this.mWy.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
            paramAnonymousAdapterView = (String)localObject.get(paramAnonymousInt);
            v.i("MicroMsg.MailPhoneMenuHelper", paramAnonymousAdapterView);
            if (paramContext.getString(R.l.dUT).equals(paramAnonymousAdapterView))
            {
              paramAnonymousAdapterView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramAnonymousView));
              paramAnonymousAdapterView.addFlags(268435456);
              if (bf.j(paramContext, paramAnonymousAdapterView)) {
                paramContext.startActivity(paramAnonymousAdapterView);
              }
              com.tencent.mm.plugin.report.service.g.oSF.A(10112, "1");
              localk.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
              GMTrace.o(1208093769728L, 9001);
              return;
            }
            if (paramContext.getString(R.l.dUU).equals(paramAnonymousAdapterView))
            {
              com.tencent.mm.plugin.report.service.g.oSF.i(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramAnonymousView);
              com.tencent.mm.bb.d.b(paramContext, "ipcall", ".ui.IPCallDialUI", paramAnonymousAdapterView);
              localk.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
              GMTrace.o(1208093769728L, 9001);
              return;
            }
            if (paramContext.getString(R.l.dUM).equals(paramAnonymousAdapterView))
            {
              if ((j.bGl()) && (j.bGm())) {
                paramAnonymousAdapterView = paramContext.getResources().getStringArray(R.c.aSl);
              }
              for (;;)
              {
                paramContext.getResources().getString(R.l.dUR);
                com.tencent.mm.ui.base.g.a(paramContext, this.mWy, paramAnonymousAdapterView, "", new g.c()new DialogInterface.OnCancelListener
                {
                  public final void hp(int paramAnonymous2Int)
                  {
                    GMTrace.i(1206214721536L, 8987);
                    if (j.7.this.sRV != null) {
                      j.7.this.sRV.onDismiss(null);
                    }
                    switch (paramAnonymous2Int)
                    {
                    }
                    for (;;)
                    {
                      GMTrace.o(1206214721536L, 8987);
                      return;
                      if (j.bGl())
                      {
                        Context localContext = j.7.this.val$context;
                        String str = paramAnonymousView;
                        Intent localIntent = new Intent("android.intent.action.INSERT");
                        localIntent.setType("vnd.android.cursor.dir/contact");
                        localIntent.putExtra("phone", str);
                        localContext.startActivity(localIntent);
                        com.tencent.mm.plugin.report.service.g.oSF.A(10113, "1");
                        GMTrace.o(1206214721536L, 8987);
                        return;
                      }
                      j.aW(j.7.this.val$context, paramAnonymousView);
                      com.tencent.mm.plugin.report.service.g.oSF.A(10114, "1");
                      GMTrace.o(1206214721536L, 8987);
                      return;
                      j.aW(j.7.this.val$context, paramAnonymousView);
                      com.tencent.mm.plugin.report.service.g.oSF.A(10114, "1");
                    }
                  }
                }, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    GMTrace.i(1208630640640L, 9005);
                    if (j.7.this.sRV != null) {
                      j.7.this.sRV.onDismiss(null);
                    }
                    GMTrace.o(1208630640640L, 9005);
                  }
                });
                localk.dismiss();
                GMTrace.o(1208093769728L, 9001);
                return;
                if (j.bGl())
                {
                  paramAnonymousAdapterView = new String[1];
                  paramAnonymousAdapterView[0] = paramContext.getResources().getString(R.l.dUL);
                }
                else
                {
                  paramAnonymousAdapterView = new String[1];
                  paramAnonymousAdapterView[0] = paramContext.getResources().getString(R.l.dUS);
                }
              }
            }
            if (paramContext.getString(R.l.dUO).equals(paramAnonymousAdapterView))
            {
              com.tencent.mm.pluginsdk.j.d.a(paramContext, paramAnonymousView, paramAnonymousView);
              com.tencent.mm.plugin.report.service.g.oSF.A(10115, "1");
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
              localk.dismiss();
              GMTrace.o(1208093769728L, 9001);
              return;
            }
            if (paramContext.getString(R.l.dUP).equals(paramAnonymousAdapterView))
            {
              v.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
              GMTrace.o(1208093769728L, 9001);
              return;
            }
            if (j.sRU.equals(paramAnonymousAdapterView))
            {
              j.a((Activity)paramContext, this.mWy, paramBundle);
              localk.dismiss();
              if (paramOnDismissListener != null)
              {
                paramOnDismissListener.onDismiss(null);
                GMTrace.o(1208093769728L, 9001);
              }
            }
            else
            {
              v.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
              localk.dismiss();
              if (paramOnDismissListener != null) {
                paramOnDismissListener.onDismiss(null);
              }
            }
            GMTrace.o(1208093769728L, 9001);
          }
        };
        localk.show();
        GMTrace.o(1209838600192L, 9014);
        return;
        i = 0;
        break;
        j = 0;
        break label95;
        localObject = new String[2];
        localObject[0] = paramContext.getResources().getString(R.l.dUT);
        localObject[1] = paramContext.getResources().getString(R.l.dUM);
        break label195;
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject);
        if (localObject == null)
        {
          GMTrace.o(1209838600192L, 9014);
          return;
        }
        localObject = ((x)localObject).tL();
        sRU = paramContext.getResources().getString(R.l.dUN, new Object[] { localObject });
        if (bool)
        {
          localObject = new String[4];
          localObject[0] = paramContext.getResources().getString(R.l.dUT);
          localObject[1] = paramContext.getResources().getString(R.l.dUU);
          localObject[2] = sRU;
          localObject[3] = paramContext.getResources().getString(R.l.dUM);
          break label195;
        }
        localObject = new String[3];
        localObject[0] = paramContext.getResources().getString(R.l.dUT);
        localObject[1] = sRU;
        localObject[2] = paramContext.getResources().getString(R.l.dUM);
        break label195;
      }
    }
  }
  
  public static void aV(Context paramContext, String paramString)
  {
    GMTrace.i(16012040732672L, 119299);
    Intent localIntent = new Intent("android.intent.action.SENDTO");
    localIntent.setData(Uri.parse("mailto:"));
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString });
    if (bf.j(paramContext, localIntent))
    {
      paramContext.startActivity(localIntent);
      GMTrace.o(16012040732672L, 119299);
      return;
    }
    com.tencent.mm.ui.base.g.a(paramContext, R.l.dUJ, R.l.dIG, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(1210912342016L, 9022);
        GMTrace.o(1210912342016L, 9022);
      }
    });
    GMTrace.o(16012040732672L, 119299);
  }
  
  public static void aW(Context paramContext, String paramString)
  {
    GMTrace.i(16012174950400L, 119300);
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
    localIntent.setType("vnd.android.cursor.item/person");
    localIntent.putExtra("phone", paramString);
    if (bf.j(paramContext, localIntent)) {
      paramContext.startActivity(localIntent);
    }
    GMTrace.o(16012174950400L, 119300);
  }
  
  public static void b(final Context paramContext, final String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    GMTrace.i(1209704382464L, 9013);
    if ((m.xW() & 0x1) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.ui.base.g.a(paramContext, paramString, paramContext.getResources().getStringArray(R.c.aRZ), "", new g.c()
      {
        public final void hp(int paramAnonymousInt)
        {
          GMTrace.i(1203798802432L, 8969);
          if (this.sRV != null) {
            this.sRV.onDismiss(null);
          }
          String str1 = paramString.replace(" ", "").replace("#", "@");
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            GMTrace.o(1203798802432L, 8969);
            return;
            Context localContext = paramContext;
            Intent localIntent = new Intent();
            localIntent.putExtra("composeType", 4);
            String str2 = str1.substring(0, str1.indexOf('@'));
            localIntent.putExtra("toList", new String[] { str2 + " " + str1 });
            com.tencent.mm.bb.d.b(localContext, "qqmail", ".ui.ComposeUI", localIntent);
            GMTrace.o(1203798802432L, 8969);
            return;
            j.aV(paramContext, str1);
          }
        }
      });
      GMTrace.o(1209704382464L, 9013);
      return;
    }
    String str = paramContext.getResources().getString(R.l.dTh);
    paramOnDismissListener = new g.c()
    {
      public final void hp(int paramAnonymousInt)
      {
        GMTrace.i(1211583430656L, 9027);
        if (this.sRV != null) {
          this.sRV.onDismiss(null);
        }
        String str = paramString.replace(" ", "").replace("#", "@");
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          GMTrace.o(1211583430656L, 9027);
          return;
          j.aV(paramContext, str);
        }
      }
    };
    com.tencent.mm.ui.base.g.a(paramContext, paramString, new String[] { str }, "", paramOnDismissListener);
    GMTrace.o(1209704382464L, 9013);
  }
  
  public static boolean bGl()
  {
    GMTrace.i(1209972817920L, 9015);
    Context localContext = aa.getContext();
    Intent localIntent = new Intent("android.intent.action.INSERT");
    localIntent.setType("vnd.android.cursor.dir/contact");
    localIntent.putExtra("phone", "10086");
    boolean bool = bf.j(localContext, localIntent);
    GMTrace.o(1209972817920L, 9015);
    return bool;
  }
  
  public static boolean bGm()
  {
    GMTrace.i(1210107035648L, 9016);
    boolean bool = bf.j(aa.getContext(), new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI));
    GMTrace.o(1210107035648L, 9016);
    return bool;
  }
  
  private static final class a
    extends BaseAdapter
  {
    private Context mContext;
    private List<String> mxI;
    private Bundle rx;
    private DialogInterface.OnDismissListener sSb;
    a sSc;
    
    public a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
    {
      GMTrace.i(1220441800704L, 9093);
      this.mxI = null;
      this.mContext = null;
      this.sSb = null;
      this.rx = null;
      this.sSc = null;
      if (paramContext != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.mxI = paramList;
        this.mContext = paramContext;
        this.sSb = paramOnDismissListener;
        this.rx = paramBundle;
        GMTrace.o(1220441800704L, 9093);
        return;
      }
    }
    
    public final int getCount()
    {
      GMTrace.i(1220576018432L, 9094);
      if (this.mxI == null)
      {
        GMTrace.o(1220576018432L, 9094);
        return 0;
      }
      int i = this.mxI.size();
      GMTrace.o(1220576018432L, 9094);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(1220710236160L, 9095);
      Object localObject = this.mxI.get(paramInt);
      GMTrace.o(1220710236160L, 9095);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(1220844453888L, 9096);
      long l = paramInt;
      GMTrace.o(1220844453888L, 9096);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      GMTrace.i(1221112889344L, 9098);
      String str = (String)this.mxI.get(paramInt);
      if (this.mContext.getString(R.l.dUP).equals(str))
      {
        GMTrace.o(1221112889344L, 9098);
        return 1;
      }
      GMTrace.o(1221112889344L, 9098);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(1221247107072L, 9099);
      String str = (String)getItem(paramInt);
      paramInt = getItemViewType(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
        if (paramInt == 1)
        {
          paramViewGroup = paramView.inflate(R.i.cXW, paramViewGroup, false);
          paramView = new b();
          ((b)paramView).iUi = ((TextView)paramViewGroup.findViewById(R.h.title));
          ((b)paramView).lJa = ((Button)paramViewGroup.findViewById(R.h.bJR));
          ((b)paramView).sSe = ((TextView)paramViewGroup.findViewById(R.h.cIx));
          paramViewGroup.setTag(paramView);
          localObject = paramView;
          paramView = paramViewGroup;
          switch (paramInt)
          {
          default: 
            label127:
            v.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
          }
        }
      }
      for (;;)
      {
        GMTrace.o(1221247107072L, 9099);
        return paramView;
        paramViewGroup = paramView.inflate(R.i.cXX, paramViewGroup, false);
        paramView = new c();
        ((c)paramView).iUi = ((TextView)paramViewGroup.findViewById(R.h.title));
        break;
        localObject = paramView.getTag();
        break label127;
        paramViewGroup = (c)localObject;
        paramViewGroup.iUi.setText(h.b(this.mContext, bf.mz(str), paramViewGroup.iUi.getTextSize()));
        continue;
        paramViewGroup = (b)localObject;
        paramViewGroup.iUi.setText(h.b(this.mContext, bf.mz(str), paramViewGroup.iUi.getTextSize()));
        paramViewGroup.sSe.setText(this.mContext.getString(R.l.dUV));
        paramViewGroup.lJa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(1215073091584L, 9053);
            if (!PlatformComm.C2Java.isNetworkConnected())
            {
              v.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
              s.makeText(j.a.a(j.a.this), j.a.a(j.a.this).getString(R.l.eln), 0).show();
              if (j.a.b(j.a.this) != null)
              {
                j.a.b(j.a.this).fd(false);
                GMTrace.o(1215073091584L, 9053);
              }
            }
            else
            {
              o.d(j.a.a(j.a.this), j.a.c(j.a.this));
              if (j.a.b(j.a.this) != null) {
                j.a.b(j.a.this).fd(true);
              }
            }
            GMTrace.o(1215073091584L, 9053);
          }
        });
      }
    }
    
    public final int getViewTypeCount()
    {
      GMTrace.i(1220978671616L, 9097);
      GMTrace.o(1220978671616L, 9097);
      return 2;
    }
    
    public static abstract interface a
    {
      public abstract void fd(boolean paramBoolean);
    }
    
    private final class b
    {
      TextView iUi;
      Button lJa;
      TextView sSe;
      
      public b()
      {
        GMTrace.i(1203933020160L, 8970);
        GMTrace.o(1203933020160L, 8970);
      }
    }
    
    private final class c
    {
      TextView iUi;
      
      public c()
      {
        GMTrace.i(1206483156992L, 8989);
        GMTrace.o(1206483156992L, 8989);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */