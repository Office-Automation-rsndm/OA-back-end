package entity;

public class User {
    /**
     * user_id              int not null,
     *    dept_id              int,
     *    user_name          varchar(30),
     *    user_creattime       datetime,
     *    user_modifytime      datetime,
     *    user_dept            varchar(30),
     *    user_phone           varchar(11),
     *    user_email           varchar(30),
     *    user_pwd             varchar(12),
     */

    private int user_id;  //用户id

    private int dept_id;  //部门的id

    private String user_name; //用户名

    private String user_pwd; //用户密码

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public User() {
    }

    public User(int user_id, int dept_id, String user_name, String user_pwd) {
        this.user_id = user_id;
        this.dept_id = dept_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", dept_id=" + dept_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}
