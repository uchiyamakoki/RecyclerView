package relax.sn.com.myapplication2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by John on 2018/3/22.
 * 第二天第一步 第一个ViewHolder
 */
public class TypeThreeViewHolder extends TypeAbstractViewHolder{

    //2第二步，初始化实例 参考一布局
    public ImageView avatar;

    public TextView name;

    public TextView content;

    public ImageView contentImage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        //2第三步 根据上面类型强转 主要是不知道为啥没提示
        avatar=(ImageView) itemView.findViewById(R.id.avatar);
        name=(TextView) itemView.findViewById(R.id.name);
        content=(TextView) itemView.findViewById(R.id.content);
        contentImage=(ImageView) itemView.findViewById(R.id.contentImage);
    }

    //2第四步绑定 之后再写第二个Holder其实类似
    @Override
    public void  bindHolder(DataModel model){
        avatar.setBackgroundResource(model.getAvatarColor());
        name.setText(model.getName());
        contentImage.setBackgroundResource(model.getContentColor());
        content.setText(model.getContent());
    }
}
