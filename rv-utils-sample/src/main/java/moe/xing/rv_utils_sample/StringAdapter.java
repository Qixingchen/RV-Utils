package moe.xing.rv_utils_sample;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import moe.xing.rv_utils_sample.databinding.ItemStringBinding;
import moe.xing.rvutils.BaseRecyclerViewAdapter;

/**
 * Created by Qi Xingchen on 16-12-7.
 */

class StringAdapter extends BaseRecyclerViewAdapter<String, StringAdapter.ViewHolder> {
    StringAdapter() {
        super(String.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemStringBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_string, parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindVH(datas.get(position));
    }

    @Override
    public boolean rvAreContentsTheSame(String oldItem, String newItem) {
        return oldItem.equals(newItem);
    }

    @Override
    public boolean rvAreItemsTheSame(String item1, String item2) {
        //noinspection StringEquality
        return item1 == item2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemStringBinding mBinding;

        ViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.findBinding(itemView);
        }

        void bindVH(final String string) {
            mBinding.setString(string);
            mBinding.executePendingBindings();
        }
    }
}

