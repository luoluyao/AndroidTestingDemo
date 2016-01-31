package com.emnets.luoly.robotiummulti;


import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnLongClickListener;

/**
 * 自定义Adapter
 * 可以自定义参数的类型、个数等
 * 而且布局文件其实在getView中已经写好了
 * 同时还可以添加自己的事件，非常方便
 *
 * @author wlc
 *
 */
public class MyAdapter extends BaseAdapter {

	private List<TestClass> list;
	private Context mContext;

	public MyAdapter(Context context, List<TestClass> list) {
		super();
		this.mContext = context;
		this.list = list;
	}

	// 下面的4个方法必须重写
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

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {


		// 初始化页面及页面中的控件
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(R.layout.item, null);
		}


		TextView Name = (TextView)convertView.findViewById(R.id.name_test);
		TextView id = (TextView)convertView.findViewById(R.id.id_test);

		//控件赋值
		final int value_id = list.get(position).getId();
		String value_name = list.get(position).getName();


		Name.setText(value_name);
		id.setText(value_id+"");
		final Context context = mContext;

		//添加一个点击图片删除该ListView中对应的item的事件
		convertView.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//list.remove(position);
				//notifyDataSetChanged();

				new AlertDialog.Builder(context).setTitle("你点击到了第"+value_id+"个").setItems(
						new String[] { value_id+"-1", value_id+"-2" }, null).setNegativeButton(
						"确定", null).show();
			}
		});

		//对ListView中的每一行信息配置OnLongClick事件
		convertView.setOnLongClickListener(new OnLongClickListener(){
			public boolean onLongClick(View v) {
				Toast.makeText(context,
						"你长按了第"+value_id+"项",
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});


		return convertView;
	}
}
