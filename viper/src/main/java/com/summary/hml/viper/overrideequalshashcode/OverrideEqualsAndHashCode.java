package com.summary.hml.viper.overrideequalshashcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-02-20 10:59
 * @Description : 重写equals 和 hashCode方法
 */
public class OverrideEqualsAndHashCode {

    private String id;

    private String num;

    // 无参构造
    public OverrideEqualsAndHashCode() {
    }

    // 有参构造
    public OverrideEqualsAndHashCode(String id, String num) {
        this.id = id;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }


    @Override
    public boolean equals(Object obj) {
        // 和当前对象比较 地址值相等返回true
        if (this == obj) {
            return true;
        }
        // 判断是否属于同意类型
        // 最好不实用instanceof来判断，当存在子父关系时可能有问题
        if (obj != null && obj.getClass() == getClass()) {
            OverrideEqualsAndHashCode eh = (OverrideEqualsAndHashCode) obj;
            // 判断属性值是否一样
            if (Objects.equals(id, eh.id) && Objects.equals(num, eh.num)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        // objects.hash 实际调用的是Arrays.hashCode(Objects a[])
        return Objects.hash(id, num);
    }


    public static void main(String[] args) {

        OverrideEqualsAndHashCode eh = new OverrideEqualsAndHashCode("1", "2");
        OverrideEqualsAndHashCode eh2 = new OverrideEqualsAndHashCode("1", "2");
        System.out.println(eh.equals(eh2));

        HashMap<OverrideEqualsAndHashCode, Object> map = new HashMap<>();
        map.put(eh, 1);
        // 如果没有重写hashCode 返回null
        System.out.println("获取map中相同对象 eh2 ==> " + map.get(eh2));

        Integer i = 5;
        Integer i2 = 5;
        System.out.println("比较Integer ==> " + i.equals(i2));

        Float f = 2F;
        Float f2 = 2F;
        System.out.println("比较Float ==> " + f.equals(f2));


    }
}
