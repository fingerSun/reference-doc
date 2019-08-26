package swaggerdemo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 *	测试用户
 * @author 韩通
 * @since 2019-06-29
 */
@Data
@ApiModel(value = "测试用户信息", description = "测试用户信息")
public class User {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户编号" , notes = "Unique identifier of the person. No two persons can have the same id.", example = "1", position = 0)
    private long id;

    @ApiModelProperty(value = "姓名" , example = "zhangsan1" , position = 1)
    private String name;

    @ApiModelProperty(value = "年龄" , example = "18" , position = 2)
    private int age;
}
