package com.summary.hml.viper.singletabletree;

import com.summary.hml.viper.ssm.mapper.tree_mapper.SingleTableTreeMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author xuchao
 * @desc 单表树 - 数据获取
 * @date 2021/11/25 10:50
 */
@Service
public class SingleTableTreeUtil {


    @Autowired
    private SingleTableTreeMapper treeMapper;


    public List<Map<String, Object>> getSingleTableTree(String configType) throws Exception {
        if (StringUtils.isEmpty(configType)) {
            throw new Exception( "视图类型不能为空！");
        }
        //接收所有的信息
        List<Map<String, Object>> allList = new ArrayList<>();
        //接收获取的父节点
        List<Map<String, Object>> parentMapList = new ArrayList<>();
        //接收获取的父节点
        List<Map<String, Object>> retList = new ArrayList<>();
        try {
            //获取所有的信息
            // 通过数据库查询所有的数据
            allList = treeMapper.getSingleTableTree(configType);
            //循环所有信息找出所有的根节点（PARENT_ID=-1）
            for (int i = 0; i < allList.size(); i++) {
                if ("-1".equals(allList.get(i).get("PARENT_ID"))) {
                    //将找出来的根节点重新存到一个List<Map>集合中
                    parentMapList.add(allList.get(i));
                    //从所有的数据中移除根节点
                    allList.remove(i);
                    //每移除一个根节点就将所有数据的个数减一
                    i--;
                }
            }
            //调用此方法寻找子节点
            retList = recursive(allList,parentMapList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retList;
    }


    /**
     * @param parentMapList   所有父节点
     * @param allList         所有数据
     * @return
     */
    public List<Map<String, Object>> recursive(List<Map<String, Object>> allList,List<Map<String,Object>> parentMapList) {
        //循环根节点
        for(int j = 0;j < parentMapList.size(); j++){
            List<Map<String, Object>> tempList = new ArrayList<>();  //用来存取子节点
            //循环全部节点，判断节点中P_id是否与根节点中的id相同
            for(int k = 0; k < allList.size(); k++){
                if(allList.get(k).get("PARENT_ID").equals(parentMapList.get(j).get("id").toString())){
                    tempList.add(allList.get(k));
                }
            }
            if(tempList.size() > 0){
                parentMapList.get(j).put("children",tempList);
                //此次循环又将tempList作为parentMapList（父节点去找其他的子节点），直到没有子节点在执行j+1
                recursive(allList,tempList);
            }
        }
        return  parentMapList;
    }

    public static void main(String[] args) {

    }

}