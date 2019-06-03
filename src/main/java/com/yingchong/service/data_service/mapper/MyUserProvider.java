package com.yingchong.service.data_service.mapper;

import java.util.Map;

public class MyUserProvider {

    public String queryUser(Map<String, Object> param) {
        String whereCondition = this.getWhereCondition(param);

        return "SELECT u.id id,u.user_name userName,u.password password, u.nick_name nickName,u.description description, " +
                " u.login_time loginTime, create_time createTime " +
                "from user u  " +
                "where " + whereCondition;
    }

    private String getWhereCondition(Map<String,Object> param) {
        StringBuilder condition = new StringBuilder(" 1=1 ");

        if (param.get("userName") != null && !String.valueOf(param.get("userName")).equals("")) {
            condition.append(" and u.user_name like concat('%',#{userName},'%') ");
        }
        if (param.get("startDate") != null ) {
            condition.append(" and u.create_time >= #{startDate} ");
        }
        if (param.get("endDate") != null ) {
            condition.append(" and u.create_time <= #{endDate} ");
        }
        if (param.get("description") != null && !String.valueOf(param.get("description")).equals("")) {
            condition.append(" and u.description like concat('%',#{description},'%') ");
        }
        return condition.append(" order by u.create_time ").toString();
    }
}
