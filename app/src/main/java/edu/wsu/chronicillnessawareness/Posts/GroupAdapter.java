package edu.wsu.chronicillnessawareness.Posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import edu.wsu.chronicillnessawareness.Model.MyListModel;
import edu.wsu.chronicillnessawareness.R;

public class GroupAdapter extends RecyclerView.Adapter< GroupAdapter.ViewHolder>{
    private MyListModel[] listdata;

    // RecyclerView recyclerView;
    public GroupAdapter(MyListModel[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListModel myListData = listdata[position];
        holder.textView_name.setText(listdata[position].getName());
        holder.imageView.setImageResource(listdata[position].getImgId());
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView_name;
        public TextView textView_desc;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.img_post);
            this.textView_name = itemView.findViewById(R.id.tv_username);

        }
    }
}