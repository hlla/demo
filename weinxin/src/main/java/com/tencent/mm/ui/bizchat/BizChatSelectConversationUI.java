package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.ui.applet.k.a;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.r;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.modelbiz.m
{
  private com.tencent.mm.ui.base.p irp;
  private String jZw;
  private int scene;
  j vtR;
  private TextView vuO;
  
  public BizChatSelectConversationUI()
  {
    GMTrace.i(2992115810304L, 22293);
    this.jZw = null;
    this.scene = 0;
    this.irp = null;
    GMTrace.o(2992115810304L, 22293);
  }
  
  private void a(final String paramString, final long paramLong, CharSequence paramCharSequence)
  {
    GMTrace.i(2993323769856L, 22302);
    v.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (this.scene == 2)
    {
      if (getIntent().getBooleanExtra("enterprise_extra_params", true))
      {
        paramCharSequence = String.valueOf(paramCharSequence);
        com.tencent.mm.pluginsdk.ui.applet.d.a(this.uRf, paramLong, getString(R.l.eLC), paramCharSequence, getString(R.l.dIs), new k.a()
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            GMTrace.i(3000303091712L, 22354);
            if (paramAnonymousBoolean)
            {
              paramAnonymousString = new Intent();
              paramAnonymousString.putExtra("enterprise_biz_name", paramString);
              paramAnonymousString.putExtra("key_biz_chat_id", paramLong);
              paramAnonymousString.putExtra("key_is_biz_chat", true);
              BizChatSelectConversationUI.this.setResult(-1, paramAnonymousString);
              BizChatSelectConversationUI.this.finish();
            }
            GMTrace.o(3000303091712L, 22354);
          }
        });
        GMTrace.o(2993323769856L, 22302);
        return;
      }
      paramCharSequence = String.valueOf(paramCharSequence);
      com.tencent.mm.pluginsdk.ui.applet.d.a(this.uRf, paramLong, getString(R.l.eLC), paramCharSequence, getString(R.l.dIs), new k.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          GMTrace.i(3011443163136L, 22437);
          if (paramAnonymousBoolean)
          {
            paramAnonymousString = new Intent();
            paramAnonymousString.putExtra("enterprise_biz_name", paramString);
            paramAnonymousString.putExtra("key_biz_chat_id", paramLong);
            paramAnonymousString.putExtra("key_is_biz_chat", true);
            BizChatSelectConversationUI.this.setResult(-1, paramAnonymousString);
            BizChatSelectConversationUI.this.finish();
          }
          GMTrace.o(3011443163136L, 22437);
        }
      });
      GMTrace.o(2993323769856L, 22302);
      return;
    }
    if (this.scene == 1)
    {
      Object localObject = (HashMap)getIntent().getSerializableExtra("enterprise_extra_params");
      paramCharSequence = (String)((HashMap)localObject).get("img_url");
      String str = (String)((HashMap)localObject).get("desc");
      localObject = (String)((HashMap)localObject).get("title");
      com.tencent.mm.pluginsdk.ui.applet.d.a(this.uRf, (String)localObject, paramCharSequence, str, null, true, getResources().getString(R.l.dIs), new k.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          GMTrace.i(2967017095168L, 22106);
          if (paramAnonymousBoolean)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("enterprise_biz_name", paramString);
            localIntent.putExtra("key_biz_chat_id", paramLong);
            localIntent.putExtra("key_is_biz_chat", true);
            if (!bf.mA(paramAnonymousString)) {
              localIntent.putExtra("enterprise_share_append_text", paramAnonymousString);
            }
            BizChatSelectConversationUI.this.setResult(-1, localIntent);
            BizChatSelectConversationUI.this.finish();
          }
          GMTrace.o(2967017095168L, 22106);
        }
      });
    }
    GMTrace.o(2993323769856L, 22302);
  }
  
  private void bTl()
  {
    GMTrace.i(2992518463488L, 22296);
    if (bf.mA(this.jZw))
    {
      this.jZw = getIntent().getStringExtra("enterprise_biz_name");
      if (bf.mA(this.jZw))
      {
        v.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
        finish();
      }
    }
    GMTrace.o(2992518463488L, 22296);
  }
  
  protected final boolean Og()
  {
    GMTrace.i(2993726423040L, 22305);
    GMTrace.o(2993726423040L, 22305);
    return false;
  }
  
  protected final boolean Oh()
  {
    GMTrace.i(2993457987584L, 22303);
    GMTrace.o(2993457987584L, 22303);
    return false;
  }
  
  protected final String Oi()
  {
    GMTrace.i(2993592205312L, 22304);
    String str = com.tencent.mm.u.n.eK(this.jZw);
    GMTrace.o(2993592205312L, 22304);
    return str;
  }
  
  protected final o Oj()
  {
    GMTrace.i(2992652681216L, 22297);
    bTl();
    d locald = new d(this, this.jZw);
    GMTrace.o(2992652681216L, 22297);
    return locald;
  }
  
  protected final com.tencent.mm.ui.contact.m Ok()
  {
    GMTrace.i(2992786898944L, 22298);
    bTl();
    com.tencent.mm.ui.contact.p localp = new com.tencent.mm.ui.contact.p(this, this.jZw);
    GMTrace.o(2992786898944L, 22298);
    return localp;
  }
  
  public final void a(int paramInt, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2993994858496L, 22307);
    if ((this.irp != null) && (this.irp.isShowing()))
    {
      this.irp.dismiss();
      this.irp = null;
    }
    if (paramk.getType() == 1355)
    {
      paramk = ((com.tencent.mm.modelbiz.a.n)paramk).Eb();
      paramk = w.DJ().ir(paramk.tru.tyW.tiZ);
      if (paramk == null)
      {
        Toast.makeText(aa.getContext(), getString(R.l.eLP), 0).show();
        GMTrace.o(2993994858496L, 22307);
        return;
      }
      a(this.jZw, paramk.field_bizChatLocalId, paramk.field_chatName);
    }
    GMTrace.o(2993994858496L, 22307);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    GMTrace.i(2992921116672L, 22299);
    super.a(paramListView, paramInt);
    if (this.vuO == null)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2963258998784L, 22078);
          BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
          GMTrace.o(2963258998784L, 22078);
        }
      };
      String str = getString(R.l.eQk);
      View localView = r.eC(this).inflate(R.i.dfq, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(R.h.bGw);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.vuO = ((TextView)localObject);
    }
    this.vuO.setVisibility(paramInt);
    GMTrace.o(2992921116672L, 22299);
  }
  
  protected final void aII()
  {
    GMTrace.i(2993055334400L, 22300);
    super.aII();
    GMTrace.o(2993055334400L, 22300);
  }
  
  public final void he(int paramInt)
  {
    GMTrace.i(2993189552128L, 22301);
    if (paramInt < this.oBp.getHeaderViewsCount())
    {
      v.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(2993189552128L, 22301);
      return;
    }
    if (!(this.oBp.getAdapter().getItem(paramInt) instanceof a))
    {
      v.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
      GMTrace.o(2993189552128L, 22301);
      return;
    }
    a locala = (a)this.oBp.getAdapter().getItem(paramInt);
    if (locala == null)
    {
      GMTrace.o(2993189552128L, 22301);
      return;
    }
    String str = locala.username;
    long l = locala.jZq;
    if ((str == null) || (l == -1L))
    {
      v.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { str, Long.valueOf(l) });
      GMTrace.o(2993189552128L, 22301);
      return;
    }
    a(str, l, locala.ioW);
    GMTrace.o(2993189552128L, 22301);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    GMTrace.i(2993860640768L, 22306);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      GMTrace.o(2993860640768L, 22306);
      return;
    }
    switch (paramInt1)
    {
    default: 
      GMTrace.o(2993860640768L, 22306);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    sr localsr;
    if (paramIntent != null)
    {
      v.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
      String str = paramIntent.getString("enterprise_members");
      localsr = new sr();
      c localc = new c();
      if (this.vtR != null)
      {
        paramIntent = this.vtR.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.jZw;
        if (!e.a(localc, str, null, localsr)) {
          break label271;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label218;
        }
        a(this.jZw, localc.field_bizChatLocalId, localc.field_chatName);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this, getString(R.l.eLP), 0).show();
        GMTrace.o(2993860640768L, 22306);
        return;
        paramIntent = null;
        break;
        label218:
        w.DN();
        paramIntent = h.a(this.jZw, localsr, this);
        getString(R.l.dIG);
        this.irp = g.a(this, getString(R.l.dBZ), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2999363567616L, 22347);
            ap.vd().c(paramIntent);
            GMTrace.o(2999363567616L, 22347);
          }
        });
        paramInt1 = 1;
        continue;
        label271:
        paramInt1 = 0;
        continue;
      }
      GMTrace.o(2993860640768L, 22306);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    GMTrace.i(2992250028032L, 22294);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
    bTl();
    paramBundle = w.DL().iG(this.jZw);
    this.vtR = w.DL().iE(paramBundle);
    String str = this.jZw;
    if (this.vtR == null) {
      bool = true;
    }
    v.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((bf.mA(paramBundle)) || (this.vtR == null) || (this.vtR.DW()) || (bf.mA(this.vtR.field_addMemberUrl)))
    {
      w.DN();
      h.a(this.jZw, this);
      getString(R.l.dIG);
      this.irp = g.a(this, getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2989297238016L, 22272);
          BizChatSelectConversationUI.this.finish();
          GMTrace.o(2989297238016L, 22272);
        }
      });
    }
    GMTrace.o(2992250028032L, 22294);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2992384245760L, 22295);
    super.onDestroy();
    GMTrace.o(2992384245760L, 22295);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/BizChatSelectConversationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */