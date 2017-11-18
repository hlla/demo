/*
 * ******************************************************************************
 *   Copyright (c) 2014 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */
package it.gmariotti.recyclerview.itemanimator.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.gmariotti.recyclerview.itemanimator.demo.R;


/**
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {
    private static final String TAG = "Recycler_SimpleAdapter";
    public static final int LAST_POSITION = -1;
    private final Context mContext;
    private List<String> mData;
    private WeakReference mWeakReference;
    private ReferenceQueue mReferenceQueue = new ReferenceQueue<>();

    public void add(String s, int position) {
        position = position == LAST_POSITION ? getItemCount() : position;
        mData.add(position, s);
        notifyItemInserted(position);
    }

    private class TestObject extends Object {
        public ArrayList<String> strings = new ArrayList<>();

        TestObject() {
//            for (int i = 0; i < 100000; i++) {
//                strings.add(i + "");
//            }
        }

//        @Override
//        protected void finalize() throws Throwable {
//            super.finalize();
//            Exception exception = new Exception("finalize");
////            mTestObject = this;
//            Log.d(TAG, ": TestObject finalize()", exception);
//        }
    }

    public void remove(int position) {
        if (position == LAST_POSITION && getItemCount() > 0)
            position = getItemCount() - 1;

        if (position > LAST_POSITION && position < getItemCount()) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;
        public final View view;

        public SimpleViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.simple_text);
            this.view = view;
        }
    }

    public SimpleAdapter(Context context, String[] data) {
        new Thread() {
            @Override
            public void run() {
                Log.d(TAG, "SimpleAdapter 1111ww");
                super.run();
                while (true) {
                    Reference reference = null;
                    try {
                        reference = mReferenceQueue.remove();
                        if (null != reference) {
                            Log.d(TAG, "objectReferenceQueue111: object=" + reference);
                            Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(reference);
                            Log.d(TAG, "reflect result=" + result + " get()" + reference.get());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    }
                }
            }
        }.start();
        mContext = context;
        if (data != null)
            mData = new ArrayList<String>(Arrays.asList(data));
        else mData = new ArrayList<String>();
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.simple_item, parent,
                false);
        Log.d(TAG, "onCreateViewHolder: view=" + view);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        if (null != mWeakReference) {
            Log.d(TAG, "onBindViewHolder: get()=" + mWeakReference.get());
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestObject object = new TestObject();
        WeakReference weakReference = new WeakReference(object, mReferenceQueue);
        Log.d(TAG, "onBindViewHolder: holder.view=" + holder.view + "  position=" + position + " " +
                "object=" + object + " weakReference=" + weakReference);
        holder.title.setText(mData.get(position));
        holder.view.setTag(position);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Position =" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
