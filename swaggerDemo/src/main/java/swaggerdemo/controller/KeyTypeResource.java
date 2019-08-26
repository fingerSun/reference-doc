package swaggerdemo.controller;

import swaggerdemo.domain.KeyTypeInfoDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import swaggerdemo.domain.KeyTypeInfoDTO;

import java.util.Map;

/**
 * @author 韩通
 * @since 2019-06-11
 *
 */
@Api(tags = "流转模块：钥匙类型管理")
public interface KeyTypeResource {

	String PREFIX = "${tauro:}/v2/keyType";

	@PostMapping(PREFIX)
	@ApiOperation(value = "增加钥匙类型", notes = "增加钥匙类型")
	String addKeyTypeInfo(@RequestBody @ApiParam(name = "钥匙类型信息", value = "钥匙类型信息", required = true) KeyTypeInfoDTO keyTypeInfoDTO);

	@GetMapping(PREFIX)
	@ApiOperation(value = "分页查询钥匙类型", notes = "分页查询钥匙类型")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "clrCenterNo", value = "清机中心", example = "1001" , paramType = "query"),
			@ApiImplicitParam(name = "keyUseRange", value = "钥匙使用范围", example = "1" , paramType = "query"),
			@ApiImplicitParam(name = "keyTypeNo", value = "钥匙类型编号", example = "10011001" , paramType = "query"),
			@ApiImplicitParam(name = "keyTypeName", value = "钥匙类型名称", example = "日立钞箱锁钥匙" , paramType = "query"),
			@ApiImplicitParam(name = "curPage", value = "当前页码", defaultValue = "1" , required = true , paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", defaultValue = "10" ,  required = true , paramType = "query")
	})
	String qryKeyTypeInfoByPage(@ApiIgnore @RequestParam Map<String, Object> paramMap);

	@PutMapping(PREFIX)
	@ApiOperation(value = "修改钥匙类型", notes = "修改钥匙类型")
	String modKeyTypeInfo(@RequestBody @ApiParam(name = "钥匙类型对象", value = "钥匙类型对象", required = true) KeyTypeInfoDTO keyTypeInfoDTO);

	@DeleteMapping(PREFIX + "/{keyTypeNo}")
	@ApiOperation(value = "删除钥匙类型", notes = "删除钥匙类型")
	@ApiImplicitParam(name = "keyTypeNo", value = "钥匙类型编号" , example = "10011001" , required = true, paramType = "path")
	String delKeyTypeInfo(@PathVariable("keyTypeNo") String keyTypeNo);

	@GetMapping(PREFIX + "/{keyTypeNo}")
	@ApiOperation(value = "查询钥匙类型详情", notes = "查询钥匙类型详情")
	@ApiImplicitParam(name = "keyTypeNo", value = "钥匙类型编号",example = "10011001" , required = true, paramType = "path")
	String qryKeyTypeInfo(@PathVariable("keyTypeNo") String keyTypeNo);

//	@PostMapping(PREFIX)
//	@ApiReturnJson({
//			@ApiReturnJsonPro(key = "keyTypeNo1", example = "1111", description = "测试")
//	})
//	@ApiOperation(value = "增加钥匙类型测试", notes = "增加钥匙类型")
//	String addKeyTypeInfo1(@RequestBody @ApiParam(name = "钥匙类型信息" , value = "钥匙类型信息" , required = true) KeyTypeInfoDTO keyTypeInfoDTO);

}
