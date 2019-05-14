package com.rencai.service.user_service.mapper;

import java.util.Map;

public class MyUserProvider {

    public String queryUser(Map<String, Object> param) {
        String whereCondition = this.getWhereCondition(param);

        return "SELECT u.id id,u.user_name name,u.age age, s.score score " +
                "from user u left join score s on u.id = s.user_id " +
                "where " + whereCondition;
    }

    private String getWhereCondition(Map<String,Object> param) {
        StringBuilder condition = new StringBuilder(" 1=1 ");

        if (param.get("keyWord") != null && !String.valueOf(param.get("keyWord")).equals("")) {
            condition.append(" and (signal_id like concat('%',#{keyWord},'%') or user_name like concat('%',#{keyWord},'%') or email like concat('%',#{keyWord},'%'))");
        }
        if (param.get("startDate") != null ) {
            condition.append(" and u.create_time >= #{startDate} ");
        }
        if (param.get("endDate") != null ) {
            condition.append(" and u.create_time <= #{endDate} ");
        }

        if (param.get("status") != null) {
            condition.append(" and status = #{status} ");
        }
        if (param.get("mobile") != null) {
            condition.append(" and mobile = #{mobile} ");
        }
        if (param.get("email") != null) {
            condition.append(" and email like concat('%',#{email},'%') ");
        }

        return condition.append(" order by u.create_time ").toString();
    }
}
