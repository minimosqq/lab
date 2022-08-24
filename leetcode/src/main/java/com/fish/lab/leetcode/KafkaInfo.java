package com.fish.lab.leetcode;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by zhangguixian on 30/09/2018.
 */
public class KafkaInfo implements Serializable{
    private static final long serialVersionUID = -8096691249526791423L;
    private String topic;
    private String namespace;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }


    public KafkaInfo() {
    }

    public KafkaInfo(String topic, String namespace) {
        this.topic = topic;
        this.namespace = namespace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KafkaInfo kafkaInfo = (KafkaInfo) o;
        return Objects.equals(topic, kafkaInfo.topic) &&
                Objects.equals(namespace, kafkaInfo.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, namespace);
    }

    @Override
    public String toString() {
        return "com.fish.lab.leetcode.KafkaInfo{" +
                "topic='" + topic + '\'' +
                ", namespace='" + namespace + '\'' +
                '}';
    }
}
