# 接口文档开发规范
## DTO对象注解描述
- `@ApiModel`：描述一个DTO的信息
    - value = "DTO类的名称"
    - description = "DTO类的详细描述"
- `@ApiModelProperty`：描述一个DTO的属性信息
    - value = "DTO类的属性名称"
    - example = "DTO类属性的示例值"  
    
示例  
```java
@Data
@ApiModel(value = "钥匙类别", description = "钥匙类别")
public class KeyTypeInfoDTO extends DTO{

   private static final long serialVersionUID = 1L;

   @ApiModelProperty(value = "清机中心编号" , example = "1001")
   private String clrCenterNo;

   @ApiModelProperty(value = "清机中心名称" , example = "工总行" )
   private String centerName;

   @ApiModelProperty(value = "钥匙使用范围 —— 1:金库 2：网点 3：设备" , example = "1" )
   private Integer keyUseRange;

   @ApiModelProperty(value = "钥匙类型编号" , example = "10011001" )
   private String keyTypeNo;

   @ApiModelProperty(value = "钥匙类型名称" , example = "日立钞箱锁钥匙" )
   private String keyTypeName;

   @ApiModelProperty(value = "备注" , example = "备注信息" )
   private String note;
}
```

## Resource接口注解描述

- `@Api` ：描述一个接口的功能
    - tags = "接口功能描述"
- `PREFIX` ：接口资源路径（主模块名+接口版本号+子模块名）  

示例：
```java
@Api(tags = "流转模块：钥匙类型管理")
public interface KeyTypeResource {
    String PREFIX = "${tauro:}/v2/keyType";
}
```

## 增加接口注解描述
- `@PostMapping(PREFIX)` ：restful风格post方法
- `@ApiOperation` : 对一个接口方法的描述
    - value = "接口方法的简短描述"
    - notes= "接口方法的详细描述"
- `@RequestBody` ：post方法接收参数
- `@ApiParam` ：对入参进行描述
    - name= "入参名称"
    - value= "入参详细描述"
    - required= "入参是否必须"
        - true ：必须
        - false ：不必须（默认）  
        
示例：
```java
@PostMapping(PREFIX)
@ApiOperation(value = "增加钥匙类型", notes = "增加钥匙类型")
String addKeyTypeInfo(@RequestBody @ApiParam(name = "钥匙类型信息" , value = "钥匙类型信息" , required = true) KeyTypeInfoDTO keyTypeInfoDTO);
```

## 修改接口注解描述
相似于增加接口

- `@PutMapping(PREFIX)` ：restful风格put方法
- `@ApiOperation` : 对一个接口方法的描述
    - value = "接口方法的简短描述"
    - notes= "接口方法的详细描述"
- `@RequestBody` ：post方法接收参数
- `@ApiParam` ：对入参进行描述
    - name= "入参名称"
    - value= "入参详细描述"
    - required= "入参是否必须"
        - true ：必须
        - false ：不必须（默认）  
    
示例：
```java
@PutMapping(PREFIX)
@ApiOperation(value = "修改钥匙类型", notes = "修改钥匙类型")
String modKeyTypeInfo(@RequestBody @ApiParam(name = "钥匙类型信息" , value = "钥匙类型信息" , required = true) KeyTypeInfoDTO keyTypeInfoDTO);
```

## 删除接口注解描述

- `@DeleteMapping(PREFIX + "/{keyTypeNo}")` ：restful风格delete方法
- `@ApiOperation` : 对一个接口方法的描述
    - value = "接口方法的简短描述"
    - notes= "接口方法的详细描述"
- `@ApiImplicitParam` ：对一个参数的详细描述
    - name= "参数名称"
    - value= "参数详细描述"
    - example= "参数示例值"
    - required= "参数是否必须"
        - true ：必须
        - false ：不必须（默认）
    - paramType= "指定参数放置位置"
        - header ：请求参数放置于Request Header，使用@RequestHeader获取
        - query ：请求参数放置于请求地址，使用@RequestParam获取
        - path ：（用于restful接口）-->请求参数的获取：@PathVariable
    - defaultValue= "参数默认值（用于传值如果为空后台初始化的字段）"
    - dataType= "参数类型"  
    
示例：
```java
@DeleteMapping(PREFIX + "/{keyTypeNo}")
@ApiOperation(value = "删除钥匙类型", notes = "删除钥匙类型")
@ApiImplicitParam(name = "keyTypeNo", value = "钥匙类型编号" , example = "10011001" , required = true, paramType = "path")
String delKeyTypeInfo(@PathVariable("keyTypeNo") String keyTypeNo);
```

## 分页查询接口注解描述

- `@GetMapping(PREFIX)` ： restful风格get方法
- `@ApiOperation` : 对一个接口方法的描述
    - value = "接口方法的简短描述"
    - notes= "接口方法的详细描述"
- `@ApiImplicitParams` ： 对一组入参的描述
- `@ApiImplicitParam` ：对一个入参的描述
    - name= "参数名称"
    - value= "参数详细描述"
    - example= "参数示例值"
    - required= "参数是否必须"
        - true ：必须
        - false ：不必须（默认）
    - paramType= "指定参数放置位置"
        - header ：请求参数放置于Request Header，使用@RequestHeader获取
        - query ：请求参数放置于请求地址，使用@RequestParam获取
        - path ：（用于restful接口）-->请求参数的获取：@PathVariable
    - defaultValue= "参数默认值（用于传值如果为空后台初始化的字段）"
    - dataType= "参数类型"
- `@ApiIgnore` ：忽略注解  
    
示例：

```java
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
```

## 查询详情接口注解描述

相似于删除接口  
- `@GetMapping(PREFIX + "/{keyTypeNo}")` ：restful风格get方法
- `@ApiOperation` : 对一个接口方法的描述
    - value = "接口方法的简短描述"
    - notes= "接口方法的详细描述"
- `@ApiImplicitParam` ：对一个参数的详细描述
    - name= "参数名称"
    - value= "参数详细描述"
    - example= "参数示例值"
    - required= "参数是否必须"
        - true ：必须
        - false ：不必须（默认）
    - paramType= "指定参数放置位置"
        - header ：请求参数放置于Request Header，使用@RequestHeader获取
        - query ：请求参数放置于请求地址，使用@RequestParam获取
        - path ：（用于restful接口）-->请求参数的获取：@PathVariable
    - defaultValue= "参数默认值（用于传值如果为空后台初始化的字段）"
    - dataType= "参数类型"

示例：
```java
@GetMapping(PREFIX + "/{keyTypeNo}")
@ApiOperation(value = "查询钥匙类型详情", notes = "查询钥匙类型详情")
@ApiImplicitParam(name = "keyTypeNo", value = "钥匙类型编号",example = "10011001" , required = true, paramType = "path")
String qryKeyTypeInfo(@PathVariable("keyTypeNo") String keyTypeNo);
```
