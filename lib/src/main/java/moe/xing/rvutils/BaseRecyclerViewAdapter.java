package moe.xing.rvutils;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;

/**
 * Created by Hehanbo on 2016/5/17 0017.
 * <p>
 * RecyclerView 的基础适配器
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class BaseRecyclerViewAdapter<T, R extends RecyclerView.ViewHolder> extends BaseSortedRVAdapter<T, R> {

    private int addition = 0;

    public BaseRecyclerViewAdapter(Class<T> kClass) {
        //noinspection ComparatorMethodParameterNotUsed
        setDatas(new SortedList<>(kClass, new SortedListAdapterCallback<T>(this) {
            @Override
            public int compare(T o1, T o2) {
                return rvCompare(o1, o2);
            }

            @Override
            public boolean areContentsTheSame(T oldItem, T newItem) {
                return rvAreContentsTheSame(oldItem, newItem);
            }

            @Override
            public boolean areItemsTheSame(T item1, T item2) {
                return rvAreItemsTheSame(item1, item2);
            }
        }));
    }

    protected int rvCompare(T o1, T o2) {
        return 0;
    }

    public boolean rvAreContentsTheSame(T oldItem, T newItem) {
        return oldItem.toString().equals(newItem.toString());
    }

    public boolean rvAreItemsTheSame(T item1, T item2) {
        return item1.equals(item2);
    }

}
