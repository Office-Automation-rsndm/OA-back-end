package service;

import dao.Userdao;

public class UserService {

    //把数据持久层 注入过来
    private Userdao userdao = new Userdao();


    public boolean login(String userName,String passwd) throws Exception{
        int a = 2;
        return userdao.login(userName, passwd) == 1;//三目运算
    }




}
