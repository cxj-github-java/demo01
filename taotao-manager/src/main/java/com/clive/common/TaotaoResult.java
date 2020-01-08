package com.clive.common;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaotaoResult {
	//定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();
	//响应业务状态，200表示成功，500表示失败
	private Integer status;
	//响应消息。返回给页面展示。封装到msg内
	private String msg;
	//响应中的数据，如果要传入json格式的数据，data代表这个数据
	private Object data;
	//有参构造，new TaotaoResult(200，“成功”)
	public TaotaoResult(Integer status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	//wucan 构造
	public TaotaoResult() {
		super();
	}
	//这是一个有参的构造方法，如果传入new TaotaoResult(null)
	public TaotaoResult(Object data) {
		super();
		this.status = 200;
		this.msg = "ok";
		this.data = data;
	}
	//这是一个静态方法，TaotaoResult.ok();
	public static TaotaoResult ok(){
		//new了一个参数里面的构造方法，会去执行一个参数的构造方法里面的代码
		return new TaotaoResult(null);
	}
	//如果外界这样调用，TaotaoResult.ok(item); data==item
	public static TaotaoResult ok(Object data){
		//new了一个参数里面的构造方法，会去执行一个参数的构造方法里面的代码
		return new TaotaoResult(data);
	}
	public static TaotaoResult build(Integer status, String msg, Object data){
		return new TaotaoResult(status,msg,data);
	}
	public static TaotaoResult build(Integer status, String msg) {
        return new TaotaoResult(status, msg, null);
    }
	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为TaotaoResult对象
     * 调用该方法时，把json数据装到哪个类里面去，传入该类的字节码对象
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
     * @return
     */
    public static TaotaoResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, TaotaoResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static TaotaoResult format(String json) {
        try {
            return MAPPER.readValue(json, TaotaoResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static TaotaoResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
	
}
