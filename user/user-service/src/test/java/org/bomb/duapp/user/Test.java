package org.bomb.duapp.user;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import javafx.util.converter.BigDecimalStringConverter;
import org.redisson.Redisson;
import org.redisson.api.RSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Test {

    private static String address = "redis://r-uf65s3orupmfwx7dal.redis.rds.aliyuncs.com:6379";

    private static String password = "HZxVS3jEq3ZNYiJz";

    public RedissonClient getClient() {
        // 1. create config
        Config config = new Config();
        config.useSingleServer().setAddress(address).setPassword(password).setDatabase(0);
        // config = Config.fromYAML(new File("config-file.yaml"))

        // 2. create redisson instance
        RedissonClient redisson = Redisson.create(config);
        // RedissonReactiveClient redissonReactive = Redisson.createReactive(config);
        // RedissonRxClient redissonRx = Redisson.createRx(config);

        return redisson;
    }

    public static void main(String[]args) {
//        RedissonClient redisson = new Test().getClient();
//        RSortedSet<Node> nodeSet = redisson.getSortedSet("bomb.node");
//        nodeSet.trySetComparator(new NodeComparator());
//        nodeSet.add(new Node(1L,"bomb","bomb", 12));
//        nodeSet.add(new Node(2L,"jack","jack", 11));
//        nodeSet.add(new Node(3L,"jenny","jenny", 10));
//        nodeSet.add(new Node(4L,"leta","leta", 9));
//        nodeSet.add(new Node(5L,"leta","leta", 8));
//        nodeSet.add(new Node(6L,"leta","leta", 7));
//        nodeSet.add(new Node(7L,"leta","leta", 6));
//        nodeSet.add(new Node(8L,"leta","leta", 5));
//        nodeSet.add(new Node(9L,"leta","leta", 4));
//        nodeSet.add(new Node(10L,"leta","leta", 3));
//        nodeSet.add(new Node(11L,"leta","leta", 2));
//        nodeSet.add(new Node(12L,"leta","leta", 1));
//
//        LinkedHashSet<Node> set = (LinkedHashSet<Node>) nodeSet.readAll();
//        System.out.println(set.toString());

        /**
         * 结论:
         *  有序集合先根据自定义比较器比较，没有则根据具体类比较器
         * */

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        ids.add(3L);
        ids.add(4L);

        ids = new ArrayList<>(new LinkedHashSet<>(ids));
        System.out.println(Lists.newArrayList(ids.get(0),ids.get(1),ids.get(2),ids.get(3)));

    }

}
