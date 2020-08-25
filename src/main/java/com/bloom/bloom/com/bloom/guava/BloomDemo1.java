package com.bloom.bloom.com.bloom.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.text.NumberFormat;
import java.util.*;

/**
 * 测试布隆过滤器误判率
 *
 * 布隆过滤器中共存在100W条数据,
 * 测试10000条数据校验在布隆过滤器中是否存在(100个实际存在,9900个不存在).
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/8/23
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/8/23              lishanglei      v1.0.0           Created
 */
public class BloomDemo1 {

    private static final int insertions = 1000000;

    public static void main(String[] args) {

        //1.初始化一个存储string数据的布隆过滤器,初始化大小为100W
        //可以在增加一个参数,设置布隆过滤器的误判率
        BloomFilter<String> bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(Charsets.UTF_8), insertions
        );

        //2.用于存放所有实际存在的key,可以去除使用
        List<String> list = new ArrayList<>(insertions);

        //3.用于存放所欲实际存在的key,判断key是否存在
        Set<String> set = new HashSet<>(insertions);

        //4.向三个容器初始化100W个随机并且唯一的字符串
        for (int i = 0; i < insertions; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            list.add(uuid);
            set.add(uuid);
        }

        //判断正确的次数
        int right = 0;
        //判断错误的次数
        int wrong = 0;

        for (int i = 0; i < 10000; i++) {

            //可以被100整除的时候,取一个存在的数(共计100个),否则随机生成一个UUID
            String data = i % 100 == 0 ? list.get((i / 100)) : UUID.randomUUID().toString();

            if (bloomFilter.mightContain(data)) {

                if (set.contains(data)) {
                    //实际存在
                    right++;
                    continue;
                }
                //实际不存在
                wrong++;
            }
        }

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);

        float percent = (float) wrong / 10000;
        float bingo = (float) (10000 - wrong) / 10000;

        System.out.println("在100W个元素中,判断100个实际存在的元素,布隆过滤器认为存在的:" + right);
        System.out.println("在100w个元素中,判断9900个实际不存在的元素,误认为存在的" + wrong
                + ",命中率:" + percentFormat.format(bingo) + ",误判率:" + percentFormat.format(percent));

    }


}
