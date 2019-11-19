package org.bomb.duapp.user;

import java.io.Serializable;

public class Node implements Comparable<Node>, Serializable {

    private Long id;

    private String key;

    private String value;

    private Integer sort;

    public Node(Long id, String key, String value, Integer sort) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.sort = sort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.id,o.getId());
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", sort=" + sort +
                '}';
    }
}
