package com.google.android.finsky.bb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.o;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.f;
import com.google.android.finsky.e.y;
import com.google.android.finsky.e.z;
import com.google.android.play.image.FifeImageView;
import java.util.Iterator;
import java.util.List;

public class i
  extends android.support.v4.app.j
{
  public a aa;
  public com.google.android.finsky.e.a ab;
  public p ac = null;
  public com.google.android.finsky.bw.l ad;
  public af ae;
  private aq af;
  private boolean ag = false;
  
  private final Bundle j(Bundle paramBundle)
  {
    Object localObject = this.ac;
    Bundle localBundle;
    if (localObject != null)
    {
      localBundle = ((p)localObject).getResult();
      if (localBundle != null) {}
    }
    else
    {
      return paramBundle;
    }
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putAll(localBundle);
    return (Bundle)localObject;
  }
  
  public void R() {}
  
  protected final Bundle S()
  {
    return this.g.getBundle("extra_arguments");
  }
  
  protected final int T()
  {
    return this.g.getInt("target_request_code");
  }
  
  public final void U()
  {
    a(false);
    if (!this.ag)
    {
      this.ag = true;
      Object localObject = this.g;
      int i = T();
      Bundle localBundle = j(S());
      int j = ((Bundle)localObject).getInt("click_event_type_positive", -1);
      if (j != -1) {
        this.ae.a(new f(this.af).a(j));
      }
      localObject = X();
      if (localObject != null) {
        ((q)localObject).a(i, localBundle);
      }
      localObject = r.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((q)((Iterator)localObject).next()).a(i, localBundle);
      }
      W();
    }
  }
  
  public final void V()
  {
    a(false);
    if (!this.ag)
    {
      this.ag = true;
      Object localObject = this.g;
      int i = T();
      Bundle localBundle = j(S());
      int j = ((Bundle)localObject).getInt("click_event_type_negative", -1);
      if (j != -1) {
        this.ae.a(new f(this.af).a(j));
      }
      localObject = X();
      if (localObject != null) {
        ((q)localObject).b(i, localBundle);
      }
      localObject = r.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((q)((Iterator)localObject).next()).b(i, localBundle);
      }
      R();
    }
  }
  
  public void W() {}
  
  protected final q X()
  {
    Object localObject = this.Q;
    if ((localObject instanceof q)) {
      return (q)localObject;
    }
    localObject = j();
    if (!(localObject instanceof q)) {
      return null;
    }
    return (q)localObject;
  }
  
  public Dialog c(Bundle paramBundle)
  {
    ((d)com.google.android.finsky.dt.b.a(d.class)).a(this);
    Bundle localBundle = this.g;
    this.ae = this.ab.a(localBundle);
    this.af = null;
    if (localBundle.containsKey("impression_type")) {
      this.af = new y(localBundle.getInt("impression_type"), localBundle.getByteArray("impression_cookie"), null);
    }
    if (paramBundle != null) {}
    for (;;)
    {
      paramBundle = new b();
      if (localBundle.containsKey("theme_id")) {
        paramBundle.j = localBundle.getInt("theme_id");
      }
      Object localObject1 = localBundle.getString("title_icon_url");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        View localView = LayoutInflater.from(by_()).inflate(2131625022, null);
        localObject2 = (TextView)localView.findViewById(2131429479);
        if (localBundle.containsKey("title"))
        {
          ((TextView)localObject2).setText(localBundle.getString("title"));
          localObject2 = (FifeImageView)localView.findViewById(2131428303);
          this.ad.a((FifeImageView)localObject2, (String)localObject1, localBundle.getBoolean("title_icon_support_fife", false));
          paramBundle.a = localView;
        }
      }
      for (;;)
      {
        if (localBundle.containsKey("icon_id")) {
          paramBundle.d = localBundle.getInt("icon_id");
        }
        if (localBundle.containsKey("message_id")) {
          paramBundle.e = j().getText(localBundle.getInt("message_id"));
        }
        for (;;)
        {
          int i;
          if (localBundle.containsKey("positive_id"))
          {
            i = localBundle.getInt("positive_id");
            paramBundle.i = j().getText(i);
            paramBundle.h = new j(this);
          }
          for (;;)
          {
            if (localBundle.containsKey("negative_id"))
            {
              i = localBundle.getInt("negative_id");
              paramBundle.g = j().getText(i);
              paramBundle.f = new l(this);
            }
            for (;;)
            {
              if (localBundle.containsKey("force_inverse_background")) {
                paramBundle.c = localBundle.getBoolean("force_inverse_background");
              }
              if (localBundle.containsKey("layoutId"))
              {
                i = localBundle.getInt("layoutId");
                localObject1 = LayoutInflater.from(j()).inflate(i, null);
                paramBundle.b = ((View)localObject1);
                if ((localObject1 instanceof p))
                {
                  this.ac = ((p)localObject1);
                  if (localBundle.containsKey("config_arguments"))
                  {
                    localObject1 = localBundle.getBundle("config_arguments");
                    this.ac.a((Bundle)localObject1);
                  }
                }
              }
              paramBundle = this.aa.a(j(), paramBundle);
              localObject1 = (TextView)j().findViewById(16908299);
              if (localBundle.containsKey("layoutId")) {}
              for (;;)
              {
                if (localBundle.containsKey("cancel_on_touch_outside")) {
                  paramBundle.setCanceledOnTouchOutside(localBundle.getBoolean("cancel_on_touch_outside"));
                }
                return paramBundle;
                if (localObject1 != null) {
                  paramBundle.setOnShowListener(new n((TextView)localObject1));
                }
              }
              if (localBundle.containsKey("negative_label"))
              {
                paramBundle.g = localBundle.getString("negative_label");
                paramBundle.f = new m(this);
              }
            }
            if (localBundle.containsKey("positive_label"))
            {
              paramBundle.i = localBundle.getString("positive_label");
              paramBundle.h = new k(this);
            }
          }
          if (localBundle.containsKey("message")) {
            paramBundle.e = localBundle.getString("message");
          } else if (localBundle.containsKey("messageHtml")) {
            paramBundle.e = Html.fromHtml(localBundle.getString("messageHtml"));
          } else if (localBundle.containsKey("messageCharSeq")) {
            paramBundle.e = localBundle.getCharSequence("messageCharSeq");
          }
        }
        if (!localBundle.containsKey("title_id")) {
          break;
        }
        ((TextView)localObject2).setText(localBundle.getInt("title_id"));
        break;
        if (localBundle.containsKey("title")) {
          paramBundle.k = localBundle.getString("title");
        } else if (localBundle.containsKey("title_id")) {
          paramBundle.k = j().getText(localBundle.getInt("title_id"));
        }
      }
      if (this.af != null) {
        this.ae.a(new z().b(this.af));
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    if (this.g.getBoolean("cancel_does_negative_action", true)) {
      V();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bb/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */