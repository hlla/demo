package com.google.android.finsky.bu;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class c
  extends a
{
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setBackgroundColor(k().getColor(2131099953));
    return paramLayoutInflater;
  }
  
  @TargetApi(22)
  protected final Transition ac()
  {
    return new Fade().setDuration(0L);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bu/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */