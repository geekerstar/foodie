package com.geekerstar.service.center;

import com.geekerstar.bo.center.CenterUserBO;
import com.geekerstar.pojo.Users;

/**
 * @author geekerstar
 * date: 2019/11/23 17:17
 * description:
 */
public interface CenterUserService {
    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    Users queryUserInfo(String userId);

    /**
     * 修改用户信息
     * @param userId
     * @param centerUserBO
     */
    Users updateUserInfo(String userId, CenterUserBO centerUserBO);

    /**
     * 用户头像更新
     * @param userId
     * @param faceUrl
     * @return
     */
    Users updateUserFace(String userId, String faceUrl);

}
