package moe.xing.rvutils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hehanbo on 16-10-8.
 * <p>
 * sorted list rv adapter
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class BaseSortedRVAdapter<T, R extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<R> {

    protected SortedList<T> datas;
    private int addition = 0;

    public int getAddition() {
        return addition;
    }

    public void setAddition(int addition) {
        this.addition = addition;
    }

    @Override
    public int getItemCount() {
        return datas == null ? addition : addition + datas.size();
    }

    @Nullable
    public T getItem(int position) {
        if (position <= datas.size() && position >= 0) {
            return datas.get(position);
        } else {
            return null;
        }
    }

    public void addData(@NonNull T data) {
        datas.addAll(data);
    }

    public void addData(@Nullable List<T> dataList) {
        if (dataList == null) {
            return;
        }
        int start = datas.size();
        datas.addAll(dataList);
    }

    public void removeData(@NonNull T data) {
        int location = datas.indexOf(data);

        if (location != -1) {
            datas.remove(data);
        }
    }

    public void removeData(@NonNull List<T> dataList) {
        datas.beginBatchedUpdates();
        for (T item : dataList) {
            datas.remove(item);
        }
        datas.endBatchedUpdates();
    }

    public void removeAllData() {
        datas.clear();
    }

    public int getDataSize() {
        return datas.size();
    }

    public SortedList<T> getDatas() {
        return datas;
    }

    public void setDatas(SortedList<T> datas) {
        this.datas = datas;
    }

    public ArrayList<T> getArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            arrayList.add(getItem(i));
        }
        return arrayList;
    }

    public void resetData(@NonNull List<T> newDataList) {
        datas.replaceAll(newDataList);
    }
}
