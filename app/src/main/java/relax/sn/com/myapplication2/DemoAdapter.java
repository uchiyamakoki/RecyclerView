package relax.sn.com.myapplication2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2018/3/22.
 */
public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    /*
    第八步 重写适配器方法
     */
    //创建布局需要LayoutInflater 而LayoutInflater需要context获取
    private LayoutInflater  mLayoutInflater;
    //创建链表后重写getItemCount()
    private List<DataModel>  mList=new ArrayList<>();

    private Context context;

    public DemoAdapter(Context context) {
        this.context=context;
        mLayoutInflater=LayoutInflater.from(context);
    }

    //第十步
    public void addList(List<DataModel> list){
        mList.addAll(list); //简单的全部添加,然后返回MainActivity的initData
    }

    /*
        最初的三个实现方法  getItemViewType(第十三步新加)
         */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //2后面的+1 再复制去bindholder 搞错了viewHolder 一直用one 。。。
        switch (viewType){
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one,parent,false));//1.加的东西 2.上面传人的 3.是佛加入根布局
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two,parent,false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //int viewType=getItemViewType(position);//根据position获得viewtype
        ((TypeAbstractViewHolder)holder).bindHolder(mList.get(position));//可以不用switch,应该是多态吧。也不用获取viewtype, 抽象出来，具体在子类实现
        /*//2 +2
        switch (viewType){
            case DataModel.TYPE_ONE:
                ((TypeAbstractViewHolder)holder).bindHolder(mList.get(position));
                break;
            case DataModel.TYPE_TWO:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_two,parent,false));
            case DataModel.TYPE_THREE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_three,parent,false));
        }*/

    }
    //第十三步 快捷键 alt+insert  Override方法
    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType(); //直接用list中的type 第十四步，创建三个不同的布局
    }

    //第九步，创建链表后，重写getItemCount() 跳去第十步，外面修改链表的方法
    @Override
    public int getItemCount() {
        return mList.size();
    }
}
