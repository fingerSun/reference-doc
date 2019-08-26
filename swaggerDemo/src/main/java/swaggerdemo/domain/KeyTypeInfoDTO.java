package swaggerdemo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *	钥匙类别
 * @author 韩通
 * @since 2019-06-11
 */
@Data
@ApiModel(value = "钥匙类别", description = "钥匙类别")
public class KeyTypeInfoDTO{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "清机中心编号" , example = "1001")
	private String clrCenterNo;

	@ApiModelProperty(value = "清机中心名称" , example = "工总行" )
	private String centerName;

	@ApiModelProperty(value = "钥匙使用范围 —— 1:金库 2：网点 3：设备" , example = "1")
	private Integer keyUseRange;

	@ApiModelProperty(value = "钥匙类型编号 —— 金库编号+使用范围+“001”" , example = "10011001" )
	private String keyTypeNo;

	@ApiModelProperty(value = "钥匙类型名称" , example = "日立钞箱锁钥匙" )
	private String keyTypeName;

	@ApiModelProperty(value = "备注" , example = "备注信息" )
	private String note;
}
