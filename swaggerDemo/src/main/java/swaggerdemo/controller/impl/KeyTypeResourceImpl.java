package swaggerdemo.controller.impl;


import swaggerdemo.controller.KeyTypeResource;
import swaggerdemo.domain.KeyTypeInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 钥匙类型
 *
 * @author 韩通
 * @since 2019-06-11
 */
@Slf4j
@RestController
public class KeyTypeResourceImpl implements KeyTypeResource {

    /**
     * 增加钥匙类型
     */
    @Override
    public String addKeyTypeInfo(KeyTypeInfoDTO keyTypeInfoDTO) {
       return keyTypeInfoDTO.toString();
    }

    /**
     * 分页查询钥匙类型
     */
    @Override
    public String qryKeyTypeInfoByPage(Map<String, Object> paramMap) {
        return "成功";
    }


    /**
     * 修改钥匙类型
     */
    @Override
    public String modKeyTypeInfo(KeyTypeInfoDTO keyTypeInfoDTO) {

        return keyTypeInfoDTO.toString();
    }

    /**
     * 删除钥匙类型
     */
    @Override
    public String delKeyTypeInfo(String keyTypeNo) {
        return keyTypeNo;
    }

    /**
     * 查询钥匙类型详情
     */
    @Override
    public String qryKeyTypeInfo(String keyTypeNo){
        return keyTypeNo;
    }

//    /**
//     * 增加钥匙类型测试
//     */
//    @Override
//    public String addKeyTypeInfo1(KeyTypeInfoDTO keyTypeInfoDTO) {
//        return keyTypeInfoDTO.toString();
//    }

}
