package com.xing.mp.service;

import com.alibaba.fastjson.JSON;
import com.xing.mp.mapper.UserMapper;
import com.xing.mp.model.User;
import com.xing.mp.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {

    @Autowired
    UserMapper userMapper;

    private static final String CODE_2_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=%s";

    private static final String APP_KEY = "wx4c745e4a039d9887";

    private static final String APP_SECRET = "fddcb2676d69b9580e1522ebf2bb311d";

    private static final String AUTH_TYPE = "authorization_code";

    public Map<String, Object> getWxSession(String wxCode) {

        String sb = String.format(CODE_2_SESSION, APP_KEY, APP_SECRET, wxCode, AUTH_TYPE);
        String res = HttpUtils.doGet(sb);
        if (res == null || "".equals(res)) {
            return null;
        }
        return JSON.parseObject(res, Map.class);
    }


    public void login(String code) {
        Map<String, Object> sessionMap = this.getWxSession(code);
        String openid = (String) sessionMap.get("openid");
        String unionid = (String) sessionMap.get("unionid");
        String sessionKey = (String) sessionMap.get("session_key");

       // 根据openid查询客户信息
        User user = userMapper.selectByOpenid(openid);
        if (null == user) {
            user = User.builder().openid(openid).unionid(unionid).build();
            //  如果信息不存在，新增用户信息
            userMapper.insert(user);
        }
    }

    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }


//    public String bindingPhone(WxBindPhoneRequest request) {
//        String phoneNumber = null;
//        try {
//            String decrypt = AESDecodeUtils.decrypt(
//                    Base64.decodeBase64(request.getSessionKey()),
//                    Base64.decodeBase64(request.getIv()),
//                    Base64.decodeBase64(request.getEncData())
//            );
//            JSONObject jsonObject = JSON.parseObject(decrypt);
//            phoneNumber = jsonObject.getString("phoneNumber");
//        } catch (Exception ex) {
//            String errMsg = "解析数据失败";
//            serviceHelper.handleErrorAndThrowException(logger, ex, errMsg);
//            throw new ServiceException(ResultCode.ENTITY_ERROR, errMsg);
//        }
//
//        if (StringUtil.isEmpty(phoneNumber)) {
//            throw new ServiceException(ResultCode.WX_RESOLVE_PHONE_ERROR, "解析手机号为空");
//        }
//
//        // 如果号码已经绑定其它的账号，解绑其它的账号，绑定这个账号
//        MaUser userDO = this.userRepo.findUserByPhone(phoneNumber);
//
//        if (userDO != null) {
//            //解除绑定
//            int result = this.userRepo.updateMaUserById("", userDO.getId());
//            if (result == 0) {
//                throw new ServiceException(ResultCode.DATABASES_UPDATE_ERROR, "数据更新异常");
//            }
//        }
//        //重新绑定新的账号
//        int result = this.userRepo.updateMaUserById(phoneNumber, request.getUserId());
//        if (result == 0) {
//            throw new ServiceException(ResultCode.DATABASES_UPDATE_ERROR, "数据更新异常");
//        }
//        return phoneNumber;
//    }

}
