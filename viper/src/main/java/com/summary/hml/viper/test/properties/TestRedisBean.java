package com.summary.hml.viper.test.properties;

/**
 * ♪───Ｏ（≧∇≦）Ｏ────♪
 *
 * @Author ： 花满楼
 * @CreateTime ： 2023-06-02 14:23
 * @Description : TODO
 */
public class TestRedisBean {

    private String host;

    private String port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "DataSourceBean{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

}
