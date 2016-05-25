package cn.huwhy.wx.api.user;

public class UserList {
    private int total;
    private int count;
    private UserListData data;
    private String next_openid;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UserListData getData() {
        return data;
    }

    public void setData(UserListData data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "total=" + total +
                ", count=" + count +
                ", data=" + data +
                ", next_openid=" + next_openid +
                '}';
    }
}
