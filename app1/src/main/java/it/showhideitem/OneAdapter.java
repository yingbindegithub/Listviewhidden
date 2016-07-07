package it.showhideitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/5.
 */
public class OneAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> list;
    private int currentItem = -1; //用于记录点击的 Item 的 position，是控制 item 展开的核心

    public OneAdapter(Context context, ArrayList<String> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        private LinearLayout showArea;
        private TextView showTV;
        private TextView hideTV;
        private RelativeLayout hideArea;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
            holder.showArea = (LinearLayout) convertView.findViewById(R.id.layout_showArea);
            holder.showTV = (TextView) convertView.findViewById(R.id.show_tv);


            holder.hideTV = (TextView) convertView.findViewById(R.id.hide_tv);

            holder.hideArea = (RelativeLayout) convertView.findViewById(R.id.layout_hideArea);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 为了记录点击的 position，用 position 设置 Tag
        holder.showArea.setTag(position);

        holder.showTV.setText("这是显示部分");
        holder.hideTV.setText("这是隐藏部分");

        //根据 currentItem 记录的点击位置来设置"对应Item"的可见性（在list依次加载列表数据时，每加载一个时都看一下是不是需改变可见性的那一条）
        if (currentItem == position) {
            holder.hideArea.setVisibility(View.VISIBLE);
        } else {
            holder.hideArea.setVisibility(View.GONE);
        }

        holder.showArea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //用 currentItem 记录点击位置
                int tag = (Integer) view.getTag();
                if (tag == currentItem) { //再次点击
                    currentItem = -1; //给 currentItem 一个无效值
                } else {
                    currentItem = tag;
                }
                //通知adapter数据改变需要重新加载
                notifyDataSetChanged(); //必须有的一步
            }
        });
        return convertView;
    }


}
