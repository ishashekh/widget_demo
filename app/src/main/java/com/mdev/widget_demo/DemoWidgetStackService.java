package com.mdev.widget_demo;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class DemoWidgetStackService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        //return an object of class DemoWidgetStackViewsFactory
        return new DemoWidgetStackViewsFactory(this.getApplicationContext());
    }
}

class DemoWidgetStackViewsFactory implements RemoteViewsService.RemoteViewsFactory{

    public static int numImages = 6;
    public Context context;

    public DemoWidgetStackViewsFactory (Context context){
        this.context = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return numImages;
    }

    @Override
    public RemoteViews getViewAt(int i) {
        //i goes from 0 to n-1
        //inflate stack_item and return
        RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.stack_item);
        int num = i + 1;
        String image_id = "img_" + num;

        //getResources().getIdentifier("myIcon", "drawable", etPackageName());
        view.setImageViewResource(R.id.stack_image, context.getResources().getIdentifier(image_id, "drawable", context.getPackageName()));
        return view;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}