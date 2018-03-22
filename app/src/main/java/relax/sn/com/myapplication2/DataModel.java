package relax.sn.com.myapplication2;

/**
 * Created by John on 2018/3/22.
 * 伪造数据
 */
public class DataModel {

    public static final int TYPE_ONE=1;

    public static final int TYPE_TWO=2;

    public static final int TYPE_THREE=3;

    public int type;//类型

    public int avatarColor;//头像颜色

    public String name;//名字

    public String content;//内容

    public int contentColor;//内容颜色

    public static int getTypeTwo() {
        return TYPE_TWO;
    }

    public static int getTypeOne() {
        return TYPE_ONE;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static int getTypeThree() {
        return TYPE_THREE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }
}
