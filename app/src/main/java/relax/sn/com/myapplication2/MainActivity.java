package relax.sn.com.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private DemoAdapter mAdapter;
    //第六步，颜色
    int colors[]={android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark};

    /*
    第一步
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false)); //设置布局样式
        //第二步去建个适配器 DemoAdapter
        mAdapter=new DemoAdapter(this); //创建适配器 第十二步，修改
        mRecyclerView.setAdapter(mAdapter);//RecyclerView设置适配器
        
        initData();
        
    }
    //第三步，伪造数据
    private void initData() {
        //第四步去建个DataModel 因为List的缘故
        List<DataModel> list =new ArrayList<>();

        //第五步随机生成数据 跳去生成颜色 小插曲
        for (int i=0;i<20;i++){

        //第七步，继续伪造数据
            DataModel data=new DataModel();
            int type= (int) ((Math.random()*3)+1);//random返回是double，所以会强转
            data.avatarColor=colors[type-1];
            data.type=type;
            data.name="name : " + i;
            data.content="content : " + i;
            data.contentColor=colors[(type+1)%3];//伪造完成后，去重写适配器构造方法
            list.add(data);
        }
        //第十一步，填充假数据 重写构造方法 创建适配器报错
        mAdapter.addList(list);
        mAdapter.notifyDataSetChanged();
    }
}
