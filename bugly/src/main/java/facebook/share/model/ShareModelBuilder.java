package com.facebook.share.model;

import com.facebook.share.ShareBuilder;

public abstract interface ShareModelBuilder<P extends ShareModel, E extends ShareModelBuilder>
  extends ShareBuilder<P, E>
{
  public abstract E readFrom(P paramP);
}


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/share/model/ShareModelBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */